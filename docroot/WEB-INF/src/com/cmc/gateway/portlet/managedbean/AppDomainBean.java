package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

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
	protected int countEntities(DynamicQuery query) throws SystemException,
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
	
	public SelectItem[] getStringItems(String type) {
		SelectItem[] items = null;
		
		try {
			List<AppDomain> domains = AppDomainLocalServiceUtil.findByType(type);
			items = new SelectItem[domains.size()];
			for (int i = 0; i < domains.size(); i++) {
				AppDomain domain = domains.get(i);
				items[i] = new SelectItem(domain.getCode(), domain.getTitle());
			}
			
		} catch (Exception e) {
			logger.warn("Cannot build select items with type {0}, Error message: {1}", type, e.getMessage());
		}
		return items;
	}
	
	public SelectItem[] getLongItems(String type) {
		SelectItem[] items = null;
		
		try {
			List<AppDomain> domains = AppDomainLocalServiceUtil.findByType(type);
			items = new SelectItem[domains.size	()];
			for (int i = 0; i < domains.size(); i++) {
				AppDomain domain = domains.get(i);
				long value = 0;
				try {
					value = Long.parseLong(domain.getCode());
				} catch (NumberFormatException e) {
					logger.error("Error when try parse {0} to long", domain.getCode());
					continue;
				}
				items[i] = new SelectItem(value, domain.getTitle());
			}
			
		} catch (Exception e) {
			logger.warn("Cannot build select items with type {0}, Error message: {1}", type, e.getMessage());
		}
		
		return items;
	}
	
	public SelectItem[] getIntItems(String type) {
		SelectItem[] items = null;
		
		try {
			List<AppDomain> domains = AppDomainLocalServiceUtil.findByType(type);
			items = new SelectItem[domains.size()];
			for (int i = 0; i < domains.size(); i++) {
				AppDomain domain = domains.get(i);
				int value = 0;
				try {
					value = Integer.parseInt(domain.getCode());
				} catch (NumberFormatException e) {
					logger.error("error when try parsing {0} to int", domain.getCode());
					continue;
				}
				items[i] = new SelectItem(value, domain.getTitle());
			}
			
		} catch (Exception e) {
			logger.warn("Cannot build select items with type {0}, Error message: {1}", type, e.getMessage());
		}
		return items;
	}
	
	public String getDomainTitle(String type, String code) {
		String title = null;
		
		try {
			AppDomain appDomain = AppDomainLocalServiceUtil.findByCodeAndType(code, type);
			title = appDomain.getTitle();
		} catch (Exception e) {
			logger.error("Error when try get title of domain with type = {0}, code = {1}, Error: {2}", type, code, e.getMessage());
		}
		
		return title;
	}

}
