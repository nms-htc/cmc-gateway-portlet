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

import com.cmc.gateway.domain.NoSuchProvisioningEntryException;
import com.cmc.gateway.domain.model.ProvisioningEntry;
import com.cmc.gateway.domain.service.base.ProvisioningEntryLocalServiceBaseImpl;
import com.cmc.gateway.domain.util.ValidateUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the provisioning entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cmc.gateway.domain.service.ProvisioningEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see com.cmc.gateway.domain.service.base.ProvisioningEntryLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.ProvisioningEntryLocalServiceUtil
 */
public class ProvisioningEntryLocalServiceImpl
	extends ProvisioningEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cmc.gateway.domain.service.ProvisioningEntryLocalServiceUtil} to access the provisioning entry local service.
	 */
	
	public ProvisioningEntry update(ProvisioningEntry provisioningEntry, ServiceContext serviceContext) throws PortalException, SystemException {
		
		if (Validator.isNull(provisioningEntry.getProvisioningId()) && provisioningEntry.isNew()) {
			long provisioningId = counterLocalService.increment(ProvisioningEntry.class.getName());
			provisioningEntry.setProvisioningId(provisioningId);
			provisioningEntry.setUserId(serviceContext.getUserId());
			provisioningEntry.setGroupId(serviceContext.getScopeGroupId());
			provisioningEntry.setCompanyId(serviceContext.getCompanyId());
			provisioningEntry.setCreateDate(serviceContext.getCreateDate());
			provisioningEntry.setModifiedDate(serviceContext.getModifiedDate());
			
			try {
				provisioningEntryPersistence.findByCode(provisioningEntry.getCode());
				throw new PortalException("code-has-been-exist-in-the-system");
			} catch (NoSuchProvisioningEntryException e) {
				// GOOD
			}
			
		} else {
			provisioningEntry.setModifiedDate(serviceContext.getModifiedDate());
		}
		
		validate(provisioningEntry);
		
		return provisioningEntryPersistence.update(provisioningEntry, true);
	}
	
	private void validate(ProvisioningEntry provisioningEntry) throws PortalException, SystemException {
		ValidateUtil.checkNull(provisioningEntry.getCode(), "code");
		ValidateUtil.checkNull(provisioningEntry.getTitle(), "title");
	}
}