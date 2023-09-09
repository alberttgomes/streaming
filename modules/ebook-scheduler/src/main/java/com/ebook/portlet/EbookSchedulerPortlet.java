package com.ebook.portlet;

import com.ebook.constants.EbookSchedulerPortletKeys;

import com.ebook.jobs.EbookSchedulerJobs;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;

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
			_ebookSchedulerJobs.active();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}

	};

	private static final Log _log = LogFactoryUtil.getLog(EbookSchedulerPortlet.class);

	private EbookSchedulerJobs _ebookSchedulerJobs = new EbookSchedulerJobs();

}