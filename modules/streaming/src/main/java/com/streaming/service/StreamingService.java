package com.streaming.service;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Albert Gomes Cabral
 */
@ProviderType
public interface StreamingService {

    public Object getPortletContent();

}