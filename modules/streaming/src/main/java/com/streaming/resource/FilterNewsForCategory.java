package com.streaming.resource;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.streaming.constants.StreamingPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Albert Gomes Cabral
 */
@Component(
      property = {
              "javax.portlet.name=" + StreamingPortletKeys.STREAMING,
              "mvc.command.name=saveResourcesMVC"
      },
      service = MVCResourceCommand.class
)
public class FilterNewsForCategory extends BaseMVCResourceCommand {
    @Override
    protected void doServeResource(
            ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws Exception {

        HttpServletRequest httpReq = PortalUtil
                .getOriginalServletRequest(PortalUtil.getHttpServletRequest(
                        (PortletRequest)resourceRequest));

        String category =
                ParamUtil.getString(resourceRequest,"news-category");

    }
}
