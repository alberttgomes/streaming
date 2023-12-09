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

import com.streaming.model.CarouselItemsDashboard;

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
			CarouselItemsDashboard carouselItemsDashboard, long groupId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.streaming.exception.CarouselInvalidFieldItemException,
			   com.streaming.exception.CarouselItemNotAllowedException,
			   com.streaming.exception.CarouselItemNotFoundException {

		getService().addNewCarouselItem(
			carouselItemsDashboard, groupId, themeDisplay);
	}

	public static void deleteCarouselItemById(
		long categoryId, long groupId,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		getService().deleteCarouselItemById(categoryId, groupId, themeDisplay);
	}

	public static void getCarouselItemById(long categoryId, long groupId) {
		getService().getCarouselItemById(categoryId, groupId);
	}

	public static void getCarouselItemById(
		long categoryId, long groupId,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		getService().getCarouselItemById(categoryId, groupId, themeDisplay);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CarouselItemsDashboardService getService() {
		return _service;
	}

	private static volatile CarouselItemsDashboardService _service;

}