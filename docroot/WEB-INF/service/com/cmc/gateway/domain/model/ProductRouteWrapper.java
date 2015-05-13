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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductRoute}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProductRoute
 * @generated
 */
public class ProductRouteWrapper implements ProductRoute,
	ModelWrapper<ProductRoute> {
	public ProductRouteWrapper(ProductRoute productRoute) {
		_productRoute = productRoute;
	}

	public Class<?> getModelClass() {
		return ProductRoute.class;
	}

	public String getModelClassName() {
		return ProductRoute.class.getName();
	}

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

	/**
	* Returns the primary key of this product route.
	*
	* @return the primary key of this product route
	*/
	public long getPrimaryKey() {
		return _productRoute.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product route.
	*
	* @param primaryKey the primary key of this product route
	*/
	public void setPrimaryKey(long primaryKey) {
		_productRoute.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the route ID of this product route.
	*
	* @return the route ID of this product route
	*/
	public long getRouteId() {
		return _productRoute.getRouteId();
	}

	/**
	* Sets the route ID of this product route.
	*
	* @param routeId the route ID of this product route
	*/
	public void setRouteId(long routeId) {
		_productRoute.setRouteId(routeId);
	}

	/**
	* Returns the group ID of this product route.
	*
	* @return the group ID of this product route
	*/
	public long getGroupId() {
		return _productRoute.getGroupId();
	}

	/**
	* Sets the group ID of this product route.
	*
	* @param groupId the group ID of this product route
	*/
	public void setGroupId(long groupId) {
		_productRoute.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this product route.
	*
	* @return the company ID of this product route
	*/
	public long getCompanyId() {
		return _productRoute.getCompanyId();
	}

	/**
	* Sets the company ID of this product route.
	*
	* @param companyId the company ID of this product route
	*/
	public void setCompanyId(long companyId) {
		_productRoute.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this product route.
	*
	* @return the user ID of this product route
	*/
	public long getUserId() {
		return _productRoute.getUserId();
	}

	/**
	* Sets the user ID of this product route.
	*
	* @param userId the user ID of this product route
	*/
	public void setUserId(long userId) {
		_productRoute.setUserId(userId);
	}

	/**
	* Returns the user uuid of this product route.
	*
	* @return the user uuid of this product route
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productRoute.getUserUuid();
	}

	/**
	* Sets the user uuid of this product route.
	*
	* @param userUuid the user uuid of this product route
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_productRoute.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this product route.
	*
	* @return the create date of this product route
	*/
	public java.util.Date getCreateDate() {
		return _productRoute.getCreateDate();
	}

	/**
	* Sets the create date of this product route.
	*
	* @param createDate the create date of this product route
	*/
	public void setCreateDate(java.util.Date createDate) {
		_productRoute.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this product route.
	*
	* @return the modified date of this product route
	*/
	public java.util.Date getModifiedDate() {
		return _productRoute.getModifiedDate();
	}

	/**
	* Sets the modified date of this product route.
	*
	* @param modifiedDate the modified date of this product route
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_productRoute.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the channel of this product route.
	*
	* @return the channel of this product route
	*/
	public java.lang.String getChannel() {
		return _productRoute.getChannel();
	}

	/**
	* Sets the channel of this product route.
	*
	* @param channel the channel of this product route
	*/
	public void setChannel(java.lang.String channel) {
		_productRoute.setChannel(channel);
	}

	/**
	* Returns the service address of this product route.
	*
	* @return the service address of this product route
	*/
	public java.lang.String getServiceAddress() {
		return _productRoute.getServiceAddress();
	}

	/**
	* Sets the service address of this product route.
	*
	* @param serviceAddress the service address of this product route
	*/
	public void setServiceAddress(java.lang.String serviceAddress) {
		_productRoute.setServiceAddress(serviceAddress);
	}

	/**
	* Returns the keyword of this product route.
	*
	* @return the keyword of this product route
	*/
	public java.lang.String getKeyword() {
		return _productRoute.getKeyword();
	}

	/**
	* Sets the keyword of this product route.
	*
	* @param keyword the keyword of this product route
	*/
	public void setKeyword(java.lang.String keyword) {
		_productRoute.setKeyword(keyword);
	}

	/**
	* Returns the open time of this product route.
	*
	* @return the open time of this product route
	*/
	public java.lang.String getOpenTime() {
		return _productRoute.getOpenTime();
	}

	/**
	* Sets the open time of this product route.
	*
	* @param openTime the open time of this product route
	*/
	public void setOpenTime(java.lang.String openTime) {
		_productRoute.setOpenTime(openTime);
	}

	/**
	* Returns the closed time of this product route.
	*
	* @return the closed time of this product route
	*/
	public java.lang.String getClosedTime() {
		return _productRoute.getClosedTime();
	}

	/**
	* Sets the closed time of this product route.
	*
	* @param closedTime the closed time of this product route
	*/
	public void setClosedTime(java.lang.String closedTime) {
		_productRoute.setClosedTime(closedTime);
	}

	/**
	* Returns the check balance of this product route.
	*
	* @return the check balance of this product route
	*/
	public boolean getCheckBalance() {
		return _productRoute.getCheckBalance();
	}

	/**
	* Returns <code>true</code> if this product route is check balance.
	*
	* @return <code>true</code> if this product route is check balance; <code>false</code> otherwise
	*/
	public boolean isCheckBalance() {
		return _productRoute.isCheckBalance();
	}

	/**
	* Sets whether this product route is check balance.
	*
	* @param checkBalance the check balance of this product route
	*/
	public void setCheckBalance(boolean checkBalance) {
		_productRoute.setCheckBalance(checkBalance);
	}

	/**
	* Returns the sms min params of this product route.
	*
	* @return the sms min params of this product route
	*/
	public int getSmsMinParams() {
		return _productRoute.getSmsMinParams();
	}

	/**
	* Sets the sms min params of this product route.
	*
	* @param smsMinParams the sms min params of this product route
	*/
	public void setSmsMinParams(int smsMinParams) {
		_productRoute.setSmsMinParams(smsMinParams);
	}

	/**
	* Returns the sms max params of this product route.
	*
	* @return the sms max params of this product route
	*/
	public int getSmsMaxParams() {
		return _productRoute.getSmsMaxParams();
	}

	/**
	* Sets the sms max params of this product route.
	*
	* @param smsMaxParams the sms max params of this product route
	*/
	public void setSmsMaxParams(int smsMaxParams) {
		_productRoute.setSmsMaxParams(smsMaxParams);
	}

	/**
	* Returns the action type of this product route.
	*
	* @return the action type of this product route
	*/
	public java.lang.String getActionType() {
		return _productRoute.getActionType();
	}

	/**
	* Sets the action type of this product route.
	*
	* @param actionType the action type of this product route
	*/
	public void setActionType(java.lang.String actionType) {
		_productRoute.setActionType(actionType);
	}

	/**
	* Returns the product ID of this product route.
	*
	* @return the product ID of this product route
	*/
	public long getProductId() {
		return _productRoute.getProductId();
	}

	/**
	* Sets the product ID of this product route.
	*
	* @param productId the product ID of this product route
	*/
	public void setProductId(long productId) {
		_productRoute.setProductId(productId);
	}

	/**
	* Returns the campaign ID of this product route.
	*
	* @return the campaign ID of this product route
	*/
	public long getCampaignId() {
		return _productRoute.getCampaignId();
	}

	/**
	* Sets the campaign ID of this product route.
	*
	* @param campaignId the campaign ID of this product route
	*/
	public void setCampaignId(long campaignId) {
		_productRoute.setCampaignId(campaignId);
	}

	/**
	* Returns the language ID of this product route.
	*
	* @return the language ID of this product route
	*/
	public java.lang.String getLanguageId() {
		return _productRoute.getLanguageId();
	}

	/**
	* Sets the language ID of this product route.
	*
	* @param languageId the language ID of this product route
	*/
	public void setLanguageId(java.lang.String languageId) {
		_productRoute.setLanguageId(languageId);
	}

	/**
	* Returns the synchronous of this product route.
	*
	* @return the synchronous of this product route
	*/
	public boolean getSynchronous() {
		return _productRoute.getSynchronous();
	}

	/**
	* Returns <code>true</code> if this product route is synchronous.
	*
	* @return <code>true</code> if this product route is synchronous; <code>false</code> otherwise
	*/
	public boolean isSynchronous() {
		return _productRoute.isSynchronous();
	}

	/**
	* Sets whether this product route is synchronous.
	*
	* @param synchronous the synchronous of this product route
	*/
	public void setSynchronous(boolean synchronous) {
		_productRoute.setSynchronous(synchronous);
	}

	/**
	* Returns the create order of this product route.
	*
	* @return the create order of this product route
	*/
	public boolean getCreateOrder() {
		return _productRoute.getCreateOrder();
	}

	/**
	* Returns <code>true</code> if this product route is create order.
	*
	* @return <code>true</code> if this product route is create order; <code>false</code> otherwise
	*/
	public boolean isCreateOrder() {
		return _productRoute.isCreateOrder();
	}

	/**
	* Sets whether this product route is create order.
	*
	* @param createOrder the create order of this product route
	*/
	public void setCreateOrder(boolean createOrder) {
		_productRoute.setCreateOrder(createOrder);
	}

	/**
	* Returns the timeout of this product route.
	*
	* @return the timeout of this product route
	*/
	public int getTimeout() {
		return _productRoute.getTimeout();
	}

	/**
	* Sets the timeout of this product route.
	*
	* @param timeout the timeout of this product route
	*/
	public void setTimeout(int timeout) {
		_productRoute.setTimeout(timeout);
	}

	/**
	* Returns the max register daily of this product route.
	*
	* @return the max register daily of this product route
	*/
	public int getMaxRegisterDaily() {
		return _productRoute.getMaxRegisterDaily();
	}

	/**
	* Sets the max register daily of this product route.
	*
	* @param maxRegisterDaily the max register daily of this product route
	*/
	public void setMaxRegisterDaily(int maxRegisterDaily) {
		_productRoute.setMaxRegisterDaily(maxRegisterDaily);
	}

	/**
	* Returns the duplicate scan of this product route.
	*
	* @return the duplicate scan of this product route
	*/
	public int getDuplicateScan() {
		return _productRoute.getDuplicateScan();
	}

	/**
	* Sets the duplicate scan of this product route.
	*
	* @param duplicateScan the duplicate scan of this product route
	*/
	public void setDuplicateScan(int duplicateScan) {
		_productRoute.setDuplicateScan(duplicateScan);
	}

	/**
	* Returns the check spam of this product route.
	*
	* @return the check spam of this product route
	*/
	public boolean getCheckSpam() {
		return _productRoute.getCheckSpam();
	}

	/**
	* Returns <code>true</code> if this product route is check spam.
	*
	* @return <code>true</code> if this product route is check spam; <code>false</code> otherwise
	*/
	public boolean isCheckSpam() {
		return _productRoute.isCheckSpam();
	}

	/**
	* Sets whether this product route is check spam.
	*
	* @param checkSpam the check spam of this product route
	*/
	public void setCheckSpam(boolean checkSpam) {
		_productRoute.setCheckSpam(checkSpam);
	}

	/**
	* Returns the fraud times of this product route.
	*
	* @return the fraud times of this product route
	*/
	public int getFraudTimes() {
		return _productRoute.getFraudTimes();
	}

	/**
	* Sets the fraud times of this product route.
	*
	* @param fraudTimes the fraud times of this product route
	*/
	public void setFraudTimes(int fraudTimes) {
		_productRoute.setFraudTimes(fraudTimes);
	}

	/**
	* Returns the fraud period of this product route.
	*
	* @return the fraud period of this product route
	*/
	public int getFraudPeriod() {
		return _productRoute.getFraudPeriod();
	}

	/**
	* Sets the fraud period of this product route.
	*
	* @param fraudPeriod the fraud period of this product route
	*/
	public void setFraudPeriod(int fraudPeriod) {
		_productRoute.setFraudPeriod(fraudPeriod);
	}

	/**
	* Returns the fraud unit of this product route.
	*
	* @return the fraud unit of this product route
	*/
	public java.lang.String getFraudUnit() {
		return _productRoute.getFraudUnit();
	}

	/**
	* Sets the fraud unit of this product route.
	*
	* @param fraudUnit the fraud unit of this product route
	*/
	public void setFraudUnit(java.lang.String fraudUnit) {
		_productRoute.setFraudUnit(fraudUnit);
	}

	/**
	* Returns the reject unit of this product route.
	*
	* @return the reject unit of this product route
	*/
	public java.lang.String getRejectUnit() {
		return _productRoute.getRejectUnit();
	}

	/**
	* Sets the reject unit of this product route.
	*
	* @param rejectUnit the reject unit of this product route
	*/
	public void setRejectUnit(java.lang.String rejectUnit) {
		_productRoute.setRejectUnit(rejectUnit);
	}

	/**
	* Returns the reject period of this product route.
	*
	* @return the reject period of this product route
	*/
	public int getRejectPeriod() {
		return _productRoute.getRejectPeriod();
	}

	/**
	* Sets the reject period of this product route.
	*
	* @param rejectPeriod the reject period of this product route
	*/
	public void setRejectPeriod(int rejectPeriod) {
		_productRoute.setRejectPeriod(rejectPeriod);
	}

	/**
	* Returns the base charge enable of this product route.
	*
	* @return the base charge enable of this product route
	*/
	public boolean getBaseChargeEnable() {
		return _productRoute.getBaseChargeEnable();
	}

	/**
	* Returns <code>true</code> if this product route is base charge enable.
	*
	* @return <code>true</code> if this product route is base charge enable; <code>false</code> otherwise
	*/
	public boolean isBaseChargeEnable() {
		return _productRoute.isBaseChargeEnable();
	}

	/**
	* Sets whether this product route is base charge enable.
	*
	* @param baseChargeEnable the base charge enable of this product route
	*/
	public void setBaseChargeEnable(boolean baseChargeEnable) {
		_productRoute.setBaseChargeEnable(baseChargeEnable);
	}

	/**
	* Returns the charging amount of this product route.
	*
	* @return the charging amount of this product route
	*/
	public double getChargingAmount() {
		return _productRoute.getChargingAmount();
	}

	/**
	* Sets the charging amount of this product route.
	*
	* @param chargingAmount the charging amount of this product route
	*/
	public void setChargingAmount(double chargingAmount) {
		_productRoute.setChargingAmount(chargingAmount);
	}

	/**
	* Returns the notify owner of this product route.
	*
	* @return the notify owner of this product route
	*/
	public boolean getNotifyOwner() {
		return _productRoute.getNotifyOwner();
	}

	/**
	* Returns <code>true</code> if this product route is notify owner.
	*
	* @return <code>true</code> if this product route is notify owner; <code>false</code> otherwise
	*/
	public boolean isNotifyOwner() {
		return _productRoute.isNotifyOwner();
	}

	/**
	* Sets whether this product route is notify owner.
	*
	* @param notifyOwner the notify owner of this product route
	*/
	public void setNotifyOwner(boolean notifyOwner) {
		_productRoute.setNotifyOwner(notifyOwner);
	}

	/**
	* Returns the notify deliver of this product route.
	*
	* @return the notify deliver of this product route
	*/
	public boolean getNotifyDeliver() {
		return _productRoute.getNotifyDeliver();
	}

	/**
	* Returns <code>true</code> if this product route is notify deliver.
	*
	* @return <code>true</code> if this product route is notify deliver; <code>false</code> otherwise
	*/
	public boolean isNotifyDeliver() {
		return _productRoute.isNotifyDeliver();
	}

	/**
	* Sets whether this product route is notify deliver.
	*
	* @param notifyDeliver the notify deliver of this product route
	*/
	public void setNotifyDeliver(boolean notifyDeliver) {
		_productRoute.setNotifyDeliver(notifyDeliver);
	}

	/**
	* Returns the send advertising of this product route.
	*
	* @return the send advertising of this product route
	*/
	public boolean getSendAdvertising() {
		return _productRoute.getSendAdvertising();
	}

	/**
	* Returns <code>true</code> if this product route is send advertising.
	*
	* @return <code>true</code> if this product route is send advertising; <code>false</code> otherwise
	*/
	public boolean isSendAdvertising() {
		return _productRoute.isSendAdvertising();
	}

	/**
	* Sets whether this product route is send advertising.
	*
	* @param sendAdvertising the send advertising of this product route
	*/
	public void setSendAdvertising(boolean sendAdvertising) {
		_productRoute.setSendAdvertising(sendAdvertising);
	}

	/**
	* Returns the check promotion of this product route.
	*
	* @return the check promotion of this product route
	*/
	public boolean getCheckPromotion() {
		return _productRoute.getCheckPromotion();
	}

	/**
	* Returns <code>true</code> if this product route is check promotion.
	*
	* @return <code>true</code> if this product route is check promotion; <code>false</code> otherwise
	*/
	public boolean isCheckPromotion() {
		return _productRoute.isCheckPromotion();
	}

	/**
	* Sets whether this product route is check promotion.
	*
	* @param checkPromotion the check promotion of this product route
	*/
	public void setCheckPromotion(boolean checkPromotion) {
		_productRoute.setCheckPromotion(checkPromotion);
	}

	/**
	* Returns the topup enable of this product route.
	*
	* @return the topup enable of this product route
	*/
	public boolean getTopupEnable() {
		return _productRoute.getTopupEnable();
	}

	/**
	* Returns <code>true</code> if this product route is topup enable.
	*
	* @return <code>true</code> if this product route is topup enable; <code>false</code> otherwise
	*/
	public boolean isTopupEnable() {
		return _productRoute.isTopupEnable();
	}

	/**
	* Sets whether this product route is topup enable.
	*
	* @param topupEnable the topup enable of this product route
	*/
	public void setTopupEnable(boolean topupEnable) {
		_productRoute.setTopupEnable(topupEnable);
	}

	/**
	* Returns the properties of this product route.
	*
	* @return the properties of this product route
	*/
	public java.lang.String getProperties() {
		return _productRoute.getProperties();
	}

	/**
	* Sets the properties of this product route.
	*
	* @param properties the properties of this product route
	*/
	public void setProperties(java.lang.String properties) {
		_productRoute.setProperties(properties);
	}

	/**
	* Returns the queue name of this product route.
	*
	* @return the queue name of this product route
	*/
	public java.lang.String getQueueName() {
		return _productRoute.getQueueName();
	}

	/**
	* Sets the queue name of this product route.
	*
	* @param queueName the queue name of this product route
	*/
	public void setQueueName(java.lang.String queueName) {
		_productRoute.setQueueName(queueName);
	}

	/**
	* Returns the process class of this product route.
	*
	* @return the process class of this product route
	*/
	public java.lang.String getProcessClass() {
		return _productRoute.getProcessClass();
	}

	/**
	* Sets the process class of this product route.
	*
	* @param processClass the process class of this product route
	*/
	public void setProcessClass(java.lang.String processClass) {
		_productRoute.setProcessClass(processClass);
	}

	/**
	* Returns the process method of this product route.
	*
	* @return the process method of this product route
	*/
	public java.lang.String getProcessMethod() {
		return _productRoute.getProcessMethod();
	}

	/**
	* Sets the process method of this product route.
	*
	* @param processMethod the process method of this product route
	*/
	public void setProcessMethod(java.lang.String processMethod) {
		_productRoute.setProcessMethod(processMethod);
	}

	/**
	* Returns the status of this product route.
	*
	* @return the status of this product route
	*/
	public int getStatus() {
		return _productRoute.getStatus();
	}

	/**
	* Sets the status of this product route.
	*
	* @param status the status of this product route
	*/
	public void setStatus(int status) {
		_productRoute.setStatus(status);
	}

	/**
	* Returns the start date of this product route.
	*
	* @return the start date of this product route
	*/
	public java.util.Date getStartDate() {
		return _productRoute.getStartDate();
	}

	/**
	* Sets the start date of this product route.
	*
	* @param startDate the start date of this product route
	*/
	public void setStartDate(java.util.Date startDate) {
		_productRoute.setStartDate(startDate);
	}

	/**
	* Returns the expiration date of this product route.
	*
	* @return the expiration date of this product route
	*/
	public java.util.Date getExpirationDate() {
		return _productRoute.getExpirationDate();
	}

	/**
	* Sets the expiration date of this product route.
	*
	* @param expirationDate the expiration date of this product route
	*/
	public void setExpirationDate(java.util.Date expirationDate) {
		_productRoute.setExpirationDate(expirationDate);
	}

	/**
	* Returns the description of this product route.
	*
	* @return the description of this product route
	*/
	public java.lang.String getDescription() {
		return _productRoute.getDescription();
	}

	/**
	* Sets the description of this product route.
	*
	* @param description the description of this product route
	*/
	public void setDescription(java.lang.String description) {
		_productRoute.setDescription(description);
	}

	public boolean isNew() {
		return _productRoute.isNew();
	}

	public void setNew(boolean n) {
		_productRoute.setNew(n);
	}

	public boolean isCachedModel() {
		return _productRoute.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_productRoute.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _productRoute.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _productRoute.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_productRoute.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _productRoute.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_productRoute.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductRouteWrapper((ProductRoute)_productRoute.clone());
	}

	public int compareTo(com.cmc.gateway.domain.model.ProductRoute productRoute) {
		return _productRoute.compareTo(productRoute);
	}

	@Override
	public int hashCode() {
		return _productRoute.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.cmc.gateway.domain.model.ProductRoute> toCacheModel() {
		return _productRoute.toCacheModel();
	}

	public com.cmc.gateway.domain.model.ProductRoute toEscapedModel() {
		return new ProductRouteWrapper(_productRoute.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _productRoute.toString();
	}

	public java.lang.String toXmlString() {
		return _productRoute.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_productRoute.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProductRoute getWrappedProductRoute() {
		return _productRoute;
	}

	public ProductRoute getWrappedModel() {
		return _productRoute;
	}

	public void resetOriginalValues() {
		_productRoute.resetOriginalValues();
	}

	private ProductRoute _productRoute;
}