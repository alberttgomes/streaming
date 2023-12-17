package com.streaming.helper;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.WebKeys;

import com.streaming.constants.StreamingDashboardHelperConstants;
import com.streaming.model.CarouselItemsDashboard;
import com.streaming.service.StreamingDashboardCarouselManagerService;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import java.util.*;

/**
 * @author Albert Gomes Cabral
 */
public class DashboardItemsHelp {
    public CarouselItemsDashboard updateDashboardItemHelp(
            long categoryId, long groupId,  String userName, String category,
            String colorTheme, String priority, String title) throws Exception {

        return _streamingDashboardCarouselManagerService.updateCarouselItemById(
                categoryId, groupId, userName, category, colorTheme, priority, title);
    }

    public CarouselItemsDashboard saveDashboardItemsHelp(
            ResourceRequest resourceRequest) throws Exception {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) resourceRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        String category = ParamUtil.getString(resourceRequest, "category");
        String colorTheme = ParamUtil.getString(resourceRequest, "colorTheme");
        String priority= ParamUtil.getString(resourceRequest, "priority");
        String title = ParamUtil.getString(resourceRequest, "title");

        List<AssetVocabulary> vocabularies =
                AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);

        long categoryId = 0;
        long groupId = themeDisplay.getSiteGroupId();

        for (AssetVocabulary vocabulary : vocabularies) {
            if (vocabulary.getName().equalsIgnoreCase(
                    StreamingDashboardHelperConstants.STREAMING_DASHBOARD_VOCABULARY_NAME)) {

                categoryId = vocabulary.getVocabularyId();

                break;
            }
        }

        try {
            AssetCategory assetCategory =
                    AssetCategoryLocalServiceUtil.getCategory(categoryId);

            User user = themeDisplay.getUser();

            long companyId = themeDisplay.getCompanyId();

            if (assetCategory != null) {
                _streamingDashboardCarouselManagerService.addNewCarouselItem(
                        assetCategory.getMvccVersion(), assetCategory.getUuid(),
                        assetCategory.getExternalReferenceCode(), RandomTestUtil.randomLong(),
                        groupId, companyId, user.getScreenName(), new Date(),
                        new Date(), category, colorTheme, assetCategory.getCategoryId(),
                        priority, title, themeDisplay);
            }
            else {
                if (_log.isWarnEnabled()) {
                    _log.warn(StringBundler.concat(
                            "Unable to find Asset Category with id ",
                            String.valueOf(categoryId), StringPool.SPACE,
                            "saving as default mode..."));
                }

                _streamingDashboardCarouselManagerService.addNewCarouselItem(
                        0, StringPool.BLANK, StringPool.BLANK, RandomTestUtil.randomLong(),
                        groupId, companyId, user.getScreenName(), new Date(),
                        new Date(), category, colorTheme, 0,
                        priority, title, themeDisplay);
            }
        }
        catch (Exception exception) {
            throw new Exception(exception);
        }

        return _streamingDashboardCarouselManagerService.getCarouselItemById(
                categoryId, groupId, themeDisplay);
    }
    private static final Log _log = LogFactoryUtil.getLog(DashboardItemsHelp.class);

    @Reference
    private StreamingDashboardCarouselManagerService
            _streamingDashboardCarouselManagerService;

}
