package com.ebook.jobs;

import com.ebook.exceptions.EbookSchedulerPortletException;
import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.scheduler.*;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.*;

/**
 * @author Albert Gomes Cabral
 */
@Component(service = EbookSchedulerJobs.class)
public class EbookSchedulerJobs  extends MVCPortlet
        implements SchedulerJobConfiguration {

    @Activate
    public void active(Map<String, String[]> mapValues,
                       Map<String, Object> properties) throws Throwable {

        /**
         * Move this section code to a class more generalized
         *
         * Note
         * This method just should active the notification
         */
        if (properties == null) {
            throw new EbookSchedulerPortletException(
                    "Properties EbookSchedulerJobs is null");
        }
        else {
            String cronExpression = GetterUtil.getString(
                    GetterUtil.getString(properties.get("cron.expression")));

            String originalPreferences = GetterUtil.getString(
                    GetterUtil.getString(properties.get("original-preferences")));

            Object preferencesParams =
                    properties.get("preferences_scheduler_portlet");

            Object portletContextParams =
                     properties.get("portlet_context");

            Map<String, Object> preferences =
                    HashMapBuilder.put(
                           "preferences",
                            preferencesParams
                    ).build();

            Map<String, Object> portletContext =
                    HashMapBuilder.put(
                            "portlet_context",
                            portletContextParams
                    ).build();

            String[] preferencesSplit =
                    originalPreferences.split("\\=");

            List<String> propsList = new ArrayList<>();

            getTriggerConfiguration();

            for (String preference : preferencesSplit) {
                int increment = 0;

                HashMap<String, String> propsPreferences =
                        HashMapBuilder.put(
                                "preference_" + increment++,
                                preference
                        ).build();

                propsList.add(String.valueOf(propsPreferences));

                _log.debug(
                        propsPreferences + "_" + increment);
            }
        }

    };

    @Override
    public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
        return () -> {
            try {
                String listenerClass = EbookSchedulerJobs.class.getName();

                _trigger = _triggerFactory.createTrigger(
                        listenerClass, listenerClass, new Date(),
                        null, 15, TimeUnit.SECOND);

                _schedulerEntryImp = new SchedulerEntryImpl(
                        listenerClass, getTriggerConfiguration());
            }
            catch (RuntimeException runtimeException) {
                throw new RuntimeException(
                        "Unable to execute EbookSchedulerJobs "
                                + runtimeException);
            }
        };
    }

    @Override
    public TriggerConfiguration getTriggerConfiguration() {
        return TriggerConfiguration.createTriggerConfiguration(
                5, TimeUnit.MINUTE);
    }

    public TriggerConfiguration getTriggerConfiguration(String cronExpression) {
        return TriggerConfiguration.createTriggerConfiguration(
                cronExpression);
    }

    private volatile boolean isUnregister = false;

    private static final Log _log = LogFactoryUtil.getLog(EbookSchedulerJobs.class);

    private ServiceRegistration<?>
            _batchEngineTaskItemDelegateServiceRegistration;

    @Reference
    private SchedulerEntryImpl _schedulerEntryImp;

    @Reference
    private SchedulerEngineHelper _schedulerEngineHelper;

    private Trigger _trigger = null;

    @Reference
    private TriggerFactory _triggerFactory;

}