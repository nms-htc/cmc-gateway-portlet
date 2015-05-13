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

import com.cmc.gateway.domain.model.ProductRoute;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ProductRoute in entity cache.
 *
 * @author Richard Nguyen
 * @see ProductRoute
 * @generated
 */
public class ProductRouteCacheModel implements CacheModel<ProductRoute>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(89);

		sb.append("{routeId=");
		sb.append(routeId);
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
		sb.append(", channel=");
		sb.append(channel);
		sb.append(", serviceAddress=");
		sb.append(serviceAddress);
		sb.append(", keyword=");
		sb.append(keyword);
		sb.append(", openTime=");
		sb.append(openTime);
		sb.append(", closedTime=");
		sb.append(closedTime);
		sb.append(", checkBalance=");
		sb.append(checkBalance);
		sb.append(", smsMinParams=");
		sb.append(smsMinParams);
		sb.append(", smsMaxParams=");
		sb.append(smsMaxParams);
		sb.append(", actionType=");
		sb.append(actionType);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", synchronous=");
		sb.append(synchronous);
		sb.append(", createOrder=");
		sb.append(createOrder);
		sb.append(", timeout=");
		sb.append(timeout);
		sb.append(", maxRegisterDaily=");
		sb.append(maxRegisterDaily);
		sb.append(", duplicateScan=");
		sb.append(duplicateScan);
		sb.append(", checkSpam=");
		sb.append(checkSpam);
		sb.append(", fraudTimes=");
		sb.append(fraudTimes);
		sb.append(", fraudPeriod=");
		sb.append(fraudPeriod);
		sb.append(", fraudUnit=");
		sb.append(fraudUnit);
		sb.append(", rejectUnit=");
		sb.append(rejectUnit);
		sb.append(", rejectPeriod=");
		sb.append(rejectPeriod);
		sb.append(", baseChargeEnable=");
		sb.append(baseChargeEnable);
		sb.append(", chargingAmount=");
		sb.append(chargingAmount);
		sb.append(", notifyOwner=");
		sb.append(notifyOwner);
		sb.append(", notifyDeliver=");
		sb.append(notifyDeliver);
		sb.append(", sendAdvertising=");
		sb.append(sendAdvertising);
		sb.append(", checkPromotion=");
		sb.append(checkPromotion);
		sb.append(", topupEnable=");
		sb.append(topupEnable);
		sb.append(", properties=");
		sb.append(properties);
		sb.append(", queueName=");
		sb.append(queueName);
		sb.append(", processClass=");
		sb.append(processClass);
		sb.append(", processMethod=");
		sb.append(processMethod);
		sb.append(", status=");
		sb.append(status);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", expirationDate=");
		sb.append(expirationDate);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public ProductRoute toEntityModel() {
		ProductRouteImpl productRouteImpl = new ProductRouteImpl();

		productRouteImpl.setRouteId(routeId);
		productRouteImpl.setGroupId(groupId);
		productRouteImpl.setCompanyId(companyId);
		productRouteImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			productRouteImpl.setCreateDate(null);
		}
		else {
			productRouteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productRouteImpl.setModifiedDate(null);
		}
		else {
			productRouteImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (channel == null) {
			productRouteImpl.setChannel(StringPool.BLANK);
		}
		else {
			productRouteImpl.setChannel(channel);
		}

		if (serviceAddress == null) {
			productRouteImpl.setServiceAddress(StringPool.BLANK);
		}
		else {
			productRouteImpl.setServiceAddress(serviceAddress);
		}

		if (keyword == null) {
			productRouteImpl.setKeyword(StringPool.BLANK);
		}
		else {
			productRouteImpl.setKeyword(keyword);
		}

		if (openTime == null) {
			productRouteImpl.setOpenTime(StringPool.BLANK);
		}
		else {
			productRouteImpl.setOpenTime(openTime);
		}

		if (closedTime == null) {
			productRouteImpl.setClosedTime(StringPool.BLANK);
		}
		else {
			productRouteImpl.setClosedTime(closedTime);
		}

		productRouteImpl.setCheckBalance(checkBalance);
		productRouteImpl.setSmsMinParams(smsMinParams);
		productRouteImpl.setSmsMaxParams(smsMaxParams);

		if (actionType == null) {
			productRouteImpl.setActionType(StringPool.BLANK);
		}
		else {
			productRouteImpl.setActionType(actionType);
		}

		productRouteImpl.setProductId(productId);
		productRouteImpl.setCampaignId(campaignId);

		if (languageId == null) {
			productRouteImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			productRouteImpl.setLanguageId(languageId);
		}

		productRouteImpl.setSynchronous(synchronous);
		productRouteImpl.setCreateOrder(createOrder);
		productRouteImpl.setTimeout(timeout);
		productRouteImpl.setMaxRegisterDaily(maxRegisterDaily);
		productRouteImpl.setDuplicateScan(duplicateScan);
		productRouteImpl.setCheckSpam(checkSpam);
		productRouteImpl.setFraudTimes(fraudTimes);
		productRouteImpl.setFraudPeriod(fraudPeriod);

		if (fraudUnit == null) {
			productRouteImpl.setFraudUnit(StringPool.BLANK);
		}
		else {
			productRouteImpl.setFraudUnit(fraudUnit);
		}

		if (rejectUnit == null) {
			productRouteImpl.setRejectUnit(StringPool.BLANK);
		}
		else {
			productRouteImpl.setRejectUnit(rejectUnit);
		}

		productRouteImpl.setRejectPeriod(rejectPeriod);
		productRouteImpl.setBaseChargeEnable(baseChargeEnable);
		productRouteImpl.setChargingAmount(chargingAmount);
		productRouteImpl.setNotifyOwner(notifyOwner);
		productRouteImpl.setNotifyDeliver(notifyDeliver);
		productRouteImpl.setSendAdvertising(sendAdvertising);
		productRouteImpl.setCheckPromotion(checkPromotion);
		productRouteImpl.setTopupEnable(topupEnable);

		if (properties == null) {
			productRouteImpl.setProperties(StringPool.BLANK);
		}
		else {
			productRouteImpl.setProperties(properties);
		}

		if (queueName == null) {
			productRouteImpl.setQueueName(StringPool.BLANK);
		}
		else {
			productRouteImpl.setQueueName(queueName);
		}

		if (processClass == null) {
			productRouteImpl.setProcessClass(StringPool.BLANK);
		}
		else {
			productRouteImpl.setProcessClass(processClass);
		}

		if (processMethod == null) {
			productRouteImpl.setProcessMethod(StringPool.BLANK);
		}
		else {
			productRouteImpl.setProcessMethod(processMethod);
		}

		productRouteImpl.setStatus(status);

		if (startDate == Long.MIN_VALUE) {
			productRouteImpl.setStartDate(null);
		}
		else {
			productRouteImpl.setStartDate(new Date(startDate));
		}

		if (expirationDate == Long.MIN_VALUE) {
			productRouteImpl.setExpirationDate(null);
		}
		else {
			productRouteImpl.setExpirationDate(new Date(expirationDate));
		}

		if (description == null) {
			productRouteImpl.setDescription(StringPool.BLANK);
		}
		else {
			productRouteImpl.setDescription(description);
		}

		productRouteImpl.resetOriginalValues();

		return productRouteImpl;
	}

	public long routeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String channel;
	public String serviceAddress;
	public String keyword;
	public String openTime;
	public String closedTime;
	public boolean checkBalance;
	public int smsMinParams;
	public int smsMaxParams;
	public String actionType;
	public long productId;
	public long campaignId;
	public String languageId;
	public boolean synchronous;
	public boolean createOrder;
	public int timeout;
	public int maxRegisterDaily;
	public int duplicateScan;
	public boolean checkSpam;
	public int fraudTimes;
	public int fraudPeriod;
	public String fraudUnit;
	public String rejectUnit;
	public int rejectPeriod;
	public boolean baseChargeEnable;
	public double chargingAmount;
	public boolean notifyOwner;
	public boolean notifyDeliver;
	public boolean sendAdvertising;
	public boolean checkPromotion;
	public boolean topupEnable;
	public String properties;
	public String queueName;
	public String processClass;
	public String processMethod;
	public int status;
	public long startDate;
	public long expirationDate;
	public String description;
}