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
 * This class is a wrapper for {@link AppDomainLocalService}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       AppDomainLocalService
 * @generated
 */
public class AppDomainLocalServiceWrapper implements AppDomainLocalService,
	ServiceWrapper<AppDomainLocalService> {
	public AppDomainLocalServiceWrapper(
		AppDomainLocalService appDomainLocalService) {
		_appDomainLocalService = appDomainLocalService;
	}

	/**
	* Adds the app domain to the database. Also notifies the appropriate model listeners.
	*
	* @param appDomain the app domain
	* @return the app domain that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain addAppDomain(
		com.cmc.gateway.domain.model.AppDomain appDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appDomainLocalService.addAppDomain(appDomain);
	}

	/**
	* Creates a new app domain with the primary key. Does not add the app domain to the database.
	*
	* @param domainId the primary key for the new app domain
	* @return the new app domain
	*/
	public com.cmc.gateway.domain.model.AppDomain createAppDomain(long domainId) {
		return _appDomainLocalService.createAppDomain(domainId);
	}

	/**
	* Deletes the app domain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param domainId the primary key of the app domain
	* @return the app domain that was removed
	* @throws PortalException if a app domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain deleteAppDomain(long domainId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _appDomainLocalService.deleteAppDomain(domainId);
	}

	/**
	* Deletes the app domain from the database. Also notifies the appropriate model listeners.
	*
	* @param appDomain the app domain
	* @return the app domain that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain deleteAppDomain(
		com.cmc.gateway.domain.model.AppDomain appDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appDomainLocalService.deleteAppDomain(appDomain);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appDomainLocalService.dynamicQuery();
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
		return _appDomainLocalService.dynamicQuery(dynamicQuery);
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
		return _appDomainLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _appDomainLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _appDomainLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cmc.gateway.domain.model.AppDomain fetchAppDomain(long domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appDomainLocalService.fetchAppDomain(domainId);
	}

	/**
	* Returns the app domain with the primary key.
	*
	* @param domainId the primary key of the app domain
	* @return the app domain
	* @throws PortalException if a app domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain getAppDomain(long domainId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _appDomainLocalService.getAppDomain(domainId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _appDomainLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the app domains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of app domains
	* @param end the upper bound of the range of app domains (not inclusive)
	* @return the range of app domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.AppDomain> getAppDomains(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appDomainLocalService.getAppDomains(start, end);
	}

	/**
	* Returns the number of app domains.
	*
	* @return the number of app domains
	* @throws SystemException if a system exception occurred
	*/
	public int getAppDomainsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appDomainLocalService.getAppDomainsCount();
	}

	/**
	* Updates the app domain in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appDomain the app domain
	* @return the app domain that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain updateAppDomain(
		com.cmc.gateway.domain.model.AppDomain appDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appDomainLocalService.updateAppDomain(appDomain);
	}

	/**
	* Updates the app domain in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appDomain the app domain
	* @param merge whether to merge the app domain with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the app domain that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain updateAppDomain(
		com.cmc.gateway.domain.model.AppDomain appDomain, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _appDomainLocalService.updateAppDomain(appDomain, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _appDomainLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_appDomainLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _appDomainLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AppDomainLocalService getWrappedAppDomainLocalService() {
		return _appDomainLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAppDomainLocalService(
		AppDomainLocalService appDomainLocalService) {
		_appDomainLocalService = appDomainLocalService;
	}

	public AppDomainLocalService getWrappedService() {
		return _appDomainLocalService;
	}

	public void setWrappedService(AppDomainLocalService appDomainLocalService) {
		_appDomainLocalService = appDomainLocalService;
	}

	private AppDomainLocalService _appDomainLocalService;
}