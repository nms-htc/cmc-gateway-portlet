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

package com.cmc.gateway.domain.service.messaging;

import com.cmc.gateway.domain.service.AppDomainLocalServiceUtil;
import com.cmc.gateway.domain.service.AppDomainServiceUtil;
import com.cmc.gateway.domain.service.ClpSerializer;
import com.cmc.gateway.domain.service.CommandActionLocalServiceUtil;
import com.cmc.gateway.domain.service.CommandActionServiceUtil;
import com.cmc.gateway.domain.service.CommandEntryLocalServiceUtil;
import com.cmc.gateway.domain.service.CommandEntryServiceUtil;
import com.cmc.gateway.domain.service.ProductActionLocalServiceUtil;
import com.cmc.gateway.domain.service.ProductActionServiceUtil;
import com.cmc.gateway.domain.service.ProductCategoryLocalServiceUtil;
import com.cmc.gateway.domain.service.ProductCategoryServiceUtil;
import com.cmc.gateway.domain.service.ProductEntryLocalServiceUtil;
import com.cmc.gateway.domain.service.ProductEntryServiceUtil;
import com.cmc.gateway.domain.service.ProductMessageLocalServiceUtil;
import com.cmc.gateway.domain.service.ProductMessageServiceUtil;
import com.cmc.gateway.domain.service.ProductRouteLocalServiceUtil;
import com.cmc.gateway.domain.service.ProductRouteServiceUtil;
import com.cmc.gateway.domain.service.ProvisioningActionLocalServiceUtil;
import com.cmc.gateway.domain.service.ProvisioningActionServiceUtil;
import com.cmc.gateway.domain.service.ProvisioningEntryLocalServiceUtil;
import com.cmc.gateway.domain.service.ProvisioningEntryServiceUtil;
import com.cmc.gateway.domain.service.ProvisioningMessageLocalServiceUtil;
import com.cmc.gateway.domain.service.ProvisioningMessageServiceUtil;
import com.cmc.gateway.domain.service.ProvisioningRouteLocalServiceUtil;
import com.cmc.gateway.domain.service.ProvisioningRouteServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AppDomainLocalServiceUtil.clearService();

			AppDomainServiceUtil.clearService();
			CommandActionLocalServiceUtil.clearService();

			CommandActionServiceUtil.clearService();
			CommandEntryLocalServiceUtil.clearService();

			CommandEntryServiceUtil.clearService();
			ProductActionLocalServiceUtil.clearService();

			ProductActionServiceUtil.clearService();
			ProductCategoryLocalServiceUtil.clearService();

			ProductCategoryServiceUtil.clearService();
			ProductEntryLocalServiceUtil.clearService();

			ProductEntryServiceUtil.clearService();
			ProductMessageLocalServiceUtil.clearService();

			ProductMessageServiceUtil.clearService();
			ProductRouteLocalServiceUtil.clearService();

			ProductRouteServiceUtil.clearService();
			ProvisioningActionLocalServiceUtil.clearService();

			ProvisioningActionServiceUtil.clearService();
			ProvisioningEntryLocalServiceUtil.clearService();

			ProvisioningEntryServiceUtil.clearService();
			ProvisioningMessageLocalServiceUtil.clearService();

			ProvisioningMessageServiceUtil.clearService();
			ProvisioningRouteLocalServiceUtil.clearService();

			ProvisioningRouteServiceUtil.clearService();
		}
	}
}