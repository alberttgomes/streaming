package com.streaming.portlet;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.streaming.constants.StreamingPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.streaming.helper.StreamingPortletHelper;
import com.streaming.model.CarouselContentModel;
import com.streaming.model.CategoriesModel;
import com.streaming.model.PreferencesPortletModel;
import org.osgi.service.component.annotations.Component;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


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

		CarouselContentModel carouselContentModel =
				new CarouselContentModel();

		Map<String, String> carouselPutJSP =
				new LinkedHashMap<String, String>();

		try {
			PreferencesPortletModel preferencesPortletModel =
					streamingPortletHelper.loadPreferencesModel(
							companyId, groupId, mvccVersion, contact.getUserId(),
							externalReferenceCode, renderRequest);

			List<CategoriesModel> categoriesModel = streamingPortletHelper.getCategories(
					preferencesPortletModel.getVocabularyCategories());

			if (categoriesModel == null) {
				_log.error(
						"category model is null \n" +
						"This category object is necessary to found the articles");

				return;
			}

			List<com.liferay.portal.kernel.search.Document> documents =
					streamingPortletHelper.getDocumentsByCategory(themeDisplay, -1, -1,
							categoriesModel.get(0).getCategoryId());

			for (com.liferay.portal.kernel.search.Document doc  : documents) {
				String articleId = doc.get("articleId");

				JournalArticle journalArticle =
						JournalArticleLocalServiceUtil.getLatestArticle(groupId, articleId);

				Set<String> fieldsName =
						streamingPortletHelper.getFieldsByStructure(journalArticle);

				String documentContent = journalArticle.getContentByLocale(
						themeDisplay.getLanguageId());

				Document document = null;

				document = SAXReaderUtil.read(new StringReader(documentContent));

				String color;
				String date;
				String description;
				String fileEntry;
				String title;

				for (String values : fieldsName) {

					String[] value = values.split("=");

				    switch (value[0])  {
						case "Text13771537":
							title = streamingPortletHelper.getTitleAndDescriptionByFields(
									carouselContentModel.getFieldSet(), value[0],themeDisplay, document);

							carouselContentModel.setTitle(title);

							break;

						case "RichText53999476":
							description = streamingPortletHelper.getTitleAndDescriptionByFields(
									carouselContentModel.getFieldSet(), value[0],themeDisplay, document);

							description = description.replace("<p>", StringPool.BLANK);

							description = description.replace("</p>", StringPool.BLANK);

							carouselContentModel.setDescription(description);

							break;

						case "Image87907379":
							fileEntry = streamingPortletHelper.getTitleAndDescriptionByFields(
									carouselContentModel.getFieldSet(), value[0],themeDisplay, document);

							carouselContentModel.setFileEntry(fileEntry);

							break;

						case "Date63543359":
							date = streamingPortletHelper.getTitleAndDescriptionByFields(
									carouselContentModel.getFieldSet(), value[0], themeDisplay, document);

							carouselContentModel.setDate(date);

							break;

						case "Color64500276":
							color = streamingPortletHelper.getTitleAndDescriptionByFields(
									carouselContentModel.getFieldSet(), value[0],themeDisplay, document);

							carouselContentModel.setColor(color);

							break;
					}
				}
			}

			_log.info("Load category "
					+ categoriesModel.get(0).getCategoryName() + " completed");
		}
		catch (PortalException | DocumentException portletException) {
			throw new PortletException(portletException);
		}
		finally {

			renderRequest.setAttribute("carouselContentModel", carouselContentModel.toString());

			super.doView(renderRequest, renderResponse);

			_log.info("Module " +
					StreamingPortlet.class.getName() + " initialized");
		}

	}

	private static final Log _log =
			LogFactoryUtil.getLog(StreamingPortlet.class);

}