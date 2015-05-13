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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the provisioning action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningActionPersistenceImpl
 * @see ProvisioningActionUtil
 * @generated
 */
public interface ProvisioningActionPersistence extends BasePersistence<ProvisioningAction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProvisioningActionUtil} to access the provisioning action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the provisioning action in the entity cache if it is enabled.
	*
	* @param provisioningAction the provisioning action
	*/
	public void cacheResult(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction);

	/**
	* Caches the provisioning actions in the entity cache if it is enabled.
	*
	* @param provisioningActions the provisioning actions
	*/
	public void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> provisioningActions);

	/**
	* Creates a new provisioning action with the primary key. Does not add the provisioning action to the database.
	*
	* @param actionId the primary key for the new provisioning action
	* @return the new provisioning action
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction create(long actionId);

	/**
	* Removes the provisioning action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the provisioning action
	* @return the provisioning action that was removed
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction remove(long actionId)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmc.gateway.domain.model.ProvisioningAction updateImpl(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning action with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningActionException} if it could not be found.
	*
	* @param actionId the primary key of the provisioning action
	* @return the provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction findByPrimaryKey(
		long actionId)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning action with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param actionId the primary key of the provisioning action
	* @return the provisioning action, or <code>null</code> if a provisioning action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction fetchByPrimaryKey(
		long actionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the provisioning actions where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @return the matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByProvisioning(
		long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByProvisioning(
		long provisioningId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByProvisioning(
		long provisioningId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning action in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction findByProvisioning_First(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning action in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction fetchByProvisioning_First(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning action in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction findByProvisioning_Last(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning action in the ordered set where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction fetchByProvisioning_Last(
		long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cmc.gateway.domain.model.ProvisioningAction[] findByProvisioning_PrevAndNext(
		long actionId, long provisioningId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the provisioning actions where commandId = &#63;.
	*
	* @param commandId the command ID
	* @return the matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByCommand(
		long commandId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByCommand(
		long commandId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findByCommand(
		long commandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction findByCommand_First(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction fetchByCommand_First(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction findByCommand_Last(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction fetchByCommand_Last(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cmc.gateway.domain.model.ProvisioningAction[] findByCommand_PrevAndNext(
		long actionId, long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning action where provisioningId = &#63; and commandId = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningActionException} if it could not be found.
	*
	* @param provisioningId the provisioning ID
	* @param commandId the command ID
	* @return the matching provisioning action
	* @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction findByP_C(
		long provisioningId, long commandId)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning action where provisioningId = &#63; and commandId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param provisioningId the provisioning ID
	* @param commandId the command ID
	* @return the matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction fetchByP_C(
		long provisioningId, long commandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning action where provisioningId = &#63; and commandId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param provisioningId the provisioning ID
	* @param commandId the command ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction fetchByP_C(
		long provisioningId, long commandId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the provisioning actions.
	*
	* @return the provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the provisioning actions where provisioningId = &#63; from the database.
	*
	* @param provisioningId the provisioning ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProvisioning(long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the provisioning actions where commandId = &#63; from the database.
	*
	* @param commandId the command ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCommand(long commandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the provisioning action where provisioningId = &#63; and commandId = &#63; from the database.
	*
	* @param provisioningId the provisioning ID
	* @param commandId the command ID
	* @return the provisioning action that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningAction removeByP_C(
		long provisioningId, long commandId)
		throws com.cmc.gateway.domain.NoSuchProvisioningActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the provisioning actions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning actions where provisioningId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @return the number of matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByProvisioning(long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning actions where commandId = &#63;.
	*
	* @param commandId the command ID
	* @return the number of matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCommand(long commandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning actions where provisioningId = &#63; and commandId = &#63;.
	*
	* @param provisioningId the provisioning ID
	* @param commandId the command ID
	* @return the number of matching provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByP_C(long provisioningId, long commandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning actions.
	*
	* @return the number of provisioning actions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}