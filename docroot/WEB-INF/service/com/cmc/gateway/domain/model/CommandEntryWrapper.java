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
 * This class is a wrapper for {@link CommandEntry}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       CommandEntry
 * @generated
 */
public class CommandEntryWrapper implements CommandEntry,
	ModelWrapper<CommandEntry> {
	public CommandEntryWrapper(CommandEntry commandEntry) {
		_commandEntry = commandEntry;
	}

	public Class<?> getModelClass() {
		return CommandEntry.class;
	}

	public String getModelClassName() {
		return CommandEntry.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commandId", getCommandId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("provisioningType", getProvisioningType());
		attributes.put("code", getCode());
		attributes.put("title", getTitle());
		attributes.put("priority", getPriority());
		attributes.put("timeout", getTimeout());
		attributes.put("retryEnable", getRetryEnable());
		attributes.put("maxRetry", getMaxRetry());
		attributes.put("logEnable", getLogEnable());
		attributes.put("properties", getProperties());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long commandId = (Long)attributes.get("commandId");

		if (commandId != null) {
			setCommandId(commandId);
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

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Integer timeout = (Integer)attributes.get("timeout");

		if (timeout != null) {
			setTimeout(timeout);
		}

		Boolean retryEnable = (Boolean)attributes.get("retryEnable");

		if (retryEnable != null) {
			setRetryEnable(retryEnable);
		}

		Integer maxRetry = (Integer)attributes.get("maxRetry");

		if (maxRetry != null) {
			setMaxRetry(maxRetry);
		}

		Boolean logEnable = (Boolean)attributes.get("logEnable");

		if (logEnable != null) {
			setLogEnable(logEnable);
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
	* Returns the primary key of this command entry.
	*
	* @return the primary key of this command entry
	*/
	public long getPrimaryKey() {
		return _commandEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this command entry.
	*
	* @param primaryKey the primary key of this command entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_commandEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the command ID of this command entry.
	*
	* @return the command ID of this command entry
	*/
	public long getCommandId() {
		return _commandEntry.getCommandId();
	}

	/**
	* Sets the command ID of this command entry.
	*
	* @param commandId the command ID of this command entry
	*/
	public void setCommandId(long commandId) {
		_commandEntry.setCommandId(commandId);
	}

	/**
	* Returns the group ID of this command entry.
	*
	* @return the group ID of this command entry
	*/
	public long getGroupId() {
		return _commandEntry.getGroupId();
	}

	/**
	* Sets the group ID of this command entry.
	*
	* @param groupId the group ID of this command entry
	*/
	public void setGroupId(long groupId) {
		_commandEntry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this command entry.
	*
	* @return the company ID of this command entry
	*/
	public long getCompanyId() {
		return _commandEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this command entry.
	*
	* @param companyId the company ID of this command entry
	*/
	public void setCompanyId(long companyId) {
		_commandEntry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this command entry.
	*
	* @return the user ID of this command entry
	*/
	public long getUserId() {
		return _commandEntry.getUserId();
	}

	/**
	* Sets the user ID of this command entry.
	*
	* @param userId the user ID of this command entry
	*/
	public void setUserId(long userId) {
		_commandEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this command entry.
	*
	* @return the user uuid of this command entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this command entry.
	*
	* @param userUuid the user uuid of this command entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_commandEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this command entry.
	*
	* @return the create date of this command entry
	*/
	public java.util.Date getCreateDate() {
		return _commandEntry.getCreateDate();
	}

	/**
	* Sets the create date of this command entry.
	*
	* @param createDate the create date of this command entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_commandEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this command entry.
	*
	* @return the modified date of this command entry
	*/
	public java.util.Date getModifiedDate() {
		return _commandEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this command entry.
	*
	* @param modifiedDate the modified date of this command entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_commandEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the provisioning type of this command entry.
	*
	* @return the provisioning type of this command entry
	*/
	public java.lang.String getProvisioningType() {
		return _commandEntry.getProvisioningType();
	}

	/**
	* Sets the provisioning type of this command entry.
	*
	* @param provisioningType the provisioning type of this command entry
	*/
	public void setProvisioningType(java.lang.String provisioningType) {
		_commandEntry.setProvisioningType(provisioningType);
	}

	/**
	* Returns the code of this command entry.
	*
	* @return the code of this command entry
	*/
	public java.lang.String getCode() {
		return _commandEntry.getCode();
	}

	/**
	* Sets the code of this command entry.
	*
	* @param code the code of this command entry
	*/
	public void setCode(java.lang.String code) {
		_commandEntry.setCode(code);
	}

	/**
	* Returns the title of this command entry.
	*
	* @return the title of this command entry
	*/
	public java.lang.String getTitle() {
		return _commandEntry.getTitle();
	}

	/**
	* Sets the title of this command entry.
	*
	* @param title the title of this command entry
	*/
	public void setTitle(java.lang.String title) {
		_commandEntry.setTitle(title);
	}

	/**
	* Returns the priority of this command entry.
	*
	* @return the priority of this command entry
	*/
	public int getPriority() {
		return _commandEntry.getPriority();
	}

	/**
	* Sets the priority of this command entry.
	*
	* @param priority the priority of this command entry
	*/
	public void setPriority(int priority) {
		_commandEntry.setPriority(priority);
	}

	/**
	* Returns the timeout of this command entry.
	*
	* @return the timeout of this command entry
	*/
	public int getTimeout() {
		return _commandEntry.getTimeout();
	}

	/**
	* Sets the timeout of this command entry.
	*
	* @param timeout the timeout of this command entry
	*/
	public void setTimeout(int timeout) {
		_commandEntry.setTimeout(timeout);
	}

	/**
	* Returns the retry enable of this command entry.
	*
	* @return the retry enable of this command entry
	*/
	public boolean getRetryEnable() {
		return _commandEntry.getRetryEnable();
	}

	/**
	* Returns <code>true</code> if this command entry is retry enable.
	*
	* @return <code>true</code> if this command entry is retry enable; <code>false</code> otherwise
	*/
	public boolean isRetryEnable() {
		return _commandEntry.isRetryEnable();
	}

	/**
	* Sets whether this command entry is retry enable.
	*
	* @param retryEnable the retry enable of this command entry
	*/
	public void setRetryEnable(boolean retryEnable) {
		_commandEntry.setRetryEnable(retryEnable);
	}

	/**
	* Returns the max retry of this command entry.
	*
	* @return the max retry of this command entry
	*/
	public int getMaxRetry() {
		return _commandEntry.getMaxRetry();
	}

	/**
	* Sets the max retry of this command entry.
	*
	* @param maxRetry the max retry of this command entry
	*/
	public void setMaxRetry(int maxRetry) {
		_commandEntry.setMaxRetry(maxRetry);
	}

	/**
	* Returns the log enable of this command entry.
	*
	* @return the log enable of this command entry
	*/
	public boolean getLogEnable() {
		return _commandEntry.getLogEnable();
	}

	/**
	* Returns <code>true</code> if this command entry is log enable.
	*
	* @return <code>true</code> if this command entry is log enable; <code>false</code> otherwise
	*/
	public boolean isLogEnable() {
		return _commandEntry.isLogEnable();
	}

	/**
	* Sets whether this command entry is log enable.
	*
	* @param logEnable the log enable of this command entry
	*/
	public void setLogEnable(boolean logEnable) {
		_commandEntry.setLogEnable(logEnable);
	}

	/**
	* Returns the properties of this command entry.
	*
	* @return the properties of this command entry
	*/
	public java.lang.String getProperties() {
		return _commandEntry.getProperties();
	}

	/**
	* Sets the properties of this command entry.
	*
	* @param properties the properties of this command entry
	*/
	public void setProperties(java.lang.String properties) {
		_commandEntry.setProperties(properties);
	}

	/**
	* Returns the status of this command entry.
	*
	* @return the status of this command entry
	*/
	public int getStatus() {
		return _commandEntry.getStatus();
	}

	/**
	* Sets the status of this command entry.
	*
	* @param status the status of this command entry
	*/
	public void setStatus(int status) {
		_commandEntry.setStatus(status);
	}

	/**
	* Returns the description of this command entry.
	*
	* @return the description of this command entry
	*/
	public java.lang.String getDescription() {
		return _commandEntry.getDescription();
	}

	/**
	* Sets the description of this command entry.
	*
	* @param description the description of this command entry
	*/
	public void setDescription(java.lang.String description) {
		_commandEntry.setDescription(description);
	}

	public boolean isNew() {
		return _commandEntry.isNew();
	}

	public void setNew(boolean n) {
		_commandEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _commandEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_commandEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _commandEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _commandEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_commandEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _commandEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_commandEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CommandEntryWrapper((CommandEntry)_commandEntry.clone());
	}

	public int compareTo(com.cmc.gateway.domain.model.CommandEntry commandEntry) {
		return _commandEntry.compareTo(commandEntry);
	}

	@Override
	public int hashCode() {
		return _commandEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.CommandEntry> toCacheModel() {
		return _commandEntry.toCacheModel();
	}

	public com.cmc.gateway.domain.model.CommandEntry toEscapedModel() {
		return new CommandEntryWrapper(_commandEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _commandEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _commandEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_commandEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CommandEntry getWrappedCommandEntry() {
		return _commandEntry;
	}

	public CommandEntry getWrappedModel() {
		return _commandEntry;
	}

	public void resetOriginalValues() {
		_commandEntry.resetOriginalValues();
	}

	private CommandEntry _commandEntry;
}