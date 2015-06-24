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

import com.cmc.gateway.domain.model.CommandAction;
import com.cmc.gateway.domain.service.base.CommandActionLocalServiceBaseImpl;
import com.cmc.gateway.domain.util.ValidateUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the command action local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cmc.gateway.domain.service.CommandActionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see com.cmc.gateway.domain.service.base.CommandActionLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.CommandActionLocalServiceUtil
 */
public class CommandActionLocalServiceImpl
	extends CommandActionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cmc.gateway.domain.service.CommandActionLocalServiceUtil} to access the command action local service.
	 */
	
	public CommandAction update(CommandAction commandAction, ServiceContext serviceContext) throws SystemException, PortalException {
		
		Date now = new Date();
		
		if (Validator.isNull(commandAction.getActionId()) && commandAction.isNew()) {
			long actionId = counterLocalService.increment(CommandAction.class.getName());
			commandAction.setActionId(actionId);
			
			commandAction.setUserId(serviceContext.getUserId());
			commandAction.setGroupId(serviceContext.getScopeGroupId());
			commandAction.setCompanyId(serviceContext.getCompanyId());
			
			commandAction.setCreateDate(now);
			commandAction.setModifiedDate(now);
		} else {
			commandAction.setModifiedDate(now);
		}
		
		validate(commandAction);
		
		return commandActionPersistence.update(commandAction, true);
	}
	
	private void validate(CommandAction commandAction ) throws PortalException {
		ValidateUtil.checkNull(commandAction.getActionName(),"action-name");
		ValidateUtil.checkNull(commandAction.getActionType(),"action-type");
		ValidateUtil.checkNull(commandAction.getCommandId(),"command-entry");
		ValidateUtil.checkNull(commandAction.getProductId(),"product");
		ValidateUtil.checkNull(commandAction.getSubscriberType(),"subscriber-type");
	}
}