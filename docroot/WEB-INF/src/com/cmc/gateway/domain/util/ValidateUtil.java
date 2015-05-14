package com.cmc.gateway.domain.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

public class ValidateUtil {

	/**
	 * Check if value is null then throw new PortalException with message "{name}-can-not-be-null"
	 * @param value value to check null;
	 * @param name name for exception message
	 * @throws PortalException 
	 */
	public static void checkNull(Object value, String name) throws PortalException {
		if (Validator.isNull(value)) {
			throw new PortalException(name + "-can-not-be-null");
		}
	}
}
