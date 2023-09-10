package com.ebook.helper;

import com.ebook.constants.MessageConstants;
import com.liferay.notification.constants.NotificationConstants;
import com.liferay.notification.context.NotificationContext;
import com.liferay.notification.model.NotificationQueueEntry;
import com.liferay.notification.service.NotificationRecipientLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import static com.liferay.notification.service.NotificationTemplateLocalServiceUtil.createNotificationTemplate;

/**
 * @author Albert Gomes Cabral
 */
public class NotificationObjects {

    public NotificationContext notificationContext
            (ThemeDisplay themeDisplay) throws Throwable {

        User user = themeDisplay.getUser();

        _notificationContext.setNotificationRecipient(
                NotificationRecipientLocalServiceUtil.createNotificationRecipient(
                        RandomTestUtil.randomInt()));
        _notificationContext.setNotificationTemplate(
                createNotificationTemplate(user.getUserId()));
        _notificationContext
                .setClassName(NotificationObjects.class.getName());
        _notificationContext.setNotificationQueueEntry(
                notificationQueueEntry());
        _notificationContext.setType(
                NotificationConstants.TYPE_EMAIL);
        _notificationContext.setType(
                MessageConstants.NEWS_EBOOK_MESSAGE);

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

}
