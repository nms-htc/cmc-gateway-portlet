package com.cmc.gateway.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmc.gateway.domain.model.ProductCategory;
import com.cmc.gateway.domain.service.ProductCategoryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(forClass = ProductCategory.class)
public class ProductCategoryConverter extends AbstractConverter<ProductCategory> {

	@Override
	protected ProductCategory find(String value) throws SystemException,
			PortalException {
		return ProductCategoryLocalServiceUtil.getProductCategory(Long.parseLong(value));
	}

	@Override
	protected Class<ProductCategory> getModelClass() {
		return ProductCategory.class;
	}

}
