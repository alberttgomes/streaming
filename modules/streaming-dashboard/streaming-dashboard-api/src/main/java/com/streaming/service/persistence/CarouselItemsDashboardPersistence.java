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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.streaming.exception.NoSuchCarouselItemsDashboardException;
import com.streaming.model.CarouselItemsDashboard;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the carousel items dashboard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CarouselItemsDashboardUtil
 * @generated
 */
@ProviderType
public interface CarouselItemsDashboardPersistence
	extends BasePersistence<CarouselItemsDashboard> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CarouselItemsDashboardUtil} to access the carousel items dashboard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the carousel items dashboards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching carousel items dashboards
	 */
	public java.util.List<CarouselItemsDashboard> findByUuid(String uuid);

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
	public java.util.List<CarouselItemsDashboard> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CarouselItemsDashboard> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator);

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
	public java.util.List<CarouselItemsDashboard> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator);

	/**
	 * Returns the last carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the last carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator);

	/**
	 * Returns the carousel items dashboards before and after the current carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current carousel items dashboard
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	public CarouselItemsDashboard[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Removes all the carousel items dashboards where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of carousel items dashboards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching carousel items dashboards
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the carousel items dashboard where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard findByUUID_G(String uuid, long groupId)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the carousel items dashboard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the carousel items dashboard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the carousel items dashboard where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the carousel items dashboard that was removed
	 */
	public CarouselItemsDashboard removeByUUID_G(String uuid, long groupId)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the number of carousel items dashboards where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching carousel items dashboards
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the carousel items dashboards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching carousel items dashboards
	 */
	public java.util.List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator);

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
	public java.util.List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator);

	/**
	 * Returns the last carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the last carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator);

	/**
	 * Returns the carousel items dashboards before and after the current carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current carousel items dashboard
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	public CarouselItemsDashboard[] findByUuid_C_PrevAndNext(
			long categoryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Removes all the carousel items dashboards where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of carousel items dashboards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching carousel items dashboards
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard findByDeleteCarouselItems(
			long groupId, long categoryId)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByDeleteCarouselItems(
		long groupId, long categoryId);

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByDeleteCarouselItems(
		long groupId, long categoryId, boolean useFinderCache);

	/**
	 * Removes the carousel items dashboard where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the carousel items dashboard that was removed
	 */
	public CarouselItemsDashboard removeByDeleteCarouselItems(
			long groupId, long categoryId)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the number of carousel items dashboards where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching carousel items dashboards
	 */
	public int countByDeleteCarouselItems(long groupId, long categoryId);

	/**
	 * Returns all the carousel items dashboards where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching carousel items dashboards
	 */
	public java.util.List<CarouselItemsDashboard> findByGetCarouselItems(
		long groupId, long categoryId);

	/**
	 * Returns a range of all the carousel items dashboards where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @return the range of matching carousel items dashboards
	 */
	public java.util.List<CarouselItemsDashboard> findByGetCarouselItems(
		long groupId, long categoryId, int start, int end);

	/**
	 * Returns an ordered range of all the carousel items dashboards where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching carousel items dashboards
	 */
	public java.util.List<CarouselItemsDashboard> findByGetCarouselItems(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator);

	/**
	 * Returns an ordered range of all the carousel items dashboards where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching carousel items dashboards
	 */
	public java.util.List<CarouselItemsDashboard> findByGetCarouselItems(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first carousel items dashboard in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard findByGetCarouselItems_First(
			long groupId, long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the first carousel items dashboard in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByGetCarouselItems_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator);

	/**
	 * Returns the last carousel items dashboard in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard findByGetCarouselItems_Last(
			long groupId, long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the last carousel items dashboard in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByGetCarouselItems_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator);

	/**
	 * Removes all the carousel items dashboards where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 */
	public void removeByGetCarouselItems(long groupId, long categoryId);

	/**
	 * Returns the number of carousel items dashboards where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching carousel items dashboards
	 */
	public int countByGetCarouselItems(long groupId, long categoryId);

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard findByGetCarouselItemById(
			long groupId, long categoryId)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByGetCarouselItemById(
		long groupId, long categoryId);

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByGetCarouselItemById(
		long groupId, long categoryId, boolean useFinderCache);

	/**
	 * Removes the carousel items dashboard where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the carousel items dashboard that was removed
	 */
	public CarouselItemsDashboard removeByGetCarouselItemById(
			long groupId, long categoryId)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the number of carousel items dashboards where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching carousel items dashboards
	 */
	public int countByGetCarouselItemById(long groupId, long categoryId);

	/**
	 * Returns the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard findByERC_G(
			String externalReferenceCode, long groupId)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByERC_G(
		String externalReferenceCode, long groupId);

	/**
	 * Returns the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	public CarouselItemsDashboard fetchByERC_G(
		String externalReferenceCode, long groupId, boolean useFinderCache);

	/**
	 * Removes the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; from the database.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the carousel items dashboard that was removed
	 */
	public CarouselItemsDashboard removeByERC_G(
			String externalReferenceCode, long groupId)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the number of carousel items dashboards where externalReferenceCode = &#63; and groupId = &#63;.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the number of matching carousel items dashboards
	 */
	public int countByERC_G(String externalReferenceCode, long groupId);

	/**
	 * Caches the carousel items dashboard in the entity cache if it is enabled.
	 *
	 * @param carouselItemsDashboard the carousel items dashboard
	 */
	public void cacheResult(CarouselItemsDashboard carouselItemsDashboard);

	/**
	 * Caches the carousel items dashboards in the entity cache if it is enabled.
	 *
	 * @param carouselItemsDashboards the carousel items dashboards
	 */
	public void cacheResult(
		java.util.List<CarouselItemsDashboard> carouselItemsDashboards);

	/**
	 * Creates a new carousel items dashboard with the primary key. Does not add the carousel items dashboard to the database.
	 *
	 * @param categoryId the primary key for the new carousel items dashboard
	 * @return the new carousel items dashboard
	 */
	public CarouselItemsDashboard create(long categoryId);

	/**
	 * Removes the carousel items dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard that was removed
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	public CarouselItemsDashboard remove(long categoryId)
		throws NoSuchCarouselItemsDashboardException;

	public CarouselItemsDashboard updateImpl(
		CarouselItemsDashboard carouselItemsDashboard);

	/**
	 * Returns the carousel items dashboard with the primary key or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	public CarouselItemsDashboard findByPrimaryKey(long categoryId)
		throws NoSuchCarouselItemsDashboardException;

	/**
	 * Returns the carousel items dashboard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard, or <code>null</code> if a carousel items dashboard with the primary key could not be found
	 */
	public CarouselItemsDashboard fetchByPrimaryKey(long categoryId);

	/**
	 * Returns all the carousel items dashboards.
	 *
	 * @return the carousel items dashboards
	 */
	public java.util.List<CarouselItemsDashboard> findAll();

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
	public java.util.List<CarouselItemsDashboard> findAll(int start, int end);

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
	public java.util.List<CarouselItemsDashboard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator);

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
	public java.util.List<CarouselItemsDashboard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CarouselItemsDashboard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the carousel items dashboards from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of carousel items dashboards.
	 *
	 * @return the number of carousel items dashboards
	 */
	public int countAll();

}