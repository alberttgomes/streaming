package com.streaming.command;

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
    public void activePortletMVCommand() {
        Instant instant = Instant.now();

        System.out.println(
                instant + "\\s" +
                _streamingService.getPortletContent());
    }

    @Reference
    private StreamingService _streamingService;

}