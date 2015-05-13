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
 * This class is used by SOAP remote services, specifically {@link com.cmc.gateway.domain.service.http.AppDomainServiceSoap}.
 *
 * @author    Richard Nguyen
 * @see       com.cmc.gateway.domain.service.http.AppDomainServiceSoap
 * @generated
 */
public class AppDomainSoap implements Serializable {
	public static AppDomainSoap toSoapModel(AppDomain model) {
		AppDomainSoap soapModel = new AppDomainSoap();

		soapModel.setDomainId(model.getDomainId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setType(model.getType());
		soapModel.setCode(model.getCode());
		soapModel.setTitle(model.getTitle());
		soapModel.setValue(model.getValue());
		soapModel.setDefaultValue(model.getDefaultValue());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static AppDomainSoap[] toSoapModels(AppDomain[] models) {
		AppDomainSoap[] soapModels = new AppDomainSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppDomainSoap[][] toSoapModels(AppDomain[][] models) {
		AppDomainSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AppDomainSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppDomainSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppDomainSoap[] toSoapModels(List<AppDomain> models) {
		List<AppDomainSoap> soapModels = new ArrayList<AppDomainSoap>(models.size());

		for (AppDomain model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppDomainSoap[soapModels.size()]);
	}

	public AppDomainSoap() {
	}

	public long getPrimaryKey() {
		return _domainId;
	}

	public void setPrimaryKey(long pk) {
		setDomainId(pk);
	}

	public long getDomainId() {
		return _domainId;
	}

	public void setDomainId(long domainId) {
		_domainId = domainId;
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

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
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

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public boolean getDefaultValue() {
		return _defaultValue;
	}

	public boolean isDefaultValue() {
		return _defaultValue;
	}

	public void setDefaultValue(boolean defaultValue) {
		_defaultValue = defaultValue;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _domainId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _type;
	private String _code;
	private String _title;
	private String _value;
	private boolean _defaultValue;
	private String _description;
}