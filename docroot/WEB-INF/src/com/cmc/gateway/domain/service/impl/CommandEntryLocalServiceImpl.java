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

import com.cmc.gateway.domain.NoSuchCommandEntryException;
import com.cmc.gateway.domain.model.CommandEntry;
import com.cmc.gateway.domain.service.base.CommandEntryLocalServiceBaseImpl;
import com.cmc.gateway.domain.util.ValidateUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the command entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.cmc.gateway.domain.service.CommandEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see com.cmc.gateway.domain.service.base.CommandEntryLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.CommandEntryLocalServiceUtil
 */
public class CommandEntryLocalServiceImpl extends
		CommandEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.cmc.gateway.domain.service.CommandEntryLocalServiceUtil} to access
	 * the command entry local service.
	 */

	public CommandEntry update(CommandEntry commandEntry,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		
		Date now = new Date();
		
		if (Validator.isNull(commandEntry.getCommandId()) && commandEntry.isNew()) {
			long commandId = counterLocalService.increment(CommandEntry.class.getName());
			commandEntry.setCommandId(commandId);
			
			commandEntry.setUserId(serviceContext.getUserId());
			commandEntry.setGroupId(serviceContext.getScopeGroupId());
			commandEntry.setCompanyId(serviceContext.getCompanyId());
			
			commandEntry.setCreateDate(now);
			commandEntry.setModifiedDate(now);
			
			try {
				commandEntryPersistence.findByCode(commandEntry.getCode());
				throw new PortalException("a-command-entry-with-code-has-been-exist-on-the-system");
			} catch (NoSuchCommandEntryException e) {
				// Good
			}
		} else {
			commandEntry.setModifiedDate(now);
		}
		
		validate(commandEntry);

		return commandEntryPersistence.update(commandEntry, true);
	}
	
	private void validate(CommandEntry commandEntry) throws PortalException, SystemException {
		ValidateUtil.checkNull(commandEntry.getProvisioningType(), "provisioning-type");
		ValidateUtil.checkNull(commandEntry.getCode(), "code");
		ValidateUtil.checkNull(commandEntry.getTitle(), "title");
	}
}