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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PersonalList}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonalList
 * @generated
 */
public class PersonalListWrapper
	extends BaseModelWrapper<PersonalList>
	implements ModelWrapper<PersonalList>, PersonalList {

	public PersonalListWrapper(PersonalList personalList) {
		super(personalList);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("personalItemId", getPersonalItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("fileShort", getFileShort());
		attributes.put("launch", isLaunch());
		attributes.put("instancePk", getInstancePk());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long personalItemId = (Long)attributes.get("personalItemId");

		if (personalItemId != null) {
			setPersonalItemId(personalItemId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String fileShort = (String)attributes.get("fileShort");

		if (fileShort != null) {
			setFileShort(fileShort);
		}

		Boolean launch = (Boolean)attributes.get("launch");

		if (launch != null) {
			setLaunch(launch);
		}

		Long instancePk = (Long)attributes.get("instancePk");

		if (instancePk != null) {
			setInstancePk(instancePk);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	@Override
	public PersonalList cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this personal list.
	 *
	 * @return the company ID of this personal list
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this personal list.
	 *
	 * @return the create date of this personal list
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this personal list.
	 *
	 * @return the description of this personal list
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the file short of this personal list.
	 *
	 * @return the file short of this personal list
	 */
	@Override
	public String getFileShort() {
		return model.getFileShort();
	}

	/**
	 * Returns the group ID of this personal list.
	 *
	 * @return the group ID of this personal list
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the instance pk of this personal list.
	 *
	 * @return the instance pk of this personal list
	 */
	@Override
	public long getInstancePk() {
		return model.getInstancePk();
	}

	/**
	 * Returns the launch of this personal list.
	 *
	 * @return the launch of this personal list
	 */
	@Override
	public boolean getLaunch() {
		return model.getLaunch();
	}

	/**
	 * Returns the modified date of this personal list.
	 *
	 * @return the modified date of this personal list
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the personal item ID of this personal list.
	 *
	 * @return the personal item ID of this personal list
	 */
	@Override
	public long getPersonalItemId() {
		return model.getPersonalItemId();
	}

	/**
	 * Returns the primary key of this personal list.
	 *
	 * @return the primary key of this personal list
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this personal list.
	 *
	 * @return the title of this personal list
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this personal list.
	 *
	 * @return the user ID of this personal list
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this personal list.
	 *
	 * @return the user name of this personal list
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this personal list.
	 *
	 * @return the user uuid of this personal list
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this personal list.
	 *
	 * @return the uuid of this personal list
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this personal list is launch.
	 *
	 * @return <code>true</code> if this personal list is launch; <code>false</code> otherwise
	 */
	@Override
	public boolean isLaunch() {
		return model.isLaunch();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this personal list.
	 *
	 * @param companyId the company ID of this personal list
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this personal list.
	 *
	 * @param createDate the create date of this personal list
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this personal list.
	 *
	 * @param description the description of this personal list
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the file short of this personal list.
	 *
	 * @param fileShort the file short of this personal list
	 */
	@Override
	public void setFileShort(String fileShort) {
		model.setFileShort(fileShort);
	}

	/**
	 * Sets the group ID of this personal list.
	 *
	 * @param groupId the group ID of this personal list
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the instance pk of this personal list.
	 *
	 * @param instancePk the instance pk of this personal list
	 */
	@Override
	public void setInstancePk(long instancePk) {
		model.setInstancePk(instancePk);
	}

	/**
	 * Sets whether this personal list is launch.
	 *
	 * @param launch the launch of this personal list
	 */
	@Override
	public void setLaunch(boolean launch) {
		model.setLaunch(launch);
	}

	/**
	 * Sets the modified date of this personal list.
	 *
	 * @param modifiedDate the modified date of this personal list
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the personal item ID of this personal list.
	 *
	 * @param personalItemId the personal item ID of this personal list
	 */
	@Override
	public void setPersonalItemId(long personalItemId) {
		model.setPersonalItemId(personalItemId);
	}

	/**
	 * Sets the primary key of this personal list.
	 *
	 * @param primaryKey the primary key of this personal list
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this personal list.
	 *
	 * @param title the title of this personal list
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this personal list.
	 *
	 * @param userId the user ID of this personal list
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this personal list.
	 *
	 * @param userName the user name of this personal list
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this personal list.
	 *
	 * @param userUuid the user uuid of this personal list
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this personal list.
	 *
	 * @param uuid the uuid of this personal list
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
	protected PersonalListWrapper wrap(PersonalList personalList) {
		return new PersonalListWrapper(personalList);
	}

}