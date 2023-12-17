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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.streaming.personal.list.exception.NoSuchPersonalListException;
import com.streaming.personal.list.model.PersonalList;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the personal list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonalListUtil
 * @generated
 */
@ProviderType
public interface PersonalListPersistence extends BasePersistence<PersonalList> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersonalListUtil} to access the personal list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the personal lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching personal lists
	 */
	public java.util.List<PersonalList> findByUuid(String uuid);

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
	public java.util.List<PersonalList> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<PersonalList> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator);

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
	public java.util.List<PersonalList> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public PersonalList findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
				orderByComparator)
		throws NoSuchPersonalListException;

	/**
	 * Returns the first personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public PersonalList fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator);

	/**
	 * Returns the last personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public PersonalList findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
				orderByComparator)
		throws NoSuchPersonalListException;

	/**
	 * Returns the last personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public PersonalList fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator);

	/**
	 * Returns the personal lists before and after the current personal list in the ordered set where uuid = &#63;.
	 *
	 * @param personalItemId the primary key of the current personal list
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next personal list
	 * @throws NoSuchPersonalListException if a personal list with the primary key could not be found
	 */
	public PersonalList[] findByUuid_PrevAndNext(
			long personalItemId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
				orderByComparator)
		throws NoSuchPersonalListException;

	/**
	 * Removes all the personal lists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of personal lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching personal lists
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the personal list where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPersonalListException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public PersonalList findByUUID_G(String uuid, long groupId)
		throws NoSuchPersonalListException;

	/**
	 * Returns the personal list where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public PersonalList fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the personal list where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public PersonalList fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the personal list where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the personal list that was removed
	 */
	public PersonalList removeByUUID_G(String uuid, long groupId)
		throws NoSuchPersonalListException;

	/**
	 * Returns the number of personal lists where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching personal lists
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the personal lists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching personal lists
	 */
	public java.util.List<PersonalList> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<PersonalList> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<PersonalList> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator);

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
	public java.util.List<PersonalList> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first personal list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public PersonalList findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
				orderByComparator)
		throws NoSuchPersonalListException;

	/**
	 * Returns the first personal list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public PersonalList fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator);

	/**
	 * Returns the last personal list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public PersonalList findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
				orderByComparator)
		throws NoSuchPersonalListException;

	/**
	 * Returns the last personal list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public PersonalList fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator);

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
	public PersonalList[] findByUuid_C_PrevAndNext(
			long personalItemId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
				orderByComparator)
		throws NoSuchPersonalListException;

	/**
	 * Removes all the personal lists where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of personal lists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching personal lists
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the personal lists where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @return the matching personal lists
	 */
	public java.util.List<PersonalList> findByPersonalList(long personalItemId);

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
	public java.util.List<PersonalList> findByPersonalList(
		long personalItemId, int start, int end);

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
	public java.util.List<PersonalList> findByPersonalList(
		long personalItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator);

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
	public java.util.List<PersonalList> findByPersonalList(
		long personalItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public PersonalList findByPersonalList_First(
			long personalItemId,
			com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
				orderByComparator)
		throws NoSuchPersonalListException;

	/**
	 * Returns the first personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public PersonalList fetchByPersonalList_First(
		long personalItemId,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator);

	/**
	 * Returns the last personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	public PersonalList findByPersonalList_Last(
			long personalItemId,
			com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
				orderByComparator)
		throws NoSuchPersonalListException;

	/**
	 * Returns the last personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public PersonalList fetchByPersonalList_Last(
		long personalItemId,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator);

	/**
	 * Removes all the personal lists where personalItemId = &#63; from the database.
	 *
	 * @param personalItemId the personal item ID
	 */
	public void removeByPersonalList(long personalItemId);

	/**
	 * Returns the number of personal lists where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @return the number of matching personal lists
	 */
	public int countByPersonalList(long personalItemId);

	/**
	 * Caches the personal list in the entity cache if it is enabled.
	 *
	 * @param personalList the personal list
	 */
	public void cacheResult(PersonalList personalList);

	/**
	 * Caches the personal lists in the entity cache if it is enabled.
	 *
	 * @param personalLists the personal lists
	 */
	public void cacheResult(java.util.List<PersonalList> personalLists);

	/**
	 * Creates a new personal list with the primary key. Does not add the personal list to the database.
	 *
	 * @param personalItemId the primary key for the new personal list
	 * @return the new personal list
	 */
	public PersonalList create(long personalItemId);

	/**
	 * Removes the personal list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personalItemId the primary key of the personal list
	 * @return the personal list that was removed
	 * @throws NoSuchPersonalListException if a personal list with the primary key could not be found
	 */
	public PersonalList remove(long personalItemId)
		throws NoSuchPersonalListException;

	public PersonalList updateImpl(PersonalList personalList);

	/**
	 * Returns the personal list with the primary key or throws a <code>NoSuchPersonalListException</code> if it could not be found.
	 *
	 * @param personalItemId the primary key of the personal list
	 * @return the personal list
	 * @throws NoSuchPersonalListException if a personal list with the primary key could not be found
	 */
	public PersonalList findByPrimaryKey(long personalItemId)
		throws NoSuchPersonalListException;

	/**
	 * Returns the personal list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personalItemId the primary key of the personal list
	 * @return the personal list, or <code>null</code> if a personal list with the primary key could not be found
	 */
	public PersonalList fetchByPrimaryKey(long personalItemId);

	/**
	 * Returns all the personal lists.
	 *
	 * @return the personal lists
	 */
	public java.util.List<PersonalList> findAll();

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
	public java.util.List<PersonalList> findAll(int start, int end);

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
	public java.util.List<PersonalList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator);

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
	public java.util.List<PersonalList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersonalList>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the personal lists from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of personal lists.
	 *
	 * @return the number of personal lists
	 */
	public int countAll();

}