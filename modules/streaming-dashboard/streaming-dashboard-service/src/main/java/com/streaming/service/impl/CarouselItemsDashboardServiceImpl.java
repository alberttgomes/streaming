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

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringBundler;
import com.streaming.exception.CarouselInvalidFieldItemException;
import com.streaming.exception.CarouselItemNotAllowedException;
import com.streaming.exception.CarouselItemNotFoundException;
import com.streaming.model.CarouselItemsDashboard;
import com.streaming.service.CarouselItemsDashboardService;
import com.streaming.service.base.CarouselItemsDashboardServiceBaseImpl;

import com.streaming.service.impl.util.PrioritiesEnum;
import org.osgi.service.component.annotations.Component;

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
public class CarouselItemsDashboardServiceImpl extends CarouselItemsDashboardServiceBaseImpl
		implements CarouselItemsDashboardService {
	@Override
	public void addNewCarouselItem(
			CarouselItemsDashboard carouselItemsDashboard, long groupId, ThemeDisplay themeDisplay)
				throws CarouselItemNotAllowedException, CarouselInvalidFieldItemException, CarouselItemNotFoundException {

		boolean valid = _validRulesCarouselFieldsBefore(carouselItemsDashboard);

		if (valid) {
			valid = _validRulesForUsersPermissions(groupId, themeDisplay);

			if (valid) {
				_log.info("User and rules checked with success");

				// Convert priority to pattern in the @PrioritiesEnum if necessary
				for (String value : PrioritiesEnum.valuesArray()) {
					if (carouselItemsDashboard.getPriority().equals(value)) {
						break;
					}
					else {
						String priorityUpperCase =
								carouselItemsDashboard.getPriority().toUpperCase();

						carouselItemsDashboard.setPriority(
								priorityUpperCase + "_PRIORITY");
					}
				}

				long categoryInstanceId = _createInstanceAssetCategory(
						carouselItemsDashboard.getCategory());

				if (categoryInstanceId > 0) {
					carouselItemsDashboardLocalService.addCarouselItemsDashboard(
							carouselItemsDashboard);
				}
				else {
					throw new CarouselItemNotFoundException(
							"Category instance not found " +
									carouselItemsDashboard.getCategory());
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
			long categoryId, long groupId, ThemeDisplay themeDisplay) {

	}

	@Override
	public void getCarouselItemById(long categoryId, long groupId, ThemeDisplay themeDisplay) {

	}

	@Override
	public void getCarouselItemById(long categoryId, long groupId) {

	}

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
}