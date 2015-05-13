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
 * This class is a wrapper for {@link ProvisioningMessage}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProvisioningMessage
 * @generated
 */
public class ProvisioningMessageWrapper implements ProvisioningMessage,
	ModelWrapper<ProvisioningMessage> {
	public ProvisioningMessageWrapper(ProvisioningMessage provisioningMessage) {
		_provisioningMessage = provisioningMessage;
	}

	public Class<?> getModelClass() {
		return ProvisioningMessage.class;
	}

	public String getModelClassName() {
		return ProvisioningMessage.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("provisioningId", getProvisioningId());
		attributes.put("responseCode", getResponseCode());
		attributes.put("cause", getCause());
		attributes.put("causeValue", getCauseValue());
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

		Long provisioningId = (Long)attributes.get("provisioningId");

		if (provisioningId != null) {
			setProvisioningId(provisioningId);
		}

		String responseCode = (String)attributes.get("responseCode");

		if (responseCode != null) {
			setResponseCode(responseCode);
		}

		String cause = (String)attributes.get("cause");

		if (cause != null) {
			setCause(cause);
		}

		Integer causeValue = (Integer)attributes.get("causeValue");

		if (causeValue != null) {
			setCauseValue(causeValue);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this provisioning message.
	*
	* @return the primary key of this provisioning message
	*/
	public long getPrimaryKey() {
		return _provisioningMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this provisioning message.
	*
	* @param primaryKey the primary key of this provisioning message
	*/
	public void setPrimaryKey(long primaryKey) {
		_provisioningMessage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the message ID of this provisioning message.
	*
	* @return the message ID of this provisioning message
	*/
	public long getMessageId() {
		return _provisioningMessage.getMessageId();
	}

	/**
	* Sets the message ID of this provisioning message.
	*
	* @param messageId the message ID of this provisioning message
	*/
	public void setMessageId(long messageId) {
		_provisioningMessage.setMessageId(messageId);
	}

	/**
	* Returns the group ID of this provisioning message.
	*
	* @return the group ID of this provisioning message
	*/
	public long getGroupId() {
		return _provisioningMessage.getGroupId();
	}

	/**
	* Sets the group ID of this provisioning message.
	*
	* @param groupId the group ID of this provisioning message
	*/
	public void setGroupId(long groupId) {
		_provisioningMessage.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this provisioning message.
	*
	* @return the company ID of this provisioning message
	*/
	public long getCompanyId() {
		return _provisioningMessage.getCompanyId();
	}

	/**
	* Sets the company ID of this provisioning message.
	*
	* @param companyId the company ID of this provisioning message
	*/
	public void setCompanyId(long companyId) {
		_provisioningMessage.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this provisioning message.
	*
	* @return the user ID of this provisioning message
	*/
	public long getUserId() {
		return _provisioningMessage.getUserId();
	}

	/**
	* Sets the user ID of this provisioning message.
	*
	* @param userId the user ID of this provisioning message
	*/
	public void setUserId(long userId) {
		_provisioningMessage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this provisioning message.
	*
	* @return the user uuid of this provisioning message
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningMessage.getUserUuid();
	}

	/**
	* Sets the user uuid of this provisioning message.
	*
	* @param userUuid the user uuid of this provisioning message
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_provisioningMessage.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this provisioning message.
	*
	* @return the create date of this provisioning message
	*/
	public java.util.Date getCreateDate() {
		return _provisioningMessage.getCreateDate();
	}

	/**
	* Sets the create date of this provisioning message.
	*
	* @param createDate the create date of this provisioning message
	*/
	public void setCreateDate(java.util.Date createDate) {
		_provisioningMessage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this provisioning message.
	*
	* @return the modified date of this provisioning message
	*/
	public java.util.Date getModifiedDate() {
		return _provisioningMessage.getModifiedDate();
	}

	/**
	* Sets the modified date of this provisioning message.
	*
	* @param modifiedDate the modified date of this provisioning message
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_provisioningMessage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the provisioning ID of this provisioning message.
	*
	* @return the provisioning ID of this provisioning message
	*/
	public long getProvisioningId() {
		return _provisioningMessage.getProvisioningId();
	}

	/**
	* Sets the provisioning ID of this provisioning message.
	*
	* @param provisioningId the provisioning ID of this provisioning message
	*/
	public void setProvisioningId(long provisioningId) {
		_provisioningMessage.setProvisioningId(provisioningId);
	}

	/**
	* Returns the response code of this provisioning message.
	*
	* @return the response code of this provisioning message
	*/
	public java.lang.String getResponseCode() {
		return _provisioningMessage.getResponseCode();
	}

	/**
	* Sets the response code of this provisioning message.
	*
	* @param responseCode the response code of this provisioning message
	*/
	public void setResponseCode(java.lang.String responseCode) {
		_provisioningMessage.setResponseCode(responseCode);
	}

	/**
	* Returns the cause of this provisioning message.
	*
	* @return the cause of this provisioning message
	*/
	public java.lang.String getCause() {
		return _provisioningMessage.getCause();
	}

	/**
	* Sets the cause of this provisioning message.
	*
	* @param cause the cause of this provisioning message
	*/
	public void setCause(java.lang.String cause) {
		_provisioningMessage.setCause(cause);
	}

	/**
	* Returns the cause value of this provisioning message.
	*
	* @return the cause value of this provisioning message
	*/
	public int getCauseValue() {
		return _provisioningMessage.getCauseValue();
	}

	/**
	* Sets the cause value of this provisioning message.
	*
	* @param causeValue the cause value of this provisioning message
	*/
	public void setCauseValue(int causeValue) {
		_provisioningMessage.setCauseValue(causeValue);
	}

	/**
	* Returns the description of this provisioning message.
	*
	* @return the description of this provisioning message
	*/
	public java.lang.String getDescription() {
		return _provisioningMessage.getDescription();
	}

	/**
	* Sets the description of this provisioning message.
	*
	* @param description the description of this provisioning message
	*/
	public void setDescription(java.lang.String description) {
		_provisioningMessage.setDescription(description);
	}

	public boolean isNew() {
		return _provisioningMessage.isNew();
	}

	public void setNew(boolean n) {
		_provisioningMessage.setNew(n);
	}

	public boolean isCachedModel() {
		return _provisioningMessage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_provisioningMessage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _provisioningMessage.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _provisioningMessage.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_provisioningMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _provisioningMessage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_provisioningMessage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProvisioningMessageWrapper((ProvisioningMessage)_provisioningMessage.clone());
	}

	public int compareTo(
		com.cmc.gateway.domain.model.ProvisioningMessage provisioningMessage) {
		return _provisioningMessage.compareTo(provisioningMessage);
	}

	@Override
	public int hashCode() {
		return _provisioningMessage.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.ProvisioningMessage> toCacheModel() {
		return _provisioningMessage.toCacheModel();
	}

	public com.cmc.gateway.domain.model.ProvisioningMessage toEscapedModel() {
		return new ProvisioningMessageWrapper(_provisioningMessage.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _provisioningMessage.toString();
	}

	public java.lang.String toXmlString() {
		return _provisioningMessage.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_provisioningMessage.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProvisioningMessage getWrappedProvisioningMessage() {
		return _provisioningMessage;
	}

	public ProvisioningMessage getWrappedModel() {
		return _provisioningMessage;
	}

	public void resetOriginalValues() {
		_provisioningMessage.resetOriginalValues();
	}

	private ProvisioningMessage _provisioningMessage;
}