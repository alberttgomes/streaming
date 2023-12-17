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

package com.streaming.personal.list.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.streaming.personal.list.model.PersonalList;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PersonalList in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersonalListCacheModel
	implements CacheModel<PersonalList>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersonalListCacheModel)) {
			return false;
		}

		PersonalListCacheModel personalListCacheModel =
			(PersonalListCacheModel)object;

		if (personalItemId == personalListCacheModel.personalItemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, personalItemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", personalItemId=");
		sb.append(personalItemId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", description=");
		sb.append(description);
		sb.append(", fileShort=");
		sb.append(fileShort);
		sb.append(", launch=");
		sb.append(launch);
		sb.append(", instancePk=");
		sb.append(instancePk);
		sb.append(", title=");
		sb.append(title);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersonalList toEntityModel() {
		PersonalListImpl personalListImpl = new PersonalListImpl();

		if (uuid == null) {
			personalListImpl.setUuid("");
		}
		else {
			personalListImpl.setUuid(uuid);
		}

		personalListImpl.setPersonalItemId(personalItemId);
		personalListImpl.setGroupId(groupId);
		personalListImpl.setCompanyId(companyId);
		personalListImpl.setUserId(userId);

		if (userName == null) {
			personalListImpl.setUserName("");
		}
		else {
			personalListImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			personalListImpl.setCreateDate(null);
		}
		else {
			personalListImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			personalListImpl.setModifiedDate(null);
		}
		else {
			personalListImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			personalListImpl.setDescription("");
		}
		else {
			personalListImpl.setDescription(description);
		}

		if (fileShort == null) {
			personalListImpl.setFileShort("");
		}
		else {
			personalListImpl.setFileShort(fileShort);
		}

		personalListImpl.setLaunch(launch);
		personalListImpl.setInstancePk(instancePk);

		if (title == null) {
			personalListImpl.setTitle("");
		}
		else {
			personalListImpl.setTitle(title);
		}

		personalListImpl.resetOriginalValues();

		return personalListImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		personalItemId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		fileShort = objectInput.readUTF();

		launch = objectInput.readBoolean();

		instancePk = objectInput.readLong();
		title = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(personalItemId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (fileShort == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileShort);
		}

		objectOutput.writeBoolean(launch);

		objectOutput.writeLong(instancePk);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}
	}

	public String uuid;
	public long personalItemId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String fileShort;
	public boolean launch;
	public long instancePk;
	public String title;

}