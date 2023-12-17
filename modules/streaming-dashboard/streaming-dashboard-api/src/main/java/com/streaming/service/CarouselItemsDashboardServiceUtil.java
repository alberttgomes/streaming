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

package com.streaming.service;

import com.streaming.exception.*;
import com.streaming.model.CarouselItemsDashboard;

import java.util.List;

/**
 * Provides the remote service utility for CarouselItemsDashboard. This utility wraps
 * <code>com.streaming.service.impl.CarouselItemsDashboardServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CarouselItemsDashboardService
 * @generated
 */
public class CarouselItemsDashboardServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.streaming.service.impl.CarouselItemsDashboardServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addNewCarouselItem(
			long mvccVersion, String uuid, String externalReferenceCode,
			long categoryId, long groupId, long companyId, String userName,
			java.util.Date createDate, java.util.Date modifiedDate,
			String category, String colorTheme, long instanceCategoryFk,
			String priority, String title,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws CarouselInvalidFieldItemException,
			CarouselItemNotAllowedException, CarouselItemNotFoundException {

		getService().addNewCarouselItem(
			mvccVersion, uuid, externalReferenceCode, categoryId, groupId,
			companyId, userName, createDate, modifiedDate, category, colorTheme,
			instanceCategoryFk, priority, title, themeDisplay);
	}

	public static void deleteCarouselItemById(
			long categoryId, long groupId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws NoSuchCarouselItemsDashboardException {

		getService().deleteCarouselItemById(categoryId, groupId, themeDisplay);
	}

	public static CarouselItemsDashboard getCarouselItemById(
			long categoryId, long groupId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws CarouselItemNotAllowedException,
			   NoSuchCarouselItemsDashboardException {

		return getService().getCarouselItemById(
			categoryId, groupId, themeDisplay);
	}

	public static List<CarouselItemsDashboard> getCarouselItemsList(
			long groupId)
		throws CarouselDashboardManagerNotFoundException,
			   CarouselItemDashboardException {

		return getService().getCarouselItemsList(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CarouselItemsDashboard updateCarouselItemById(
			long categoryId, long groupId, String userName, String category,
			String colorTheme, String priority, String title)
		throws CarouselDashboardManagerNotFoundException,
			   CarouselItemDashboardException {

		return getService().updateCarouselItemById(
			categoryId, groupId, userName, category, colorTheme, priority,
			title);
	}

	public static CarouselItemsDashboardService getService() {
		return _service;
	}

	private static volatile CarouselItemsDashboardService _service;

}