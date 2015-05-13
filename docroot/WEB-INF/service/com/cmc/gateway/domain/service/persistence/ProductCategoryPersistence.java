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

import com.cmc.gateway.domain.model.ProductCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the product category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductCategoryPersistenceImpl
 * @see ProductCategoryUtil
 * @generated
 */
public interface ProductCategoryPersistence extends BasePersistence<ProductCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductCategoryUtil} to access the product category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the product category in the entity cache if it is enabled.
	*
	* @param productCategory the product category
	*/
	public void cacheResult(
		com.cmc.gateway.domain.model.ProductCategory productCategory);

	/**
	* Caches the product categories in the entity cache if it is enabled.
	*
	* @param productCategories the product categories
	*/
	public void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProductCategory> productCategories);

	/**
	* Creates a new product category with the primary key. Does not add the product category to the database.
	*
	* @param categoryId the primary key for the new product category
	* @return the new product category
	*/
	public com.cmc.gateway.domain.model.ProductCategory create(long categoryId);

	/**
	* Removes the product category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the product category
	* @return the product category that was removed
	* @throws com.cmc.gateway.domain.NoSuchProductCategoryException if a product category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductCategory remove(long categoryId)
		throws com.cmc.gateway.domain.NoSuchProductCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cmc.gateway.domain.model.ProductCategory updateImpl(
		com.cmc.gateway.domain.model.ProductCategory productCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product category with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the product category
	* @return the product category
	* @throws com.cmc.gateway.domain.NoSuchProductCategoryException if a product category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductCategory findByPrimaryKey(
		long categoryId)
		throws com.cmc.gateway.domain.NoSuchProductCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the product category
	* @return the product category, or <code>null</code> if a product category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the product categories.
	*
	* @return the product categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the product categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product categories
	* @param end the upper bound of the range of product categories (not inclusive)
	* @return the range of product categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the product categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product categories
	* @param end the upper bound of the range of product categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of product categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the product categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of product categories.
	*
	* @return the number of product categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}