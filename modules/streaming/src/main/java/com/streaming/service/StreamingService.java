package com.streaming.service;

import com.liferay.notification.context.NotificationContext;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.streaming.model.CarouselContentModel;
import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Albert Gomes Cabral
 */
@ProviderType
public interface StreamingService {

    public CarouselContentModel getCarouselContentModel();

    public void sendMessageNotification(
            long companyId, JSONObject payload, UnicodeProperties unicodeProperties,
            NotificationContext notificationContext, long userId);

    public boolean isEnableRuleToSendNotification(JSONObject payload);

    public void activeSchedulerJobSendNotification();
}