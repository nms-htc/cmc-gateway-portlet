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

import com.cmc.gateway.domain.model.CommandEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CommandEntry in entity cache.
 *
 * @author Richard Nguyen
 * @see CommandEntry
 * @generated
 */
public class CommandEntryCacheModel implements CacheModel<CommandEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{commandId=");
		sb.append(commandId);
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
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", timeout=");
		sb.append(timeout);
		sb.append(", retryEnable=");
		sb.append(retryEnable);
		sb.append(", maxRetry=");
		sb.append(maxRetry);
		sb.append(", logEnable=");
		sb.append(logEnable);
		sb.append(", properties=");
		sb.append(properties);
		sb.append(", status=");
		sb.append(status);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public CommandEntry toEntityModel() {
		CommandEntryImpl commandEntryImpl = new CommandEntryImpl();

		commandEntryImpl.setCommandId(commandId);
		commandEntryImpl.setGroupId(groupId);
		commandEntryImpl.setCompanyId(companyId);
		commandEntryImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			commandEntryImpl.setCreateDate(null);
		}
		else {
			commandEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commandEntryImpl.setModifiedDate(null);
		}
		else {
			commandEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (provisioningType == null) {
			commandEntryImpl.setProvisioningType(StringPool.BLANK);
		}
		else {
			commandEntryImpl.setProvisioningType(provisioningType);
		}

		if (code == null) {
			commandEntryImpl.setCode(StringPool.BLANK);
		}
		else {
			commandEntryImpl.setCode(code);
		}

		if (title == null) {
			commandEntryImpl.setTitle(StringPool.BLANK);
		}
		else {
			commandEntryImpl.setTitle(title);
		}

		commandEntryImpl.setPriority(priority);
		commandEntryImpl.setTimeout(timeout);
		commandEntryImpl.setRetryEnable(retryEnable);
		commandEntryImpl.setMaxRetry(maxRetry);
		commandEntryImpl.setLogEnable(logEnable);

		if (properties == null) {
			commandEntryImpl.setProperties(StringPool.BLANK);
		}
		else {
			commandEntryImpl.setProperties(properties);
		}

		commandEntryImpl.setStatus(status);

		if (description == null) {
			commandEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			commandEntryImpl.setDescription(description);
		}

		commandEntryImpl.resetOriginalValues();

		return commandEntryImpl;
	}

	public long commandId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String provisioningType;
	public String code;
	public String title;
	public int priority;
	public int timeout;
	public boolean retryEnable;
	public int maxRetry;
	public boolean logEnable;
	public String properties;
	public int status;
	public String description;
}