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
 * This class is a wrapper for {@link ProvisioningRouteLocalService}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProvisioningRouteLocalService
 * @generated
 */
public class ProvisioningRouteLocalServiceWrapper
	implements ProvisioningRouteLocalService,
		ServiceWrapper<ProvisioningRouteLocalService> {
	public ProvisioningRouteLocalServiceWrapper(
		ProvisioningRouteLocalService provisioningRouteLocalService) {
		_provisioningRouteLocalService = provisioningRouteLocalService;
	}

	/**
	* Adds the provisioning route to the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningRoute the provisioning route
	* @return the provisioning route that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute addProvisioningRoute(
		com.cmc.gateway.domain.model.ProvisioningRoute provisioningRoute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRouteLocalService.addProvisioningRoute(provisioningRoute);
	}

	/**
	* Creates a new provisioning route with the primary key. Does not add the provisioning route to the database.
	*
	* @param routeId the primary key for the new provisioning route
	* @return the new provisioning route
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute createProvisioningRoute(
		long routeId) {
		return _provisioningRouteLocalService.createProvisioningRoute(routeId);
	}

	/**
	* Deletes the provisioning route with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param routeId the primary key of the provisioning route
	* @return the provisioning route that was removed
	* @throws PortalException if a provisioning route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute deleteProvisioningRoute(
		long routeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRouteLocalService.deleteProvisioningRoute(routeId);
	}

	/**
	* Deletes the provisioning route from the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningRoute the provisioning route
	* @return the provisioning route that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute deleteProvisioningRoute(
		com.cmc.gateway.domain.model.ProvisioningRoute provisioningRoute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRouteLocalService.deleteProvisioningRoute(provisioningRoute);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _provisioningRouteLocalService.dynamicQuery();
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
		return _provisioningRouteLocalService.dynamicQuery(dynamicQuery);
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
		return _provisioningRouteLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _provisioningRouteLocalService.dynamicQuery(dynamicQuery, start,
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
		return _provisioningRouteLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cmc.gateway.domain.model.ProvisioningRoute fetchProvisioningRoute(
		long routeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRouteLocalService.fetchProvisioningRoute(routeId);
	}

	/**
	* Returns the provisioning route with the primary key.
	*
	* @param routeId the primary key of the provisioning route
	* @return the provisioning route
	* @throws PortalException if a provisioning route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute getProvisioningRoute(
		long routeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRouteLocalService.getProvisioningRoute(routeId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRouteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the provisioning routes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of provisioning routes
	* @param end the upper bound of the range of provisioning routes (not inclusive)
	* @return the range of provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningRoute> getProvisioningRoutes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRouteLocalService.getProvisioningRoutes(start, end);
	}

	/**
	* Returns the number of provisioning routes.
	*
	* @return the number of provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public int getProvisioningRoutesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRouteLocalService.getProvisioningRoutesCount();
	}

	/**
	* Updates the provisioning route in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param provisioningRoute the provisioning route
	* @return the provisioning route that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute updateProvisioningRoute(
		com.cmc.gateway.domain.model.ProvisioningRoute provisioningRoute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRouteLocalService.updateProvisioningRoute(provisioningRoute);
	}

	/**
	* Updates the provisioning route in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param provisioningRoute the provisioning route
	* @param merge whether to merge the provisioning route with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the provisioning route that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute updateProvisioningRoute(
		com.cmc.gateway.domain.model.ProvisioningRoute provisioningRoute,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRouteLocalService.updateProvisioningRoute(provisioningRoute,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _provisioningRouteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_provisioningRouteLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _provisioningRouteLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public com.cmc.gateway.domain.model.ProvisioningRoute update(
		com.cmc.gateway.domain.model.ProvisioningRoute provisioningRoute,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningRouteLocalService.update(provisioningRoute,
			serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ProvisioningRouteLocalService getWrappedProvisioningRouteLocalService() {
		return _provisioningRouteLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedProvisioningRouteLocalService(
		ProvisioningRouteLocalService provisioningRouteLocalService) {
		_provisioningRouteLocalService = provisioningRouteLocalService;
	}

	public ProvisioningRouteLocalService getWrappedService() {
		return _provisioningRouteLocalService;
	}

	public void setWrappedService(
		ProvisioningRouteLocalService provisioningRouteLocalService) {
		_provisioningRouteLocalService = provisioningRouteLocalService;
	}

	private ProvisioningRouteLocalService _provisioningRouteLocalService;
}