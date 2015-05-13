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
 * This class is a wrapper for {@link ProvisioningAction}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProvisioningAction
 * @generated
 */
public class ProvisioningActionWrapper implements ProvisioningAction,
	ModelWrapper<ProvisioningAction> {
	public ProvisioningActionWrapper(ProvisioningAction provisioningAction) {
		_provisioningAction = provisioningAction;
	}

	public Class<?> getModelClass() {
		return ProvisioningAction.class;
	}

	public String getModelClassName() {
		return ProvisioningAction.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("actionId", getActionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("provisioningId", getProvisioningId());
		attributes.put("commandId", getCommandId());
		attributes.put("priority", getPriority());
		attributes.put("timeout", getTimeout());
		attributes.put("retryEnable", getRetryEnable());
		attributes.put("maxRetry", getMaxRetry());
		attributes.put("logEnable", getLogEnable());
		attributes.put("processClass", getProcessClass());
		attributes.put("processMethod", getProcessMethod());
		attributes.put("properties", getProperties());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long actionId = (Long)attributes.get("actionId");

		if (actionId != null) {
			setActionId(actionId);
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

		Long provisioningId = (Long)attributes.get("provisioningId");

		if (provisioningId != null) {
			setProvisioningId(provisioningId);
		}

		Long commandId = (Long)attributes.get("commandId");

		if (commandId != null) {
			setCommandId(commandId);
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
	* Returns the primary key of this provisioning action.
	*
	* @return the primary key of this provisioning action
	*/
	public long getPrimaryKey() {
		return _provisioningAction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this provisioning action.
	*
	* @param primaryKey the primary key of this provisioning action
	*/
	public void setPrimaryKey(long primaryKey) {
		_provisioningAction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the action ID of this provisioning action.
	*
	* @return the action ID of this provisioning action
	*/
	public long getActionId() {
		return _provisioningAction.getActionId();
	}

	/**
	* Sets the action ID of this provisioning action.
	*
	* @param actionId the action ID of this provisioning action
	*/
	public void setActionId(long actionId) {
		_provisioningAction.setActionId(actionId);
	}

	/**
	* Returns the group ID of this provisioning action.
	*
	* @return the group ID of this provisioning action
	*/
	public long getGroupId() {
		return _provisioningAction.getGroupId();
	}

	/**
	* Sets the group ID of this provisioning action.
	*
	* @param groupId the group ID of this provisioning action
	*/
	public void setGroupId(long groupId) {
		_provisioningAction.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this provisioning action.
	*
	* @return the company ID of this provisioning action
	*/
	public long getCompanyId() {
		return _provisioningAction.getCompanyId();
	}

	/**
	* Sets the company ID of this provisioning action.
	*
	* @param companyId the company ID of this provisioning action
	*/
	public void setCompanyId(long companyId) {
		_provisioningAction.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this provisioning action.
	*
	* @return the user ID of this provisioning action
	*/
	public long getUserId() {
		return _provisioningAction.getUserId();
	}

	/**
	* Sets the user ID of this provisioning action.
	*
	* @param userId the user ID of this provisioning action
	*/
	public void setUserId(long userId) {
		_provisioningAction.setUserId(userId);
	}

	/**
	* Returns the user uuid of this provisioning action.
	*
	* @return the user uuid of this provisioning action
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningAction.getUserUuid();
	}

	/**
	* Sets the user uuid of this provisioning action.
	*
	* @param userUuid the user uuid of this provisioning action
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_provisioningAction.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this provisioning action.
	*
	* @return the create date of this provisioning action
	*/
	public java.util.Date getCreateDate() {
		return _provisioningAction.getCreateDate();
	}

	/**
	* Sets the create date of this provisioning action.
	*
	* @param createDate the create date of this provisioning action
	*/
	public void setCreateDate(java.util.Date createDate) {
		_provisioningAction.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this provisioning action.
	*
	* @return the modified date of this provisioning action
	*/
	public java.util.Date getModifiedDate() {
		return _provisioningAction.getModifiedDate();
	}

	/**
	* Sets the modified date of this provisioning action.
	*
	* @param modifiedDate the modified date of this provisioning action
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_provisioningAction.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the provisioning ID of this provisioning action.
	*
	* @return the provisioning ID of this provisioning action
	*/
	public long getProvisioningId() {
		return _provisioningAction.getProvisioningId();
	}

	/**
	* Sets the provisioning ID of this provisioning action.
	*
	* @param provisioningId the provisioning ID of this provisioning action
	*/
	public void setProvisioningId(long provisioningId) {
		_provisioningAction.setProvisioningId(provisioningId);
	}

	/**
	* Returns the command ID of this provisioning action.
	*
	* @return the command ID of this provisioning action
	*/
	public long getCommandId() {
		return _provisioningAction.getCommandId();
	}

	/**
	* Sets the command ID of this provisioning action.
	*
	* @param commandId the command ID of this provisioning action
	*/
	public void setCommandId(long commandId) {
		_provisioningAction.setCommandId(commandId);
	}

	/**
	* Returns the priority of this provisioning action.
	*
	* @return the priority of this provisioning action
	*/
	public int getPriority() {
		return _provisioningAction.getPriority();
	}

	/**
	* Sets the priority of this provisioning action.
	*
	* @param priority the priority of this provisioning action
	*/
	public void setPriority(int priority) {
		_provisioningAction.setPriority(priority);
	}

	/**
	* Returns the timeout of this provisioning action.
	*
	* @return the timeout of this provisioning action
	*/
	public int getTimeout() {
		return _provisioningAction.getTimeout();
	}

	/**
	* Sets the timeout of this provisioning action.
	*
	* @param timeout the timeout of this provisioning action
	*/
	public void setTimeout(int timeout) {
		_provisioningAction.setTimeout(timeout);
	}

	/**
	* Returns the retry enable of this provisioning action.
	*
	* @return the retry enable of this provisioning action
	*/
	public boolean getRetryEnable() {
		return _provisioningAction.getRetryEnable();
	}

	/**
	* Returns <code>true</code> if this provisioning action is retry enable.
	*
	* @return <code>true</code> if this provisioning action is retry enable; <code>false</code> otherwise
	*/
	public boolean isRetryEnable() {
		return _provisioningAction.isRetryEnable();
	}

	/**
	* Sets whether this provisioning action is retry enable.
	*
	* @param retryEnable the retry enable of this provisioning action
	*/
	public void setRetryEnable(boolean retryEnable) {
		_provisioningAction.setRetryEnable(retryEnable);
	}

	/**
	* Returns the max retry of this provisioning action.
	*
	* @return the max retry of this provisioning action
	*/
	public int getMaxRetry() {
		return _provisioningAction.getMaxRetry();
	}

	/**
	* Sets the max retry of this provisioning action.
	*
	* @param maxRetry the max retry of this provisioning action
	*/
	public void setMaxRetry(int maxRetry) {
		_provisioningAction.setMaxRetry(maxRetry);
	}

	/**
	* Returns the log enable of this provisioning action.
	*
	* @return the log enable of this provisioning action
	*/
	public boolean getLogEnable() {
		return _provisioningAction.getLogEnable();
	}

	/**
	* Returns <code>true</code> if this provisioning action is log enable.
	*
	* @return <code>true</code> if this provisioning action is log enable; <code>false</code> otherwise
	*/
	public boolean isLogEnable() {
		return _provisioningAction.isLogEnable();
	}

	/**
	* Sets whether this provisioning action is log enable.
	*
	* @param logEnable the log enable of this provisioning action
	*/
	public void setLogEnable(boolean logEnable) {
		_provisioningAction.setLogEnable(logEnable);
	}

	/**
	* Returns the process class of this provisioning action.
	*
	* @return the process class of this provisioning action
	*/
	public java.lang.String getProcessClass() {
		return _provisioningAction.getProcessClass();
	}

	/**
	* Sets the process class of this provisioning action.
	*
	* @param processClass the process class of this provisioning action
	*/
	public void setProcessClass(java.lang.String processClass) {
		_provisioningAction.setProcessClass(processClass);
	}

	/**
	* Returns the process method of this provisioning action.
	*
	* @return the process method of this provisioning action
	*/
	public java.lang.String getProcessMethod() {
		return _provisioningAction.getProcessMethod();
	}

	/**
	* Sets the process method of this provisioning action.
	*
	* @param processMethod the process method of this provisioning action
	*/
	public void setProcessMethod(java.lang.String processMethod) {
		_provisioningAction.setProcessMethod(processMethod);
	}

	/**
	* Returns the properties of this provisioning action.
	*
	* @return the properties of this provisioning action
	*/
	public java.lang.String getProperties() {
		return _provisioningAction.getProperties();
	}

	/**
	* Sets the properties of this provisioning action.
	*
	* @param properties the properties of this provisioning action
	*/
	public void setProperties(java.lang.String properties) {
		_provisioningAction.setProperties(properties);
	}

	/**
	* Returns the status of this provisioning action.
	*
	* @return the status of this provisioning action
	*/
	public int getStatus() {
		return _provisioningAction.getStatus();
	}

	/**
	* Sets the status of this provisioning action.
	*
	* @param status the status of this provisioning action
	*/
	public void setStatus(int status) {
		_provisioningAction.setStatus(status);
	}

	/**
	* Returns the description of this provisioning action.
	*
	* @return the description of this provisioning action
	*/
	public java.lang.String getDescription() {
		return _provisioningAction.getDescription();
	}

	/**
	* Sets the description of this provisioning action.
	*
	* @param description the description of this provisioning action
	*/
	public void setDescription(java.lang.String description) {
		_provisioningAction.setDescription(description);
	}

	public boolean isNew() {
		return _provisioningAction.isNew();
	}

	public void setNew(boolean n) {
		_provisioningAction.setNew(n);
	}

	public boolean isCachedModel() {
		return _provisioningAction.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_provisioningAction.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _provisioningAction.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _provisioningAction.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_provisioningAction.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _provisioningAction.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_provisioningAction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProvisioningActionWrapper((ProvisioningAction)_provisioningAction.clone());
	}

	public int compareTo(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction) {
		return _provisioningAction.compareTo(provisioningAction);
	}

	@Override
	public int hashCode() {
		return _provisioningAction.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.ProvisioningAction> toCacheModel() {
		return _provisioningAction.toCacheModel();
	}

	public com.cmc.gateway.domain.model.ProvisioningAction toEscapedModel() {
		return new ProvisioningActionWrapper(_provisioningAction.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _provisioningAction.toString();
	}

	public java.lang.String toXmlString() {
		return _provisioningAction.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_provisioningAction.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProvisioningAction getWrappedProvisioningAction() {
		return _provisioningAction;
	}

	public ProvisioningAction getWrappedModel() {
		return _provisioningAction;
	}

	public void resetOriginalValues() {
		_provisioningAction.resetOriginalValues();
	}

	private ProvisioningAction _provisioningAction;
}