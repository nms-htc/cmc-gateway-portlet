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
 * This class is used by SOAP remote services, specifically {@link com.cmc.gateway.domain.service.http.ProvisioningRouteServiceSoap}.
 *
 * @author    Richard Nguyen
 * @see       com.cmc.gateway.domain.service.http.ProvisioningRouteServiceSoap
 * @generated
 */
public class ProvisioningRouteSoap implements Serializable {
	public static ProvisioningRouteSoap toSoapModel(ProvisioningRoute model) {
		ProvisioningRouteSoap soapModel = new ProvisioningRouteSoap();

		soapModel.setRouteId(model.getRouteId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProvisioningId(model.getProvisioningId());
		soapModel.setProvisioningType(model.getProvisioningType());
		soapModel.setRouteType(model.getRouteType());
		soapModel.setRouteKey(model.getRouteKey());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ProvisioningRouteSoap[] toSoapModels(
		ProvisioningRoute[] models) {
		ProvisioningRouteSoap[] soapModels = new ProvisioningRouteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProvisioningRouteSoap[][] toSoapModels(
		ProvisioningRoute[][] models) {
		ProvisioningRouteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProvisioningRouteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProvisioningRouteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProvisioningRouteSoap[] toSoapModels(
		List<ProvisioningRoute> models) {
		List<ProvisioningRouteSoap> soapModels = new ArrayList<ProvisioningRouteSoap>(models.size());

		for (ProvisioningRoute model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProvisioningRouteSoap[soapModels.size()]);
	}

	public ProvisioningRouteSoap() {
	}

	public long getPrimaryKey() {
		return _routeId;
	}

	public void setPrimaryKey(long pk) {
		setRouteId(pk);
	}

	public long getRouteId() {
		return _routeId;
	}

	public void setRouteId(long routeId) {
		_routeId = routeId;
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

	public long getProvisioningId() {
		return _provisioningId;
	}

	public void setProvisioningId(long provisioningId) {
		_provisioningId = provisioningId;
	}

	public String getProvisioningType() {
		return _provisioningType;
	}

	public void setProvisioningType(String provisioningType) {
		_provisioningType = provisioningType;
	}

	public String getRouteType() {
		return _routeType;
	}

	public void setRouteType(String routeType) {
		_routeType = routeType;
	}

	public String getRouteKey() {
		return _routeKey;
	}

	public void setRouteKey(String routeKey) {
		_routeKey = routeKey;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _routeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _provisioningId;
	private String _provisioningType;
	private String _routeType;
	private String _routeKey;
	private String _description;
}