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
 * This class is a wrapper for {@link ProductRouteService}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProductRouteService
 * @generated
 */
public class ProductRouteServiceWrapper implements ProductRouteService,
	ServiceWrapper<ProductRouteService> {
	public ProductRouteServiceWrapper(ProductRouteService productRouteService) {
		_productRouteService = productRouteService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _productRouteService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_productRouteService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _productRouteService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ProductRouteService getWrappedProductRouteService() {
		return _productRouteService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedProductRouteService(
		ProductRouteService productRouteService) {
		_productRouteService = productRouteService;
	}

	public ProductRouteService getWrappedService() {
		return _productRouteService;
	}

	public void setWrappedService(ProductRouteService productRouteService) {
		_productRouteService = productRouteService;
	}

	private ProductRouteService _productRouteService;
}