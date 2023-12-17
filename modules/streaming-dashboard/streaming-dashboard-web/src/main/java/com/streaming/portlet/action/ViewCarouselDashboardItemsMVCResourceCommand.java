package com.streaming.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.streaming.constants.StreamingDashboardPortletKeys;
import com.streaming.exception.CarouselDashboardManagerNotFoundException;
import com.streaming.exception.CarouselItemDashboardException;
import com.streaming.model.CarouselItemsDashboard;
import com.streaming.service.StreamingDashboardCarouselManagerService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StreamingDashboardPortletKeys.STREAMING_DASHBOARD_PORTLET,
                "mvc.command.name=" + "MVCCommandNames.ADD_ASSIGNMENT"
        },
        service = BaseMVCResourceCommand.class
)
public class GetStreamingDashboardMVCResourceCommand
        extends BaseMVCResourceCommand {
    @Override
    protected void doServeResource(
            ResourceRequest resourceRequest, ResourceResponse resourceResponse)
                throws Exception {
        ThemeDisplay themeDisplay =
                (ThemeDisplay) resourceRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        long groupId = themeDisplay.getSiteGroupId();

        try {
            List<CarouselItemsDashboard> carouselItemsDashboards =
                    _carouselItemsDashboardService.getCarouselItemsList(groupId);

            resourceRequest.setAttribute("carouselItemsDashboardList",
                    carouselItemsDashboards);
        }
        catch (CarouselDashboardManagerNotFoundException
               | CarouselItemDashboardException exception) {
            if (exception instanceof
                    CarouselDashboardManagerNotFoundException) {
                _log.error("Unable to get dashboard, not found. ", exception);
            }
            else {
                throw new PortletException(exception);
            }
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(
            GetStreamingDashboardMVCResourceCommand.class);

    @Reference
    private StreamingDashboardCarouselManagerService
            _carouselItemsDashboardService;
}
