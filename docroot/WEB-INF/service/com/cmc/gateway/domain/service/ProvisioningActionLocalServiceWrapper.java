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
 * This class is a wrapper for {@link ProvisioningActionLocalService}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProvisioningActionLocalService
 * @generated
 */
public class ProvisioningActionLocalServiceWrapper
	implements ProvisioningActionLocalService,
		ServiceWrapper<ProvisioningActionLocalService> {
	public ProvisioningActionLocalServiceWrapper(
		ProvisioningActionLocalService provisioningActionLocalService) {
		_provisioningActionLocalService = provisioningActionLocalService;
	}

	/**
	* Adds the provisioning action to the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningAction the provisioning action
	* @return the provisioning action that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction addProvisioningAction(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningActionLocalService.addProvisioningAction(provisioningAction);
	}

	/**
	* Creates a new provisioning action with the primary key. Does not add the provisioning action to the database.
	*
	* @param actionId the primary key for the new provisioning action
	* @return the new provisioning action
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction createProvisioningAction(
		long actionId) {
		return _provisioningActionLocalService.createProvisioningAction(actionId);
	}

	/**
	* Deletes the provisioning action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the provisioning action
	* @return the provisioning action that was removed
	* @throws PortalException if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction deleteProvisioningAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningActionLocalService.deleteProvisioningAction(actionId);
	}

	/**
	* Deletes the provisioning action from the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningAction the provisioning action
	* @return the provisioning action that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction deleteProvisioningAction(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningActionLocalService.deleteProvisioningAction(provisioningAction);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _provisioningActionLocalService.dynamicQuery();
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
		return _provisioningActionLocalService.dynamicQuery(dynamicQuery);
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
		return _provisioningActionLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _provisioningActionLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _provisioningActionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cmc.gateway.domain.model.ProvisioningAction fetchProvisioningAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningActionLocalService.fetchProvisioningAction(actionId);
	}

	/**
	* Returns the provisioning action with the primary key.
	*
	* @param actionId the primary key of the provisioning action
	* @return the provisioning action
	* @throws PortalException if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction getProvisioningAction(
		long actionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningActionLocalService.getProvisioningAction(actionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningActionLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> getProvisioningActions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningActionLocalService.getProvisioningActions(start, end);
	}

	/**
	* Returns the number of provisioning actions.
	*
	* @return the number of provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public int getProvisioningActionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningActionLocalService.getProvisioningActionsCount();
	}

	/**
	* Updates the provisioning action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param provisioningAction the provisioning action
	* @return the provisioning action that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction updateProvisioningAction(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningActionLocalService.updateProvisioningAction(provisioningAction);
	}

	/**
	* Updates the provisioning action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param provisioningAction the provisioning action
	* @param merge whether to merge the provisioning action with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the provisioning action that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction updateProvisioningAction(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningActionLocalService.updateProvisioningAction(provisioningAction,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _provisioningActionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_provisioningActionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _provisioningActionLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ProvisioningActionLocalService getWrappedProvisioningActionLocalService() {
		return _provisioningActionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedProvisioningActionLocalService(
		ProvisioningActionLocalService provisioningActionLocalService) {
		_provisioningActionLocalService = provisioningActionLocalService;
	}

	public ProvisioningActionLocalService getWrappedService() {
		return _provisioningActionLocalService;
	}

	public void setWrappedService(
		ProvisioningActionLocalService provisioningActionLocalService) {
		_provisioningActionLocalService = provisioningActionLocalService;
	}

	private ProvisioningActionLocalService _provisioningActionLocalService;
}