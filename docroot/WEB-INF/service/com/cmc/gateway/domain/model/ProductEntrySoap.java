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
 * This class is used by SOAP remote services, specifically {@link com.cmc.gateway.domain.service.http.ProductEntryServiceSoap}.
 *
 * @author    Richard Nguyen
 * @see       com.cmc.gateway.domain.service.http.ProductEntryServiceSoap
 * @generated
 */
public class ProductEntrySoap implements Serializable {
	public static ProductEntrySoap toSoapModel(ProductEntry model) {
		ProductEntrySoap soapModel = new ProductEntrySoap();

		soapModel.setProductId(model.getProductId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setProductType(model.getProductType());
		soapModel.setCode(model.getCode());
		soapModel.setTitle(model.getTitle());
		soapModel.setSku(model.getSku());
		soapModel.setPrice(model.getPrice());
		soapModel.setSubscriberTypes(model.getSubscriberTypes());
		soapModel.setTermOfUse(model.getTermOfUse());
		soapModel.setTermPeriod(model.getTermPeriod());
		soapModel.setTermUnit(model.getTermUnit());
		soapModel.setSubscription(model.getSubscription());
		soapModel.setSubscriptionUnit(model.getSubscriptionUnit());
		soapModel.setSubscriptionPeriod(model.getSubscriptionPeriod());
		soapModel.setGracePeriod(model.getGracePeriod());
		soapModel.setGraceUnit(model.getGraceUnit());
		soapModel.setStatus(model.getStatus());
		soapModel.setDescription(model.getDescription());
		soapModel.setProperties(model.getProperties());

		return soapModel;
	}

	public static ProductEntrySoap[] toSoapModels(ProductEntry[] models) {
		ProductEntrySoap[] soapModels = new ProductEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductEntrySoap[][] toSoapModels(ProductEntry[][] models) {
		ProductEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductEntrySoap[] toSoapModels(List<ProductEntry> models) {
		List<ProductEntrySoap> soapModels = new ArrayList<ProductEntrySoap>(models.size());

		for (ProductEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductEntrySoap[soapModels.size()]);
	}

	public ProductEntrySoap() {
	}

	public long getPrimaryKey() {
		return _productId;
	}

	public void setPrimaryKey(long pk) {
		setProductId(pk);
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
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

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getProductType() {
		return _productType;
	}

	public void setProductType(String productType) {
		_productType = productType;
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

	public String getSku() {
		return _sku;
	}

	public void setSku(String sku) {
		_sku = sku;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public String getSubscriberTypes() {
		return _subscriberTypes;
	}

	public void setSubscriberTypes(String subscriberTypes) {
		_subscriberTypes = subscriberTypes;
	}

	public boolean getTermOfUse() {
		return _termOfUse;
	}

	public boolean isTermOfUse() {
		return _termOfUse;
	}

	public void setTermOfUse(boolean termOfUse) {
		_termOfUse = termOfUse;
	}

	public int getTermPeriod() {
		return _termPeriod;
	}

	public void setTermPeriod(int termPeriod) {
		_termPeriod = termPeriod;
	}

	public String getTermUnit() {
		return _termUnit;
	}

	public void setTermUnit(String termUnit) {
		_termUnit = termUnit;
	}

	public boolean getSubscription() {
		return _subscription;
	}

	public boolean isSubscription() {
		return _subscription;
	}

	public void setSubscription(boolean subscription) {
		_subscription = subscription;
	}

	public String getSubscriptionUnit() {
		return _subscriptionUnit;
	}

	public void setSubscriptionUnit(String subscriptionUnit) {
		_subscriptionUnit = subscriptionUnit;
	}

	public int getSubscriptionPeriod() {
		return _subscriptionPeriod;
	}

	public void setSubscriptionPeriod(int subscriptionPeriod) {
		_subscriptionPeriod = subscriptionPeriod;
	}

	public int getGracePeriod() {
		return _gracePeriod;
	}

	public void setGracePeriod(int gracePeriod) {
		_gracePeriod = gracePeriod;
	}

	public String getGraceUnit() {
		return _graceUnit;
	}

	public void setGraceUnit(String graceUnit) {
		_graceUnit = graceUnit;
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

	public String getProperties() {
		return _properties;
	}

	public void setProperties(String properties) {
		_properties = properties;
	}

	private long _productId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _categoryId;
	private String _productType;
	private String _code;
	private String _title;
	private String _sku;
	private double _price;
	private String _subscriberTypes;
	private boolean _termOfUse;
	private int _termPeriod;
	private String _termUnit;
	private boolean _subscription;
	private String _subscriptionUnit;
	private int _subscriptionPeriod;
	private int _gracePeriod;
	private String _graceUnit;
	private int _status;
	private String _description;
	private String _properties;
}