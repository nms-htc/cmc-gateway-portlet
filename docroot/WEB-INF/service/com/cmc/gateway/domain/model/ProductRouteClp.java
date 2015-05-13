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

package com.cmc.gateway.domain.model;

import com.cmc.gateway.domain.service.ProductRouteLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard Nguyen
 */
public class ProductRouteClp extends BaseModelImpl<ProductRoute>
	implements ProductRoute {
	public ProductRouteClp() {
	}

	public Class<?> getModelClass() {
		return ProductRoute.class;
	}

	public String getModelClassName() {
		return ProductRoute.class.getName();
	}

	public long getPrimaryKey() {
		return _routeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setRouteId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_routeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("routeId", getRouteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("channel", getChannel());
		attributes.put("serviceAddress", getServiceAddress());
		attributes.put("keyword", getKeyword());
		attributes.put("openTime", getOpenTime());
		attributes.put("closedTime", getClosedTime());
		attributes.put("checkBalance", getCheckBalance());
		attributes.put("smsMinParams", getSmsMinParams());
		attributes.put("smsMaxParams", getSmsMaxParams());
		attributes.put("actionType", getActionType());
		attributes.put("productId", getProductId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("languageId", getLanguageId());
		attributes.put("synchronous", getSynchronous());
		attributes.put("createOrder", getCreateOrder());
		attributes.put("timeout", getTimeout());
		attributes.put("maxRegisterDaily", getMaxRegisterDaily());
		attributes.put("duplicateScan", getDuplicateScan());
		attributes.put("checkSpam", getCheckSpam());
		attributes.put("fraudTimes", getFraudTimes());
		attributes.put("fraudPeriod", getFraudPeriod());
		attributes.put("fraudUnit", getFraudUnit());
		attributes.put("rejectUnit", getRejectUnit());
		attributes.put("rejectPeriod", getRejectPeriod());
		attributes.put("baseChargeEnable", getBaseChargeEnable());
		attributes.put("chargingAmount", getChargingAmount());
		attributes.put("notifyOwner", getNotifyOwner());
		attributes.put("notifyDeliver", getNotifyDeliver());
		attributes.put("sendAdvertising", getSendAdvertising());
		attributes.put("checkPromotion", getCheckPromotion());
		attributes.put("topupEnable", getTopupEnable());
		attributes.put("properties", getProperties());
		attributes.put("queueName", getQueueName());
		attributes.put("processClass", getProcessClass());
		attributes.put("processMethod", getProcessMethod());
		attributes.put("status", getStatus());
		attributes.put("startDate", getStartDate());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long routeId = (Long)attributes.get("routeId");

		if (routeId != null) {
			setRouteId(routeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String channel = (String)attributes.get("channel");

		if (channel != null) {
			setChannel(channel);
		}

		String serviceAddress = (String)attributes.get("serviceAddress");

		if (serviceAddress != null) {
			setServiceAddress(serviceAddress);
		}

		String keyword = (String)attributes.get("keyword");

		if (keyword != null) {
			setKeyword(keyword);
		}

		String openTime = (String)attributes.get("openTime");

		if (openTime != null) {
			setOpenTime(openTime);
		}

		String closedTime = (String)attributes.get("closedTime");

		if (closedTime != null) {
			setClosedTime(closedTime);
		}

		Boolean checkBalance = (Boolean)attributes.get("checkBalance");

		if (checkBalance != null) {
			setCheckBalance(checkBalance);
		}

		Integer smsMinParams = (Integer)attributes.get("smsMinParams");

		if (smsMinParams != null) {
			setSmsMinParams(smsMinParams);
		}

		Integer smsMaxParams = (Integer)attributes.get("smsMaxParams");

		if (smsMaxParams != null) {
			setSmsMaxParams(smsMaxParams);
		}

		String actionType = (String)attributes.get("actionType");

		if (actionType != null) {
			setActionType(actionType);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		Boolean synchronous = (Boolean)attributes.get("synchronous");

		if (synchronous != null) {
			setSynchronous(synchronous);
		}

		Boolean createOrder = (Boolean)attributes.get("createOrder");

		if (createOrder != null) {
			setCreateOrder(createOrder);
		}

		Integer timeout = (Integer)attributes.get("timeout");

		if (timeout != null) {
			setTimeout(timeout);
		}

		Integer maxRegisterDaily = (Integer)attributes.get("maxRegisterDaily");

		if (maxRegisterDaily != null) {
			setMaxRegisterDaily(maxRegisterDaily);
		}

		Integer duplicateScan = (Integer)attributes.get("duplicateScan");

		if (duplicateScan != null) {
			setDuplicateScan(duplicateScan);
		}

		Boolean checkSpam = (Boolean)attributes.get("checkSpam");

		if (checkSpam != null) {
			setCheckSpam(checkSpam);
		}

		Integer fraudTimes = (Integer)attributes.get("fraudTimes");

		if (fraudTimes != null) {
			setFraudTimes(fraudTimes);
		}

		Integer fraudPeriod = (Integer)attributes.get("fraudPeriod");

		if (fraudPeriod != null) {
			setFraudPeriod(fraudPeriod);
		}

		String fraudUnit = (String)attributes.get("fraudUnit");

		if (fraudUnit != null) {
			setFraudUnit(fraudUnit);
		}

		String rejectUnit = (String)attributes.get("rejectUnit");

		if (rejectUnit != null) {
			setRejectUnit(rejectUnit);
		}

		Integer rejectPeriod = (Integer)attributes.get("rejectPeriod");

		if (rejectPeriod != null) {
			setRejectPeriod(rejectPeriod);
		}

		Boolean baseChargeEnable = (Boolean)attributes.get("baseChargeEnable");

		if (baseChargeEnable != null) {
			setBaseChargeEnable(baseChargeEnable);
		}

		Double chargingAmount = (Double)attributes.get("chargingAmount");

		if (chargingAmount != null) {
			setChargingAmount(chargingAmount);
		}

		Boolean notifyOwner = (Boolean)attributes.get("notifyOwner");

		if (notifyOwner != null) {
			setNotifyOwner(notifyOwner);
		}

		Boolean notifyDeliver = (Boolean)attributes.get("notifyDeliver");

		if (notifyDeliver != null) {
			setNotifyDeliver(notifyDeliver);
		}

		Boolean sendAdvertising = (Boolean)attributes.get("sendAdvertising");

		if (sendAdvertising != null) {
			setSendAdvertising(sendAdvertising);
		}

		Boolean checkPromotion = (Boolean)attributes.get("checkPromotion");

		if (checkPromotion != null) {
			setCheckPromotion(checkPromotion);
		}

		Boolean topupEnable = (Boolean)attributes.get("topupEnable");

		if (topupEnable != null) {
			setTopupEnable(topupEnable);
		}

		String properties = (String)attributes.get("properties");

		if (properties != null) {
			setProperties(properties);
		}

		String queueName = (String)attributes.get("queueName");

		if (queueName != null) {
			setQueueName(queueName);
		}

		String processClass = (String)attributes.get("processClass");

		if (processClass != null) {
			setProcessClass(processClass);
		}

		String processMethod = (String)attributes.get("processMethod");

		if (processMethod != null) {
			setProcessMethod(processMethod);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	public long getRouteId() {
		return _routeId;
	}

	public void setRouteId(long routeId) {
		_routeId = routeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getChannel() {
		return _channel;
	}

	public void setChannel(String channel) {
		_channel = channel;
	}

	public String getServiceAddress() {
		return _serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		_serviceAddress = serviceAddress;
	}

	public String getKeyword() {
		return _keyword;
	}

	public void setKeyword(String keyword) {
		_keyword = keyword;
	}

	public String getOpenTime() {
		return _openTime;
	}

	public void setOpenTime(String openTime) {
		_openTime = openTime;
	}

	public String getClosedTime() {
		return _closedTime;
	}

	public void setClosedTime(String closedTime) {
		_closedTime = closedTime;
	}

	public boolean getCheckBalance() {
		return _checkBalance;
	}

	public boolean isCheckBalance() {
		return _checkBalance;
	}

	public void setCheckBalance(boolean checkBalance) {
		_checkBalance = checkBalance;
	}

	public int getSmsMinParams() {
		return _smsMinParams;
	}

	public void setSmsMinParams(int smsMinParams) {
		_smsMinParams = smsMinParams;
	}

	public int getSmsMaxParams() {
		return _smsMaxParams;
	}

	public void setSmsMaxParams(int smsMaxParams) {
		_smsMaxParams = smsMaxParams;
	}

	public String getActionType() {
		return _actionType;
	}

	public void setActionType(String actionType) {
		_actionType = actionType;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public boolean getSynchronous() {
		return _synchronous;
	}

	public boolean isSynchronous() {
		return _synchronous;
	}

	public void setSynchronous(boolean synchronous) {
		_synchronous = synchronous;
	}

	public boolean getCreateOrder() {
		return _createOrder;
	}

	public boolean isCreateOrder() {
		return _createOrder;
	}

	public void setCreateOrder(boolean createOrder) {
		_createOrder = createOrder;
	}

	public int getTimeout() {
		return _timeout;
	}

	public void setTimeout(int timeout) {
		_timeout = timeout;
	}

	public int getMaxRegisterDaily() {
		return _maxRegisterDaily;
	}

	public void setMaxRegisterDaily(int maxRegisterDaily) {
		_maxRegisterDaily = maxRegisterDaily;
	}

	public int getDuplicateScan() {
		return _duplicateScan;
	}

	public void setDuplicateScan(int duplicateScan) {
		_duplicateScan = duplicateScan;
	}

	public boolean getCheckSpam() {
		return _checkSpam;
	}

	public boolean isCheckSpam() {
		return _checkSpam;
	}

	public void setCheckSpam(boolean checkSpam) {
		_checkSpam = checkSpam;
	}

	public int getFraudTimes() {
		return _fraudTimes;
	}

	public void setFraudTimes(int fraudTimes) {
		_fraudTimes = fraudTimes;
	}

	public int getFraudPeriod() {
		return _fraudPeriod;
	}

	public void setFraudPeriod(int fraudPeriod) {
		_fraudPeriod = fraudPeriod;
	}

	public String getFraudUnit() {
		return _fraudUnit;
	}

	public void setFraudUnit(String fraudUnit) {
		_fraudUnit = fraudUnit;
	}

	public String getRejectUnit() {
		return _rejectUnit;
	}

	public void setRejectUnit(String rejectUnit) {
		_rejectUnit = rejectUnit;
	}

	public int getRejectPeriod() {
		return _rejectPeriod;
	}

	public void setRejectPeriod(int rejectPeriod) {
		_rejectPeriod = rejectPeriod;
	}

	public boolean getBaseChargeEnable() {
		return _baseChargeEnable;
	}

	public boolean isBaseChargeEnable() {
		return _baseChargeEnable;
	}

	public void setBaseChargeEnable(boolean baseChargeEnable) {
		_baseChargeEnable = baseChargeEnable;
	}

	public double getChargingAmount() {
		return _chargingAmount;
	}

	public void setChargingAmount(double chargingAmount) {
		_chargingAmount = chargingAmount;
	}

	public boolean getNotifyOwner() {
		return _notifyOwner;
	}

	public boolean isNotifyOwner() {
		return _notifyOwner;
	}

	public void setNotifyOwner(boolean notifyOwner) {
		_notifyOwner = notifyOwner;
	}

	public boolean getNotifyDeliver() {
		return _notifyDeliver;
	}

	public boolean isNotifyDeliver() {
		return _notifyDeliver;
	}

	public void setNotifyDeliver(boolean notifyDeliver) {
		_notifyDeliver = notifyDeliver;
	}

	public boolean getSendAdvertising() {
		return _sendAdvertising;
	}

	public boolean isSendAdvertising() {
		return _sendAdvertising;
	}

	public void setSendAdvertising(boolean sendAdvertising) {
		_sendAdvertising = sendAdvertising;
	}

	public boolean getCheckPromotion() {
		return _checkPromotion;
	}

	public boolean isCheckPromotion() {
		return _checkPromotion;
	}

	public void setCheckPromotion(boolean checkPromotion) {
		_checkPromotion = checkPromotion;
	}

	public boolean getTopupEnable() {
		return _topupEnable;
	}

	public boolean isTopupEnable() {
		return _topupEnable;
	}

	public void setTopupEnable(boolean topupEnable) {
		_topupEnable = topupEnable;
	}

	public String getProperties() {
		return _properties;
	}

	public void setProperties(String properties) {
		_properties = properties;
	}

	public String getQueueName() {
		return _queueName;
	}

	public void setQueueName(String queueName) {
		_queueName = queueName;
	}

	public String getProcessClass() {
		return _processClass;
	}

	public void setProcessClass(String processClass) {
		_processClass = processClass;
	}

	public String getProcessMethod() {
		return _processMethod;
	}

	public void setProcessMethod(String processMethod) {
		_processMethod = processMethod;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public BaseModel<?> getProductRouteRemoteModel() {
		return _productRouteRemoteModel;
	}

	public void setProductRouteRemoteModel(BaseModel<?> productRouteRemoteModel) {
		_productRouteRemoteModel = productRouteRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ProductRouteLocalServiceUtil.addProductRoute(this);
		}
		else {
			ProductRouteLocalServiceUtil.updateProductRoute(this);
		}
	}

	@Override
	public ProductRoute toEscapedModel() {
		return (ProductRoute)Proxy.newProxyInstance(ProductRoute.class.getClassLoader(),
			new Class[] { ProductRoute.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProductRouteClp clone = new ProductRouteClp();

		clone.setRouteId(getRouteId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setChannel(getChannel());
		clone.setServiceAddress(getServiceAddress());
		clone.setKeyword(getKeyword());
		clone.setOpenTime(getOpenTime());
		clone.setClosedTime(getClosedTime());
		clone.setCheckBalance(getCheckBalance());
		clone.setSmsMinParams(getSmsMinParams());
		clone.setSmsMaxParams(getSmsMaxParams());
		clone.setActionType(getActionType());
		clone.setProductId(getProductId());
		clone.setCampaignId(getCampaignId());
		clone.setLanguageId(getLanguageId());
		clone.setSynchronous(getSynchronous());
		clone.setCreateOrder(getCreateOrder());
		clone.setTimeout(getTimeout());
		clone.setMaxRegisterDaily(getMaxRegisterDaily());
		clone.setDuplicateScan(getDuplicateScan());
		clone.setCheckSpam(getCheckSpam());
		clone.setFraudTimes(getFraudTimes());
		clone.setFraudPeriod(getFraudPeriod());
		clone.setFraudUnit(getFraudUnit());
		clone.setRejectUnit(getRejectUnit());
		clone.setRejectPeriod(getRejectPeriod());
		clone.setBaseChargeEnable(getBaseChargeEnable());
		clone.setChargingAmount(getChargingAmount());
		clone.setNotifyOwner(getNotifyOwner());
		clone.setNotifyDeliver(getNotifyDeliver());
		clone.setSendAdvertising(getSendAdvertising());
		clone.setCheckPromotion(getCheckPromotion());
		clone.setTopupEnable(getTopupEnable());
		clone.setProperties(getProperties());
		clone.setQueueName(getQueueName());
		clone.setProcessClass(getProcessClass());
		clone.setProcessMethod(getProcessMethod());
		clone.setStatus(getStatus());
		clone.setStartDate(getStartDate());
		clone.setExpirationDate(getExpirationDate());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ProductRoute productRoute) {
		int value = 0;

		value = getChannel().compareTo(productRoute.getChannel());

		if (value != 0) {
			return value;
		}

		value = getServiceAddress().compareTo(productRoute.getServiceAddress());

		if (value != 0) {
			return value;
		}

		value = getKeyword().compareTo(productRoute.getKeyword());

		if (value != 0) {
			return value;
		}

		value = getOpenTime().compareTo(productRoute.getOpenTime());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProductRouteClp productRoute = null;

		try {
			productRoute = (ProductRouteClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = productRoute.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(89);

		sb.append("{routeId=");
		sb.append(getRouteId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", channel=");
		sb.append(getChannel());
		sb.append(", serviceAddress=");
		sb.append(getServiceAddress());
		sb.append(", keyword=");
		sb.append(getKeyword());
		sb.append(", openTime=");
		sb.append(getOpenTime());
		sb.append(", closedTime=");
		sb.append(getClosedTime());
		sb.append(", checkBalance=");
		sb.append(getCheckBalance());
		sb.append(", smsMinParams=");
		sb.append(getSmsMinParams());
		sb.append(", smsMaxParams=");
		sb.append(getSmsMaxParams());
		sb.append(", actionType=");
		sb.append(getActionType());
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", synchronous=");
		sb.append(getSynchronous());
		sb.append(", createOrder=");
		sb.append(getCreateOrder());
		sb.append(", timeout=");
		sb.append(getTimeout());
		sb.append(", maxRegisterDaily=");
		sb.append(getMaxRegisterDaily());
		sb.append(", duplicateScan=");
		sb.append(getDuplicateScan());
		sb.append(", checkSpam=");
		sb.append(getCheckSpam());
		sb.append(", fraudTimes=");
		sb.append(getFraudTimes());
		sb.append(", fraudPeriod=");
		sb.append(getFraudPeriod());
		sb.append(", fraudUnit=");
		sb.append(getFraudUnit());
		sb.append(", rejectUnit=");
		sb.append(getRejectUnit());
		sb.append(", rejectPeriod=");
		sb.append(getRejectPeriod());
		sb.append(", baseChargeEnable=");
		sb.append(getBaseChargeEnable());
		sb.append(", chargingAmount=");
		sb.append(getChargingAmount());
		sb.append(", notifyOwner=");
		sb.append(getNotifyOwner());
		sb.append(", notifyDeliver=");
		sb.append(getNotifyDeliver());
		sb.append(", sendAdvertising=");
		sb.append(getSendAdvertising());
		sb.append(", checkPromotion=");
		sb.append(getCheckPromotion());
		sb.append(", topupEnable=");
		sb.append(getTopupEnable());
		sb.append(", properties=");
		sb.append(getProperties());
		sb.append(", queueName=");
		sb.append(getQueueName());
		sb.append(", processClass=");
		sb.append(getProcessClass());
		sb.append(", processMethod=");
		sb.append(getProcessMethod());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", expirationDate=");
		sb.append(getExpirationDate());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(136);

		sb.append("<model><model-name>");
		sb.append("com.cmc.gateway.domain.model.ProductRoute");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>routeId</column-name><column-value><![CDATA[");
		sb.append(getRouteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>channel</column-name><column-value><![CDATA[");
		sb.append(getChannel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceAddress</column-name><column-value><![CDATA[");
		sb.append(getServiceAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>keyword</column-name><column-value><![CDATA[");
		sb.append(getKeyword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openTime</column-name><column-value><![CDATA[");
		sb.append(getOpenTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>closedTime</column-name><column-value><![CDATA[");
		sb.append(getClosedTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkBalance</column-name><column-value><![CDATA[");
		sb.append(getCheckBalance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smsMinParams</column-name><column-value><![CDATA[");
		sb.append(getSmsMinParams());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smsMaxParams</column-name><column-value><![CDATA[");
		sb.append(getSmsMaxParams());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionType</column-name><column-value><![CDATA[");
		sb.append(getActionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>synchronous</column-name><column-value><![CDATA[");
		sb.append(getSynchronous());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createOrder</column-name><column-value><![CDATA[");
		sb.append(getCreateOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeout</column-name><column-value><![CDATA[");
		sb.append(getTimeout());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxRegisterDaily</column-name><column-value><![CDATA[");
		sb.append(getMaxRegisterDaily());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duplicateScan</column-name><column-value><![CDATA[");
		sb.append(getDuplicateScan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkSpam</column-name><column-value><![CDATA[");
		sb.append(getCheckSpam());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fraudTimes</column-name><column-value><![CDATA[");
		sb.append(getFraudTimes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fraudPeriod</column-name><column-value><![CDATA[");
		sb.append(getFraudPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fraudUnit</column-name><column-value><![CDATA[");
		sb.append(getFraudUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rejectUnit</column-name><column-value><![CDATA[");
		sb.append(getRejectUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rejectPeriod</column-name><column-value><![CDATA[");
		sb.append(getRejectPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>baseChargeEnable</column-name><column-value><![CDATA[");
		sb.append(getBaseChargeEnable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chargingAmount</column-name><column-value><![CDATA[");
		sb.append(getChargingAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notifyOwner</column-name><column-value><![CDATA[");
		sb.append(getNotifyOwner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notifyDeliver</column-name><column-value><![CDATA[");
		sb.append(getNotifyDeliver());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendAdvertising</column-name><column-value><![CDATA[");
		sb.append(getSendAdvertising());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkPromotion</column-name><column-value><![CDATA[");
		sb.append(getCheckPromotion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>topupEnable</column-name><column-value><![CDATA[");
		sb.append(getTopupEnable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>properties</column-name><column-value><![CDATA[");
		sb.append(getProperties());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>queueName</column-name><column-value><![CDATA[");
		sb.append(getQueueName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processClass</column-name><column-value><![CDATA[");
		sb.append(getProcessClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processMethod</column-name><column-value><![CDATA[");
		sb.append(getProcessMethod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expirationDate</column-name><column-value><![CDATA[");
		sb.append(getExpirationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _routeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _channel;
	private String _serviceAddress;
	private String _keyword;
	private String _openTime;
	private String _closedTime;
	private boolean _checkBalance;
	private int _smsMinParams;
	private int _smsMaxParams;
	private String _actionType;
	private long _productId;
	private long _campaignId;
	private String _languageId;
	private boolean _synchronous;
	private boolean _createOrder;
	private int _timeout;
	private int _maxRegisterDaily;
	private int _duplicateScan;
	private boolean _checkSpam;
	private int _fraudTimes;
	private int _fraudPeriod;
	private String _fraudUnit;
	private String _rejectUnit;
	private int _rejectPeriod;
	private boolean _baseChargeEnable;
	private double _chargingAmount;
	private boolean _notifyOwner;
	private boolean _notifyDeliver;
	private boolean _sendAdvertising;
	private boolean _checkPromotion;
	private boolean _topupEnable;
	private String _properties;
	private String _queueName;
	private String _processClass;
	private String _processMethod;
	private int _status;
	private Date _startDate;
	private Date _expirationDate;
	private String _description;
	private BaseModel<?> _productRouteRemoteModel;
}