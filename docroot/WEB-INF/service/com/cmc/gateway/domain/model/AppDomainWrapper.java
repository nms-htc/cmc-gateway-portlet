/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.cmc.gateway.domain.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AppDomain}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       AppDomain
 * @generated
 */
public class AppDomainWrapper implements AppDomain, ModelWrapper<AppDomain> {
	public AppDomainWrapper(AppDomain appDomain) {
		_appDomain = appDomain;
	}

	public Class<?> getModelClass() {
		return AppDomain.class;
	}

	public String getModelClassName() {
		return AppDomain.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("domainId", getDomainId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("type", getType());
		attributes.put("code", getCode());
		attributes.put("title", getTitle());
		attributes.put("value", getValue());
		attributes.put("defaultValue", getDefaultValue());
		attributes.put("description", getDescription());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long domainId = (Long)attributes.get("domainId");

		if (domainId != null) {
			setDomainId(domainId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Boolean defaultValue = (Boolean)attributes.get("defaultValue");

		if (defaultValue != null) {
			setDefaultValue(defaultValue);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this app domain.
	*
	* @return the primary key of this app domain
	*/
	public long getPrimaryKey() {
		return _appDomain.getPrimaryKey();
	}

	/**
	* Sets the primary key of this app domain.
	*
	* @param primaryKey the primary key of this app domain
	*/
	public void setPrimaryKey(long primaryKey) {
		_appDomain.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the domain ID of this app domain.
	*
	* @return the domain ID of this app domain
	*/
	public long getDomainId() {
		return _appDomain.getDomainId();
	}

	/**
	* Sets the domain ID of this app domain.
	*
	* @param domainId the domain ID of this app domain
	*/
	public void setDomainId(long domainId) {
		_appDomain.setDomainId(domainId);
	}

	/**
	* Returns the group ID of this app domain.
	*
	* @return the group ID of this app domain
	*/
	public long getGroupId() {
		return _appDomain.getGroupId();
	}

	/**
	* Sets the group ID of this app domain.
	*
	* @param groupId the group ID of this app domain
	*/
	public void setGroupId(long groupId) {
		_appDomain.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this app domain.
	*
	* @return the company ID of this app domain
	*/
	public long getCompanyId() {
		return _appDomain.getCompanyId();
	}

	/**
	* Sets the company ID of this app domain.
	*
	* @param companyId the company ID of this app domain
	*/
	public void setCompanyId(long companyId) {
		_appDomain.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this app domain.
	*
	* @return the user ID of this app domain
	*/
	public long getUserId() {
		return _appDomain.getUserId();
	}

	/**
	* Sets the user ID of this app domain.
	*
	* @param userId the user ID of this app domain
	*/
	public void setUserId(long userId) {
		_appDomain.setUserId(userId);
	}

	/**
	* Returns the user uuid of this app domain.
	*
	* @return the user uuid of this app domain
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appDomain.getUserUuid();
	}

	/**
	* Sets the user uuid of this app domain.
	*
	* @param userUuid the user uuid of this app domain
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_appDomain.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this app domain.
	*
	* @return the create date of this app domain
	*/
	public java.util.Date getCreateDate() {
		return _appDomain.getCreateDate();
	}

	/**
	* Sets the create date of this app domain.
	*
	* @param createDate the create date of this app domain
	*/
	public void setCreateDate(java.util.Date createDate) {
		_appDomain.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this app domain.
	*
	* @return the modified date of this app domain
	*/
	public java.util.Date getModifiedDate() {
		return _appDomain.getModifiedDate();
	}

	/**
	* Sets the modified date of this app domain.
	*
	* @param modifiedDate the modified date of this app domain
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_appDomain.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the type of this app domain.
	*
	* @return the type of this app domain
	*/
	public java.lang.String getType() {
		return _appDomain.getType();
	}

	/**
	* Sets the type of this app domain.
	*
	* @param type the type of this app domain
	*/
	public void setType(java.lang.String type) {
		_appDomain.setType(type);
	}

	/**
	* Returns the code of this app domain.
	*
	* @return the code of this app domain
	*/
	public java.lang.String getCode() {
		return _appDomain.getCode();
	}

	/**
	* Sets the code of this app domain.
	*
	* @param code the code of this app domain
	*/
	public void setCode(java.lang.String code) {
		_appDomain.setCode(code);
	}

	/**
	* Returns the title of this app domain.
	*
	* @return the title of this app domain
	*/
	public java.lang.String getTitle() {
		return _appDomain.getTitle();
	}

	/**
	* Sets the title of this app domain.
	*
	* @param title the title of this app domain
	*/
	public void setTitle(java.lang.String title) {
		_appDomain.setTitle(title);
	}

	/**
	* Returns the value of this app domain.
	*
	* @return the value of this app domain
	*/
	public java.lang.String getValue() {
		return _appDomain.getValue();
	}

	/**
	* Sets the value of this app domain.
	*
	* @param value the value of this app domain
	*/
	public void setValue(java.lang.String value) {
		_appDomain.setValue(value);
	}

	/**
	* Returns the default value of this app domain.
	*
	* @return the default value of this app domain
	*/
	public boolean getDefaultValue() {
		return _appDomain.getDefaultValue();
	}

	/**
	* Returns <code>true</code> if this app domain is default value.
	*
	* @return <code>true</code> if this app domain is default value; <code>false</code> otherwise
	*/
	public boolean isDefaultValue() {
		return _appDomain.isDefaultValue();
	}

	/**
	* Sets whether this app domain is default value.
	*
	* @param defaultValue the default value of this app domain
	*/
	public void setDefaultValue(boolean defaultValue) {
		_appDomain.setDefaultValue(defaultValue);
	}

	/**
	* Returns the description of this app domain.
	*
	* @return the description of this app domain
	*/
	public java.lang.String getDescription() {
		return _appDomain.getDescription();
	}

	/**
	* Sets the description of this app domain.
	*
	* @param description the description of this app domain
	*/
	public void setDescription(java.lang.String description) {
		_appDomain.setDescription(description);
	}

	public boolean isNew() {
		return _appDomain.isNew();
	}

	public void setNew(boolean n) {
		_appDomain.setNew(n);
	}

	public boolean isCachedModel() {
		return _appDomain.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_appDomain.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _appDomain.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _appDomain.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_appDomain.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _appDomain.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_appDomain.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AppDomainWrapper((AppDomain)_appDomain.clone());
	}

	public int compareTo(com.cmc.gateway.domain.model.AppDomain appDomain) {
		return _appDomain.compareTo(appDomain);
	}

	@Override
	public int hashCode() {
		return _appDomain.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.AppDomain> toCacheModel() {
		return _appDomain.toCacheModel();
	}

	public com.cmc.gateway.domain.model.AppDomain toEscapedModel() {
		return new AppDomainWrapper(_appDomain.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _appDomain.toString();
	}

	public java.lang.String toXmlString() {
		return _appDomain.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_appDomain.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AppDomain getWrappedAppDomain() {
		return _appDomain;
	}

	public AppDomain getWrappedModel() {
		return _appDomain;
	}

	public void resetOriginalValues() {
		_appDomain.resetOriginalValues();
	}

	private AppDomain _appDomain;
}