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

import com.cmc.gateway.domain.service.CommandEntryLocalServiceUtil;

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
public class CommandEntryClp extends BaseModelImpl<CommandEntry>
	implements CommandEntry {
	public CommandEntryClp() {
	}

	public Class<?> getModelClass() {
		return CommandEntry.class;
	}

	public String getModelClassName() {
		return CommandEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _commandId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCommandId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_commandId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getCommandId() {
		return _commandId;
	}

	public void setCommandId(long commandId) {
		_commandId = commandId;
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

	public String getProvisioningType() {
		return _provisioningType;
	}

	public void setProvisioningType(String provisioningType) {
		_provisioningType = provisioningType;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	public int getTimeout() {
		return _timeout;
	}

	public void setTimeout(int timeout) {
		_timeout = timeout;
	}

	public boolean getRetryEnable() {
		return _retryEnable;
	}

	public boolean isRetryEnable() {
		return _retryEnable;
	}

	public void setRetryEnable(boolean retryEnable) {
		_retryEnable = retryEnable;
	}

	public int getMaxRetry() {
		return _maxRetry;
	}

	public void setMaxRetry(int maxRetry) {
		_maxRetry = maxRetry;
	}

	public boolean getLogEnable() {
		return _logEnable;
	}

	public boolean isLogEnable() {
		return _logEnable;
	}

	public void setLogEnable(boolean logEnable) {
		_logEnable = logEnable;
	}

	public String getProperties() {
		return _properties;
	}

	public void setProperties(String properties) {
		_properties = properties;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public BaseModel<?> getCommandEntryRemoteModel() {
		return _commandEntryRemoteModel;
	}

	public void setCommandEntryRemoteModel(BaseModel<?> commandEntryRemoteModel) {
		_commandEntryRemoteModel = commandEntryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CommandEntryLocalServiceUtil.addCommandEntry(this);
		}
		else {
			CommandEntryLocalServiceUtil.updateCommandEntry(this);
		}
	}

	@Override
	public CommandEntry toEscapedModel() {
		return (CommandEntry)Proxy.newProxyInstance(CommandEntry.class.getClassLoader(),
			new Class[] { CommandEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CommandEntryClp clone = new CommandEntryClp();

		clone.setCommandId(getCommandId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setProvisioningType(getProvisioningType());
		clone.setCode(getCode());
		clone.setTitle(getTitle());
		clone.setPriority(getPriority());
		clone.setTimeout(getTimeout());
		clone.setRetryEnable(getRetryEnable());
		clone.setMaxRetry(getMaxRetry());
		clone.setLogEnable(getLogEnable());
		clone.setProperties(getProperties());
		clone.setStatus(getStatus());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(CommandEntry commandEntry) {
		int value = 0;

		value = getCode().compareTo(commandEntry.getCode());

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

		CommandEntryClp commandEntry = null;

		try {
			commandEntry = (CommandEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = commandEntry.getPrimaryKey();

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

		sb.append("{commandId=");
		sb.append(getCommandId());
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
		sb.append(", provisioningType=");
		sb.append(getProvisioningType());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", timeout=");
		sb.append(getTimeout());
		sb.append(", retryEnable=");
		sb.append(getRetryEnable());
		sb.append(", maxRetry=");
		sb.append(getMaxRetry());
		sb.append(", logEnable=");
		sb.append(getLogEnable());
		sb.append(", properties=");
		sb.append(getProperties());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.cmc.gateway.domain.model.CommandEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commandId</column-name><column-value><![CDATA[");
		sb.append(getCommandId());
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
			"<column><column-name>provisioningType</column-name><column-value><![CDATA[");
		sb.append(getProvisioningType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeout</column-name><column-value><![CDATA[");
		sb.append(getTimeout());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>retryEnable</column-name><column-value><![CDATA[");
		sb.append(getRetryEnable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxRetry</column-name><column-value><![CDATA[");
		sb.append(getMaxRetry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logEnable</column-name><column-value><![CDATA[");
		sb.append(getLogEnable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>properties</column-name><column-value><![CDATA[");
		sb.append(getProperties());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _commandId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _provisioningType;
	private String _code;
	private String _title;
	private int _priority;
	private int _timeout;
	private boolean _retryEnable;
	private int _maxRetry;
	private boolean _logEnable;
	private String _properties;
	private int _status;
	private String _description;
	private BaseModel<?> _commandEntryRemoteModel;
}