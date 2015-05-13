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

import com.cmc.gateway.domain.model.ProvisioningMessage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ProvisioningMessage in entity cache.
 *
 * @author Richard Nguyen
 * @see ProvisioningMessage
 * @generated
 */
public class ProvisioningMessageCacheModel implements CacheModel<ProvisioningMessage>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{messageId=");
		sb.append(messageId);
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
		sb.append(", responseCode=");
		sb.append(responseCode);
		sb.append(", cause=");
		sb.append(cause);
		sb.append(", causeValue=");
		sb.append(causeValue);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public ProvisioningMessage toEntityModel() {
		ProvisioningMessageImpl provisioningMessageImpl = new ProvisioningMessageImpl();

		provisioningMessageImpl.setMessageId(messageId);
		provisioningMessageImpl.setGroupId(groupId);
		provisioningMessageImpl.setCompanyId(companyId);
		provisioningMessageImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			provisioningMessageImpl.setCreateDate(null);
		}
		else {
			provisioningMessageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			provisioningMessageImpl.setModifiedDate(null);
		}
		else {
			provisioningMessageImpl.setModifiedDate(new Date(modifiedDate));
		}

		provisioningMessageImpl.setProvisioningId(provisioningId);

		if (responseCode == null) {
			provisioningMessageImpl.setResponseCode(StringPool.BLANK);
		}
		else {
			provisioningMessageImpl.setResponseCode(responseCode);
		}

		if (cause == null) {
			provisioningMessageImpl.setCause(StringPool.BLANK);
		}
		else {
			provisioningMessageImpl.setCause(cause);
		}

		provisioningMessageImpl.setCauseValue(causeValue);

		if (description == null) {
			provisioningMessageImpl.setDescription(StringPool.BLANK);
		}
		else {
			provisioningMessageImpl.setDescription(description);
		}

		provisioningMessageImpl.resetOriginalValues();

		return provisioningMessageImpl;
	}

	public long messageId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long provisioningId;
	public String responseCode;
	public String cause;
	public int causeValue;
	public String description;
}