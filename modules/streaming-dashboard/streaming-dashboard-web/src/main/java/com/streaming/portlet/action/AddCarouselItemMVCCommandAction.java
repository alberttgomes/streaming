package com.streaming.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.streaming.constants.StreamingDashboardPortletKeys;
import com.streaming.service.StreamingDashboardCarouselManagerService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author Albert Gomes Cabral
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StreamingDashboardPortletKeys.STREAMING_DASHBOARD_PORTLET,
                "mvc.command.name=" + "MVCCommandNames.ADD_ASSIGNMENT"
        },
        service = MVCActionCommand.class
)
public class AddCarouselItemMVCCommandAction extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) actionRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);


    }

    @Reference
    private StreamingDashboardCarouselManagerService _carouselItemsDashboardService;
}
