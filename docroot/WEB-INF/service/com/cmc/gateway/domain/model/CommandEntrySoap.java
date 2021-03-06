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
 * This class is used by SOAP remote services, specifically {@link com.cmc.gateway.domain.service.http.CommandEntryServiceSoap}.
 *
 * @author    Richard Nguyen
 * @see       com.cmc.gateway.domain.service.http.CommandEntryServiceSoap
 * @generated
 */
public class CommandEntrySoap implements Serializable {
	public static CommandEntrySoap toSoapModel(CommandEntry model) {
		CommandEntrySoap soapModel = new CommandEntrySoap();

		soapModel.setCommandId(model.getCommandId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProvisioningType(model.getProvisioningType());
		soapModel.setCode(model.getCode());
		soapModel.setTitle(model.getTitle());
		soapModel.setPriority(model.getPriority());
		soapModel.setTimeout(model.getTimeout());
		soapModel.setRetryEnable(model.getRetryEnable());
		soapModel.setMaxRetry(model.getMaxRetry());
		soapModel.setLogEnable(model.getLogEnable());
		soapModel.setProperties(model.getProperties());
		soapModel.setStatus(model.getStatus());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static CommandEntrySoap[] toSoapModels(CommandEntry[] models) {
		CommandEntrySoap[] soapModels = new CommandEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommandEntrySoap[][] toSoapModels(CommandEntry[][] models) {
		CommandEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CommandEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CommandEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommandEntrySoap[] toSoapModels(List<CommandEntry> models) {
		List<CommandEntrySoap> soapModels = new ArrayList<CommandEntrySoap>(models.size());

		for (CommandEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CommandEntrySoap[soapModels.size()]);
	}

	public CommandEntrySoap() {
	}

	public long getPrimaryKey() {
		return _commandId;
	}

	public void setPrimaryKey(long pk) {
		setCommandId(pk);
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

	private long _commandId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}