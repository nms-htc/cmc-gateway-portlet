/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.cmc.gateway.domain;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Richard Nguyen
 */
public class NoSuchCommandActionException extends NoSuchModelException {

	public NoSuchCommandActionException() {
		super();
	}

	public NoSuchCommandActionException(String msg) {
		super(msg);
	}

	public NoSuchCommandActionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCommandActionException(Throwable cause) {
		super(cause);
	}

}