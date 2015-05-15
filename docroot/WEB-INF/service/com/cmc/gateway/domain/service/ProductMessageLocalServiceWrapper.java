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
 * This class is a wrapper for {@link ProductMessageLocalService}.
 * </p>
 *
 * @author    Richard Nguyen
 * @see       ProductMessageLocalService
 * @generated
 */
public class ProductMessageLocalServiceWrapper
	implements ProductMessageLocalService,
		ServiceWrapper<ProductMessageLocalService> {
	public ProductMessageLocalServiceWrapper(
		ProductMessageLocalService productMessageLocalService) {
		_productMessageLocalService = productMessageLocalService;
	}

	/**
	* Adds the product message to the database. Also notifies the appropriate model listeners.
	*
	* @param productMessage the product message
	* @return the product message that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage addProductMessage(
		com.cmc.gateway.domain.model.ProductMessage productMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productMessageLocalService.addProductMessage(productMessage);
	}

	/**
	* Creates a new product message with the primary key. Does not add the product message to the database.
	*
	* @param messageId the primary key for the new product message
	* @return the new product message
	*/
	public com.cmc.gateway.domain.model.ProductMessage createProductMessage(
		long messageId) {
		return _productMessageLocalService.createProductMessage(messageId);
	}

	/**
	* Deletes the product message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the product message
	* @return the product message that was removed
	* @throws PortalException if a product message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage deleteProductMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productMessageLocalService.deleteProductMessage(messageId);
	}

	/**
	* Deletes the product message from the database. Also notifies the appropriate model listeners.
	*
	* @param productMessage the product message
	* @return the product message that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage deleteProductMessage(
		com.cmc.gateway.domain.model.ProductMessage productMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productMessageLocalService.deleteProductMessage(productMessage);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productMessageLocalService.dynamicQuery();
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
		return _productMessageLocalService.dynamicQuery(dynamicQuery);
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
		return _productMessageLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _productMessageLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _productMessageLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.cmc.gateway.domain.model.ProductMessage fetchProductMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productMessageLocalService.fetchProductMessage(messageId);
	}

	/**
	* Returns the product message with the primary key.
	*
	* @param messageId the primary key of the product message
	* @return the product message
	* @throws PortalException if a product message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage getProductMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productMessageLocalService.getProductMessage(messageId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productMessageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the product messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of product messages
	* @param end the upper bound of the range of product messages (not inclusive)
	* @return the range of product messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cmc.gateway.domain.model.ProductMessage> getProductMessages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productMessageLocalService.getProductMessages(start, end);
	}

	/**
	* Returns the number of product messages.
	*
	* @return the number of product messages
	* @throws SystemException if a system exception occurred
	*/
	public int getProductMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productMessageLocalService.getProductMessagesCount();
	}

	/**
	* Updates the product message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param productMessage the product message
	* @return the product message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage updateProductMessage(
		com.cmc.gateway.domain.model.ProductMessage productMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productMessageLocalService.updateProductMessage(productMessage);
	}

	/**
	* Updates the product message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param productMessage the product message
	* @param merge whether to merge the product message with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the product message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.cmc.gateway.domain.model.ProductMessage updateProductMessage(
		com.cmc.gateway.domain.model.ProductMessage productMessage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productMessageLocalService.updateProductMessage(productMessage,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _productMessageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_productMessageLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _productMessageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.cmc.gateway.domain.model.ProductMessage update(
		com.cmc.gateway.domain.model.ProductMessage productMessage,
		com.liferay.portal.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productMessageLocalService.update(productMessage, context);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ProductMessageLocalService getWrappedProductMessageLocalService() {
		return _productMessageLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedProductMessageLocalService(
		ProductMessageLocalService productMessageLocalService) {
		_productMessageLocalService = productMessageLocalService;
	}

	public ProductMessageLocalService getWrappedService() {
		return _productMessageLocalService;
	}

	public void setWrappedService(
		ProductMessageLocalService productMessageLocalService) {
		_productMessageLocalService = productMessageLocalService;
	}

	private ProductMessageLocalService _productMessageLocalService;
}