package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmc.gateway.domain.model.ProvisioningRoute;
import com.cmc.gateway.domain.service.ProvisioningRouteLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class ProvisioningRouteBean extends AbstractCRUDBean<ProvisioningRoute> implements Serializable {

	private static final long serialVersionUID = 989853615258674877L;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ProvisioningRouteBean.class);

	@Override
	protected ProvisioningRoute initEntity() {
		return ProvisioningRouteLocalServiceUtil.createProvisioningRoute(0);
	}

	@Override
	protected ProvisioningRoute addEntity(ProvisioningRoute entity)
			throws PortalException, SystemException {
		return ProvisioningRouteLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected ProvisioningRoute updateEntity(ProvisioningRoute entity)
			throws PortalException, SystemException {
		return ProvisioningRouteLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(ProvisioningRoute entity)
			throws PortalException, SystemException {
		ProvisioningRouteLocalServiceUtil.deleteProvisioningRoute(entity);
	}

	@Override
	protected ProvisioningRoute findById(long id) throws SystemException,
			PortalException {
		return ProvisioningRouteLocalServiceUtil.getProvisioningRoute(id);
	}

	@Override
	protected int count(DynamicQuery query) throws SystemException,
			PortalException {
		return Long.valueOf(ProvisioningRouteLocalServiceUtil.dynamicQueryCount(query)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProvisioningRoute> queryEntities(DynamicQuery query)
			throws SystemException, PortalException {
		return ProvisioningRouteLocalServiceUtil.dynamicQuery(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProvisioningRoute> queryEntities(DynamicQuery query,
			int start, int end) throws SystemException, PortalException {
		return ProvisioningRouteLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return ProvisioningRouteLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<ProvisioningRoute> getEntityClass() {
		return ProvisioningRoute.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}

}
