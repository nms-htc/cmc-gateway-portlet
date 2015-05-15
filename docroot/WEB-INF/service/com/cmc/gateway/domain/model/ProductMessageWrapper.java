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
 * This class is a wrapper for {@link ProductMessage}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProductMessage
 * @generated
 */
public class ProductMessageWrapper implements ProductMessage,
	ModelWrapper<ProductMessage> {
	public ProductMessageWrapper(ProductMessage productMessage) {
		_productMessage = productMessage;
	}

	public Class<?> getModelClass() {
		return ProductMessage.class;
	}

	public String getModelClassName() {
		return ProductMessage.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("productId", getProductId());
		attributes.put("actionType", getActionType());
		attributes.put("channel", getChannel());
		attributes.put("cause", getCause());
		attributes.put("languageId", getLanguageId());
		attributes.put("causeValue", getCauseValue());
		attributes.put("content", getContent());
		attributes.put("description", getDescription());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
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

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String actionType = (String)attributes.get("actionType");

		if (actionType != null) {
			setActionType(actionType);
		}

		String channel = (String)attributes.get("channel");

		if (channel != null) {
			setChannel(channel);
		}

		String cause = (String)attributes.get("cause");

		if (cause != null) {
			setCause(cause);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		Integer causeValue = (Integer)attributes.get("causeValue");

		if (causeValue != null) {
			setCauseValue(causeValue);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this product message.
	*
	* @return the primary key of this product message
	*/
	public long getPrimaryKey() {
		return _productMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product message.
	*
	* @param primaryKey the primary key of this product message
	*/
	public void setPrimaryKey(long primaryKey) {
		_productMessage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the message ID of this product message.
	*
	* @return the message ID of this product message
	*/
	public long getMessageId() {
		return _productMessage.getMessageId();
	}

	/**
	* Sets the message ID of this product message.
	*
	* @param messageId the message ID of this product message
	*/
	public void setMessageId(long messageId) {
		_productMessage.setMessageId(messageId);
	}

	/**
	* Returns the group ID of this product message.
	*
	* @return the group ID of this product message
	*/
	public long getGroupId() {
		return _productMessage.getGroupId();
	}

	/**
	* Sets the group ID of this product message.
	*
	* @param groupId the group ID of this product message
	*/
	public void setGroupId(long groupId) {
		_productMessage.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this product message.
	*
	* @return the company ID of this product message
	*/
	public long getCompanyId() {
		return _productMessage.getCompanyId();
	}

	/**
	* Sets the company ID of this product message.
	*
	* @param companyId the company ID of this product message
	*/
	public void setCompanyId(long companyId) {
		_productMessage.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this product message.
	*
	* @return the user ID of this product message
	*/
	public long getUserId() {
		return _productMessage.getUserId();
	}

	/**
	* Sets the user ID of this product message.
	*
	* @param userId the user ID of this product message
	*/
	public void setUserId(long userId) {
		_productMessage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this product message.
	*
	* @return the user uuid of this product message
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productMessage.getUserUuid();
	}

	/**
	* Sets the user uuid of this product message.
	*
	* @param userUuid the user uuid of this product message
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_productMessage.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this product message.
	*
	* @return the create date of this product message
	*/
	public java.util.Date getCreateDate() {
		return _productMessage.getCreateDate();
	}

	/**
	* Sets the create date of this product message.
	*
	* @param createDate the create date of this product message
	*/
	public void setCreateDate(java.util.Date createDate) {
		_productMessage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this product message.
	*
	* @return the modified date of this product message
	*/
	public java.util.Date getModifiedDate() {
		return _productMessage.getModifiedDate();
	}

	/**
	* Sets the modified date of this product message.
	*
	* @param modifiedDate the modified date of this product message
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_productMessage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the product ID of this product message.
	*
	* @return the product ID of this product message
	*/
	public long getProductId() {
		return _productMessage.getProductId();
	}

	/**
	* Sets the product ID of this product message.
	*
	* @param productId the product ID of this product message
	*/
	public void setProductId(long productId) {
		_productMessage.setProductId(productId);
	}

	/**
	* Returns the action type of this product message.
	*
	* @return the action type of this product message
	*/
	public java.lang.String getActionType() {
		return _productMessage.getActionType();
	}

	/**
	* Sets the action type of this product message.
	*
	* @param actionType the action type of this product message
	*/
	public void setActionType(java.lang.String actionType) {
		_productMessage.setActionType(actionType);
	}

	/**
	* Returns the channel of this product message.
	*
	* @return the channel of this product message
	*/
	public java.lang.String getChannel() {
		return _productMessage.getChannel();
	}

	/**
	* Sets the channel of this product message.
	*
	* @param channel the channel of this product message
	*/
	public void setChannel(java.lang.String channel) {
		_productMessage.setChannel(channel);
	}

	/**
	* Returns the cause of this product message.
	*
	* @return the cause of this product message
	*/
	public java.lang.String getCause() {
		return _productMessage.getCause();
	}

	/**
	* Sets the cause of this product message.
	*
	* @param cause the cause of this product message
	*/
	public void setCause(java.lang.String cause) {
		_productMessage.setCause(cause);
	}

	/**
	* Returns the language ID of this product message.
	*
	* @return the language ID of this product message
	*/
	public java.lang.String getLanguageId() {
		return _productMessage.getLanguageId();
	}

	/**
	* Sets the language ID of this product message.
	*
	* @param languageId the language ID of this product message
	*/
	public void setLanguageId(java.lang.String languageId) {
		_productMessage.setLanguageId(languageId);
	}

	/**
	* Returns the cause value of this product message.
	*
	* @return the cause value of this product message
	*/
	public int getCauseValue() {
		return _productMessage.getCauseValue();
	}

	/**
	* Sets the cause value of this product message.
	*
	* @param causeValue the cause value of this product message
	*/
	public void setCauseValue(int causeValue) {
		_productMessage.setCauseValue(causeValue);
	}

	/**
	* Returns the content of this product message.
	*
	* @return the content of this product message
	*/
	public java.lang.String getContent() {
		return _productMessage.getContent();
	}

	/**
	* Sets the content of this product message.
	*
	* @param content the content of this product message
	*/
	public void setContent(java.lang.String content) {
		_productMessage.setContent(content);
	}

	/**
	* Returns the description of this product message.
	*
	* @return the description of this product message
	*/
	public java.lang.String getDescription() {
		return _productMessage.getDescription();
	}

	/**
	* Sets the description of this product message.
	*
	* @param description the description of this product message
	*/
	public void setDescription(java.lang.String description) {
		_productMessage.setDescription(description);
	}

	public boolean isNew() {
		return _productMessage.isNew();
	}

	public void setNew(boolean n) {
		_productMessage.setNew(n);
	}

	public boolean isCachedModel() {
		return _productMessage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_productMessage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _productMessage.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _productMessage.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_productMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _productMessage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_productMessage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductMessageWrapper((ProductMessage)_productMessage.clone());
	}

	public int compareTo(
		com.cmc.gateway.domain.model.ProductMessage productMessage) {
		return _productMessage.compareTo(productMessage);
	}

	@Override
	public int hashCode() {
		return _productMessage.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.ProductMessage> toCacheModel() {
		return _productMessage.toCacheModel();
	}

	public com.cmc.gateway.domain.model.ProductMessage toEscapedModel() {
		return new ProductMessageWrapper(_productMessage.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _productMessage.toString();
	}

	public java.lang.String toXmlString() {
		return _productMessage.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_productMessage.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProductMessage getWrappedProductMessage() {
		return _productMessage;
	}

	public ProductMessage getWrappedModel() {
		return _productMessage;
	}

	public void resetOriginalValues() {
		_productMessage.resetOriginalValues();
	}

	private ProductMessage _productMessage;
}