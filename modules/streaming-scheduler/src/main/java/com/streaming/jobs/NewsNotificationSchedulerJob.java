package com.streaming.jobs;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.*;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.*;

/**
 * @author Albert Gomes Cabral
 */
@Component(
        immediate = true,
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        service = NewsNotificationSchedulerJob.class
)
public class NewsNotificationSchedulerJob implements SchedulerJobConfiguration {
    @Override
    public String getName() {
        return NewsNotificationSchedulerJob.class.getName();
    }

    @Override
    public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
        return () -> {
            _log.info("Starting job to send notifications for the users...");
        };
    }

    @Override
    public TriggerConfiguration getTriggerConfiguration() {
        if (Validator.isNotNull(_DEFAULT_CRON_EXPRESSION)) {
            return TriggerConfiguration.createTriggerConfiguration(
                    _DEFAULT_CRON_EXPRESSION);
        }
        return TriggerConfiguration.createTriggerConfiguration(
                5, TimeUnit.MINUTE);
    }

    private static final String _DEFAULT_CRON_EXPRESSION = "0 */2 * ? * *";

    private static final Log _log = LogFactoryUtil.getLog(
            NewsNotificationSchedulerJob.class);

}