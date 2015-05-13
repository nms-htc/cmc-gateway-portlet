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

import com.cmc.gateway.domain.service.ProvisioningEntryLocalServiceUtil;

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
public class ProvisioningEntryClp extends BaseModelImpl<ProvisioningEntry>
	implements ProvisioningEntry {
	public ProvisioningEntryClp() {
	}

	public Class<?> getModelClass() {
		return ProvisioningEntry.class;
	}

	public String getModelClassName() {
		return ProvisioningEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _provisioningId;
	}

	public void setPrimaryKey(long primaryKey) {
		setProvisioningId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_provisioningId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getProvisioningId() {
		return _provisioningId;
	}

	public void setProvisioningId(long provisioningId) {
		_provisioningId = provisioningId;
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

	public String getConnectionHost() {
		return _connectionHost;
	}

	public void setConnectionHost(String connectionHost) {
		_connectionHost = connectionHost;
	}

	public int getConnectionPort() {
		return _connectionPort;
	}

	public void setConnectionPort(int connectionPort) {
		_connectionPort = connectionPort;
	}

	public String getConnectByUserName() {
		return _connectByUserName;
	}

	public void setConnectByUserName(String connectByUserName) {
		_connectByUserName = connectByUserName;
	}

	public String getConnectByPassword() {
		return _connectByPassword;
	}

	public void setConnectByPassword(String connectByPassword) {
		_connectByPassword = connectByPassword;
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

	public BaseModel<?> getProvisioningEntryRemoteModel() {
		return _provisioningEntryRemoteModel;
	}

	public void setProvisioningEntryRemoteModel(
		BaseModel<?> provisioningEntryRemoteModel) {
		_provisioningEntryRemoteModel = provisioningEntryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ProvisioningEntryLocalServiceUtil.addProvisioningEntry(this);
		}
		else {
			ProvisioningEntryLocalServiceUtil.updateProvisioningEntry(this);
		}
	}

	@Override
	public ProvisioningEntry toEscapedModel() {
		return (ProvisioningEntry)Proxy.newProxyInstance(ProvisioningEntry.class.getClassLoader(),
			new Class[] { ProvisioningEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProvisioningEntryClp clone = new ProvisioningEntryClp();

		clone.setProvisioningId(getProvisioningId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setProvisioningType(getProvisioningType());
		clone.setCode(getCode());
		clone.setTitle(getTitle());
		clone.setConnectionHost(getConnectionHost());
		clone.setConnectionPort(getConnectionPort());
		clone.setConnectByUserName(getConnectByUserName());
		clone.setConnectByPassword(getConnectByPassword());
		clone.setProcessClass(getProcessClass());
		clone.setProcessMethod(getProcessMethod());
		clone.setProperties(getProperties());
		clone.setStatus(getStatus());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ProvisioningEntry provisioningEntry) {
		int value = 0;

		value = getCode().compareTo(provisioningEntry.getCode());

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

		ProvisioningEntryClp provisioningEntry = null;

		try {
			provisioningEntry = (ProvisioningEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = provisioningEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{provisioningId=");
		sb.append(getProvisioningId());
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
		sb.append(", connectionHost=");
		sb.append(getConnectionHost());
		sb.append(", connectionPort=");
		sb.append(getConnectionPort());
		sb.append(", connectByUserName=");
		sb.append(getConnectByUserName());
		sb.append(", connectByPassword=");
		sb.append(getConnectByPassword());
		sb.append(", processClass=");
		sb.append(getProcessClass());
		sb.append(", processMethod=");
		sb.append(getProcessMethod());
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
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.cmc.gateway.domain.model.ProvisioningEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>provisioningId</column-name><column-value><![CDATA[");
		sb.append(getProvisioningId());
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
			"<column><column-name>connectionHost</column-name><column-value><![CDATA[");
		sb.append(getConnectionHost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>connectionPort</column-name><column-value><![CDATA[");
		sb.append(getConnectionPort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>connectByUserName</column-name><column-value><![CDATA[");
		sb.append(getConnectByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>connectByPassword</column-name><column-value><![CDATA[");
		sb.append(getConnectByPassword());
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

	private long _provisioningId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _provisioningType;
	private String _code;
	private String _title;
	private String _connectionHost;
	private int _connectionPort;
	private String _connectByUserName;
	private String _connectByPassword;
	private String _processClass;
	private String _processMethod;
	private String _properties;
	private int _status;
	private String _description;
	private BaseModel<?> _provisioningEntryRemoteModel;
}