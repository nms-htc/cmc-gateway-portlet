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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ProductAction in entity cache.
 *
 * @author Richard Nguyen
 * @see ProductAction
 * @generated
 */
public class ProductActionCacheModel implements CacheModel<ProductAction>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{actionId=");
		sb.append(actionId);
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
		sb.append(", actionType=");
		sb.append(actionType);
		sb.append(", subscriberType=");
		sb.append(subscriberType);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", balanceType=");
		sb.append(balanceType);
		sb.append(", commandId=");
		sb.append(commandId);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public ProductAction toEntityModel() {
		ProductActionImpl productActionImpl = new ProductActionImpl();

		productActionImpl.setActionId(actionId);
		productActionImpl.setGroupId(groupId);
		productActionImpl.setCompanyId(companyId);
		productActionImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			productActionImpl.setCreateDate(null);
		}
		else {
			productActionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productActionImpl.setModifiedDate(null);
		}
		else {
			productActionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (actionType == null) {
			productActionImpl.setActionType(StringPool.BLANK);
		}
		else {
			productActionImpl.setActionType(actionType);
		}

		productActionImpl.setSubscriberType(subscriberType);
		productActionImpl.setProductId(productId);

		if (balanceType == null) {
			productActionImpl.setBalanceType(StringPool.BLANK);
		}
		else {
			productActionImpl.setBalanceType(balanceType);
		}

		productActionImpl.setCommandId(commandId);

		if (description == null) {
			productActionImpl.setDescription(StringPool.BLANK);
		}
		else {
			productActionImpl.setDescription(description);
		}

		productActionImpl.resetOriginalValues();

		return productActionImpl;
	}

	public long actionId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String actionType;
	public int subscriberType;
	public long productId;
	public String balanceType;
	public long commandId;
	public String description;
}