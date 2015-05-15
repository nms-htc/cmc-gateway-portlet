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

import com.cmc.gateway.domain.model.ProductMessage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ProductMessage in entity cache.
 *
 * @author Richard Nguyen
 * @see ProductMessage
 * @generated
 */
public class ProductMessageCacheModel implements CacheModel<ProductMessage>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

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
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", actionType=");
		sb.append(actionType);
		sb.append(", channel=");
		sb.append(channel);
		sb.append(", cause=");
		sb.append(cause);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", causeValue=");
		sb.append(causeValue);
		sb.append(", content=");
		sb.append(content);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public ProductMessage toEntityModel() {
		ProductMessageImpl productMessageImpl = new ProductMessageImpl();

		productMessageImpl.setMessageId(messageId);
		productMessageImpl.setGroupId(groupId);
		productMessageImpl.setCompanyId(companyId);
		productMessageImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			productMessageImpl.setCreateDate(null);
		}
		else {
			productMessageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productMessageImpl.setModifiedDate(null);
		}
		else {
			productMessageImpl.setModifiedDate(new Date(modifiedDate));
		}

		productMessageImpl.setProductId(productId);

		if (actionType == null) {
			productMessageImpl.setActionType(StringPool.BLANK);
		}
		else {
			productMessageImpl.setActionType(actionType);
		}

		if (channel == null) {
			productMessageImpl.setChannel(StringPool.BLANK);
		}
		else {
			productMessageImpl.setChannel(channel);
		}

		if (cause == null) {
			productMessageImpl.setCause(StringPool.BLANK);
		}
		else {
			productMessageImpl.setCause(cause);
		}

		if (languageId == null) {
			productMessageImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			productMessageImpl.setLanguageId(languageId);
		}

		productMessageImpl.setCauseValue(causeValue);

		if (content == null) {
			productMessageImpl.setContent(StringPool.BLANK);
		}
		else {
			productMessageImpl.setContent(content);
		}

		if (description == null) {
			productMessageImpl.setDescription(StringPool.BLANK);
		}
		else {
			productMessageImpl.setDescription(description);
		}

		productMessageImpl.resetOriginalValues();

		return productMessageImpl;
	}

	public long messageId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long productId;
	public String actionType;
	public String channel;
	public String cause;
	public String languageId;
	public int causeValue;
	public String content;
	public String description;
}