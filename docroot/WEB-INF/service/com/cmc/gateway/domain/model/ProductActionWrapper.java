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
 * This class is a wrapper for {@link ProductAction}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProductAction
 * @generated
 */
public class ProductActionWrapper implements ProductAction,
	ModelWrapper<ProductAction> {
	public ProductActionWrapper(ProductAction productAction) {
		_productAction = productAction;
	}

	public Class<?> getModelClass() {
		return ProductAction.class;
	}

	public String getModelClassName() {
		return ProductAction.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("actionId", getActionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("actionType", getActionType());
		attributes.put("subscriberType", getSubscriberType());
		attributes.put("productId", getProductId());
		attributes.put("balanceType", getBalanceType());
		attributes.put("commandId", getCommandId());
		attributes.put("description", getDescription());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long actionId = (Long)attributes.get("actionId");

		if (actionId != null) {
			setActionId(actionId);
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

		String actionType = (String)attributes.get("actionType");

		if (actionType != null) {
			setActionType(actionType);
		}

		Integer subscriberType = (Integer)attributes.get("subscriberType");

		if (subscriberType != null) {
			setSubscriberType(subscriberType);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String balanceType = (String)attributes.get("balanceType");

		if (balanceType != null) {
			setBalanceType(balanceType);
		}

		Long commandId = (Long)attributes.get("commandId");

		if (commandId != null) {
			setCommandId(commandId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this product action.
	*
	* @return the primary key of this product action
	*/
	public long getPrimaryKey() {
		return _productAction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product action.
	*
	* @param primaryKey the primary key of this product action
	*/
	public void setPrimaryKey(long primaryKey) {
		_productAction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the action ID of this product action.
	*
	* @return the action ID of this product action
	*/
	public long getActionId() {
		return _productAction.getActionId();
	}

	/**
	* Sets the action ID of this product action.
	*
	* @param actionId the action ID of this product action
	*/
	public void setActionId(long actionId) {
		_productAction.setActionId(actionId);
	}

	/**
	* Returns the group ID of this product action.
	*
	* @return the group ID of this product action
	*/
	public long getGroupId() {
		return _productAction.getGroupId();
	}

	/**
	* Sets the group ID of this product action.
	*
	* @param groupId the group ID of this product action
	*/
	public void setGroupId(long groupId) {
		_productAction.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this product action.
	*
	* @return the company ID of this product action
	*/
	public long getCompanyId() {
		return _productAction.getCompanyId();
	}

	/**
	* Sets the company ID of this product action.
	*
	* @param companyId the company ID of this product action
	*/
	public void setCompanyId(long companyId) {
		_productAction.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this product action.
	*
	* @return the user ID of this product action
	*/
	public long getUserId() {
		return _productAction.getUserId();
	}

	/**
	* Sets the user ID of this product action.
	*
	* @param userId the user ID of this product action
	*/
	public void setUserId(long userId) {
		_productAction.setUserId(userId);
	}

	/**
	* Returns the user uuid of this product action.
	*
	* @return the user uuid of this product action
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productAction.getUserUuid();
	}

	/**
	* Sets the user uuid of this product action.
	*
	* @param userUuid the user uuid of this product action
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_productAction.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this product action.
	*
	* @return the create date of this product action
	*/
	public java.util.Date getCreateDate() {
		return _productAction.getCreateDate();
	}

	/**
	* Sets the create date of this product action.
	*
	* @param createDate the create date of this product action
	*/
	public void setCreateDate(java.util.Date createDate) {
		_productAction.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this product action.
	*
	* @return the modified date of this product action
	*/
	public java.util.Date getModifiedDate() {
		return _productAction.getModifiedDate();
	}

	/**
	* Sets the modified date of this product action.
	*
	* @param modifiedDate the modified date of this product action
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_productAction.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the action type of this product action.
	*
	* @return the action type of this product action
	*/
	public java.lang.String getActionType() {
		return _productAction.getActionType();
	}

	/**
	* Sets the action type of this product action.
	*
	* @param actionType the action type of this product action
	*/
	public void setActionType(java.lang.String actionType) {
		_productAction.setActionType(actionType);
	}

	/**
	* Returns the subscriber type of this product action.
	*
	* @return the subscriber type of this product action
	*/
	public int getSubscriberType() {
		return _productAction.getSubscriberType();
	}

	/**
	* Sets the subscriber type of this product action.
	*
	* @param subscriberType the subscriber type of this product action
	*/
	public void setSubscriberType(int subscriberType) {
		_productAction.setSubscriberType(subscriberType);
	}

	/**
	* Returns the product ID of this product action.
	*
	* @return the product ID of this product action
	*/
	public long getProductId() {
		return _productAction.getProductId();
	}

	/**
	* Sets the product ID of this product action.
	*
	* @param productId the product ID of this product action
	*/
	public void setProductId(long productId) {
		_productAction.setProductId(productId);
	}

	/**
	* Returns the balance type of this product action.
	*
	* @return the balance type of this product action
	*/
	public java.lang.String getBalanceType() {
		return _productAction.getBalanceType();
	}

	/**
	* Sets the balance type of this product action.
	*
	* @param balanceType the balance type of this product action
	*/
	public void setBalanceType(java.lang.String balanceType) {
		_productAction.setBalanceType(balanceType);
	}

	/**
	* Returns the command ID of this product action.
	*
	* @return the command ID of this product action
	*/
	public long getCommandId() {
		return _productAction.getCommandId();
	}

	/**
	* Sets the command ID of this product action.
	*
	* @param commandId the command ID of this product action
	*/
	public void setCommandId(long commandId) {
		_productAction.setCommandId(commandId);
	}

	/**
	* Returns the description of this product action.
	*
	* @return the description of this product action
	*/
	public java.lang.String getDescription() {
		return _productAction.getDescription();
	}

	/**
	* Sets the description of this product action.
	*
	* @param description the description of this product action
	*/
	public void setDescription(java.lang.String description) {
		_productAction.setDescription(description);
	}

	public boolean isNew() {
		return _productAction.isNew();
	}

	public void setNew(boolean n) {
		_productAction.setNew(n);
	}

	public boolean isCachedModel() {
		return _productAction.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_productAction.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _productAction.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _productAction.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_productAction.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _productAction.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_productAction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductActionWrapper((ProductAction)_productAction.clone());
	}

	public int compareTo(
		com.cmc.gateway.domain.model.ProductAction productAction) {
		return _productAction.compareTo(productAction);
	}

	@Override
	public int hashCode() {
		return _productAction.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.ProductAction> toCacheModel() {
		return _productAction.toCacheModel();
	}

	public com.cmc.gateway.domain.model.ProductAction toEscapedModel() {
		return new ProductActionWrapper(_productAction.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _productAction.toString();
	}

	public java.lang.String toXmlString() {
		return _productAction.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_productAction.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProductAction getWrappedProductAction() {
		return _productAction;
	}

	public ProductAction getWrappedModel() {
		return _productAction;
	}

	public void resetOriginalValues() {
		_productAction.resetOriginalValues();
	}

	private ProductAction _productAction;
}