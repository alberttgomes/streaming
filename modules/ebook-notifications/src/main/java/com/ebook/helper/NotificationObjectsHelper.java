package com.ebook.helper;

import com.ebook.constants.MessageConstants;
import com.ebook.constants.NotificationsEbookPortletKeys;
import com.ebook.portlet.NotificationEbookPortlet;
import com.liferay.notification.constants.NotificationConstants;
import com.liferay.notification.context.NotificationContext;
import com.liferay.notification.model.NotificationQueueEntry;
import com.liferay.notification.model.NotificationRecipient;
import com.liferay.notification.model.NotificationRecipientSetting;
import com.liferay.notification.model.NotificationTemplate;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author Albert Gomes Cabral
 */
public class NotificationObjectsHelper {

    public NotificationContext notificationContext(
            ThemeDisplay themeDisplay, long classPK,
            List<Long> fileEntryIds, String externalReferenceCode,
            Map<String, Object> termValues, List<Long> attachmentObjectFieldIds) {

        _notificationContext
                .setClassPK(classPK);
        _notificationContext
                .setFileEntryIds(fileEntryIds);
        _notificationContext
                .setClassName(
                        NotificationEbookPortlet.class.getName());
        _notificationContext
                .setExternalReferenceCode(externalReferenceCode);
        _notificationContext
                .setNotificationQueueEntry(_notificationQueueEntry);
        _notificationContext
                .setUserId(themeDisplay.getUserId());
        _notificationContext
                .setAttachmentObjectFieldIds(attachmentObjectFieldIds);
        _notificationContext
                .setNotificationRecipientSettings(
                        _notificationRecipientSettingsList);
        _notificationContext
                .setPortletId(
                        NotificationsEbookPortletKeys
                                .NOTIFICATIONSEBOOK);
        _notificationContext
                .setNotificationRecipient(_notificationRecipient);
        _notificationContext
                .setNotificationTemplate(_notificationTemplate);
        _notificationContext
                .setTermValues(termValues);
        _notificationContext
                .setType(NotificationConstants.TYPE_EMAIL);
        _notificationContext
                .setType(MessageConstants.NEWS_EBOOK_MESSAGE);

        return _notificationContext;
    }

    private NotificationQueueEntry notificationQueueEntry(
            String body, long notificationQueueEntryId,
            String className, long classPK, String type,
            long companyId, Date createDate,
            Map<String, Object> attributes, long mvccVersion,
            long primaryKey, boolean newEntry, Date sentDate) {

        _notificationQueueEntry
                .setBody(body);
        _notificationQueueEntry
                .setClassName(className);
        _notificationQueueEntry
                .setNotificationQueueEntryId(
                        notificationQueueEntryId);
        _notificationQueueEntry
                .setClassPK(classPK);
        _notificationQueueEntry
                .setType(type);
        _notificationQueueEntry
                .setCompanyId(companyId);
        _notificationQueueEntry
                .setCreateDate(createDate);
        _notificationQueueEntry
                .setModelAttributes(attributes);
        _notificationQueueEntry
                .setMvccVersion(mvccVersion);
        _notificationQueueEntry
                .setPrimaryKey(primaryKey);
        _notificationQueueEntry
                .setNew(newEntry);
        _notificationQueueEntry
                .setSentDate(sentDate);


        return _notificationQueueEntry;
    }


    private static final NotificationContext
            _notificationContext = new NotificationContext();

    @Reference
    private NotificationTemplate _notificationTemplate;

    @Reference
    private NotificationRecipient _notificationRecipient;

    @Reference
    private List<NotificationRecipientSetting>
            _notificationRecipientSettingsList;

    @Reference
    private NotificationQueueEntry _notificationQueueEntry;

}
