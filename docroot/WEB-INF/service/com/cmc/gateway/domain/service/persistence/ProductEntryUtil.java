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

import com.cmc.gateway.domain.model.ProductEntry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the product entry service. This utility wraps {@link ProductEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductEntryPersistence
 * @see ProductEntryPersistenceImpl
 * @generated
 */
public class ProductEntryUtil {
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
	public static void clearCache(ProductEntry productEntry) {
		getPersistence().clearCache(productEntry);
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
	public static List<ProductEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ProductEntry update(ProductEntry productEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(productEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ProductEntry update(ProductEntry productEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(productEntry, merge, serviceContext);
	}

	/**
	* Caches the product entry in the entity cache if it is enabled.
	*
	* @param productEntry the product entry
	*/
	public static void cacheResult(
		com.cmc.gateway.domain.model.ProductEntry productEntry) {
		getPersistence().cacheResult(productEntry);
	}

	/**
	* Caches the product entries in the entity cache if it is enabled.
	*
	* @param productEntries the product entries
	*/
	public static void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProductEntry> productEntries) {
		getPersistence().cacheResult(productEntries);
	}

	/**
	* Creates a new product entry with the primary key. Does not add the product entry to the database.
	*
	* @param productId the primary key for the new product entry
	* @return the new product entry
	*/
	public static com.cmc.gateway.domain.model.ProductEntry create(
		long productId) {
		return getPersistence().create(productId);
	}

	/**
	* Removes the product entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productId the primary key of the product entry
	* @return the product entry that was removed
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry remove(
		long productId)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(productId);
	}

	public static com.cmc.gateway.domain.model.ProductEntry updateImpl(
		com.cmc.gateway.domain.model.ProductEntry productEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(productEntry, merge);
	}

	/**
	* Returns the product entry with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductEntryException} if it could not be found.
	*
	* @param productId the primary key of the product entry
	* @return the product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry findByPrimaryKey(
		long productId)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(productId);
	}

	/**
	* Returns the product entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param productId the primary key of the product entry
	* @return the product entry, or <code>null</code> if a product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry fetchByPrimaryKey(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(productId);
	}

	/**
	* Returns all the product entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId);
	}

	/**
	* Returns a range of all the product entries where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of product entries
	* @param end the upper bound of the range of product entries (not inclusive)
	* @return the range of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the product entries where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of product entries
	* @param end the upper bound of the range of product entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(categoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first product entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the first product entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the last product entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the last product entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the product entries before and after the current product entry in the ordered set where categoryId = &#63;.
	*
	* @param productId the primary key of the current product entry
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry[] findByCategory_PrevAndNext(
		long productId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory_PrevAndNext(productId, categoryId,
			orderByComparator);
	}

	/**
	* Returns all the product entries where productType = &#63;.
	*
	* @param productType the product type
	* @return the matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByType(
		java.lang.String productType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(productType);
	}

	/**
	* Returns a range of all the product entries where productType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productType the product type
	* @param start the lower bound of the range of product entries
	* @param end the upper bound of the range of product entries (not inclusive)
	* @return the range of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByType(
		java.lang.String productType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(productType, start, end);
	}

	/**
	* Returns an ordered range of all the product entries where productType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param productType the product type
	* @param start the lower bound of the range of product entries
	* @param end the upper bound of the range of product entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByType(
		java.lang.String productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType(productType, start, end, orderByComparator);
	}

	/**
	* Returns the first product entry in the ordered set where productType = &#63;.
	*
	* @param productType the product type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry findByType_First(
		java.lang.String productType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType_First(productType, orderByComparator);
	}

	/**
	* Returns the first product entry in the ordered set where productType = &#63;.
	*
	* @param productType the product type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry fetchByType_First(
		java.lang.String productType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_First(productType, orderByComparator);
	}

	/**
	* Returns the last product entry in the ordered set where productType = &#63;.
	*
	* @param productType the product type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry findByType_Last(
		java.lang.String productType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType_Last(productType, orderByComparator);
	}

	/**
	* Returns the last product entry in the ordered set where productType = &#63;.
	*
	* @param productType the product type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry fetchByType_Last(
		java.lang.String productType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_Last(productType, orderByComparator);
	}

	/**
	* Returns the product entries before and after the current product entry in the ordered set where productType = &#63;.
	*
	* @param productId the primary key of the current product entry
	* @param productType the product type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry[] findByType_PrevAndNext(
		long productId, java.lang.String productType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType_PrevAndNext(productId, productType,
			orderByComparator);
	}

	/**
	* Returns the product entry where code = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProductEntryException} if it could not be found.
	*
	* @param code the code
	* @return the matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry findByCode(
		java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns the product entry where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry fetchByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code);
	}

	/**
	* Returns the product entry where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code, retrieveFromCache);
	}

	/**
	* Returns all the product entries where status = &#63;.
	*
	* @param status the status
	* @return the matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the product entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of product entries
	* @param end the upper bound of the range of product entries (not inclusive)
	* @return the range of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the product entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of product entries
	* @param end the upper bound of the range of product entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first product entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first product entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last product entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last product entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the product entries before and after the current product entry in the ordered set where status = &#63;.
	*
	* @param productId the primary key of the current product entry
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry[] findByStatus_PrevAndNext(
		long productId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_PrevAndNext(productId, status,
			orderByComparator);
	}

	/**
	* Returns all the product entries.
	*
	* @return the product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the product entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product entries
	* @param end the upper bound of the range of product entries (not inclusive)
	* @return the range of product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the product entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product entries
	* @param end the upper bound of the range of product entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of product entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the product entries where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	* Removes all the product entries where productType = &#63; from the database.
	*
	* @param productType the product type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(java.lang.String productType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(productType);
	}

	/**
	* Removes the product entry where code = &#63; from the database.
	*
	* @param code the code
	* @return the product entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductEntry removeByCode(
		java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCode(code);
	}

	/**
	* Removes all the product entries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Removes all the product entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of product entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	* Returns the number of product entries where productType = &#63;.
	*
	* @param productType the product type
	* @return the number of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String productType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(productType);
	}

	/**
	* Returns the number of product entries where code = &#63;.
	*
	* @param code the code
	* @return the number of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Returns the number of product entries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns the number of product entries.
	*
	* @return the number of product entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProductEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProductEntryPersistence)PortletBeanLocatorUtil.locate(com.cmc.gateway.domain.service.ClpSerializer.getServletContextName(),
					ProductEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(ProductEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ProductEntryPersistence persistence) {
	}

	private static ProductEntryPersistence _persistence;
}