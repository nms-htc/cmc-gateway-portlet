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

import com.cmc.gateway.domain.model.CommandAction;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CommandAction in entity cache.
 *
 * @author Richard Nguyen
 * @see CommandAction
 * @generated
 */
public class CommandActionCacheModel implements CacheModel<CommandAction>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

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
		sb.append(", commandId=");
		sb.append(commandId);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", actionType=");
		sb.append(actionType);
		sb.append(", subscriberType=");
		sb.append(subscriberType);
		sb.append(", actionName=");
		sb.append(actionName);
		sb.append(", nextActionType=");
		sb.append(nextActionType);
		sb.append(", nextCommandId=");
		sb.append(nextCommandId);
		sb.append(", processClass=");
		sb.append(processClass);
		sb.append(", processMethod=");
		sb.append(processMethod);
		sb.append(", properties=");
		sb.append(properties);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public CommandAction toEntityModel() {
		CommandActionImpl commandActionImpl = new CommandActionImpl();

		commandActionImpl.setActionId(actionId);
		commandActionImpl.setGroupId(groupId);
		commandActionImpl.setCompanyId(companyId);
		commandActionImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			commandActionImpl.setCreateDate(null);
		}
		else {
			commandActionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commandActionImpl.setModifiedDate(null);
		}
		else {
			commandActionImpl.setModifiedDate(new Date(modifiedDate));
		}

		commandActionImpl.setCommandId(commandId);
		commandActionImpl.setProductId(productId);

		if (actionType == null) {
			commandActionImpl.setActionType(StringPool.BLANK);
		}
		else {
			commandActionImpl.setActionType(actionType);
		}

		commandActionImpl.setSubscriberType(subscriberType);

		if (actionName == null) {
			commandActionImpl.setActionName(StringPool.BLANK);
		}
		else {
			commandActionImpl.setActionName(actionName);
		}

		if (nextActionType == null) {
			commandActionImpl.setNextActionType(StringPool.BLANK);
		}
		else {
			commandActionImpl.setNextActionType(nextActionType);
		}

		commandActionImpl.setNextCommandId(nextCommandId);

		if (processClass == null) {
			commandActionImpl.setProcessClass(StringPool.BLANK);
		}
		else {
			commandActionImpl.setProcessClass(processClass);
		}

		if (processMethod == null) {
			commandActionImpl.setProcessMethod(StringPool.BLANK);
		}
		else {
			commandActionImpl.setProcessMethod(processMethod);
		}

		if (properties == null) {
			commandActionImpl.setProperties(StringPool.BLANK);
		}
		else {
			commandActionImpl.setProperties(properties);
		}

		if (description == null) {
			commandActionImpl.setDescription(StringPool.BLANK);
		}
		else {
			commandActionImpl.setDescription(description);
		}

		commandActionImpl.resetOriginalValues();

		return commandActionImpl;
	}

	public long actionId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long commandId;
	public long productId;
	public String actionType;
	public int subscriberType;
	public String actionName;
	public String nextActionType;
	public long nextCommandId;
	public String processClass;
	public String processMethod;
	public String properties;
	public String description;
}