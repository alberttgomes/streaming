/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.streaming.service.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringBundler;
import com.streaming.exception.*;
import com.streaming.model.CarouselItemsDashboard;
import com.streaming.service.StreamingDashboardCarouselManagerService;
import com.streaming.service.base.CarouselItemsDashboardServiceBaseImpl;

import com.streaming.service.impl.util.PrioritiesEnum;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;


/**
 * @author Brian Wing Shun Chan
 * @author Albert Gomes Cabral
 */
@Component(
	property = {
		"json.web.service.context.name=carouselitemsdashboard",
		"json.web.service.context.path=CarouselItemsDashboard"
	},
	service = AopService.class
)
public class CarouselItemsDashboardServiceImpl
		extends CarouselItemsDashboardServiceBaseImpl implements StreamingDashboardCarouselManagerService {
	@Override
	public void addNewCarouselItem(
			long mvccVersion, String uuid, String externalReferenceCode, long categoryId,
			long groupId, long companyId, String userName, Date createDate, Date modifiedDate,
			String category, String colorTheme, long instanceCategoryFk, String priority,
			String title, ThemeDisplay themeDisplay)
		throws CarouselItemNotAllowedException, CarouselInvalidFieldItemException,
			CarouselItemNotFoundException {

		_carouselItemsDashboard.setMvccVersion(mvccVersion);
		_carouselItemsDashboard.setUuid(uuid);
		_carouselItemsDashboard.setExternalReferenceCode(externalReferenceCode);
		_carouselItemsDashboard.setCategoryId(categoryId);
		_carouselItemsDashboard.setGroupId(groupId);
		_carouselItemsDashboard.setCompanyId(companyId);
		_carouselItemsDashboard.setUserName(userName);
		_carouselItemsDashboard.setCreateDate(createDate);
		_carouselItemsDashboard.setModifiedDate(modifiedDate);
		_carouselItemsDashboard.setCategory(category);
		_carouselItemsDashboard.setColorTheme(colorTheme);
		_carouselItemsDashboard.setInstanceCategoryFk(instanceCategoryFk);
		_carouselItemsDashboard.setPriority(priority);
		_carouselItemsDashboard.setTitle(title);

		boolean valid = _validRulesCarouselFieldsBefore(_carouselItemsDashboard);

		if (valid) {
			valid = _validRulesForUsersPermissions(groupId, themeDisplay);

			if (valid) {
				_log.info("User and rules checked with success");

				if (_carouselItemsDashboard.getCategory().isEmpty()) {
					_prioritiesEnum = PrioritiesEnum.LOW_PRIORITY;
				}
				else {
					_prioritiesEnum = PrioritiesEnum.valueOf(
							_carouselItemsDashboard.getCategory());
				}

				long categoryInstanceId = _createInstanceAssetCategory(
						_carouselItemsDashboard.getCategory());

				if (categoryInstanceId > 0) {
					carouselItemsDashboardLocalService.addCarouselItemsDashboard(
							_carouselItemsDashboard);
				}
				else {
					throw new CarouselItemNotFoundException(
							"Category instance not found " +
									_carouselItemsDashboard.getCategory());
				}
			}
			else {
				throw new CarouselItemNotAllowedException(
						StringBundler.concat("Allowed denied for user ",
								themeDisplay.getUser().toString(), StringPool.SPACE,
								"check your permissions"));
			}
		}
		else {
			throw new CarouselInvalidFieldItemException(
					"Invalid fields on CarouselItemsDashboard model");
		}
	}

	@Override
	public void deleteCarouselItemById(
			long categoryId, long groupId, ThemeDisplay themeDisplay)
				throws NoSuchCarouselItemsDashboardException {
		boolean hasPermission = _validRulesForUsersPermissions(
				groupId, themeDisplay);

		if (!hasPermission) {
			return;
		}

		if (carouselItemsDashboardPersistence.fetchByDeleteCarouselItems(
				groupId, categoryId, false) != null) {
			carouselItemsDashboardPersistence.removeByDeleteCarouselItems(
					groupId, categoryId);
		}
		else {
			_log.warn("Content wasn't found with the primary key " +
					categoryId);
		}
	}

	@Override
	public CarouselItemsDashboard getCarouselItemById(
			long categoryId, long groupId, ThemeDisplay themeDisplay)
		throws NoSuchCarouselItemsDashboardException, CarouselItemNotAllowedException {
		boolean hasPermission = _validRulesForUsersPermissions(
				groupId, themeDisplay);

		CarouselItemsDashboard carouselItemsDashboard;

		if (hasPermission) {
			carouselItemsDashboard =
					carouselItemsDashboardPersistence.findByGetCarouselItemById(
							groupId, categoryId);
		}
		else {
			throw new CarouselItemNotAllowedException(
					"Check your user account and rules to see this content.");
		}
		return carouselItemsDashboard;
	}

	@Override
	public List<CarouselItemsDashboard> getCarouselItemsList(long groupId)
			throws CarouselDashboardManagerNotFoundException, CarouselItemDashboardException {
		return null;
	}

	@Override
	public CarouselItemsDashboard updateCarouselItemById(
			long categoryId, long groupId,  String userName, String category,
			String colorTheme, String priority, String title)
		throws CarouselDashboardManagerNotFoundException, CarouselItemDashboardException {
		return null;
	};

	private long _createInstanceAssetCategory(String categoryName) {
		List<AssetCategory> categories =
				AssetCategoryLocalServiceUtil.getAssetCategories(-1, -1);

		long categoryId = 0;

		for (AssetCategory category : categories) {
			 if (categoryName.equals(category.getName())) {
				 categoryId = category.getCategoryId();
				 break;
			 }
		}
		return categoryId;
	}

	private boolean _validRulesCarouselFieldsBefore(
			CarouselItemsDashboard carouselItemsDashboard)  {
		if (carouselItemsDashboard.getTitle().isEmpty()) {
			return false;
		}
		else if (carouselItemsDashboard.getPriority().isEmpty()) {
			return false;
		}
		else if (carouselItemsDashboard.getColorTheme().isEmpty()) {
			return false;
		}
		else if (carouselItemsDashboard.getCategory().isEmpty()) {
			return false;
		}
		else if (carouselItemsDashboard.getGroupId() < 0) {
			return false;
		}
		else return carouselItemsDashboard.getCategoryId() < 0;
	}

	private boolean _validRulesForUsersPermissions(
			long groupId, ThemeDisplay themeDisplay) {
		boolean checkGroupAndPermission = false;

		User user = themeDisplay.getUser();

		if (user.isActive()) {
			long[] groupIds = user.getUserGroupIds();

			for (long id : groupIds) {
				if (groupId == id) {
					checkGroupAndPermission = true;
					break;
				}
			}
		}
		return checkGroupAndPermission;
	}

	private CarouselItemsDashboard _carouselItemsDashboard;
	private PrioritiesEnum _prioritiesEnum;

	private static final Log _log = LogFactoryUtil.getLog(
			CarouselItemsDashboardServiceImpl.class);
}