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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the product message service. This utility wraps {@link ProductMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductMessagePersistence
 * @see ProductMessagePersistenceImpl
 * @generated
 */
public class ProductMessageUtil {
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
	public static void clearCache(ProductMessage productMessage) {
		getPersistence().clearCache(productMessage);
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
	public static List<ProductMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ProductMessage update(ProductMessage productMessage,
		boolean merge) throws SystemException {
		return getPersistence().update(productMessage, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ProductMessage update(ProductMessage productMessage,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(productMessage, merge, serviceContext);
	}

	/**
	* Caches the product message in the entity cache if it is enabled.
	*
	* @param productMessage the product message
	*/
	public static void cacheResult(
		com.cmc.gateway.domain.model.ProductMessage productMessage) {
		getPersistence().cacheResult(productMessage);
	}

	/**
	* Caches the product messages in the entity cache if it is enabled.
	*
	* @param productMessages the product messages
	*/
	public static void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProductMessage> productMessages) {
		getPersistence().cacheResult(productMessages);
	}

	/**
	* Creates a new product message with the primary key. Does not add the product message to the database.
	*
	* @param messageId the primary key for the new product message
	* @return the new product message
	*/
	public static com.cmc.gateway.domain.model.ProductMessage create(
		long messageId) {
		return getPersistence().create(messageId);
	}

	/**
	* Removes the product message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the product message
	* @return the product message that was removed
	* @throws com.cmc.gateway.domain.NoSuchProductMessageException if a product message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductMessage remove(
		long messageId)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(messageId);
	}

	public static com.cmc.gateway.domain.model.ProductMessage updateImpl(
		com.cmc.gateway.domain.model.ProductMessage productMessage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(productMessage, merge);
	}

	/**
	* Returns the product message with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductMessageException} if it could not be found.
	*
	* @param messageId the primary key of the product message
	* @return the product message
	* @throws com.cmc.gateway.domain.NoSuchProductMessageException if a product message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductMessage findByPrimaryKey(
		long messageId)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(messageId);
	}

	/**
	* Returns the product message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the product message
	* @return the product message, or <code>null</code> if a product message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductMessage fetchByPrimaryKey(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(messageId);
	}

	/**
	* Returns all the product messages where productId = &#63;.
	*
	* @param productId the product ID
	* @return the matching product messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductMessage> findByProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct(productId);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProductMessage> findByProduct(
		long productId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct(productId, start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProductMessage> findByProduct(
		long productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProduct(productId, start, end, orderByComparator);
	}

	/**
	* Returns the first product message in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product message
	* @throws com.cmc.gateway.domain.NoSuchProductMessageException if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductMessage findByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct_First(productId, orderByComparator);
	}

	/**
	* Returns the first product message in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product message, or <code>null</code> if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductMessage fetchByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProduct_First(productId, orderByComparator);
	}

	/**
	* Returns the last product message in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product message
	* @throws com.cmc.gateway.domain.NoSuchProductMessageException if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductMessage findByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct_Last(productId, orderByComparator);
	}

	/**
	* Returns the last product message in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product message, or <code>null</code> if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductMessage fetchByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByProduct_Last(productId, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.ProductMessage[] findByProduct_PrevAndNext(
		long messageId, long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProduct_PrevAndNext(messageId, productId,
			orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.ProductMessage findByMessage(
		long productId, java.lang.String actionType, java.lang.String channel)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMessage(productId, actionType, channel);
	}

	/**
	* Returns the product message where productId = &#63; and actionType = &#63; and channel = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param productId the product ID
	* @param actionType the action type
	* @param channel the channel
	* @return the matching product message, or <code>null</code> if a matching product message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductMessage fetchByMessage(
		long productId, java.lang.String actionType, java.lang.String channel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMessage(productId, actionType, channel);
	}

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
	public static com.cmc.gateway.domain.model.ProductMessage fetchByMessage(
		long productId, java.lang.String actionType, java.lang.String channel,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMessage(productId, actionType, channel,
			retrieveFromCache);
	}

	/**
	* Returns all the product messages.
	*
	* @return the product messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProductMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProductMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the product messages where productId = &#63; from the database.
	*
	* @param productId the product ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProduct(productId);
	}

	/**
	* Removes the product message where productId = &#63; and actionType = &#63; and channel = &#63; from the database.
	*
	* @param productId the product ID
	* @param actionType the action type
	* @param channel the channel
	* @return the product message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductMessage removeByMessage(
		long productId, java.lang.String actionType, java.lang.String channel)
		throws com.cmc.gateway.domain.NoSuchProductMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByMessage(productId, actionType, channel);
	}

	/**
	* Removes all the product messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of product messages where productId = &#63;.
	*
	* @param productId the product ID
	* @return the number of matching product messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProduct(productId);
	}

	/**
	* Returns the number of product messages where productId = &#63; and actionType = &#63; and channel = &#63;.
	*
	* @param productId the product ID
	* @param actionType the action type
	* @param channel the channel
	* @return the number of matching product messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMessage(long productId,
		java.lang.String actionType, java.lang.String channel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMessage(productId, actionType, channel);
	}

	/**
	* Returns the number of product messages.
	*
	* @return the number of product messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProductMessagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProductMessagePersistence)PortletBeanLocatorUtil.locate(com.cmc.gateway.domain.service.ClpSerializer.getServletContextName(),
					ProductMessagePersistence.class.getName());

			ReferenceRegistry.registerReference(ProductMessageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ProductMessagePersistence persistence) {
	}

	private static ProductMessagePersistence _persistence;
}