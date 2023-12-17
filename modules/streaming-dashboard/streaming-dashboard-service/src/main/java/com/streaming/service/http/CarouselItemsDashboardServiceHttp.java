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

package com.streaming.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.streaming.exception.*;
import com.streaming.service.CarouselItemsDashboardServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>CarouselItemsDashboardServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CarouselItemsDashboardServiceHttp {

	public static void addNewCarouselItem(
			HttpPrincipal httpPrincipal, long mvccVersion, String uuid,
			String externalReferenceCode, long categoryId, long groupId,
			long companyId, String userName, java.util.Date createDate,
			java.util.Date modifiedDate, String category, String colorTheme,
			long instanceCategoryFk, String priority, String title,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws CarouselInvalidFieldItemException,
			CarouselItemNotAllowedException, CarouselItemNotFoundException {

		try {
			MethodKey methodKey = new MethodKey(
				CarouselItemsDashboardServiceUtil.class, "addNewCarouselItem",
				_addNewCarouselItemParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, mvccVersion, uuid, externalReferenceCode, categoryId,
				groupId, companyId, userName, createDate, modifiedDate,
				category, colorTheme, instanceCategoryFk, priority, title,
				themeDisplay);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof CarouselItemNotAllowedException) {
					throw (CarouselItemNotAllowedException)exception;
				}

				if (exception instanceof CarouselInvalidFieldItemException) {
					throw (CarouselInvalidFieldItemException)exception;
				}

				if (exception instanceof CarouselItemNotFoundException) {
					throw (CarouselItemNotFoundException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteCarouselItemById(
			HttpPrincipal httpPrincipal, long categoryId, long groupId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws NoSuchCarouselItemsDashboardException {

		try {
			MethodKey methodKey = new MethodKey(
				CarouselItemsDashboardServiceUtil.class,
				"deleteCarouselItemById",
				_deleteCarouselItemByIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId, groupId, themeDisplay);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						NoSuchCarouselItemsDashboardException) {

					throw (NoSuchCarouselItemsDashboardException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.streaming.model.CarouselItemsDashboard
			getCarouselItemById(
				HttpPrincipal httpPrincipal, long categoryId, long groupId,
				com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws CarouselItemNotAllowedException,
			   NoSuchCarouselItemsDashboardException {

		try {
			MethodKey methodKey = new MethodKey(
				CarouselItemsDashboardServiceUtil.class, "getCarouselItemById",
				_getCarouselItemByIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId, groupId, themeDisplay);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						NoSuchCarouselItemsDashboardException) {

					throw (NoSuchCarouselItemsDashboardException)exception;
				}

				if (exception instanceof CarouselItemNotAllowedException) {
					throw (CarouselItemNotAllowedException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.streaming.model.CarouselItemsDashboard)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.streaming.model.CarouselItemsDashboard>
			getCarouselItemsList(HttpPrincipal httpPrincipal, long groupId)
		throws CarouselDashboardManagerNotFoundException,
			   CarouselItemDashboardException {

		try {
			MethodKey methodKey = new MethodKey(
				CarouselItemsDashboardServiceUtil.class, "getCarouselItemsList",
				_getCarouselItemsListParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						CarouselDashboardManagerNotFoundException) {

					throw (CarouselDashboardManagerNotFoundException)exception;
				}

				if (exception instanceof CarouselItemDashboardException) {
					throw (CarouselItemDashboardException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.streaming.model.CarouselItemsDashboard>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.streaming.model.CarouselItemsDashboard
			updateCarouselItemById(
				HttpPrincipal httpPrincipal, long categoryId, long groupId,
				String userName, String category, String colorTheme,
				String priority, String title)
		throws CarouselDashboardManagerNotFoundException,
			   CarouselItemDashboardException {

		try {
			MethodKey methodKey = new MethodKey(
				CarouselItemsDashboardServiceUtil.class,
				"updateCarouselItemById",
				_updateCarouselItemByIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId, groupId, userName, category, colorTheme,
				priority, title);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						CarouselDashboardManagerNotFoundException) {

					throw (CarouselDashboardManagerNotFoundException)exception;
				}

				if (exception instanceof CarouselItemDashboardException) {
					throw (CarouselItemDashboardException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.streaming.model.CarouselItemsDashboard)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CarouselItemsDashboardServiceHttp.class);

	private static final Class<?>[] _addNewCarouselItemParameterTypes0 =
		new Class[] {
			long.class, String.class, String.class, long.class, long.class,
			long.class, String.class, java.util.Date.class,
			java.util.Date.class, String.class, String.class, long.class,
			String.class, String.class,
			com.liferay.portal.kernel.theme.ThemeDisplay.class
		};
	private static final Class<?>[] _deleteCarouselItemByIdParameterTypes1 =
		new Class[] {
			long.class, long.class,
			com.liferay.portal.kernel.theme.ThemeDisplay.class
		};
	private static final Class<?>[] _getCarouselItemByIdParameterTypes2 =
		new Class[] {
			long.class, long.class,
			com.liferay.portal.kernel.theme.ThemeDisplay.class
		};
	private static final Class<?>[] _getCarouselItemsListParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _updateCarouselItemByIdParameterTypes4 =
		new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			String.class, String.class
		};

}