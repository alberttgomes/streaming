package com.ebook.impl;

import com.ebook.exceptions.NewsBookNotificationException;
import com.liferay.notification.constants.NotificationQueueEntryConstants;
import com.liferay.notification.context.NotificationContext;
import com.liferay.notification.model.NotificationTemplate;
import com.liferay.notification.rest.dto.v1_0.NotificationQueueEntry;
import com.liferay.notification.type.BaseNotificationType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HashMapBuilder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
@Component(service = NotificationsNewsBookImpl.class)
public class NotificationsNewsBookImpl extends BaseNotificationType {

    public void addNotificationNewsBook(NotificationContext notificationContext, User user)
            throws NewsBookNotificationException, PortalException {

        if (notificationContext == null) {
            throw new NewsBookNotificationException(
                    "NotificationContext is null");
        }

        notificationQueueEntryLocalService
                .addNotificationQueueEntry(notificationContext);

    };

    public void sendNotification(
            ThemeDisplay themeDisplay, NotificationContext notificationContext)
            throws PortalException {

        List<Map<String, String>> notificationRecipientSettings =
                new ArrayList<>();

        NotificationTemplate notificationTemplate =
                notificationContext.getNotificationTemplate();

        User user = themeDisplay.getUser();

        if (user != null && notificationTemplate != null) {

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

            notificationRecipientSettings.add(
                    HashMapBuilder.put(
                            "userFullName", user.getFullName()
                    ).build());
        }

        user = userLocalService.getUser(notificationContext.getUserId());

        siteDefaultLocale = portal.getSiteDefaultLocale(user.getGroupId());
        userLocale = user.getLocale();

        addNotificationNewsBook(notificationContext, user);

        NotificationQueueEntry notificationQueueEntry = new NotificationQueueEntry();

        if (notificationQueueEntry.getStatus() ==
                NotificationQueueEntryConstants.STATUS_SENT) {

            _log.info("Notification submitted with success");
        }

    }


    private static final Log _log =
            LogFactoryUtil.getLog(NotificationsNewsBookImpl.class);

    @Reference
    private UserNotificationEventLocalService _userNotificationEventLocalService;

}
