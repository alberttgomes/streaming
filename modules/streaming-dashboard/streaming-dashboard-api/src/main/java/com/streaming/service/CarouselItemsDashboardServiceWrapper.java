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
			com.streaming.model.CarouselItemsDashboard carouselItemsDashboard,
			long groupId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.streaming.exception.CarouselInvalidFieldItemException,
			   com.streaming.exception.CarouselItemNotAllowedException,
			   com.streaming.exception.CarouselItemNotFoundException {

		_carouselItemsDashboardService.addNewCarouselItem(
			carouselItemsDashboard, groupId, themeDisplay);
	}

	@Override
	public void deleteCarouselItemById(
		long categoryId, long groupId,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		_carouselItemsDashboardService.deleteCarouselItemById(
			categoryId, groupId, themeDisplay);
	}

	@Override
	public void getCarouselItemById(long categoryId, long groupId) {
		_carouselItemsDashboardService.getCarouselItemById(categoryId, groupId);
	}

	@Override
	public void getCarouselItemById(
		long categoryId, long groupId,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		_carouselItemsDashboardService.getCarouselItemById(
			categoryId, groupId, themeDisplay);
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