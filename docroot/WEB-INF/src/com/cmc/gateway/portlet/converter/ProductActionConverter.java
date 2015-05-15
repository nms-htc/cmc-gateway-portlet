package com.cmc.gateway.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmc.gateway.domain.model.ProductAction;
import com.cmc.gateway.domain.service.ProductActionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(forClass = ProductAction.class)
public class ProductActionConverter extends AbstractConverter<ProductAction>{

	@Override
	protected ProductAction find(String value) throws SystemException,
			PortalException {
		return ProductActionLocalServiceUtil.getProductAction(Long.parseLong(value));
	}

	@Override
	protected Class<ProductAction> getModelClass() {
		return ProductAction.class;
	}

}
