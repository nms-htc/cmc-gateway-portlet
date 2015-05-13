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

import com.cmc.gateway.domain.model.ProvisioningAction;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ProvisioningAction in entity cache.
 *
 * @author Richard Nguyen
 * @see ProvisioningAction
 * @generated
 */
public class ProvisioningActionCacheModel implements CacheModel<ProvisioningAction>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

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
		sb.append(", provisioningId=");
		sb.append(provisioningId);
		sb.append(", commandId=");
		sb.append(commandId);
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

	public ProvisioningAction toEntityModel() {
		ProvisioningActionImpl provisioningActionImpl = new ProvisioningActionImpl();

		provisioningActionImpl.setActionId(actionId);
		provisioningActionImpl.setGroupId(groupId);
		provisioningActionImpl.setCompanyId(companyId);
		provisioningActionImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			provisioningActionImpl.setCreateDate(null);
		}
		else {
			provisioningActionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			provisioningActionImpl.setModifiedDate(null);
		}
		else {
			provisioningActionImpl.setModifiedDate(new Date(modifiedDate));
		}

		provisioningActionImpl.setProvisioningId(provisioningId);
		provisioningActionImpl.setCommandId(commandId);
		provisioningActionImpl.setPriority(priority);
		provisioningActionImpl.setTimeout(timeout);
		provisioningActionImpl.setRetryEnable(retryEnable);
		provisioningActionImpl.setMaxRetry(maxRetry);
		provisioningActionImpl.setLogEnable(logEnable);

		if (processClass == null) {
			provisioningActionImpl.setProcessClass(StringPool.BLANK);
		}
		else {
			provisioningActionImpl.setProcessClass(processClass);
		}

		if (processMethod == null) {
			provisioningActionImpl.setProcessMethod(StringPool.BLANK);
		}
		else {
			provisioningActionImpl.setProcessMethod(processMethod);
		}

		if (properties == null) {
			provisioningActionImpl.setProperties(StringPool.BLANK);
		}
		else {
			provisioningActionImpl.setProperties(properties);
		}

		provisioningActionImpl.setStatus(status);

		if (description == null) {
			provisioningActionImpl.setDescription(StringPool.BLANK);
		}
		else {
			provisioningActionImpl.setDescription(description);
		}

		provisioningActionImpl.resetOriginalValues();

		return provisioningActionImpl;
	}

	public long actionId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long provisioningId;
	public long commandId;
	public int priority;
	public int timeout;
	public boolean retryEnable;
	public int maxRetry;
	public boolean logEnable;
	public String processClass;
	public String processMethod;
	public String properties;
	public int status;
	public String description;
}