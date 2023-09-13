package com.ebook.jobs;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.*;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

import java.util.*;

/**
 * @author Albert Gomes Cabral
 */
@Component(
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        service = SchedulerJobNewsNotification.class
)
public class SchedulerJobNewsNotification implements SchedulerJobConfiguration {

    @Activate
    public void active() throws Throwable {};

    @Override
    public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
        return () -> {
            try {
                SchedulerEngineHelperUtil.unschedule(_trigger.getJobName(),
                        _trigger.getGroupName(), StorageType.MEMORY_CLUSTERED);
            }
            catch (SchedulerException schedulerException) {
                throw new SchedulerException(
                        "Unable to un scheduler job ",
                        schedulerException);
            }
        };
    }

    @Override
    public TriggerConfiguration getTriggerConfiguration() {
        if (Validator.isNotNull(_cronExpression)) {
            try {
                String listenerClass =
                        SchedulerJobNewsNotification.class.getName();

                _trigger = _triggerFactoryUtil.createTrigger(
                        listenerClass, listenerClass, new Date(),
                        null, _cronExpression,
                        TimeZone.getTimeZone("America/Recife"));

                SchedulerEngineHelperUtil.schedule(
                        _trigger, StorageType.MEMORY_CLUSTERED, listenerClass,
                        DestinationNames.LIVE_USERS, new Message());

                return TriggerConfiguration.
                        createTriggerConfiguration(_cronExpression);
            }
            catch (SchedulerException schedulerException) {
                throw new RuntimeException(schedulerException);
            }
        }

        return TriggerConfiguration.createTriggerConfiguration(
                3, TimeUnit.HOUR);
    }

    private static final String
            _cronExpression = "0 */2 * ? * *";

    private static final Log _log =
            LogFactoryUtil.getLog(SchedulerJobNewsNotification.class);

    private Trigger _trigger;

    @Reference
    private TriggerFactoryUtil _triggerFactoryUtil;

}