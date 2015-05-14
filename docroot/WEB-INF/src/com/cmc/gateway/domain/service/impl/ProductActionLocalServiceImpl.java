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

import java.util.Date;

import com.cmc.gateway.domain.model.ProductAction;
import com.cmc.gateway.domain.service.base.ProductActionLocalServiceBaseImpl;
import com.cmc.gateway.domain.util.ValidateUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the product action local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cmc.gateway.domain.service.ProductActionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see com.cmc.gateway.domain.service.base.ProductActionLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.ProductActionLocalServiceUtil
 */
public class ProductActionLocalServiceImpl
	extends ProductActionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cmc.gateway.domain.service.ProductActionLocalServiceUtil} to access the product action local service.
	 */
	
	public ProductAction update(ProductAction productAction, ServiceContext serviceContext) 
		throws PortalException, SystemException {
		
		Date now = new Date();
		
		if (Validator.isNull(productAction.getActionId()) && productAction.isNew()) {
			long actionId = counterLocalService.increment(ProductAction.class.getName());
			productAction.setActionId(actionId);
			
			productAction.setUserId(serviceContext.getUserId());
			productAction.setGroupId(serviceContext.getScopeGroupId());
			productAction.setCompanyId(serviceContext.getCompanyId());
			
			productAction.setCreateDate(now);
			productAction.setModifiedDate(now);
		} else {
			productAction.setModifiedDate(now);
		}
		
		validate(productAction);
		
		return productActionPersistence.update(productAction, true);
	}
	
	private void validate(ProductAction productAction) throws PortalException, SystemException {
		ValidateUtil.checkNull(productAction.getActionType(), "action-type");
		ValidateUtil.checkNull(productAction.getProductId(), "product");
		ValidateUtil.checkNull(productAction.getCommandId(), "command-entry");
	}
}