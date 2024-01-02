package com.streaming.jobs;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.*;
import org.osgi.service.component.annotations.*;

/**
 * @author Albert Gomes Cabral
 */
@Component(
        immediate = true,
        service = SchedulerJobConfiguration.class
)
public class NoticeUserSchedulerJob implements SchedulerJobConfiguration {
    @Override
    public String getName() {
        return NoticeUserSchedulerJob.class.getName();
    }

    @Override
    public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
        return () -> {
            _log.info("Starting job to send notifications for the users...");
        };
    }

    @Override
    public TriggerConfiguration getTriggerConfiguration() {
        return TriggerConfiguration.createTriggerConfiguration(
                1, TimeUnit.MINUTE);
    }

    private static final Log _log = LogFactoryUtil.getLog(
            NoticeUserSchedulerJob.class);

}