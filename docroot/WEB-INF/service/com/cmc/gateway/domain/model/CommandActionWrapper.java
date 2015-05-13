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
 * This class is a wrapper for {@link CommandAction}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       CommandAction
 * @generated
 */
public class CommandActionWrapper implements CommandAction,
	ModelWrapper<CommandAction> {
	public CommandActionWrapper(CommandAction commandAction) {
		_commandAction = commandAction;
	}

	public Class<?> getModelClass() {
		return CommandAction.class;
	}

	public String getModelClassName() {
		return CommandAction.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("actionId", getActionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("commandId", getCommandId());
		attributes.put("productId", getProductId());
		attributes.put("actionType", getActionType());
		attributes.put("subscriberType", getSubscriberType());
		attributes.put("actionName", getActionName());
		attributes.put("nextActionType", getNextActionType());
		attributes.put("nextCommandId", getNextCommandId());
		attributes.put("processClass", getProcessClass());
		attributes.put("processMethod", getProcessMethod());
		attributes.put("properties", getProperties());
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

		Long commandId = (Long)attributes.get("commandId");

		if (commandId != null) {
			setCommandId(commandId);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String actionType = (String)attributes.get("actionType");

		if (actionType != null) {
			setActionType(actionType);
		}

		Integer subscriberType = (Integer)attributes.get("subscriberType");

		if (subscriberType != null) {
			setSubscriberType(subscriberType);
		}

		String actionName = (String)attributes.get("actionName");

		if (actionName != null) {
			setActionName(actionName);
		}

		String nextActionType = (String)attributes.get("nextActionType");

		if (nextActionType != null) {
			setNextActionType(nextActionType);
		}

		Long nextCommandId = (Long)attributes.get("nextCommandId");

		if (nextCommandId != null) {
			setNextCommandId(nextCommandId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this command action.
	*
	* @return the primary key of this command action
	*/
	public long getPrimaryKey() {
		return _commandAction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this command action.
	*
	* @param primaryKey the primary key of this command action
	*/
	public void setPrimaryKey(long primaryKey) {
		_commandAction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the action ID of this command action.
	*
	* @return the action ID of this command action
	*/
	public long getActionId() {
		return _commandAction.getActionId();
	}

	/**
	* Sets the action ID of this command action.
	*
	* @param actionId the action ID of this command action
	*/
	public void setActionId(long actionId) {
		_commandAction.setActionId(actionId);
	}

	/**
	* Returns the group ID of this command action.
	*
	* @return the group ID of this command action
	*/
	public long getGroupId() {
		return _commandAction.getGroupId();
	}

	/**
	* Sets the group ID of this command action.
	*
	* @param groupId the group ID of this command action
	*/
	public void setGroupId(long groupId) {
		_commandAction.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this command action.
	*
	* @return the company ID of this command action
	*/
	public long getCompanyId() {
		return _commandAction.getCompanyId();
	}

	/**
	* Sets the company ID of this command action.
	*
	* @param companyId the company ID of this command action
	*/
	public void setCompanyId(long companyId) {
		_commandAction.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this command action.
	*
	* @return the user ID of this command action
	*/
	public long getUserId() {
		return _commandAction.getUserId();
	}

	/**
	* Sets the user ID of this command action.
	*
	* @param userId the user ID of this command action
	*/
	public void setUserId(long userId) {
		_commandAction.setUserId(userId);
	}

	/**
	* Returns the user uuid of this command action.
	*
	* @return the user uuid of this command action
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandAction.getUserUuid();
	}

	/**
	* Sets the user uuid of this command action.
	*
	* @param userUuid the user uuid of this command action
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_commandAction.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this command action.
	*
	* @return the create date of this command action
	*/
	public java.util.Date getCreateDate() {
		return _commandAction.getCreateDate();
	}

	/**
	* Sets the create date of this command action.
	*
	* @param createDate the create date of this command action
	*/
	public void setCreateDate(java.util.Date createDate) {
		_commandAction.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this command action.
	*
	* @return the modified date of this command action
	*/
	public java.util.Date getModifiedDate() {
		return _commandAction.getModifiedDate();
	}

	/**
	* Sets the modified date of this command action.
	*
	* @param modifiedDate the modified date of this command action
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_commandAction.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the command ID of this command action.
	*
	* @return the command ID of this command action
	*/
	public long getCommandId() {
		return _commandAction.getCommandId();
	}

	/**
	* Sets the command ID of this command action.
	*
	* @param commandId the command ID of this command action
	*/
	public void setCommandId(long commandId) {
		_commandAction.setCommandId(commandId);
	}

	/**
	* Returns the product ID of this command action.
	*
	* @return the product ID of this command action
	*/
	public long getProductId() {
		return _commandAction.getProductId();
	}

	/**
	* Sets the product ID of this command action.
	*
	* @param productId the product ID of this command action
	*/
	public void setProductId(long productId) {
		_commandAction.setProductId(productId);
	}

	/**
	* Returns the action type of this command action.
	*
	* @return the action type of this command action
	*/
	public java.lang.String getActionType() {
		return _commandAction.getActionType();
	}

	/**
	* Sets the action type of this command action.
	*
	* @param actionType the action type of this command action
	*/
	public void setActionType(java.lang.String actionType) {
		_commandAction.setActionType(actionType);
	}

	/**
	* Returns the subscriber type of this command action.
	*
	* @return the subscriber type of this command action
	*/
	public int getSubscriberType() {
		return _commandAction.getSubscriberType();
	}

	/**
	* Sets the subscriber type of this command action.
	*
	* @param subscriberType the subscriber type of this command action
	*/
	public void setSubscriberType(int subscriberType) {
		_commandAction.setSubscriberType(subscriberType);
	}

	/**
	* Returns the action name of this command action.
	*
	* @return the action name of this command action
	*/
	public java.lang.String getActionName() {
		return _commandAction.getActionName();
	}

	/**
	* Sets the action name of this command action.
	*
	* @param actionName the action name of this command action
	*/
	public void setActionName(java.lang.String actionName) {
		_commandAction.setActionName(actionName);
	}

	/**
	* Returns the next action type of this command action.
	*
	* @return the next action type of this command action
	*/
	public java.lang.String getNextActionType() {
		return _commandAction.getNextActionType();
	}

	/**
	* Sets the next action type of this command action.
	*
	* @param nextActionType the next action type of this command action
	*/
	public void setNextActionType(java.lang.String nextActionType) {
		_commandAction.setNextActionType(nextActionType);
	}

	/**
	* Returns the next command ID of this command action.
	*
	* @return the next command ID of this command action
	*/
	public long getNextCommandId() {
		return _commandAction.getNextCommandId();
	}

	/**
	* Sets the next command ID of this command action.
	*
	* @param nextCommandId the next command ID of this command action
	*/
	public void setNextCommandId(long nextCommandId) {
		_commandAction.setNextCommandId(nextCommandId);
	}

	/**
	* Returns the process class of this command action.
	*
	* @return the process class of this command action
	*/
	public java.lang.String getProcessClass() {
		return _commandAction.getProcessClass();
	}

	/**
	* Sets the process class of this command action.
	*
	* @param processClass the process class of this command action
	*/
	public void setProcessClass(java.lang.String processClass) {
		_commandAction.setProcessClass(processClass);
	}

	/**
	* Returns the process method of this command action.
	*
	* @return the process method of this command action
	*/
	public java.lang.String getProcessMethod() {
		return _commandAction.getProcessMethod();
	}

	/**
	* Sets the process method of this command action.
	*
	* @param processMethod the process method of this command action
	*/
	public void setProcessMethod(java.lang.String processMethod) {
		_commandAction.setProcessMethod(processMethod);
	}

	/**
	* Returns the properties of this command action.
	*
	* @return the properties of this command action
	*/
	public java.lang.String getProperties() {
		return _commandAction.getProperties();
	}

	/**
	* Sets the properties of this command action.
	*
	* @param properties the properties of this command action
	*/
	public void setProperties(java.lang.String properties) {
		_commandAction.setProperties(properties);
	}

	/**
	* Returns the description of this command action.
	*
	* @return the description of this command action
	*/
	public java.lang.String getDescription() {
		return _commandAction.getDescription();
	}

	/**
	* Sets the description of this command action.
	*
	* @param description the description of this command action
	*/
	public void setDescription(java.lang.String description) {
		_commandAction.setDescription(description);
	}

	public boolean isNew() {
		return _commandAction.isNew();
	}

	public void setNew(boolean n) {
		_commandAction.setNew(n);
	}

	public boolean isCachedModel() {
		return _commandAction.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_commandAction.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _commandAction.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _commandAction.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_commandAction.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _commandAction.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_commandAction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CommandActionWrapper((CommandAction)_commandAction.clone());
	}

	public int compareTo(
		com.cmc.gateway.domain.model.CommandAction commandAction) {
		return _commandAction.compareTo(commandAction);
	}

	@Override
	public int hashCode() {
		return _commandAction.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.CommandAction> toCacheModel() {
		return _commandAction.toCacheModel();
	}

	public com.cmc.gateway.domain.model.CommandAction toEscapedModel() {
		return new CommandActionWrapper(_commandAction.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _commandAction.toString();
	}

	public java.lang.String toXmlString() {
		return _commandAction.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_commandAction.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CommandAction getWrappedCommandAction() {
		return _commandAction;
	}

	public CommandAction getWrappedModel() {
		return _commandAction;
	}

	public void resetOriginalValues() {
		_commandAction.resetOriginalValues();
	}

	private CommandAction _commandAction;
}