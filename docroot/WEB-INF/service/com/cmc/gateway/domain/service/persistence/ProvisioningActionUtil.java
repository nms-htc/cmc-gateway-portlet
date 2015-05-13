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

import com.cmc.gateway.domain.model.ProvisioningAction;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the provisioning action service. This utility wraps {@link ProvisioningActionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningActionPersistence
 * @see ProvisioningActionPersistenceImpl
 * @generated
 */
public class ProvisioningActionUtil {
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
	public static void clearCache(ProvisioningAction provisioningAction) {
		getPersistence().clearCache(provisioningAction);
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
	public static List<ProvisioningAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProvisioningAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProvisioningAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ProvisioningAction update(
		ProvisioningAction provisioningAction, boolean merge)
		throws SystemException {
		return getPersistence().update(provisioningAction, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ProvisioningAction update(
		ProvisioningAction provisioningAction, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(provisioningAction, merge, serviceContext);
	}

	/**
	* Caches the provisioning action in the entity cache if it is enabled.
	*
	* @param provisioningAction the provisioning action
	*/
	public static void cacheResult(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction) {
		getPersistence().cacheResult(provisioningAction);
	}

	/**
	* Caches the provisioning actions in the entity cache if it is enabled.
	*
	* @param provisioningActions the provisioning actions
	*/
	public static void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> provisioningActions) {
		getPersistence().cacheResult(provisioningActions);
	}

	/**
	* Creates a new provisioning action with the primary key. Does not add the provisioning action to the database.
	*
	* @param actionId the primary key for the new provisioning action
	* @return the new provisioning action
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction create(
		long actionId) {
		return getPersistence().create(actionId);
	}

	/**
	* Removes the provisioning action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the provisioning action
	* @return the provisioning action that was removed
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction remove(
		long actionId)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(actionId);
	}

	public static com.cmc.gateway.domain.model.ProvisioningAction updateImpl(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(provisioningAction, merge);
	}

	/**
	* Returns the provisioning action with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningActionException} if it could not be found.
	*
	* @param actionId the primary key of the provisioning action
	* @return the provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction findByPrimaryKey(
		long actionId)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(actionId);
	}

	/**
	* Returns the provisioning action with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param actionId the primary key of the provisioning action
	* @return the provisioning action, or <code>null</code> if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction fetchByPrimaryKey(
		long actionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(actionId);
	}

	/**
	* Returns all the provisioning actions where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @return the matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByProvisioning(
		long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProvisioning(provisioningId);
	}

	/**
	* Returns a range of all the provisioning actions where provisioningId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningId the provisioning ID
	* @param start the lower bound of the range of provisioning actions
	* @param end the upper bound of the range of provisioning actions (not inclusive)
	* @return the range of matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByProvisioning(
		long provisioningId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProvisioning(provisioningId, start, end);
	}

	/**
	* Returns an ordered range of all the provisioning actions where provisioningId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningId the provisioning ID
	* @param start the lower bound of the range of provisioning actions
	* @param end the upper bound of the range of provisioning actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByProvisioning(
		long provisioningId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProvisioning(provisioningId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first provisioning action in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction findByProvisioning_First(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProvisioning_First(provisioningId, orderByComparator);
	}

	/**
	* Returns the first provisioning action in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction fetchByProvisioning_First(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProvisioning_First(provisioningId, orderByComparator);
	}

	/**
	* Returns the last provisioning action in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction findByProvisioning_Last(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProvisioning_Last(provisioningId, orderByComparator);
	}

	/**
	* Returns the last provisioning action in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction fetchByProvisioning_Last(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProvisioning_Last(provisioningId, orderByComparator);
	}

	/**
	* Returns the provisioning actions before and after the current provisioning action in the ordered set where provisioningId = &#63;.
	*
	* @param actionId the primary key of the current provisioning action
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction[] findByProvisioning_PrevAndNext(
		long actionId, long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProvisioning_PrevAndNext(actionId, provisioningId,
			orderByComparator);
	}

	/**
	* Returns all the provisioning actions where commandId = &#63;.
	*
	* @param commandId the command ID
	* @return the matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByCommand(
		long commandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCommand(commandId);
	}

	/**
	* Returns a range of all the provisioning actions where commandId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param commandId the command ID
	* @param start the lower bound of the range of provisioning actions
	* @param end the upper bound of the range of provisioning actions (not inclusive)
	* @return the range of matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByCommand(
		long commandId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCommand(commandId, start, end);
	}

	/**
	* Returns an ordered range of all the provisioning actions where commandId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param commandId the command ID
	* @param start the lower bound of the range of provisioning actions
	* @param end the upper bound of the range of provisioning actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByCommand(
		long commandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCommand(commandId, start, end, orderByComparator);
	}

	/**
	* Returns the first provisioning action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction findByCommand_First(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCommand_First(commandId, orderByComparator);
	}

	/**
	* Returns the first provisioning action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction fetchByCommand_First(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCommand_First(commandId, orderByComparator);
	}

	/**
	* Returns the last provisioning action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction findByCommand_Last(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCommand_Last(commandId, orderByComparator);
	}

	/**
	* Returns the last provisioning action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction fetchByCommand_Last(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCommand_Last(commandId, orderByComparator);
	}

	/**
	* Returns the provisioning actions before and after the current provisioning action in the ordered set where commandId = &#63;.
	*
	* @param actionId the primary key of the current provisioning action
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction[] findByCommand_PrevAndNext(
		long actionId, long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCommand_PrevAndNext(actionId, commandId,
			orderByComparator);
	}

	/**
	* Returns the provisioning action where provisioningId = &#63; and commandId = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningActionException} if it could not be found.
	*
	* @param provisioningId the provisioning ID
	* @param commandId the command ID
	* @return the matching provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction findByP_C(
		long provisioningId, long commandId)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_C(provisioningId, commandId);
	}

	/**
	* Returns the provisioning action where provisioningId = &#63; and commandId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param provisioningId the provisioning ID
	* @param commandId the command ID
	* @return the matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction fetchByP_C(
		long provisioningId, long commandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByP_C(provisioningId, commandId);
	}

	/**
	* Returns the provisioning action where provisioningId = &#63; and commandId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param provisioningId the provisioning ID
	* @param commandId the command ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction fetchByP_C(
		long provisioningId, long commandId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_C(provisioningId, commandId, retrieveFromCache);
	}

	/**
	* Returns all the provisioning actions.
	*
	* @return the provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the provisioning actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of provisioning actions
	* @param end the upper bound of the range of provisioning actions (not inclusive)
	* @return the range of provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the provisioning actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of provisioning actions
	* @param end the upper bound of the range of provisioning actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the provisioning actions where provisioningId = &#63; from the database.
	*
	* @param provisioningId the provisioning ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProvisioning(long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProvisioning(provisioningId);
	}

	/**
	* Removes all the provisioning actions where commandId = &#63; from the database.
	*
	* @param commandId the command ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCommand(long commandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCommand(commandId);
	}

	/**
	* Removes the provisioning action where provisioningId = &#63; and commandId = &#63; from the database.
	*
	* @param provisioningId the provisioning ID
	* @param commandId the command ID
	* @return the provisioning action that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProvisioningAction removeByP_C(
		long provisioningId, long commandId)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByP_C(provisioningId, commandId);
	}

	/**
	* Removes all the provisioning actions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of provisioning actions where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @return the number of matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProvisioning(long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProvisioning(provisioningId);
	}

	/**
	* Returns the number of provisioning actions where commandId = &#63;.
	*
	* @param commandId the command ID
	* @return the number of matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCommand(long commandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCommand(commandId);
	}

	/**
	* Returns the number of provisioning actions where provisioningId = &#63; and commandId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param commandId the command ID
	* @return the number of matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_C(long provisioningId, long commandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByP_C(provisioningId, commandId);
	}

	/**
	* Returns the number of provisioning actions.
	*
	* @return the number of provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProvisioningActionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProvisioningActionPersistence)PortletBeanLocatorUtil.locate(com.cmc.gateway.domain.service.ClpSerializer.getServletContextName(),
					ProvisioningActionPersistence.class.getName());

			ReferenceRegistry.registerReference(ProvisioningActionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ProvisioningActionPersistence persistence) {
	}

	private static ProvisioningActionPersistence _persistence;
}