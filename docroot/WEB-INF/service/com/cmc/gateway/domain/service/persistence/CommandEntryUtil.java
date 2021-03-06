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

import com.cmc.gateway.domain.model.CommandEntry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the command entry service. This utility wraps {@link CommandEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see CommandEntryPersistence
 * @see CommandEntryPersistenceImpl
 * @generated
 */
public class CommandEntryUtil {
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
	public static void clearCache(CommandEntry commandEntry) {
		getPersistence().clearCache(commandEntry);
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
	public static List<CommandEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CommandEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CommandEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CommandEntry update(CommandEntry commandEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(commandEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CommandEntry update(CommandEntry commandEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(commandEntry, merge, serviceContext);
	}

	/**
	* Caches the command entry in the entity cache if it is enabled.
	*
	* @param commandEntry the command entry
	*/
	public static void cacheResult(
		com.cmc.gateway.domain.model.CommandEntry commandEntry) {
		getPersistence().cacheResult(commandEntry);
	}

	/**
	* Caches the command entries in the entity cache if it is enabled.
	*
	* @param commandEntries the command entries
	*/
	public static void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.CommandEntry> commandEntries) {
		getPersistence().cacheResult(commandEntries);
	}

	/**
	* Creates a new command entry with the primary key. Does not add the command entry to the database.
	*
	* @param commandId the primary key for the new command entry
	* @return the new command entry
	*/
	public static com.cmc.gateway.domain.model.CommandEntry create(
		long commandId) {
		return getPersistence().create(commandId);
	}

	/**
	* Removes the command entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commandId the primary key of the command entry
	* @return the command entry that was removed
	* @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a command entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry remove(
		long commandId)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(commandId);
	}

	public static com.cmc.gateway.domain.model.CommandEntry updateImpl(
		com.cmc.gateway.domain.model.CommandEntry commandEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(commandEntry, merge);
	}

	/**
	* Returns the command entry with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchCommandEntryException} if it could not be found.
	*
	* @param commandId the primary key of the command entry
	* @return the command entry
	* @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a command entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry findByPrimaryKey(
		long commandId)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(commandId);
	}

	/**
	* Returns the command entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commandId the primary key of the command entry
	* @return the command entry, or <code>null</code> if a command entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry fetchByPrimaryKey(
		long commandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(commandId);
	}

	/**
	* Returns the command entry where code = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchCommandEntryException} if it could not be found.
	*
	* @param code the code
	* @return the matching command entry
	* @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry findByCode(
		java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns the command entry where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching command entry, or <code>null</code> if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry fetchByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code);
	}

	/**
	* Returns the command entry where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching command entry, or <code>null</code> if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code, retrieveFromCache);
	}

	/**
	* Returns all the command entries where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @return the matching command entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.CommandEntry> findByType(
		java.lang.String provisioningType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(provisioningType);
	}

	/**
	* Returns a range of all the command entries where provisioningType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningType the provisioning type
	* @param start the lower bound of the range of command entries
	* @param end the upper bound of the range of command entries (not inclusive)
	* @return the range of matching command entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.CommandEntry> findByType(
		java.lang.String provisioningType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(provisioningType, start, end);
	}

	/**
	* Returns an ordered range of all the command entries where provisioningType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningType the provisioning type
	* @param start the lower bound of the range of command entries
	* @param end the upper bound of the range of command entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching command entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.CommandEntry> findByType(
		java.lang.String provisioningType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType(provisioningType, start, end, orderByComparator);
	}

	/**
	* Returns the first command entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command entry
	* @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry findByType_First(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType_First(provisioningType, orderByComparator);
	}

	/**
	* Returns the first command entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command entry, or <code>null</code> if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry fetchByType_First(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByType_First(provisioningType, orderByComparator);
	}

	/**
	* Returns the last command entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command entry
	* @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry findByType_Last(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType_Last(provisioningType, orderByComparator);
	}

	/**
	* Returns the last command entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command entry, or <code>null</code> if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry fetchByType_Last(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByType_Last(provisioningType, orderByComparator);
	}

	/**
	* Returns the command entries before and after the current command entry in the ordered set where provisioningType = &#63;.
	*
	* @param commandId the primary key of the current command entry
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next command entry
	* @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a command entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry[] findByType_PrevAndNext(
		long commandId, java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType_PrevAndNext(commandId, provisioningType,
			orderByComparator);
	}

	/**
	* Returns all the command entries.
	*
	* @return the command entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.CommandEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the command entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of command entries
	* @param end the upper bound of the range of command entries (not inclusive)
	* @return the range of command entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.CommandEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the command entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of command entries
	* @param end the upper bound of the range of command entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of command entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.CommandEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the command entry where code = &#63; from the database.
	*
	* @param code the code
	* @return the command entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.CommandEntry removeByCode(
		java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCode(code);
	}

	/**
	* Removes all the command entries where provisioningType = &#63; from the database.
	*
	* @param provisioningType the provisioning type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(java.lang.String provisioningType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(provisioningType);
	}

	/**
	* Removes all the command entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of command entries where code = &#63;.
	*
	* @param code the code
	* @return the number of matching command entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Returns the number of command entries where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @return the number of matching command entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String provisioningType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(provisioningType);
	}

	/**
	* Returns the number of command entries.
	*
	* @return the number of command entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CommandEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CommandEntryPersistence)PortletBeanLocatorUtil.locate(com.cmc.gateway.domain.service.ClpSerializer.getServletContextName(),
					CommandEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(CommandEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CommandEntryPersistence persistence) {
	}

	private static CommandEntryPersistence _persistence;
}