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

package com.cmc.gateway.domain.service.persistence;

import com.cmc.gateway.domain.model.ProvisioningMessage;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the provisioning message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningMessagePersistenceImpl
 * @see ProvisioningMessageUtil
 * @generated
 */
public interface ProvisioningMessagePersistence extends BasePersistence<ProvisioningMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProvisioningMessageUtil} to access the provisioning message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the provisioning message in the entity cache if it is enabled.
	*
	* @param provisioningMessage the provisioning message
	*/
	public void cacheResult(
		com.cmc.gateway.domain.model.ProvisioningMessage provisioningMessage);

	/**
	* Caches the provisioning messages in the entity cache if it is enabled.
	*
	* @param provisioningMessages the provisioning messages
	*/
	public void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> provisioningMessages);

	/**
	* Creates a new provisioning message with the primary key. Does not add the provisioning message to the database.
	*
	* @param messageId the primary key for the new provisioning message
	* @return the new provisioning message
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage create(
		long messageId);

	/**
	* Removes the provisioning message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the provisioning message
	* @return the provisioning message that was removed
	* @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a provisioning message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage remove(
		long messageId)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmc.gateway.domain.model.ProvisioningMessage updateImpl(
		com.cmc.gateway.domain.model.ProvisioningMessage provisioningMessage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning message with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningMessageException} if it could not be found.
	*
	* @param messageId the primary key of the provisioning message
	* @return the provisioning message
	* @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a provisioning message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage findByPrimaryKey(
		long messageId)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the provisioning message
	* @return the provisioning message, or <code>null</code> if a provisioning message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage fetchByPrimaryKey(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the provisioning messages where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @return the matching provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findByProvisioning(
		long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the provisioning messages where provisioningId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningId the provisioning ID
	* @param start the lower bound of the range of provisioning messages
	* @param end the upper bound of the range of provisioning messages (not inclusive)
	* @return the range of matching provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findByProvisioning(
		long provisioningId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the provisioning messages where provisioningId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningId the provisioning ID
	* @param start the lower bound of the range of provisioning messages
	* @param end the upper bound of the range of provisioning messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findByProvisioning(
		long provisioningId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning message in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning message
	* @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage findByProvisioning_First(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning message in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage fetchByProvisioning_First(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning message in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning message
	* @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage findByProvisioning_Last(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning message in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage fetchByProvisioning_Last(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning messages before and after the current provisioning message in the ordered set where provisioningId = &#63;.
	*
	* @param messageId the primary key of the current provisioning message
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next provisioning message
	* @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a provisioning message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage[] findByProvisioning_PrevAndNext(
		long messageId, long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning message where provisioningId = &#63; and responseCode = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningMessageException} if it could not be found.
	*
	* @param provisioningId the provisioning ID
	* @param responseCode the response code
	* @return the matching provisioning message
	* @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage findByResponseCode(
		long provisioningId, java.lang.String responseCode)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning message where provisioningId = &#63; and responseCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param provisioningId the provisioning ID
	* @param responseCode the response code
	* @return the matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage fetchByResponseCode(
		long provisioningId, java.lang.String responseCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning message where provisioningId = &#63; and responseCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param provisioningId the provisioning ID
	* @param responseCode the response code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage fetchByResponseCode(
		long provisioningId, java.lang.String responseCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the provisioning messages.
	*
	* @return the provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the provisioning messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of provisioning messages
	* @param end the upper bound of the range of provisioning messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the provisioning messages where provisioningId = &#63; from the database.
	*
	* @param provisioningId the provisioning ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProvisioning(long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the provisioning message where provisioningId = &#63; and responseCode = &#63; from the database.
	*
	* @param provisioningId the provisioning ID
	* @param responseCode the response code
	* @return the provisioning message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningMessage removeByResponseCode(
		long provisioningId, java.lang.String responseCode)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the provisioning messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning messages where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @return the number of matching provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByProvisioning(long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning messages where provisioningId = &#63; and responseCode = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param responseCode the response code
	* @return the number of matching provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByResponseCode(long provisioningId,
		java.lang.String responseCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning messages.
	*
	* @return the number of provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}