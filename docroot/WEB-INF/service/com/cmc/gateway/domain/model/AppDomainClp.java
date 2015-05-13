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

import com.cmc.gateway.domain.service.AppDomainLocalServiceUtil;

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
public class AppDomainClp extends BaseModelImpl<AppDomain> implements AppDomain {
	public AppDomainClp() {
	}

	public Class<?> getModelClass() {
		return AppDomain.class;
	}

	public String getModelClassName() {
		return AppDomain.class.getName();
	}

	public long getPrimaryKey() {
		return _domainId;
	}

	public void setPrimaryKey(long primaryKey) {
		setDomainId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_domainId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getDomainId() {
		return _domainId;
	}

	public void setDomainId(long domainId) {
		_domainId = domainId;
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

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
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

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public boolean getDefaultValue() {
		return _defaultValue;
	}

	public boolean isDefaultValue() {
		return _defaultValue;
	}

	public void setDefaultValue(boolean defaultValue) {
		_defaultValue = defaultValue;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public BaseModel<?> getAppDomainRemoteModel() {
		return _appDomainRemoteModel;
	}

	public void setAppDomainRemoteModel(BaseModel<?> appDomainRemoteModel) {
		_appDomainRemoteModel = appDomainRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AppDomainLocalServiceUtil.addAppDomain(this);
		}
		else {
			AppDomainLocalServiceUtil.updateAppDomain(this);
		}
	}

	@Override
	public AppDomain toEscapedModel() {
		return (AppDomain)Proxy.newProxyInstance(AppDomain.class.getClassLoader(),
			new Class[] { AppDomain.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AppDomainClp clone = new AppDomainClp();

		clone.setDomainId(getDomainId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setType(getType());
		clone.setCode(getCode());
		clone.setTitle(getTitle());
		clone.setValue(getValue());
		clone.setDefaultValue(getDefaultValue());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(AppDomain appDomain) {
		int value = 0;

		value = getType().compareTo(appDomain.getType());

		if (value != 0) {
			return value;
		}

		value = getCode().compareTo(appDomain.getCode());

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

		AppDomainClp appDomain = null;

		try {
			appDomain = (AppDomainClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = appDomain.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{domainId=");
		sb.append(getDomainId());
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
		sb.append(", type=");
		sb.append(getType());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", defaultValue=");
		sb.append(getDefaultValue());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.cmc.gateway.domain.model.AppDomain");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>domainId</column-name><column-value><![CDATA[");
		sb.append(getDomainId());
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
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
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
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultValue</column-name><column-value><![CDATA[");
		sb.append(getDefaultValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _domainId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _type;
	private String _code;
	private String _title;
	private String _value;
	private boolean _defaultValue;
	private String _description;
	private BaseModel<?> _appDomainRemoteModel;
}