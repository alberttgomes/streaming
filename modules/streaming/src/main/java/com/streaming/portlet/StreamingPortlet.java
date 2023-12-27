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

import com.streaming.util.StreamingPortletUtil;
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

		ContentModel contentModel = new ContentModel();

		try {
			PreferencesPortletModel preferencesPortletModel =
					StreamingPortletHelper.setPreferencesModel(
							companyId, groupId, mvccVersion, contact.getUserId(),
							StreamingCategoriesKeys.STREAMING_VOCABULARY_CATEGORIES,
							externalReferenceCode, renderRequest);

			if (preferencesPortletModel.getClass() != null) {
				preferencesPortlet = preferencesPortletModel;
			}

			List<CategoriesModel> categoriesModelList =
					StreamingPortletHelper.getCategories(
							preferencesPortletModel.getVocabularyCategories());

			List<Object> objectList = new ArrayList<>();

			for (String categoryByVocabulary :
					StreamingPortletUtil.streamingVocabularyValuesToArray()) {
				CategoriesModel categoriesModel =
						StreamingPortletHelper.getCategoryModelByVocabularyName(
								categoriesModelList, categoryByVocabulary);

				if (categoriesModel == null) {
					continue;
				}

				List<com.liferay.portal.kernel.search.Document> documents =
						StreamingPortletHelper.getDocumentsByCategory(
								themeDisplay, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
								categoriesModel.getCategoryId());

				int count = 0;

				Map<String, Object> carouselRender = new HashMap<>();

				for (com.liferay.portal.kernel.search.Document doc : documents) {
					count++;

					String articleId = doc.get("articleId");

					JournalArticle journalArticle =
							JournalArticleLocalServiceUtil.getLatestArticle(
									groupId, articleId);

					Set<String> fieldsNames =
							StreamingPortletHelper.getFieldsByStructure(
									journalArticle);

					String documentContent =
							journalArticle.getContentByLocale(
									themeDisplay.getLanguageId());

					Document document;
					document = SAXReaderUtil.read(new StringReader(documentContent));

					Map<String, String> map = new HashMap<>();

					for (String values : fieldsNames) {
						String[] value = values.split(StringPool.COMMA);
						switch (value[0])  {
							case "Text00874470":
								map.put("title",
										StreamingPortletHelper.getFields(
												contentModel.getFieldSet(), value[0],
												themeDisplay, document));
								break;
							case "RichText22021739":
								map.put("description",
										StreamingPortletHelper.getFields(
												contentModel.getFieldSet(), value[0],
												themeDisplay, document));
								break;
							case "Image27507480":
								map.put("image",
										StreamingPortletHelper.getFields(
												contentModel.getFieldSet(), value[0],
												themeDisplay, document));
								break;
							case "Date94594405":
								map.put("date", StreamingPortletHelper.getFields(
										contentModel.getFieldSet(), value[0],
										themeDisplay, document));
								break;
							case "Color12880647":
								map.put("color",
										StreamingPortletHelper.getFields(
												contentModel.getFieldSet(), value[0],
												themeDisplay, document));
								break;
						}
						if ((fieldsNames.size() -1) == map.size()) {
							map.put("category",
									categoriesModel.getCategoryName());
						}
					}

					carouselRender.put("index" + count, map);
				}

				if (!carouselRender.isEmpty()) {
					List<Map<String, Object>> carouselRenderList = new ArrayList<>();

					carouselRenderList.add(carouselRender);

					List<Object> objects = StreamingPortletHelper.convertObjectData(
							carouselRenderList);

					objectList.add(objects);
				}
			}

			renderRequest.setAttribute("carouselData", objectList);

			super.doView(renderRequest, renderResponse);
		}
		catch (PortalException | DocumentException exception) {
			throw new PortletException(exception);
		}
	}

	protected PreferencesPortletModel preferencesPortlet = null;
}