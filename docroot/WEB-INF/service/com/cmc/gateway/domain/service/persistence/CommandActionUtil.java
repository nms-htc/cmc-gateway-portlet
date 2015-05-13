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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the command action service. This utility wraps {@link CommandActionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see CommandActionPersistence
 * @see CommandActionPersistenceImpl
 * @generated
 */
public class CommandActionUtil {
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
	public static void clearCache(CommandAction commandAction) {
		getPersistence().clearCache(commandAction);
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
	public static List<CommandAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CommandAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CommandAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CommandAction update(CommandAction commandAction,
		boolean merge) throws SystemException {
		return getPersistence().update(commandAction, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CommandAction update(CommandAction commandAction,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(commandAction, merge, serviceContext);
	}

	/**
	* Caches the command action in the entity cache if it is enabled.
	*
	* @param commandAction the command action
	*/
	public static void cacheResult(
		com.cmc.gateway.domain.model.CommandAction commandAction) {
		getPersistence().cacheResult(commandAction);
	}

	/**
	* Caches the command actions in the entity cache if it is enabled.
	*
	* @param commandActions the command actions
	*/
	public static void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.CommandAction> commandActions) {
		getPersistence().cacheResult(commandActions);
	}

	/**
	* Creates a new command action with the primary key. Does not add the command action to the database.
	*
	* @param actionId the primary key for the new command action
	* @return the new command action
	*/
	public static com.cmc.gateway.domain.model.CommandAction create(
		long actionId) {
		return getPersistence().create(actionId);
	}

	/**
	* Removes the command action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actionId the primary key of the command action
	* @return the command action that was removed
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction remove(
		long actionId)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(actionId);
	}

	public static com.cmc.gateway.domain.model.CommandAction updateImpl(
		com.cmc.gateway.domain.model.CommandAction commandAction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(commandAction, merge);
	}

	/**
	* Returns the command action with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchCommandActionException} if it could not be found.
	*
	* @param actionId the primary key of the command action
	* @return the command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction findByPrimaryKey(
		long actionId)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(actionId);
	}

	/**
	* Returns the command action with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param actionId the primary key of the command action
	* @return the command action, or <code>null</code> if a command action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction fetchByPrimaryKey(
		long actionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(actionId);
	}

	/**
	* Returns all the command actions where commandId = &#63;.
	*
	* @param commandId the command ID
	* @return the matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByCommand(
		long commandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCommand(commandId);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByCommand(
		long commandId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCommand(commandId, start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByCommand(
		long commandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCommand(commandId, start, end, orderByComparator);
	}

	/**
	* Returns the first command action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction findByCommand_First(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCommand_First(commandId, orderByComparator);
	}

	/**
	* Returns the first command action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction fetchByCommand_First(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCommand_First(commandId, orderByComparator);
	}

	/**
	* Returns the last command action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction findByCommand_Last(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCommand_Last(commandId, orderByComparator);
	}

	/**
	* Returns the last command action in the ordered set where commandId = &#63;.
	*
	* @param commandId the command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction fetchByCommand_Last(
		long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCommand_Last(commandId, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.CommandAction[] findByCommand_PrevAndNext(
		long actionId, long commandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCommand_PrevAndNext(actionId, commandId,
			orderByComparator);
	}

	/**
	* Returns all the command actions where productId = &#63;.
	*
	* @param productId the product ID
	* @return the matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct(productId);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByProduct(
		long productId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct(productId, start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByProduct(
		long productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProduct(productId, start, end, orderByComparator);
	}

	/**
	* Returns the first command action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction findByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct_First(productId, orderByComparator);
	}

	/**
	* Returns the first command action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction fetchByProduct_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProduct_First(productId, orderByComparator);
	}

	/**
	* Returns the last command action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction findByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProduct_Last(productId, orderByComparator);
	}

	/**
	* Returns the last command action in the ordered set where productId = &#63;.
	*
	* @param productId the product ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction fetchByProduct_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByProduct_Last(productId, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.CommandAction[] findByProduct_PrevAndNext(
		long actionId, long productId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProduct_PrevAndNext(actionId, productId,
			orderByComparator);
	}

	/**
	* Returns all the command actions where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @return the matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextCommand(
		long nextCommandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNextCommand(nextCommandId);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextCommand(
		long nextCommandId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNextCommand(nextCommandId, start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextCommand(
		long nextCommandId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNextCommand(nextCommandId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first command action in the ordered set where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction findByNextCommand_First(
		long nextCommandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNextCommand_First(nextCommandId, orderByComparator);
	}

	/**
	* Returns the first command action in the ordered set where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction fetchByNextCommand_First(
		long nextCommandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNextCommand_First(nextCommandId, orderByComparator);
	}

	/**
	* Returns the last command action in the ordered set where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action
	* @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction findByNextCommand_Last(
		long nextCommandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNextCommand_Last(nextCommandId, orderByComparator);
	}

	/**
	* Returns the last command action in the ordered set where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command action, or <code>null</code> if a matching command action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandAction fetchByNextCommand_Last(
		long nextCommandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNextCommand_Last(nextCommandId, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.CommandAction[] findByNextCommand_PrevAndNext(
		long actionId, long nextCommandId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNextCommand_PrevAndNext(actionId, nextCommandId,
			orderByComparator);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextAction(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNextAction(commandId, productId, actionType,
			subscriberType, actionName);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextAction(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNextAction(commandId, productId, actionType,
			subscriberType, actionName, start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findByNextAction(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNextAction(commandId, productId, actionType,
			subscriberType, actionName, start, end, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.CommandAction findByNextAction_First(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNextAction_First(commandId, productId, actionType,
			subscriberType, actionName, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.CommandAction fetchByNextAction_First(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNextAction_First(commandId, productId, actionType,
			subscriberType, actionName, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.CommandAction findByNextAction_Last(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNextAction_Last(commandId, productId, actionType,
			subscriberType, actionName, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.CommandAction fetchByNextAction_Last(
		long commandId, long productId, java.lang.String actionType,
		int subscriberType, java.lang.String actionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNextAction_Last(commandId, productId, actionType,
			subscriberType, actionName, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.CommandAction[] findByNextAction_PrevAndNext(
		long actionId, long commandId, long productId,
		java.lang.String actionType, int subscriberType,
		java.lang.String actionName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNextAction_PrevAndNext(actionId, commandId,
			productId, actionType, subscriberType, actionName, orderByComparator);
	}

	/**
	* Returns all the command actions.
	*
	* @return the command actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.CommandAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the command actions where commandId = &#63; from the database.
	*
	* @param commandId the command ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCommand(long commandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCommand(commandId);
	}

	/**
	* Removes all the command actions where productId = &#63; from the database.
	*
	* @param productId the product ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProduct(productId);
	}

	/**
	* Removes all the command actions where nextCommandId = &#63; from the database.
	*
	* @param nextCommandId the next command ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNextCommand(long nextCommandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNextCommand(nextCommandId);
	}

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
	public static void removeByNextAction(long commandId, long productId,
		java.lang.String actionType, int subscriberType,
		java.lang.String actionName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByNextAction(commandId, productId, actionType,
			subscriberType, actionName);
	}

	/**
	* Removes all the command actions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of command actions where commandId = &#63;.
	*
	* @param commandId the command ID
	* @return the number of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCommand(long commandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCommand(commandId);
	}

	/**
	* Returns the number of command actions where productId = &#63;.
	*
	* @param productId the product ID
	* @return the number of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProduct(long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProduct(productId);
	}

	/**
	* Returns the number of command actions where nextCommandId = &#63;.
	*
	* @param nextCommandId the next command ID
	* @return the number of matching command actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNextCommand(long nextCommandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNextCommand(nextCommandId);
	}

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
	public static int countByNextAction(long commandId, long productId,
		java.lang.String actionType, int subscriberType,
		java.lang.String actionName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByNextAction(commandId, productId, actionType,
			subscriberType, actionName);
	}

	/**
	* Returns the number of command actions.
	*
	* @return the number of command actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CommandActionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CommandActionPersistence)PortletBeanLocatorUtil.locate(com.cmc.gateway.domain.service.ClpSerializer.getServletContextName(),
					CommandActionPersistence.class.getName());

			ReferenceRegistry.registerReference(CommandActionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CommandActionPersistence persistence) {
	}

	private static CommandActionPersistence _persistence;
}