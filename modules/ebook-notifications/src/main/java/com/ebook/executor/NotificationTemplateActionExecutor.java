package com.ebook.executor;

import com.ebook.exceptions.NewsBookNotificationException;
import com.ebook.module.NotificationNewsEbookModel;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.notification.model.NotificationTemplate;
import com.liferay.notification.service.NotificationTemplateLocalService;
import com.liferay.notification.type.NotificationType;
import com.liferay.notification.type.NotificationTypeServiceTracker;
import com.liferay.portal.kernel.json.JSONObject;
import  com.ebook.constants.NotificationNewsEbookConstants;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
@Component(service = NotificationActionExecutorImpl.class)
public class NotificationTemplateActionExecutor {

    public void execute(
            long companyId, UnicodeProperties parametersUnicodeProperties,
            JSONObject payloadJSONObject, long userId)
        throws Exception {

        NotificationTemplate notificationTemplate =
                _notificationTemplateLocalService.getNotificationTemplate(
                        GetterUtil.getLong(
                                parametersUnicodeProperties.get("notificationTemplateId")));

        NotificationType notificationType =
                _notificationTypeServiceTracker.getNotificationType(
                        notificationTemplate.getType());

        JournalArticle journalArticleModel =
                _journalArticleLocalServiceUtil.getJournalArticle(
                        (payloadJSONObject.getLong("resourcePrimKey")));

        Map<String, Object> currentVariables =
                _getVariables(journalArticleModel, payloadJSONObject);

        Map<String, Object> termValues =
                _getTermValues(journalArticleModel, currentVariables);

    }

    private Map<String, Object> _getTermValues(
            JournalArticle journalArticle, Map<String, Object> variables) {

        Map<String, Object> termValues =
                HashMapBuilder.put(
                    "term_values_key",
                    variables.get("modelBase")
                ).build();

        for (JournalArticle articleField :
                _journalArticleLocalServiceUtil.getArticles(
                        journalArticle.getPrimaryKey())) {

            if (!StringUtil.equals(
                    String.valueOf(articleField.getStatus()),
                    NotificationNewsEbookConstants.STATUS_APPROVED) ||
                    (termValues.get(articleField.getContent()) == null)) {

                return null;
            }

            NotificationNewsEbookModel notificationNewsEbookModel =
                    fetchNotificationNewsEbookModel(
                            (Long) termValues.get(articleField.getResourcePrimKey()));

            if (notificationNewsEbookModel != null) {
                termValues.put(articleField.getTitle(),
                        notificationNewsEbookModel.getClass());
            }
        }

        return termValues;
    }

    private Map<String, Object> _getVariables(
            JournalArticle journalArticle, JSONObject payloadJSONObject) {

        return HashMapBuilder.<String, Object>put(
            "creator",
            () -> {
                if (journalArticle == null) {
                    return null;
                }

                return MapUtil.getString(
                        (Map<String, Object>)
                                payloadJSONObject.get("messageModel"),
                                (String) payloadJSONObject.get("userId"));
            }
        ).put(
            "currentUserId", journalArticle.getUserId()
        ).put(
            "content", journalArticle
        ).build();
    }

    public NotificationNewsEbookModel fetchNotificationNewsEbookModel(
            long notificationNewsEbookId) {

        NotificationNewsEbookModel notificationNewsEbookModel
                = new NotificationNewsEbookModel();

        if (notificationNewsEbookId < 0) {
            throw new NewsBookNotificationException(
                    "notificationNewsEbookId is invalid");
        }

        notificationNewsEbookModel
                .getNotificationNewsEbookId(notificationNewsEbookId);

        return notificationNewsEbookModel;
    }

    public String getKey() {
        return NotificationNewsEbookConstants.KEY_NOTIFICATION;
    }

    @Reference
    private JournalArticleLocalService _journalArticleLocalServiceUtil;

    @Reference
    private NotificationTemplateLocalService _notificationTemplateLocalService;

    @Reference
    private NotificationTypeServiceTracker _notificationTypeServiceTracker;

}