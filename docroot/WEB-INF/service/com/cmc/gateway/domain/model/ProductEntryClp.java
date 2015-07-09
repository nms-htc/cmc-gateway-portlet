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

import com.cmc.gateway.domain.service.ProductEntryLocalServiceUtil;

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
public class ProductEntryClp extends BaseModelImpl<ProductEntry>
	implements ProductEntry {
	public ProductEntryClp() {
	}

	public Class<?> getModelClass() {
		return ProductEntry.class;
	}

	public String getModelClassName() {
		return ProductEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _productId;
	}

	public void setPrimaryKey(long primaryKey) {
		setProductId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_productId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productId", getProductId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryId", getCategoryId());
		attributes.put("productType", getProductType());
		attributes.put("code", getCode());
		attributes.put("title", getTitle());
		attributes.put("sku", getSku());
		attributes.put("price", getPrice());
		attributes.put("subscriberTypes", getSubscriberTypes());
		attributes.put("termOfUse", getTermOfUse());
		attributes.put("termPeriod", getTermPeriod());
		attributes.put("termUnit", getTermUnit());
		attributes.put("subscription", getSubscription());
		attributes.put("subscriptionUnit", getSubscriptionUnit());
		attributes.put("subscriptionPeriod", getSubscriptionPeriod());
		attributes.put("gracePeriod", getGracePeriod());
		attributes.put("graceUnit", getGraceUnit());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());
		attributes.put("properties", getProperties());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String productType = (String)attributes.get("productType");

		if (productType != null) {
			setProductType(productType);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String sku = (String)attributes.get("sku");

		if (sku != null) {
			setSku(sku);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String subscriberTypes = (String)attributes.get("subscriberTypes");

		if (subscriberTypes != null) {
			setSubscriberTypes(subscriberTypes);
		}

		Boolean termOfUse = (Boolean)attributes.get("termOfUse");

		if (termOfUse != null) {
			setTermOfUse(termOfUse);
		}

		Integer termPeriod = (Integer)attributes.get("termPeriod");

		if (termPeriod != null) {
			setTermPeriod(termPeriod);
		}

		String termUnit = (String)attributes.get("termUnit");

		if (termUnit != null) {
			setTermUnit(termUnit);
		}

		Boolean subscription = (Boolean)attributes.get("subscription");

		if (subscription != null) {
			setSubscription(subscription);
		}

		String subscriptionUnit = (String)attributes.get("subscriptionUnit");

		if (subscriptionUnit != null) {
			setSubscriptionUnit(subscriptionUnit);
		}

		Integer subscriptionPeriod = (Integer)attributes.get(
				"subscriptionPeriod");

		if (subscriptionPeriod != null) {
			setSubscriptionPeriod(subscriptionPeriod);
		}

		Integer gracePeriod = (Integer)attributes.get("gracePeriod");

		if (gracePeriod != null) {
			setGracePeriod(gracePeriod);
		}

		String graceUnit = (String)attributes.get("graceUnit");

		if (graceUnit != null) {
			setGraceUnit(graceUnit);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String properties = (String)attributes.get("properties");

		if (properties != null) {
			setProperties(properties);
		}
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

	public BaseModel<?> getProductEntryRemoteModel() {
		return _productEntryRemoteModel;
	}

	public void setProductEntryRemoteModel(BaseModel<?> productEntryRemoteModel) {
		_productEntryRemoteModel = productEntryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ProductEntryLocalServiceUtil.addProductEntry(this);
		}
		else {
			ProductEntryLocalServiceUtil.updateProductEntry(this);
		}
	}

	@Override
	public ProductEntry toEscapedModel() {
		return (ProductEntry)Proxy.newProxyInstance(ProductEntry.class.getClassLoader(),
			new Class[] { ProductEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProductEntryClp clone = new ProductEntryClp();

		clone.setProductId(getProductId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCategoryId(getCategoryId());
		clone.setProductType(getProductType());
		clone.setCode(getCode());
		clone.setTitle(getTitle());
		clone.setSku(getSku());
		clone.setPrice(getPrice());
		clone.setSubscriberTypes(getSubscriberTypes());
		clone.setTermOfUse(getTermOfUse());
		clone.setTermPeriod(getTermPeriod());
		clone.setTermUnit(getTermUnit());
		clone.setSubscription(getSubscription());
		clone.setSubscriptionUnit(getSubscriptionUnit());
		clone.setSubscriptionPeriod(getSubscriptionPeriod());
		clone.setGracePeriod(getGracePeriod());
		clone.setGraceUnit(getGraceUnit());
		clone.setStatus(getStatus());
		clone.setDescription(getDescription());
		clone.setProperties(getProperties());

		return clone;
	}

	public int compareTo(ProductEntry productEntry) {
		int value = 0;

		value = getCode().compareTo(productEntry.getCode());

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

		ProductEntryClp productEntry = null;

		try {
			productEntry = (ProductEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = productEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(49);

		sb.append("{productId=");
		sb.append(getProductId());
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
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", productType=");
		sb.append(getProductType());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", sku=");
		sb.append(getSku());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", subscriberTypes=");
		sb.append(getSubscriberTypes());
		sb.append(", termOfUse=");
		sb.append(getTermOfUse());
		sb.append(", termPeriod=");
		sb.append(getTermPeriod());
		sb.append(", termUnit=");
		sb.append(getTermUnit());
		sb.append(", subscription=");
		sb.append(getSubscription());
		sb.append(", subscriptionUnit=");
		sb.append(getSubscriptionUnit());
		sb.append(", subscriptionPeriod=");
		sb.append(getSubscriptionPeriod());
		sb.append(", gracePeriod=");
		sb.append(getGracePeriod());
		sb.append(", graceUnit=");
		sb.append(getGraceUnit());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", properties=");
		sb.append(getProperties());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("com.cmc.gateway.domain.model.ProductEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
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
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productType</column-name><column-value><![CDATA[");
		sb.append(getProductType());
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
			"<column><column-name>sku</column-name><column-value><![CDATA[");
		sb.append(getSku());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subscriberTypes</column-name><column-value><![CDATA[");
		sb.append(getSubscriberTypes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termOfUse</column-name><column-value><![CDATA[");
		sb.append(getTermOfUse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termPeriod</column-name><column-value><![CDATA[");
		sb.append(getTermPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termUnit</column-name><column-value><![CDATA[");
		sb.append(getTermUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subscription</column-name><column-value><![CDATA[");
		sb.append(getSubscription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subscriptionUnit</column-name><column-value><![CDATA[");
		sb.append(getSubscriptionUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subscriptionPeriod</column-name><column-value><![CDATA[");
		sb.append(getSubscriptionPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gracePeriod</column-name><column-value><![CDATA[");
		sb.append(getGracePeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>graceUnit</column-name><column-value><![CDATA[");
		sb.append(getGraceUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>properties</column-name><column-value><![CDATA[");
		sb.append(getProperties());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _productId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _productEntryRemoteModel;
}