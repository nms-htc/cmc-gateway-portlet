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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the product action service. This utility wraps {@link ProductActionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductActionPersistence
 * @see ProductActionPersistenceImpl
 * @generated
 */
public class ProductActionUtil {
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
	public static void clearCache(ProductAction productAction) {
		getPersistence().clearCache(productAction);
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
	public static List<ProductAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ProductAction update(ProductAction productAction,
		boolean merge) throws SystemException {
		return getPersistence().update(productAction, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ProductAction update(ProductAction productAction,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(productAction, merge, serviceContext);
	}

	/**
	* Caches the product action in the entity cache if it is enabled.
	*
	* @param productAction the product action
	*/
	public static void cacheResult(
		com.cmc.gateway.domain.model.ProductAction productAction) {
		getPersistence().cacheResult(productAction);
	}

	/**
	* Caches the product actions in the entity cache if it is enabled.
	*
	* @param productActions the product actions
	*/
	public static void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProductAction> productActions) {
		getPersistence().cacheResult(productActions);
	}

	/**
	* Creates a new product action with the primary key. Does not add the product action to the database.
	*
	* @param actionId the primary key for the new product action
	* @return the new product action
	*/
	public static com.cmc.gateway.domain.model.ProductAction create(
		long actionId) {
		return getPersistence().create(actionId);
	}

	/**
	* Removes the product action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the product action
	* @return the product action that was removed
	* @throws com.cmc.gateway.domain.NoSuchProductActionException if a product action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductAction remove(
		long actionId)
		throws com.cmc.gateway.domain.NoSuchProductActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(actionId);
	}

	public static com.cmc.gateway.domain.model.ProductAction updateImpl(
		com.cmc.gateway.domain.model.ProductAction productAction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(productAction, merge);
	}

	/**
	* Returns the product action with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductActionException} if it could not be found.
	*
	* @param actionId the primary key of the product action
	* @return the product action
	* @throws com.cmc.gateway.domain.NoSuchProductActionException if a product action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductAction findByPrimaryKey(
		long actionId)
		throws com.cmc.gateway.domain.NoSuchProductActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(actionId);
	}

	/**
	* Returns the product action with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param actionId the primary key of the product action
	* @return the product action, or <code>null</code> if a product action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductAction fetchByPrimaryKey(
		long actionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(actionId);
	}

	/**
	* Returns all the product actions where productId = &#63;.
	*
	* @param productId the product ID
	* @return the matching product actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductAction> findByProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct(productId);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProductAction> findByProduct(
		long productId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct(productId, start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProductAction> findByProduct(
		long productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProduct(productId, start, end, orderByComparator);
	}

	/**
	* Returns the first product action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product action
	* @throws com.cmc.gateway.domain.NoSuchProductActionException if a matching product action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductAction findByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct_First(productId, orderByComparator);
	}

	/**
	* Returns the first product action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product action, or <code>null</code> if a matching product action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductAction fetchByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProduct_First(productId, orderByComparator);
	}

	/**
	* Returns the last product action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product action
	* @throws com.cmc.gateway.domain.NoSuchProductActionException if a matching product action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductAction findByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct_Last(productId, orderByComparator);
	}

	/**
	* Returns the last product action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product action, or <code>null</code> if a matching product action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductAction fetchByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByProduct_Last(productId, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.ProductAction[] findByProduct_PrevAndNext(
		long actionId, long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProduct_PrevAndNext(actionId, productId,
			orderByComparator);
	}

	/**
	* Returns all the product actions.
	*
	* @return the product actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductAction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProductAction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProductAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the product actions where productId = &#63; from the database.
	*
	* @param productId the product ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProduct(productId);
	}

	/**
	* Removes all the product actions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of product actions where productId = &#63;.
	*
	* @param productId the product ID
	* @return the number of matching product actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProduct(productId);
	}

	/**
	* Returns the number of product actions.
	*
	* @return the number of product actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProductActionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProductActionPersistence)PortletBeanLocatorUtil.locate(com.cmc.gateway.domain.service.ClpSerializer.getServletContextName(),
					ProductActionPersistence.class.getName());

			ReferenceRegistry.registerReference(ProductActionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ProductActionPersistence persistence) {
	}

	private static ProductActionPersistence _persistence;
}