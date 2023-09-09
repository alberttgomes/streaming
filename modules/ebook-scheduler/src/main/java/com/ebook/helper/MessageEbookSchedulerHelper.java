package com.ebook.helper;

import com.liferay.portal.kernel.pop.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Albert Gomes Cabral
 */
@Component(
        configurationPid = "",
        enabled = false,
        service = MessageEbookSchedulerHelper.class
)
public class MessageEbookSchedulerHelper {

    public void registerMessageListener() throws MessageListenerException {};

    @Reference
    private SchedulerEngineHelper _schedulerEngineHelper;
}