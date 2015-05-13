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

import com.cmc.gateway.domain.model.ProductAction;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the product action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductActionPersistenceImpl
 * @see ProductActionUtil
 * @generated
 */
public interface ProductActionPersistence extends BasePersistence<ProductAction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductActionUtil} to access the product action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the product action in the entity cache if it is enabled.
	*
	* @param productAction the product action
	*/
	public void cacheResult(
		com.cmc.gateway.domain.model.ProductAction productAction);

	/**
	* Caches the product actions in the entity cache if it is enabled.
	*
	* @param productActions the product actions
	*/
	public void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProductAction> productActions);

	/**
	* Creates a new product action with the primary key. Does not add the product action to the database.
	*
	* @param actionId the primary key for the new product action
	* @return the new product action
	*/
	public com.cmc.gateway.domain.model.ProductAction create(long actionId);

	/**
	* Removes the product action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the product action
	* @return the product action that was removed
	* @throws com.cmc.gateway.domain.NoSuchProductActionException if a product action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductAction remove(long actionId)
		throws com.cmc.gateway.domain.NoSuchProductActionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmc.gateway.domain.model.ProductAction updateImpl(
		com.cmc.gateway.domain.model.ProductAction productAction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product action with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductActionException} if it could not be found.
	*
	* @param actionId the primary key of the product action
	* @return the product action
	* @throws com.cmc.gateway.domain.NoSuchProductActionException if a product action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductAction findByPrimaryKey(
		long actionId)
		throws com.cmc.gateway.domain.NoSuchProductActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product action with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param actionId the primary key of the product action
	* @return the product action, or <code>null</code> if a product action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductAction fetchByPrimaryKey(
		long actionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the product actions where productId = &#63;.
	*
	* @param productId the product ID
	* @return the matching product actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductAction> findByProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the product actions where productId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productId the product ID
	* @param start the lower bound of the range of product actions
	* @param end the upper bound of the range of product actions (not inclusive)
	* @return the range of matching product actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductAction> findByProduct(
		long productId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the product actions where productId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productId the product ID
	* @param start the lower bound of the range of product actions
	* @param end the upper bound of the range of product actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching product actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductAction> findByProduct(
		long productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product action
	* @throws com.cmc.gateway.domain.NoSuchProductActionException if a matching product action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductAction findByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product action, or <code>null</code> if a matching product action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductAction fetchByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product action
	* @throws com.cmc.gateway.domain.NoSuchProductActionException if a matching product action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductAction findByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product action, or <code>null</code> if a matching product action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductAction fetchByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product actions before and after the current product action in the ordered set where productId = &#63;.
	*
	* @param actionId the primary key of the current product action
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product action
	* @throws com.cmc.gateway.domain.NoSuchProductActionException if a product action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductAction[] findByProduct_PrevAndNext(
		long actionId, long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the product actions.
	*
	* @return the product actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductAction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the product actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product actions
	* @param end the upper bound of the range of product actions (not inclusive)
	* @return the range of product actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductAction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the product actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product actions
	* @param end the upper bound of the range of product actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of product actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the product actions where productId = &#63; from the database.
	*
	* @param productId the product ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the product actions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of product actions where productId = &#63;.
	*
	* @param productId the product ID
	* @return the number of matching product actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of product actions.
	*
	* @return the number of product actions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}