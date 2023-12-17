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

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.streaming.exception.*;

/**
 * Provides a wrapper for {@link CarouselItemsDashboardService}.
 *
 * @author Brian Wing Shun Chan
 * @see CarouselItemsDashboardService
 * @generated
 */
public class CarouselItemsDashboardServiceWrapper
	implements CarouselItemsDashboardService,
			   ServiceWrapper<CarouselItemsDashboardService> {

	public CarouselItemsDashboardServiceWrapper() {
		this(null);
	}

	public CarouselItemsDashboardServiceWrapper(
		CarouselItemsDashboardService carouselItemsDashboardService) {

		_carouselItemsDashboardService = carouselItemsDashboardService;
	}

	@Override
	public void addNewCarouselItem(
			long mvccVersion, String uuid, String externalReferenceCode,
			long categoryId, long groupId, long companyId, String userName,
			java.util.Date createDate, java.util.Date modifiedDate,
			String category, String colorTheme, long instanceCategoryFk,
			String priority, String title,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws CarouselInvalidFieldItemException,
			   CarouselItemNotAllowedException, CarouselItemNotFoundException {

		_carouselItemsDashboardService.addNewCarouselItem(
			mvccVersion, uuid, externalReferenceCode, categoryId, groupId,
			companyId, userName, createDate, modifiedDate, category, colorTheme,
			instanceCategoryFk, priority, title, themeDisplay);
	}

	@Override
	public void deleteCarouselItemById(
			long categoryId, long groupId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws NoSuchCarouselItemsDashboardException {

		_carouselItemsDashboardService.deleteCarouselItemById(
			categoryId, groupId, themeDisplay);
	}

	@Override
	public com.streaming.model.CarouselItemsDashboard getCarouselItemById(
			long categoryId, long groupId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws CarouselItemNotAllowedException,
			NoSuchCarouselItemsDashboardException {

		return _carouselItemsDashboardService.getCarouselItemById(
			categoryId, groupId, themeDisplay);
	}

	@Override
	public java.util.List<com.streaming.model.CarouselItemsDashboard>
			getCarouselItemsList(long groupId)
		throws CarouselDashboardManagerNotFoundException,
			   CarouselItemDashboardException {

		return _carouselItemsDashboardService.getCarouselItemsList(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _carouselItemsDashboardService.getOSGiServiceIdentifier();
	}

	@Override
	public com.streaming.model.CarouselItemsDashboard updateCarouselItemById(
			long categoryId, long groupId, String userName, String category,
			String colorTheme, String priority, String title)
		throws CarouselDashboardManagerNotFoundException,
			CarouselItemDashboardException {

		return _carouselItemsDashboardService.updateCarouselItemById(
			categoryId, groupId, userName, category, colorTheme, priority,
			title);
	}

	@Override
	public CarouselItemsDashboardService getWrappedService() {
		return _carouselItemsDashboardService;
	}

	@Override
	public void setWrappedService(
		CarouselItemsDashboardService carouselItemsDashboardService) {

		_carouselItemsDashboardService = carouselItemsDashboardService;
	}

	private CarouselItemsDashboardService _carouselItemsDashboardService;

}