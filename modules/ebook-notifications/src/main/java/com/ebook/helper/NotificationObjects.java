package com.ebook.helper;

import com.liferay.notification.constants.NotificationConstants;
import com.liferay.notification.context.NotificationContext;
import com.liferay.notification.model.NotificationQueueEntry;
import com.liferay.notification.model.NotificationRecipient;
import com.liferay.notification.model.NotificationTemplate;

/**
 * @author Albert Gomes Cabral
 */
public class NotificationObjects {
    public NotificationContext notificationContext() {
        _notificationContext
                .setNotificationRecipient(_notificationRecipient);
        _notificationContext
                .setNotificationTemplate(_notificationTemplate);
        _notificationContext
                .setClassName(NotificationObjects.class.getName());
        _notificationContext
                .setNotificationQueueEntry(notificationQueueEntry());
        _notificationContext.setType(
                NotificationConstants.TYPE_EMAIL);

        return _notificationContext;
    }

    private NotificationQueueEntry notificationQueueEntry() {
        _notificationQueueEntry
                .setBody(null);
        _notificationQueueEntry
                .setClassName(NotificationObjects.class.getName());
        _notificationQueueEntry
                .setNotificationQueueEntryId(0);
        _notificationQueueEntry.setClassPK(1);

        return _notificationQueueEntry;
    }

    private static NotificationContext
            _notificationContext = new NotificationContext();

    private NotificationQueueEntry _notificationQueueEntry;

    private NotificationRecipient _notificationRecipient;

    private NotificationTemplate _notificationTemplate;
}
