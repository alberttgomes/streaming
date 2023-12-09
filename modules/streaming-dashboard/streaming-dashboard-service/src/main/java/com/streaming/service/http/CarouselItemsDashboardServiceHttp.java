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
			HttpPrincipal httpPrincipal,
			com.streaming.model.CarouselItemsDashboard carouselItemsDashboard,
			long groupId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.streaming.exception.CarouselInvalidFieldItemException,
			   com.streaming.exception.CarouselItemNotAllowedException,
			   com.streaming.exception.CarouselItemNotFoundException {

		try {
			MethodKey methodKey = new MethodKey(
				CarouselItemsDashboardServiceUtil.class, "addNewCarouselItem",
				_addNewCarouselItemParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, carouselItemsDashboard, groupId, themeDisplay);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.streaming.exception.
							CarouselItemNotAllowedException) {

					throw (com.streaming.exception.
						CarouselItemNotAllowedException)exception;
				}

				if (exception instanceof
						com.streaming.exception.
							CarouselInvalidFieldItemException) {

					throw (com.streaming.exception.
						CarouselInvalidFieldItemException)exception;
				}

				if (exception instanceof
						com.streaming.exception.CarouselItemNotFoundException) {

					throw (com.streaming.exception.
						CarouselItemNotFoundException)exception;
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
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

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

	public static void getCarouselItemById(
		HttpPrincipal httpPrincipal, long categoryId, long groupId,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {

		try {
			MethodKey methodKey = new MethodKey(
				CarouselItemsDashboardServiceUtil.class, "getCarouselItemById",
				_getCarouselItemByIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId, groupId, themeDisplay);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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

	public static void getCarouselItemById(
		HttpPrincipal httpPrincipal, long categoryId, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				CarouselItemsDashboardServiceUtil.class, "getCarouselItemById",
				_getCarouselItemByIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId, groupId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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

	private static Log _log = LogFactoryUtil.getLog(
		CarouselItemsDashboardServiceHttp.class);

	private static final Class<?>[] _addNewCarouselItemParameterTypes0 =
		new Class[] {
			com.streaming.model.CarouselItemsDashboard.class, long.class,
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
	private static final Class<?>[] _getCarouselItemByIdParameterTypes3 =
		new Class[] {long.class, long.class};

}