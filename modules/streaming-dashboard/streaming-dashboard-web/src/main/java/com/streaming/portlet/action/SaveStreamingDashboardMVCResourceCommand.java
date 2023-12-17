package com.streaming.portlet.action;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.streaming.constants.StreamingDashboardPortletKeys;
import com.streaming.helper.DashboardItemsHelp;
import com.streaming.model.CarouselItemsDashboard;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StreamingDashboardPortletKeys.STREAMING_DASHBOARD_PORTLET,
                "mvc.command.name=save-dashboard"
        },
        service = MVCResourceCommand.class
)
public class SaveStreamingDashboardMVCResourceCommand extends BaseMVCResourceCommand {
    @Override
    protected void doServeResource(
            ResourceRequest resourceRequest, ResourceResponse resourceResponse)
                throws Exception {

        CarouselItemsDashboard carouselItemsDashboard =
                _dashboardItemsHelp.saveDashboardItemsHelp(resourceRequest);

        _log.info(StringBundler.concat(
                "Active the ", carouselItemsDashboard.getCategory(),
                StringPool.SPACE, "category."));

    }

    private static final Log _log = LogFactoryUtil.getLog(
            SaveStreamingDashboardMVCResourceCommand.class);

    @Reference
    private DashboardItemsHelp _dashboardItemsHelp;
}
