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

import com.cmc.gateway.domain.model.ProvisioningRoute;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the provisioning route service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningRoutePersistenceImpl
 * @see ProvisioningRouteUtil
 * @generated
 */
public interface ProvisioningRoutePersistence extends BasePersistence<ProvisioningRoute> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProvisioningRouteUtil} to access the provisioning route persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the provisioning route in the entity cache if it is enabled.
	*
	* @param provisioningRoute the provisioning route
	*/
	public void cacheResult(
		com.cmc.gateway.domain.model.ProvisioningRoute provisioningRoute);

	/**
	* Caches the provisioning routes in the entity cache if it is enabled.
	*
	* @param provisioningRoutes the provisioning routes
	*/
	public void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProvisioningRoute> provisioningRoutes);

	/**
	* Creates a new provisioning route with the primary key. Does not add the provisioning route to the database.
	*
	* @param routeId the primary key for the new provisioning route
	* @return the new provisioning route
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute create(long routeId);

	/**
	* Removes the provisioning route with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param routeId the primary key of the provisioning route
	* @return the provisioning route that was removed
	* @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a provisioning route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute remove(long routeId)
		throws com.cmc.gateway.domain.NoSuchProvisioningRouteException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmc.gateway.domain.model.ProvisioningRoute updateImpl(
		com.cmc.gateway.domain.model.ProvisioningRoute provisioningRoute,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning route with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningRouteException} if it could not be found.
	*
	* @param routeId the primary key of the provisioning route
	* @return the provisioning route
	* @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a provisioning route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute findByPrimaryKey(
		long routeId)
		throws com.cmc.gateway.domain.NoSuchProvisioningRouteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning route with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param routeId the primary key of the provisioning route
	* @return the provisioning route, or <code>null</code> if a provisioning route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute fetchByPrimaryKey(
		long routeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the provisioning routes where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param routeType the route type
	* @param routeKey the route key
	* @return the matching provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningRoute> findByRoute(
		java.lang.String provisioningType, java.lang.String routeType,
		java.lang.String routeKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the provisioning routes where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningType the provisioning type
	* @param routeType the route type
	* @param routeKey the route key
	* @param start the lower bound of the range of provisioning routes
	* @param end the upper bound of the range of provisioning routes (not inclusive)
	* @return the range of matching provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningRoute> findByRoute(
		java.lang.String provisioningType, java.lang.String routeType,
		java.lang.String routeKey, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the provisioning routes where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningType the provisioning type
	* @param routeType the route type
	* @param routeKey the route key
	* @param start the lower bound of the range of provisioning routes
	* @param end the upper bound of the range of provisioning routes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningRoute> findByRoute(
		java.lang.String provisioningType, java.lang.String routeType,
		java.lang.String routeKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning route in the ordered set where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param routeType the route type
	* @param routeKey the route key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning route
	* @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a matching provisioning route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute findByRoute_First(
		java.lang.String provisioningType, java.lang.String routeType,
		java.lang.String routeKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningRouteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning route in the ordered set where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param routeType the route type
	* @param routeKey the route key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning route, or <code>null</code> if a matching provisioning route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute fetchByRoute_First(
		java.lang.String provisioningType, java.lang.String routeType,
		java.lang.String routeKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning route in the ordered set where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param routeType the route type
	* @param routeKey the route key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning route
	* @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a matching provisioning route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute findByRoute_Last(
		java.lang.String provisioningType, java.lang.String routeType,
		java.lang.String routeKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningRouteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning route in the ordered set where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param routeType the route type
	* @param routeKey the route key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning route, or <code>null</code> if a matching provisioning route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute fetchByRoute_Last(
		java.lang.String provisioningType, java.lang.String routeType,
		java.lang.String routeKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning routes before and after the current provisioning route in the ordered set where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	*
	* @param routeId the primary key of the current provisioning route
	* @param provisioningType the provisioning type
	* @param routeType the route type
	* @param routeKey the route key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next provisioning route
	* @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a provisioning route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute[] findByRoute_PrevAndNext(
		long routeId, java.lang.String provisioningType,
		java.lang.String routeType, java.lang.String routeKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningRouteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the provisioning routes where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @return the matching provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningRoute> findByProvisioning(
		long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the provisioning routes where provisioningId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningId the provisioning ID
	* @param start the lower bound of the range of provisioning routes
	* @param end the upper bound of the range of provisioning routes (not inclusive)
	* @return the range of matching provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningRoute> findByProvisioning(
		long provisioningId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the provisioning routes where provisioningId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningId the provisioning ID
	* @param start the lower bound of the range of provisioning routes
	* @param end the upper bound of the range of provisioning routes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningRoute> findByProvisioning(
		long provisioningId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning route in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning route
	* @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a matching provisioning route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute findByProvisioning_First(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningRouteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning route in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning route, or <code>null</code> if a matching provisioning route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute fetchByProvisioning_First(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning route in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning route
	* @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a matching provisioning route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute findByProvisioning_Last(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningRouteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning route in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning route, or <code>null</code> if a matching provisioning route could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute fetchByProvisioning_Last(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning routes before and after the current provisioning route in the ordered set where provisioningId = &#63;.
	*
	* @param routeId the primary key of the current provisioning route
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next provisioning route
	* @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a provisioning route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningRoute[] findByProvisioning_PrevAndNext(
		long routeId, long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningRouteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the provisioning routes.
	*
	* @return the provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningRoute> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the provisioning routes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of provisioning routes
	* @param end the upper bound of the range of provisioning routes (not inclusive)
	* @return the range of provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningRoute> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the provisioning routes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of provisioning routes
	* @param end the upper bound of the range of provisioning routes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningRoute> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the provisioning routes where provisioningType = &#63; and routeType = &#63; and routeKey = &#63; from the database.
	*
	* @param provisioningType the provisioning type
	* @param routeType the route type
	* @param routeKey the route key
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRoute(java.lang.String provisioningType,
		java.lang.String routeType, java.lang.String routeKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the provisioning routes where provisioningId = &#63; from the database.
	*
	* @param provisioningId the provisioning ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProvisioning(long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the provisioning routes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning routes where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param routeType the route type
	* @param routeKey the route key
	* @return the number of matching provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public int countByRoute(java.lang.String provisioningType,
		java.lang.String routeType, java.lang.String routeKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning routes where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @return the number of matching provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public int countByProvisioning(long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning routes.
	*
	* @return the number of provisioning routes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}