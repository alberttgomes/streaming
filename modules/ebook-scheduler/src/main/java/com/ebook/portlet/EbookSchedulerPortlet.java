package com.ebook.portlet;

import com.ebook.constants.EbookSchedulerPortletKeys;

import com.ebook.jobs.EbookSchedulerJobs;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.util.HashMapBuilder;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EbookScheduler",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EbookSchedulerPortletKeys.EBOOKSCHEDULER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EbookSchedulerPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		_log.info("Initializing EbookSchedulerPortlet");

		try {
			PortletPreferences preferences = renderRequest.getPreferences();

			Map<String, String[]> mapValues = preferences.getMap();

			HashMap<String, Object> properties =
					HashMapBuilder.put(
							"preferences_scheduler_portlet",
							(Object) renderRequest.getPreferences()
					).put(
							"portlet_context",
							renderRequest.getPortletContext()
					).build();

			EbookSchedulerJobs ebookSchedulerJobs =
					new EbookSchedulerJobs();

			_log.debug("Sending values to active method...");

			ebookSchedulerJobs.active(mapValues, properties);

			renderResponse.setProperty("preferences",
					properties.get("preferences_scheduler_portlet").toString());

		}
		catch (Throwable throwable) {

			_log.error("Unable to execute EbookSchedulerPortlet "
					+ throwable);

			throw new RuntimeException(throwable);
		}

	};

	private static final Log _log =
			LogFactoryUtil.getLog(EbookSchedulerPortlet.class);

}