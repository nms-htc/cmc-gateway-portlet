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
 * This class is used by SOAP remote services, specifically {@link com.cmc.gateway.domain.service.http.ProductMessageServiceSoap}.
 *
 * @author    Richard Nguyen
 * @see       com.cmc.gateway.domain.service.http.ProductMessageServiceSoap
 * @generated
 */
public class ProductMessageSoap implements Serializable {
	public static ProductMessageSoap toSoapModel(ProductMessage model) {
		ProductMessageSoap soapModel = new ProductMessageSoap();

		soapModel.setMessageId(model.getMessageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProductId(model.getProductId());
		soapModel.setActionType(model.getActionType());
		soapModel.setChannel(model.getChannel());
		soapModel.setCause(model.getCause());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setCauseValue(model.getCauseValue());
		soapModel.setContent(model.getContent());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ProductMessageSoap[] toSoapModels(ProductMessage[] models) {
		ProductMessageSoap[] soapModels = new ProductMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductMessageSoap[][] toSoapModels(ProductMessage[][] models) {
		ProductMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductMessageSoap[] toSoapModels(List<ProductMessage> models) {
		List<ProductMessageSoap> soapModels = new ArrayList<ProductMessageSoap>(models.size());

		for (ProductMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductMessageSoap[soapModels.size()]);
	}

	public ProductMessageSoap() {
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

	public String getChannel() {
		return _channel;
	}

	public void setChannel(String channel) {
		_channel = channel;
	}

	public String getCause() {
		return _cause;
	}

	public void setCause(String cause) {
		_cause = cause;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public int getCauseValue() {
		return _causeValue;
	}

	public void setCauseValue(int causeValue) {
		_causeValue = causeValue;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
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
	private long _productId;
	private String _actionType;
	private String _channel;
	private String _cause;
	private String _languageId;
	private long _campaignId;
	private int _causeValue;
	private String _content;
	private String _description;
}