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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.cmc.gateway.domain.service.http.ProductRouteServiceSoap}.
 *
 * @author    Richard Nguyen
 * @see       com.cmc.gateway.domain.service.http.ProductRouteServiceSoap
 * @generated
 */
public class ProductRouteSoap implements Serializable {
	public static ProductRouteSoap toSoapModel(ProductRoute model) {
		ProductRouteSoap soapModel = new ProductRouteSoap();

		soapModel.setRouteId(model.getRouteId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setChannel(model.getChannel());
		soapModel.setServiceAddress(model.getServiceAddress());
		soapModel.setKeyword(model.getKeyword());
		soapModel.setOpenTime(model.getOpenTime());
		soapModel.setClosedTime(model.getClosedTime());
		soapModel.setCheckBalance(model.getCheckBalance());
		soapModel.setSmsMinParams(model.getSmsMinParams());
		soapModel.setSmsMaxParams(model.getSmsMaxParams());
		soapModel.setActionType(model.getActionType());
		soapModel.setProductId(model.getProductId());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setSynchronous(model.getSynchronous());
		soapModel.setCreateOrder(model.getCreateOrder());
		soapModel.setTimeout(model.getTimeout());
		soapModel.setMaxRegisterDaily(model.getMaxRegisterDaily());
		soapModel.setDuplicateScan(model.getDuplicateScan());
		soapModel.setCheckSpam(model.getCheckSpam());
		soapModel.setFraudTimes(model.getFraudTimes());
		soapModel.setFraudPeriod(model.getFraudPeriod());
		soapModel.setFraudUnit(model.getFraudUnit());
		soapModel.setRejectUnit(model.getRejectUnit());
		soapModel.setRejectPeriod(model.getRejectPeriod());
		soapModel.setBaseChargeEnable(model.getBaseChargeEnable());
		soapModel.setChargingAmount(model.getChargingAmount());
		soapModel.setNotifyOwner(model.getNotifyOwner());
		soapModel.setNotifyDeliver(model.getNotifyDeliver());
		soapModel.setSendAdvertising(model.getSendAdvertising());
		soapModel.setCheckPromotion(model.getCheckPromotion());
		soapModel.setTopupEnable(model.getTopupEnable());
		soapModel.setProperties(model.getProperties());
		soapModel.setQueueName(model.getQueueName());
		soapModel.setProcessClass(model.getProcessClass());
		soapModel.setProcessMethod(model.getProcessMethod());
		soapModel.setStatus(model.getStatus());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setExpirationDate(model.getExpirationDate());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ProductRouteSoap[] toSoapModels(ProductRoute[] models) {
		ProductRouteSoap[] soapModels = new ProductRouteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductRouteSoap[][] toSoapModels(ProductRoute[][] models) {
		ProductRouteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductRouteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductRouteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductRouteSoap[] toSoapModels(List<ProductRoute> models) {
		List<ProductRouteSoap> soapModels = new ArrayList<ProductRouteSoap>(models.size());

		for (ProductRoute model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductRouteSoap[soapModels.size()]);
	}

	public ProductRouteSoap() {
	}

	public long getPrimaryKey() {
		return _routeId;
	}

	public void setPrimaryKey(long pk) {
		setRouteId(pk);
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

	private long _routeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}