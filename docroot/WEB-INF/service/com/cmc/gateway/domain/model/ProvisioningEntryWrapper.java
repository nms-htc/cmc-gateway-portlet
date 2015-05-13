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
 * This class is a wrapper for {@link ProvisioningEntry}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProvisioningEntry
 * @generated
 */
public class ProvisioningEntryWrapper implements ProvisioningEntry,
	ModelWrapper<ProvisioningEntry> {
	public ProvisioningEntryWrapper(ProvisioningEntry provisioningEntry) {
		_provisioningEntry = provisioningEntry;
	}

	public Class<?> getModelClass() {
		return ProvisioningEntry.class;
	}

	public String getModelClassName() {
		return ProvisioningEntry.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("provisioningId", getProvisioningId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("provisioningType", getProvisioningType());
		attributes.put("code", getCode());
		attributes.put("title", getTitle());
		attributes.put("connectionHost", getConnectionHost());
		attributes.put("connectionPort", getConnectionPort());
		attributes.put("connectByUserName", getConnectByUserName());
		attributes.put("connectByPassword", getConnectByPassword());
		attributes.put("processClass", getProcessClass());
		attributes.put("processMethod", getProcessMethod());
		attributes.put("properties", getProperties());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long provisioningId = (Long)attributes.get("provisioningId");

		if (provisioningId != null) {
			setProvisioningId(provisioningId);
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

		String provisioningType = (String)attributes.get("provisioningType");

		if (provisioningType != null) {
			setProvisioningType(provisioningType);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String connectionHost = (String)attributes.get("connectionHost");

		if (connectionHost != null) {
			setConnectionHost(connectionHost);
		}

		Integer connectionPort = (Integer)attributes.get("connectionPort");

		if (connectionPort != null) {
			setConnectionPort(connectionPort);
		}

		String connectByUserName = (String)attributes.get("connectByUserName");

		if (connectByUserName != null) {
			setConnectByUserName(connectByUserName);
		}

		String connectByPassword = (String)attributes.get("connectByPassword");

		if (connectByPassword != null) {
			setConnectByPassword(connectByPassword);
		}

		String processClass = (String)attributes.get("processClass");

		if (processClass != null) {
			setProcessClass(processClass);
		}

		String processMethod = (String)attributes.get("processMethod");

		if (processMethod != null) {
			setProcessMethod(processMethod);
		}

		String properties = (String)attributes.get("properties");

		if (properties != null) {
			setProperties(properties);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this provisioning entry.
	*
	* @return the primary key of this provisioning entry
	*/
	public long getPrimaryKey() {
		return _provisioningEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this provisioning entry.
	*
	* @param primaryKey the primary key of this provisioning entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_provisioningEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the provisioning ID of this provisioning entry.
	*
	* @return the provisioning ID of this provisioning entry
	*/
	public long getProvisioningId() {
		return _provisioningEntry.getProvisioningId();
	}

	/**
	* Sets the provisioning ID of this provisioning entry.
	*
	* @param provisioningId the provisioning ID of this provisioning entry
	*/
	public void setProvisioningId(long provisioningId) {
		_provisioningEntry.setProvisioningId(provisioningId);
	}

	/**
	* Returns the group ID of this provisioning entry.
	*
	* @return the group ID of this provisioning entry
	*/
	public long getGroupId() {
		return _provisioningEntry.getGroupId();
	}

	/**
	* Sets the group ID of this provisioning entry.
	*
	* @param groupId the group ID of this provisioning entry
	*/
	public void setGroupId(long groupId) {
		_provisioningEntry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this provisioning entry.
	*
	* @return the company ID of this provisioning entry
	*/
	public long getCompanyId() {
		return _provisioningEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this provisioning entry.
	*
	* @param companyId the company ID of this provisioning entry
	*/
	public void setCompanyId(long companyId) {
		_provisioningEntry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this provisioning entry.
	*
	* @return the user ID of this provisioning entry
	*/
	public long getUserId() {
		return _provisioningEntry.getUserId();
	}

	/**
	* Sets the user ID of this provisioning entry.
	*
	* @param userId the user ID of this provisioning entry
	*/
	public void setUserId(long userId) {
		_provisioningEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this provisioning entry.
	*
	* @return the user uuid of this provisioning entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this provisioning entry.
	*
	* @param userUuid the user uuid of this provisioning entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_provisioningEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this provisioning entry.
	*
	* @return the create date of this provisioning entry
	*/
	public java.util.Date getCreateDate() {
		return _provisioningEntry.getCreateDate();
	}

	/**
	* Sets the create date of this provisioning entry.
	*
	* @param createDate the create date of this provisioning entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_provisioningEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this provisioning entry.
	*
	* @return the modified date of this provisioning entry
	*/
	public java.util.Date getModifiedDate() {
		return _provisioningEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this provisioning entry.
	*
	* @param modifiedDate the modified date of this provisioning entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_provisioningEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the provisioning type of this provisioning entry.
	*
	* @return the provisioning type of this provisioning entry
	*/
	public java.lang.String getProvisioningType() {
		return _provisioningEntry.getProvisioningType();
	}

	/**
	* Sets the provisioning type of this provisioning entry.
	*
	* @param provisioningType the provisioning type of this provisioning entry
	*/
	public void setProvisioningType(java.lang.String provisioningType) {
		_provisioningEntry.setProvisioningType(provisioningType);
	}

	/**
	* Returns the code of this provisioning entry.
	*
	* @return the code of this provisioning entry
	*/
	public java.lang.String getCode() {
		return _provisioningEntry.getCode();
	}

	/**
	* Sets the code of this provisioning entry.
	*
	* @param code the code of this provisioning entry
	*/
	public void setCode(java.lang.String code) {
		_provisioningEntry.setCode(code);
	}

	/**
	* Returns the title of this provisioning entry.
	*
	* @return the title of this provisioning entry
	*/
	public java.lang.String getTitle() {
		return _provisioningEntry.getTitle();
	}

	/**
	* Sets the title of this provisioning entry.
	*
	* @param title the title of this provisioning entry
	*/
	public void setTitle(java.lang.String title) {
		_provisioningEntry.setTitle(title);
	}

	/**
	* Returns the connection host of this provisioning entry.
	*
	* @return the connection host of this provisioning entry
	*/
	public java.lang.String getConnectionHost() {
		return _provisioningEntry.getConnectionHost();
	}

	/**
	* Sets the connection host of this provisioning entry.
	*
	* @param connectionHost the connection host of this provisioning entry
	*/
	public void setConnectionHost(java.lang.String connectionHost) {
		_provisioningEntry.setConnectionHost(connectionHost);
	}

	/**
	* Returns the connection port of this provisioning entry.
	*
	* @return the connection port of this provisioning entry
	*/
	public int getConnectionPort() {
		return _provisioningEntry.getConnectionPort();
	}

	/**
	* Sets the connection port of this provisioning entry.
	*
	* @param connectionPort the connection port of this provisioning entry
	*/
	public void setConnectionPort(int connectionPort) {
		_provisioningEntry.setConnectionPort(connectionPort);
	}

	/**
	* Returns the connect by user name of this provisioning entry.
	*
	* @return the connect by user name of this provisioning entry
	*/
	public java.lang.String getConnectByUserName() {
		return _provisioningEntry.getConnectByUserName();
	}

	/**
	* Sets the connect by user name of this provisioning entry.
	*
	* @param connectByUserName the connect by user name of this provisioning entry
	*/
	public void setConnectByUserName(java.lang.String connectByUserName) {
		_provisioningEntry.setConnectByUserName(connectByUserName);
	}

	/**
	* Returns the connect by password of this provisioning entry.
	*
	* @return the connect by password of this provisioning entry
	*/
	public java.lang.String getConnectByPassword() {
		return _provisioningEntry.getConnectByPassword();
	}

	/**
	* Sets the connect by password of this provisioning entry.
	*
	* @param connectByPassword the connect by password of this provisioning entry
	*/
	public void setConnectByPassword(java.lang.String connectByPassword) {
		_provisioningEntry.setConnectByPassword(connectByPassword);
	}

	/**
	* Returns the process class of this provisioning entry.
	*
	* @return the process class of this provisioning entry
	*/
	public java.lang.String getProcessClass() {
		return _provisioningEntry.getProcessClass();
	}

	/**
	* Sets the process class of this provisioning entry.
	*
	* @param processClass the process class of this provisioning entry
	*/
	public void setProcessClass(java.lang.String processClass) {
		_provisioningEntry.setProcessClass(processClass);
	}

	/**
	* Returns the process method of this provisioning entry.
	*
	* @return the process method of this provisioning entry
	*/
	public java.lang.String getProcessMethod() {
		return _provisioningEntry.getProcessMethod();
	}

	/**
	* Sets the process method of this provisioning entry.
	*
	* @param processMethod the process method of this provisioning entry
	*/
	public void setProcessMethod(java.lang.String processMethod) {
		_provisioningEntry.setProcessMethod(processMethod);
	}

	/**
	* Returns the properties of this provisioning entry.
	*
	* @return the properties of this provisioning entry
	*/
	public java.lang.String getProperties() {
		return _provisioningEntry.getProperties();
	}

	/**
	* Sets the properties of this provisioning entry.
	*
	* @param properties the properties of this provisioning entry
	*/
	public void setProperties(java.lang.String properties) {
		_provisioningEntry.setProperties(properties);
	}

	/**
	* Returns the status of this provisioning entry.
	*
	* @return the status of this provisioning entry
	*/
	public int getStatus() {
		return _provisioningEntry.getStatus();
	}

	/**
	* Sets the status of this provisioning entry.
	*
	* @param status the status of this provisioning entry
	*/
	public void setStatus(int status) {
		_provisioningEntry.setStatus(status);
	}

	/**
	* Returns the description of this provisioning entry.
	*
	* @return the description of this provisioning entry
	*/
	public java.lang.String getDescription() {
		return _provisioningEntry.getDescription();
	}

	/**
	* Sets the description of this provisioning entry.
	*
	* @param description the description of this provisioning entry
	*/
	public void setDescription(java.lang.String description) {
		_provisioningEntry.setDescription(description);
	}

	public boolean isNew() {
		return _provisioningEntry.isNew();
	}

	public void setNew(boolean n) {
		_provisioningEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _provisioningEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_provisioningEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _provisioningEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _provisioningEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_provisioningEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _provisioningEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_provisioningEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProvisioningEntryWrapper((ProvisioningEntry)_provisioningEntry.clone());
	}

	public int compareTo(
		com.cmc.gateway.domain.model.ProvisioningEntry provisioningEntry) {
		return _provisioningEntry.compareTo(provisioningEntry);
	}

	@Override
	public int hashCode() {
		return _provisioningEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.ProvisioningEntry> toCacheModel() {
		return _provisioningEntry.toCacheModel();
	}

	public com.cmc.gateway.domain.model.ProvisioningEntry toEscapedModel() {
		return new ProvisioningEntryWrapper(_provisioningEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _provisioningEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _provisioningEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_provisioningEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProvisioningEntry getWrappedProvisioningEntry() {
		return _provisioningEntry;
	}

	public ProvisioningEntry getWrappedModel() {
		return _provisioningEntry;
	}

	public void resetOriginalValues() {
		_provisioningEntry.resetOriginalValues();
	}

	private ProvisioningEntry _provisioningEntry;
}