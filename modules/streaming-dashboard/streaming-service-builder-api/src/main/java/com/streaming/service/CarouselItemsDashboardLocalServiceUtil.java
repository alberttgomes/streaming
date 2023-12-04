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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.streaming.model.CarouselItemsDashboard;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CarouselItemsDashboard. This utility wraps
 * <code>com.streaming.service.impl.CarouselItemsDashboardLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CarouselItemsDashboardLocalService
 * @generated
 */
public class CarouselItemsDashboardLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.streaming.service.impl.CarouselItemsDashboardLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static CarouselItemsDashboard addCarouselItemsDashboard(
		CarouselItemsDashboard carouselItemsDashboard) {

		return getService().addCarouselItemsDashboard(carouselItemsDashboard);
	}

	/**
	 * Creates a new carousel items dashboard with the primary key. Does not add the carousel items dashboard to the database.
	 *
	 * @param streamingId the primary key for the new carousel items dashboard
	 * @return the new carousel items dashboard
	 */
	public static CarouselItemsDashboard createCarouselItemsDashboard(
		long streamingId) {

		return getService().createCarouselItemsDashboard(streamingId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static CarouselItemsDashboard deleteCarouselItemsDashboard(
		CarouselItemsDashboard carouselItemsDashboard) {

		return getService().deleteCarouselItemsDashboard(
			carouselItemsDashboard);
	}

	/**
	 * Deletes the carousel items dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarouselItemsDashboardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param streamingId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard that was removed
	 * @throws PortalException if a carousel items dashboard with the primary key could not be found
	 */
	public static CarouselItemsDashboard deleteCarouselItemsDashboard(
			long streamingId)
		throws PortalException {

		return getService().deleteCarouselItemsDashboard(streamingId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CarouselItemsDashboard fetchCarouselItemsDashboard(
		long streamingId) {

		return getService().fetchCarouselItemsDashboard(streamingId);
	}

	public static CarouselItemsDashboard
		fetchCarouselItemsDashboardByExternalReferenceCode(
			String externalReferenceCode, long groupId) {

		return getService().fetchCarouselItemsDashboardByExternalReferenceCode(
			externalReferenceCode, groupId);
	}

	/**
	 * Returns the carousel items dashboard matching the UUID and group.
	 *
	 * @param uuid the carousel items dashboard's UUID
	 * @param groupId the primary key of the group
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard
		fetchCarouselItemsDashboardByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchCarouselItemsDashboardByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the carousel items dashboard with the primary key.
	 *
	 * @param streamingId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard
	 * @throws PortalException if a carousel items dashboard with the primary key could not be found
	 */
	public static CarouselItemsDashboard getCarouselItemsDashboard(
			long streamingId)
		throws PortalException {

		return getService().getCarouselItemsDashboard(streamingId);
	}

	public static CarouselItemsDashboard
			getCarouselItemsDashboardByExternalReferenceCode(
				String externalReferenceCode, long groupId)
		throws PortalException {

		return getService().getCarouselItemsDashboardByExternalReferenceCode(
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
	public static CarouselItemsDashboard
			getCarouselItemsDashboardByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getCarouselItemsDashboardByUuidAndGroupId(
			uuid, groupId);
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
	public static List<CarouselItemsDashboard> getCarouselItemsDashboards(
		int start, int end) {

		return getService().getCarouselItemsDashboards(start, end);
	}

	/**
	 * Returns all the carousel items dashboards matching the UUID and company.
	 *
	 * @param uuid the UUID of the carousel items dashboards
	 * @param companyId the primary key of the company
	 * @return the matching carousel items dashboards, or an empty list if no matches were found
	 */
	public static List<CarouselItemsDashboard>
		getCarouselItemsDashboardsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getCarouselItemsDashboardsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<CarouselItemsDashboard>
		getCarouselItemsDashboardsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getService().getCarouselItemsDashboardsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of carousel items dashboards.
	 *
	 * @return the number of carousel items dashboards
	 */
	public static int getCarouselItemsDashboardsCount() {
		return getService().getCarouselItemsDashboardsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static CarouselItemsDashboard updateCarouselItemsDashboard(
		CarouselItemsDashboard carouselItemsDashboard) {

		return getService().updateCarouselItemsDashboard(
			carouselItemsDashboard);
	}

	public static CarouselItemsDashboardLocalService getService() {
		return _service;
	}

	private static volatile CarouselItemsDashboardLocalService _service;

}