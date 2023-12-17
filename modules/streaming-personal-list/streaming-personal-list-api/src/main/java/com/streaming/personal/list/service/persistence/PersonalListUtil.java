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

package com.streaming.personal.list.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.streaming.personal.list.model.PersonalList;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the personal list service. This utility wraps <code>com.streaming.personal.list.service.persistence.impl.PersonalListPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonalListPersistence
 * @generated
 */
public class PersonalListUtil {

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
	public static void clearCache(PersonalList personalList) {
		getPersistence().clearCache(personalList);
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
	public static Map<Serializable, PersonalList> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersonalList> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersonalList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersonalList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersonalList> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersonalList update(PersonalList personalList) {
		return getPersistence().update(personalList);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersonalList update(
		PersonalList personalList, ServiceContext serviceContext) {

		return getPersistence().update(personalList, serviceContext);
	}

	/**
	 * Returns all the personal lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching personal lists
	 */
	public static List<PersonalList> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the personal lists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @return the range of matching personal lists
	 */
	public static List<PersonalList> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the personal lists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personal lists
	 */
	public static List<PersonalList> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersonalList> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personal lists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personal lists
	 */
	public static List<PersonalList> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersonalList> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public static PersonalList findByUuid_First(
			String uuid, OrderByComparator<PersonalList> orderByComparator)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public static PersonalList fetchByUuid_First(
		String uuid, OrderByComparator<PersonalList> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public static PersonalList findByUuid_Last(
			String uuid, OrderByComparator<PersonalList> orderByComparator)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public static PersonalList fetchByUuid_Last(
		String uuid, OrderByComparator<PersonalList> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the personal lists before and after the current personal list in the ordered set where uuid = &#63;.
	 *
	 * @param personalItemId the primary key of the current personal list
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next personal list
	 * @throws NoSuchPersonalListException if a personal list with the primary key could not be found
	 */
	public static PersonalList[] findByUuid_PrevAndNext(
			long personalItemId, String uuid,
			OrderByComparator<PersonalList> orderByComparator)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().findByUuid_PrevAndNext(
			personalItemId, uuid, orderByComparator);
	}

	/**
	 * Removes all the personal lists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of personal lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching personal lists
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the personal list where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPersonalListException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public static PersonalList findByUUID_G(String uuid, long groupId)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the personal list where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public static PersonalList fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the personal list where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public static PersonalList fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the personal list where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the personal list that was removed
	 */
	public static PersonalList removeByUUID_G(String uuid, long groupId)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of personal lists where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching personal lists
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the personal lists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching personal lists
	 */
	public static List<PersonalList> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the personal lists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @return the range of matching personal lists
	 */
	public static List<PersonalList> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the personal lists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personal lists
	 */
	public static List<PersonalList> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersonalList> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personal lists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personal lists
	 */
	public static List<PersonalList> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersonalList> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first personal list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public static PersonalList findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersonalList> orderByComparator)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first personal list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public static PersonalList fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersonalList> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last personal list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public static PersonalList findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersonalList> orderByComparator)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last personal list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public static PersonalList fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersonalList> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the personal lists before and after the current personal list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param personalItemId the primary key of the current personal list
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next personal list
	 * @throws NoSuchPersonalListException if a personal list with the primary key could not be found
	 */
	public static PersonalList[] findByUuid_C_PrevAndNext(
			long personalItemId, String uuid, long companyId,
			OrderByComparator<PersonalList> orderByComparator)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().findByUuid_C_PrevAndNext(
			personalItemId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the personal lists where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of personal lists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching personal lists
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the personal lists where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @return the matching personal lists
	 */
	public static List<PersonalList> findByPersonalList(long personalItemId) {
		return getPersistence().findByPersonalList(personalItemId);
	}

	/**
	 * Returns a range of all the personal lists where personalItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param personalItemId the personal item ID
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @return the range of matching personal lists
	 */
	public static List<PersonalList> findByPersonalList(
		long personalItemId, int start, int end) {

		return getPersistence().findByPersonalList(personalItemId, start, end);
	}

	/**
	 * Returns an ordered range of all the personal lists where personalItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param personalItemId the personal item ID
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching personal lists
	 */
	public static List<PersonalList> findByPersonalList(
		long personalItemId, int start, int end,
		OrderByComparator<PersonalList> orderByComparator) {

		return getPersistence().findByPersonalList(
			personalItemId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personal lists where personalItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param personalItemId the personal item ID
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching personal lists
	 */
	public static List<PersonalList> findByPersonalList(
		long personalItemId, int start, int end,
		OrderByComparator<PersonalList> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPersonalList(
			personalItemId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public static PersonalList findByPersonalList_First(
			long personalItemId,
			OrderByComparator<PersonalList> orderByComparator)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().findByPersonalList_First(
			personalItemId, orderByComparator);
	}

	/**
	 * Returns the first personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public static PersonalList fetchByPersonalList_First(
		long personalItemId,
		OrderByComparator<PersonalList> orderByComparator) {

		return getPersistence().fetchByPersonalList_First(
			personalItemId, orderByComparator);
	}

	/**
	 * Returns the last personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public static PersonalList findByPersonalList_Last(
			long personalItemId,
			OrderByComparator<PersonalList> orderByComparator)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().findByPersonalList_Last(
			personalItemId, orderByComparator);
	}

	/**
	 * Returns the last personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public static PersonalList fetchByPersonalList_Last(
		long personalItemId,
		OrderByComparator<PersonalList> orderByComparator) {

		return getPersistence().fetchByPersonalList_Last(
			personalItemId, orderByComparator);
	}

	/**
	 * Removes all the personal lists where personalItemId = &#63; from the database.
	 *
	 * @param personalItemId the personal item ID
	 */
	public static void removeByPersonalList(long personalItemId) {
		getPersistence().removeByPersonalList(personalItemId);
	}

	/**
	 * Returns the number of personal lists where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @return the number of matching personal lists
	 */
	public static int countByPersonalList(long personalItemId) {
		return getPersistence().countByPersonalList(personalItemId);
	}

	/**
	 * Caches the personal list in the entity cache if it is enabled.
	 *
	 * @param personalList the personal list
	 */
	public static void cacheResult(PersonalList personalList) {
		getPersistence().cacheResult(personalList);
	}

	/**
	 * Caches the personal lists in the entity cache if it is enabled.
	 *
	 * @param personalLists the personal lists
	 */
	public static void cacheResult(List<PersonalList> personalLists) {
		getPersistence().cacheResult(personalLists);
	}

	/**
	 * Creates a new personal list with the primary key. Does not add the personal list to the database.
	 *
	 * @param personalItemId the primary key for the new personal list
	 * @return the new personal list
	 */
	public static PersonalList create(long personalItemId) {
		return getPersistence().create(personalItemId);
	}

	/**
	 * Removes the personal list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personalItemId the primary key of the personal list
	 * @return the personal list that was removed
	 * @throws NoSuchPersonalListException if a personal list with the primary key could not be found
	 */
	public static PersonalList remove(long personalItemId)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().remove(personalItemId);
	}

	public static PersonalList updateImpl(PersonalList personalList) {
		return getPersistence().updateImpl(personalList);
	}

	/**
	 * Returns the personal list with the primary key or throws a <code>NoSuchPersonalListException</code> if it could not be found.
	 *
	 * @param personalItemId the primary key of the personal list
	 * @return the personal list
	 * @throws NoSuchPersonalListException if a personal list with the primary key could not be found
	 */
	public static PersonalList findByPrimaryKey(long personalItemId)
		throws com.streaming.personal.list.exception.
			NoSuchPersonalListException {

		return getPersistence().findByPrimaryKey(personalItemId);
	}

	/**
	 * Returns the personal list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personalItemId the primary key of the personal list
	 * @return the personal list, or <code>null</code> if a personal list with the primary key could not be found
	 */
	public static PersonalList fetchByPrimaryKey(long personalItemId) {
		return getPersistence().fetchByPrimaryKey(personalItemId);
	}

	/**
	 * Returns all the personal lists.
	 *
	 * @return the personal lists
	 */
	public static List<PersonalList> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the personal lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @return the range of personal lists
	 */
	public static List<PersonalList> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the personal lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of personal lists
	 */
	public static List<PersonalList> findAll(
		int start, int end, OrderByComparator<PersonalList> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personal lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of personal lists
	 */
	public static List<PersonalList> findAll(
		int start, int end, OrderByComparator<PersonalList> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the personal lists from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of personal lists.
	 *
	 * @return the number of personal lists
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PersonalListPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PersonalListPersistence _persistence;

}