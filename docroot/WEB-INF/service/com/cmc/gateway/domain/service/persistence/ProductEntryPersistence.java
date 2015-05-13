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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the product entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductEntryPersistenceImpl
 * @see ProductEntryUtil
 * @generated
 */
public interface ProductEntryPersistence extends BasePersistence<ProductEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductEntryUtil} to access the product entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the product entry in the entity cache if it is enabled.
	*
	* @param productEntry the product entry
	*/
	public void cacheResult(
		com.cmc.gateway.domain.model.ProductEntry productEntry);

	/**
	* Caches the product entries in the entity cache if it is enabled.
	*
	* @param productEntries the product entries
	*/
	public void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProductEntry> productEntries);

	/**
	* Creates a new product entry with the primary key. Does not add the product entry to the database.
	*
	* @param productId the primary key for the new product entry
	* @return the new product entry
	*/
	public com.cmc.gateway.domain.model.ProductEntry create(long productId);

	/**
	* Removes the product entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productId the primary key of the product entry
	* @return the product entry that was removed
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry remove(long productId)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmc.gateway.domain.model.ProductEntry updateImpl(
		com.cmc.gateway.domain.model.ProductEntry productEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product entry with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductEntryException} if it could not be found.
	*
	* @param productId the primary key of the product entry
	* @return the product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry findByPrimaryKey(
		long productId)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param productId the primary key of the product entry
	* @return the product entry, or <code>null</code> if a product entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry fetchByPrimaryKey(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the product entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cmc.gateway.domain.model.ProductEntry[] findByCategory_PrevAndNext(
		long productId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the product entries where productType = &#63;.
	*
	* @param productType the product type
	* @return the matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByType(
		java.lang.String productType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByType(
		java.lang.String productType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByType(
		java.lang.String productType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product entry in the ordered set where productType = &#63;.
	*
	* @param productType the product type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry findByType_First(
		java.lang.String productType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product entry in the ordered set where productType = &#63;.
	*
	* @param productType the product type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry fetchByType_First(
		java.lang.String productType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product entry in the ordered set where productType = &#63;.
	*
	* @param productType the product type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry findByType_Last(
		java.lang.String productType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product entry in the ordered set where productType = &#63;.
	*
	* @param productType the product type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry fetchByType_Last(
		java.lang.String productType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cmc.gateway.domain.model.ProductEntry[] findByType_PrevAndNext(
		long productId, java.lang.String productType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product entry where code = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProductEntryException} if it could not be found.
	*
	* @param code the code
	* @return the matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry findByCode(
		java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product entry where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry fetchByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product entry where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the product entries where status = &#63;.
	*
	* @param status the status
	* @return the matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry
	* @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product entry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product entry, or <code>null</code> if a matching product entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cmc.gateway.domain.model.ProductEntry[] findByStatus_PrevAndNext(
		long productId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the product entries.
	*
	* @return the product entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cmc.gateway.domain.model.ProductEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the product entries where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the product entries where productType = &#63; from the database.
	*
	* @param productType the product type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(java.lang.String productType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the product entry where code = &#63; from the database.
	*
	* @param code the code
	* @return the product entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductEntry removeByCode(
		java.lang.String code)
		throws com.cmc.gateway.domain.NoSuchProductEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the product entries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the product entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of product entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of product entries where productType = &#63;.
	*
	* @param productType the product type
	* @return the number of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(java.lang.String productType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of product entries where code = &#63;.
	*
	* @param code the code
	* @return the number of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of product entries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching product entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of product entries.
	*
	* @return the number of product entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}