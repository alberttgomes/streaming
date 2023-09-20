package com.streaming.service.impl;

import com.streaming.portlet.StreamingPortlet;
import com.streaming.service.StreamingService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Albert Gomes Cabral
 */
@Component(service = StreamingService.class)
public class StreamingServiceImpl implements StreamingService {

    @Override
    public Object getPortletContent() {
        return _streamingPortlet.getCarouselDataPortlet();
    }

    @Reference
    private StreamingPortlet _streamingPortlet;

}