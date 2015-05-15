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
 * The utility for the command entry local service. This utility wraps {@link com.cmc.gateway.domain.service.impl.CommandEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see CommandEntryLocalService
 * @see com.cmc.gateway.domain.service.base.CommandEntryLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.impl.CommandEntryLocalServiceImpl
 * @generated
 */
public class CommandEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cmc.gateway.domain.service.impl.CommandEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the command entry to the database. Also notifies the appropriate model listeners.
	*
	* @param commandEntry the command entry
	* @return the command entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry addCommandEntry(
		com.cmc.gateway.domain.model.CommandEntry commandEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCommandEntry(commandEntry);
	}

	/**
	* Creates a new command entry with the primary key. Does not add the command entry to the database.
	*
	* @param commandId the primary key for the new command entry
	* @return the new command entry
	*/
	public static com.cmc.gateway.domain.model.CommandEntry createCommandEntry(
		long commandId) {
		return getService().createCommandEntry(commandId);
	}

	/**
	* Deletes the command entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commandId the primary key of the command entry
	* @return the command entry that was removed
	* @throws PortalException if a command entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry deleteCommandEntry(
		long commandId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCommandEntry(commandId);
	}

	/**
	* Deletes the command entry from the database. Also notifies the appropriate model listeners.
	*
	* @param commandEntry the command entry
	* @return the command entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry deleteCommandEntry(
		com.cmc.gateway.domain.model.CommandEntry commandEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCommandEntry(commandEntry);
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

	public static com.cmc.gateway.domain.model.CommandEntry fetchCommandEntry(
		long commandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCommandEntry(commandId);
	}

	/**
	* Returns the command entry with the primary key.
	*
	* @param commandId the primary key of the command entry
	* @return the command entry
	* @throws PortalException if a command entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry getCommandEntry(
		long commandId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCommandEntry(commandId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the command entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of command entries
	* @param end the upper bound of the range of command entries (not inclusive)
	* @return the range of command entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.CommandEntry> getCommandEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCommandEntries(start, end);
	}

	/**
	* Returns the number of command entries.
	*
	* @return the number of command entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getCommandEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCommandEntriesCount();
	}

	/**
	* Updates the command entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commandEntry the command entry
	* @return the command entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry updateCommandEntry(
		com.cmc.gateway.domain.model.CommandEntry commandEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCommandEntry(commandEntry);
	}

	/**
	* Updates the command entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commandEntry the command entry
	* @param merge whether to merge the command entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the command entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry updateCommandEntry(
		com.cmc.gateway.domain.model.CommandEntry commandEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCommandEntry(commandEntry, merge);
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

	public static com.cmc.gateway.domain.model.CommandEntry update(
		com.cmc.gateway.domain.model.CommandEntry commandEntry,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().update(commandEntry, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static CommandEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CommandEntryLocalService.class.getName());

			if (invokableLocalService instanceof CommandEntryLocalService) {
				_service = (CommandEntryLocalService)invokableLocalService;
			}
			else {
				_service = new CommandEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CommandEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CommandEntryLocalService service) {
	}

	private static CommandEntryLocalService _service;
}