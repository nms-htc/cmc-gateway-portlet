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

import com.cmc.gateway.domain.model.ProvisioningEntry;
import com.cmc.gateway.domain.model.ProvisioningEntryModel;
import com.cmc.gateway.domain.model.ProvisioningEntrySoap;

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
 * The base model implementation for the ProvisioningEntry service. Represents a row in the &quot;GW_ProvisioningEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.cmc.gateway.domain.model.ProvisioningEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProvisioningEntryImpl}.
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningEntryImpl
 * @see com.cmc.gateway.domain.model.ProvisioningEntry
 * @see com.cmc.gateway.domain.model.ProvisioningEntryModel
 * @generated
 */
@JSON(strict = true)
public class ProvisioningEntryModelImpl extends BaseModelImpl<ProvisioningEntry>
	implements ProvisioningEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a provisioning entry model instance should use the {@link com.cmc.gateway.domain.model.ProvisioningEntry} interface instead.
	 */
	public static final String TABLE_NAME = "GW_ProvisioningEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "provisioningId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "provisioningType", Types.VARCHAR },
			{ "CODE", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "connectionHost", Types.VARCHAR },
			{ "connectionPort", Types.INTEGER },
			{ "connectByUserName", Types.VARCHAR },
			{ "connectByPassword", Types.VARCHAR },
			{ "processClass", Types.VARCHAR },
			{ "processMethod", Types.VARCHAR },
			{ "properties", Types.VARCHAR },
			{ "status", Types.INTEGER },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table GW_ProvisioningEntry (provisioningId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,provisioningType VARCHAR(75) null,CODE VARCHAR(75) null,title VARCHAR(75) null,connectionHost VARCHAR(75) null,connectionPort INTEGER,connectByUserName VARCHAR(75) null,connectByPassword VARCHAR(75) null,processClass VARCHAR(75) null,processMethod VARCHAR(75) null,properties STRING null,status INTEGER,description STRING null)";
	public static final String TABLE_SQL_DROP = "drop table GW_ProvisioningEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY provisioningEntry.code ASC";
	public static final String ORDER_BY_SQL = " ORDER BY GW_ProvisioningEntry.CODE ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.cmc.gateway.domain.model.ProvisioningEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.cmc.gateway.domain.model.ProvisioningEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.cmc.gateway.domain.model.ProvisioningEntry"),
			true);
	public static long CODE_COLUMN_BITMASK = 1L;
	public static long PROVISIONINGTYPE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ProvisioningEntry toModel(ProvisioningEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProvisioningEntry model = new ProvisioningEntryImpl();

		model.setProvisioningId(soapModel.getProvisioningId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setProvisioningType(soapModel.getProvisioningType());
		model.setCode(soapModel.getCode());
		model.setTitle(soapModel.getTitle());
		model.setConnectionHost(soapModel.getConnectionHost());
		model.setConnectionPort(soapModel.getConnectionPort());
		model.setConnectByUserName(soapModel.getConnectByUserName());
		model.setConnectByPassword(soapModel.getConnectByPassword());
		model.setProcessClass(soapModel.getProcessClass());
		model.setProcessMethod(soapModel.getProcessMethod());
		model.setProperties(soapModel.getProperties());
		model.setStatus(soapModel.getStatus());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ProvisioningEntry> toModels(
		ProvisioningEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ProvisioningEntry> models = new ArrayList<ProvisioningEntry>(soapModels.length);

		for (ProvisioningEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.cmc.gateway.domain.model.ProvisioningEntry"));

	public ProvisioningEntryModelImpl() {
	}

	public long getPrimaryKey() {
		return _provisioningId;
	}

	public void setPrimaryKey(long primaryKey) {
		setProvisioningId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_provisioningId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return ProvisioningEntry.class;
	}

	public String getModelClassName() {
		return ProvisioningEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("provisioningId", getProvisioningId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("provisioningType", getProvisioningType());
		attributes.put("code", getCode());
		attributes.put("title", getTitle());
		attributes.put("connectionHost", getConnectionHost());
		attributes.put("connectionPort", getConnectionPort());
		attributes.put("connectByUserName", getConnectByUserName());
		attributes.put("connectByPassword", getConnectByPassword());
		attributes.put("processClass", getProcessClass());
		attributes.put("processMethod", getProcessMethod());
		attributes.put("properties", getProperties());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long provisioningId = (Long)attributes.get("provisioningId");

		if (provisioningId != null) {
			setProvisioningId(provisioningId);
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

		String provisioningType = (String)attributes.get("provisioningType");

		if (provisioningType != null) {
			setProvisioningType(provisioningType);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String connectionHost = (String)attributes.get("connectionHost");

		if (connectionHost != null) {
			setConnectionHost(connectionHost);
		}

		Integer connectionPort = (Integer)attributes.get("connectionPort");

		if (connectionPort != null) {
			setConnectionPort(connectionPort);
		}

		String connectByUserName = (String)attributes.get("connectByUserName");

		if (connectByUserName != null) {
			setConnectByUserName(connectByUserName);
		}

		String connectByPassword = (String)attributes.get("connectByPassword");

		if (connectByPassword != null) {
			setConnectByPassword(connectByPassword);
		}

		String processClass = (String)attributes.get("processClass");

		if (processClass != null) {
			setProcessClass(processClass);
		}

		String processMethod = (String)attributes.get("processMethod");

		if (processMethod != null) {
			setProcessMethod(processMethod);
		}

		String properties = (String)attributes.get("properties");

		if (properties != null) {
			setProperties(properties);
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

	@JSON
	public long getProvisioningId() {
		return _provisioningId;
	}

	public void setProvisioningId(long provisioningId) {
		_provisioningId = provisioningId;
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
	public String getProvisioningType() {
		if (_provisioningType == null) {
			return StringPool.BLANK;
		}
		else {
			return _provisioningType;
		}
	}

	public void setProvisioningType(String provisioningType) {
		_columnBitmask |= PROVISIONINGTYPE_COLUMN_BITMASK;

		if (_originalProvisioningType == null) {
			_originalProvisioningType = _provisioningType;
		}

		_provisioningType = provisioningType;
	}

	public String getOriginalProvisioningType() {
		return GetterUtil.getString(_originalProvisioningType);
	}

	@JSON
	public String getCode() {
		if (_code == null) {
			return StringPool.BLANK;
		}
		else {
			return _code;
		}
	}

	public void setCode(String code) {
		_columnBitmask = -1L;

		if (_originalCode == null) {
			_originalCode = _code;
		}

		_code = code;
	}

	public String getOriginalCode() {
		return GetterUtil.getString(_originalCode);
	}

	@JSON
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	public String getConnectionHost() {
		if (_connectionHost == null) {
			return StringPool.BLANK;
		}
		else {
			return _connectionHost;
		}
	}

	public void setConnectionHost(String connectionHost) {
		_connectionHost = connectionHost;
	}

	@JSON
	public int getConnectionPort() {
		return _connectionPort;
	}

	public void setConnectionPort(int connectionPort) {
		_connectionPort = connectionPort;
	}

	@JSON
	public String getConnectByUserName() {
		if (_connectByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _connectByUserName;
		}
	}

	public void setConnectByUserName(String connectByUserName) {
		_connectByUserName = connectByUserName;
	}

	@JSON
	public String getConnectByPassword() {
		if (_connectByPassword == null) {
			return StringPool.BLANK;
		}
		else {
			return _connectByPassword;
		}
	}

	public void setConnectByPassword(String connectByPassword) {
		_connectByPassword = connectByPassword;
	}

	@JSON
	public String getProcessClass() {
		if (_processClass == null) {
			return StringPool.BLANK;
		}
		else {
			return _processClass;
		}
	}

	public void setProcessClass(String processClass) {
		_processClass = processClass;
	}

	@JSON
	public String getProcessMethod() {
		if (_processMethod == null) {
			return StringPool.BLANK;
		}
		else {
			return _processMethod;
		}
	}

	public void setProcessMethod(String processMethod) {
		_processMethod = processMethod;
	}

	@JSON
	public String getProperties() {
		if (_properties == null) {
			return StringPool.BLANK;
		}
		else {
			return _properties;
		}
	}

	public void setProperties(String properties) {
		_properties = properties;
	}

	@JSON
	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
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
			ProvisioningEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProvisioningEntry toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (ProvisioningEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ProvisioningEntryImpl provisioningEntryImpl = new ProvisioningEntryImpl();

		provisioningEntryImpl.setProvisioningId(getProvisioningId());
		provisioningEntryImpl.setGroupId(getGroupId());
		provisioningEntryImpl.setCompanyId(getCompanyId());
		provisioningEntryImpl.setUserId(getUserId());
		provisioningEntryImpl.setCreateDate(getCreateDate());
		provisioningEntryImpl.setModifiedDate(getModifiedDate());
		provisioningEntryImpl.setProvisioningType(getProvisioningType());
		provisioningEntryImpl.setCode(getCode());
		provisioningEntryImpl.setTitle(getTitle());
		provisioningEntryImpl.setConnectionHost(getConnectionHost());
		provisioningEntryImpl.setConnectionPort(getConnectionPort());
		provisioningEntryImpl.setConnectByUserName(getConnectByUserName());
		provisioningEntryImpl.setConnectByPassword(getConnectByPassword());
		provisioningEntryImpl.setProcessClass(getProcessClass());
		provisioningEntryImpl.setProcessMethod(getProcessMethod());
		provisioningEntryImpl.setProperties(getProperties());
		provisioningEntryImpl.setStatus(getStatus());
		provisioningEntryImpl.setDescription(getDescription());

		provisioningEntryImpl.resetOriginalValues();

		return provisioningEntryImpl;
	}

	public int compareTo(ProvisioningEntry provisioningEntry) {
		int value = 0;

		value = getCode().compareTo(provisioningEntry.getCode());

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

		ProvisioningEntry provisioningEntry = null;

		try {
			provisioningEntry = (ProvisioningEntry)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = provisioningEntry.getPrimaryKey();

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
		ProvisioningEntryModelImpl provisioningEntryModelImpl = this;

		provisioningEntryModelImpl._originalProvisioningType = provisioningEntryModelImpl._provisioningType;

		provisioningEntryModelImpl._originalCode = provisioningEntryModelImpl._code;

		provisioningEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProvisioningEntry> toCacheModel() {
		ProvisioningEntryCacheModel provisioningEntryCacheModel = new ProvisioningEntryCacheModel();

		provisioningEntryCacheModel.provisioningId = getProvisioningId();

		provisioningEntryCacheModel.groupId = getGroupId();

		provisioningEntryCacheModel.companyId = getCompanyId();

		provisioningEntryCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			provisioningEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			provisioningEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			provisioningEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			provisioningEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		provisioningEntryCacheModel.provisioningType = getProvisioningType();

		String provisioningType = provisioningEntryCacheModel.provisioningType;

		if ((provisioningType != null) && (provisioningType.length() == 0)) {
			provisioningEntryCacheModel.provisioningType = null;
		}

		provisioningEntryCacheModel.code = getCode();

		String code = provisioningEntryCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			provisioningEntryCacheModel.code = null;
		}

		provisioningEntryCacheModel.title = getTitle();

		String title = provisioningEntryCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			provisioningEntryCacheModel.title = null;
		}

		provisioningEntryCacheModel.connectionHost = getConnectionHost();

		String connectionHost = provisioningEntryCacheModel.connectionHost;

		if ((connectionHost != null) && (connectionHost.length() == 0)) {
			provisioningEntryCacheModel.connectionHost = null;
		}

		provisioningEntryCacheModel.connectionPort = getConnectionPort();

		provisioningEntryCacheModel.connectByUserName = getConnectByUserName();

		String connectByUserName = provisioningEntryCacheModel.connectByUserName;

		if ((connectByUserName != null) && (connectByUserName.length() == 0)) {
			provisioningEntryCacheModel.connectByUserName = null;
		}

		provisioningEntryCacheModel.connectByPassword = getConnectByPassword();

		String connectByPassword = provisioningEntryCacheModel.connectByPassword;

		if ((connectByPassword != null) && (connectByPassword.length() == 0)) {
			provisioningEntryCacheModel.connectByPassword = null;
		}

		provisioningEntryCacheModel.processClass = getProcessClass();

		String processClass = provisioningEntryCacheModel.processClass;

		if ((processClass != null) && (processClass.length() == 0)) {
			provisioningEntryCacheModel.processClass = null;
		}

		provisioningEntryCacheModel.processMethod = getProcessMethod();

		String processMethod = provisioningEntryCacheModel.processMethod;

		if ((processMethod != null) && (processMethod.length() == 0)) {
			provisioningEntryCacheModel.processMethod = null;
		}

		provisioningEntryCacheModel.properties = getProperties();

		String properties = provisioningEntryCacheModel.properties;

		if ((properties != null) && (properties.length() == 0)) {
			provisioningEntryCacheModel.properties = null;
		}

		provisioningEntryCacheModel.status = getStatus();

		provisioningEntryCacheModel.description = getDescription();

		String description = provisioningEntryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			provisioningEntryCacheModel.description = null;
		}

		return provisioningEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{provisioningId=");
		sb.append(getProvisioningId());
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
		sb.append(", provisioningType=");
		sb.append(getProvisioningType());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", connectionHost=");
		sb.append(getConnectionHost());
		sb.append(", connectionPort=");
		sb.append(getConnectionPort());
		sb.append(", connectByUserName=");
		sb.append(getConnectByUserName());
		sb.append(", connectByPassword=");
		sb.append(getConnectByPassword());
		sb.append(", processClass=");
		sb.append(getProcessClass());
		sb.append(", processMethod=");
		sb.append(getProcessMethod());
		sb.append(", properties=");
		sb.append(getProperties());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.cmc.gateway.domain.model.ProvisioningEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>provisioningId</column-name><column-value><![CDATA[");
		sb.append(getProvisioningId());
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
			"<column><column-name>provisioningType</column-name><column-value><![CDATA[");
		sb.append(getProvisioningType());
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
			"<column><column-name>connectionHost</column-name><column-value><![CDATA[");
		sb.append(getConnectionHost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>connectionPort</column-name><column-value><![CDATA[");
		sb.append(getConnectionPort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>connectByUserName</column-name><column-value><![CDATA[");
		sb.append(getConnectByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>connectByPassword</column-name><column-value><![CDATA[");
		sb.append(getConnectByPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processClass</column-name><column-value><![CDATA[");
		sb.append(getProcessClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processMethod</column-name><column-value><![CDATA[");
		sb.append(getProcessMethod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>properties</column-name><column-value><![CDATA[");
		sb.append(getProperties());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ProvisioningEntry.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ProvisioningEntry.class
		};
	private long _provisioningId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _provisioningType;
	private String _originalProvisioningType;
	private String _code;
	private String _originalCode;
	private String _title;
	private String _connectionHost;
	private int _connectionPort;
	private String _connectByUserName;
	private String _connectByPassword;
	private String _processClass;
	private String _processMethod;
	private String _properties;
	private int _status;
	private String _description;
	private long _columnBitmask;
	private ProvisioningEntry _escapedModelProxy;
}