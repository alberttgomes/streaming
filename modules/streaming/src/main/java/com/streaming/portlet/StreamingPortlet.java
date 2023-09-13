package com.streaming.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.streaming.constants.StreamingPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.streaming.helper.StreamingPortletHelper;
import com.streaming.model.CategoriesModel;
import com.streaming.model.PreferencesPortletModel;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Streaming",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + StreamingPortletKeys.STREAMING,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StreamingPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay)
				renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long companyId = themeDisplay.getCompanyId();

		long groupId = themeDisplay.getSiteGroupId();

		Group group = themeDisplay.getSiteGroup();

		Contact contact = themeDisplay.getContact();

		String externalReferenceCode =
				group.getExternalReferenceCode();

		long mvccVersion = group.getMvccVersion();

		StreamingPortletHelper streamingPortletHelper =
				new StreamingPortletHelper();

		try {

			PreferencesPortletModel notificationNewsStreamingModel =
					streamingPortletHelper.loadPreferencesModel(
							companyId, groupId, mvccVersion, contact.getUserId(),
							externalReferenceCode, renderRequest);

			List<CategoriesModel> categoriesModel = streamingPortletHelper.getCategories(
					notificationNewsStreamingModel.getVocabularyCategories());

			_log.info("Load category "
					+ categoriesModel.get(0).getCategoryName() + " completed");
		}
		catch (RuntimeException portletException) {
			throw new PortletException(portletException);
		}
		finally {
			renderRequest.setAttribute("news", null);

			super.doView(renderRequest, renderResponse);

			_log.info("Module " +
					StreamingPortlet.class.getName() + " initialized");
		}

	}

	private static final Log _log =
			LogFactoryUtil.getLog(StreamingPortlet.class);

}