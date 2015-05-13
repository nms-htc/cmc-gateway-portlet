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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductEntry}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProductEntry
 * @generated
 */
public class ProductEntryWrapper implements ProductEntry,
	ModelWrapper<ProductEntry> {
	public ProductEntryWrapper(ProductEntry productEntry) {
		_productEntry = productEntry;
	}

	public Class<?> getModelClass() {
		return ProductEntry.class;
	}

	public String getModelClassName() {
		return ProductEntry.class.getName();
	}

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

		return attributes;
	}

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
	}

	/**
	* Returns the primary key of this product entry.
	*
	* @return the primary key of this product entry
	*/
	public long getPrimaryKey() {
		return _productEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product entry.
	*
	* @param primaryKey the primary key of this product entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_productEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the product ID of this product entry.
	*
	* @return the product ID of this product entry
	*/
	public long getProductId() {
		return _productEntry.getProductId();
	}

	/**
	* Sets the product ID of this product entry.
	*
	* @param productId the product ID of this product entry
	*/
	public void setProductId(long productId) {
		_productEntry.setProductId(productId);
	}

	/**
	* Returns the group ID of this product entry.
	*
	* @return the group ID of this product entry
	*/
	public long getGroupId() {
		return _productEntry.getGroupId();
	}

	/**
	* Sets the group ID of this product entry.
	*
	* @param groupId the group ID of this product entry
	*/
	public void setGroupId(long groupId) {
		_productEntry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this product entry.
	*
	* @return the company ID of this product entry
	*/
	public long getCompanyId() {
		return _productEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this product entry.
	*
	* @param companyId the company ID of this product entry
	*/
	public void setCompanyId(long companyId) {
		_productEntry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this product entry.
	*
	* @return the user ID of this product entry
	*/
	public long getUserId() {
		return _productEntry.getUserId();
	}

	/**
	* Sets the user ID of this product entry.
	*
	* @param userId the user ID of this product entry
	*/
	public void setUserId(long userId) {
		_productEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this product entry.
	*
	* @return the user uuid of this product entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this product entry.
	*
	* @param userUuid the user uuid of this product entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_productEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this product entry.
	*
	* @return the create date of this product entry
	*/
	public java.util.Date getCreateDate() {
		return _productEntry.getCreateDate();
	}

	/**
	* Sets the create date of this product entry.
	*
	* @param createDate the create date of this product entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_productEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this product entry.
	*
	* @return the modified date of this product entry
	*/
	public java.util.Date getModifiedDate() {
		return _productEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this product entry.
	*
	* @param modifiedDate the modified date of this product entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_productEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category ID of this product entry.
	*
	* @return the category ID of this product entry
	*/
	public long getCategoryId() {
		return _productEntry.getCategoryId();
	}

	/**
	* Sets the category ID of this product entry.
	*
	* @param categoryId the category ID of this product entry
	*/
	public void setCategoryId(long categoryId) {
		_productEntry.setCategoryId(categoryId);
	}

	/**
	* Returns the product type of this product entry.
	*
	* @return the product type of this product entry
	*/
	public java.lang.String getProductType() {
		return _productEntry.getProductType();
	}

	/**
	* Sets the product type of this product entry.
	*
	* @param productType the product type of this product entry
	*/
	public void setProductType(java.lang.String productType) {
		_productEntry.setProductType(productType);
	}

	/**
	* Returns the code of this product entry.
	*
	* @return the code of this product entry
	*/
	public java.lang.String getCode() {
		return _productEntry.getCode();
	}

	/**
	* Sets the code of this product entry.
	*
	* @param code the code of this product entry
	*/
	public void setCode(java.lang.String code) {
		_productEntry.setCode(code);
	}

	/**
	* Returns the title of this product entry.
	*
	* @return the title of this product entry
	*/
	public java.lang.String getTitle() {
		return _productEntry.getTitle();
	}

	/**
	* Sets the title of this product entry.
	*
	* @param title the title of this product entry
	*/
	public void setTitle(java.lang.String title) {
		_productEntry.setTitle(title);
	}

	/**
	* Returns the sku of this product entry.
	*
	* @return the sku of this product entry
	*/
	public java.lang.String getSku() {
		return _productEntry.getSku();
	}

	/**
	* Sets the sku of this product entry.
	*
	* @param sku the sku of this product entry
	*/
	public void setSku(java.lang.String sku) {
		_productEntry.setSku(sku);
	}

	/**
	* Returns the price of this product entry.
	*
	* @return the price of this product entry
	*/
	public double getPrice() {
		return _productEntry.getPrice();
	}

	/**
	* Sets the price of this product entry.
	*
	* @param price the price of this product entry
	*/
	public void setPrice(double price) {
		_productEntry.setPrice(price);
	}

	/**
	* Returns the subscriber types of this product entry.
	*
	* @return the subscriber types of this product entry
	*/
	public java.lang.String getSubscriberTypes() {
		return _productEntry.getSubscriberTypes();
	}

	/**
	* Sets the subscriber types of this product entry.
	*
	* @param subscriberTypes the subscriber types of this product entry
	*/
	public void setSubscriberTypes(java.lang.String subscriberTypes) {
		_productEntry.setSubscriberTypes(subscriberTypes);
	}

	/**
	* Returns the term of use of this product entry.
	*
	* @return the term of use of this product entry
	*/
	public boolean getTermOfUse() {
		return _productEntry.getTermOfUse();
	}

	/**
	* Returns <code>true</code> if this product entry is term of use.
	*
	* @return <code>true</code> if this product entry is term of use; <code>false</code> otherwise
	*/
	public boolean isTermOfUse() {
		return _productEntry.isTermOfUse();
	}

	/**
	* Sets whether this product entry is term of use.
	*
	* @param termOfUse the term of use of this product entry
	*/
	public void setTermOfUse(boolean termOfUse) {
		_productEntry.setTermOfUse(termOfUse);
	}

	/**
	* Returns the term period of this product entry.
	*
	* @return the term period of this product entry
	*/
	public int getTermPeriod() {
		return _productEntry.getTermPeriod();
	}

	/**
	* Sets the term period of this product entry.
	*
	* @param termPeriod the term period of this product entry
	*/
	public void setTermPeriod(int termPeriod) {
		_productEntry.setTermPeriod(termPeriod);
	}

	/**
	* Returns the term unit of this product entry.
	*
	* @return the term unit of this product entry
	*/
	public java.lang.String getTermUnit() {
		return _productEntry.getTermUnit();
	}

	/**
	* Sets the term unit of this product entry.
	*
	* @param termUnit the term unit of this product entry
	*/
	public void setTermUnit(java.lang.String termUnit) {
		_productEntry.setTermUnit(termUnit);
	}

	/**
	* Returns the subscription of this product entry.
	*
	* @return the subscription of this product entry
	*/
	public boolean getSubscription() {
		return _productEntry.getSubscription();
	}

	/**
	* Returns <code>true</code> if this product entry is subscription.
	*
	* @return <code>true</code> if this product entry is subscription; <code>false</code> otherwise
	*/
	public boolean isSubscription() {
		return _productEntry.isSubscription();
	}

	/**
	* Sets whether this product entry is subscription.
	*
	* @param subscription the subscription of this product entry
	*/
	public void setSubscription(boolean subscription) {
		_productEntry.setSubscription(subscription);
	}

	/**
	* Returns the subscription unit of this product entry.
	*
	* @return the subscription unit of this product entry
	*/
	public java.lang.String getSubscriptionUnit() {
		return _productEntry.getSubscriptionUnit();
	}

	/**
	* Sets the subscription unit of this product entry.
	*
	* @param subscriptionUnit the subscription unit of this product entry
	*/
	public void setSubscriptionUnit(java.lang.String subscriptionUnit) {
		_productEntry.setSubscriptionUnit(subscriptionUnit);
	}

	/**
	* Returns the subscription period of this product entry.
	*
	* @return the subscription period of this product entry
	*/
	public int getSubscriptionPeriod() {
		return _productEntry.getSubscriptionPeriod();
	}

	/**
	* Sets the subscription period of this product entry.
	*
	* @param subscriptionPeriod the subscription period of this product entry
	*/
	public void setSubscriptionPeriod(int subscriptionPeriod) {
		_productEntry.setSubscriptionPeriod(subscriptionPeriod);
	}

	/**
	* Returns the grace period of this product entry.
	*
	* @return the grace period of this product entry
	*/
	public int getGracePeriod() {
		return _productEntry.getGracePeriod();
	}

	/**
	* Sets the grace period of this product entry.
	*
	* @param gracePeriod the grace period of this product entry
	*/
	public void setGracePeriod(int gracePeriod) {
		_productEntry.setGracePeriod(gracePeriod);
	}

	/**
	* Returns the grace unit of this product entry.
	*
	* @return the grace unit of this product entry
	*/
	public java.lang.String getGraceUnit() {
		return _productEntry.getGraceUnit();
	}

	/**
	* Sets the grace unit of this product entry.
	*
	* @param graceUnit the grace unit of this product entry
	*/
	public void setGraceUnit(java.lang.String graceUnit) {
		_productEntry.setGraceUnit(graceUnit);
	}

	/**
	* Returns the status of this product entry.
	*
	* @return the status of this product entry
	*/
	public int getStatus() {
		return _productEntry.getStatus();
	}

	/**
	* Sets the status of this product entry.
	*
	* @param status the status of this product entry
	*/
	public void setStatus(int status) {
		_productEntry.setStatus(status);
	}

	/**
	* Returns the description of this product entry.
	*
	* @return the description of this product entry
	*/
	public java.lang.String getDescription() {
		return _productEntry.getDescription();
	}

	/**
	* Sets the description of this product entry.
	*
	* @param description the description of this product entry
	*/
	public void setDescription(java.lang.String description) {
		_productEntry.setDescription(description);
	}

	public boolean isNew() {
		return _productEntry.isNew();
	}

	public void setNew(boolean n) {
		_productEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _productEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_productEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _productEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _productEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_productEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _productEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_productEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductEntryWrapper((ProductEntry)_productEntry.clone());
	}

	public int compareTo(com.cmc.gateway.domain.model.ProductEntry productEntry) {
		return _productEntry.compareTo(productEntry);
	}

	@Override
	public int hashCode() {
		return _productEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.ProductEntry> toCacheModel() {
		return _productEntry.toCacheModel();
	}

	public com.cmc.gateway.domain.model.ProductEntry toEscapedModel() {
		return new ProductEntryWrapper(_productEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _productEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _productEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_productEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProductEntry getWrappedProductEntry() {
		return _productEntry;
	}

	public ProductEntry getWrappedModel() {
		return _productEntry;
	}

	public void resetOriginalValues() {
		_productEntry.resetOriginalValues();
	}

	private ProductEntry _productEntry;
}