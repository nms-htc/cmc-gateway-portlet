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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.cmc.gateway.domain.service.http.ProvisioningMessageServiceSoap}.
 *
 * @author    Richard Nguyen
 * @see       com.cmc.gateway.domain.service.http.ProvisioningMessageServiceSoap
 * @generated
 */
public class ProvisioningMessageSoap implements Serializable {
	public static ProvisioningMessageSoap toSoapModel(ProvisioningMessage model) {
		ProvisioningMessageSoap soapModel = new ProvisioningMessageSoap();

		soapModel.setMessageId(model.getMessageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProvisioningId(model.getProvisioningId());
		soapModel.setResponseCode(model.getResponseCode());
		soapModel.setCause(model.getCause());
		soapModel.setCauseValue(model.getCauseValue());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ProvisioningMessageSoap[] toSoapModels(
		ProvisioningMessage[] models) {
		ProvisioningMessageSoap[] soapModels = new ProvisioningMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProvisioningMessageSoap[][] toSoapModels(
		ProvisioningMessage[][] models) {
		ProvisioningMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProvisioningMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProvisioningMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProvisioningMessageSoap[] toSoapModels(
		List<ProvisioningMessage> models) {
		List<ProvisioningMessageSoap> soapModels = new ArrayList<ProvisioningMessageSoap>(models.size());

		for (ProvisioningMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProvisioningMessageSoap[soapModels.size()]);
	}

	public ProvisioningMessageSoap() {
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long pk) {
		setMessageId(pk);
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

	private long _messageId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _provisioningId;
	private String _responseCode;
	private String _cause;
	private int _causeValue;
	private String _description;
}