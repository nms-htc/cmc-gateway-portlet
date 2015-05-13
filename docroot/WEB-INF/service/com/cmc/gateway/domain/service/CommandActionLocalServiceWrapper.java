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
 * This class is a wrapper for {@link CommandActionLocalService}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       CommandActionLocalService
 * @generated
 */
public class CommandActionLocalServiceWrapper
	implements CommandActionLocalService,
		ServiceWrapper<CommandActionLocalService> {
	public CommandActionLocalServiceWrapper(
		CommandActionLocalService commandActionLocalService) {
		_commandActionLocalService = commandActionLocalService;
	}

	/**
	* Adds the command action to the database. Also notifies the appropriate model listeners.
	*
	* @param commandAction the command action
	* @return the command action that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction addCommandAction(
		com.cmc.gateway.domain.model.CommandAction commandAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.addCommandAction(commandAction);
	}

	/**
	* Creates a new command action with the primary key. Does not add the command action to the database.
	*
	* @param actionId the primary key for the new command action
	* @return the new command action
	*/
	public com.cmc.gateway.domain.model.CommandAction createCommandAction(
		long actionId) {
		return _commandActionLocalService.createCommandAction(actionId);
	}

	/**
	* Deletes the command action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the command action
	* @return the command action that was removed
	* @throws PortalException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction deleteCommandAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.deleteCommandAction(actionId);
	}

	/**
	* Deletes the command action from the database. Also notifies the appropriate model listeners.
	*
	* @param commandAction the command action
	* @return the command action that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction deleteCommandAction(
		com.cmc.gateway.domain.model.CommandAction commandAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.deleteCommandAction(commandAction);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commandActionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cmc.gateway.domain.model.CommandAction fetchCommandAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.fetchCommandAction(actionId);
	}

	/**
	* Returns the command action with the primary key.
	*
	* @param actionId the primary key of the command action
	* @return the command action
	* @throws PortalException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction getCommandAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.getCommandAction(actionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the command actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of command actions
	* @param end the upper bound of the range of command actions (not inclusive)
	* @return the range of command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> getCommandActions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.getCommandActions(start, end);
	}

	/**
	* Returns the number of command actions.
	*
	* @return the number of command actions
	* @throws SystemException if a system exception occurred
	*/
	public int getCommandActionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.getCommandActionsCount();
	}

	/**
	* Updates the command action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commandAction the command action
	* @return the command action that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction updateCommandAction(
		com.cmc.gateway.domain.model.CommandAction commandAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.updateCommandAction(commandAction);
	}

	/**
	* Updates the command action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commandAction the command action
	* @param merge whether to merge the command action with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the command action that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction updateCommandAction(
		com.cmc.gateway.domain.model.CommandAction commandAction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commandActionLocalService.updateCommandAction(commandAction,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _commandActionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_commandActionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _commandActionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CommandActionLocalService getWrappedCommandActionLocalService() {
		return _commandActionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCommandActionLocalService(
		CommandActionLocalService commandActionLocalService) {
		_commandActionLocalService = commandActionLocalService;
	}

	public CommandActionLocalService getWrappedService() {
		return _commandActionLocalService;
	}

	public void setWrappedService(
		CommandActionLocalService commandActionLocalService) {
		_commandActionLocalService = commandActionLocalService;
	}

	private CommandActionLocalService _commandActionLocalService;
}