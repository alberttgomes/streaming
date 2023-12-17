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

package com.streaming.personal.list.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.streaming.personal.list.model.PersonalList;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PersonalList. This utility wraps
 * <code>com.streaming.personal.list.service.impl.PersonalListLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersonalListLocalService
 * @generated
 */
public class PersonalListLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.streaming.personal.list.service.impl.PersonalListLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the personal list to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalList the personal list
	 * @return the personal list that was added
	 */
	public static PersonalList addPersonalList(PersonalList personalList) {
		return getService().addPersonalList(personalList);
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
	 * Creates a new personal list with the primary key. Does not add the personal list to the database.
	 *
	 * @param personalItemId the primary key for the new personal list
	 * @return the new personal list
	 */
	public static PersonalList createPersonalList(long personalItemId) {
		return getService().createPersonalList(personalItemId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the personal list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalItemId the primary key of the personal list
	 * @return the personal list that was removed
	 * @throws PortalException if a personal list with the primary key could not be found
	 */
	public static PersonalList deletePersonalList(long personalItemId)
		throws PortalException {

		return getService().deletePersonalList(personalItemId);
	}

	/**
	 * Deletes the personal list from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalList the personal list
	 * @return the personal list that was removed
	 */
	public static PersonalList deletePersonalList(PersonalList personalList) {
		return getService().deletePersonalList(personalList);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.streaming.personal.list.model.impl.PersonalListModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.streaming.personal.list.model.impl.PersonalListModelImpl</code>.
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

	public static PersonalList fetchPersonalList(long personalItemId) {
		return getService().fetchPersonalList(personalItemId);
	}

	/**
	 * Returns the personal list matching the UUID and group.
	 *
	 * @param uuid the personal list's UUID
	 * @param groupId the primary key of the group
	 * @return the matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	public static PersonalList fetchPersonalListByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPersonalListByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the personal list with the primary key.
	 *
	 * @param personalItemId the primary key of the personal list
	 * @return the personal list
	 * @throws PortalException if a personal list with the primary key could not be found
	 */
	public static PersonalList getPersonalList(long personalItemId)
		throws PortalException {

		return getService().getPersonalList(personalItemId);
	}

	/**
	 * Returns the personal list matching the UUID and group.
	 *
	 * @param uuid the personal list's UUID
	 * @param groupId the primary key of the group
	 * @return the matching personal list
	 * @throws PortalException if a matching personal list could not be found
	 */
	public static PersonalList getPersonalListByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPersonalListByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the personal lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.streaming.personal.list.model.impl.PersonalListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @return the range of personal lists
	 */
	public static List<PersonalList> getPersonalLists(int start, int end) {
		return getService().getPersonalLists(start, end);
	}

	/**
	 * Returns all the personal lists matching the UUID and company.
	 *
	 * @param uuid the UUID of the personal lists
	 * @param companyId the primary key of the company
	 * @return the matching personal lists, or an empty list if no matches were found
	 */
	public static List<PersonalList> getPersonalListsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPersonalListsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of personal lists matching the UUID and company.
	 *
	 * @param uuid the UUID of the personal lists
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of personal lists
	 * @param end the upper bound of the range of personal lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching personal lists, or an empty list if no matches were found
	 */
	public static List<PersonalList> getPersonalListsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersonalList> orderByComparator) {

		return getService().getPersonalListsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of personal lists.
	 *
	 * @return the number of personal lists
	 */
	public static int getPersonalListsCount() {
		return getService().getPersonalListsCount();
	}

	/**
	 * Updates the personal list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalList the personal list
	 * @return the personal list that was updated
	 */
	public static PersonalList updatePersonalList(PersonalList personalList) {
		return getService().updatePersonalList(personalList);
	}

	public static PersonalListLocalService getService() {
		return _service;
	}

	private static volatile PersonalListLocalService _service;

}