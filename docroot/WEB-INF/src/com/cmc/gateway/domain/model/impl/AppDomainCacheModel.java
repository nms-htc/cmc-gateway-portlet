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

import com.cmc.gateway.domain.model.AppDomain;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AppDomain in entity cache.
 *
 * @author Richard Nguyen
 * @see AppDomain
 * @generated
 */
public class AppDomainCacheModel implements CacheModel<AppDomain>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{domainId=");
		sb.append(domainId);
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
		sb.append(", type=");
		sb.append(type);
		sb.append(", code=");
		sb.append(code);
		sb.append(", title=");
		sb.append(title);
		sb.append(", value=");
		sb.append(value);
		sb.append(", defaultValue=");
		sb.append(defaultValue);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public AppDomain toEntityModel() {
		AppDomainImpl appDomainImpl = new AppDomainImpl();

		appDomainImpl.setDomainId(domainId);
		appDomainImpl.setGroupId(groupId);
		appDomainImpl.setCompanyId(companyId);
		appDomainImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			appDomainImpl.setCreateDate(null);
		}
		else {
			appDomainImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appDomainImpl.setModifiedDate(null);
		}
		else {
			appDomainImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (type == null) {
			appDomainImpl.setType(StringPool.BLANK);
		}
		else {
			appDomainImpl.setType(type);
		}

		if (code == null) {
			appDomainImpl.setCode(StringPool.BLANK);
		}
		else {
			appDomainImpl.setCode(code);
		}

		if (title == null) {
			appDomainImpl.setTitle(StringPool.BLANK);
		}
		else {
			appDomainImpl.setTitle(title);
		}

		if (value == null) {
			appDomainImpl.setValue(StringPool.BLANK);
		}
		else {
			appDomainImpl.setValue(value);
		}

		appDomainImpl.setDefaultValue(defaultValue);

		if (description == null) {
			appDomainImpl.setDescription(StringPool.BLANK);
		}
		else {
			appDomainImpl.setDescription(description);
		}

		appDomainImpl.resetOriginalValues();

		return appDomainImpl;
	}

	public long domainId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String type;
	public String code;
	public String title;
	public String value;
	public boolean defaultValue;
	public String description;
}