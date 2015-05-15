package com.cmc.gateway.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmc.gateway.domain.model.ProductMessage;
import com.cmc.gateway.domain.service.ProductMessageLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(forClass = ProductMessage.class)
public class ProductMessageConverter extends AbstractConverter<ProductMessage> {

	@Override
	protected ProductMessage find(String value) throws SystemException,
			PortalException {
		return ProductMessageLocalServiceUtil.getProductMessage(Long.parseLong(value));
	}

	@Override
	protected Class<ProductMessage> getModelClass() {
		return ProductMessage.class;
	}

}
