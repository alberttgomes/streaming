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

package com.streaming.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the CarouselItemsDashboard service. Represents a row in the &quot;STG-CarouselItemsDashboard&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CarouselItemsDashboardModel
 * @generated
 */
@ImplementationClassName("com.streaming.model.impl.CarouselItemsDashboardImpl")
@ProviderType
public interface CarouselItemsDashboard
	extends CarouselItemsDashboardModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.streaming.model.impl.CarouselItemsDashboardImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CarouselItemsDashboard, Long>
		CATEGORY_ID_ACCESSOR = new Accessor<CarouselItemsDashboard, Long>() {

			@Override
			public Long get(CarouselItemsDashboard carouselItemsDashboard) {
				return carouselItemsDashboard.getCategoryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CarouselItemsDashboard> getTypeClass() {
				return CarouselItemsDashboard.class;
			}

		};

}