package com.cmc.gateway.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmc.gateway.domain.model.ProductEntry;
import com.cmc.gateway.domain.service.ProductEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(forClass = ProductEntry.class)
public class ProductEntryConverter extends AbstractConverter<ProductEntry> {

	@Override
	protected ProductEntry find(String value) throws SystemException,
			PortalException {
		return ProductEntryLocalServiceUtil.getProductEntry(Long.parseLong(value));
	}

	@Override
	protected Class<ProductEntry> getModelClass() {
		return ProductEntry.class;
	}

}
