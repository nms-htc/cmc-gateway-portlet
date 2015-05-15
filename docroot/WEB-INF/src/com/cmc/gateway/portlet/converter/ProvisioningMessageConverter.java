package com.cmc.gateway.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmc.gateway.domain.model.ProvisioningMessage;
import com.cmc.gateway.domain.service.ProvisioningMessageLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(forClass = ProvisioningMessage.class)
public class ProvisioningMessageConverter extends AbstractConverter<ProvisioningMessage> {

	@Override
	protected ProvisioningMessage find(String value) throws SystemException,
			PortalException {
		return ProvisioningMessageLocalServiceUtil.getProvisioningMessage(Long.parseLong(value));
	}

	@Override
	protected Class<ProvisioningMessage> getModelClass() {
		return ProvisioningMessage.class;
	}

}
