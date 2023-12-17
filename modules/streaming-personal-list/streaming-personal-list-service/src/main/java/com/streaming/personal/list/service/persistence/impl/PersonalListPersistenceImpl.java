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

package com.streaming.personal.list.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import com.streaming.personal.list.exception.NoSuchPersonalListException;
import com.streaming.personal.list.model.PersonalList;
import com.streaming.personal.list.model.PersonalListTable;
import com.streaming.personal.list.model.impl.PersonalListImpl;
import com.streaming.personal.list.model.impl.PersonalListModelImpl;
import com.streaming.personal.list.service.persistence.PersonalListPersistence;
import com.streaming.personal.list.service.persistence.PersonalListUtil;
import com.streaming.personal.list.service.persistence.impl.constants.PersonalListPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the personal list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PersonalListPersistence.class)
public class PersonalListPersistenceImpl
	extends BasePersistenceImpl<PersonalList>
	implements PersonalListPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersonalListUtil</code> to access the personal list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersonalListImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the personal lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching personal lists
	 */
	@Override
	public List<PersonalList> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersonalList> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<PersonalList> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersonalList> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<PersonalList> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersonalList> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<PersonalList> list = null;

		if (useFinderCache) {
			list = (List<PersonalList>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersonalList personalList : list) {
					if (!uuid.equals(personalList.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PERSONALLIST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersonalListModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<PersonalList>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	@Override
	public PersonalList findByUuid_First(
			String uuid, OrderByComparator<PersonalList> orderByComparator)
		throws NoSuchPersonalListException {

		PersonalList personalList = fetchByUuid_First(uuid, orderByComparator);

		if (personalList != null) {
			return personalList;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPersonalListException(sb.toString());
	}

	/**
	 * Returns the first personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	@Override
	public PersonalList fetchByUuid_First(
		String uuid, OrderByComparator<PersonalList> orderByComparator) {

		List<PersonalList> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	@Override
	public PersonalList findByUuid_Last(
			String uuid, OrderByComparator<PersonalList> orderByComparator)
		throws NoSuchPersonalListException {

		PersonalList personalList = fetchByUuid_Last(uuid, orderByComparator);

		if (personalList != null) {
			return personalList;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPersonalListException(sb.toString());
	}

	/**
	 * Returns the last personal list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	@Override
	public PersonalList fetchByUuid_Last(
		String uuid, OrderByComparator<PersonalList> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PersonalList> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersonalList[] findByUuid_PrevAndNext(
			long personalItemId, String uuid,
			OrderByComparator<PersonalList> orderByComparator)
		throws NoSuchPersonalListException {

		uuid = Objects.toString(uuid, "");

		PersonalList personalList = findByPrimaryKey(personalItemId);

		Session session = null;

		try {
			session = openSession();

			PersonalList[] array = new PersonalListImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, personalList, uuid, orderByComparator, true);

			array[1] = personalList;

			array[2] = getByUuid_PrevAndNext(
				session, personalList, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersonalList getByUuid_PrevAndNext(
		Session session, PersonalList personalList, String uuid,
		OrderByComparator<PersonalList> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PERSONALLIST_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PersonalListModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(personalList)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersonalList> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the personal lists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PersonalList personalList :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(personalList);
		}
	}

	/**
	 * Returns the number of personal lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching personal lists
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERSONALLIST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"personalList.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(personalList.uuid IS NULL OR personalList.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the personal list where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPersonalListException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	@Override
	public PersonalList findByUUID_G(String uuid, long groupId)
		throws NoSuchPersonalListException {

		PersonalList personalList = fetchByUUID_G(uuid, groupId);

		if (personalList == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPersonalListException(sb.toString());
		}

		return personalList;
	}

	/**
	 * Returns the personal list where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	@Override
	public PersonalList fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the personal list where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	@Override
	public PersonalList fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof PersonalList) {
			PersonalList personalList = (PersonalList)result;

			if (!Objects.equals(uuid, personalList.getUuid()) ||
				(groupId != personalList.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PERSONALLIST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<PersonalList> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					PersonalList personalList = list.get(0);

					result = personalList;

					cacheResult(personalList);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PersonalList)result;
		}
	}

	/**
	 * Removes the personal list where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the personal list that was removed
	 */
	@Override
	public PersonalList removeByUUID_G(String uuid, long groupId)
		throws NoSuchPersonalListException {

		PersonalList personalList = findByUUID_G(uuid, groupId);

		return remove(personalList);
	}

	/**
	 * Returns the number of personal lists where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching personal lists
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSONALLIST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"personalList.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(personalList.uuid IS NULL OR personalList.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"personalList.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the personal lists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching personal lists
	 */
	@Override
	public List<PersonalList> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersonalList> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<PersonalList> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersonalList> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<PersonalList> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersonalList> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<PersonalList> list = null;

		if (useFinderCache) {
			list = (List<PersonalList>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersonalList personalList : list) {
					if (!uuid.equals(personalList.getUuid()) ||
						(companyId != personalList.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PERSONALLIST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersonalListModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<PersonalList>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public PersonalList findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersonalList> orderByComparator)
		throws NoSuchPersonalListException {

		PersonalList personalList = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (personalList != null) {
			return personalList;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPersonalListException(sb.toString());
	}

	/**
	 * Returns the first personal list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	@Override
	public PersonalList fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersonalList> orderByComparator) {

		List<PersonalList> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersonalList findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersonalList> orderByComparator)
		throws NoSuchPersonalListException {

		PersonalList personalList = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (personalList != null) {
			return personalList;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPersonalListException(sb.toString());
	}

	/**
	 * Returns the last personal list in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	@Override
	public PersonalList fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersonalList> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PersonalList> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersonalList[] findByUuid_C_PrevAndNext(
			long personalItemId, String uuid, long companyId,
			OrderByComparator<PersonalList> orderByComparator)
		throws NoSuchPersonalListException {

		uuid = Objects.toString(uuid, "");

		PersonalList personalList = findByPrimaryKey(personalItemId);

		Session session = null;

		try {
			session = openSession();

			PersonalList[] array = new PersonalListImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, personalList, uuid, companyId, orderByComparator,
				true);

			array[1] = personalList;

			array[2] = getByUuid_C_PrevAndNext(
				session, personalList, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersonalList getByUuid_C_PrevAndNext(
		Session session, PersonalList personalList, String uuid, long companyId,
		OrderByComparator<PersonalList> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PERSONALLIST_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PersonalListModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(personalList)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersonalList> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the personal lists where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PersonalList personalList :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(personalList);
		}
	}

	/**
	 * Returns the number of personal lists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching personal lists
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSONALLIST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"personalList.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(personalList.uuid IS NULL OR personalList.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"personalList.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByPersonalList;
	private FinderPath _finderPathWithoutPaginationFindByPersonalList;
	private FinderPath _finderPathCountByPersonalList;

	/**
	 * Returns all the personal lists where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @return the matching personal lists
	 */
	@Override
	public List<PersonalList> findByPersonalList(long personalItemId) {
		return findByPersonalList(
			personalItemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersonalList> findByPersonalList(
		long personalItemId, int start, int end) {

		return findByPersonalList(personalItemId, start, end, null);
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
	@Override
	public List<PersonalList> findByPersonalList(
		long personalItemId, int start, int end,
		OrderByComparator<PersonalList> orderByComparator) {

		return findByPersonalList(
			personalItemId, start, end, orderByComparator, true);
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
	@Override
	public List<PersonalList> findByPersonalList(
		long personalItemId, int start, int end,
		OrderByComparator<PersonalList> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPersonalList;
				finderArgs = new Object[] {personalItemId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPersonalList;
			finderArgs = new Object[] {
				personalItemId, start, end, orderByComparator
			};
		}

		List<PersonalList> list = null;

		if (useFinderCache) {
			list = (List<PersonalList>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersonalList personalList : list) {
					if (personalItemId != personalList.getPersonalItemId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PERSONALLIST_WHERE);

			sb.append(_FINDER_COLUMN_PERSONALLIST_PERSONALITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersonalListModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(personalItemId);

				list = (List<PersonalList>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	@Override
	public PersonalList findByPersonalList_First(
			long personalItemId,
			OrderByComparator<PersonalList> orderByComparator)
		throws NoSuchPersonalListException {

		PersonalList personalList = fetchByPersonalList_First(
			personalItemId, orderByComparator);

		if (personalList != null) {
			return personalList;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("personalItemId=");
		sb.append(personalItemId);

		sb.append("}");

		throw new NoSuchPersonalListException(sb.toString());
	}

	/**
	 * Returns the first personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	@Override
	public PersonalList fetchByPersonalList_First(
		long personalItemId,
		OrderByComparator<PersonalList> orderByComparator) {

		List<PersonalList> list = findByPersonalList(
			personalItemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list
	 * @throws NoSuchPersonalListException if a matching personal list could not be found
	 */
	@Override
	public PersonalList findByPersonalList_Last(
			long personalItemId,
			OrderByComparator<PersonalList> orderByComparator)
		throws NoSuchPersonalListException {

		PersonalList personalList = fetchByPersonalList_Last(
			personalItemId, orderByComparator);

		if (personalList != null) {
			return personalList;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("personalItemId=");
		sb.append(personalItemId);

		sb.append("}");

		throw new NoSuchPersonalListException(sb.toString());
	}

	/**
	 * Returns the last personal list in the ordered set where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching personal list, or <code>null</code> if a matching personal list could not be found
	 */
	@Override
	public PersonalList fetchByPersonalList_Last(
		long personalItemId,
		OrderByComparator<PersonalList> orderByComparator) {

		int count = countByPersonalList(personalItemId);

		if (count == 0) {
			return null;
		}

		List<PersonalList> list = findByPersonalList(
			personalItemId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the personal lists where personalItemId = &#63; from the database.
	 *
	 * @param personalItemId the personal item ID
	 */
	@Override
	public void removeByPersonalList(long personalItemId) {
		for (PersonalList personalList :
				findByPersonalList(
					personalItemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(personalList);
		}
	}

	/**
	 * Returns the number of personal lists where personalItemId = &#63;.
	 *
	 * @param personalItemId the personal item ID
	 * @return the number of matching personal lists
	 */
	@Override
	public int countByPersonalList(long personalItemId) {
		FinderPath finderPath = _finderPathCountByPersonalList;

		Object[] finderArgs = new Object[] {personalItemId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERSONALLIST_WHERE);

			sb.append(_FINDER_COLUMN_PERSONALLIST_PERSONALITEMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(personalItemId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PERSONALLIST_PERSONALITEMID_2 =
		"personalList.personalItemId = ?";

	public PersonalListPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PersonalList.class);

		setModelImplClass(PersonalListImpl.class);
		setModelPKClass(long.class);

		setTable(PersonalListTable.INSTANCE);
	}

	/**
	 * Caches the personal list in the entity cache if it is enabled.
	 *
	 * @param personalList the personal list
	 */
	@Override
	public void cacheResult(PersonalList personalList) {
		entityCache.putResult(
			PersonalListImpl.class, personalList.getPrimaryKey(), personalList);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {personalList.getUuid(), personalList.getGroupId()},
			personalList);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the personal lists in the entity cache if it is enabled.
	 *
	 * @param personalLists the personal lists
	 */
	@Override
	public void cacheResult(List<PersonalList> personalLists) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (personalLists.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PersonalList personalList : personalLists) {
			if (entityCache.getResult(
					PersonalListImpl.class, personalList.getPrimaryKey()) ==
						null) {

				cacheResult(personalList);
			}
		}
	}

	/**
	 * Clears the cache for all personal lists.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersonalListImpl.class);

		finderCache.clearCache(PersonalListImpl.class);
	}

	/**
	 * Clears the cache for the personal list.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersonalList personalList) {
		entityCache.removeResult(PersonalListImpl.class, personalList);
	}

	@Override
	public void clearCache(List<PersonalList> personalLists) {
		for (PersonalList personalList : personalLists) {
			entityCache.removeResult(PersonalListImpl.class, personalList);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PersonalListImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PersonalListImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PersonalListModelImpl personalListModelImpl) {

		Object[] args = new Object[] {
			personalListModelImpl.getUuid(), personalListModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, personalListModelImpl);
	}

	/**
	 * Creates a new personal list with the primary key. Does not add the personal list to the database.
	 *
	 * @param personalItemId the primary key for the new personal list
	 * @return the new personal list
	 */
	@Override
	public PersonalList create(long personalItemId) {
		PersonalList personalList = new PersonalListImpl();

		personalList.setNew(true);
		personalList.setPrimaryKey(personalItemId);

		String uuid = _portalUUID.generate();

		personalList.setUuid(uuid);

		personalList.setCompanyId(CompanyThreadLocal.getCompanyId());

		return personalList;
	}

	/**
	 * Removes the personal list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personalItemId the primary key of the personal list
	 * @return the personal list that was removed
	 * @throws NoSuchPersonalListException if a personal list with the primary key could not be found
	 */
	@Override
	public PersonalList remove(long personalItemId)
		throws NoSuchPersonalListException {

		return remove((Serializable)personalItemId);
	}

	/**
	 * Removes the personal list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the personal list
	 * @return the personal list that was removed
	 * @throws NoSuchPersonalListException if a personal list with the primary key could not be found
	 */
	@Override
	public PersonalList remove(Serializable primaryKey)
		throws NoSuchPersonalListException {

		Session session = null;

		try {
			session = openSession();

			PersonalList personalList = (PersonalList)session.get(
				PersonalListImpl.class, primaryKey);

			if (personalList == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersonalListException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(personalList);
		}
		catch (NoSuchPersonalListException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PersonalList removeImpl(PersonalList personalList) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(personalList)) {
				personalList = (PersonalList)session.get(
					PersonalListImpl.class, personalList.getPrimaryKeyObj());
			}

			if (personalList != null) {
				session.delete(personalList);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (personalList != null) {
			clearCache(personalList);
		}

		return personalList;
	}

	@Override
	public PersonalList updateImpl(PersonalList personalList) {
		boolean isNew = personalList.isNew();

		if (!(personalList instanceof PersonalListModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(personalList.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					personalList);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in personalList proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersonalList implementation " +
					personalList.getClass());
		}

		PersonalListModelImpl personalListModelImpl =
			(PersonalListModelImpl)personalList;

		if (Validator.isNull(personalList.getUuid())) {
			String uuid = _portalUUID.generate();

			personalList.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (personalList.getCreateDate() == null)) {
			if (serviceContext == null) {
				personalList.setCreateDate(date);
			}
			else {
				personalList.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!personalListModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				personalList.setModifiedDate(date);
			}
			else {
				personalList.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(personalList);
			}
			else {
				personalList = (PersonalList)session.merge(personalList);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PersonalListImpl.class, personalListModelImpl, false, true);

		cacheUniqueFindersCache(personalListModelImpl);

		if (isNew) {
			personalList.setNew(false);
		}

		personalList.resetOriginalValues();

		return personalList;
	}

	/**
	 * Returns the personal list with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the personal list
	 * @return the personal list
	 * @throws NoSuchPersonalListException if a personal list with the primary key could not be found
	 */
	@Override
	public PersonalList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersonalListException {

		PersonalList personalList = fetchByPrimaryKey(primaryKey);

		if (personalList == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersonalListException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return personalList;
	}

	/**
	 * Returns the personal list with the primary key or throws a <code>NoSuchPersonalListException</code> if it could not be found.
	 *
	 * @param personalItemId the primary key of the personal list
	 * @return the personal list
	 * @throws NoSuchPersonalListException if a personal list with the primary key could not be found
	 */
	@Override
	public PersonalList findByPrimaryKey(long personalItemId)
		throws NoSuchPersonalListException {

		return findByPrimaryKey((Serializable)personalItemId);
	}

	/**
	 * Returns the personal list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personalItemId the primary key of the personal list
	 * @return the personal list, or <code>null</code> if a personal list with the primary key could not be found
	 */
	@Override
	public PersonalList fetchByPrimaryKey(long personalItemId) {
		return fetchByPrimaryKey((Serializable)personalItemId);
	}

	/**
	 * Returns all the personal lists.
	 *
	 * @return the personal lists
	 */
	@Override
	public List<PersonalList> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersonalList> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PersonalList> findAll(
		int start, int end, OrderByComparator<PersonalList> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PersonalList> findAll(
		int start, int end, OrderByComparator<PersonalList> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PersonalList> list = null;

		if (useFinderCache) {
			list = (List<PersonalList>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERSONALLIST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERSONALLIST;

				sql = sql.concat(PersonalListModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PersonalList>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the personal lists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersonalList personalList : findAll()) {
			remove(personalList);
		}
	}

	/**
	 * Returns the number of personal lists.
	 *
	 * @return the number of personal lists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PERSONALLIST);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "personalItemId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSONALLIST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersonalListModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the personal list persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByPersonalList = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPersonalList",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"personalItemId"}, true);

		_finderPathWithoutPaginationFindByPersonalList = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPersonalList",
			new String[] {Long.class.getName()},
			new String[] {"personalItemId"}, true);

		_finderPathCountByPersonalList = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPersonalList",
			new String[] {Long.class.getName()},
			new String[] {"personalItemId"}, false);

		_setPersonalListUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPersonalListUtilPersistence(null);

		entityCache.removeCache(PersonalListImpl.class.getName());
	}

	private void _setPersonalListUtilPersistence(
		PersonalListPersistence personalListPersistence) {

		try {
			Field field = PersonalListUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, personalListPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = PersonalListPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PersonalListPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PersonalListPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PERSONALLIST =
		"SELECT personalList FROM PersonalList personalList";

	private static final String _SQL_SELECT_PERSONALLIST_WHERE =
		"SELECT personalList FROM PersonalList personalList WHERE ";

	private static final String _SQL_COUNT_PERSONALLIST =
		"SELECT COUNT(personalList) FROM PersonalList personalList";

	private static final String _SQL_COUNT_PERSONALLIST_WHERE =
		"SELECT COUNT(personalList) FROM PersonalList personalList WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "personalList.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersonalList exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PersonalList exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PersonalListPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}