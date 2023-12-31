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

package com.streaming.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import com.streaming.exception.DuplicateCarouselItemsDashboardExternalReferenceCodeException;
import com.streaming.exception.NoSuchCarouselItemsDashboardException;
import com.streaming.model.CarouselItemsDashboard;
import com.streaming.model.CarouselItemsDashboardTable;
import com.streaming.model.impl.CarouselItemsDashboardImpl;
import com.streaming.model.impl.CarouselItemsDashboardModelImpl;
import com.streaming.service.persistence.CarouselItemsDashboardPersistence;
import com.streaming.service.persistence.CarouselItemsDashboardUtil;
import com.streaming.service.persistence.impl.constants.CarouselItemsDashboardPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the carousel items dashboard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CarouselItemsDashboardPersistence.class)
public class CarouselItemsDashboardPersistenceImpl
	extends BasePersistenceImpl<CarouselItemsDashboard>
	implements CarouselItemsDashboardPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CarouselItemsDashboardUtil</code> to access the carousel items dashboard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CarouselItemsDashboardImpl.class.getName();

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
	 * Returns all the carousel items dashboards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching carousel items dashboards
	 */
	@Override
	public List<CarouselItemsDashboard> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CarouselItemsDashboard> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CarouselItemsDashboard> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CarouselItemsDashboard> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator,
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

		List<CarouselItemsDashboard> list = null;

		if (useFinderCache) {
			list = (List<CarouselItemsDashboard>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CarouselItemsDashboard carouselItemsDashboard : list) {
					if (!uuid.equals(carouselItemsDashboard.getUuid())) {
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

			sb.append(_SQL_SELECT_CAROUSELITEMSDASHBOARD_WHERE);

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
				sb.append(CarouselItemsDashboardModelImpl.ORDER_BY_JPQL);
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

				list = (List<CarouselItemsDashboard>)QueryUtil.list(
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
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard findByUuid_First(
			String uuid,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard = fetchByUuid_First(
			uuid, orderByComparator);

		if (carouselItemsDashboard != null) {
			return carouselItemsDashboard;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCarouselItemsDashboardException(sb.toString());
	}

	/**
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByUuid_First(
		String uuid,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		List<CarouselItemsDashboard> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard findByUuid_Last(
			String uuid,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard = fetchByUuid_Last(
			uuid, orderByComparator);

		if (carouselItemsDashboard != null) {
			return carouselItemsDashboard;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCarouselItemsDashboardException(sb.toString());
	}

	/**
	 * Returns the last carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByUuid_Last(
		String uuid,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CarouselItemsDashboard> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the carousel items dashboards before and after the current carousel items dashboard in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current carousel items dashboard
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	@Override
	public CarouselItemsDashboard[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException {

		uuid = Objects.toString(uuid, "");

		CarouselItemsDashboard carouselItemsDashboard = findByPrimaryKey(
			categoryId);

		Session session = null;

		try {
			session = openSession();

			CarouselItemsDashboard[] array = new CarouselItemsDashboardImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, carouselItemsDashboard, uuid, orderByComparator, true);

			array[1] = carouselItemsDashboard;

			array[2] = getByUuid_PrevAndNext(
				session, carouselItemsDashboard, uuid, orderByComparator,
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

	protected CarouselItemsDashboard getByUuid_PrevAndNext(
		Session session, CarouselItemsDashboard carouselItemsDashboard,
		String uuid,
		OrderByComparator<CarouselItemsDashboard> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CAROUSELITEMSDASHBOARD_WHERE);

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
			sb.append(CarouselItemsDashboardModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						carouselItemsDashboard)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CarouselItemsDashboard> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the carousel items dashboards where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CarouselItemsDashboard carouselItemsDashboard :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(carouselItemsDashboard);
		}
	}

	/**
	 * Returns the number of carousel items dashboards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching carousel items dashboards
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CAROUSELITEMSDASHBOARD_WHERE);

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
		"carouselItemsDashboard.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(carouselItemsDashboard.uuid IS NULL OR carouselItemsDashboard.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the carousel items dashboard where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard findByUUID_G(String uuid, long groupId)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard = fetchByUUID_G(
			uuid, groupId);

		if (carouselItemsDashboard == null) {
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

			throw new NoSuchCarouselItemsDashboardException(sb.toString());
		}

		return carouselItemsDashboard;
	}

	/**
	 * Returns the carousel items dashboard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the carousel items dashboard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByUUID_G(
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

		if (result instanceof CarouselItemsDashboard) {
			CarouselItemsDashboard carouselItemsDashboard =
				(CarouselItemsDashboard)result;

			if (!Objects.equals(uuid, carouselItemsDashboard.getUuid()) ||
				(groupId != carouselItemsDashboard.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CAROUSELITEMSDASHBOARD_WHERE);

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

				List<CarouselItemsDashboard> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CarouselItemsDashboard carouselItemsDashboard = list.get(0);

					result = carouselItemsDashboard;

					cacheResult(carouselItemsDashboard);
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
			return (CarouselItemsDashboard)result;
		}
	}

	/**
	 * Removes the carousel items dashboard where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the carousel items dashboard that was removed
	 */
	@Override
	public CarouselItemsDashboard removeByUUID_G(String uuid, long groupId)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard = findByUUID_G(
			uuid, groupId);

		return remove(carouselItemsDashboard);
	}

	/**
	 * Returns the number of carousel items dashboards where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching carousel items dashboards
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CAROUSELITEMSDASHBOARD_WHERE);

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
		"carouselItemsDashboard.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(carouselItemsDashboard.uuid IS NULL OR carouselItemsDashboard.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"carouselItemsDashboard.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the carousel items dashboards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching carousel items dashboards
	 */
	@Override
	public List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CarouselItemsDashboard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator,
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

		List<CarouselItemsDashboard> list = null;

		if (useFinderCache) {
			list = (List<CarouselItemsDashboard>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CarouselItemsDashboard carouselItemsDashboard : list) {
					if (!uuid.equals(carouselItemsDashboard.getUuid()) ||
						(companyId != carouselItemsDashboard.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CAROUSELITEMSDASHBOARD_WHERE);

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
				sb.append(CarouselItemsDashboardModelImpl.ORDER_BY_JPQL);
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

				list = (List<CarouselItemsDashboard>)QueryUtil.list(
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
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (carouselItemsDashboard != null) {
			return carouselItemsDashboard;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCarouselItemsDashboardException(sb.toString());
	}

	/**
	 * Returns the first carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		List<CarouselItemsDashboard> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CarouselItemsDashboard findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (carouselItemsDashboard != null) {
			return carouselItemsDashboard;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCarouselItemsDashboardException(sb.toString());
	}

	/**
	 * Returns the last carousel items dashboard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CarouselItemsDashboard> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CarouselItemsDashboard[] findByUuid_C_PrevAndNext(
			long categoryId, String uuid, long companyId,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException {

		uuid = Objects.toString(uuid, "");

		CarouselItemsDashboard carouselItemsDashboard = findByPrimaryKey(
			categoryId);

		Session session = null;

		try {
			session = openSession();

			CarouselItemsDashboard[] array = new CarouselItemsDashboardImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, carouselItemsDashboard, uuid, companyId,
				orderByComparator, true);

			array[1] = carouselItemsDashboard;

			array[2] = getByUuid_C_PrevAndNext(
				session, carouselItemsDashboard, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CarouselItemsDashboard getByUuid_C_PrevAndNext(
		Session session, CarouselItemsDashboard carouselItemsDashboard,
		String uuid, long companyId,
		OrderByComparator<CarouselItemsDashboard> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CAROUSELITEMSDASHBOARD_WHERE);

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
			sb.append(CarouselItemsDashboardModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						carouselItemsDashboard)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CarouselItemsDashboard> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the carousel items dashboards where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CarouselItemsDashboard carouselItemsDashboard :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(carouselItemsDashboard);
		}
	}

	/**
	 * Returns the number of carousel items dashboards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching carousel items dashboards
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CAROUSELITEMSDASHBOARD_WHERE);

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
		"carouselItemsDashboard.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(carouselItemsDashboard.uuid IS NULL OR carouselItemsDashboard.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"carouselItemsDashboard.companyId = ?";

	private FinderPath _finderPathFetchByDeleteCarouselItems;
	private FinderPath _finderPathCountByDeleteCarouselItems;

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard findByDeleteCarouselItems(
			long groupId, long categoryId)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard =
			fetchByDeleteCarouselItems(groupId, categoryId);

		if (carouselItemsDashboard == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", categoryId=");
			sb.append(categoryId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCarouselItemsDashboardException(sb.toString());
		}

		return carouselItemsDashboard;
	}

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByDeleteCarouselItems(
		long groupId, long categoryId) {

		return fetchByDeleteCarouselItems(groupId, categoryId, true);
	}

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByDeleteCarouselItems(
		long groupId, long categoryId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, categoryId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDeleteCarouselItems, finderArgs, this);
		}

		if (result instanceof CarouselItemsDashboard) {
			CarouselItemsDashboard carouselItemsDashboard =
				(CarouselItemsDashboard)result;

			if ((groupId != carouselItemsDashboard.getGroupId()) ||
				(categoryId != carouselItemsDashboard.getCategoryId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CAROUSELITEMSDASHBOARD_WHERE);

			sb.append(_FINDER_COLUMN_DELETECAROUSELITEMS_GROUPID_2);

			sb.append(_FINDER_COLUMN_DELETECAROUSELITEMS_CATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(categoryId);

				List<CarouselItemsDashboard> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDeleteCarouselItems, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupId, categoryId};
							}

							_log.warn(
								"CarouselItemsDashboardPersistenceImpl.fetchByDeleteCarouselItems(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CarouselItemsDashboard carouselItemsDashboard = list.get(0);

					result = carouselItemsDashboard;

					cacheResult(carouselItemsDashboard);
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
			return (CarouselItemsDashboard)result;
		}
	}

	/**
	 * Removes the carousel items dashboard where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the carousel items dashboard that was removed
	 */
	@Override
	public CarouselItemsDashboard removeByDeleteCarouselItems(
			long groupId, long categoryId)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard =
			findByDeleteCarouselItems(groupId, categoryId);

		return remove(carouselItemsDashboard);
	}

	/**
	 * Returns the number of carousel items dashboards where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching carousel items dashboards
	 */
	@Override
	public int countByDeleteCarouselItems(long groupId, long categoryId) {
		FinderPath finderPath = _finderPathCountByDeleteCarouselItems;

		Object[] finderArgs = new Object[] {groupId, categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CAROUSELITEMSDASHBOARD_WHERE);

			sb.append(_FINDER_COLUMN_DELETECAROUSELITEMS_GROUPID_2);

			sb.append(_FINDER_COLUMN_DELETECAROUSELITEMS_CATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_DELETECAROUSELITEMS_GROUPID_2 =
		"carouselItemsDashboard.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_DELETECAROUSELITEMS_CATEGORYID_2 =
			"carouselItemsDashboard.categoryId = ?";

	private FinderPath _finderPathWithPaginationFindByGetCarouselItems;
	private FinderPath _finderPathWithoutPaginationFindByGetCarouselItems;
	private FinderPath _finderPathCountByGetCarouselItems;

	/**
	 * Returns all the carousel items dashboards where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching carousel items dashboards
	 */
	@Override
	public List<CarouselItemsDashboard> findByGetCarouselItems(
		long groupId, long categoryId) {

		return findByGetCarouselItems(
			groupId, categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CarouselItemsDashboard> findByGetCarouselItems(
		long groupId, long categoryId, int start, int end) {

		return findByGetCarouselItems(groupId, categoryId, start, end, null);
	}

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
	@Override
	public List<CarouselItemsDashboard> findByGetCarouselItems(
		long groupId, long categoryId, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return findByGetCarouselItems(
			groupId, categoryId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<CarouselItemsDashboard> findByGetCarouselItems(
		long groupId, long categoryId, int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGetCarouselItems;
				finderArgs = new Object[] {groupId, categoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGetCarouselItems;
			finderArgs = new Object[] {
				groupId, categoryId, start, end, orderByComparator
			};
		}

		List<CarouselItemsDashboard> list = null;

		if (useFinderCache) {
			list = (List<CarouselItemsDashboard>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CarouselItemsDashboard carouselItemsDashboard : list) {
					if ((groupId != carouselItemsDashboard.getGroupId()) ||
						(categoryId !=
							carouselItemsDashboard.getCategoryId())) {

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

			sb.append(_SQL_SELECT_CAROUSELITEMSDASHBOARD_WHERE);

			sb.append(_FINDER_COLUMN_GETCAROUSELITEMS_GROUPID_2);

			sb.append(_FINDER_COLUMN_GETCAROUSELITEMS_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CarouselItemsDashboardModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(categoryId);

				list = (List<CarouselItemsDashboard>)QueryUtil.list(
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
	 * Returns the first carousel items dashboard in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard findByGetCarouselItems_First(
			long groupId, long categoryId,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard =
			fetchByGetCarouselItems_First(
				groupId, categoryId, orderByComparator);

		if (carouselItemsDashboard != null) {
			return carouselItemsDashboard;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", categoryId=");
		sb.append(categoryId);

		sb.append("}");

		throw new NoSuchCarouselItemsDashboardException(sb.toString());
	}

	/**
	 * Returns the first carousel items dashboard in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByGetCarouselItems_First(
		long groupId, long categoryId,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		List<CarouselItemsDashboard> list = findByGetCarouselItems(
			groupId, categoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last carousel items dashboard in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard findByGetCarouselItems_Last(
			long groupId, long categoryId,
			OrderByComparator<CarouselItemsDashboard> orderByComparator)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard =
			fetchByGetCarouselItems_Last(
				groupId, categoryId, orderByComparator);

		if (carouselItemsDashboard != null) {
			return carouselItemsDashboard;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", categoryId=");
		sb.append(categoryId);

		sb.append("}");

		throw new NoSuchCarouselItemsDashboardException(sb.toString());
	}

	/**
	 * Returns the last carousel items dashboard in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByGetCarouselItems_Last(
		long groupId, long categoryId,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		int count = countByGetCarouselItems(groupId, categoryId);

		if (count == 0) {
			return null;
		}

		List<CarouselItemsDashboard> list = findByGetCarouselItems(
			groupId, categoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the carousel items dashboards where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 */
	@Override
	public void removeByGetCarouselItems(long groupId, long categoryId) {
		for (CarouselItemsDashboard carouselItemsDashboard :
				findByGetCarouselItems(
					groupId, categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(carouselItemsDashboard);
		}
	}

	/**
	 * Returns the number of carousel items dashboards where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching carousel items dashboards
	 */
	@Override
	public int countByGetCarouselItems(long groupId, long categoryId) {
		FinderPath finderPath = _finderPathCountByGetCarouselItems;

		Object[] finderArgs = new Object[] {groupId, categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CAROUSELITEMSDASHBOARD_WHERE);

			sb.append(_FINDER_COLUMN_GETCAROUSELITEMS_GROUPID_2);

			sb.append(_FINDER_COLUMN_GETCAROUSELITEMS_CATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_GETCAROUSELITEMS_GROUPID_2 =
		"carouselItemsDashboard.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GETCAROUSELITEMS_CATEGORYID_2 =
		"carouselItemsDashboard.categoryId = ?";

	private FinderPath _finderPathFetchByGetCarouselItemById;
	private FinderPath _finderPathCountByGetCarouselItemById;

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard findByGetCarouselItemById(
			long groupId, long categoryId)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard =
			fetchByGetCarouselItemById(groupId, categoryId);

		if (carouselItemsDashboard == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", categoryId=");
			sb.append(categoryId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCarouselItemsDashboardException(sb.toString());
		}

		return carouselItemsDashboard;
	}

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByGetCarouselItemById(
		long groupId, long categoryId) {

		return fetchByGetCarouselItemById(groupId, categoryId, true);
	}

	/**
	 * Returns the carousel items dashboard where groupId = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByGetCarouselItemById(
		long groupId, long categoryId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, categoryId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGetCarouselItemById, finderArgs, this);
		}

		if (result instanceof CarouselItemsDashboard) {
			CarouselItemsDashboard carouselItemsDashboard =
				(CarouselItemsDashboard)result;

			if ((groupId != carouselItemsDashboard.getGroupId()) ||
				(categoryId != carouselItemsDashboard.getCategoryId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CAROUSELITEMSDASHBOARD_WHERE);

			sb.append(_FINDER_COLUMN_GETCAROUSELITEMBYID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GETCAROUSELITEMBYID_CATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(categoryId);

				List<CarouselItemsDashboard> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGetCarouselItemById, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupId, categoryId};
							}

							_log.warn(
								"CarouselItemsDashboardPersistenceImpl.fetchByGetCarouselItemById(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CarouselItemsDashboard carouselItemsDashboard = list.get(0);

					result = carouselItemsDashboard;

					cacheResult(carouselItemsDashboard);
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
			return (CarouselItemsDashboard)result;
		}
	}

	/**
	 * Removes the carousel items dashboard where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the carousel items dashboard that was removed
	 */
	@Override
	public CarouselItemsDashboard removeByGetCarouselItemById(
			long groupId, long categoryId)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard =
			findByGetCarouselItemById(groupId, categoryId);

		return remove(carouselItemsDashboard);
	}

	/**
	 * Returns the number of carousel items dashboards where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching carousel items dashboards
	 */
	@Override
	public int countByGetCarouselItemById(long groupId, long categoryId) {
		FinderPath finderPath = _finderPathCountByGetCarouselItemById;

		Object[] finderArgs = new Object[] {groupId, categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CAROUSELITEMSDASHBOARD_WHERE);

			sb.append(_FINDER_COLUMN_GETCAROUSELITEMBYID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GETCAROUSELITEMBYID_CATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_GETCAROUSELITEMBYID_GROUPID_2 =
		"carouselItemsDashboard.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GETCAROUSELITEMBYID_CATEGORYID_2 =
			"carouselItemsDashboard.categoryId = ?";

	private FinderPath _finderPathFetchByERC_G;
	private FinderPath _finderPathCountByERC_G;

	/**
	 * Returns the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard findByERC_G(
			String externalReferenceCode, long groupId)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard = fetchByERC_G(
			externalReferenceCode, groupId);

		if (carouselItemsDashboard == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalReferenceCode=");
			sb.append(externalReferenceCode);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCarouselItemsDashboardException(sb.toString());
		}

		return carouselItemsDashboard;
	}

	/**
	 * Returns the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByERC_G(
		String externalReferenceCode, long groupId) {

		return fetchByERC_G(externalReferenceCode, groupId, true);
	}

	/**
	 * Returns the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByERC_G(
		String externalReferenceCode, long groupId, boolean useFinderCache) {

		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalReferenceCode, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByERC_G, finderArgs, this);
		}

		if (result instanceof CarouselItemsDashboard) {
			CarouselItemsDashboard carouselItemsDashboard =
				(CarouselItemsDashboard)result;

			if (!Objects.equals(
					externalReferenceCode,
					carouselItemsDashboard.getExternalReferenceCode()) ||
				(groupId != carouselItemsDashboard.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CAROUSELITEMSDASHBOARD_WHERE);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_ERC_G_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_ERC_G_EXTERNALREFERENCECODE_2);
			}

			sb.append(_FINDER_COLUMN_ERC_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				queryPos.add(groupId);

				List<CarouselItemsDashboard> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByERC_G, finderArgs, list);
					}
				}
				else {
					CarouselItemsDashboard carouselItemsDashboard = list.get(0);

					result = carouselItemsDashboard;

					cacheResult(carouselItemsDashboard);
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
			return (CarouselItemsDashboard)result;
		}
	}

	/**
	 * Removes the carousel items dashboard where externalReferenceCode = &#63; and groupId = &#63; from the database.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the carousel items dashboard that was removed
	 */
	@Override
	public CarouselItemsDashboard removeByERC_G(
			String externalReferenceCode, long groupId)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard = findByERC_G(
			externalReferenceCode, groupId);

		return remove(carouselItemsDashboard);
	}

	/**
	 * Returns the number of carousel items dashboards where externalReferenceCode = &#63; and groupId = &#63;.
	 *
	 * @param externalReferenceCode the external reference code
	 * @param groupId the group ID
	 * @return the number of matching carousel items dashboards
	 */
	@Override
	public int countByERC_G(String externalReferenceCode, long groupId) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByERC_G;

		Object[] finderArgs = new Object[] {externalReferenceCode, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CAROUSELITEMSDASHBOARD_WHERE);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_ERC_G_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_ERC_G_EXTERNALREFERENCECODE_2);
			}

			sb.append(_FINDER_COLUMN_ERC_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
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

	private static final String _FINDER_COLUMN_ERC_G_EXTERNALREFERENCECODE_2 =
		"carouselItemsDashboard.externalReferenceCode = ? AND ";

	private static final String _FINDER_COLUMN_ERC_G_EXTERNALREFERENCECODE_3 =
		"(carouselItemsDashboard.externalReferenceCode IS NULL OR carouselItemsDashboard.externalReferenceCode = '') AND ";

	private static final String _FINDER_COLUMN_ERC_G_GROUPID_2 =
		"carouselItemsDashboard.groupId = ?";

	public CarouselItemsDashboardPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CarouselItemsDashboard.class);

		setModelImplClass(CarouselItemsDashboardImpl.class);
		setModelPKClass(long.class);

		setTable(CarouselItemsDashboardTable.INSTANCE);
	}

	/**
	 * Caches the carousel items dashboard in the entity cache if it is enabled.
	 *
	 * @param carouselItemsDashboard the carousel items dashboard
	 */
	@Override
	public void cacheResult(CarouselItemsDashboard carouselItemsDashboard) {
		entityCache.putResult(
			CarouselItemsDashboardImpl.class,
			carouselItemsDashboard.getPrimaryKey(), carouselItemsDashboard);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				carouselItemsDashboard.getUuid(),
				carouselItemsDashboard.getGroupId()
			},
			carouselItemsDashboard);

		finderCache.putResult(
			_finderPathFetchByDeleteCarouselItems,
			new Object[] {
				carouselItemsDashboard.getGroupId(),
				carouselItemsDashboard.getCategoryId()
			},
			carouselItemsDashboard);

		finderCache.putResult(
			_finderPathFetchByGetCarouselItemById,
			new Object[] {
				carouselItemsDashboard.getGroupId(),
				carouselItemsDashboard.getCategoryId()
			},
			carouselItemsDashboard);

		finderCache.putResult(
			_finderPathFetchByERC_G,
			new Object[] {
				carouselItemsDashboard.getExternalReferenceCode(),
				carouselItemsDashboard.getGroupId()
			},
			carouselItemsDashboard);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the carousel items dashboards in the entity cache if it is enabled.
	 *
	 * @param carouselItemsDashboards the carousel items dashboards
	 */
	@Override
	public void cacheResult(
		List<CarouselItemsDashboard> carouselItemsDashboards) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (carouselItemsDashboards.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CarouselItemsDashboard carouselItemsDashboard :
				carouselItemsDashboards) {

			if (entityCache.getResult(
					CarouselItemsDashboardImpl.class,
					carouselItemsDashboard.getPrimaryKey()) == null) {

				cacheResult(carouselItemsDashboard);
			}
		}
	}

	/**
	 * Clears the cache for all carousel items dashboards.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CarouselItemsDashboardImpl.class);

		finderCache.clearCache(CarouselItemsDashboardImpl.class);
	}

	/**
	 * Clears the cache for the carousel items dashboard.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CarouselItemsDashboard carouselItemsDashboard) {
		entityCache.removeResult(
			CarouselItemsDashboardImpl.class, carouselItemsDashboard);
	}

	@Override
	public void clearCache(
		List<CarouselItemsDashboard> carouselItemsDashboards) {

		for (CarouselItemsDashboard carouselItemsDashboard :
				carouselItemsDashboards) {

			entityCache.removeResult(
				CarouselItemsDashboardImpl.class, carouselItemsDashboard);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CarouselItemsDashboardImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				CarouselItemsDashboardImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CarouselItemsDashboardModelImpl carouselItemsDashboardModelImpl) {

		Object[] args = new Object[] {
			carouselItemsDashboardModelImpl.getUuid(),
			carouselItemsDashboardModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, carouselItemsDashboardModelImpl);

		args = new Object[] {
			carouselItemsDashboardModelImpl.getGroupId(),
			carouselItemsDashboardModelImpl.getCategoryId()
		};

		finderCache.putResult(
			_finderPathCountByDeleteCarouselItems, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDeleteCarouselItems, args,
			carouselItemsDashboardModelImpl);

		args = new Object[] {
			carouselItemsDashboardModelImpl.getGroupId(),
			carouselItemsDashboardModelImpl.getCategoryId()
		};

		finderCache.putResult(
			_finderPathCountByGetCarouselItemById, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByGetCarouselItemById, args,
			carouselItemsDashboardModelImpl);

		args = new Object[] {
			carouselItemsDashboardModelImpl.getExternalReferenceCode(),
			carouselItemsDashboardModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByERC_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByERC_G, args, carouselItemsDashboardModelImpl);
	}

	/**
	 * Creates a new carousel items dashboard with the primary key. Does not add the carousel items dashboard to the database.
	 *
	 * @param categoryId the primary key for the new carousel items dashboard
	 * @return the new carousel items dashboard
	 */
	@Override
	public CarouselItemsDashboard create(long categoryId) {
		CarouselItemsDashboard carouselItemsDashboard =
			new CarouselItemsDashboardImpl();

		carouselItemsDashboard.setNew(true);
		carouselItemsDashboard.setPrimaryKey(categoryId);

		String uuid = _portalUUID.generate();

		carouselItemsDashboard.setUuid(uuid);

		carouselItemsDashboard.setCompanyId(CompanyThreadLocal.getCompanyId());

		return carouselItemsDashboard;
	}

	/**
	 * Removes the carousel items dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard that was removed
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	@Override
	public CarouselItemsDashboard remove(long categoryId)
		throws NoSuchCarouselItemsDashboardException {

		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the carousel items dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the carousel items dashboard
	 * @return the carousel items dashboard that was removed
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	@Override
	public CarouselItemsDashboard remove(Serializable primaryKey)
		throws NoSuchCarouselItemsDashboardException {

		Session session = null;

		try {
			session = openSession();

			CarouselItemsDashboard carouselItemsDashboard =
				(CarouselItemsDashboard)session.get(
					CarouselItemsDashboardImpl.class, primaryKey);

			if (carouselItemsDashboard == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCarouselItemsDashboardException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(carouselItemsDashboard);
		}
		catch (NoSuchCarouselItemsDashboardException noSuchEntityException) {
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
	protected CarouselItemsDashboard removeImpl(
		CarouselItemsDashboard carouselItemsDashboard) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(carouselItemsDashboard)) {
				carouselItemsDashboard = (CarouselItemsDashboard)session.get(
					CarouselItemsDashboardImpl.class,
					carouselItemsDashboard.getPrimaryKeyObj());
			}

			if (carouselItemsDashboard != null) {
				session.delete(carouselItemsDashboard);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (carouselItemsDashboard != null) {
			clearCache(carouselItemsDashboard);
		}

		return carouselItemsDashboard;
	}

	@Override
	public CarouselItemsDashboard updateImpl(
		CarouselItemsDashboard carouselItemsDashboard) {

		boolean isNew = carouselItemsDashboard.isNew();

		if (!(carouselItemsDashboard instanceof
				CarouselItemsDashboardModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(carouselItemsDashboard.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					carouselItemsDashboard);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in carouselItemsDashboard proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CarouselItemsDashboard implementation " +
					carouselItemsDashboard.getClass());
		}

		CarouselItemsDashboardModelImpl carouselItemsDashboardModelImpl =
			(CarouselItemsDashboardModelImpl)carouselItemsDashboard;

		if (Validator.isNull(carouselItemsDashboard.getUuid())) {
			String uuid = _portalUUID.generate();

			carouselItemsDashboard.setUuid(uuid);
		}

		if (Validator.isNull(
				carouselItemsDashboard.getExternalReferenceCode())) {

			carouselItemsDashboard.setExternalReferenceCode(
				carouselItemsDashboard.getUuid());
		}
		else {
			CarouselItemsDashboard ercCarouselItemsDashboard = fetchByERC_G(
				carouselItemsDashboard.getExternalReferenceCode(),
				carouselItemsDashboard.getGroupId());

			if (isNew) {
				if (ercCarouselItemsDashboard != null) {
					throw new DuplicateCarouselItemsDashboardExternalReferenceCodeException(
						"Duplicate carousel items dashboard with external reference code " +
							carouselItemsDashboard.getExternalReferenceCode());
				}
			}
			else {
				if ((ercCarouselItemsDashboard != null) &&
					(carouselItemsDashboard.getCategoryId() !=
						ercCarouselItemsDashboard.getCategoryId())) {

					throw new DuplicateCarouselItemsDashboardExternalReferenceCodeException(
						"Duplicate carousel items dashboard with external reference code " +
							carouselItemsDashboard.getExternalReferenceCode());
				}
			}
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (carouselItemsDashboard.getCreateDate() == null)) {
			if (serviceContext == null) {
				carouselItemsDashboard.setCreateDate(date);
			}
			else {
				carouselItemsDashboard.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!carouselItemsDashboardModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				carouselItemsDashboard.setModifiedDate(date);
			}
			else {
				carouselItemsDashboard.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(carouselItemsDashboard);
			}
			else {
				carouselItemsDashboard = (CarouselItemsDashboard)session.merge(
					carouselItemsDashboard);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CarouselItemsDashboardImpl.class, carouselItemsDashboardModelImpl,
			false, true);

		cacheUniqueFindersCache(carouselItemsDashboardModelImpl);

		if (isNew) {
			carouselItemsDashboard.setNew(false);
		}

		carouselItemsDashboard.resetOriginalValues();

		return carouselItemsDashboard;
	}

	/**
	 * Returns the carousel items dashboard with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the carousel items dashboard
	 * @return the carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	@Override
	public CarouselItemsDashboard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCarouselItemsDashboardException {

		CarouselItemsDashboard carouselItemsDashboard = fetchByPrimaryKey(
			primaryKey);

		if (carouselItemsDashboard == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCarouselItemsDashboardException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return carouselItemsDashboard;
	}

	/**
	 * Returns the carousel items dashboard with the primary key or throws a <code>NoSuchCarouselItemsDashboardException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard
	 * @throws NoSuchCarouselItemsDashboardException if a carousel items dashboard with the primary key could not be found
	 */
	@Override
	public CarouselItemsDashboard findByPrimaryKey(long categoryId)
		throws NoSuchCarouselItemsDashboardException {

		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the carousel items dashboard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard, or <code>null</code> if a carousel items dashboard with the primary key could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchByPrimaryKey(long categoryId) {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns all the carousel items dashboards.
	 *
	 * @return the carousel items dashboards
	 */
	@Override
	public List<CarouselItemsDashboard> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CarouselItemsDashboard> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CarouselItemsDashboard> findAll(
		int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CarouselItemsDashboard> findAll(
		int start, int end,
		OrderByComparator<CarouselItemsDashboard> orderByComparator,
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

		List<CarouselItemsDashboard> list = null;

		if (useFinderCache) {
			list = (List<CarouselItemsDashboard>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CAROUSELITEMSDASHBOARD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CAROUSELITEMSDASHBOARD;

				sql = sql.concat(CarouselItemsDashboardModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CarouselItemsDashboard>)QueryUtil.list(
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
	 * Removes all the carousel items dashboards from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CarouselItemsDashboard carouselItemsDashboard : findAll()) {
			remove(carouselItemsDashboard);
		}
	}

	/**
	 * Returns the number of carousel items dashboards.
	 *
	 * @return the number of carousel items dashboards
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_CAROUSELITEMSDASHBOARD);

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
		return "categoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CAROUSELITEMSDASHBOARD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CarouselItemsDashboardModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the carousel items dashboard persistence.
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

		_finderPathFetchByDeleteCarouselItems = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDeleteCarouselItems",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "categoryId"}, true);

		_finderPathCountByDeleteCarouselItems = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDeleteCarouselItems",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "categoryId"}, false);

		_finderPathWithPaginationFindByGetCarouselItems = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGetCarouselItems",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "categoryId"}, true);

		_finderPathWithoutPaginationFindByGetCarouselItems = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGetCarouselItems",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "categoryId"}, true);

		_finderPathCountByGetCarouselItems = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGetCarouselItems",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "categoryId"}, false);

		_finderPathFetchByGetCarouselItemById = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByGetCarouselItemById",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "categoryId"}, true);

		_finderPathCountByGetCarouselItemById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGetCarouselItemById",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "categoryId"}, false);

		_finderPathFetchByERC_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByERC_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"externalReferenceCode", "groupId"}, true);

		_finderPathCountByERC_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByERC_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"externalReferenceCode", "groupId"}, false);

		_setCarouselItemsDashboardUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCarouselItemsDashboardUtilPersistence(null);

		entityCache.removeCache(CarouselItemsDashboardImpl.class.getName());
	}

	private void _setCarouselItemsDashboardUtilPersistence(
		CarouselItemsDashboardPersistence carouselItemsDashboardPersistence) {

		try {
			Field field = CarouselItemsDashboardUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, carouselItemsDashboardPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = CarouselItemsDashboardPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CarouselItemsDashboardPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CarouselItemsDashboardPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CAROUSELITEMSDASHBOARD =
		"SELECT carouselItemsDashboard FROM CarouselItemsDashboard carouselItemsDashboard";

	private static final String _SQL_SELECT_CAROUSELITEMSDASHBOARD_WHERE =
		"SELECT carouselItemsDashboard FROM CarouselItemsDashboard carouselItemsDashboard WHERE ";

	private static final String _SQL_COUNT_CAROUSELITEMSDASHBOARD =
		"SELECT COUNT(carouselItemsDashboard) FROM CarouselItemsDashboard carouselItemsDashboard";

	private static final String _SQL_COUNT_CAROUSELITEMSDASHBOARD_WHERE =
		"SELECT COUNT(carouselItemsDashboard) FROM CarouselItemsDashboard carouselItemsDashboard WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"carouselItemsDashboard.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CarouselItemsDashboard exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CarouselItemsDashboard exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CarouselItemsDashboardPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}