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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;STG-CarouselItemsDashboard&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CarouselItemsDashboard
 * @generated
 */
public class CarouselItemsDashboardTable
	extends BaseTable<CarouselItemsDashboardTable> {

	public static final CarouselItemsDashboardTable INSTANCE =
		new CarouselItemsDashboardTable();

	public final Column<CarouselItemsDashboardTable, Long> mvccVersion =
		createColumn(
			"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<CarouselItemsDashboardTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, String>
		externalReferenceCode = createColumn(
			"externalReferenceCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, Long> streamingId =
		createColumn(
			"streamingId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CarouselItemsDashboardTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, String> category =
		createColumn(
			"category", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, String> colorTheme =
		createColumn(
			"colorTheme", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, String> priority =
		createColumn(
			"priority", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, String> title =
		createColumn("title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CarouselItemsDashboardTable, String> user =
		createColumn("user", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CarouselItemsDashboardTable() {
		super("STG-CarouselItemsDashboard", CarouselItemsDashboardTable::new);
	}

}