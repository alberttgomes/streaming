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

package com.streaming.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import com.streaming.model.CarouselItemsDashboard;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CarouselItemsDashboard in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CarouselItemsDashboardCacheModel
	implements CacheModel<CarouselItemsDashboard>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CarouselItemsDashboardCacheModel)) {
			return false;
		}

		CarouselItemsDashboardCacheModel carouselItemsDashboardCacheModel =
			(CarouselItemsDashboardCacheModel)object;

		if ((streamingId == carouselItemsDashboardCacheModel.streamingId) &&
			(mvccVersion == carouselItemsDashboardCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, streamingId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", streamingId=");
		sb.append(streamingId);
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
		sb.append(", category=");
		sb.append(category);
		sb.append(", colorTheme=");
		sb.append(colorTheme);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", title=");
		sb.append(title);
		sb.append(", user=");
		sb.append(user);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CarouselItemsDashboard toEntityModel() {
		CarouselItemsDashboardImpl carouselItemsDashboardImpl =
			new CarouselItemsDashboardImpl();

		carouselItemsDashboardImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			carouselItemsDashboardImpl.setUuid("");
		}
		else {
			carouselItemsDashboardImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			carouselItemsDashboardImpl.setExternalReferenceCode("");
		}
		else {
			carouselItemsDashboardImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		carouselItemsDashboardImpl.setStreamingId(streamingId);
		carouselItemsDashboardImpl.setGroupId(groupId);
		carouselItemsDashboardImpl.setCompanyId(companyId);
		carouselItemsDashboardImpl.setUserId(userId);

		if (userName == null) {
			carouselItemsDashboardImpl.setUserName("");
		}
		else {
			carouselItemsDashboardImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			carouselItemsDashboardImpl.setCreateDate(null);
		}
		else {
			carouselItemsDashboardImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			carouselItemsDashboardImpl.setModifiedDate(null);
		}
		else {
			carouselItemsDashboardImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (category == null) {
			carouselItemsDashboardImpl.setCategory("");
		}
		else {
			carouselItemsDashboardImpl.setCategory(category);
		}

		if (colorTheme == null) {
			carouselItemsDashboardImpl.setColorTheme("");
		}
		else {
			carouselItemsDashboardImpl.setColorTheme(colorTheme);
		}

		if (priority == null) {
			carouselItemsDashboardImpl.setPriority("");
		}
		else {
			carouselItemsDashboardImpl.setPriority(priority);
		}

		if (title == null) {
			carouselItemsDashboardImpl.setTitle("");
		}
		else {
			carouselItemsDashboardImpl.setTitle(title);
		}

		if (user == null) {
			carouselItemsDashboardImpl.setUser("");
		}
		else {
			carouselItemsDashboardImpl.setUser(user);
		}

		carouselItemsDashboardImpl.resetOriginalValues();

		return carouselItemsDashboardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		streamingId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		category = objectInput.readUTF();
		colorTheme = objectInput.readUTF();
		priority = objectInput.readUTF();
		title = objectInput.readUTF();
		user = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (externalReferenceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalReferenceCode);
		}

		objectOutput.writeLong(streamingId);

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

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (colorTheme == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(colorTheme);
		}

		if (priority == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(priority);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (user == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(user);
		}
	}

	public long mvccVersion;
	public String uuid;
	public String externalReferenceCode;
	public long streamingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String category;
	public String colorTheme;
	public String priority;
	public String title;
	public String user;

}