package com.streaming.helper;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.messaging.Message;
import com.streaming.constants.NotificationStatus;
import com.streaming.exceptions.NotificationMessageException;
import com.streaming.model.CategoriesModel;
import com.streaming.model.PreferencesPortletModel;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
public class StreamingPortletHelper {

    public PreferencesPortletModel loadPreferencesModel(
            long companyId, long groupId, long mvccVersion,
            long userId, String externalReferenceCode, PortletRequest preferences)
            throws RuntimeException {

        PortletPreferences portletPreferences =
                preferences.getPreferences();

        PreferencesPortletModel preferencesPortletModel =
                new PreferencesPortletModel();

        preferencesPortletModel.setVocabularyCategories(
                "vocabulary_streaming");
        preferencesPortletModel.setCompanyId(companyId);
        preferencesPortletModel.setMvccVersion(mvccVersion);
        preferencesPortletModel.setExternalReferenceCode(externalReferenceCode);
        preferencesPortletModel.setGroupId(groupId);
        preferencesPortletModel.setUserId(userId);
        preferencesPortletModel.setPreferences(preferences);

        return preferencesPortletModel;
    }

    public List<CategoriesModel> getCategories(String vocabularyName) {

        List<AssetVocabulary> vocabularies =
                AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);

        long categoryId = -1;

        for (AssetVocabulary vocabulary : vocabularies) {
            if (vocabulary.getName().equalsIgnoreCase(vocabularyName)) {
                categoryId = vocabulary.getVocabularyId();

                break;
            }
        }

        List<CategoriesModel> listCat = new ArrayList<>();

        if (categoryId == -1) {
            List<AssetCategory> categories =
                    AssetCategoryLocalServiceUtil.getAssetCategories(-1, -1);

            for (AssetCategory category : categories) {
                if (category.getName().equals(vocabularyName)) {
                    categoryId = category.getVocabularyId();

                    break;
                }
            }

            List<AssetCategory> categoriesList = AssetCategoryLocalServiceUtil
                    .getChildCategories(categoryId, -1, -1, null);

            categoriesList.parallelStream().forEach(cat -> {
                CategoriesModel categoriesModel = new CategoriesModel();
                categoriesModel.setCategoryId(cat.getCategoryId());
                categoriesModel.setCategoryName(cat.getName());
                categoriesModel.setCategoryVocabulary(cat.getVocabularyId());
                listCat.add(categoriesModel);
            });
        }
        else {
            List<AssetCategory> categoriesList = AssetCategoryLocalServiceUtil
                    .getVocabularyCategories(categoryId, -1, -1, null);

            categoriesList.parallelStream().forEach(cat -> {
                CategoriesModel categoriesModel = new CategoriesModel();
                categoriesModel.setCategoryId(cat.getCategoryId());
                categoriesModel.setCategoryName(cat.getName());
                categoriesModel.setCategoryVocabulary(cat.getVocabularyId());
                listCat.add(categoriesModel);
            });
        }

        return listCat;
    }

    public void registerMessageListener(Message message)
            throws NotificationMessageException {

        JSONObject jsonObject = (JSONObject)message.getPayload();

        long notificationId = jsonObject.getLong(
                "notification_model_news_id");

        List<String> messageList = (List<String>)
                jsonObject.get("notification_model_news_messages");

        String notificationStatus = jsonObject.getString(
                "notification_model_news_status");

        if (!notificationStatus.equals
                (NotificationStatus.STATUS_APPROVED)) {
            return;
        }

        message.put("notification_id", notificationId);
        message.put("notification_message", messageList);
        message.put("notification_status", notificationStatus);
    }

}
