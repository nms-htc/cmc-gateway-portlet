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

package com.cmc.gateway.domain.service.impl;

import com.cmc.gateway.domain.model.ProductRoute;
import com.cmc.gateway.domain.service.base.ProductRouteLocalServiceBaseImpl;
import com.cmc.gateway.domain.util.ValidateUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the product route local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cmc.gateway.domain.service.ProductRouteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see com.cmc.gateway.domain.service.base.ProductRouteLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.ProductRouteLocalServiceUtil
 */
public class ProductRouteLocalServiceImpl
	extends ProductRouteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cmc.gateway.domain.service.ProductRouteLocalServiceUtil} to access the product route local service.
	 */
	
	public ProductRoute update(ProductRoute productRoute, ServiceContext context) throws PortalException, SystemException {
		
		if (Validator.isNull(productRoute.getRouteId()) && productRoute.isNew()) {
			long routeId = counterLocalService.increment(ProductRoute.class.getName());
			productRoute.setRouteId(routeId);
			
			productRoute.setUserId(context.getUserId());
			productRoute.setGroupId(context.getScopeGroupId());
			productRoute.setCompanyId(context.getCompanyId());
			productRoute.setCreateDate(context.getCreateDate());
			productRoute.setModifiedDate(context.getModifiedDate());
		} else {
			productRoute.setModifiedDate(context.getModifiedDate());
		}
		
		validate(productRoute);
		
		return productRoutePersistence.update(productRoute, true);
	}
	
	private void validate(ProductRoute productRoute) throws PortalException, SystemException {
		ValidateUtil.checkNull(productRoute.getProductId(), "product");
		ValidateUtil.checkNull(productRoute.getChannel(), "channel");
		ValidateUtil.checkNull(productRoute.getServiceAddress(), "service-address");
		ValidateUtil.checkNull(productRoute.getKeyword(), "keyword");
	}
}