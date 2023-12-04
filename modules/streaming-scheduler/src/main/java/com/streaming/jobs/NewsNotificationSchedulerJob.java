package com.streaming.jobs;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.*;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.util.Validator;
import com.streaming.model.NotificationNewsStreamingModel;
import org.osgi.service.component.annotations.*;

import java.util.*;

/**
 * @author Albert Gomes Cabral
 */
@Component(
        immediate = true,
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        service = SchedulerJobNewsNotification.class
)
public class SchedulerJobNewsNotification implements SchedulerJobConfiguration {
    @Override
    public String getName() {
        return SchedulerJobNewsNotification.class.getName();
    }

    @Override
    public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
        return () -> {
            _log.info("Starting job to send notifications for the users...");
        };
    }

    @Override
    public TriggerConfiguration getTriggerConfiguration() {
        if (Validator.isNotNull(_cronExpression)) {
            return TriggerConfiguration.createTriggerConfiguration(
                    _cronExpression);
        }
        return TriggerConfiguration.createTriggerConfiguration(
                3, TimeUnit.MINUTE);
    }

    private static final String _cronExpression = "0 */2 * ? * *";

    private static final Log _log = LogFactoryUtil.getLog(SchedulerJobNewsNotification.class);

}