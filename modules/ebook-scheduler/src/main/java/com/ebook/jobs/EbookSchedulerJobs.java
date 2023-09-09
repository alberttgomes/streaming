package com.ebook.jobs;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.scheduler.*;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

/**
 * @author Albert Gomes Cabral
 */
@Component(
        immediate = true,
        service = EbookSchedulerJobs.class
)
public class EbookSchedulerJobs implements SchedulerJobConfiguration {

    @Activate
    public void active() throws Throwable {

    };

    @Override
    public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
        return () -> {};
    }

    @Override
    public TriggerConfiguration getTriggerConfiguration() {
        return TriggerConfiguration.createTriggerConfiguration(
                _cronExpressionDefault);
    }

    private volatile boolean isUnregister = false;

    private String _cronExpressionDefault = TimeUnit.MINUTE.toString();

    private static final Log _log = LogFactoryUtil.getLog(EbookSchedulerJobs.class);

    private ServiceRegistration<?>
            _batchEngineTaskItemDelegateServiceRegistration;

    @Reference
    private SchedulerEntryImpl _schedulerEntryImp;

    private SchedulerEngineHelper _schedulerEngineHelper;

    private Trigger _trigger = null;

    @Reference
    private TriggerFactory _triggerFactory;

}