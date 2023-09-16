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

    @Activate
    public void active(Map<String, Object> properties) throws Throwable {};

    @Deactivate
    public void deactivate() throws Throwable {
        try {
            SchedulerEngineHelperUtil.unschedule(_trigger.getJobName(),
                    _trigger.getGroupName(), StorageType.MEMORY_CLUSTERED);
        }
        catch (SchedulerException schedulerException) {
            throw new SchedulerException(
                    "Unable to un scheduler job ",
                    schedulerException);
        }
    }

    @Override
    public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
        return () -> {
            NotificationNewsStreamingModel notificationNewsStreamingModel =
                    new NotificationNewsStreamingModel();

            long newsId = notificationNewsStreamingModel.getNewsId();

            if (newsId < 0) {
                throw new Exception(
                        "NotificationNewsStreamingModel's " +
                                "newsId is invalid");
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
                3, TimeUnit.MINUTE);
    }

    private static final String
            _cronExpression = "0 */2 * ? * *";

    private static final Log _log =
            LogFactoryUtil.getLog(SchedulerJobNewsNotification.class);

    private Trigger _trigger;

    @Reference
    private TriggerFactoryUtil _triggerFactoryUtil;

}