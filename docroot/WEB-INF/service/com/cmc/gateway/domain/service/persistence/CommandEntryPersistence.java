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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the command entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see CommandEntryPersistenceImpl
 * @see CommandEntryUtil
 * @generated
 */
public interface CommandEntryPersistence extends BasePersistence<CommandEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommandEntryUtil} to access the command entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the command entry in the entity cache if it is enabled.
	*
	* @param commandEntry the command entry
	*/
	public void cacheResult(
		com.cmc.gateway.domain.model.CommandEntry commandEntry);

	/**
	* Caches the command entries in the entity cache if it is enabled.
	*
	* @param commandEntries the command entries
	*/
	public void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.CommandEntry> commandEntries);

	/**
	* Creates a new command entry with the primary key. Does not add the command entry to the database.
	*
	* @param commandId the primary key for the new command entry
	* @return the new command entry
	*/
	public com.cmc.gateway.domain.model.CommandEntry create(long commandId);

	/**
	* Removes the command entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commandId the primary key of the command entry
	* @return the command entry that was removed
	* @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a command entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandEntry remove(long commandId)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmc.gateway.domain.model.CommandEntry updateImpl(
		com.cmc.gateway.domain.model.CommandEntry commandEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the command entry with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchCommandEntryException} if it could not be found.
	*
	* @param commandId the primary key of the command entry
	* @return the command entry
	* @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a command entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandEntry findByPrimaryKey(
		long commandId)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the command entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commandId the primary key of the command entry
	* @return the command entry, or <code>null</code> if a command entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandEntry fetchByPrimaryKey(
		long commandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the command entry where code = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchCommandEntryException} if it could not be found.
	*
	* @param code the code
	* @return the matching command entry
	* @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandEntry findByCode(
		java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the command entry where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching command entry, or <code>null</code> if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandEntry fetchByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the command entry where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching command entry, or <code>null</code> if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandEntry fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the command entries where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @return the matching command entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandEntry> findByType(
		java.lang.String provisioningType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.CommandEntry> findByType(
		java.lang.String provisioningType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.CommandEntry> findByType(
		java.lang.String provisioningType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first command entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command entry
	* @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandEntry findByType_First(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first command entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching command entry, or <code>null</code> if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandEntry fetchByType_First(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last command entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command entry
	* @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandEntry findByType_Last(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last command entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching command entry, or <code>null</code> if a matching command entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandEntry fetchByType_Last(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cmc.gateway.domain.model.CommandEntry[] findByType_PrevAndNext(
		long commandId, java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the command entries.
	*
	* @return the command entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.CommandEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.CommandEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.CommandEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the command entry where code = &#63; from the database.
	*
	* @param code the code
	* @return the command entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.CommandEntry removeByCode(
		java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchCommandEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the command entries where provisioningType = &#63; from the database.
	*
	* @param provisioningType the provisioning type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(java.lang.String provisioningType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the command entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of command entries where code = &#63;.
	*
	* @param code the code
	* @return the number of matching command entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of command entries where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @return the number of matching command entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(java.lang.String provisioningType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of command entries.
	*
	* @return the number of command entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}