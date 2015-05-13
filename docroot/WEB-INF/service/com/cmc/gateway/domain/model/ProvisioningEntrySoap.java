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
 * This class is used by SOAP remote services, specifically {@link com.cmc.gateway.domain.service.http.ProvisioningEntryServiceSoap}.
 *
 * @author    Richard Nguyen
 * @see       com.cmc.gateway.domain.service.http.ProvisioningEntryServiceSoap
 * @generated
 */
public class ProvisioningEntrySoap implements Serializable {
	public static ProvisioningEntrySoap toSoapModel(ProvisioningEntry model) {
		ProvisioningEntrySoap soapModel = new ProvisioningEntrySoap();

		soapModel.setProvisioningId(model.getProvisioningId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProvisioningType(model.getProvisioningType());
		soapModel.setCode(model.getCode());
		soapModel.setTitle(model.getTitle());
		soapModel.setConnectionHost(model.getConnectionHost());
		soapModel.setConnectionPort(model.getConnectionPort());
		soapModel.setConnectByUserName(model.getConnectByUserName());
		soapModel.setConnectByPassword(model.getConnectByPassword());
		soapModel.setProcessClass(model.getProcessClass());
		soapModel.setProcessMethod(model.getProcessMethod());
		soapModel.setProperties(model.getProperties());
		soapModel.setStatus(model.getStatus());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ProvisioningEntrySoap[] toSoapModels(
		ProvisioningEntry[] models) {
		ProvisioningEntrySoap[] soapModels = new ProvisioningEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProvisioningEntrySoap[][] toSoapModels(
		ProvisioningEntry[][] models) {
		ProvisioningEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProvisioningEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProvisioningEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProvisioningEntrySoap[] toSoapModels(
		List<ProvisioningEntry> models) {
		List<ProvisioningEntrySoap> soapModels = new ArrayList<ProvisioningEntrySoap>(models.size());

		for (ProvisioningEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProvisioningEntrySoap[soapModels.size()]);
	}

	public ProvisioningEntrySoap() {
	}

	public long getPrimaryKey() {
		return _provisioningId;
	}

	public void setPrimaryKey(long pk) {
		setProvisioningId(pk);
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

	private long _provisioningId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}