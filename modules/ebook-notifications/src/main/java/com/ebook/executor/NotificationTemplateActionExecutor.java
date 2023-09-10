package com.ebook.executor;

import com.ebook.exceptions.NewsBookNotificationException;
import com.ebook.module.NotificationNewsEbookModel;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.notification.context.NotificationContextBuilder;
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
@Component(service = NotificationTemplateActionExecutor.class)
public class NotificationTemplateActionExecutor implements NotificationActionExecutor {

    @Override
    public void execute(
            long companyId, UnicodeProperties parametersUnicodeProperties,
            JSONObject payloadJSONObject, long userId)
            throws Exception, NewsBookNotificationException {

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

        notificationType.sendNotification(
                new NotificationContextBuilder(
                ).className(
                        journalArticleModel.getClassName()
                ).classPK(
                        GetterUtil.getLong(termValues.get("id"))
                ).externalReferenceCode(
                        GetterUtil.getString(termValues.get("externalReferenceCode"))
                ).notificationTemplate(
                        notificationTemplate
                ).termValues(
                        termValues
                ).userId(
                        userId
                ).portletId(
                        String.valueOf(journalArticleModel.getResourcePrimKey())
                ).build());

    }

    private Map<String, Object> _getTermValues(
            JournalArticle journalArticle, Map<String, Object> variables)
            throws NewsBookNotificationException {

        Map<String, Object> termValues =
                HashMapBuilder.put(
                    "term_variables_key",
                    variables.get("messageContent")
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
                            articleField.getResourcePrimKey());

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
                "modelMessage",
                () -> {
                    if (payloadJSONObject == null) {
                        return null;
                    }

                    return MapUtil.getString(
                            (Map<String, ?>)
                                    payloadJSONObject.get("messageModel"),
                                    (String) payloadJSONObject.get("sender"));
                }
        ).put(
                "articleId", journalArticle.getPrimaryKey()
        ).put(
                "currentUserId", payloadJSONObject.get("userId")
        ).put(
                "content", journalArticle
        ).put(
                "message", payloadJSONObject.get("message")
        ).put(
                "userName", payloadJSONObject.get("username")
        ).build();
    }

    public NotificationNewsEbookModel fetchNotificationNewsEbookModel(
            long notificationNewsEbookId) throws NewsBookNotificationException {

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

    @Override
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