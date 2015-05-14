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

import com.cmc.gateway.domain.model.ProductMessage;
import com.cmc.gateway.domain.service.base.ProductMessageLocalServiceBaseImpl;
import com.cmc.gateway.domain.util.ValidateUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the product message local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cmc.gateway.domain.service.ProductMessageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see com.cmc.gateway.domain.service.base.ProductMessageLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.ProductMessageLocalServiceUtil
 */
public class ProductMessageLocalServiceImpl
	extends ProductMessageLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cmc.gateway.domain.service.ProductMessageLocalServiceUtil} to access the product message local service.
	 */
	
	public ProductMessage update(ProductMessage productMessage, ServiceContext context) throws SystemException, PortalException {
		
		if (Validator.isNull(productMessage.getMessageId()) && productMessage.isNew()) {
			long messageId = counterLocalService.increment(ProductMessage.class.getName());
			productMessage.setMessageId(messageId);
			
			productMessage.setUserId(context.getUserId());	
			productMessage.setGroupId(context.getScopeGroupId());
			productMessage.setCompanyId(context.getCompanyId());
			productMessage.setCreateDate(context.getCreateDate());
			productMessage.setModifiedDate(context.getModifiedDate());
		} else {
			productMessage.setModifiedDate(context.getModifiedDate());
		}
		
		validate(productMessage);
		
		return productMessagePersistence.update(productMessage, true);
	}
	
	private void validate(ProductMessage productMessage) throws PortalException {
		ValidateUtil.checkNull(productMessage.getProductId(), "product");
		ValidateUtil.checkNull(productMessage.getActionType(), "action-type");
		ValidateUtil.checkNull(productMessage.getChannel(), "channel");
	}
}