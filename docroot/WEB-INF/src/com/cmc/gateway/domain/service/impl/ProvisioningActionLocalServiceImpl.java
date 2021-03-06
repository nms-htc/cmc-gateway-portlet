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

import com.cmc.gateway.domain.model.ProvisioningAction;
import com.cmc.gateway.domain.service.base.ProvisioningActionLocalServiceBaseImpl;
import com.cmc.gateway.domain.util.ValidateUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the provisioning action local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cmc.gateway.domain.service.ProvisioningActionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see com.cmc.gateway.domain.service.base.ProvisioningActionLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.ProvisioningActionLocalServiceUtil
 */
public class ProvisioningActionLocalServiceImpl
	extends ProvisioningActionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cmc.gateway.domain.service.ProvisioningActionLocalServiceUtil} to access the provisioning action local service.
	 */
	
	public ProvisioningAction update(ProvisioningAction provisioningAction, ServiceContext context) throws PortalException, SystemException {
		
		if (Validator.isNull(provisioningAction.getActionId()) && provisioningAction.isNew()) {
			long actionId = counterLocalService.increment(ProvisioningAction.class.getName());
			provisioningAction.setActionId(actionId);
			provisioningAction.setUserId(context.getUserId());
			provisioningAction.setGroupId(context.getScopeGroupId());
			provisioningAction.setCompanyId(context.getCompanyId());
			provisioningAction.setCreateDate(context.getCreateDate());
			provisioningAction.setModifiedDate(context.getModifiedDate());
		} else {
			provisioningAction.setModifiedDate(context.getModifiedDate());
		}
		
		validate(provisioningAction);
		
		return provisioningActionPersistence.update(provisioningAction, true);
	}
	
	private void validate(ProvisioningAction provisioningAction) throws PortalException {
		ValidateUtil.checkNull(provisioningAction.getProvisioningId(), "provisioning-entry");
		ValidateUtil.checkNull(provisioningAction.getCommandId(), "command-entry");
	}
}