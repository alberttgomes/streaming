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
 * Provides a wrapper for {@link CarouselItemsDashboardLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CarouselItemsDashboardLocalService
 * @generated
 */
public class CarouselItemsDashboardLocalServiceWrapper
	implements CarouselItemsDashboardLocalService,
			   ServiceWrapper<CarouselItemsDashboardLocalService> {

	public CarouselItemsDashboardLocalServiceWrapper() {
		this(null);
	}

	public CarouselItemsDashboardLocalServiceWrapper(
		CarouselItemsDashboardLocalService carouselItemsDashboardLocalService) {

		_carouselItemsDashboardLocalService =
			carouselItemsDashboardLocalService;
	}

	/**
	 * Adds the carousel items dashboard to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarouselItemsDashboardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param carouselItemsDashboard the carousel items dashboard
	 * @return the carousel items dashboard that was added
	 */
	@Override
	public com.streaming.model.CarouselItemsDashboard addCarouselItemsDashboard(
		com.streaming.model.CarouselItemsDashboard carouselItemsDashboard) {

		return _carouselItemsDashboardLocalService.addCarouselItemsDashboard(
			carouselItemsDashboard);
	}

	/**
	 * Creates a new carousel items dashboard with the primary key. Does not add the carousel items dashboard to the database.
	 *
	 * @param categoryId the primary key for the new carousel items dashboard
	 * @return the new carousel items dashboard
	 */
	@Override
	public com.streaming.model.CarouselItemsDashboard
		createCarouselItemsDashboard(long categoryId) {

		return _carouselItemsDashboardLocalService.createCarouselItemsDashboard(
			categoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carouselItemsDashboardLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the carousel items dashboard from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarouselItemsDashboardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param carouselItemsDashboard the carousel items dashboard
	 * @return the carousel items dashboard that was removed
	 */
	@Override
	public com.streaming.model.CarouselItemsDashboard
		deleteCarouselItemsDashboard(
			com.streaming.model.CarouselItemsDashboard carouselItemsDashboard) {

		return _carouselItemsDashboardLocalService.deleteCarouselItemsDashboard(
			carouselItemsDashboard);
	}

	/**
	 * Deletes the carousel items dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarouselItemsDashboardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param categoryId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard that was removed
	 * @throws PortalException if a carousel items dashboard with the primary key could not be found
	 */
	@Override
	public com.streaming.model.CarouselItemsDashboard
			deleteCarouselItemsDashboard(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carouselItemsDashboardLocalService.deleteCarouselItemsDashboard(
			categoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carouselItemsDashboardLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _carouselItemsDashboardLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _carouselItemsDashboardLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _carouselItemsDashboardLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _carouselItemsDashboardLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.streaming.model.impl.CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _carouselItemsDashboardLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.streaming.model.impl.CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _carouselItemsDashboardLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _carouselItemsDashboardLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _carouselItemsDashboardLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.streaming.model.CarouselItemsDashboard
		fetchCarouselItemsDashboard(long categoryId) {

		return _carouselItemsDashboardLocalService.fetchCarouselItemsDashboard(
			categoryId);
	}

	@Override
	public com.streaming.model.CarouselItemsDashboard
		fetchCarouselItemsDashboardByExternalReferenceCode(
			String externalReferenceCode, long groupId) {

		return _carouselItemsDashboardLocalService.
			fetchCarouselItemsDashboardByExternalReferenceCode(
				externalReferenceCode, groupId);
	}

	/**
	 * Returns the carousel items dashboard matching the UUID and group.
	 *
	 * @param uuid the carousel items dashboard's UUID
	 * @param groupId the primary key of the group
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public com.streaming.model.CarouselItemsDashboard
		fetchCarouselItemsDashboardByUuidAndGroupId(String uuid, long groupId) {

		return _carouselItemsDashboardLocalService.
			fetchCarouselItemsDashboardByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _carouselItemsDashboardLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the carousel items dashboard with the primary key.
	 *
	 * @param categoryId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard
	 * @throws PortalException if a carousel items dashboard with the primary key could not be found
	 */
	@Override
	public com.streaming.model.CarouselItemsDashboard getCarouselItemsDashboard(
			long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carouselItemsDashboardLocalService.getCarouselItemsDashboard(
			categoryId);
	}

	@Override
	public com.streaming.model.CarouselItemsDashboard
			getCarouselItemsDashboardByExternalReferenceCode(
				String externalReferenceCode, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carouselItemsDashboardLocalService.
			getCarouselItemsDashboardByExternalReferenceCode(
				externalReferenceCode, groupId);
	}

	/**
	 * Returns the carousel items dashboard matching the UUID and group.
	 *
	 * @param uuid the carousel items dashboard's UUID
	 * @param groupId the primary key of the group
	 * @return the matching carousel items dashboard
	 * @throws PortalException if a matching carousel items dashboard could not be found
	 */
	@Override
	public com.streaming.model.CarouselItemsDashboard
			getCarouselItemsDashboardByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carouselItemsDashboardLocalService.
			getCarouselItemsDashboardByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the carousel items dashboards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.streaming.model.impl.CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @return the range of carousel items dashboards
	 */
	@Override
	public java.util.List<com.streaming.model.CarouselItemsDashboard>
		getCarouselItemsDashboards(int start, int end) {

		return _carouselItemsDashboardLocalService.getCarouselItemsDashboards(
			start, end);
	}

	/**
	 * Returns all the carousel items dashboards matching the UUID and company.
	 *
	 * @param uuid the UUID of the carousel items dashboards
	 * @param companyId the primary key of the company
	 * @return the matching carousel items dashboards, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.streaming.model.CarouselItemsDashboard>
		getCarouselItemsDashboardsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _carouselItemsDashboardLocalService.
			getCarouselItemsDashboardsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of carousel items dashboards matching the UUID and company.
	 *
	 * @param uuid the UUID of the carousel items dashboards
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching carousel items dashboards, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.streaming.model.CarouselItemsDashboard>
		getCarouselItemsDashboardsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.streaming.model.CarouselItemsDashboard>
					orderByComparator) {

		return _carouselItemsDashboardLocalService.
			getCarouselItemsDashboardsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of carousel items dashboards.
	 *
	 * @return the number of carousel items dashboards
	 */
	@Override
	public int getCarouselItemsDashboardsCount() {
		return _carouselItemsDashboardLocalService.
			getCarouselItemsDashboardsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _carouselItemsDashboardLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _carouselItemsDashboardLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _carouselItemsDashboardLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _carouselItemsDashboardLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the carousel items dashboard in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarouselItemsDashboardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param carouselItemsDashboard the carousel items dashboard
	 * @return the carousel items dashboard that was updated
	 */
	@Override
	public com.streaming.model.CarouselItemsDashboard
		updateCarouselItemsDashboard(
			com.streaming.model.CarouselItemsDashboard carouselItemsDashboard) {

		return _carouselItemsDashboardLocalService.updateCarouselItemsDashboard(
			carouselItemsDashboard);
	}

	@Override
	public CarouselItemsDashboardLocalService getWrappedService() {
		return _carouselItemsDashboardLocalService;
	}

	@Override
	public void setWrappedService(
		CarouselItemsDashboardLocalService carouselItemsDashboardLocalService) {

		_carouselItemsDashboardLocalService =
			carouselItemsDashboardLocalService;
	}

	private CarouselItemsDashboardLocalService
		_carouselItemsDashboardLocalService;

}