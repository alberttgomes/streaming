package com.streaming.helper;

import com.streaming.executor.NotificationActionExecutor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Albert Gomes Cabral
 */
@Component(service = NoticeUserSchedulerJobHelper.class)
public class NoticeUserSchedulerJobHelper {

    @Reference
    private NotificationActionExecutor _notificationActionExecutor;
    @Reference
    private NotificationHelper _notificationHelper;
}
