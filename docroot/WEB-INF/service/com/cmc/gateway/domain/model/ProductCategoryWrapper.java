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
 * This class is a wrapper for {@link ProductCategory}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProductCategory
 * @generated
 */
public class ProductCategoryWrapper implements ProductCategory,
	ModelWrapper<ProductCategory> {
	public ProductCategoryWrapper(ProductCategory productCategory) {
		_productCategory = productCategory;
	}

	public Class<?> getModelClass() {
		return ProductCategory.class;
	}

	public String getModelClassName() {
		return ProductCategory.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this product category.
	*
	* @return the primary key of this product category
	*/
	public long getPrimaryKey() {
		return _productCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product category.
	*
	* @param primaryKey the primary key of this product category
	*/
	public void setPrimaryKey(long primaryKey) {
		_productCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this product category.
	*
	* @return the category ID of this product category
	*/
	public long getCategoryId() {
		return _productCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this product category.
	*
	* @param categoryId the category ID of this product category
	*/
	public void setCategoryId(long categoryId) {
		_productCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the group ID of this product category.
	*
	* @return the group ID of this product category
	*/
	public long getGroupId() {
		return _productCategory.getGroupId();
	}

	/**
	* Sets the group ID of this product category.
	*
	* @param groupId the group ID of this product category
	*/
	public void setGroupId(long groupId) {
		_productCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this product category.
	*
	* @return the company ID of this product category
	*/
	public long getCompanyId() {
		return _productCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this product category.
	*
	* @param companyId the company ID of this product category
	*/
	public void setCompanyId(long companyId) {
		_productCategory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this product category.
	*
	* @return the user ID of this product category
	*/
	public long getUserId() {
		return _productCategory.getUserId();
	}

	/**
	* Sets the user ID of this product category.
	*
	* @param userId the user ID of this product category
	*/
	public void setUserId(long userId) {
		_productCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this product category.
	*
	* @return the user uuid of this product category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this product category.
	*
	* @param userUuid the user uuid of this product category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_productCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this product category.
	*
	* @return the create date of this product category
	*/
	public java.util.Date getCreateDate() {
		return _productCategory.getCreateDate();
	}

	/**
	* Sets the create date of this product category.
	*
	* @param createDate the create date of this product category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_productCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this product category.
	*
	* @return the modified date of this product category
	*/
	public java.util.Date getModifiedDate() {
		return _productCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this product category.
	*
	* @param modifiedDate the modified date of this product category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_productCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this product category.
	*
	* @return the title of this product category
	*/
	public java.lang.String getTitle() {
		return _productCategory.getTitle();
	}

	/**
	* Sets the title of this product category.
	*
	* @param title the title of this product category
	*/
	public void setTitle(java.lang.String title) {
		_productCategory.setTitle(title);
	}

	/**
	* Returns the description of this product category.
	*
	* @return the description of this product category
	*/
	public java.lang.String getDescription() {
		return _productCategory.getDescription();
	}

	/**
	* Sets the description of this product category.
	*
	* @param description the description of this product category
	*/
	public void setDescription(java.lang.String description) {
		_productCategory.setDescription(description);
	}

	public boolean isNew() {
		return _productCategory.isNew();
	}

	public void setNew(boolean n) {
		_productCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _productCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_productCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _productCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _productCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_productCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _productCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_productCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductCategoryWrapper((ProductCategory)_productCategory.clone());
	}

	public int compareTo(
		com.cmc.gateway.domain.model.ProductCategory productCategory) {
		return _productCategory.compareTo(productCategory);
	}

	@Override
	public int hashCode() {
		return _productCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.ProductCategory> toCacheModel() {
		return _productCategory.toCacheModel();
	}

	public com.cmc.gateway.domain.model.ProductCategory toEscapedModel() {
		return new ProductCategoryWrapper(_productCategory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _productCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _productCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_productCategory.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProductCategory getWrappedProductCategory() {
		return _productCategory;
	}

	public ProductCategory getWrappedModel() {
		return _productCategory;
	}

	public void resetOriginalValues() {
		_productCategory.resetOriginalValues();
	}

	private ProductCategory _productCategory;
}