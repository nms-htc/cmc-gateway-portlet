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

import com.cmc.gateway.domain.model.ProductRoute;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the product route service. This utility wraps {@link ProductRoutePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductRoutePersistence
 * @see ProductRoutePersistenceImpl
 * @generated
 */
public class ProductRouteUtil {
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
	public static void clearCache(ProductRoute productRoute) {
		getPersistence().clearCache(productRoute);
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
	public static List<ProductRoute> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductRoute> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductRoute> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ProductRoute update(ProductRoute productRoute, boolean merge)
		throws SystemException {
		return getPersistence().update(productRoute, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ProductRoute update(ProductRoute productRoute, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(productRoute, merge, serviceContext);
	}

	/**
	* Caches the product route in the entity cache if it is enabled.
	*
	* @param productRoute the product route
	*/
	public static void cacheResult(
		com.cmc.gateway.domain.model.ProductRoute productRoute) {
		getPersistence().cacheResult(productRoute);
	}

	/**
	* Caches the product routes in the entity cache if it is enabled.
	*
	* @param productRoutes the product routes
	*/
	public static void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProductRoute> productRoutes) {
		getPersistence().cacheResult(productRoutes);
	}

	/**
	* Creates a new product route with the primary key. Does not add the product route to the database.
	*
	* @param routeId the primary key for the new product route
	* @return the new product route
	*/
	public static com.cmc.gateway.domain.model.ProductRoute create(long routeId) {
		return getPersistence().create(routeId);
	}

	/**
	* Removes the product route with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param routeId the primary key of the product route
	* @return the product route that was removed
	* @throws com.cmc.gateway.domain.NoSuchProductRouteException if a product route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute remove(long routeId)
		throws com.cmc.gateway.domain.NoSuchProductRouteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(routeId);
	}

	public static com.cmc.gateway.domain.model.ProductRoute updateImpl(
		com.cmc.gateway.domain.model.ProductRoute productRoute, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(productRoute, merge);
	}

	/**
	* Returns the product route with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductRouteException} if it could not be found.
	*
	* @param routeId the primary key of the product route
	* @return the product route
	* @throws com.cmc.gateway.domain.NoSuchProductRouteException if a product route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute findByPrimaryKey(
		long routeId)
		throws com.cmc.gateway.domain.NoSuchProductRouteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(routeId);
	}

	/**
	* Returns the product route with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param routeId the primary key of the product route
	* @return the product route, or <code>null</code> if a product route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute fetchByPrimaryKey(
		long routeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(routeId);
	}

	/**
	* Returns all the product routes where productId = &#63;.
	*
	* @param productId the product ID
	* @return the matching product routes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductRoute> findByProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct(productId);
	}

	/**
	* Returns a range of all the product routes where productId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productId the product ID
	* @param start the lower bound of the range of product routes
	* @param end the upper bound of the range of product routes (not inclusive)
	* @return the range of matching product routes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductRoute> findByProduct(
		long productId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct(productId, start, end);
	}

	/**
	* Returns an ordered range of all the product routes where productId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productId the product ID
	* @param start the lower bound of the range of product routes
	* @param end the upper bound of the range of product routes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching product routes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductRoute> findByProduct(
		long productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProduct(productId, start, end, orderByComparator);
	}

	/**
	* Returns the first product route in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product route
	* @throws com.cmc.gateway.domain.NoSuchProductRouteException if a matching product route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute findByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductRouteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct_First(productId, orderByComparator);
	}

	/**
	* Returns the first product route in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product route, or <code>null</code> if a matching product route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute fetchByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProduct_First(productId, orderByComparator);
	}

	/**
	* Returns the last product route in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product route
	* @throws com.cmc.gateway.domain.NoSuchProductRouteException if a matching product route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute findByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductRouteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct_Last(productId, orderByComparator);
	}

	/**
	* Returns the last product route in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product route, or <code>null</code> if a matching product route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute fetchByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByProduct_Last(productId, orderByComparator);
	}

	/**
	* Returns the product routes before and after the current product route in the ordered set where productId = &#63;.
	*
	* @param routeId the primary key of the current product route
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product route
	* @throws com.cmc.gateway.domain.NoSuchProductRouteException if a product route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute[] findByProduct_PrevAndNext(
		long routeId, long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductRouteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProduct_PrevAndNext(routeId, productId,
			orderByComparator);
	}

	/**
	* Returns the product route where productId = &#63; and channel = &#63; and serviceAddress = &#63; and keyword = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProductRouteException} if it could not be found.
	*
	* @param productId the product ID
	* @param channel the channel
	* @param serviceAddress the service address
	* @param keyword the keyword
	* @return the matching product route
	* @throws com.cmc.gateway.domain.NoSuchProductRouteException if a matching product route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute findByRoute(
		long productId, java.lang.String channel,
		java.lang.String serviceAddress, java.lang.String keyword)
		throws com.cmc.gateway.domain.NoSuchProductRouteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoute(productId, channel, serviceAddress, keyword);
	}

	/**
	* Returns the product route where productId = &#63; and channel = &#63; and serviceAddress = &#63; and keyword = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param productId the product ID
	* @param channel the channel
	* @param serviceAddress the service address
	* @param keyword the keyword
	* @return the matching product route, or <code>null</code> if a matching product route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute fetchByRoute(
		long productId, java.lang.String channel,
		java.lang.String serviceAddress, java.lang.String keyword)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoute(productId, channel, serviceAddress, keyword);
	}

	/**
	* Returns the product route where productId = &#63; and channel = &#63; and serviceAddress = &#63; and keyword = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param productId the product ID
	* @param channel the channel
	* @param serviceAddress the service address
	* @param keyword the keyword
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching product route, or <code>null</code> if a matching product route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute fetchByRoute(
		long productId, java.lang.String channel,
		java.lang.String serviceAddress, java.lang.String keyword,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRoute(productId, channel, serviceAddress, keyword,
			retrieveFromCache);
	}

	/**
	* Returns all the product routes.
	*
	* @return the product routes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductRoute> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the product routes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product routes
	* @param end the upper bound of the range of product routes (not inclusive)
	* @return the range of product routes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductRoute> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the product routes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product routes
	* @param end the upper bound of the range of product routes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of product routes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductRoute> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the product routes where productId = &#63; from the database.
	*
	* @param productId the product ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProduct(productId);
	}

	/**
	* Removes the product route where productId = &#63; and channel = &#63; and serviceAddress = &#63; and keyword = &#63; from the database.
	*
	* @param productId the product ID
	* @param channel the channel
	* @param serviceAddress the service address
	* @param keyword the keyword
	* @return the product route that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductRoute removeByRoute(
		long productId, java.lang.String channel,
		java.lang.String serviceAddress, java.lang.String keyword)
		throws com.cmc.gateway.domain.NoSuchProductRouteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByRoute(productId, channel, serviceAddress, keyword);
	}

	/**
	* Removes all the product routes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of product routes where productId = &#63;.
	*
	* @param productId the product ID
	* @return the number of matching product routes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProduct(productId);
	}

	/**
	* Returns the number of product routes where productId = &#63; and channel = &#63; and serviceAddress = &#63; and keyword = &#63;.
	*
	* @param productId the product ID
	* @param channel the channel
	* @param serviceAddress the service address
	* @param keyword the keyword
	* @return the number of matching product routes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoute(long productId, java.lang.String channel,
		java.lang.String serviceAddress, java.lang.String keyword)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByRoute(productId, channel, serviceAddress, keyword);
	}

	/**
	* Returns the number of product routes.
	*
	* @return the number of product routes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProductRoutePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProductRoutePersistence)PortletBeanLocatorUtil.locate(com.cmc.gateway.domain.service.ClpSerializer.getServletContextName(),
					ProductRoutePersistence.class.getName());

			ReferenceRegistry.registerReference(ProductRouteUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ProductRoutePersistence persistence) {
	}

	private static ProductRoutePersistence _persistence;
}