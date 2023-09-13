package com.streaming.helper;

//import com.streaming.constants.NotificationStatus;
//import com.streaming.exceptions.NotificationMessageException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.messaging.Message;
import com.streaming.model.PreferencesPortletModel;

import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
public class StreamingPortletHelper {

    public PreferencesPortletModel loadNotificationNewsModel(
            long companyId, long groupId, String categoryName,
            long userId, String externalReferenceCode, Object preferences)
            throws RuntimeException {

        PreferencesPortletModel preferencesPortletModel =
                new PreferencesPortletModel();

        preferencesPortletModel.setCompanyId(companyId);
        preferencesPortletModel.setCategoryName(categoryName);
        preferencesPortletModel.setExternalReferenceCode(externalReferenceCode);
        preferencesPortletModel.setGroupId(groupId);
        preferencesPortletModel.setUserId(userId);
        preferencesPortletModel.setPreferences(preferences);

        return preferencesPortletModel;
    }

//    public void registerMessageListener(Message message)
//            throws NotificationMessageException {
//
//        JSONObject jsonObject = (JSONObject)message.getPayload();
//
//        long notificationId = jsonObject.getLong(
//                "notification_model_news_id");
//
//        List<String> messageList = (List<String>)
//                jsonObject.get("notification_model_news_messages");
//
//        String notificationStatus = jsonObject.getString(
//                "notification_model_news_status");
//
//        if (!notificationStatus.equals
//                (NotificationStatus.STATUS_APPROVED)) {
//            return;
//        }
//
//        message.put("notification_id", notificationId);
//        message.put("notification_message", messageList);
//        message.put("notification_status", notificationStatus);
//    }

}
