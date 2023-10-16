package com.streaming.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.streaming.service.StreamingService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.time.Instant;

@Component(
        property = {
                "osgi.command.function=launch",
                "osgi.command.scope=streaming"
        },
        service = StreamingPortletMVCCommand.class
)
public class StreamingPortletMVCCommand {

    @Activate
    public void activePortletMVCommand()
            throws JsonProcessingException {

        Instant instant = Instant.now();

        _log.info(
                instant + "\\s" +
                _streamingService.getPortletContent());
    }

    private static final Log _log =
            LogFactoryUtil.getLog(StreamingPortletMVCCommand.class);

    @Reference
    private StreamingService _streamingService;

}