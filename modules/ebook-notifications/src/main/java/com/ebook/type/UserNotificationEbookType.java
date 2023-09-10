package com.ebook.type;

import com.liferay.notification.context.NotificationContext;
import com.liferay.notification.model.NotificationTemplate;
import com.liferay.notification.type.BaseNotificationType;
import com.liferay.notification.type.NotificationType;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.util.HashMapBuilder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Albert Gomes
 */
@Component(service = NotificationEbookUserType.class)
public class NotificationEbookUserType
        extends BaseNotificationType implements NotificationType {

    @Override
    public void sendNotification(NotificationContext notificationContext)
            throws PortalException {

        List<Map<String, String>> notificationRecipientSettings =
                new ArrayList<>();

        NotificationTemplate notificationTemplate =
                notificationContext.getNotificationTemplate();

        User usersProvider = userLocalService
                .getUser(notificationContext.getUserId());

        siteDefaultLocale = portal.getSiteDefaultLocale(usersProvider.getGroupId());
        userLocale = usersProvider.getLocale();

        _userNotificationEventLocalService.sendUserNotificationEvents(
                usersProvider.getUserId(), notificationContext.getPortletId(),
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
                        "userFullName", usersProvider.getFullName()
                ).build());


        prepareNotificationContext(
                usersProvider, null, notificationContext, notificationRecipientSettings,
                formatLocalizedContent(
                        notificationTemplate.getSubjectMap(), notificationContext));

        notificationQueueEntryLocalService.addNotificationQueueEntry(
                notificationContext);
    }

    private ServiceTrackerMap<String, User> _serviceTrackerMap;

    @Reference
    private UserNotificationEventLocalService
            _userNotificationEventLocalService;
}
