package com.streaming.executor;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.streaming.exceptions.NotificationMessageException;
import com.streaming.model.NotificationNewsStreamingModel;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.notification.context.NotificationContextBuilder;
import com.liferay.notification.model.NotificationTemplate;
import com.liferay.notification.service.NotificationTemplateLocalService;
import com.liferay.notification.type.NotificationType;
import com.liferay.notification.type.NotificationTypeServiceTracker;
import com.liferay.portal.kernel.json.JSONObject;
import com.streaming.constants.NotificationStatusAndTypesConstants;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.streaming.portlet.NotificationEbookPortlet;
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
            throws Exception, NotificationMessageException {

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
                        NotificationNewsStreamingModel.class.getName()
                ).build());

    }

    private Map<String, Object> _getTermValues(
            JournalArticle journalArticle, Map<String, Object> variables)
            throws NotificationMessageException {

        Map<String, Object> termValues =
                HashMapBuilder.put(
                    "term_variables_key",
                    variables.get("messageContent")
                ).build();

        for (JournalArticle articleField :
                _journalArticleLocalServiceUtil.getArticles(
                        journalArticle.getPrimaryKey())) {

            if (articleField.getStatus() !=
                    WorkflowConstants.STATUS_APPROVED ||
                    (termValues.get(articleField.getContent()) == null)) {

                return null;
            }

            NotificationNewsStreamingModel notificationNewsStreamingModel =
                    _fetchNotificationNewsEbookModel(
                            articleField.getResourcePrimKey());

            if (notificationNewsStreamingModel.getStatusNotification()
                    .equals(NotificationStatusAndTypesConstants.STATUS_APPROVED)) {
                termValues.put(articleField.getTitle(),
                        notificationNewsStreamingModel.getClass());
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

    private NotificationNewsStreamingModel _fetchNotificationNewsEbookModel(
            long notificationNewsEbookId) throws NotificationMessageException {

        if (notificationNewsEbookId < 0) {
            if(_log.isWarnEnabled()) {
                _log.warn(
                        "notificationNewsEbookId is invalid");
            }
            else {
                throw new NotificationMessageException(
                        "notificationNewsEbookId is invalid");
            }

            return null;
        }

        NotificationNewsStreamingModel notificationNewsStreamingModel
                = new NotificationNewsStreamingModel();

        notificationNewsStreamingModel
                .getNotificationNewsStreamingId(notificationNewsEbookId);

        return notificationNewsStreamingModel;
    }

    @Override
    public String getKey() {
        return NotificationStatusAndTypesConstants.KEY_NOTIFICATION;
    }

    private static final Log _log =
            LogFactoryUtil.getLog(NotificationTemplateActionExecutor.class);

    @Reference
    private JournalArticleLocalService _journalArticleLocalServiceUtil;

    @Reference
    private NotificationTemplateLocalService _notificationTemplateLocalService;

    @Reference
    private NotificationTypeServiceTracker _notificationTypeServiceTracker;

}