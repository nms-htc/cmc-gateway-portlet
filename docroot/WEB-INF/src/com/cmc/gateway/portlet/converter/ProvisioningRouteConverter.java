package com.cmc.gateway.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmc.gateway.domain.model.ProvisioningRoute;
import com.cmc.gateway.domain.service.ProvisioningRouteLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(forClass = ProvisioningRoute.class)
public class ProvisioningRouteConverter extends AbstractConverter<ProvisioningRoute> {

	@Override
	protected ProvisioningRoute find(String value) throws SystemException,
			PortalException {
		return ProvisioningRouteLocalServiceUtil.getProvisioningRoute(Long.parseLong(value));
	}

	@Override
	protected Class<ProvisioningRoute> getModelClass() {
		return ProvisioningRoute.class;
	}

}
