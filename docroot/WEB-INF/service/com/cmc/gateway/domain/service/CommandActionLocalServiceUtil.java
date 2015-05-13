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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the command action local service. This utility wraps {@link com.cmc.gateway.domain.service.impl.CommandActionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see CommandActionLocalService
 * @see com.cmc.gateway.domain.service.base.CommandActionLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.impl.CommandActionLocalServiceImpl
 * @generated
 */
public class CommandActionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cmc.gateway.domain.service.impl.CommandActionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the command action to the database. Also notifies the appropriate model listeners.
	*
	* @param commandAction the command action
	* @return the command action that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction addCommandAction(
		com.cmc.gateway.domain.model.CommandAction commandAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCommandAction(commandAction);
	}

	/**
	* Creates a new command action with the primary key. Does not add the command action to the database.
	*
	* @param actionId the primary key for the new command action
	* @return the new command action
	*/
	public static com.cmc.gateway.domain.model.CommandAction createCommandAction(
		long actionId) {
		return getService().createCommandAction(actionId);
	}

	/**
	* Deletes the command action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the command action
	* @return the command action that was removed
	* @throws PortalException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction deleteCommandAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCommandAction(actionId);
	}

	/**
	* Deletes the command action from the database. Also notifies the appropriate model listeners.
	*
	* @param commandAction the command action
	* @return the command action that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction deleteCommandAction(
		com.cmc.gateway.domain.model.CommandAction commandAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCommandAction(commandAction);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.cmc.gateway.domain.model.CommandAction fetchCommandAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCommandAction(actionId);
	}

	/**
	* Returns the command action with the primary key.
	*
	* @param actionId the primary key of the command action
	* @return the command action
	* @throws PortalException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction getCommandAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCommandAction(actionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> getCommandActions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCommandActions(start, end);
	}

	/**
	* Returns the number of command actions.
	*
	* @return the number of command actions
	* @throws SystemException if a system exception occurred
	*/
	public static int getCommandActionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCommandActionsCount();
	}

	/**
	* Updates the command action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commandAction the command action
	* @return the command action that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction updateCommandAction(
		com.cmc.gateway.domain.model.CommandAction commandAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCommandAction(commandAction);
	}

	/**
	* Updates the command action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commandAction the command action
	* @param merge whether to merge the command action with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the command action that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction updateCommandAction(
		com.cmc.gateway.domain.model.CommandAction commandAction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCommandAction(commandAction, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static CommandActionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CommandActionLocalService.class.getName());

			if (invokableLocalService instanceof CommandActionLocalService) {
				_service = (CommandActionLocalService)invokableLocalService;
			}
			else {
				_service = new CommandActionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CommandActionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CommandActionLocalService service) {
	}

	private static CommandActionLocalService _service;
}