package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmc.gateway.domain.model.AppDomain;
import com.cmc.gateway.domain.service.AppDomainLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class AppDomainBean extends AbstractCRUDBean<AppDomain> implements Serializable {

	private static final long serialVersionUID = 829906766355926232L;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(AppDomain.class);

	@Override
	protected AppDomain initEntity() {
		return AppDomainLocalServiceUtil.createAppDomain(0);
	}

	@Override
	protected AppDomain addEntity(AppDomain entity) throws PortalException,
			SystemException {
		return AppDomainLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected AppDomain updateEntity(AppDomain entity) throws PortalException,
			SystemException {
		return AppDomainLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(AppDomain entity) throws PortalException,
			SystemException {
		AppDomainLocalServiceUtil.deleteAppDomain(entity);
	}

	@Override
	protected AppDomain findById(long id) throws SystemException, PortalException {
		return AppDomainLocalServiceUtil.getAppDomain(id);
	}

	@Override
	protected int count(DynamicQuery query) throws SystemException,
			PortalException {
		return Long.valueOf(AppDomainLocalServiceUtil.dynamicQueryCount(query)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<AppDomain> queryEntities(DynamicQuery query)
			throws SystemException, PortalException {
		return AppDomainLocalServiceUtil.dynamicQuery(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<AppDomain> queryEntities(DynamicQuery query, int start,
			int end) throws SystemException, PortalException {
		return AppDomainLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return AppDomainLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<AppDomain> getEntityClass() {
		return AppDomain.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}

}
