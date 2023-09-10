package com.ebook.executor;

import com.ebook.exceptions.NewsBookNotificationException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * @author Albert Gomes Cabral
 */
public interface NotificationActionExecutor {
    void execute(
            long companyId, UnicodeProperties parametersUnicodeProperties,
            JSONObject payloadJSONObject, long userId)
            throws Exception, NewsBookNotificationException;

    public String getKey();
}
