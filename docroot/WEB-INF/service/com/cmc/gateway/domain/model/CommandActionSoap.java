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
 * This class is used by SOAP remote services, specifically {@link com.cmc.gateway.domain.service.http.CommandActionServiceSoap}.
 *
 * @author    Richard Nguyen
 * @see       com.cmc.gateway.domain.service.http.CommandActionServiceSoap
 * @generated
 */
public class CommandActionSoap implements Serializable {
	public static CommandActionSoap toSoapModel(CommandAction model) {
		CommandActionSoap soapModel = new CommandActionSoap();

		soapModel.setActionId(model.getActionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCommandId(model.getCommandId());
		soapModel.setProductId(model.getProductId());
		soapModel.setActionType(model.getActionType());
		soapModel.setSubscriberType(model.getSubscriberType());
		soapModel.setActionName(model.getActionName());
		soapModel.setNextActionType(model.getNextActionType());
		soapModel.setNextCommandId(model.getNextCommandId());
		soapModel.setProcessClass(model.getProcessClass());
		soapModel.setProcessMethod(model.getProcessMethod());
		soapModel.setProperties(model.getProperties());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static CommandActionSoap[] toSoapModels(CommandAction[] models) {
		CommandActionSoap[] soapModels = new CommandActionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommandActionSoap[][] toSoapModels(CommandAction[][] models) {
		CommandActionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CommandActionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CommandActionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommandActionSoap[] toSoapModels(List<CommandAction> models) {
		List<CommandActionSoap> soapModels = new ArrayList<CommandActionSoap>(models.size());

		for (CommandAction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CommandActionSoap[soapModels.size()]);
	}

	public CommandActionSoap() {
	}

	public long getPrimaryKey() {
		return _actionId;
	}

	public void setPrimaryKey(long pk) {
		setActionId(pk);
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

	private long _actionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}