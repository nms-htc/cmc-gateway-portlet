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

import com.cmc.gateway.domain.model.CommandAction;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the command action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see CommandActionPersistenceImpl
 * @see CommandActionUtil
 * @generated
 */
public interface CommandActionPersistence extends BasePersistence<CommandAction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommandActionUtil} to access the command action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the command action in the entity cache if it is enabled.
	*
	* @param commandAction the command action
	*/
	public void cacheResult(
		com.cmc.gateway.domain.model.CommandAction commandAction);

	/**
	* Caches the command actions in the entity cache if it is enabled.
	*
	* @param commandActions the command actions
	*/
	public void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.CommandAction> commandActions);

	/**
	* Creates a new command action with the primary key. Does not add the command action to the database.
	*
	* @param actionId the primary key for the new command action
	* @return the new command action
	*/
	public com.cmc.gateway.domain.model.CommandAction create(long actionId);

	/**
	* Removes the command action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the command action
	* @return the command action that was removed
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction remove(long actionId)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmc.gateway.domain.model.CommandAction updateImpl(
		com.cmc.gateway.domain.model.CommandAction commandAction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the command action with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchCommandActionException} if it could not be found.
	*
	* @param actionId the primary key of the command action
	* @return the command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction findByPrimaryKey(
		long actionId)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the command action with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param actionId the primary key of the command action
	* @return the command action, or <code>null</code> if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction fetchByPrimaryKey(
		long actionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the command actions where commandId = &#63;.
	*
	* @param commandId the command ID
	* @return the matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByCommand(
		long commandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the command actions where commandId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param commandId the command ID
	* @param start the lower bound of the range of command actions
	* @param end the upper bound of the range of command actions (not inclusive)
	* @return the range of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByCommand(
		long commandId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the command actions where commandId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param commandId the command ID
	* @param start the lower bound of the range of command actions
	* @param end the upper bound of the range of command actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByCommand(
		long commandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first command action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction findByCommand_First(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first command action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction fetchByCommand_First(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last command action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction findByCommand_Last(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last command action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction fetchByCommand_Last(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the command actions before and after the current command action in the ordered set where commandId = &#63;.
	*
	* @param actionId the primary key of the current command action
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction[] findByCommand_PrevAndNext(
		long actionId, long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the command actions where productId = &#63;.
	*
	* @param productId the product ID
	* @return the matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the command actions where productId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productId the product ID
	* @param start the lower bound of the range of command actions
	* @param end the upper bound of the range of command actions (not inclusive)
	* @return the range of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByProduct(
		long productId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the command actions where productId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productId the product ID
	* @param start the lower bound of the range of command actions
	* @param end the upper bound of the range of command actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByProduct(
		long productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first command action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction findByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first command action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction fetchByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last command action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction findByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last command action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction fetchByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the command actions before and after the current command action in the ordered set where productId = &#63;.
	*
	* @param actionId the primary key of the current command action
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction[] findByProduct_PrevAndNext(
		long actionId, long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the command actions where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @return the matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextCommand(
		long nextCommandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the command actions where nextCommandId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nextCommandId the next command ID
	* @param start the lower bound of the range of command actions
	* @param end the upper bound of the range of command actions (not inclusive)
	* @return the range of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextCommand(
		long nextCommandId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the command actions where nextCommandId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nextCommandId the next command ID
	* @param start the lower bound of the range of command actions
	* @param end the upper bound of the range of command actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextCommand(
		long nextCommandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first command action in the ordered set where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction findByNextCommand_First(
		long nextCommandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first command action in the ordered set where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction fetchByNextCommand_First(
		long nextCommandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last command action in the ordered set where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction findByNextCommand_Last(
		long nextCommandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last command action in the ordered set where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction fetchByNextCommand_Last(
		long nextCommandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the command actions before and after the current command action in the ordered set where nextCommandId = &#63;.
	*
	* @param actionId the primary key of the current command action
	* @param nextCommandId the next command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction[] findByNextCommand_PrevAndNext(
		long actionId, long nextCommandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the command actions where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	*
	* @param commandId the command ID
	* @param productId the product ID
	* @param actionType the action type
	* @param subscriberType the subscriber type
	* @param actionName the action name
	* @return the matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextAction(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the command actions where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param commandId the command ID
	* @param productId the product ID
	* @param actionType the action type
	* @param subscriberType the subscriber type
	* @param actionName the action name
	* @param start the lower bound of the range of command actions
	* @param end the upper bound of the range of command actions (not inclusive)
	* @return the range of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextAction(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the command actions where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param commandId the command ID
	* @param productId the product ID
	* @param actionType the action type
	* @param subscriberType the subscriber type
	* @param actionName the action name
	* @param start the lower bound of the range of command actions
	* @param end the upper bound of the range of command actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextAction(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first command action in the ordered set where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	*
	* @param commandId the command ID
	* @param productId the product ID
	* @param actionType the action type
	* @param subscriberType the subscriber type
	* @param actionName the action name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction findByNextAction_First(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first command action in the ordered set where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	*
	* @param commandId the command ID
	* @param productId the product ID
	* @param actionType the action type
	* @param subscriberType the subscriber type
	* @param actionName the action name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction fetchByNextAction_First(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last command action in the ordered set where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	*
	* @param commandId the command ID
	* @param productId the product ID
	* @param actionType the action type
	* @param subscriberType the subscriber type
	* @param actionName the action name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction findByNextAction_Last(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last command action in the ordered set where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	*
	* @param commandId the command ID
	* @param productId the product ID
	* @param actionType the action type
	* @param subscriberType the subscriber type
	* @param actionName the action name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction fetchByNextAction_Last(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the command actions before and after the current command action in the ordered set where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	*
	* @param actionId the primary key of the current command action
	* @param commandId the command ID
	* @param productId the product ID
	* @param actionType the action type
	* @param subscriberType the subscriber type
	* @param actionName the action name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandAction[] findByNextAction_PrevAndNext(
		long actionId, long commandId, long productId,
		java.lang.String actionType, int subscriberType,
		java.lang.String actionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the command actions.
	*
	* @return the command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the command actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of command actions
	* @param end the upper bound of the range of command actions (not inclusive)
	* @return the range of command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the command actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of command actions
	* @param end the upper bound of the range of command actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of command actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the command actions where commandId = &#63; from the database.
	*
	* @param commandId the command ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCommand(long commandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the command actions where productId = &#63; from the database.
	*
	* @param productId the product ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the command actions where nextCommandId = &#63; from the database.
	*
	* @param nextCommandId the next command ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNextCommand(long nextCommandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the command actions where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63; from the database.
	*
	* @param commandId the command ID
	* @param productId the product ID
	* @param actionType the action type
	* @param subscriberType the subscriber type
	* @param actionName the action name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNextAction(long commandId, long productId,
		java.lang.String actionType, int subscriberType,
		java.lang.String actionName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the command actions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of command actions where commandId = &#63;.
	*
	* @param commandId the command ID
	* @return the number of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCommand(long commandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of command actions where productId = &#63;.
	*
	* @param productId the product ID
	* @return the number of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of command actions where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @return the number of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByNextCommand(long nextCommandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of command actions where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	*
	* @param commandId the command ID
	* @param productId the product ID
	* @param actionType the action type
	* @param subscriberType the subscriber type
	* @param actionName the action name
	* @return the number of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByNextAction(long commandId, long productId,
		java.lang.String actionType, int subscriberType,
		java.lang.String actionName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of command actions.
	*
	* @return the number of command actions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}