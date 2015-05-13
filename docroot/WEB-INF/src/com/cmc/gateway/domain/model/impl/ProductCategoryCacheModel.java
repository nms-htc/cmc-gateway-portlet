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

import com.cmc.gateway.domain.model.ProductCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ProductCategory in entity cache.
 *
 * @author Richard Nguyen
 * @see ProductCategory
 * @generated
 */
public class ProductCategoryCacheModel implements CacheModel<ProductCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{categoryId=");
		sb.append(categoryId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public ProductCategory toEntityModel() {
		ProductCategoryImpl productCategoryImpl = new ProductCategoryImpl();

		productCategoryImpl.setCategoryId(categoryId);
		productCategoryImpl.setGroupId(groupId);
		productCategoryImpl.setCompanyId(companyId);
		productCategoryImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			productCategoryImpl.setCreateDate(null);
		}
		else {
			productCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productCategoryImpl.setModifiedDate(null);
		}
		else {
			productCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			productCategoryImpl.setTitle(StringPool.BLANK);
		}
		else {
			productCategoryImpl.setTitle(title);
		}

		if (description == null) {
			productCategoryImpl.setDescription(StringPool.BLANK);
		}
		else {
			productCategoryImpl.setDescription(description);
		}

		productCategoryImpl.resetOriginalValues();

		return productCategoryImpl;
	}

	public long categoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
}