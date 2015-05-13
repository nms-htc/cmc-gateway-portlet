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

import com.cmc.gateway.domain.service.ProvisioningRouteLocalServiceUtil;

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
public class ProvisioningRouteClp extends BaseModelImpl<ProvisioningRoute>
	implements ProvisioningRoute {
	public ProvisioningRouteClp() {
	}

	public Class<?> getModelClass() {
		return ProvisioningRoute.class;
	}

	public String getModelClassName() {
		return ProvisioningRoute.class.getName();
	}

	public long getPrimaryKey() {
		return _routeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setRouteId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_routeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("routeId", getRouteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("provisioningId", getProvisioningId());
		attributes.put("provisioningType", getProvisioningType());
		attributes.put("routeType", getRouteType());
		attributes.put("routeKey", getRouteKey());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long routeId = (Long)attributes.get("routeId");

		if (routeId != null) {
			setRouteId(routeId);
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

		String provisioningType = (String)attributes.get("provisioningType");

		if (provisioningType != null) {
			setProvisioningType(provisioningType);
		}

		String routeType = (String)attributes.get("routeType");

		if (routeType != null) {
			setRouteType(routeType);
		}

		String routeKey = (String)attributes.get("routeKey");

		if (routeKey != null) {
			setRouteKey(routeKey);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	public long getRouteId() {
		return _routeId;
	}

	public void setRouteId(long routeId) {
		_routeId = routeId;
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

	public long getProvisioningId() {
		return _provisioningId;
	}

	public void setProvisioningId(long provisioningId) {
		_provisioningId = provisioningId;
	}

	public String getProvisioningType() {
		return _provisioningType;
	}

	public void setProvisioningType(String provisioningType) {
		_provisioningType = provisioningType;
	}

	public String getRouteType() {
		return _routeType;
	}

	public void setRouteType(String routeType) {
		_routeType = routeType;
	}

	public String getRouteKey() {
		return _routeKey;
	}

	public void setRouteKey(String routeKey) {
		_routeKey = routeKey;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public BaseModel<?> getProvisioningRouteRemoteModel() {
		return _provisioningRouteRemoteModel;
	}

	public void setProvisioningRouteRemoteModel(
		BaseModel<?> provisioningRouteRemoteModel) {
		_provisioningRouteRemoteModel = provisioningRouteRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ProvisioningRouteLocalServiceUtil.addProvisioningRoute(this);
		}
		else {
			ProvisioningRouteLocalServiceUtil.updateProvisioningRoute(this);
		}
	}

	@Override
	public ProvisioningRoute toEscapedModel() {
		return (ProvisioningRoute)Proxy.newProxyInstance(ProvisioningRoute.class.getClassLoader(),
			new Class[] { ProvisioningRoute.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProvisioningRouteClp clone = new ProvisioningRouteClp();

		clone.setRouteId(getRouteId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setProvisioningId(getProvisioningId());
		clone.setProvisioningType(getProvisioningType());
		clone.setRouteType(getRouteType());
		clone.setRouteKey(getRouteKey());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ProvisioningRoute provisioningRoute) {
		int value = 0;

		if (getProvisioningId() < provisioningRoute.getProvisioningId()) {
			value = -1;
		}
		else if (getProvisioningId() > provisioningRoute.getProvisioningId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getRouteType().compareTo(provisioningRoute.getRouteType());

		if (value != 0) {
			return value;
		}

		value = getRouteKey().compareTo(provisioningRoute.getRouteKey());

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

		ProvisioningRouteClp provisioningRoute = null;

		try {
			provisioningRoute = (ProvisioningRouteClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = provisioningRoute.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{routeId=");
		sb.append(getRouteId());
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
		sb.append(", provisioningId=");
		sb.append(getProvisioningId());
		sb.append(", provisioningType=");
		sb.append(getProvisioningType());
		sb.append(", routeType=");
		sb.append(getRouteType());
		sb.append(", routeKey=");
		sb.append(getRouteKey());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.cmc.gateway.domain.model.ProvisioningRoute");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>routeId</column-name><column-value><![CDATA[");
		sb.append(getRouteId());
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
			"<column><column-name>provisioningId</column-name><column-value><![CDATA[");
		sb.append(getProvisioningId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>provisioningType</column-name><column-value><![CDATA[");
		sb.append(getProvisioningType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>routeType</column-name><column-value><![CDATA[");
		sb.append(getRouteType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>routeKey</column-name><column-value><![CDATA[");
		sb.append(getRouteKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _routeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _provisioningId;
	private String _provisioningType;
	private String _routeType;
	private String _routeKey;
	private String _description;
	private BaseModel<?> _provisioningRouteRemoteModel;
}