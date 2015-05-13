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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the provisioning message service. This utility wraps {@link ProvisioningMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningMessagePersistence
 * @see ProvisioningMessagePersistenceImpl
 * @generated
 */
public class ProvisioningMessageUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ProvisioningMessage provisioningMessage) {
		getPersistence().clearCache(provisioningMessage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProvisioningMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProvisioningMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProvisioningMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ProvisioningMessage update(
		ProvisioningMessage provisioningMessage, boolean merge)
		throws SystemException {
		return getPersistence().update(provisioningMessage, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ProvisioningMessage update(
		ProvisioningMessage provisioningMessage, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(provisioningMessage, merge, serviceContext);
	}

	/**
	* Caches the provisioning message in the entity cache if it is enabled.
	*
	* @param provisioningMessage the provisioning message
	*/
	public static void cacheResult(
		com.cmc.gateway.domain.model.ProvisioningMessage provisioningMessage) {
		getPersistence().cacheResult(provisioningMessage);
	}

	/**
	* Caches the provisioning messages in the entity cache if it is enabled.
	*
	* @param provisioningMessages the provisioning messages
	*/
	public static void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> provisioningMessages) {
		getPersistence().cacheResult(provisioningMessages);
	}

	/**
	* Creates a new provisioning message with the primary key. Does not add the provisioning message to the database.
	*
	* @param messageId the primary key for the new provisioning message
	* @return the new provisioning message
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage create(
		long messageId) {
		return getPersistence().create(messageId);
	}

	/**
	* Removes the provisioning message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the provisioning message
	* @return the provisioning message that was removed
	* @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a provisioning message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage remove(
		long messageId)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(messageId);
	}

	public static com.cmc.gateway.domain.model.ProvisioningMessage updateImpl(
		com.cmc.gateway.domain.model.ProvisioningMessage provisioningMessage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(provisioningMessage, merge);
	}

	/**
	* Returns the provisioning message with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningMessageException} if it could not be found.
	*
	* @param messageId the primary key of the provisioning message
	* @return the provisioning message
	* @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a provisioning message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage findByPrimaryKey(
		long messageId)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(messageId);
	}

	/**
	* Returns the provisioning message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the provisioning message
	* @return the provisioning message, or <code>null</code> if a provisioning message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage fetchByPrimaryKey(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(messageId);
	}

	/**
	* Returns all the provisioning messages where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @return the matching provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findByProvisioning(
		long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProvisioning(provisioningId);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findByProvisioning(
		long provisioningId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProvisioning(provisioningId, start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findByProvisioning(
		long provisioningId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProvisioning(provisioningId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first provisioning message in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning message
	* @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage findByProvisioning_First(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProvisioning_First(provisioningId, orderByComparator);
	}

	/**
	* Returns the first provisioning message in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage fetchByProvisioning_First(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProvisioning_First(provisioningId, orderByComparator);
	}

	/**
	* Returns the last provisioning message in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning message
	* @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage findByProvisioning_Last(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProvisioning_Last(provisioningId, orderByComparator);
	}

	/**
	* Returns the last provisioning message in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage fetchByProvisioning_Last(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProvisioning_Last(provisioningId, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.ProvisioningMessage[] findByProvisioning_PrevAndNext(
		long messageId, long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProvisioning_PrevAndNext(messageId, provisioningId,
			orderByComparator);
	}

	/**
	* Returns the provisioning message where provisioningId = &#63; and responseCode = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningMessageException} if it could not be found.
	*
	* @param provisioningId the provisioning ID
	* @param responseCode the response code
	* @return the matching provisioning message
	* @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage findByResponseCode(
		long provisioningId, java.lang.String responseCode)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByResponseCode(provisioningId, responseCode);
	}

	/**
	* Returns the provisioning message where provisioningId = &#63; and responseCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param provisioningId the provisioning ID
	* @param responseCode the response code
	* @return the matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage fetchByResponseCode(
		long provisioningId, java.lang.String responseCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByResponseCode(provisioningId, responseCode);
	}

	/**
	* Returns the provisioning message where provisioningId = &#63; and responseCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param provisioningId the provisioning ID
	* @param responseCode the response code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage fetchByResponseCode(
		long provisioningId, java.lang.String responseCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResponseCode(provisioningId, responseCode,
			retrieveFromCache);
	}

	/**
	* Returns all the provisioning messages.
	*
	* @return the provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the provisioning messages where provisioningId = &#63; from the database.
	*
	* @param provisioningId the provisioning ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProvisioning(long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProvisioning(provisioningId);
	}

	/**
	* Removes the provisioning message where provisioningId = &#63; and responseCode = &#63; from the database.
	*
	* @param provisioningId the provisioning ID
	* @param responseCode the response code
	* @return the provisioning message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningMessage removeByResponseCode(
		long provisioningId, java.lang.String responseCode)
		throws com.cmc.gateway.domain.NoSuchProvisioningMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByResponseCode(provisioningId, responseCode);
	}

	/**
	* Removes all the provisioning messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of provisioning messages where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @return the number of matching provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProvisioning(long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProvisioning(provisioningId);
	}

	/**
	* Returns the number of provisioning messages where provisioningId = &#63; and responseCode = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param responseCode the response code
	* @return the number of matching provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResponseCode(long provisioningId,
		java.lang.String responseCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByResponseCode(provisioningId, responseCode);
	}

	/**
	* Returns the number of provisioning messages.
	*
	* @return the number of provisioning messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProvisioningMessagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProvisioningMessagePersistence)PortletBeanLocatorUtil.locate(com.cmc.gateway.domain.service.ClpSerializer.getServletContextName(),
					ProvisioningMessagePersistence.class.getName());

			ReferenceRegistry.registerReference(ProvisioningMessageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ProvisioningMessagePersistence persistence) {
	}

	private static ProvisioningMessagePersistence _persistence;
}