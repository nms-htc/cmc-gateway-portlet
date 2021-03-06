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
 * This class is a wrapper for {@link ProvisioningEntryLocalService}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProvisioningEntryLocalService
 * @generated
 */
public class ProvisioningEntryLocalServiceWrapper
	implements ProvisioningEntryLocalService,
		ServiceWrapper<ProvisioningEntryLocalService> {
	public ProvisioningEntryLocalServiceWrapper(
		ProvisioningEntryLocalService provisioningEntryLocalService) {
		_provisioningEntryLocalService = provisioningEntryLocalService;
	}

	/**
	* Adds the provisioning entry to the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningEntry the provisioning entry
	* @return the provisioning entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry addProvisioningEntry(
		com.cmc.gateway.domain.model.ProvisioningEntry provisioningEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntryLocalService.addProvisioningEntry(provisioningEntry);
	}

	/**
	* Creates a new provisioning entry with the primary key. Does not add the provisioning entry to the database.
	*
	* @param provisioningId the primary key for the new provisioning entry
	* @return the new provisioning entry
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry createProvisioningEntry(
		long provisioningId) {
		return _provisioningEntryLocalService.createProvisioningEntry(provisioningId);
	}

	/**
	* Deletes the provisioning entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningId the primary key of the provisioning entry
	* @return the provisioning entry that was removed
	* @throws PortalException if a provisioning entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry deleteProvisioningEntry(
		long provisioningId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntryLocalService.deleteProvisioningEntry(provisioningId);
	}

	/**
	* Deletes the provisioning entry from the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningEntry the provisioning entry
	* @return the provisioning entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry deleteProvisioningEntry(
		com.cmc.gateway.domain.model.ProvisioningEntry provisioningEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntryLocalService.deleteProvisioningEntry(provisioningEntry);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _provisioningEntryLocalService.dynamicQuery();
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
		return _provisioningEntryLocalService.dynamicQuery(dynamicQuery);
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
		return _provisioningEntryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _provisioningEntryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _provisioningEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cmc.gateway.domain.model.ProvisioningEntry fetchProvisioningEntry(
		long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntryLocalService.fetchProvisioningEntry(provisioningId);
	}

	/**
	* Returns the provisioning entry with the primary key.
	*
	* @param provisioningId the primary key of the provisioning entry
	* @return the provisioning entry
	* @throws PortalException if a provisioning entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry getProvisioningEntry(
		long provisioningId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntryLocalService.getProvisioningEntry(provisioningId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the provisioning entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of provisioning entries
	* @param end the upper bound of the range of provisioning entries (not inclusive)
	* @return the range of provisioning entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningEntry> getProvisioningEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntryLocalService.getProvisioningEntries(start, end);
	}

	/**
	* Returns the number of provisioning entries.
	*
	* @return the number of provisioning entries
	* @throws SystemException if a system exception occurred
	*/
	public int getProvisioningEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntryLocalService.getProvisioningEntriesCount();
	}

	/**
	* Updates the provisioning entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param provisioningEntry the provisioning entry
	* @return the provisioning entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry updateProvisioningEntry(
		com.cmc.gateway.domain.model.ProvisioningEntry provisioningEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntryLocalService.updateProvisioningEntry(provisioningEntry);
	}

	/**
	* Updates the provisioning entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param provisioningEntry the provisioning entry
	* @param merge whether to merge the provisioning entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the provisioning entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry updateProvisioningEntry(
		com.cmc.gateway.domain.model.ProvisioningEntry provisioningEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntryLocalService.updateProvisioningEntry(provisioningEntry,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _provisioningEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_provisioningEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _provisioningEntryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public com.cmc.gateway.domain.model.ProvisioningEntry update(
		com.cmc.gateway.domain.model.ProvisioningEntry provisioningEntry,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningEntryLocalService.update(provisioningEntry,
			serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ProvisioningEntryLocalService getWrappedProvisioningEntryLocalService() {
		return _provisioningEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedProvisioningEntryLocalService(
		ProvisioningEntryLocalService provisioningEntryLocalService) {
		_provisioningEntryLocalService = provisioningEntryLocalService;
	}

	public ProvisioningEntryLocalService getWrappedService() {
		return _provisioningEntryLocalService;
	}

	public void setWrappedService(
		ProvisioningEntryLocalService provisioningEntryLocalService) {
		_provisioningEntryLocalService = provisioningEntryLocalService;
	}

	private ProvisioningEntryLocalService _provisioningEntryLocalService;
}