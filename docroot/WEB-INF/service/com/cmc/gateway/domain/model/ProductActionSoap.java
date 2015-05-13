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
 * This class is used by SOAP remote services, specifically {@link com.cmc.gateway.domain.service.http.ProductActionServiceSoap}.
 *
 * @author    Richard Nguyen
 * @see       com.cmc.gateway.domain.service.http.ProductActionServiceSoap
 * @generated
 */
public class ProductActionSoap implements Serializable {
	public static ProductActionSoap toSoapModel(ProductAction model) {
		ProductActionSoap soapModel = new ProductActionSoap();

		soapModel.setActionId(model.getActionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActionType(model.getActionType());
		soapModel.setSubscriberType(model.getSubscriberType());
		soapModel.setProductId(model.getProductId());
		soapModel.setBalanceType(model.getBalanceType());
		soapModel.setCommandId(model.getCommandId());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ProductActionSoap[] toSoapModels(ProductAction[] models) {
		ProductActionSoap[] soapModels = new ProductActionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductActionSoap[][] toSoapModels(ProductAction[][] models) {
		ProductActionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductActionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductActionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductActionSoap[] toSoapModels(List<ProductAction> models) {
		List<ProductActionSoap> soapModels = new ArrayList<ProductActionSoap>(models.size());

		for (ProductAction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductActionSoap[soapModels.size()]);
	}

	public ProductActionSoap() {
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

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public String getBalanceType() {
		return _balanceType;
	}

	public void setBalanceType(String balanceType) {
		_balanceType = balanceType;
	}

	public long getCommandId() {
		return _commandId;
	}

	public void setCommandId(long commandId) {
		_commandId = commandId;
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
	private String _actionType;
	private int _subscriberType;
	private long _productId;
	private String _balanceType;
	private long _commandId;
	private String _description;
}