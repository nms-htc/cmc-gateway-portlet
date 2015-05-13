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

import com.cmc.gateway.domain.service.ProvisioningMessageLocalServiceUtil;

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
public class ProvisioningMessageClp extends BaseModelImpl<ProvisioningMessage>
	implements ProvisioningMessage {
	public ProvisioningMessageClp() {
	}

	public Class<?> getModelClass() {
		return ProvisioningMessage.class;
	}

	public String getModelClassName() {
		return ProvisioningMessage.class.getName();
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMessageId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_messageId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("provisioningId", getProvisioningId());
		attributes.put("responseCode", getResponseCode());
		attributes.put("cause", getCause());
		attributes.put("causeValue", getCauseValue());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
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

		String responseCode = (String)attributes.get("responseCode");

		if (responseCode != null) {
			setResponseCode(responseCode);
		}

		String cause = (String)attributes.get("cause");

		if (cause != null) {
			setCause(cause);
		}

		Integer causeValue = (Integer)attributes.get("causeValue");

		if (causeValue != null) {
			setCauseValue(causeValue);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
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

	public String getResponseCode() {
		return _responseCode;
	}

	public void setResponseCode(String responseCode) {
		_responseCode = responseCode;
	}

	public String getCause() {
		return _cause;
	}

	public void setCause(String cause) {
		_cause = cause;
	}

	public int getCauseValue() {
		return _causeValue;
	}

	public void setCauseValue(int causeValue) {
		_causeValue = causeValue;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public BaseModel<?> getProvisioningMessageRemoteModel() {
		return _provisioningMessageRemoteModel;
	}

	public void setProvisioningMessageRemoteModel(
		BaseModel<?> provisioningMessageRemoteModel) {
		_provisioningMessageRemoteModel = provisioningMessageRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ProvisioningMessageLocalServiceUtil.addProvisioningMessage(this);
		}
		else {
			ProvisioningMessageLocalServiceUtil.updateProvisioningMessage(this);
		}
	}

	@Override
	public ProvisioningMessage toEscapedModel() {
		return (ProvisioningMessage)Proxy.newProxyInstance(ProvisioningMessage.class.getClassLoader(),
			new Class[] { ProvisioningMessage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProvisioningMessageClp clone = new ProvisioningMessageClp();

		clone.setMessageId(getMessageId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setProvisioningId(getProvisioningId());
		clone.setResponseCode(getResponseCode());
		clone.setCause(getCause());
		clone.setCauseValue(getCauseValue());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ProvisioningMessage provisioningMessage) {
		int value = 0;

		if (getProvisioningId() < provisioningMessage.getProvisioningId()) {
			value = -1;
		}
		else if (getProvisioningId() > provisioningMessage.getProvisioningId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		ProvisioningMessageClp provisioningMessage = null;

		try {
			provisioningMessage = (ProvisioningMessageClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = provisioningMessage.getPrimaryKey();

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

		sb.append("{messageId=");
		sb.append(getMessageId());
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
		sb.append(", responseCode=");
		sb.append(getResponseCode());
		sb.append(", cause=");
		sb.append(getCause());
		sb.append(", causeValue=");
		sb.append(getCauseValue());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.cmc.gateway.domain.model.ProvisioningMessage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
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
			"<column><column-name>responseCode</column-name><column-value><![CDATA[");
		sb.append(getResponseCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cause</column-name><column-value><![CDATA[");
		sb.append(getCause());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>causeValue</column-name><column-value><![CDATA[");
		sb.append(getCauseValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _messageId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _provisioningId;
	private String _responseCode;
	private String _cause;
	private int _causeValue;
	private String _description;
	private BaseModel<?> _provisioningMessageRemoteModel;
}