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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the app domain service. This utility wraps {@link AppDomainPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see AppDomainPersistence
 * @see AppDomainPersistenceImpl
 * @generated
 */
public class AppDomainUtil {
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
	public static void clearCache(AppDomain appDomain) {
		getPersistence().clearCache(appDomain);
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
	public static List<AppDomain> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppDomain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppDomain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AppDomain update(AppDomain appDomain, boolean merge)
		throws SystemException {
		return getPersistence().update(appDomain, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AppDomain update(AppDomain appDomain, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(appDomain, merge, serviceContext);
	}

	/**
	* Caches the app domain in the entity cache if it is enabled.
	*
	* @param appDomain the app domain
	*/
	public static void cacheResult(
		com.cmc.gateway.domain.model.AppDomain appDomain) {
		getPersistence().cacheResult(appDomain);
	}

	/**
	* Caches the app domains in the entity cache if it is enabled.
	*
	* @param appDomains the app domains
	*/
	public static void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.AppDomain> appDomains) {
		getPersistence().cacheResult(appDomains);
	}

	/**
	* Creates a new app domain with the primary key. Does not add the app domain to the database.
	*
	* @param domainId the primary key for the new app domain
	* @return the new app domain
	*/
	public static com.cmc.gateway.domain.model.AppDomain create(long domainId) {
		return getPersistence().create(domainId);
	}

	/**
	* Removes the app domain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param domainId the primary key of the app domain
	* @return the app domain that was removed
	* @throws com.cmc.gateway.domain.NoSuchAppDomainException if a app domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.AppDomain remove(long domainId)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(domainId);
	}

	public static com.cmc.gateway.domain.model.AppDomain updateImpl(
		com.cmc.gateway.domain.model.AppDomain appDomain, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(appDomain, merge);
	}

	/**
	* Returns the app domain with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchAppDomainException} if it could not be found.
	*
	* @param domainId the primary key of the app domain
	* @return the app domain
	* @throws com.cmc.gateway.domain.NoSuchAppDomainException if a app domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.AppDomain findByPrimaryKey(
		long domainId)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(domainId);
	}

	/**
	* Returns the app domain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param domainId the primary key of the app domain
	* @return the app domain, or <code>null</code> if a app domain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.AppDomain fetchByPrimaryKey(
		long domainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(domainId);
	}

	/**
	* Returns all the app domains where type = &#63;.
	*
	* @param type the type
	* @return the matching app domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.AppDomain> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.AppDomain> findByType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.AppDomain> findByType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end, orderByComparator);
	}

	/**
	* Returns the first app domain in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app domain
	* @throws com.cmc.gateway.domain.NoSuchAppDomainException if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.AppDomain findByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	* Returns the first app domain in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app domain, or <code>null</code> if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.AppDomain fetchByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	* Returns the last app domain in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app domain
	* @throws com.cmc.gateway.domain.NoSuchAppDomainException if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.AppDomain findByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	* Returns the last app domain in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app domain, or <code>null</code> if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.AppDomain fetchByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

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
	public static com.cmc.gateway.domain.model.AppDomain[] findByType_PrevAndNext(
		long domainId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType_PrevAndNext(domainId, type, orderByComparator);
	}

	/**
	* Returns the app domain where type = &#63; and code = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchAppDomainException} if it could not be found.
	*
	* @param type the type
	* @param code the code
	* @return the matching app domain
	* @throws com.cmc.gateway.domain.NoSuchAppDomainException if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.AppDomain findByCode(
		java.lang.String type, java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(type, code);
	}

	/**
	* Returns the app domain where type = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param type the type
	* @param code the code
	* @return the matching app domain, or <code>null</code> if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.AppDomain fetchByCode(
		java.lang.String type, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(type, code);
	}

	/**
	* Returns the app domain where type = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param type the type
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching app domain, or <code>null</code> if a matching app domain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.AppDomain fetchByCode(
		java.lang.String type, java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(type, code, retrieveFromCache);
	}

	/**
	* Returns all the app domains.
	*
	* @return the app domains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.AppDomain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.AppDomain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.AppDomain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the app domains where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(type);
	}

	/**
	* Removes the app domain where type = &#63; and code = &#63; from the database.
	*
	* @param type the type
	* @param code the code
	* @return the app domain that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.AppDomain removeByCode(
		java.lang.String type, java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchAppDomainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCode(type, code);
	}

	/**
	* Removes all the app domains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of app domains where type = &#63;.
	*
	* @param type the type
	* @return the number of matching app domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(type);
	}

	/**
	* Returns the number of app domains where type = &#63; and code = &#63;.
	*
	* @param type the type
	* @param code the code
	* @return the number of matching app domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String type, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(type, code);
	}

	/**
	* Returns the number of app domains.
	*
	* @return the number of app domains
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AppDomainPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AppDomainPersistence)PortletBeanLocatorUtil.locate(com.cmc.gateway.domain.service.ClpSerializer.getServletContextName(),
					AppDomainPersistence.class.getName());

			ReferenceRegistry.registerReference(AppDomainUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AppDomainPersistence persistence) {
	}

	private static AppDomainPersistence _persistence;
}