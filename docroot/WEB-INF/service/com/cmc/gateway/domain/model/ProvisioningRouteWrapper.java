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
 * This class is a wrapper for {@link ProvisioningRoute}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProvisioningRoute
 * @generated
 */
public class ProvisioningRouteWrapper implements ProvisioningRoute,
	ModelWrapper<ProvisioningRoute> {
	public ProvisioningRouteWrapper(ProvisioningRoute provisioningRoute) {
		_provisioningRoute = provisioningRoute;
	}

	public Class<?> getModelClass() {
		return ProvisioningRoute.class;
	}

	public String getModelClassName() {
		return ProvisioningRoute.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("routeId", getRouteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("provisioningId", getProvisioningId());
		attributes.put("provisioningType", getProvisioningType());
		attributes.put("routeType", getRouteType());
		attributes.put("routeKey", getRouteKey());
		attributes.put("description", getDescription());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long routeId = (Long)attributes.get("routeId");

		if (routeId != null) {
			setRouteId(routeId);
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

		String provisioningType = (String)attributes.get("provisioningType");

		if (provisioningType != null) {
			setProvisioningType(provisioningType);
		}

		String routeType = (String)attributes.get("routeType");

		if (routeType != null) {
			setRouteType(routeType);
		}

		String routeKey = (String)attributes.get("routeKey");

		if (routeKey != null) {
			setRouteKey(routeKey);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this provisioning route.
	*
	* @return the primary key of this provisioning route
	*/
	public long getPrimaryKey() {
		return _provisioningRoute.getPrimaryKey();
	}

	/**
	* Sets the primary key of this provisioning route.
	*
	* @param primaryKey the primary key of this provisioning route
	*/
	public void setPrimaryKey(long primaryKey) {
		_provisioningRoute.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the route ID of this provisioning route.
	*
	* @return the route ID of this provisioning route
	*/
	public long getRouteId() {
		return _provisioningRoute.getRouteId();
	}

	/**
	* Sets the route ID of this provisioning route.
	*
	* @param routeId the route ID of this provisioning route
	*/
	public void setRouteId(long routeId) {
		_provisioningRoute.setRouteId(routeId);
	}

	/**
	* Returns the group ID of this provisioning route.
	*
	* @return the group ID of this provisioning route
	*/
	public long getGroupId() {
		return _provisioningRoute.getGroupId();
	}

	/**
	* Sets the group ID of this provisioning route.
	*
	* @param groupId the group ID of this provisioning route
	*/
	public void setGroupId(long groupId) {
		_provisioningRoute.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this provisioning route.
	*
	* @return the company ID of this provisioning route
	*/
	public long getCompanyId() {
		return _provisioningRoute.getCompanyId();
	}

	/**
	* Sets the company ID of this provisioning route.
	*
	* @param companyId the company ID of this provisioning route
	*/
	public void setCompanyId(long companyId) {
		_provisioningRoute.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this provisioning route.
	*
	* @return the user ID of this provisioning route
	*/
	public long getUserId() {
		return _provisioningRoute.getUserId();
	}

	/**
	* Sets the user ID of this provisioning route.
	*
	* @param userId the user ID of this provisioning route
	*/
	public void setUserId(long userId) {
		_provisioningRoute.setUserId(userId);
	}

	/**
	* Returns the user uuid of this provisioning route.
	*
	* @return the user uuid of this provisioning route
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRoute.getUserUuid();
	}

	/**
	* Sets the user uuid of this provisioning route.
	*
	* @param userUuid the user uuid of this provisioning route
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_provisioningRoute.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this provisioning route.
	*
	* @return the create date of this provisioning route
	*/
	public java.util.Date getCreateDate() {
		return _provisioningRoute.getCreateDate();
	}

	/**
	* Sets the create date of this provisioning route.
	*
	* @param createDate the create date of this provisioning route
	*/
	public void setCreateDate(java.util.Date createDate) {
		_provisioningRoute.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this provisioning route.
	*
	* @return the modified date of this provisioning route
	*/
	public java.util.Date getModifiedDate() {
		return _provisioningRoute.getModifiedDate();
	}

	/**
	* Sets the modified date of this provisioning route.
	*
	* @param modifiedDate the modified date of this provisioning route
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_provisioningRoute.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the provisioning ID of this provisioning route.
	*
	* @return the provisioning ID of this provisioning route
	*/
	public long getProvisioningId() {
		return _provisioningRoute.getProvisioningId();
	}

	/**
	* Sets the provisioning ID of this provisioning route.
	*
	* @param provisioningId the provisioning ID of this provisioning route
	*/
	public void setProvisioningId(long provisioningId) {
		_provisioningRoute.setProvisioningId(provisioningId);
	}

	/**
	* Returns the provisioning type of this provisioning route.
	*
	* @return the provisioning type of this provisioning route
	*/
	public java.lang.String getProvisioningType() {
		return _provisioningRoute.getProvisioningType();
	}

	/**
	* Sets the provisioning type of this provisioning route.
	*
	* @param provisioningType the provisioning type of this provisioning route
	*/
	public void setProvisioningType(java.lang.String provisioningType) {
		_provisioningRoute.setProvisioningType(provisioningType);
	}

	/**
	* Returns the route type of this provisioning route.
	*
	* @return the route type of this provisioning route
	*/
	public java.lang.String getRouteType() {
		return _provisioningRoute.getRouteType();
	}

	/**
	* Sets the route type of this provisioning route.
	*
	* @param routeType the route type of this provisioning route
	*/
	public void setRouteType(java.lang.String routeType) {
		_provisioningRoute.setRouteType(routeType);
	}

	/**
	* Returns the route key of this provisioning route.
	*
	* @return the route key of this provisioning route
	*/
	public java.lang.String getRouteKey() {
		return _provisioningRoute.getRouteKey();
	}

	/**
	* Sets the route key of this provisioning route.
	*
	* @param routeKey the route key of this provisioning route
	*/
	public void setRouteKey(java.lang.String routeKey) {
		_provisioningRoute.setRouteKey(routeKey);
	}

	/**
	* Returns the description of this provisioning route.
	*
	* @return the description of this provisioning route
	*/
	public java.lang.String getDescription() {
		return _provisioningRoute.getDescription();
	}

	/**
	* Sets the description of this provisioning route.
	*
	* @param description the description of this provisioning route
	*/
	public void setDescription(java.lang.String description) {
		_provisioningRoute.setDescription(description);
	}

	public boolean isNew() {
		return _provisioningRoute.isNew();
	}

	public void setNew(boolean n) {
		_provisioningRoute.setNew(n);
	}

	public boolean isCachedModel() {
		return _provisioningRoute.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_provisioningRoute.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _provisioningRoute.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _provisioningRoute.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_provisioningRoute.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _provisioningRoute.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_provisioningRoute.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProvisioningRouteWrapper((ProvisioningRoute)_provisioningRoute.clone());
	}

	public int compareTo(
		com.cmc.gateway.domain.model.ProvisioningRoute provisioningRoute) {
		return _provisioningRoute.compareTo(provisioningRoute);
	}

	@Override
	public int hashCode() {
		return _provisioningRoute.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.ProvisioningRoute> toCacheModel() {
		return _provisioningRoute.toCacheModel();
	}

	public com.cmc.gateway.domain.model.ProvisioningRoute toEscapedModel() {
		return new ProvisioningRouteWrapper(_provisioningRoute.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _provisioningRoute.toString();
	}

	public java.lang.String toXmlString() {
		return _provisioningRoute.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_provisioningRoute.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProvisioningRoute getWrappedProvisioningRoute() {
		return _provisioningRoute;
	}

	public ProvisioningRoute getWrappedModel() {
		return _provisioningRoute;
	}

	public void resetOriginalValues() {
		_provisioningRoute.resetOriginalValues();
	}

	private ProvisioningRoute _provisioningRoute;
}