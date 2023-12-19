package com.streaming.portlet;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
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

import java.io.IOException;
import java.io.StringReader;
import java.util.*;


import com.streaming.helper.StreamingPortletHelper;
import com.streaming.model.ContentModel;
import com.streaming.model.CategoriesModel;
import com.streaming.model.PreferencesPortletModel;
import com.streaming.constants.StreamingCategoriesKeys;

import org.osgi.service.component.annotations.Component;

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

		ThemeDisplay themeDisplay = (ThemeDisplay) 
			renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getSiteGroupId();

		Group group = themeDisplay.getSiteGroup();
		Contact contact = themeDisplay.getContact();
		String externalReferenceCode = group.getExternalReferenceCode();
		long mvccVersion = group.getMvccVersion();

		ContentModel contentModel = null;

		try {
			PreferencesPortletModel preferencesPortletModel =
					StreamingPortletHelper.setPreferencesModel(
							companyId, groupId, mvccVersion, contact.getUserId(),
							StreamingCategoriesKeys.STREAMING_MOVIES_CATEGORY,
							externalReferenceCode, renderRequest);

			if (preferencesPortletModel.getClass() != null) {
				preferencesPortlet = preferencesPortletModel;
			}

			List<CategoriesModel> categoriesModelList =
					StreamingPortletHelper.getCategories(
							preferencesPortletModel.getVocabularyCategories());

			CategoriesModel categoriesModel =
					StreamingPortletHelper.getCategoryModelByVocabularyName(
							categoriesModelList,
							StreamingCategoriesKeys.STREAMING_MOVIES_CATEGORY);

			List<com.liferay.portal.kernel.search.Document> documents =
					StreamingPortletHelper.getDocumentsByCategory(
							themeDisplay, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
							categoriesModel.getCategoryId());

			int count = 0;

			for (com.liferay.portal.kernel.search.Document doc : documents) {
				count++;

				String articleId = doc.get("articleId");

				JournalArticle journalArticle =
						JournalArticleLocalServiceUtil.getLatestArticle(
							groupId, articleId);

				Set<String> fieldsNames = StreamingPortletHelper.getFieldsByStructure(
					journalArticle);

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

				for (String values : fieldsNames) {
					String[] value = values.split(StringPool.COMMA);
				    switch (value[0])  {
						case "Text13771537":
							title = StreamingPortletHelper.getFields(
									contentModel.getFieldSet(), value[0],
									themeDisplay, document);
							contentModel.setTitle(title);
							map.put(value[0], title);

							break;
						case "RichText53999476":
							description = StreamingPortletHelper.getFields(
									contentModel.getFieldSet(), value[0], themeDisplay, document);
							contentModel.setDescription(description);
							map.put("rich-text", description);

							break;
						case "Image87907379":
							fileEntry = StreamingPortletHelper.getFields(
									contentModel.getFieldSet(), value[0], themeDisplay, document);
							contentModel.setFileEntry(fileEntry);
							map.put("image", fileEntry);

							break;
						case "Date63543359":
							date = StreamingPortletHelper.getFields(
									contentModel.getFieldSet(), value[0], themeDisplay, document);
							contentModel.setDate(date);
							map.put("date", date);

							break;
						case "Color64500276":
							color = StreamingPortletHelper.getFields(
									contentModel.getFieldSet(), value[0], themeDisplay, document);
							contentModel.setColor(color);
							map.put("color", color);

							break;
					}
				}
				carouselRender.put("field_" + count, map);
			}
		}
		catch (PortalException | DocumentException exception) {
			throw new PortletException(exception);
		}
		finally {
			renderRequest.setAttribute("carouselJsonData", carouselRender);

			super.doView(renderRequest, renderResponse);
		}
	}

	protected PreferencesPortletModel preferencesPortlet = null;
	protected final Map<String, Object> carouselRender = new LinkedHashMap<>();
}