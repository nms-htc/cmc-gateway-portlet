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
 * The utility for the provisioning action local service. This utility wraps {@link com.cmc.gateway.domain.service.impl.ProvisioningActionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningActionLocalService
 * @see com.cmc.gateway.domain.service.base.ProvisioningActionLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.impl.ProvisioningActionLocalServiceImpl
 * @generated
 */
public class ProvisioningActionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cmc.gateway.domain.service.impl.ProvisioningActionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the provisioning action to the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningAction the provisioning action
	* @return the provisioning action that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction addProvisioningAction(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProvisioningAction(provisioningAction);
	}

	/**
	* Creates a new provisioning action with the primary key. Does not add the provisioning action to the database.
	*
	* @param actionId the primary key for the new provisioning action
	* @return the new provisioning action
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction createProvisioningAction(
		long actionId) {
		return getService().createProvisioningAction(actionId);
	}

	/**
	* Deletes the provisioning action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the provisioning action
	* @return the provisioning action that was removed
	* @throws PortalException if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction deleteProvisioningAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProvisioningAction(actionId);
	}

	/**
	* Deletes the provisioning action from the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningAction the provisioning action
	* @return the provisioning action that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction deleteProvisioningAction(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProvisioningAction(provisioningAction);
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

	public static com.cmc.gateway.domain.model.ProvisioningAction fetchProvisioningAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProvisioningAction(actionId);
	}

	/**
	* Returns the provisioning action with the primary key.
	*
	* @param actionId the primary key of the provisioning action
	* @return the provisioning action
	* @throws PortalException if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction getProvisioningAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProvisioningAction(actionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the provisioning actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of provisioning actions
	* @param end the upper bound of the range of provisioning actions (not inclusive)
	* @return the range of provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> getProvisioningActions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProvisioningActions(start, end);
	}

	/**
	* Returns the number of provisioning actions.
	*
	* @return the number of provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static int getProvisioningActionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProvisioningActionsCount();
	}

	/**
	* Updates the provisioning action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param provisioningAction the provisioning action
	* @return the provisioning action that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction updateProvisioningAction(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProvisioningAction(provisioningAction);
	}

	/**
	* Updates the provisioning action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param provisioningAction the provisioning action
	* @param merge whether to merge the provisioning action with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the provisioning action that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction updateProvisioningAction(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProvisioningAction(provisioningAction, merge);
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

	public static com.cmc.gateway.domain.model.ProvisioningAction update(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().update(provisioningAction, context);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProvisioningActionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ProvisioningActionLocalService.class.getName());

			if (invokableLocalService instanceof ProvisioningActionLocalService) {
				_service = (ProvisioningActionLocalService)invokableLocalService;
			}
			else {
				_service = new ProvisioningActionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ProvisioningActionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ProvisioningActionLocalService service) {
	}

	private static ProvisioningActionLocalService _service;
}