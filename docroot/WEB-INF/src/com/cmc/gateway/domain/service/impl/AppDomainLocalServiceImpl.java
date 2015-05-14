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

import com.cmc.gateway.domain.NoSuchAppDomainException;
import com.cmc.gateway.domain.model.AppDomain;
import com.cmc.gateway.domain.service.base.AppDomainLocalServiceBaseImpl;
import com.cmc.gateway.domain.util.ValidateUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the app domain local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cmc.gateway.domain.service.AppDomainLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see com.cmc.gateway.domain.service.base.AppDomainLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.AppDomainLocalServiceUtil
 */
public class AppDomainLocalServiceImpl extends AppDomainLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cmc.gateway.domain.service.AppDomainLocalServiceUtil} to access the app domain local service.
	 */
	public AppDomain update(AppDomain appDomain, ServiceContext serviceContext) throws SystemException, PortalException {
		
		Date now = new Date();
		
		if (Validator.isNull(appDomain.getDomainId()) && appDomain.isNew()) {
			long appDomainId = counterLocalService.increment(AppDomain.class.getName());
			appDomain.setDomainId(appDomainId);
			
			appDomain.setCompanyId(serviceContext.getCompanyId());
			appDomain.setGroupId(serviceContext.getScopeGroupId());
			appDomain.setUserId(serviceContext.getUserId());
			
			appDomain.setCreateDate(now);
			appDomain.setModifiedDate(now);
		} else {
			appDomain.setModifiedDate(now);
		}
		
		validate(appDomain);
		
		return appDomainPersistence.update(appDomain, true);
	}
	
	public void validate(AppDomain appDomain) throws PortalException, SystemException{
		ValidateUtil.checkNull(appDomain.getCode(), "code");
		ValidateUtil.checkNull(appDomain.getTitle(), "title");
		ValidateUtil.checkNull(appDomain.getType(), "type");
		
		try {
			appDomainPersistence.findByCode(appDomain.getType(), appDomain.getCode());
			throw new PortalException("code-and-type-has-bean-exist-on-the-system");
		} catch (NoSuchAppDomainException e) {
			// everything is fine.
		}
	}
	
}