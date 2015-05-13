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

import com.cmc.gateway.domain.model.ProvisioningRoute;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ProvisioningRoute in entity cache.
 *
 * @author Richard Nguyen
 * @see ProvisioningRoute
 * @generated
 */
public class ProvisioningRouteCacheModel implements CacheModel<ProvisioningRoute>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{routeId=");
		sb.append(routeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", provisioningId=");
		sb.append(provisioningId);
		sb.append(", provisioningType=");
		sb.append(provisioningType);
		sb.append(", routeType=");
		sb.append(routeType);
		sb.append(", routeKey=");
		sb.append(routeKey);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public ProvisioningRoute toEntityModel() {
		ProvisioningRouteImpl provisioningRouteImpl = new ProvisioningRouteImpl();

		provisioningRouteImpl.setRouteId(routeId);
		provisioningRouteImpl.setGroupId(groupId);
		provisioningRouteImpl.setCompanyId(companyId);
		provisioningRouteImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			provisioningRouteImpl.setCreateDate(null);
		}
		else {
			provisioningRouteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			provisioningRouteImpl.setModifiedDate(null);
		}
		else {
			provisioningRouteImpl.setModifiedDate(new Date(modifiedDate));
		}

		provisioningRouteImpl.setProvisioningId(provisioningId);

		if (provisioningType == null) {
			provisioningRouteImpl.setProvisioningType(StringPool.BLANK);
		}
		else {
			provisioningRouteImpl.setProvisioningType(provisioningType);
		}

		if (routeType == null) {
			provisioningRouteImpl.setRouteType(StringPool.BLANK);
		}
		else {
			provisioningRouteImpl.setRouteType(routeType);
		}

		if (routeKey == null) {
			provisioningRouteImpl.setRouteKey(StringPool.BLANK);
		}
		else {
			provisioningRouteImpl.setRouteKey(routeKey);
		}

		if (description == null) {
			provisioningRouteImpl.setDescription(StringPool.BLANK);
		}
		else {
			provisioningRouteImpl.setDescription(description);
		}

		provisioningRouteImpl.resetOriginalValues();

		return provisioningRouteImpl;
	}

	public long routeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long provisioningId;
	public String provisioningType;
	public String routeType;
	public String routeKey;
	public String description;
}