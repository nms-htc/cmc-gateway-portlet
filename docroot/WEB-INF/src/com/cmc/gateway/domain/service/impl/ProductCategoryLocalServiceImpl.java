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

import com.cmc.gateway.domain.NoSuchProductCategoryException;
import com.cmc.gateway.domain.model.ProductCategory;
import com.cmc.gateway.domain.service.base.ProductCategoryLocalServiceBaseImpl;
import com.cmc.gateway.domain.util.ValidateUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the product category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.cmc.gateway.domain.service.ProductCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see com.cmc.gateway.domain.service.base.ProductCategoryLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.ProductCategoryLocalServiceUtil
 */
public class ProductCategoryLocalServiceImpl extends
		ProductCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.cmc.gateway.domain.service.ProductCategoryLocalServiceUtil} to access
	 * the product category local service.
	 */

	public ProductCategory update(ProductCategory productCategory,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		
		Date now = new Date();
		
		if (Validator.isNull(productCategory.getCategoryId()) && productCategory.isNew()) {
			long categoryId = counterLocalService.increment(ProductCategory.class.getName()); 
			productCategory.setCategoryId(categoryId);
			
			productCategory.setUserId(serviceContext.getUserId());
			productCategory.setGroupId(serviceContext.getScopeGroupId());
			productCategory.setCompanyId(serviceContext.getCompanyId());
			
			productCategory.setCreateDate(now);
			productCategory.setModifiedDate(now);
		} else {
			productCategory.setModifiedDate(now);
		}
		
		validate(productCategory);

		return productCategoryPersistence.update(productCategory, true);
	}
	
	public ProductCategory delete(long categoryId)
			throws PortalException, SystemException {
		validateDelete(categoryId);
		return super.deleteProductCategory(categoryId);
	}
	
	public ProductCategory delete(ProductCategory productCategory)
			throws SystemException, PortalException {
		validateDelete(productCategory.getCategoryId());
		return super.deleteProductCategory(productCategory);
	}

	public void validate(ProductCategory productCategory) throws PortalException {
		ValidateUtil.checkNull(productCategory.getTitle(), "title");
	}
	
	public void validateDelete(long categoryId) throws PortalException, SystemException {
		try {
			productCategoryPersistence.findByPrimaryKey(categoryId);
		} catch (NoSuchProductCategoryException e) {
			throw new PortalException("product-category-can-not-found");
		}
		
		if (productEntryPersistence.countByCategory(categoryId) > 0) {
			throw new PortalException("can-not-delete-product-category-what-had-product-associate-with");
		}
	}
}