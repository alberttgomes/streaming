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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CarouselItemsDashboard}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CarouselItemsDashboard
 * @generated
 */
public class CarouselItemsDashboardWrapper
	extends BaseModelWrapper<CarouselItemsDashboard>
	implements CarouselItemsDashboard, ModelWrapper<CarouselItemsDashboard> {

	public CarouselItemsDashboardWrapper(
		CarouselItemsDashboard carouselItemsDashboard) {

		super(carouselItemsDashboard);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("category", getCategory());
		attributes.put("colorTheme", getColorTheme());
		attributes.put("priority", getPriority());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String externalReferenceCode = (String)attributes.get(
			"externalReferenceCode");

		if (externalReferenceCode != null) {
			setExternalReferenceCode(externalReferenceCode);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String colorTheme = (String)attributes.get("colorTheme");

		if (colorTheme != null) {
			setColorTheme(colorTheme);
		}

		String priority = (String)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	@Override
	public CarouselItemsDashboard cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the category of this carousel items dashboard.
	 *
	 * @return the category of this carousel items dashboard
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the category ID of this carousel items dashboard.
	 *
	 * @return the category ID of this carousel items dashboard
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the color theme of this carousel items dashboard.
	 *
	 * @return the color theme of this carousel items dashboard
	 */
	@Override
	public String getColorTheme() {
		return model.getColorTheme();
	}

	/**
	 * Returns the company ID of this carousel items dashboard.
	 *
	 * @return the company ID of this carousel items dashboard
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this carousel items dashboard.
	 *
	 * @return the create date of this carousel items dashboard
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external reference code of this carousel items dashboard.
	 *
	 * @return the external reference code of this carousel items dashboard
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the group ID of this carousel items dashboard.
	 *
	 * @return the group ID of this carousel items dashboard
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this carousel items dashboard.
	 *
	 * @return the modified date of this carousel items dashboard
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this carousel items dashboard.
	 *
	 * @return the mvcc version of this carousel items dashboard
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this carousel items dashboard.
	 *
	 * @return the primary key of this carousel items dashboard
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this carousel items dashboard.
	 *
	 * @return the priority of this carousel items dashboard
	 */
	@Override
	public String getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the title of this carousel items dashboard.
	 *
	 * @return the title of this carousel items dashboard
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this carousel items dashboard.
	 *
	 * @return the user ID of this carousel items dashboard
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this carousel items dashboard.
	 *
	 * @return the user name of this carousel items dashboard
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this carousel items dashboard.
	 *
	 * @return the user uuid of this carousel items dashboard
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this carousel items dashboard.
	 *
	 * @return the uuid of this carousel items dashboard
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the category of this carousel items dashboard.
	 *
	 * @param category the category of this carousel items dashboard
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the category ID of this carousel items dashboard.
	 *
	 * @param categoryId the category ID of this carousel items dashboard
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the color theme of this carousel items dashboard.
	 *
	 * @param colorTheme the color theme of this carousel items dashboard
	 */
	@Override
	public void setColorTheme(String colorTheme) {
		model.setColorTheme(colorTheme);
	}

	/**
	 * Sets the company ID of this carousel items dashboard.
	 *
	 * @param companyId the company ID of this carousel items dashboard
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this carousel items dashboard.
	 *
	 * @param createDate the create date of this carousel items dashboard
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external reference code of this carousel items dashboard.
	 *
	 * @param externalReferenceCode the external reference code of this carousel items dashboard
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the group ID of this carousel items dashboard.
	 *
	 * @param groupId the group ID of this carousel items dashboard
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this carousel items dashboard.
	 *
	 * @param modifiedDate the modified date of this carousel items dashboard
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this carousel items dashboard.
	 *
	 * @param mvccVersion the mvcc version of this carousel items dashboard
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this carousel items dashboard.
	 *
	 * @param primaryKey the primary key of this carousel items dashboard
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this carousel items dashboard.
	 *
	 * @param priority the priority of this carousel items dashboard
	 */
	@Override
	public void setPriority(String priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the title of this carousel items dashboard.
	 *
	 * @param title the title of this carousel items dashboard
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this carousel items dashboard.
	 *
	 * @param userId the user ID of this carousel items dashboard
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this carousel items dashboard.
	 *
	 * @param userName the user name of this carousel items dashboard
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this carousel items dashboard.
	 *
	 * @param userUuid the user uuid of this carousel items dashboard
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this carousel items dashboard.
	 *
	 * @param uuid the uuid of this carousel items dashboard
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CarouselItemsDashboardWrapper wrap(
		CarouselItemsDashboard carouselItemsDashboard) {

		return new CarouselItemsDashboardWrapper(carouselItemsDashboard);
	}

}