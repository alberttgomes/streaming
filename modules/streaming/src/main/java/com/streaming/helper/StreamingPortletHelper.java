package com.streaming.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.journal.model.JournalArticle;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.search.facet.faceted.searcher.FacetedSearcher;
import com.liferay.portal.kernel.search.facet.faceted.searcher.FacetedSearcherManagerUtil;
import com.liferay.portal.kernel.search.generic.BooleanClauseImpl;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.search.generic.QueryTermImpl;
import com.liferay.portal.kernel.search.generic.TermQueryImpl;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.xml.Node;

import com.streaming.model.CategoriesModel;
import com.streaming.model.PreferencesPortletModel;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import java.util.*;


/**
 * @author Albert Gomes Cabral
 */
public class StreamingPortletHelper {

    public static List<Object> convertObjectData(
            List<Map<String, Object>> dataMapList) throws JsonProcessingException {
        List<Object> objectList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for (Map<String, Object> map : dataMapList) {
            String jsonParser = mapper.writeValueAsString(map);
            objectList.add(jsonParser);
        }
        return objectList;
    }

    public static List<CategoriesModel> getCategories(
            String vocabularyName) {
        List<AssetVocabulary> vocabularies =
                AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);

        long categoryId = 0;

        for (AssetVocabulary vocabulary : vocabularies) {
            if (vocabulary.getName().equalsIgnoreCase(vocabularyName)) {
                categoryId = vocabulary.getVocabularyId();
                break;
            }
        }

        List<CategoriesModel> categoryList = new ArrayList<>();

        if (categoryId == 0) {
            List<AssetCategory> categories =
                    AssetCategoryLocalServiceUtil.getAssetCategories(-1, -1);

            categories.parallelStream().forEach(cat -> {
                CategoriesModel categoriesModel = new CategoriesModel();
                categoriesModel.setCategoryId(cat.getCategoryId());
                categoriesModel.setCategoryName(cat.getName());
                categoriesModel.setCategoryVocabulary(cat.getVocabularyId());
                categoryList.add(categoriesModel);
            });
        }
        else {
            List<AssetCategory> categoriesList =
                    AssetCategoryLocalServiceUtil.getVocabularyCategories(
                            categoryId, -1, -1, null);

            categoriesList.parallelStream().forEach(cat -> {
                CategoriesModel categoriesModel = new CategoriesModel();
                categoriesModel.setCategoryId(cat.getCategoryId());
                categoriesModel.setCategoryName(cat.getName());
                categoriesModel.setCategoryVocabulary(cat.getVocabularyId());
                categoryList.add(categoriesModel);
            });
        }
        return categoryList;
    }

    public static CategoriesModel getCategoryModelByVocabularyName(
            List<CategoriesModel> categoriesModelList, String vocabulary) {

        CategoriesModel categoriesModel = new CategoriesModel();

        for (CategoriesModel categoriesModelIterator : categoriesModelList) {
            if (categoriesModelIterator.getCategoryName().equals(vocabulary)) {
                categoriesModel = categoriesModelIterator;

                break;
            }
        }

        return categoriesModel;
    }

    public static List<com.liferay.portal.kernel.search.Document> getDocumentsByCategory(
            ThemeDisplay themeDisplay, int start, int end, long categoryId)
                throws RuntimeException {

        List<com.liferay.portal.kernel.search.Document> docs = null;

        BooleanQuery filterQuery = new BooleanQueryImpl();

        try {
            TermQuery termQueryCategoryIds = _buildTermQuery(
                    "assetCategoryIds", String.valueOf(categoryId));
            filterQuery.add(termQueryCategoryIds, BooleanClauseOccur.MUST);

            TermQuery termQueryEntryClassName = _buildTermQuery(
                    "entryClassName", JournalArticle.class.getName());
            filterQuery.add(termQueryEntryClassName, BooleanClauseOccur.MUST);

            TermQuery termQueryHead = _buildTermQuery("head", "true");
            filterQuery.add(termQueryHead, BooleanClauseOccur.MUST);

            BooleanClause<Query> clause = new BooleanClauseImpl<>(
                    filterQuery, BooleanClauseOccur.MUST);

            SearchContext searchContext =
                    _getSearchContext(themeDisplay, start, end);

            searchContext.setBooleanClauses(new BooleanClause[]{clause});

            FacetedSearcher facetedSearcher =
                    FacetedSearcherManagerUtil.createFacetedSearcher();

            Hits hits = facetedSearcher.search(searchContext);

            if (hits.getLength() > start) {
                docs = hits.toList();
            }
        }
        catch (RuntimeException | ParseException
               | SearchException runtimeException) {
            throw new RuntimeException(runtimeException);
        }
        return docs;
    }

    public static Set<String> getFieldsByStructure(
            JournalArticle journalArticle) throws PortalException {
        DDMStructure structure = journalArticle.getDDMStructure();
        Set<String> fieldNames = structure.getFieldNames();
        Set<String> fields = new HashSet<String>();

        for (String name : fieldNames) {
            fields.add(name + StringPool.COMMA_AND_SPACE +
                    structure.getFieldDataType(name));
        }
        return fields;
    }

    public static String getFields(
            String fieldGroup, String field, ThemeDisplay themeDisplay, Document document)
                throws PortalException, JsonProcessingException {
        String xPathFieldGroup =
                "/root/dynamic-element[@name='" + fieldGroup + "']";
        Node node = document.selectSingleNode(
                xPathFieldGroup + "/dynamic-element[@name='" + field + "']/dynamic-content");

        String fieldResult = StringPool.BLANK;

        if (Validator.isNotNull(node)) {
            fieldResult = node.getText().trim();

            if (fieldResult.contains("groupId") && fieldResult.contains("uuid")) {
                ObjectMapper mapper = new ObjectMapper();

                Map<String, Object> jsonMap = mapper.readValue(
                        fieldResult, Map.class);

                Object groupId = jsonMap.get("groupId");
                Object uuid = jsonMap.get("uuid");

                DLFileEntry dlFileEntry =
                        DLFileEntryServiceUtil.getFileEntryByUuidAndGroupId(
                                uuid.toString(), Long.parseLong(groupId.toString()));

                FileEntry fileEntry = DLAppServiceUtil.getFileEntry(
                        dlFileEntry.getFileEntryId());

                FileVersion fileVersion = fileEntry.getFileVersion();

                fieldResult = DLURLHelperUtil.getPreviewURL(
                        fileEntry, fileVersion, themeDisplay, StringPool.BLANK);
            }
        }
        return fieldResult;
    }

    public static PreferencesPortletModel setPreferencesModel(
            long companyId, long groupId, long mvccVersion, long userId,
            String VocabularyCategory, String externalReferenceCode, PortletRequest preferences)
                throws RuntimeException {
        PortletPreferences portletPreferences = preferences.getPreferences();
        PreferencesPortletModel preferencesPortletModel = new PreferencesPortletModel();

        preferencesPortletModel.setVocabularyCategories(VocabularyCategory);
        preferencesPortletModel.setCompanyId(companyId);
        preferencesPortletModel.setMvccVersion(mvccVersion);
        preferencesPortletModel.setExternalReferenceCode(externalReferenceCode);
        preferencesPortletModel.setGroupId(groupId);
        preferencesPortletModel.setUserId(userId);
        preferencesPortletModel.setPreferences(portletPreferences);

        return preferencesPortletModel;
    }

    private static TermQueryImpl _buildTermQuery(String field, String value) {
        return new TermQueryImpl(new QueryTermImpl(field, value));
    }

    private static SearchContext _getSearchContext(
            ThemeDisplay themeDisplay, int start, int end) {
        long[] groupsIds = {themeDisplay.getScopeGroupId()};

        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(themeDisplay.getCompanyId());
        searchContext.setGroupIds(groupsIds);
        searchContext.setStart(start);
        searchContext.setEnd(end);

        return searchContext;
    }

}
