package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmc.gateway.domain.model.ProvisioningMessage;
import com.cmc.gateway.domain.service.ProvisioningMessageLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class ProvisioningMessageBean extends AbstractCRUDBean<ProvisioningMessage> implements Serializable {

	private static final long serialVersionUID = 8454971141761402505L;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ProvisioningMessageBean.class);

	@Override
	protected ProvisioningMessage initEntity() {
		return ProvisioningMessageLocalServiceUtil.createProvisioningMessage(0);
	}

	@Override
	protected ProvisioningMessage addEntity(ProvisioningMessage entity)
			throws PortalException, SystemException {
		return ProvisioningMessageLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected ProvisioningMessage updateEntity(ProvisioningMessage entity)
			throws PortalException, SystemException {
		return ProvisioningMessageLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(ProvisioningMessage entity)
			throws PortalException, SystemException {
		ProvisioningMessageLocalServiceUtil.deleteProvisioningMessage(entity);
	}

	@Override
	protected ProvisioningMessage findById(long id) throws SystemException,
			PortalException {
		return ProvisioningMessageLocalServiceUtil.getProvisioningMessage(id);
	}

	@Override
	protected int countEntities(DynamicQuery query) throws SystemException,
			PortalException {
		return Long.valueOf(ProvisioningMessageLocalServiceUtil.dynamicQueryCount(query)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProvisioningMessage> queryEntities(DynamicQuery query)
			throws SystemException, PortalException {
		return ProvisioningMessageLocalServiceUtil.dynamicQuery(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProvisioningMessage> queryEntities(DynamicQuery query,
			int start, int end) throws SystemException, PortalException {
		return ProvisioningMessageLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return ProvisioningMessageLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<ProvisioningMessage> getEntityClass() {
		return ProvisioningMessage.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}

}
