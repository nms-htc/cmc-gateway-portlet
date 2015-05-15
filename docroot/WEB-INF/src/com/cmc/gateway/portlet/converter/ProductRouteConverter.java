package com.cmc.gateway.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmc.gateway.domain.model.ProductRoute;
import com.cmc.gateway.domain.service.ProductRouteLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(forClass = ProductRoute.class)
public class ProductRouteConverter extends AbstractConverter<ProductRoute> {

	@Override
	protected ProductRoute find(String value) throws SystemException,
			PortalException {
		return ProductRouteLocalServiceUtil.getProductRoute(Long.parseLong(value));
	}

	@Override
	protected Class<ProductRoute> getModelClass() {
		return ProductRoute.class;
	}

}
