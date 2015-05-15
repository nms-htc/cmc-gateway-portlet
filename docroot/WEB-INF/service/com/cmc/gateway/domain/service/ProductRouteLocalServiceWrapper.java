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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ProductRouteLocalService}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProductRouteLocalService
 * @generated
 */
public class ProductRouteLocalServiceWrapper implements ProductRouteLocalService,
	ServiceWrapper<ProductRouteLocalService> {
	public ProductRouteLocalServiceWrapper(
		ProductRouteLocalService productRouteLocalService) {
		_productRouteLocalService = productRouteLocalService;
	}

	/**
	* Adds the product route to the database. Also notifies the appropriate model listeners.
	*
	* @param productRoute the product route
	* @return the product route that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductRoute addProductRoute(
		com.cmc.gateway.domain.model.ProductRoute productRoute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.addProductRoute(productRoute);
	}

	/**
	* Creates a new product route with the primary key. Does not add the product route to the database.
	*
	* @param routeId the primary key for the new product route
	* @return the new product route
	*/
	public com.cmc.gateway.domain.model.ProductRoute createProductRoute(
		long routeId) {
		return _productRouteLocalService.createProductRoute(routeId);
	}

	/**
	* Deletes the product route with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param routeId the primary key of the product route
	* @return the product route that was removed
	* @throws PortalException if a product route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductRoute deleteProductRoute(
		long routeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.deleteProductRoute(routeId);
	}

	/**
	* Deletes the product route from the database. Also notifies the appropriate model listeners.
	*
	* @param productRoute the product route
	* @return the product route that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductRoute deleteProductRoute(
		com.cmc.gateway.domain.model.ProductRoute productRoute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.deleteProductRoute(productRoute);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productRouteLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cmc.gateway.domain.model.ProductRoute fetchProductRoute(
		long routeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.fetchProductRoute(routeId);
	}

	/**
	* Returns the product route with the primary key.
	*
	* @param routeId the primary key of the product route
	* @return the product route
	* @throws PortalException if a product route with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductRoute getProductRoute(
		long routeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.getProductRoute(routeId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the product routes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product routes
	* @param end the upper bound of the range of product routes (not inclusive)
	* @return the range of product routes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductRoute> getProductRoutes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.getProductRoutes(start, end);
	}

	/**
	* Returns the number of product routes.
	*
	* @return the number of product routes
	* @throws SystemException if a system exception occurred
	*/
	public int getProductRoutesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.getProductRoutesCount();
	}

	/**
	* Updates the product route in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param productRoute the product route
	* @return the product route that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductRoute updateProductRoute(
		com.cmc.gateway.domain.model.ProductRoute productRoute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.updateProductRoute(productRoute);
	}

	/**
	* Updates the product route in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param productRoute the product route
	* @param merge whether to merge the product route with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the product route that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductRoute updateProductRoute(
		com.cmc.gateway.domain.model.ProductRoute productRoute, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.updateProductRoute(productRoute, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _productRouteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_productRouteLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _productRouteLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.cmc.gateway.domain.model.ProductRoute update(
		com.cmc.gateway.domain.model.ProductRoute productRoute,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productRouteLocalService.update(productRoute, context);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ProductRouteLocalService getWrappedProductRouteLocalService() {
		return _productRouteLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedProductRouteLocalService(
		ProductRouteLocalService productRouteLocalService) {
		_productRouteLocalService = productRouteLocalService;
	}

	public ProductRouteLocalService getWrappedService() {
		return _productRouteLocalService;
	}

	public void setWrappedService(
		ProductRouteLocalService productRouteLocalService) {
		_productRouteLocalService = productRouteLocalService;
	}

	private ProductRouteLocalService _productRouteLocalService;
}