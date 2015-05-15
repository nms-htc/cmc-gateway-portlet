package com.cmc.gateway.portlet.converter;

import javax.faces.convert.FacesConverter;

import com.cmc.gateway.domain.model.CommandEntry;
import com.cmc.gateway.domain.service.CommandEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(forClass = CommandEntry.class)
public class CommandEntryConverter extends AbstractConverter<CommandEntry>{

	@Override
	protected CommandEntry find(String value) throws SystemException,
			PortalException {
		return CommandEntryLocalServiceUtil.getCommandEntry(Long.parseLong(value));
	}

	@Override
	protected Class<CommandEntry> getModelClass() {
		return CommandEntry.class;
	}

}
