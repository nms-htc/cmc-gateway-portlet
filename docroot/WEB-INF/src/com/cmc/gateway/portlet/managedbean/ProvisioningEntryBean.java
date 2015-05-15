package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmc.gateway.domain.model.ProvisioningEntry;
import com.cmc.gateway.domain.service.ProvisioningEntryLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class ProvisioningEntryBean extends AbstractCRUDBean<ProvisioningEntry> implements Serializable {

	private static final long serialVersionUID = 6975327274200645693L;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ProvisioningEntryBean.class);

	@Override
	protected ProvisioningEntry initEntity() {
		return ProvisioningEntryLocalServiceUtil.createProvisioningEntry(0);
	}

	@Override
	protected ProvisioningEntry addEntity(ProvisioningEntry entity)
			throws PortalException, SystemException {
		return ProvisioningEntryLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected ProvisioningEntry updateEntity(ProvisioningEntry entity)
			throws PortalException, SystemException {
		return ProvisioningEntryLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(ProvisioningEntry entity)
			throws PortalException, SystemException {
		ProvisioningEntryLocalServiceUtil.deleteProvisioningEntry(entity);
	}

	@Override
	protected ProvisioningEntry findById(long id) throws SystemException,
			PortalException {
		return ProvisioningEntryLocalServiceUtil.getProvisioningEntry(id);
	}

	@Override
	protected int count(DynamicQuery query) throws SystemException,
			PortalException {
		return Long.valueOf(ProvisioningEntryLocalServiceUtil.dynamicQueryCount(query)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProvisioningEntry> queryEntities(DynamicQuery query)
			throws SystemException, PortalException {
		return ProvisioningEntryLocalServiceUtil.dynamicQuery(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProvisioningEntry> queryEntities(DynamicQuery query,
			int start, int end) throws SystemException, PortalException {
		return ProvisioningEntryLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return ProvisioningEntryLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<ProvisioningEntry> getEntityClass() {
		return ProvisioningEntry.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}

}
