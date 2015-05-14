package com.cmc.gateway.portlet.managedbean;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;

public interface Searcher {
	public DynamicQuery getSearchQuery();
}
