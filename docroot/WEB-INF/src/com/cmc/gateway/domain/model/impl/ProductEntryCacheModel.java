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

import com.cmc.gateway.domain.model.ProductEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ProductEntry in entity cache.
 *
 * @author Richard Nguyen
 * @see ProductEntry
 * @generated
 */
public class ProductEntryCacheModel implements CacheModel<ProductEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{productId=");
		sb.append(productId);
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
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", productType=");
		sb.append(productType);
		sb.append(", code=");
		sb.append(code);
		sb.append(", title=");
		sb.append(title);
		sb.append(", sku=");
		sb.append(sku);
		sb.append(", price=");
		sb.append(price);
		sb.append(", subscriberTypes=");
		sb.append(subscriberTypes);
		sb.append(", termOfUse=");
		sb.append(termOfUse);
		sb.append(", termPeriod=");
		sb.append(termPeriod);
		sb.append(", termUnit=");
		sb.append(termUnit);
		sb.append(", subscription=");
		sb.append(subscription);
		sb.append(", subscriptionUnit=");
		sb.append(subscriptionUnit);
		sb.append(", subscriptionPeriod=");
		sb.append(subscriptionPeriod);
		sb.append(", gracePeriod=");
		sb.append(gracePeriod);
		sb.append(", graceUnit=");
		sb.append(graceUnit);
		sb.append(", status=");
		sb.append(status);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public ProductEntry toEntityModel() {
		ProductEntryImpl productEntryImpl = new ProductEntryImpl();

		productEntryImpl.setProductId(productId);
		productEntryImpl.setGroupId(groupId);
		productEntryImpl.setCompanyId(companyId);
		productEntryImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			productEntryImpl.setCreateDate(null);
		}
		else {
			productEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productEntryImpl.setModifiedDate(null);
		}
		else {
			productEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		productEntryImpl.setCategoryId(categoryId);

		if (productType == null) {
			productEntryImpl.setProductType(StringPool.BLANK);
		}
		else {
			productEntryImpl.setProductType(productType);
		}

		if (code == null) {
			productEntryImpl.setCode(StringPool.BLANK);
		}
		else {
			productEntryImpl.setCode(code);
		}

		if (title == null) {
			productEntryImpl.setTitle(StringPool.BLANK);
		}
		else {
			productEntryImpl.setTitle(title);
		}

		if (sku == null) {
			productEntryImpl.setSku(StringPool.BLANK);
		}
		else {
			productEntryImpl.setSku(sku);
		}

		productEntryImpl.setPrice(price);

		if (subscriberTypes == null) {
			productEntryImpl.setSubscriberTypes(StringPool.BLANK);
		}
		else {
			productEntryImpl.setSubscriberTypes(subscriberTypes);
		}

		productEntryImpl.setTermOfUse(termOfUse);
		productEntryImpl.setTermPeriod(termPeriod);

		if (termUnit == null) {
			productEntryImpl.setTermUnit(StringPool.BLANK);
		}
		else {
			productEntryImpl.setTermUnit(termUnit);
		}

		productEntryImpl.setSubscription(subscription);

		if (subscriptionUnit == null) {
			productEntryImpl.setSubscriptionUnit(StringPool.BLANK);
		}
		else {
			productEntryImpl.setSubscriptionUnit(subscriptionUnit);
		}

		productEntryImpl.setSubscriptionPeriod(subscriptionPeriod);
		productEntryImpl.setGracePeriod(gracePeriod);

		if (graceUnit == null) {
			productEntryImpl.setGraceUnit(StringPool.BLANK);
		}
		else {
			productEntryImpl.setGraceUnit(graceUnit);
		}

		productEntryImpl.setStatus(status);

		if (description == null) {
			productEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			productEntryImpl.setDescription(description);
		}

		productEntryImpl.resetOriginalValues();

		return productEntryImpl;
	}

	public long productId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long categoryId;
	public String productType;
	public String code;
	public String title;
	public String sku;
	public double price;
	public String subscriberTypes;
	public boolean termOfUse;
	public int termPeriod;
	public String termUnit;
	public boolean subscription;
	public String subscriptionUnit;
	public int subscriptionPeriod;
	public int gracePeriod;
	public String graceUnit;
	public int status;
	public String description;
}