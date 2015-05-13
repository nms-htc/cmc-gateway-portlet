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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ProvisioningEntry in entity cache.
 *
 * @author Richard Nguyen
 * @see ProvisioningEntry
 * @generated
 */
public class ProvisioningEntryCacheModel implements CacheModel<ProvisioningEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{provisioningId=");
		sb.append(provisioningId);
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
		sb.append(", provisioningType=");
		sb.append(provisioningType);
		sb.append(", code=");
		sb.append(code);
		sb.append(", title=");
		sb.append(title);
		sb.append(", connectionHost=");
		sb.append(connectionHost);
		sb.append(", connectionPort=");
		sb.append(connectionPort);
		sb.append(", connectByUserName=");
		sb.append(connectByUserName);
		sb.append(", connectByPassword=");
		sb.append(connectByPassword);
		sb.append(", processClass=");
		sb.append(processClass);
		sb.append(", processMethod=");
		sb.append(processMethod);
		sb.append(", properties=");
		sb.append(properties);
		sb.append(", status=");
		sb.append(status);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public ProvisioningEntry toEntityModel() {
		ProvisioningEntryImpl provisioningEntryImpl = new ProvisioningEntryImpl();

		provisioningEntryImpl.setProvisioningId(provisioningId);
		provisioningEntryImpl.setGroupId(groupId);
		provisioningEntryImpl.setCompanyId(companyId);
		provisioningEntryImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			provisioningEntryImpl.setCreateDate(null);
		}
		else {
			provisioningEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			provisioningEntryImpl.setModifiedDate(null);
		}
		else {
			provisioningEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (provisioningType == null) {
			provisioningEntryImpl.setProvisioningType(StringPool.BLANK);
		}
		else {
			provisioningEntryImpl.setProvisioningType(provisioningType);
		}

		if (code == null) {
			provisioningEntryImpl.setCode(StringPool.BLANK);
		}
		else {
			provisioningEntryImpl.setCode(code);
		}

		if (title == null) {
			provisioningEntryImpl.setTitle(StringPool.BLANK);
		}
		else {
			provisioningEntryImpl.setTitle(title);
		}

		if (connectionHost == null) {
			provisioningEntryImpl.setConnectionHost(StringPool.BLANK);
		}
		else {
			provisioningEntryImpl.setConnectionHost(connectionHost);
		}

		provisioningEntryImpl.setConnectionPort(connectionPort);

		if (connectByUserName == null) {
			provisioningEntryImpl.setConnectByUserName(StringPool.BLANK);
		}
		else {
			provisioningEntryImpl.setConnectByUserName(connectByUserName);
		}

		if (connectByPassword == null) {
			provisioningEntryImpl.setConnectByPassword(StringPool.BLANK);
		}
		else {
			provisioningEntryImpl.setConnectByPassword(connectByPassword);
		}

		if (processClass == null) {
			provisioningEntryImpl.setProcessClass(StringPool.BLANK);
		}
		else {
			provisioningEntryImpl.setProcessClass(processClass);
		}

		if (processMethod == null) {
			provisioningEntryImpl.setProcessMethod(StringPool.BLANK);
		}
		else {
			provisioningEntryImpl.setProcessMethod(processMethod);
		}

		if (properties == null) {
			provisioningEntryImpl.setProperties(StringPool.BLANK);
		}
		else {
			provisioningEntryImpl.setProperties(properties);
		}

		provisioningEntryImpl.setStatus(status);

		if (description == null) {
			provisioningEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			provisioningEntryImpl.setDescription(description);
		}

		provisioningEntryImpl.resetOriginalValues();

		return provisioningEntryImpl;
	}

	public long provisioningId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String provisioningType;
	public String code;
	public String title;
	public String connectionHost;
	public int connectionPort;
	public String connectByUserName;
	public String connectByPassword;
	public String processClass;
	public String processMethod;
	public String properties;
	public int status;
	public String description;
}