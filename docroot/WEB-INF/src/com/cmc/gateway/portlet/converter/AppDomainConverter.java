package com.cmc.gateway.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmc.gateway.domain.model.AppDomain;
import com.cmc.gateway.domain.service.AppDomainLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(forClass = AppDomain.class)
public class AppDomainConverter extends AbstractConverter<AppDomain> {

	@Override
	protected AppDomain find(String value) throws SystemException,
			PortalException {
		return AppDomainLocalServiceUtil.getAppDomain(Long.parseLong(value));
	}

	@Override
	protected Class<AppDomain> getModelClass() {
		return AppDomain.class;
	}

}
