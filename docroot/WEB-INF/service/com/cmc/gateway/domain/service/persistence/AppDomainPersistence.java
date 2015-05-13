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

import com.cmc.gateway.domain.model.AppDomain;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the app domain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see AppDomainPersistenceImpl
 * @see AppDomainUtil
 * @generated
 */
public interface AppDomainPersistence extends BasePersistence<AppDomain> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppDomainUtil} to access the app domain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the app domain in the entity cache if it is enabled.
	*
	* @param appDomain the app domain
	*/
	public void cacheResult(com.cmc.gateway.domain.model.AppDomain appDomain);

	/**
	* Caches the app domains in the entity cache if it is enabled.
	*
	* @param appDomains the app domains
	*/
	public void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.AppDomain> appDomains);

	/**
	* Creates a new app domain with the primary key. Does not add the app domain to the database.
	*
	* @param domainId the primary key for the new app domain
	* @return the new app domain
	*/
	public com.cmc.gateway.domain.model.AppDomain create(long domainId);

	/**
	* Removes the app domain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param domainId the primary key of the app domain
	* @return the app domain that was removed
	* @throws com.cmc.gateway.domain.NoSuchAppDomainException if a app domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain remove(long domainId)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmc.gateway.domain.model.AppDomain updateImpl(
		com.cmc.gateway.domain.model.AppDomain appDomain, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the app domain with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchAppDomainException} if it could not be found.
	*
	* @param domainId the primary key of the app domain
	* @return the app domain
	* @throws com.cmc.gateway.domain.NoSuchAppDomainException if a app domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain findByPrimaryKey(
		long domainId)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the app domain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param domainId the primary key of the app domain
	* @return the app domain, or <code>null</code> if a app domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain fetchByPrimaryKey(
		long domainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the app domains where type = &#63;.
	*
	* @param type the type
	* @return the matching app domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.AppDomain> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the app domains where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of app domains
	* @param end the upper bound of the range of app domains (not inclusive)
	* @return the range of matching app domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.AppDomain> findByType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the app domains where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of app domains
	* @param end the upper bound of the range of app domains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching app domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.AppDomain> findByType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first app domain in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app domain
	* @throws com.cmc.gateway.domain.NoSuchAppDomainException if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain findByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first app domain in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app domain, or <code>null</code> if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain fetchByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last app domain in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app domain
	* @throws com.cmc.gateway.domain.NoSuchAppDomainException if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain findByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last app domain in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app domain, or <code>null</code> if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain fetchByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the app domains before and after the current app domain in the ordered set where type = &#63;.
	*
	* @param domainId the primary key of the current app domain
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next app domain
	* @throws com.cmc.gateway.domain.NoSuchAppDomainException if a app domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain[] findByType_PrevAndNext(
		long domainId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the app domain where type = &#63; and code = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchAppDomainException} if it could not be found.
	*
	* @param type the type
	* @param code the code
	* @return the matching app domain
	* @throws com.cmc.gateway.domain.NoSuchAppDomainException if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain findByCode(
		java.lang.String type, java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the app domain where type = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param type the type
	* @param code the code
	* @return the matching app domain, or <code>null</code> if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain fetchByCode(
		java.lang.String type, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the app domain where type = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param type the type
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching app domain, or <code>null</code> if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain fetchByCode(
		java.lang.String type, java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the app domains.
	*
	* @return the app domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.AppDomain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the app domains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of app domains
	* @param end the upper bound of the range of app domains (not inclusive)
	* @return the range of app domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.AppDomain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the app domains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of app domains
	* @param end the upper bound of the range of app domains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of app domains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.AppDomain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the app domains where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the app domain where type = &#63; and code = &#63; from the database.
	*
	* @param type the type
	* @param code the code
	* @return the app domain that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.AppDomain removeByCode(
		java.lang.String type, java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the app domains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of app domains where type = &#63;.
	*
	* @param type the type
	* @return the number of matching app domains
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of app domains where type = &#63; and code = &#63;.
	*
	* @param type the type
	* @param code the code
	* @return the number of matching app domains
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String type, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of app domains.
	*
	* @return the number of app domains
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}