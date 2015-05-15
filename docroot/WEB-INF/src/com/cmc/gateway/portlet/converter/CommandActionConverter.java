package com.cmc.gateway.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmc.gateway.domain.model.CommandAction;
import com.cmc.gateway.domain.service.CommandActionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(forClass = CommandAction.class)
public class CommandActionConverter extends AbstractConverter<CommandAction> {

	@Override
	protected CommandAction find(String value) throws SystemException,
			PortalException {
		return CommandActionLocalServiceUtil.getCommandAction(Long.parseLong(value));
	}

	@Override
	protected Class<CommandAction> getModelClass() {
		return CommandAction.class;
	}
	
}
