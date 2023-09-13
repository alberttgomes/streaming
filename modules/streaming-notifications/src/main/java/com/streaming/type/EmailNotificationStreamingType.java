package com.streaming.type;

import com.streaming.exceptions.NotificationMessageException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.notification.constants.NotificationConstants;
import com.liferay.notification.constants.NotificationPortletKeys;
import com.liferay.notification.constants.NotificationQueueEntryConstants;
import com.liferay.notification.context.NotificationContext;
import com.liferay.notification.model.NotificationTemplate;
import com.liferay.notification.model.NotificationTemplateAttachment;
import com.liferay.notification.rest.dto.v1_0.NotificationQueueEntry;
import com.liferay.notification.service.NotificationTemplateAttachmentLocalService;
import com.liferay.notification.type.BaseNotificationType;
import com.liferay.notification.type.NotificationType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepository;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.util.MapUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.*;


/**
 * @author Albert Gomes Cabral
 */
@Component(service = EmailNotificationStreamingType.class)
public class EmailNotificationStreamingType
        extends BaseNotificationType implements NotificationType {

    public void addNotificationNewsBook(NotificationContext notificationContext)
            throws NotificationMessageException, PortalException {
        if (notificationContext == null) {
            throw new NotificationMessageException(
                    "NotificationContext parameter is null");
        }

        notificationQueueEntryLocalService
                .addNotificationQueueEntry(notificationContext);
    };

    @Override
    public void sendNotification(
            NotificationContext notificationContext) throws PortalException {

        long groupId = 0;

        User user = userLocalService
                .getUser(notificationContext.getUserId());

        Group userGroup = user.getGroup();

        if (userGroup != null) {
            groupId = userGroup.getGroupId();
        }

        siteDefaultLocale = portal.getSiteDefaultLocale(groupId);

        userLocale = user.getLocale();

        notificationContext.setFileEntryIds(
                _getFileEntryIds(user.getCompanyId(), notificationContext));

        NotificationTemplate notificationTemplate =
                notificationContext.getNotificationTemplate();

        if (notificationTemplate != null) {

            siteDefaultLocale = portal.getSiteDefaultLocale(user.getGroupId());
            userLocale = user.getLocale();

            _userNotificationEventLocalService.sendUserNotificationEvents(
                    user.getUserId(), notificationContext.getPortletId(),
                    UserNotificationDeliveryConstants.TYPE_WEBSITE,
                    JSONUtil.put(
                            "className", notificationContext.getClassName()
                    ).put(
                            "classPK", notificationContext.getClassPK()
                    ).put(
                            "externalReferenceCode",
                            notificationContext.getExternalReferenceCode()
                    ).put(
                            "notificationMessage",
                            formatLocalizedContent(
                                    notificationTemplate.getSubjectMap(),
                                    notificationContext)
                    ).put(
                            "portletId", notificationContext.getPortletId()
                    ));
        }

        NotificationQueueEntry notificationQueueEntry
                = new NotificationQueueEntry();

        if (notificationQueueEntry.getStatus() ==
                NotificationQueueEntryConstants.STATUS_SENT) {

            _log.info("Notification submitted with success");
        }

    }

    public void deleteNotification() throws PortalException {
        List<com.liferay.notification.model.NotificationQueueEntry>
                notificationQueueEntries = notificationQueueEntryLocalService
                    .getNotificationEntries(NotificationConstants.TYPE_EMAIL,
                        NotificationQueueEntryConstants.STATUS_SENT);

        notificationQueueEntryLocalService.deleteNotificationQueueEntry(
                notificationQueueEntries.get(0));

        if (notificationQueueEntries.size() > 0) {
            throw new PortalException(
                    "Notification wasn't deleted");
        }
    }

    private List<Long> _getFileEntryIds(
            long companyId, NotificationContext notificationContext)
            throws PortalException {

        Group group = _groupLocalService.getCompanyGroup(companyId);

        Repository repository = _getRepository(group.getGroupId());

        if (repository == null) {
            return new ArrayList<>();
        }

        List<Long> fileEntryIds = new ArrayList<>();

        NotificationTemplate notificationTemplate =
                notificationContext.getNotificationTemplate();

        for (NotificationTemplateAttachment notificationTemplateAttachment :
                _notificationTemplateAttachmentLocalService.
                        getNotificationTemplateAttachments(
                                notificationTemplate.getNotificationTemplateId())) {

            JournalArticle journalArticle = _journalArticleLocalService.fetchJournalArticle(
                    notificationTemplateAttachment.getObjectFieldId());

            DLFileEntry dlFileEntry = _dlFileEntryLocalService.fetchDLFileEntry(
                    MapUtil.getLong(
                            notificationContext.getTermValues(),
                            String.valueOf(journalArticle.getGroupId())));

            if (dlFileEntry == null) {
                continue;
            }

            FileEntry fileEntry = _portletFileRepository.addPortletFileEntry(
                    null, repository.getGroupId(),
                    userLocalService.getGuestUserId(companyId),
                    NotificationTemplate.class.getName(), 0,
                    NotificationPortletKeys.NOTIFICATION_TEMPLATES,
                    repository.getDlFolderId(), dlFileEntry.getContentStream(),
                    _portletFileRepository.getUniqueFileName(
                            group.getGroupId(), repository.getDlFolderId(),
                            dlFileEntry.getFileName()),
                    dlFileEntry.getMimeType(), false);

            fileEntryIds.add(fileEntry.getFileEntryId());
        }

        return fileEntryIds;
    }

    private Repository _getRepository(long groupId) {
        Repository repository = _portletFileRepository.fetchPortletRepository(
                groupId, NotificationPortletKeys.NOTIFICATION_TEMPLATES);

        if (repository != null) {
            return repository;
        }

        try {
            return _portletFileRepository.addPortletRepository(
                    groupId, NotificationPortletKeys.NOTIFICATION_TEMPLATES,
                    new ServiceContext());
        }
        catch (PortalException portalException) {
            if (_log.isDebugEnabled()) {
                _log.debug(portalException);
            }

            return null;
        }
    }

    private static final Log _log =
            LogFactoryUtil.getLog(EmailNotificationStreamingType.class);

    @Reference
    private DLFileEntryLocalService _dlFileEntryLocalService;

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private JournalArticleLocalService _journalArticleLocalService;

    @Reference
    private NotificationTemplateAttachmentLocalService
            _notificationTemplateAttachmentLocalService;

    @Reference
    private PortletFileRepository _portletFileRepository;

    @Reference
    private UserNotificationEventLocalService
            _userNotificationEventLocalService;

}