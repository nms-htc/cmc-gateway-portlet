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

package com.cmc.gateway.domain.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CommandEntryService}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       CommandEntryService
 * @generated
 */
public class CommandEntryServiceWrapper implements CommandEntryService,
	ServiceWrapper<CommandEntryService> {
	public CommandEntryServiceWrapper(CommandEntryService commandEntryService) {
		_commandEntryService = commandEntryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _commandEntryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_commandEntryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _commandEntryService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CommandEntryService getWrappedCommandEntryService() {
		return _commandEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCommandEntryService(
		CommandEntryService commandEntryService) {
		_commandEntryService = commandEntryService;
	}

	public CommandEntryService getWrappedService() {
		return _commandEntryService;
	}

	public void setWrappedService(CommandEntryService commandEntryService) {
		_commandEntryService = commandEntryService;
	}

	private CommandEntryService _commandEntryService;
}