package com.streaming.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.streaming.exceptions.StreamingException;
import com.streaming.model.ContentModel;
import com.streaming.model.PreferencesPortletModel;
import org.osgi.annotation.versioning.ProviderType;

import java.io.IOException;
import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
@ProviderType
@Transactional
public interface StreamingService {
    public Object getPortletContent()
            throws JsonProcessingException, StreamingException;

    public void processCarouselContentView(
            List<ContentModel> contentModels)
            throws IOException, StreamingException, StreamingException;

    public PreferencesPortletModel preferencesPortlet(
            long companyId, String externalReferenceCode, long preferenceId)
                throws StreamingException;
}