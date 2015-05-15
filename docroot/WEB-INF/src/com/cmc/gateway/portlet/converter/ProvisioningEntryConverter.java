package com.cmc.gateway.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmc.gateway.domain.model.ProvisioningEntry;
import com.cmc.gateway.domain.service.ProvisioningEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(forClass = ProvisioningEntry.class)
public class ProvisioningEntryConverter extends AbstractConverter<ProvisioningEntry> {

	@Override
	protected ProvisioningEntry find(String value) throws SystemException,
			PortalException {
		return ProvisioningEntryLocalServiceUtil.getProvisioningEntry(Long.parseLong(value));
	}

	@Override
	protected Class<ProvisioningEntry> getModelClass() {
		return ProvisioningEntry.class;
	}

}
