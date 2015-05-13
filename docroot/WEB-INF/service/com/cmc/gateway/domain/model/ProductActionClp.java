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

import com.cmc.gateway.domain.service.ProductActionLocalServiceUtil;

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
public class ProductActionClp extends BaseModelImpl<ProductAction>
	implements ProductAction {
	public ProductActionClp() {
	}

	public Class<?> getModelClass() {
		return ProductAction.class;
	}

	public String getModelClassName() {
		return ProductAction.class.getName();
	}

	public long getPrimaryKey() {
		return _actionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setActionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_actionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public BaseModel<?> getProductActionRemoteModel() {
		return _productActionRemoteModel;
	}

	public void setProductActionRemoteModel(
		BaseModel<?> productActionRemoteModel) {
		_productActionRemoteModel = productActionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ProductActionLocalServiceUtil.addProductAction(this);
		}
		else {
			ProductActionLocalServiceUtil.updateProductAction(this);
		}
	}

	@Override
	public ProductAction toEscapedModel() {
		return (ProductAction)Proxy.newProxyInstance(ProductAction.class.getClassLoader(),
			new Class[] { ProductAction.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProductActionClp clone = new ProductActionClp();

		clone.setActionId(getActionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setActionType(getActionType());
		clone.setSubscriberType(getSubscriberType());
		clone.setProductId(getProductId());
		clone.setBalanceType(getBalanceType());
		clone.setCommandId(getCommandId());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ProductAction productAction) {
		int value = 0;

		value = getActionType().compareTo(productAction.getActionType());

		if (value != 0) {
			return value;
		}

		if (getSubscriberType() < productAction.getSubscriberType()) {
			value = -1;
		}
		else if (getSubscriberType() > productAction.getSubscriberType()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		ProductActionClp productAction = null;

		try {
			productAction = (ProductActionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = productAction.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{actionId=");
		sb.append(getActionId());
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
		sb.append(", actionType=");
		sb.append(getActionType());
		sb.append(", subscriberType=");
		sb.append(getSubscriberType());
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", balanceType=");
		sb.append(getBalanceType());
		sb.append(", commandId=");
		sb.append(getCommandId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.cmc.gateway.domain.model.ProductAction");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>actionId</column-name><column-value><![CDATA[");
		sb.append(getActionId());
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
			"<column><column-name>actionType</column-name><column-value><![CDATA[");
		sb.append(getActionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subscriberType</column-name><column-value><![CDATA[");
		sb.append(getSubscriberType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>balanceType</column-name><column-value><![CDATA[");
		sb.append(getBalanceType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commandId</column-name><column-value><![CDATA[");
		sb.append(getCommandId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _actionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _actionType;
	private int _subscriberType;
	private long _productId;
	private String _balanceType;
	private long _commandId;
	private String _description;
	private BaseModel<?> _productActionRemoteModel;
}