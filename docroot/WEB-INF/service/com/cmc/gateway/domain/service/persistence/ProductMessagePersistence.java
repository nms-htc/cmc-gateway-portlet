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

import com.cmc.gateway.domain.model.ProductMessage;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the product message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductMessagePersistenceImpl
 * @see ProductMessageUtil
 * @generated
 */
public interface ProductMessagePersistence extends BasePersistence<ProductMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductMessageUtil} to access the product message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the product message in the entity cache if it is enabled.
	*
	* @param productMessage the product message
	*/
	public void cacheResult(
		com.cmc.gateway.domain.model.ProductMessage productMessage);

	/**
	* Caches the product messages in the entity cache if it is enabled.
	*
	* @param productMessages the product messages
	*/
	public void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProductMessage> productMessages);

	/**
	* Creates a new product message with the primary key. Does not add the product message to the database.
	*
	* @param messageId the primary key for the new product message
	* @return the new product message
	*/
	public com.cmc.gateway.domain.model.ProductMessage create(long messageId);

	/**
	* Removes the product message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the product message
	* @return the product message that was removed
	* @throws com.cmc.gateway.domain.NoSuchProductMessageException if a product message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage remove(long messageId)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmc.gateway.domain.model.ProductMessage updateImpl(
		com.cmc.gateway.domain.model.ProductMessage productMessage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product message with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductMessageException} if it could not be found.
	*
	* @param messageId the primary key of the product message
	* @return the product message
	* @throws com.cmc.gateway.domain.NoSuchProductMessageException if a product message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage findByPrimaryKey(
		long messageId)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the product message
	* @return the product message, or <code>null</code> if a product message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage fetchByPrimaryKey(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the product messages where productId = &#63;.
	*
	* @param productId the product ID
	* @return the matching product messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductMessage> findByProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the product messages where productId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productId the product ID
	* @param start the lower bound of the range of product messages
	* @param end the upper bound of the range of product messages (not inclusive)
	* @return the range of matching product messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductMessage> findByProduct(
		long productId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the product messages where productId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productId the product ID
	* @param start the lower bound of the range of product messages
	* @param end the upper bound of the range of product messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching product messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductMessage> findByProduct(
		long productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product message in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product message
	* @throws com.cmc.gateway.domain.NoSuchProductMessageException if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage findByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product message in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product message, or <code>null</code> if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage fetchByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product message in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product message
	* @throws com.cmc.gateway.domain.NoSuchProductMessageException if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage findByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product message in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product message, or <code>null</code> if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage fetchByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product messages before and after the current product message in the ordered set where productId = &#63;.
	*
	* @param messageId the primary key of the current product message
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product message
	* @throws com.cmc.gateway.domain.NoSuchProductMessageException if a product message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage[] findByProduct_PrevAndNext(
		long messageId, long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product message where productId = &#63; and actionType = &#63; and channel = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProductMessageException} if it could not be found.
	*
	* @param productId the product ID
	* @param actionType the action type
	* @param channel the channel
	* @return the matching product message
	* @throws com.cmc.gateway.domain.NoSuchProductMessageException if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage findByMessage(
		long productId, java.lang.String actionType, java.lang.String channel)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product message where productId = &#63; and actionType = &#63; and channel = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param productId the product ID
	* @param actionType the action type
	* @param channel the channel
	* @return the matching product message, or <code>null</code> if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage fetchByMessage(
		long productId, java.lang.String actionType, java.lang.String channel)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product message where productId = &#63; and actionType = &#63; and channel = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param productId the product ID
	* @param actionType the action type
	* @param channel the channel
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching product message, or <code>null</code> if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage fetchByMessage(
		long productId, java.lang.String actionType, java.lang.String channel,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the product messages.
	*
	* @return the product messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the product messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product messages
	* @param end the upper bound of the range of product messages (not inclusive)
	* @return the range of product messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the product messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product messages
	* @param end the upper bound of the range of product messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of product messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the product messages where productId = &#63; from the database.
	*
	* @param productId the product ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the product message where productId = &#63; and actionType = &#63; and channel = &#63; from the database.
	*
	* @param productId the product ID
	* @param actionType the action type
	* @param channel the channel
	* @return the product message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage removeByMessage(
		long productId, java.lang.String actionType, java.lang.String channel)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the product messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of product messages where productId = &#63;.
	*
	* @param productId the product ID
	* @return the number of matching product messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of product messages where productId = &#63; and actionType = &#63; and channel = &#63;.
	*
	* @param productId the product ID
	* @param actionType the action type
	* @param channel the channel
	* @return the number of matching product messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByMessage(long productId, java.lang.String actionType,
		java.lang.String channel)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of product messages.
	*
	* @return the number of product messages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}