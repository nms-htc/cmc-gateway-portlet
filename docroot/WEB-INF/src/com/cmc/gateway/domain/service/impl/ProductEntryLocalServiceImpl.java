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

import com.cmc.gateway.domain.NoSuchProductEntryException;
import com.cmc.gateway.domain.model.ProductEntry;
import com.cmc.gateway.domain.service.base.ProductEntryLocalServiceBaseImpl;
import com.cmc.gateway.domain.util.ValidateUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the product entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cmc.gateway.domain.service.ProductEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see com.cmc.gateway.domain.service.base.ProductEntryLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.ProductEntryLocalServiceUtil
 */
public class ProductEntryLocalServiceImpl
	extends ProductEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cmc.gateway.domain.service.ProductEntryLocalServiceUtil} to access the product entry local service.
	 */
	
	public ProductEntry update(ProductEntry productEntry, ServiceContext serviceContext) throws PortalException, SystemException {
		
		Date now = new Date();
		
		if (Validator.isNull(productEntry.getProductId()) && productEntry.isNew()) {
			long productId = counterLocalService.increment(ProductEntry.class.getName());
			productEntry.setProductId(productId);
			
			productEntry.setUserId(serviceContext.getUserId());
			productEntry.setGroupId(serviceContext.getScopeGroupId());
			productEntry.setCompanyId(serviceContext.getCompanyId());
			
			productEntry.setCreateDate(now);
			productEntry.setModifiedDate(now);
		} else {
			productEntry.setModifiedDate(now);	
		}
		
		validate(productEntry);
		
		return productEntryPersistence.update(productEntry, true);
	}
	
	public void validate(ProductEntry productEntry) throws PortalException, SystemException {
		ValidateUtil.checkNull(productEntry.getTitle(), "title");
		ValidateUtil.checkNull(productEntry.getCode(), "code");
		try {
			productEntryPersistence.findByCode(productEntry.getCode());
			throw new PortalException("code-has-been-exist-on-the-system");
		} catch (NoSuchProductEntryException e) {
			// Happy
		}
	}
}