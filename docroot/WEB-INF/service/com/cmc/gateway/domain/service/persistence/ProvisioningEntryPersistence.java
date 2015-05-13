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

import com.cmc.gateway.domain.model.ProvisioningEntry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the provisioning entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningEntryPersistenceImpl
 * @see ProvisioningEntryUtil
 * @generated
 */
public interface ProvisioningEntryPersistence extends BasePersistence<ProvisioningEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProvisioningEntryUtil} to access the provisioning entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the provisioning entry in the entity cache if it is enabled.
	*
	* @param provisioningEntry the provisioning entry
	*/
	public void cacheResult(
		com.cmc.gateway.domain.model.ProvisioningEntry provisioningEntry);

	/**
	* Caches the provisioning entries in the entity cache if it is enabled.
	*
	* @param provisioningEntries the provisioning entries
	*/
	public void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProvisioningEntry> provisioningEntries);

	/**
	* Creates a new provisioning entry with the primary key. Does not add the provisioning entry to the database.
	*
	* @param provisioningId the primary key for the new provisioning entry
	* @return the new provisioning entry
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry create(
		long provisioningId);

	/**
	* Removes the provisioning entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param provisioningId the primary key of the provisioning entry
	* @return the provisioning entry that was removed
	* @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a provisioning entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry remove(
		long provisioningId)
		throws com.cmc.gateway.domain.NoSuchProvisioningEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmc.gateway.domain.model.ProvisioningEntry updateImpl(
		com.cmc.gateway.domain.model.ProvisioningEntry provisioningEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning entry with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningEntryException} if it could not be found.
	*
	* @param provisioningId the primary key of the provisioning entry
	* @return the provisioning entry
	* @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a provisioning entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry findByPrimaryKey(
		long provisioningId)
		throws com.cmc.gateway.domain.NoSuchProvisioningEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param provisioningId the primary key of the provisioning entry
	* @return the provisioning entry, or <code>null</code> if a provisioning entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry fetchByPrimaryKey(
		long provisioningId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning entry where code = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningEntryException} if it could not be found.
	*
	* @param code the code
	* @return the matching provisioning entry
	* @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a matching provisioning entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry findByCode(
		java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchProvisioningEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning entry where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching provisioning entry, or <code>null</code> if a matching provisioning entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry fetchByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning entry where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching provisioning entry, or <code>null</code> if a matching provisioning entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the provisioning entries where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @return the matching provisioning entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningEntry> findByType(
		java.lang.String provisioningType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the provisioning entries where provisioningType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningType the provisioning type
	* @param start the lower bound of the range of provisioning entries
	* @param end the upper bound of the range of provisioning entries (not inclusive)
	* @return the range of matching provisioning entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningEntry> findByType(
		java.lang.String provisioningType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the provisioning entries where provisioningType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param provisioningType the provisioning type
	* @param start the lower bound of the range of provisioning entries
	* @param end the upper bound of the range of provisioning entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching provisioning entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningEntry> findByType(
		java.lang.String provisioningType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning entry
	* @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a matching provisioning entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry findByType_First(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first provisioning entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching provisioning entry, or <code>null</code> if a matching provisioning entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry fetchByType_First(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning entry
	* @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a matching provisioning entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry findByType_Last(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last provisioning entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching provisioning entry, or <code>null</code> if a matching provisioning entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry fetchByType_Last(
		java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provisioning entries before and after the current provisioning entry in the ordered set where provisioningType = &#63;.
	*
	* @param provisioningId the primary key of the current provisioning entry
	* @param provisioningType the provisioning type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next provisioning entry
	* @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a provisioning entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry[] findByType_PrevAndNext(
		long provisioningId, java.lang.String provisioningType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProvisioningEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the provisioning entries.
	*
	* @return the provisioning entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the provisioning entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of provisioning entries
	* @param end the upper bound of the range of provisioning entries (not inclusive)
	* @return the range of provisioning entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the provisioning entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of provisioning entries
	* @param end the upper bound of the range of provisioning entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of provisioning entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProvisioningEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the provisioning entry where code = &#63; from the database.
	*
	* @param code the code
	* @return the provisioning entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProvisioningEntry removeByCode(
		java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchProvisioningEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the provisioning entries where provisioningType = &#63; from the database.
	*
	* @param provisioningType the provisioning type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(java.lang.String provisioningType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the provisioning entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning entries where code = &#63;.
	*
	* @param code the code
	* @return the number of matching provisioning entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning entries where provisioningType = &#63;.
	*
	* @param provisioningType the provisioning type
	* @return the number of matching provisioning entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(java.lang.String provisioningType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provisioning entries.
	*
	* @return the number of provisioning entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}