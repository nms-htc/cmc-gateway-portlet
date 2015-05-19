package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmc.gateway.domain.model.CommandAction;
import com.cmc.gateway.domain.service.CommandActionLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class CommandActionBean extends AbstractCRUDBean<CommandAction> implements Serializable {

	private static final long serialVersionUID = 1056470463861523863L;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(CommandActionBean.class);

	@Override
	protected CommandAction initEntity() {
		return CommandActionLocalServiceUtil.createCommandAction(0);
	}

	@Override
	protected CommandAction addEntity(CommandAction entity)
			throws PortalException, SystemException {
		return CommandActionLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected CommandAction updateEntity(CommandAction entity)
			throws PortalException, SystemException {
		return CommandActionLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(CommandAction entity) throws PortalException,
			SystemException {
		CommandActionLocalServiceUtil.deleteCommandAction(entity);
	}

	@Override
	protected CommandAction findById(long id) throws SystemException,
			PortalException {
		return CommandActionLocalServiceUtil.getCommandAction(id);
	}

	@Override
	protected int countEntities(DynamicQuery query) throws SystemException,
			PortalException {
		return Long.valueOf(CommandActionLocalServiceUtil.dynamicQueryCount(query)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<CommandAction> queryEntities(DynamicQuery query)
			throws SystemException, PortalException {
		return CommandActionLocalServiceUtil.dynamicQuery(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<CommandAction> queryEntities(DynamicQuery query, int start,
			int end) throws SystemException, PortalException {
		return CommandActionLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return CommandActionLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<CommandAction> getEntityClass() {
		return CommandAction.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}
}
