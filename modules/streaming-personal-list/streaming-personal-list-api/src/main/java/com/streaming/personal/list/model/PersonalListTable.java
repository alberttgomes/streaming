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

package com.streaming.personal.list.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;PersonalList&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PersonalList
 * @generated
 */
public class PersonalListTable extends BaseTable<PersonalListTable> {

	public static final PersonalListTable INSTANCE = new PersonalListTable();

	public final Column<PersonalListTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonalListTable, Long> personalItemId = createColumn(
		"personalItemId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PersonalListTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonalListTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonalListTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonalListTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonalListTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PersonalListTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PersonalListTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonalListTable, String> fileShort = createColumn(
		"fileShort", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PersonalListTable, Boolean> launch = createColumn(
		"launch", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PersonalListTable, Long> instancePk = createColumn(
		"instancePk", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PersonalListTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PersonalListTable() {
		super("PersonalList", PersonalListTable::new);
	}

}