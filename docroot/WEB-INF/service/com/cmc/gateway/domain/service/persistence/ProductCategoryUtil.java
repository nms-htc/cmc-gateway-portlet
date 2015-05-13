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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the product category service. This utility wraps {@link ProductCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductCategoryPersistence
 * @see ProductCategoryPersistenceImpl
 * @generated
 */
public class ProductCategoryUtil {
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
	public static void clearCache(ProductCategory productCategory) {
		getPersistence().clearCache(productCategory);
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
	public static List<ProductCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ProductCategory update(ProductCategory productCategory,
		boolean merge) throws SystemException {
		return getPersistence().update(productCategory, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ProductCategory update(ProductCategory productCategory,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(productCategory, merge, serviceContext);
	}

	/**
	* Caches the product category in the entity cache if it is enabled.
	*
	* @param productCategory the product category
	*/
	public static void cacheResult(
		com.cmc.gateway.domain.model.ProductCategory productCategory) {
		getPersistence().cacheResult(productCategory);
	}

	/**
	* Caches the product categories in the entity cache if it is enabled.
	*
	* @param productCategories the product categories
	*/
	public static void cacheResult(
		java.util.List<com.cmc.gateway.domain.model.ProductCategory> productCategories) {
		getPersistence().cacheResult(productCategories);
	}

	/**
	* Creates a new product category with the primary key. Does not add the product category to the database.
	*
	* @param categoryId the primary key for the new product category
	* @return the new product category
	*/
	public static com.cmc.gateway.domain.model.ProductCategory create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the product category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the product category
	* @return the product category that was removed
	* @throws com.cmc.gateway.domain.NoSuchProductCategoryException if a product category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductCategory remove(
		long categoryId)
		throws com.cmc.gateway.domain.NoSuchProductCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(categoryId);
	}

	public static com.cmc.gateway.domain.model.ProductCategory updateImpl(
		com.cmc.gateway.domain.model.ProductCategory productCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(productCategory, merge);
	}

	/**
	* Returns the product category with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the product category
	* @return the product category
	* @throws com.cmc.gateway.domain.NoSuchProductCategoryException if a product category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductCategory findByPrimaryKey(
		long categoryId)
		throws com.cmc.gateway.domain.NoSuchProductCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the product category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the product category
	* @return the product category, or <code>null</code> if a product category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the product categories.
	*
	* @return the product categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cmc.gateway.domain.model.ProductCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProductCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cmc.gateway.domain.model.ProductCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the product categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of product categories.
	*
	* @return the number of product categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProductCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProductCategoryPersistence)PortletBeanLocatorUtil.locate(com.cmc.gateway.domain.service.ClpSerializer.getServletContextName(),
					ProductCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(ProductCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ProductCategoryPersistence persistence) {
	}

	private static ProductCategoryPersistence _persistence;
}