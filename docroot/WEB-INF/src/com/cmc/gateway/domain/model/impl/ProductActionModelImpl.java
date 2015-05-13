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

package com.cmc.gateway.domain.model.impl;

import com.cmc.gateway.domain.model.ProductAction;
import com.cmc.gateway.domain.model.ProductActionModel;
import com.cmc.gateway.domain.model.ProductActionSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ProductAction service. Represents a row in the &quot;GW_ProductAction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.cmc.gateway.domain.model.ProductActionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProductActionImpl}.
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductActionImpl
 * @see com.cmc.gateway.domain.model.ProductAction
 * @see com.cmc.gateway.domain.model.ProductActionModel
 * @generated
 */
@JSON(strict = true)
public class ProductActionModelImpl extends BaseModelImpl<ProductAction>
	implements ProductActionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a product action model instance should use the {@link com.cmc.gateway.domain.model.ProductAction} interface instead.
	 */
	public static final String TABLE_NAME = "GW_ProductAction";
	public static final Object[][] TABLE_COLUMNS = {
			{ "actionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "actionType", Types.VARCHAR },
			{ "subscriberType", Types.INTEGER },
			{ "productId", Types.BIGINT },
			{ "balanceType", Types.VARCHAR },
			{ "commandId", Types.BIGINT },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table GW_ProductAction (actionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,actionType VARCHAR(75) null,subscriberType INTEGER,productId LONG,balanceType VARCHAR(75) null,commandId LONG,description STRING null)";
	public static final String TABLE_SQL_DROP = "drop table GW_ProductAction";
	public static final String ORDER_BY_JPQL = " ORDER BY productAction.actionType ASC, productAction.subscriberType ASC";
	public static final String ORDER_BY_SQL = " ORDER BY GW_ProductAction.actionType ASC, GW_ProductAction.subscriberType ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.cmc.gateway.domain.model.ProductAction"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.cmc.gateway.domain.model.ProductAction"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.cmc.gateway.domain.model.ProductAction"),
			true);
	public static long PRODUCTID_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ProductAction toModel(ProductActionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProductAction model = new ProductActionImpl();

		model.setActionId(soapModel.getActionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setActionType(soapModel.getActionType());
		model.setSubscriberType(soapModel.getSubscriberType());
		model.setProductId(soapModel.getProductId());
		model.setBalanceType(soapModel.getBalanceType());
		model.setCommandId(soapModel.getCommandId());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ProductAction> toModels(ProductActionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ProductAction> models = new ArrayList<ProductAction>(soapModels.length);

		for (ProductActionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.cmc.gateway.domain.model.ProductAction"));

	public ProductActionModelImpl() {
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

	public Class<?> getModelClass() {
		return ProductAction.class;
	}

	public String getModelClassName() {
		return ProductAction.class.getName();
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

	@JSON
	public long getActionId() {
		return _actionId;
	}

	public void setActionId(long actionId) {
		_actionId = actionId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
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

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public String getActionType() {
		if (_actionType == null) {
			return StringPool.BLANK;
		}
		else {
			return _actionType;
		}
	}

	public void setActionType(String actionType) {
		_columnBitmask = -1L;

		_actionType = actionType;
	}

	@JSON
	public int getSubscriberType() {
		return _subscriberType;
	}

	public void setSubscriberType(int subscriberType) {
		_columnBitmask = -1L;

		_subscriberType = subscriberType;
	}

	@JSON
	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_columnBitmask |= PRODUCTID_COLUMN_BITMASK;

		if (!_setOriginalProductId) {
			_setOriginalProductId = true;

			_originalProductId = _productId;
		}

		_productId = productId;
	}

	public long getOriginalProductId() {
		return _originalProductId;
	}

	@JSON
	public String getBalanceType() {
		if (_balanceType == null) {
			return StringPool.BLANK;
		}
		else {
			return _balanceType;
		}
	}

	public void setBalanceType(String balanceType) {
		_balanceType = balanceType;
	}

	@JSON
	public long getCommandId() {
		return _commandId;
	}

	public void setCommandId(long commandId) {
		_commandId = commandId;
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ProductAction.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProductAction toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (ProductAction)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ProductActionImpl productActionImpl = new ProductActionImpl();

		productActionImpl.setActionId(getActionId());
		productActionImpl.setGroupId(getGroupId());
		productActionImpl.setCompanyId(getCompanyId());
		productActionImpl.setUserId(getUserId());
		productActionImpl.setCreateDate(getCreateDate());
		productActionImpl.setModifiedDate(getModifiedDate());
		productActionImpl.setActionType(getActionType());
		productActionImpl.setSubscriberType(getSubscriberType());
		productActionImpl.setProductId(getProductId());
		productActionImpl.setBalanceType(getBalanceType());
		productActionImpl.setCommandId(getCommandId());
		productActionImpl.setDescription(getDescription());

		productActionImpl.resetOriginalValues();

		return productActionImpl;
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

		ProductAction productAction = null;

		try {
			productAction = (ProductAction)obj;
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
	public void resetOriginalValues() {
		ProductActionModelImpl productActionModelImpl = this;

		productActionModelImpl._originalProductId = productActionModelImpl._productId;

		productActionModelImpl._setOriginalProductId = false;

		productActionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProductAction> toCacheModel() {
		ProductActionCacheModel productActionCacheModel = new ProductActionCacheModel();

		productActionCacheModel.actionId = getActionId();

		productActionCacheModel.groupId = getGroupId();

		productActionCacheModel.companyId = getCompanyId();

		productActionCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			productActionCacheModel.createDate = createDate.getTime();
		}
		else {
			productActionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			productActionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			productActionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		productActionCacheModel.actionType = getActionType();

		String actionType = productActionCacheModel.actionType;

		if ((actionType != null) && (actionType.length() == 0)) {
			productActionCacheModel.actionType = null;
		}

		productActionCacheModel.subscriberType = getSubscriberType();

		productActionCacheModel.productId = getProductId();

		productActionCacheModel.balanceType = getBalanceType();

		String balanceType = productActionCacheModel.balanceType;

		if ((balanceType != null) && (balanceType.length() == 0)) {
			productActionCacheModel.balanceType = null;
		}

		productActionCacheModel.commandId = getCommandId();

		productActionCacheModel.description = getDescription();

		String description = productActionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			productActionCacheModel.description = null;
		}

		return productActionCacheModel;
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

	private static ClassLoader _classLoader = ProductAction.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ProductAction.class
		};
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
	private long _originalProductId;
	private boolean _setOriginalProductId;
	private String _balanceType;
	private long _commandId;
	private String _description;
	private long _columnBitmask;
	private ProductAction _escapedModelProxy;
}