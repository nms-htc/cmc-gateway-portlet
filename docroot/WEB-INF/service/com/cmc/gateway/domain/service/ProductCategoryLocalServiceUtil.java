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

package com.cmc.gateway.domain.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the product category local service. This utility wraps {@link com.cmc.gateway.domain.service.impl.ProductCategoryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductCategoryLocalService
 * @see com.cmc.gateway.domain.service.base.ProductCategoryLocalServiceBaseImpl
 * @see com.cmc.gateway.domain.service.impl.ProductCategoryLocalServiceImpl
 * @generated
 */
public class ProductCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cmc.gateway.domain.service.impl.ProductCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the product category to the database. Also notifies the appropriate model listeners.
	*
	* @param productCategory the product category
	* @return the product category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductCategory addProductCategory(
		com.cmc.gateway.domain.model.ProductCategory productCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProductCategory(productCategory);
	}

	/**
	* Creates a new product category with the primary key. Does not add the product category to the database.
	*
	* @param categoryId the primary key for the new product category
	* @return the new product category
	*/
	public static com.cmc.gateway.domain.model.ProductCategory createProductCategory(
		long categoryId) {
		return getService().createProductCategory(categoryId);
	}

	/**
	* Deletes the product category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the product category
	* @return the product category that was removed
	* @throws PortalException if a product category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductCategory deleteProductCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProductCategory(categoryId);
	}

	/**
	* Deletes the product category from the database. Also notifies the appropriate model listeners.
	*
	* @param productCategory the product category
	* @return the product category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductCategory deleteProductCategory(
		com.cmc.gateway.domain.model.ProductCategory productCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProductCategory(productCategory);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.cmc.gateway.domain.model.ProductCategory fetchProductCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProductCategory(categoryId);
	}

	/**
	* Returns the product category with the primary key.
	*
	* @param categoryId the primary key of the product category
	* @return the product category
	* @throws PortalException if a product category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductCategory getProductCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProductCategory(categoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.cmc.gateway.domain.model.ProductCategory> getProductCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProductCategories(start, end);
	}

	/**
	* Returns the number of product categories.
	*
	* @return the number of product categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getProductCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProductCategoriesCount();
	}

	/**
	* Updates the product category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param productCategory the product category
	* @return the product category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductCategory updateProductCategory(
		com.cmc.gateway.domain.model.ProductCategory productCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProductCategory(productCategory);
	}

	/**
	* Updates the product category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param productCategory the product category
	* @param merge whether to merge the product category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the product category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cmc.gateway.domain.model.ProductCategory updateProductCategory(
		com.cmc.gateway.domain.model.ProductCategory productCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProductCategory(productCategory, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.cmc.gateway.domain.model.ProductCategory update(
		com.cmc.gateway.domain.model.ProductCategory productCategory,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().update(productCategory, serviceContext);
	}

	public static com.cmc.gateway.domain.model.ProductCategory delete(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().delete(categoryId);
	}

	public static com.cmc.gateway.domain.model.ProductCategory delete(
		com.cmc.gateway.domain.model.ProductCategory productCategory)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().delete(productCategory);
	}

	public static void validate(
		com.cmc.gateway.domain.model.ProductCategory productCategory)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().validate(productCategory);
	}

	public static void validateDelete(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().validateDelete(categoryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProductCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ProductCategoryLocalService.class.getName());

			if (invokableLocalService instanceof ProductCategoryLocalService) {
				_service = (ProductCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new ProductCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ProductCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ProductCategoryLocalService service) {
	}

	private static ProductCategoryLocalService _service;
}