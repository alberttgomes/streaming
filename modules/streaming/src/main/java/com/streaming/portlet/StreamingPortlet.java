package com.streaming.portlet;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
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

import com.streaming.constants.VocabularyCategoriesConstant;
import com.streaming.helper.StreamingPortletHelper;
import com.streaming.model.CarouselContentModel;
import com.streaming.model.CategoriesModel;
import com.streaming.model.PreferencesPortletModel;
import org.osgi.service.component.annotations.Component;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;


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
		"javax.portlet.security-role-ref=power-user,user",
		"vocabulary.categories=vocabulary_streaming"
	},
	service = Portlet.class
)
public class StreamingPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
				throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getSiteGroupId();

		Group group = themeDisplay.getSiteGroup();
		Contact contact = themeDisplay.getContact();
		String externalReferenceCode =
				group.getExternalReferenceCode();
		long mvccVersion = group.getMvccVersion();

		CarouselContentModel carouselContentModel =
				new CarouselContentModel();
		try {
			PreferencesPortletModel preferencesPortletModel =
					StreamingPortletHelper.setPreferencesModel(
							companyId, groupId, mvccVersion, contact.getUserId(),
							VocabularyCategoriesConstant.VOCABULARY_STREAMING_NAME,
							externalReferenceCode, renderRequest);

			List<CategoriesModel> categoriesModel = StreamingPortletHelper.getCategories(
					preferencesPortletModel.getVocabularyCategories());

			List<com.liferay.portal.kernel.search.Document> documents =
					StreamingPortletHelper.getDocumentsByCategory(themeDisplay, -1, -1,
							categoriesModel.get(0).getCategoryId());

			int count = 0;

			for (com.liferay.portal.kernel.search.Document doc  : documents) {
				count++;

				String articleId = doc.get("articleId");

				JournalArticle journalArticle =
						JournalArticleLocalServiceUtil.getLatestArticle(groupId, articleId);

				Set<String> fieldsName = StreamingPortletHelper.getFieldsByStructure(journalArticle);

				String documentContent = journalArticle.getContentByLocale(
						themeDisplay.getLanguageId());

				Document document;
				document = SAXReaderUtil.read(new StringReader(documentContent));

				Map<String, String> map = new HashMap<>();

				String color;
				String date;
				String description;
				String fileEntry;
				String title;

				for (String values : fieldsName) {
					String[] value = values.split("=");
				    switch (value[0])  {
						case "Text13771537":
							title = StreamingPortletHelper.getFields(
									carouselContentModel.getFieldSet(), value[0],themeDisplay, document);
							carouselContentModel.setTitle(title);
							map.put(value[0], title);
							break;
						case "RichText53999476":
							description = StreamingPortletHelper.getFields(
									carouselContentModel.getFieldSet(), value[0],themeDisplay, document);
							carouselContentModel.setDescription(description);
							map.put("rich-text", description);
							break;
						case "Image87907379":
							fileEntry = StreamingPortletHelper.getFields(
									carouselContentModel.getFieldSet(), value[0],themeDisplay, document);
							carouselContentModel.setFileEntry(fileEntry);
							map.put("image", fileEntry);
							break;
						case "Date63543359":
							date = StreamingPortletHelper.getFields(
									carouselContentModel.getFieldSet(), value[0], themeDisplay, document);
							carouselContentModel.setDate(date);
							map.put("date", date);
							break;
						case "Color64500276":
							color = StreamingPortletHelper.getFields(
									carouselContentModel.getFieldSet(), value[0],themeDisplay, document);
							carouselContentModel.setColor(color);
							map.put("color", color);
							break;
					}
				}
				_carouselRender.put("field_" + count, map);
			}
		}
		catch (PortalException | DocumentException exception) {
			throw new PortletException(exception);
		}
		finally {
			renderRequest.setAttribute("carouselJsonData", _carouselRender);

			super.doView(renderRequest, renderResponse);
		}
	}

	private final Map<String, Object> _carouselRender = new LinkedHashMap<>();

	private static final Log _log = LogFactoryUtil.getLog(StreamingPortlet.class);

}