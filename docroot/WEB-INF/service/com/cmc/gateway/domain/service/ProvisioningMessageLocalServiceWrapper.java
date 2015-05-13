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
 * This class is a wrapper for {@link ProvisioningMessageLocalService}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProvisioningMessageLocalService
 * @generated
 */
public class ProvisioningMessageLocalServiceWrapper
	implements ProvisioningMessageLocalService,
		ServiceWrapper<ProvisioningMessageLocalService> {
	public ProvisioningMessageLocalServiceWrapper(
		ProvisioningMessageLocalService provisioningMessageLocalService) {
		_provisioningMessageLocalService = provisioningMessageLocalService;
	}

	/**
	* Adds the provisioning message to the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningMessage the provisioning message
	* @return the provisioning message that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage addProvisioningMessage(
		com.cmc.gateway.domain.model.ProvisioningMessage provisioningMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningMessageLocalService.addProvisioningMessage(provisioningMessage);
	}

	/**
	* Creates a new provisioning message with the primary key. Does not add the provisioning message to the database.
	*
	* @param messageId the primary key for the new provisioning message
	* @return the new provisioning message
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage createProvisioningMessage(
		long messageId) {
		return _provisioningMessageLocalService.createProvisioningMessage(messageId);
	}

	/**
	* Deletes the provisioning message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the provisioning message
	* @return the provisioning message that was removed
	* @throws PortalException if a provisioning message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage deleteProvisioningMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningMessageLocalService.deleteProvisioningMessage(messageId);
	}

	/**
	* Deletes the provisioning message from the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningMessage the provisioning message
	* @return the provisioning message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage deleteProvisioningMessage(
		com.cmc.gateway.domain.model.ProvisioningMessage provisioningMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningMessageLocalService.deleteProvisioningMessage(provisioningMessage);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _provisioningMessageLocalService.dynamicQuery();
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
		return _provisioningMessageLocalService.dynamicQuery(dynamicQuery);
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
		return _provisioningMessageLocalService.dynamicQuery(dynamicQuery,
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
		return _provisioningMessageLocalService.dynamicQuery(dynamicQuery,
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
		return _provisioningMessageLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cmc.gateway.domain.model.ProvisioningMessage fetchProvisioningMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningMessageLocalService.fetchProvisioningMessage(messageId);
	}

	/**
	* Returns the provisioning message with the primary key.
	*
	* @param messageId the primary key of the provisioning message
	* @return the provisioning message
	* @throws PortalException if a provisioning message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage getProvisioningMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningMessageLocalService.getProvisioningMessage(messageId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _provisioningMessageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the provisioning messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of provisioning messages
	* @param end the upper bound of the range of provisioning messages (not inclusive)
	* @return the range of provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> getProvisioningMessages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningMessageLocalService.getProvisioningMessages(start,
			end);
	}

	/**
	* Returns the number of provisioning messages.
	*
	* @return the number of provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public int getProvisioningMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningMessageLocalService.getProvisioningMessagesCount();
	}

	/**
	* Updates the provisioning message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param provisioningMessage the provisioning message
	* @return the provisioning message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage updateProvisioningMessage(
		com.cmc.gateway.domain.model.ProvisioningMessage provisioningMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningMessageLocalService.updateProvisioningMessage(provisioningMessage);
	}

	/**
	* Updates the provisioning message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param provisioningMessage the provisioning message
	* @param merge whether to merge the provisioning message with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the provisioning message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage updateProvisioningMessage(
		com.cmc.gateway.domain.model.ProvisioningMessage provisioningMessage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _provisioningMessageLocalService.updateProvisioningMessage(provisioningMessage,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _provisioningMessageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_provisioningMessageLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _provisioningMessageLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ProvisioningMessageLocalService getWrappedProvisioningMessageLocalService() {
		return _provisioningMessageLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedProvisioningMessageLocalService(
		ProvisioningMessageLocalService provisioningMessageLocalService) {
		_provisioningMessageLocalService = provisioningMessageLocalService;
	}

	public ProvisioningMessageLocalService getWrappedService() {
		return _provisioningMessageLocalService;
	}

	public void setWrappedService(
		ProvisioningMessageLocalService provisioningMessageLocalService) {
		_provisioningMessageLocalService = provisioningMessageLocalService;
	}

	private ProvisioningMessageLocalService _provisioningMessageLocalService;
}