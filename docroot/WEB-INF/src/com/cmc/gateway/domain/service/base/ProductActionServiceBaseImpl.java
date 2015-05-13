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

package com.cmc.gateway.domain.service.base;

import com.cmc.gateway.domain.model.ProductAction;
import com.cmc.gateway.domain.service.AppDomainLocalService;
import com.cmc.gateway.domain.service.AppDomainService;
import com.cmc.gateway.domain.service.CommandActionLocalService;
import com.cmc.gateway.domain.service.CommandActionService;
import com.cmc.gateway.domain.service.CommandEntryLocalService;
import com.cmc.gateway.domain.service.CommandEntryService;
import com.cmc.gateway.domain.service.ProductActionLocalService;
import com.cmc.gateway.domain.service.ProductActionService;
import com.cmc.gateway.domain.service.ProductCategoryLocalService;
import com.cmc.gateway.domain.service.ProductCategoryService;
import com.cmc.gateway.domain.service.ProductEntryLocalService;
import com.cmc.gateway.domain.service.ProductEntryService;
import com.cmc.gateway.domain.service.ProductMessageLocalService;
import com.cmc.gateway.domain.service.ProductMessageService;
import com.cmc.gateway.domain.service.ProductRouteLocalService;
import com.cmc.gateway.domain.service.ProductRouteService;
import com.cmc.gateway.domain.service.ProvisioningActionLocalService;
import com.cmc.gateway.domain.service.ProvisioningActionService;
import com.cmc.gateway.domain.service.ProvisioningEntryLocalService;
import com.cmc.gateway.domain.service.ProvisioningEntryService;
import com.cmc.gateway.domain.service.ProvisioningMessageLocalService;
import com.cmc.gateway.domain.service.ProvisioningMessageService;
import com.cmc.gateway.domain.service.ProvisioningRouteLocalService;
import com.cmc.gateway.domain.service.ProvisioningRouteService;
import com.cmc.gateway.domain.service.persistence.AppDomainPersistence;
import com.cmc.gateway.domain.service.persistence.CommandActionPersistence;
import com.cmc.gateway.domain.service.persistence.CommandEntryPersistence;
import com.cmc.gateway.domain.service.persistence.ProductActionPersistence;
import com.cmc.gateway.domain.service.persistence.ProductCategoryPersistence;
import com.cmc.gateway.domain.service.persistence.ProductEntryPersistence;
import com.cmc.gateway.domain.service.persistence.ProductMessagePersistence;
import com.cmc.gateway.domain.service.persistence.ProductRoutePersistence;
import com.cmc.gateway.domain.service.persistence.ProvisioningActionPersistence;
import com.cmc.gateway.domain.service.persistence.ProvisioningEntryPersistence;
import com.cmc.gateway.domain.service.persistence.ProvisioningMessagePersistence;
import com.cmc.gateway.domain.service.persistence.ProvisioningRoutePersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the product action remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.cmc.gateway.domain.service.impl.ProductActionServiceImpl}.
 * </p>
 *
 * @author Richard Nguyen
 * @see com.cmc.gateway.domain.service.impl.ProductActionServiceImpl
 * @see com.cmc.gateway.domain.service.ProductActionServiceUtil
 * @generated
 */
public abstract class ProductActionServiceBaseImpl extends BaseServiceImpl
	implements ProductActionService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.cmc.gateway.domain.service.ProductActionServiceUtil} to access the product action remote service.
	 */

	/**
	 * Returns the app domain local service.
	 *
	 * @return the app domain local service
	 */
	public AppDomainLocalService getAppDomainLocalService() {
		return appDomainLocalService;
	}

	/**
	 * Sets the app domain local service.
	 *
	 * @param appDomainLocalService the app domain local service
	 */
	public void setAppDomainLocalService(
		AppDomainLocalService appDomainLocalService) {
		this.appDomainLocalService = appDomainLocalService;
	}

	/**
	 * Returns the app domain remote service.
	 *
	 * @return the app domain remote service
	 */
	public AppDomainService getAppDomainService() {
		return appDomainService;
	}

	/**
	 * Sets the app domain remote service.
	 *
	 * @param appDomainService the app domain remote service
	 */
	public void setAppDomainService(AppDomainService appDomainService) {
		this.appDomainService = appDomainService;
	}

	/**
	 * Returns the app domain persistence.
	 *
	 * @return the app domain persistence
	 */
	public AppDomainPersistence getAppDomainPersistence() {
		return appDomainPersistence;
	}

	/**
	 * Sets the app domain persistence.
	 *
	 * @param appDomainPersistence the app domain persistence
	 */
	public void setAppDomainPersistence(
		AppDomainPersistence appDomainPersistence) {
		this.appDomainPersistence = appDomainPersistence;
	}

	/**
	 * Returns the command action local service.
	 *
	 * @return the command action local service
	 */
	public CommandActionLocalService getCommandActionLocalService() {
		return commandActionLocalService;
	}

	/**
	 * Sets the command action local service.
	 *
	 * @param commandActionLocalService the command action local service
	 */
	public void setCommandActionLocalService(
		CommandActionLocalService commandActionLocalService) {
		this.commandActionLocalService = commandActionLocalService;
	}

	/**
	 * Returns the command action remote service.
	 *
	 * @return the command action remote service
	 */
	public CommandActionService getCommandActionService() {
		return commandActionService;
	}

	/**
	 * Sets the command action remote service.
	 *
	 * @param commandActionService the command action remote service
	 */
	public void setCommandActionService(
		CommandActionService commandActionService) {
		this.commandActionService = commandActionService;
	}

	/**
	 * Returns the command action persistence.
	 *
	 * @return the command action persistence
	 */
	public CommandActionPersistence getCommandActionPersistence() {
		return commandActionPersistence;
	}

	/**
	 * Sets the command action persistence.
	 *
	 * @param commandActionPersistence the command action persistence
	 */
	public void setCommandActionPersistence(
		CommandActionPersistence commandActionPersistence) {
		this.commandActionPersistence = commandActionPersistence;
	}

	/**
	 * Returns the command entry local service.
	 *
	 * @return the command entry local service
	 */
	public CommandEntryLocalService getCommandEntryLocalService() {
		return commandEntryLocalService;
	}

	/**
	 * Sets the command entry local service.
	 *
	 * @param commandEntryLocalService the command entry local service
	 */
	public void setCommandEntryLocalService(
		CommandEntryLocalService commandEntryLocalService) {
		this.commandEntryLocalService = commandEntryLocalService;
	}

	/**
	 * Returns the command entry remote service.
	 *
	 * @return the command entry remote service
	 */
	public CommandEntryService getCommandEntryService() {
		return commandEntryService;
	}

	/**
	 * Sets the command entry remote service.
	 *
	 * @param commandEntryService the command entry remote service
	 */
	public void setCommandEntryService(CommandEntryService commandEntryService) {
		this.commandEntryService = commandEntryService;
	}

	/**
	 * Returns the command entry persistence.
	 *
	 * @return the command entry persistence
	 */
	public CommandEntryPersistence getCommandEntryPersistence() {
		return commandEntryPersistence;
	}

	/**
	 * Sets the command entry persistence.
	 *
	 * @param commandEntryPersistence the command entry persistence
	 */
	public void setCommandEntryPersistence(
		CommandEntryPersistence commandEntryPersistence) {
		this.commandEntryPersistence = commandEntryPersistence;
	}

	/**
	 * Returns the product action local service.
	 *
	 * @return the product action local service
	 */
	public ProductActionLocalService getProductActionLocalService() {
		return productActionLocalService;
	}

	/**
	 * Sets the product action local service.
	 *
	 * @param productActionLocalService the product action local service
	 */
	public void setProductActionLocalService(
		ProductActionLocalService productActionLocalService) {
		this.productActionLocalService = productActionLocalService;
	}

	/**
	 * Returns the product action remote service.
	 *
	 * @return the product action remote service
	 */
	public ProductActionService getProductActionService() {
		return productActionService;
	}

	/**
	 * Sets the product action remote service.
	 *
	 * @param productActionService the product action remote service
	 */
	public void setProductActionService(
		ProductActionService productActionService) {
		this.productActionService = productActionService;
	}

	/**
	 * Returns the product action persistence.
	 *
	 * @return the product action persistence
	 */
	public ProductActionPersistence getProductActionPersistence() {
		return productActionPersistence;
	}

	/**
	 * Sets the product action persistence.
	 *
	 * @param productActionPersistence the product action persistence
	 */
	public void setProductActionPersistence(
		ProductActionPersistence productActionPersistence) {
		this.productActionPersistence = productActionPersistence;
	}

	/**
	 * Returns the product category local service.
	 *
	 * @return the product category local service
	 */
	public ProductCategoryLocalService getProductCategoryLocalService() {
		return productCategoryLocalService;
	}

	/**
	 * Sets the product category local service.
	 *
	 * @param productCategoryLocalService the product category local service
	 */
	public void setProductCategoryLocalService(
		ProductCategoryLocalService productCategoryLocalService) {
		this.productCategoryLocalService = productCategoryLocalService;
	}

	/**
	 * Returns the product category remote service.
	 *
	 * @return the product category remote service
	 */
	public ProductCategoryService getProductCategoryService() {
		return productCategoryService;
	}

	/**
	 * Sets the product category remote service.
	 *
	 * @param productCategoryService the product category remote service
	 */
	public void setProductCategoryService(
		ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}

	/**
	 * Returns the product category persistence.
	 *
	 * @return the product category persistence
	 */
	public ProductCategoryPersistence getProductCategoryPersistence() {
		return productCategoryPersistence;
	}

	/**
	 * Sets the product category persistence.
	 *
	 * @param productCategoryPersistence the product category persistence
	 */
	public void setProductCategoryPersistence(
		ProductCategoryPersistence productCategoryPersistence) {
		this.productCategoryPersistence = productCategoryPersistence;
	}

	/**
	 * Returns the product entry local service.
	 *
	 * @return the product entry local service
	 */
	public ProductEntryLocalService getProductEntryLocalService() {
		return productEntryLocalService;
	}

	/**
	 * Sets the product entry local service.
	 *
	 * @param productEntryLocalService the product entry local service
	 */
	public void setProductEntryLocalService(
		ProductEntryLocalService productEntryLocalService) {
		this.productEntryLocalService = productEntryLocalService;
	}

	/**
	 * Returns the product entry remote service.
	 *
	 * @return the product entry remote service
	 */
	public ProductEntryService getProductEntryService() {
		return productEntryService;
	}

	/**
	 * Sets the product entry remote service.
	 *
	 * @param productEntryService the product entry remote service
	 */
	public void setProductEntryService(ProductEntryService productEntryService) {
		this.productEntryService = productEntryService;
	}

	/**
	 * Returns the product entry persistence.
	 *
	 * @return the product entry persistence
	 */
	public ProductEntryPersistence getProductEntryPersistence() {
		return productEntryPersistence;
	}

	/**
	 * Sets the product entry persistence.
	 *
	 * @param productEntryPersistence the product entry persistence
	 */
	public void setProductEntryPersistence(
		ProductEntryPersistence productEntryPersistence) {
		this.productEntryPersistence = productEntryPersistence;
	}

	/**
	 * Returns the product message local service.
	 *
	 * @return the product message local service
	 */
	public ProductMessageLocalService getProductMessageLocalService() {
		return productMessageLocalService;
	}

	/**
	 * Sets the product message local service.
	 *
	 * @param productMessageLocalService the product message local service
	 */
	public void setProductMessageLocalService(
		ProductMessageLocalService productMessageLocalService) {
		this.productMessageLocalService = productMessageLocalService;
	}

	/**
	 * Returns the product message remote service.
	 *
	 * @return the product message remote service
	 */
	public ProductMessageService getProductMessageService() {
		return productMessageService;
	}

	/**
	 * Sets the product message remote service.
	 *
	 * @param productMessageService the product message remote service
	 */
	public void setProductMessageService(
		ProductMessageService productMessageService) {
		this.productMessageService = productMessageService;
	}

	/**
	 * Returns the product message persistence.
	 *
	 * @return the product message persistence
	 */
	public ProductMessagePersistence getProductMessagePersistence() {
		return productMessagePersistence;
	}

	/**
	 * Sets the product message persistence.
	 *
	 * @param productMessagePersistence the product message persistence
	 */
	public void setProductMessagePersistence(
		ProductMessagePersistence productMessagePersistence) {
		this.productMessagePersistence = productMessagePersistence;
	}

	/**
	 * Returns the product route local service.
	 *
	 * @return the product route local service
	 */
	public ProductRouteLocalService getProductRouteLocalService() {
		return productRouteLocalService;
	}

	/**
	 * Sets the product route local service.
	 *
	 * @param productRouteLocalService the product route local service
	 */
	public void setProductRouteLocalService(
		ProductRouteLocalService productRouteLocalService) {
		this.productRouteLocalService = productRouteLocalService;
	}

	/**
	 * Returns the product route remote service.
	 *
	 * @return the product route remote service
	 */
	public ProductRouteService getProductRouteService() {
		return productRouteService;
	}

	/**
	 * Sets the product route remote service.
	 *
	 * @param productRouteService the product route remote service
	 */
	public void setProductRouteService(ProductRouteService productRouteService) {
		this.productRouteService = productRouteService;
	}

	/**
	 * Returns the product route persistence.
	 *
	 * @return the product route persistence
	 */
	public ProductRoutePersistence getProductRoutePersistence() {
		return productRoutePersistence;
	}

	/**
	 * Sets the product route persistence.
	 *
	 * @param productRoutePersistence the product route persistence
	 */
	public void setProductRoutePersistence(
		ProductRoutePersistence productRoutePersistence) {
		this.productRoutePersistence = productRoutePersistence;
	}

	/**
	 * Returns the provisioning action local service.
	 *
	 * @return the provisioning action local service
	 */
	public ProvisioningActionLocalService getProvisioningActionLocalService() {
		return provisioningActionLocalService;
	}

	/**
	 * Sets the provisioning action local service.
	 *
	 * @param provisioningActionLocalService the provisioning action local service
	 */
	public void setProvisioningActionLocalService(
		ProvisioningActionLocalService provisioningActionLocalService) {
		this.provisioningActionLocalService = provisioningActionLocalService;
	}

	/**
	 * Returns the provisioning action remote service.
	 *
	 * @return the provisioning action remote service
	 */
	public ProvisioningActionService getProvisioningActionService() {
		return provisioningActionService;
	}

	/**
	 * Sets the provisioning action remote service.
	 *
	 * @param provisioningActionService the provisioning action remote service
	 */
	public void setProvisioningActionService(
		ProvisioningActionService provisioningActionService) {
		this.provisioningActionService = provisioningActionService;
	}

	/**
	 * Returns the provisioning action persistence.
	 *
	 * @return the provisioning action persistence
	 */
	public ProvisioningActionPersistence getProvisioningActionPersistence() {
		return provisioningActionPersistence;
	}

	/**
	 * Sets the provisioning action persistence.
	 *
	 * @param provisioningActionPersistence the provisioning action persistence
	 */
	public void setProvisioningActionPersistence(
		ProvisioningActionPersistence provisioningActionPersistence) {
		this.provisioningActionPersistence = provisioningActionPersistence;
	}

	/**
	 * Returns the provisioning entry local service.
	 *
	 * @return the provisioning entry local service
	 */
	public ProvisioningEntryLocalService getProvisioningEntryLocalService() {
		return provisioningEntryLocalService;
	}

	/**
	 * Sets the provisioning entry local service.
	 *
	 * @param provisioningEntryLocalService the provisioning entry local service
	 */
	public void setProvisioningEntryLocalService(
		ProvisioningEntryLocalService provisioningEntryLocalService) {
		this.provisioningEntryLocalService = provisioningEntryLocalService;
	}

	/**
	 * Returns the provisioning entry remote service.
	 *
	 * @return the provisioning entry remote service
	 */
	public ProvisioningEntryService getProvisioningEntryService() {
		return provisioningEntryService;
	}

	/**
	 * Sets the provisioning entry remote service.
	 *
	 * @param provisioningEntryService the provisioning entry remote service
	 */
	public void setProvisioningEntryService(
		ProvisioningEntryService provisioningEntryService) {
		this.provisioningEntryService = provisioningEntryService;
	}

	/**
	 * Returns the provisioning entry persistence.
	 *
	 * @return the provisioning entry persistence
	 */
	public ProvisioningEntryPersistence getProvisioningEntryPersistence() {
		return provisioningEntryPersistence;
	}

	/**
	 * Sets the provisioning entry persistence.
	 *
	 * @param provisioningEntryPersistence the provisioning entry persistence
	 */
	public void setProvisioningEntryPersistence(
		ProvisioningEntryPersistence provisioningEntryPersistence) {
		this.provisioningEntryPersistence = provisioningEntryPersistence;
	}

	/**
	 * Returns the provisioning message local service.
	 *
	 * @return the provisioning message local service
	 */
	public ProvisioningMessageLocalService getProvisioningMessageLocalService() {
		return provisioningMessageLocalService;
	}

	/**
	 * Sets the provisioning message local service.
	 *
	 * @param provisioningMessageLocalService the provisioning message local service
	 */
	public void setProvisioningMessageLocalService(
		ProvisioningMessageLocalService provisioningMessageLocalService) {
		this.provisioningMessageLocalService = provisioningMessageLocalService;
	}

	/**
	 * Returns the provisioning message remote service.
	 *
	 * @return the provisioning message remote service
	 */
	public ProvisioningMessageService getProvisioningMessageService() {
		return provisioningMessageService;
	}

	/**
	 * Sets the provisioning message remote service.
	 *
	 * @param provisioningMessageService the provisioning message remote service
	 */
	public void setProvisioningMessageService(
		ProvisioningMessageService provisioningMessageService) {
		this.provisioningMessageService = provisioningMessageService;
	}

	/**
	 * Returns the provisioning message persistence.
	 *
	 * @return the provisioning message persistence
	 */
	public ProvisioningMessagePersistence getProvisioningMessagePersistence() {
		return provisioningMessagePersistence;
	}

	/**
	 * Sets the provisioning message persistence.
	 *
	 * @param provisioningMessagePersistence the provisioning message persistence
	 */
	public void setProvisioningMessagePersistence(
		ProvisioningMessagePersistence provisioningMessagePersistence) {
		this.provisioningMessagePersistence = provisioningMessagePersistence;
	}

	/**
	 * Returns the provisioning route local service.
	 *
	 * @return the provisioning route local service
	 */
	public ProvisioningRouteLocalService getProvisioningRouteLocalService() {
		return provisioningRouteLocalService;
	}

	/**
	 * Sets the provisioning route local service.
	 *
	 * @param provisioningRouteLocalService the provisioning route local service
	 */
	public void setProvisioningRouteLocalService(
		ProvisioningRouteLocalService provisioningRouteLocalService) {
		this.provisioningRouteLocalService = provisioningRouteLocalService;
	}

	/**
	 * Returns the provisioning route remote service.
	 *
	 * @return the provisioning route remote service
	 */
	public ProvisioningRouteService getProvisioningRouteService() {
		return provisioningRouteService;
	}

	/**
	 * Sets the provisioning route remote service.
	 *
	 * @param provisioningRouteService the provisioning route remote service
	 */
	public void setProvisioningRouteService(
		ProvisioningRouteService provisioningRouteService) {
		this.provisioningRouteService = provisioningRouteService;
	}

	/**
	 * Returns the provisioning route persistence.
	 *
	 * @return the provisioning route persistence
	 */
	public ProvisioningRoutePersistence getProvisioningRoutePersistence() {
		return provisioningRoutePersistence;
	}

	/**
	 * Sets the provisioning route persistence.
	 *
	 * @param provisioningRoutePersistence the provisioning route persistence
	 */
	public void setProvisioningRoutePersistence(
		ProvisioningRoutePersistence provisioningRoutePersistence) {
		this.provisioningRoutePersistence = provisioningRoutePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return ProductAction.class;
	}

	protected String getModelClassName() {
		return ProductAction.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = productActionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AppDomainLocalService.class)
	protected AppDomainLocalService appDomainLocalService;
	@BeanReference(type = AppDomainService.class)
	protected AppDomainService appDomainService;
	@BeanReference(type = AppDomainPersistence.class)
	protected AppDomainPersistence appDomainPersistence;
	@BeanReference(type = CommandActionLocalService.class)
	protected CommandActionLocalService commandActionLocalService;
	@BeanReference(type = CommandActionService.class)
	protected CommandActionService commandActionService;
	@BeanReference(type = CommandActionPersistence.class)
	protected CommandActionPersistence commandActionPersistence;
	@BeanReference(type = CommandEntryLocalService.class)
	protected CommandEntryLocalService commandEntryLocalService;
	@BeanReference(type = CommandEntryService.class)
	protected CommandEntryService commandEntryService;
	@BeanReference(type = CommandEntryPersistence.class)
	protected CommandEntryPersistence commandEntryPersistence;
	@BeanReference(type = ProductActionLocalService.class)
	protected ProductActionLocalService productActionLocalService;
	@BeanReference(type = ProductActionService.class)
	protected ProductActionService productActionService;
	@BeanReference(type = ProductActionPersistence.class)
	protected ProductActionPersistence productActionPersistence;
	@BeanReference(type = ProductCategoryLocalService.class)
	protected ProductCategoryLocalService productCategoryLocalService;
	@BeanReference(type = ProductCategoryService.class)
	protected ProductCategoryService productCategoryService;
	@BeanReference(type = ProductCategoryPersistence.class)
	protected ProductCategoryPersistence productCategoryPersistence;
	@BeanReference(type = ProductEntryLocalService.class)
	protected ProductEntryLocalService productEntryLocalService;
	@BeanReference(type = ProductEntryService.class)
	protected ProductEntryService productEntryService;
	@BeanReference(type = ProductEntryPersistence.class)
	protected ProductEntryPersistence productEntryPersistence;
	@BeanReference(type = ProductMessageLocalService.class)
	protected ProductMessageLocalService productMessageLocalService;
	@BeanReference(type = ProductMessageService.class)
	protected ProductMessageService productMessageService;
	@BeanReference(type = ProductMessagePersistence.class)
	protected ProductMessagePersistence productMessagePersistence;
	@BeanReference(type = ProductRouteLocalService.class)
	protected ProductRouteLocalService productRouteLocalService;
	@BeanReference(type = ProductRouteService.class)
	protected ProductRouteService productRouteService;
	@BeanReference(type = ProductRoutePersistence.class)
	protected ProductRoutePersistence productRoutePersistence;
	@BeanReference(type = ProvisioningActionLocalService.class)
	protected ProvisioningActionLocalService provisioningActionLocalService;
	@BeanReference(type = ProvisioningActionService.class)
	protected ProvisioningActionService provisioningActionService;
	@BeanReference(type = ProvisioningActionPersistence.class)
	protected ProvisioningActionPersistence provisioningActionPersistence;
	@BeanReference(type = ProvisioningEntryLocalService.class)
	protected ProvisioningEntryLocalService provisioningEntryLocalService;
	@BeanReference(type = ProvisioningEntryService.class)
	protected ProvisioningEntryService provisioningEntryService;
	@BeanReference(type = ProvisioningEntryPersistence.class)
	protected ProvisioningEntryPersistence provisioningEntryPersistence;
	@BeanReference(type = ProvisioningMessageLocalService.class)
	protected ProvisioningMessageLocalService provisioningMessageLocalService;
	@BeanReference(type = ProvisioningMessageService.class)
	protected ProvisioningMessageService provisioningMessageService;
	@BeanReference(type = ProvisioningMessagePersistence.class)
	protected ProvisioningMessagePersistence provisioningMessagePersistence;
	@BeanReference(type = ProvisioningRouteLocalService.class)
	protected ProvisioningRouteLocalService provisioningRouteLocalService;
	@BeanReference(type = ProvisioningRouteService.class)
	protected ProvisioningRouteService provisioningRouteService;
	@BeanReference(type = ProvisioningRoutePersistence.class)
	protected ProvisioningRoutePersistence provisioningRoutePersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ProductActionServiceClpInvoker _clpInvoker = new ProductActionServiceClpInvoker();
}