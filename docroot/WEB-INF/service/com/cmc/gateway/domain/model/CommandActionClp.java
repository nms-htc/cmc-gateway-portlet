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

import com.cmc.gateway.domain.service.CommandActionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard Nguyen
 */
public class CommandActionClp extends BaseModelImpl<CommandAction>
	implements CommandAction {
	public CommandActionClp() {
	}

	public Class<?> getModelClass() {
		return CommandAction.class;
	}

	public String getModelClassName() {
		return CommandAction.class.getName();
	}

	public long getPrimaryKey() {
		return _actionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setActionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_actionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getActionId() {
		return _actionId;
	}

	public void setActionId(long actionId) {
		_actionId = actionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCommandId() {
		return _commandId;
	}

	public void setCommandId(long commandId) {
		_commandId = commandId;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public String getActionType() {
		return _actionType;
	}

	public void setActionType(String actionType) {
		_actionType = actionType;
	}

	public int getSubscriberType() {
		return _subscriberType;
	}

	public void setSubscriberType(int subscriberType) {
		_subscriberType = subscriberType;
	}

	public String getActionName() {
		return _actionName;
	}

	public void setActionName(String actionName) {
		_actionName = actionName;
	}

	public String getNextActionType() {
		return _nextActionType;
	}

	public void setNextActionType(String nextActionType) {
		_nextActionType = nextActionType;
	}

	public long getNextCommandId() {
		return _nextCommandId;
	}

	public void setNextCommandId(long nextCommandId) {
		_nextCommandId = nextCommandId;
	}

	public String getProcessClass() {
		return _processClass;
	}

	public void setProcessClass(String processClass) {
		_processClass = processClass;
	}

	public String getProcessMethod() {
		return _processMethod;
	}

	public void setProcessMethod(String processMethod) {
		_processMethod = processMethod;
	}

	public String getProperties() {
		return _properties;
	}

	public void setProperties(String properties) {
		_properties = properties;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public BaseModel<?> getCommandActionRemoteModel() {
		return _commandActionRemoteModel;
	}

	public void setCommandActionRemoteModel(
		BaseModel<?> commandActionRemoteModel) {
		_commandActionRemoteModel = commandActionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CommandActionLocalServiceUtil.addCommandAction(this);
		}
		else {
			CommandActionLocalServiceUtil.updateCommandAction(this);
		}
	}

	@Override
	public CommandAction toEscapedModel() {
		return (CommandAction)Proxy.newProxyInstance(CommandAction.class.getClassLoader(),
			new Class[] { CommandAction.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CommandActionClp clone = new CommandActionClp();

		clone.setActionId(getActionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCommandId(getCommandId());
		clone.setProductId(getProductId());
		clone.setActionType(getActionType());
		clone.setSubscriberType(getSubscriberType());
		clone.setActionName(getActionName());
		clone.setNextActionType(getNextActionType());
		clone.setNextCommandId(getNextCommandId());
		clone.setProcessClass(getProcessClass());
		clone.setProcessMethod(getProcessMethod());
		clone.setProperties(getProperties());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(CommandAction commandAction) {
		int value = 0;

		value = getActionName().compareTo(commandAction.getActionName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CommandActionClp commandAction = null;

		try {
			commandAction = (CommandActionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = commandAction.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{actionId=");
		sb.append(getActionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", commandId=");
		sb.append(getCommandId());
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", actionType=");
		sb.append(getActionType());
		sb.append(", subscriberType=");
		sb.append(getSubscriberType());
		sb.append(", actionName=");
		sb.append(getActionName());
		sb.append(", nextActionType=");
		sb.append(getNextActionType());
		sb.append(", nextCommandId=");
		sb.append(getNextCommandId());
		sb.append(", processClass=");
		sb.append(getProcessClass());
		sb.append(", processMethod=");
		sb.append(getProcessMethod());
		sb.append(", properties=");
		sb.append(getProperties());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.cmc.gateway.domain.model.CommandAction");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>actionId</column-name><column-value><![CDATA[");
		sb.append(getActionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commandId</column-name><column-value><![CDATA[");
		sb.append(getCommandId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionType</column-name><column-value><![CDATA[");
		sb.append(getActionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subscriberType</column-name><column-value><![CDATA[");
		sb.append(getSubscriberType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionName</column-name><column-value><![CDATA[");
		sb.append(getActionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nextActionType</column-name><column-value><![CDATA[");
		sb.append(getNextActionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nextCommandId</column-name><column-value><![CDATA[");
		sb.append(getNextCommandId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processClass</column-name><column-value><![CDATA[");
		sb.append(getProcessClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processMethod</column-name><column-value><![CDATA[");
		sb.append(getProcessMethod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>properties</column-name><column-value><![CDATA[");
		sb.append(getProperties());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _actionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _commandId;
	private long _productId;
	private String _actionType;
	private int _subscriberType;
	private String _actionName;
	private String _nextActionType;
	private long _nextCommandId;
	private String _processClass;
	private String _processMethod;
	private String _properties;
	private String _description;
	private BaseModel<?> _commandActionRemoteModel;
}