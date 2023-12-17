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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.streaming.exception.*;
import com.streaming.model.CarouselItemsDashboard;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for CarouselItemsDashboard. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CarouselItemsDashboardServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CarouselItemsDashboardService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.streaming.service.impl.CarouselItemsDashboardServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the carousel items dashboard remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CarouselItemsDashboardServiceUtil} if injection and service tracking are not available.
	 */
	public void addNewCarouselItem(
			long mvccVersion, String uuid, String externalReferenceCode,
			long categoryId, long groupId, long companyId, String userName,
			Date createDate, Date modifiedDate, String category,
			String colorTheme, long instanceCategoryFk, String priority,
			String title, ThemeDisplay themeDisplay)
		throws CarouselInvalidFieldItemException,
			   CarouselItemNotAllowedException, CarouselItemNotFoundException;

	public void deleteCarouselItemById(
			long categoryId, long groupId, ThemeDisplay themeDisplay)
		throws NoSuchCarouselItemsDashboardException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CarouselItemsDashboard getCarouselItemById(
			long categoryId, long groupId, ThemeDisplay themeDisplay)
		throws CarouselItemNotAllowedException,
			   NoSuchCarouselItemsDashboardException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CarouselItemsDashboard> getCarouselItemsList(long groupId)
		throws CarouselDashboardManagerNotFoundException,
			   CarouselItemDashboardException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public CarouselItemsDashboard updateCarouselItemById(
			long categoryId, long groupId, String userName, String category,
			String colorTheme, String priority, String title)
		throws CarouselDashboardManagerNotFoundException,
			   CarouselItemDashboardException;

}