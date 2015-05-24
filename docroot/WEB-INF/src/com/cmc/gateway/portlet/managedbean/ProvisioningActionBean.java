package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmc.gateway.domain.model.ProvisioningAction;
import com.cmc.gateway.domain.service.ProvisioningActionLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class ProvisioningActionBean extends AbstractCRUDBean<ProvisioningAction> implements Serializable{

	private static final long serialVersionUID = 3404226777113747906L;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ProvisioningActionBean.class);

	@Override
	protected ProvisioningAction initEntity() {
		return ProvisioningActionLocalServiceUtil.createProvisioningAction(0);
	}

	@Override
	protected ProvisioningAction addEntity(ProvisioningAction entity) throws PortalException, SystemException {
		return ProvisioningActionLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected ProvisioningAction updateEntity(ProvisioningAction entity) throws PortalException, SystemException {
		return ProvisioningActionLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(ProvisioningAction entity) throws PortalException, SystemException {
		ProvisioningActionLocalServiceUtil.deleteProvisioningAction(entity);
	}

	@Override
	protected ProvisioningAction findById(long id) throws SystemException, PortalException {
		return ProvisioningActionLocalServiceUtil.getProvisioningAction(id);
	}

	@Override
	protected int countEntities(DynamicQuery query) throws SystemException, PortalException {
		return Long.valueOf(ProvisioningActionLocalServiceUtil.dynamicQueryCount(query)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProvisioningAction> queryEntities(DynamicQuery query) throws SystemException, PortalException {
		return ProvisioningActionLocalServiceUtil.dynamicQuery(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProvisioningAction> queryEntities(DynamicQuery query, int start, int end) throws SystemException, PortalException {
		return ProvisioningActionLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return ProvisioningActionLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<ProvisioningAction> getEntityClass() {
		return ProvisioningAction.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}

}
