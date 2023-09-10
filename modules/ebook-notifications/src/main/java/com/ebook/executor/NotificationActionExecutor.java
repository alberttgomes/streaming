package com.ebook.executor;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * @author Albert Gomes Cabral
 */
public interface NotificationActionExecutor {
    public void executor(
            long companyId, UnicodeProperties parametersUnicodeProperties,
            JSONObject payloadJSONObject, long userId);

    public String getKey();
}
