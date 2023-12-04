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

package com.streaming.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.streaming.model.CarouselItemsDashboard;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the carousel items dashboard service. This utility wraps <code>com.streaming.service.persistence.impl.CarouselItemsDashboardPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CarouselItemsDashboardPersistence
 * @generated
 */
public class CarouselItemsDashboardUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		CarouselItemsDashboard carouselItemsDashboard) {

		getPersistence().clearCache(carouselItemsDashboard);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CarouselItemsDashboard> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CarouselItemsDashboard> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CarouselItemsDashboard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CarouselItemsDashboard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CarouselItemsDashboard update(
		CarouselItemsDashboard carouselItemsDashboard) {

		return getPersistence().update(carouselItemsDashboard);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CarouselItemsDashboard update(
		CarouselItemsDashboard carouselItemsDashboard,
		ServiceContext serviceContext) {

		return getPersistence().update(carouselItemsDashboard, serviceContext);
	}

	/**
	 * Returns all the carousel items dashboards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the carousel items dashboards where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @return the range of matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the carousel items dashboards where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the carousel items dashboards where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard findByUuid_First(
			String uuid,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByUuid_First(
		String uuid,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard findByUuid_Last(
			String uuid,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByUuid_Last(
		String uuid,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the carousel items dashboards before and after the current carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param streamingId the primary key of the current carousel items dashboard
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	public static CarouselItemsDashboard[] findByUuid_PrevAndNext(
			long streamingId, String uuid,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByUuid_PrevAndNext(
			streamingId, uuid, orderByComparator);
	}

	/**
	 * Removes all the carousel items dashboards where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of carousel items dashboards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching carousel items dashboards
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the carousel items dashboard where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard findByUUID_G(String uuid, long groupId)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the carousel items dashboard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the carousel items dashboard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the carousel items dashboard where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the carousel items dashboard that was removed
	 */
	public static CarouselItemsDashboard removeByUUID_G(
			String uuid, long groupId)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of carousel items dashboards where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching carousel items dashboards
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the carousel items dashboards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the carousel items dashboards where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @return the range of matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the carousel items dashboards where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the carousel items dashboards where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the carousel items dashboards before and after the current carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param streamingId the primary key of the current carousel items dashboard
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	public static CarouselItemsDashboard[] findByUuid_C_PrevAndNext(
			long streamingId, String uuid, long companyId,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByUuid_C_PrevAndNext(
			streamingId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the carousel items dashboards where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of carousel items dashboards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching carousel items dashboards
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the carousel items dashboards where companyId = &#63; and groupId = &#63; and streamingId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @return the matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByGetCarouselItems(
		long companyId, long groupId, long streamingId) {

		return getPersistence().findByGetCarouselItems(
			companyId, groupId, streamingId);
	}

	/**
	 * Returns a range of all the carousel items dashboards where companyId = &#63; and groupId = &#63; and streamingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @return the range of matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByGetCarouselItems(
		long companyId, long groupId, long streamingId, int start, int end) {

		return getPersistence().findByGetCarouselItems(
			companyId, groupId, streamingId, start, end);
	}

	/**
	 * Returns an ordered range of all the carousel items dashboards where companyId = &#63; and groupId = &#63; and streamingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByGetCarouselItems(
		long companyId, long groupId, long streamingId, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getPersistence().findByGetCarouselItems(
			companyId, groupId, streamingId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the carousel items dashboards where companyId = &#63; and groupId = &#63; and streamingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findByGetCarouselItems(
		long companyId, long groupId, long streamingId, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGetCarouselItems(
			companyId, groupId, streamingId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first carousel items dashboard in the ordered set where companyId = &#63; and groupId = &#63; and streamingId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard findByGetCarouselItems_First(
			long companyId, long groupId, long streamingId,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByGetCarouselItems_First(
			companyId, groupId, streamingId, orderByComparator);
	}

	/**
	 * Returns the first carousel items dashboard in the ordered set where companyId = &#63; and groupId = &#63; and streamingId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByGetCarouselItems_First(
		long companyId, long groupId, long streamingId,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getPersistence().fetchByGetCarouselItems_First(
			companyId, groupId, streamingId, orderByComparator);
	}

	/**
	 * Returns the last carousel items dashboard in the ordered set where companyId = &#63; and groupId = &#63; and streamingId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard findByGetCarouselItems_Last(
			long companyId, long groupId, long streamingId,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByGetCarouselItems_Last(
			companyId, groupId, streamingId, orderByComparator);
	}

	/**
	 * Returns the last carousel items dashboard in the ordered set where companyId = &#63; and groupId = &#63; and streamingId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByGetCarouselItems_Last(
		long companyId, long groupId, long streamingId,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getPersistence().fetchByGetCarouselItems_Last(
			companyId, groupId, streamingId, orderByComparator);
	}

	/**
	 * Removes all the carousel items dashboards where companyId = &#63; and groupId = &#63; and streamingId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 */
	public static void removeByGetCarouselItems(
		long companyId, long groupId, long streamingId) {

		getPersistence().removeByGetCarouselItems(
			companyId, groupId, streamingId);
	}

	/**
	 * Returns the number of carousel items dashboards where companyId = &#63; and groupId = &#63; and streamingId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @return the number of matching carousel items dashboards
	 */
	public static int countByGetCarouselItems(
		long companyId, long groupId, long streamingId) {

		return getPersistence().countByGetCarouselItems(
			companyId, groupId, streamingId);
	}

	/**
	 * Returns the carousel items dashboard where companyId = &#63; and groupId = &#63; and streamingId = &#63; or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @return the matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard findByGetCarouselItem(
			long companyId, long groupId, long streamingId)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByGetCarouselItem(
			companyId, groupId, streamingId);
	}

	/**
	 * Returns the carousel items dashboard where companyId = &#63; and groupId = &#63; and streamingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByGetCarouselItem(
		long companyId, long groupId, long streamingId) {

		return getPersistence().fetchByGetCarouselItem(
			companyId, groupId, streamingId);
	}

	/**
	 * Returns the carousel items dashboard where companyId = &#63; and groupId = &#63; and streamingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByGetCarouselItem(
		long companyId, long groupId, long streamingId,
		boolean useFinderCache) {

		return getPersistence().fetchByGetCarouselItem(
			companyId, groupId, streamingId, useFinderCache);
	}

	/**
	 * Removes the carousel items dashboard where companyId = &#63; and groupId = &#63; and streamingId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @return the carousel items dashboard that was removed
	 */
	public static CarouselItemsDashboard removeByGetCarouselItem(
			long companyId, long groupId, long streamingId)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().removeByGetCarouselItem(
			companyId, groupId, streamingId);
	}

	/**
	 * Returns the number of carousel items dashboards where companyId = &#63; and groupId = &#63; and streamingId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param streamingId the streaming ID
	 * @return the number of matching carousel items dashboards
	 */
	public static int countByGetCarouselItem(
		long companyId, long groupId, long streamingId) {

		return getPersistence().countByGetCarouselItem(
			companyId, groupId, streamingId);
	}

	/**
	 * Returns the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard findByERC_G(
			String externalReferenceCode, long groupId)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByERC_G(externalReferenceCode, groupId);
	}

	/**
	 * Returns the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByERC_G(
		String externalReferenceCode, long groupId) {

		return getPersistence().fetchByERC_G(externalReferenceCode, groupId);
	}

	/**
	 * Returns the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public static CarouselItemsDashboard fetchByERC_G(
		String externalReferenceCode, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByERC_G(
			externalReferenceCode, groupId, useFinderCache);
	}

	/**
	 * Removes the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; from the database.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the carousel items dashboard that was removed
	 */
	public static CarouselItemsDashboard removeByERC_G(
			String externalReferenceCode, long groupId)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().removeByERC_G(externalReferenceCode, groupId);
	}

	/**
	 * Returns the number of carousel items dashboards where externalReferenceCode = &#63; and groupId = &#63;.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the number of matching carousel items dashboards
	 */
	public static int countByERC_G(String externalReferenceCode, long groupId) {
		return getPersistence().countByERC_G(externalReferenceCode, groupId);
	}

	/**
	 * Caches the carousel items dashboard in the entity cache if it is enabled.
	 *
	 * @param carouselItemsDashboard the carousel items dashboard
	 */
	public static void cacheResult(
		CarouselItemsDashboard carouselItemsDashboard) {

		getPersistence().cacheResult(carouselItemsDashboard);
	}

	/**
	 * Caches the carousel items dashboards in the entity cache if it is enabled.
	 *
	 * @param carouselItemsDashboards the carousel items dashboards
	 */
	public static void cacheResult(
		List<CarouselItemsDashboard> carouselItemsDashboards) {

		getPersistence().cacheResult(carouselItemsDashboards);
	}

	/**
	 * Creates a new carousel items dashboard with the primary key. Does not add the carousel items dashboard to the database.
	 *
	 * @param streamingId the primary key for the new carousel items dashboard
	 * @return the new carousel items dashboard
	 */
	public static CarouselItemsDashboard create(long streamingId) {
		return getPersistence().create(streamingId);
	}

	/**
	 * Removes the carousel items dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param streamingId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard that was removed
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	public static CarouselItemsDashboard remove(long streamingId)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().remove(streamingId);
	}

	public static CarouselItemsDashboard updateImpl(
		CarouselItemsDashboard carouselItemsDashboard) {

		return getPersistence().updateImpl(carouselItemsDashboard);
	}

	/**
	 * Returns the carousel items dashboard with the primary key or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param streamingId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	public static CarouselItemsDashboard findByPrimaryKey(long streamingId)
		throws com.streaming.exception.NoSuchCarouselItemsDashboardException {

		return getPersistence().findByPrimaryKey(streamingId);
	}

	/**
	 * Returns the carousel items dashboard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param streamingId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard, or <code>null</code> if a carousel items dashboard with the primary key could not be found
	 */
	public static CarouselItemsDashboard fetchByPrimaryKey(long streamingId) {
		return getPersistence().fetchByPrimaryKey(streamingId);
	}

	/**
	 * Returns all the carousel items dashboards.
	 *
	 * @return the carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the carousel items dashboards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @return the range of carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the carousel items dashboards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findAll(
		int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the carousel items dashboards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of carousel items dashboards
	 */
	public static List<CarouselItemsDashboard> findAll(
		int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the carousel items dashboards from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of carousel items dashboards.
	 *
	 * @return the number of carousel items dashboards
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CarouselItemsDashboardPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CarouselItemsDashboardPersistence _persistence;

}