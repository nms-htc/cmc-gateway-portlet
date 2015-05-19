package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmc.gateway.domain.model.CommandEntry;
import com.cmc.gateway.domain.service.CommandEntryLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class CommandEntryBean extends AbstractCRUDBean<CommandEntry> implements Serializable{

	private static final long serialVersionUID = 1126113998589873977L;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(CommandEntryBean.class);

	@Override
	protected CommandEntry initEntity() {
		return CommandEntryLocalServiceUtil.createCommandEntry(0);
	}

	@Override
	protected CommandEntry addEntity(CommandEntry entity)
			throws PortalException, SystemException {
		return CommandEntryLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected CommandEntry updateEntity(CommandEntry entity)
			throws PortalException, SystemException {
		return CommandEntryLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(CommandEntry entity) throws PortalException,
			SystemException {
		CommandEntryLocalServiceUtil.deleteCommandEntry(entity);
	}

	@Override
	protected CommandEntry findById(long id) throws SystemException,
			PortalException {
		return CommandEntryLocalServiceUtil.getCommandEntry(id);
	}

	@Override
	protected int countEntities(DynamicQuery query) throws SystemException,
			PortalException {
		return Long.valueOf(CommandEntryLocalServiceUtil.dynamicQueryCount(query)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<CommandEntry> queryEntities(DynamicQuery query)
			throws SystemException, PortalException {
		return CommandEntryLocalServiceUtil.dynamicQuery(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<CommandEntry> queryEntities(DynamicQuery query, int start,
			int end) throws SystemException, PortalException {
		return CommandEntryLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return CommandEntryLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<CommandEntry> getEntityClass() {
		return CommandEntry.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}

}
