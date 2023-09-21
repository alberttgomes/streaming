package com.streaming.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Albert Gomes Cabral
 */
@ProviderType
public interface StreamingService {

    public Object getPortletContent() throws JsonProcessingException;

}