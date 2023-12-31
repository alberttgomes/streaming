package com.streaming.helper;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.messaging.Message;
import com.streaming.constants.MessageConstants;
import com.streaming.constants.NotificationConstants;
import com.streaming.constants.NotificationsEbookPortletKeys;
import com.streaming.exceptions.NotificationMessageException;
import com.streaming.portlet.NotificationEbookPortlet;
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
public class NotificationHelper {

    public NotificationContext notificationContextHelper(
            List<Long> attachmentObjectFieldIds, long classPK,
            List<Long> fileEntryIds, String externalReferenceCode,
            Map<String, Object> termValues, ThemeDisplay themeDisplay) {

        _notificationContext.setClassPK(classPK);
        _notificationContext.setFileEntryIds(fileEntryIds);
        _notificationContext.setClassName(
                        NotificationEbookPortlet.class.getName());
        _notificationContext.setExternalReferenceCode(
                externalReferenceCode);
        _notificationContext.setNotificationQueueEntry(
                _notificationQueueEntry);
        _notificationContext.setUserId(themeDisplay.getUserId());
        _notificationContext.setAttachmentObjectFieldIds(
                attachmentObjectFieldIds);
        _notificationContext.setNotificationRecipientSettings(
                        _notificationRecipientSettingsList);
        _notificationContext.setPortletId(
                        NotificationsEbookPortletKeys.NOTIFICATIONSEBOOK);
        _notificationContext.setNotificationRecipient(
                _notificationRecipient);
        _notificationContext.setNotificationTemplate(
                _notificationTemplate);
        _notificationContext.setTermValues(termValues);
        _notificationContext.setType(com.liferay.notification.constants.NotificationConstants.TYPE_EMAIL);
        _notificationContext.setType(
                MessageConstants.NEWS_STREAMING_MESSAGE);

        return _notificationContext;
    }

    public NotificationQueueEntry notificationQueueEntryHelper(
            String body, long notificationQueueEntryId,
            String className, long classPK, String type,
            long companyId, Date createDate,
            Map<String, Object> attributes, long mvccVersion,
            long primaryKey, boolean newEntry, Date sentDate) {

        _notificationQueueEntry.setBody(body);
        _notificationQueueEntry.setClassName(className);
        _notificationQueueEntry.setNotificationQueueEntryId(
                        notificationQueueEntryId);
        _notificationQueueEntry.setClassPK(classPK);
        _notificationQueueEntry.setType(type);
        _notificationQueueEntry.setCompanyId(companyId);
        _notificationQueueEntry.setCreateDate(createDate);
        _notificationQueueEntry.setModelAttributes(attributes);
        _notificationQueueEntry.setMvccVersion(mvccVersion);
        _notificationQueueEntry.setPrimaryKey(primaryKey);
        _notificationQueueEntry.setNew(newEntry);
        _notificationQueueEntry.setSentDate(sentDate);

        return _notificationQueueEntry;
    }

    public void registerMessageListener(Message message)
            throws NotificationMessageException {

        JSONObject jsonObject = (JSONObject)message.getPayload();

        long notificationId = jsonObject.getLong(
                "notification_model_news_id");

        List<String> messageList = (List<String>)
                jsonObject.get("notification_model_news_messages");

        String notificationStatus = jsonObject.getString(
                "notification_model_news_status");

        if (!notificationStatus.equals
                (NotificationConstants.STATUS_APPROVED)) {
            return;
        }

        message.put("notification_id", notificationId);
        message.put("notification_message", messageList);
        message.put("notification_status", notificationStatus);
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
