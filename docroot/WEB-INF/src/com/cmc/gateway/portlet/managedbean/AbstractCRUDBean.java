package com.cmc.gateway.portlet.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import org.primefaces.model.LazyDataModel;

import com.cmc.gateway.portlet.model.AbstractLazyDataModel;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

public abstract class AbstractCRUDBean<T extends BaseModel<T>> {
	
	/**
	 * Logger
	 */
	private static final Logger _LOGGER = LoggerFactory.getLogger(AbstractCRUDBean.class);
	public static final String PARAM_ENTITY_KEY = "entityId";
	
	/**
	 *  Current entity to process
	 */
	protected T current;
	/**
	 * lazyDataModel for primefaces lazy datatable
	 */
	protected LazyDataModel<T> lazyDataModel;
	
	@PostConstruct
	public void init() {
		LiferayFacesContext content = LiferayFacesContext.getInstance();
		long entityId = content.getRequestParameterAsLong(PARAM_ENTITY_KEY, 0);
		if (Validator.isNotNull(entityId)) {
			try {
				current = findById(entityId);
			} catch (Exception e) {
				
			}
			
		}
	}
	
	// Bussiness method
	
	protected void afterPersist() {}
	
	protected void beforePersist() {}
	
	public void persist() {
		LiferayFacesContext context = LiferayFacesContext.getInstance();
		try {
			beforePersist();
			addEntity(current);
			current = null; // reset current entity after persist
			afterPersist();
			context.addGlobalSuccessInfoMessage();
		} catch (Exception e) {
			_LOGGER.error(e);
			JsfUtil.handleException(e);
		}
	}
	
	protected void afterUpdate() {}
	
	protected void beforeUpdate() {}
	
	public void update() {
		LiferayFacesContext context = LiferayFacesContext.getInstance();
		try {
			beforeUpdate();
			current = updateEntity(current);
			afterUpdate();
			context.addGlobalSuccessInfoMessage();
		} catch (Exception e) {
			_LOGGER.error(e);
			JsfUtil.handleException(e);
		}
	}
	
	protected void afterRemove(T entity) {}
	
	protected void beforeRemove(T entity) {}
	
	public void remove(T entity) {
		LiferayFacesContext context = LiferayFacesContext.getInstance();
		try {
			beforeRemove(entity);
			removeEntity(entity);
			afterRemove(entity);
			context.addGlobalSuccessInfoMessage();
		} catch (Exception e) {
			_LOGGER.error(e);
			JsfUtil.handleException(e);
		}
	}
	
	// Getters and Setters
	
	public T getCurrent() {
		if (current == null) {
			current = initEntity();
		}
		return current;
	}
	
	public void setCurrent(T current) {
		this.current = current;
	}
	
	public LazyDataModel<T> getLazyDataModel() {
		if (lazyDataModel == null) {
			lazyDataModel = initDataModel();
		}
		return lazyDataModel;
	}
	
	public void setLazyDataModel(LazyDataModel<T> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}
	
	protected abstract T initEntity();
	protected LazyDataModel<T> initDataModel() {
		AbstractLazyDataModel<T> model = new AbstractLazyDataModel<T>() {
			private static final long serialVersionUID = 1L;

			@Override
			protected Class<T> getModelClass() {
				return getEntityClass();
			}

			@Override
			protected DynamicQuery getDynamicQuery() {
				return createDymanicQuery();
			}

			@Override
			protected List<T> query(DynamicQuery query, int start, int end)
					throws SystemException, PortalException {
				if (start >= 0 && end >= start) {
					return queryEntities(query, start, end);
				} else {
					return queryEntities(query);
				}
			}

			@Override
			protected int count(DynamicQuery query) throws SystemException,
					PortalException {
				return countEntities(query);
			}

			@Override
			protected T findById(long id) throws SystemException,
					PortalException {
				return findById(id);
			}
		};
		
		model.setSearcher(getSearcher());
				
		return model;
	}
	protected abstract T addEntity(T entity) throws PortalException, SystemException;
	protected abstract T updateEntity(T entity) throws PortalException, SystemException;
	protected abstract void removeEntity(T entity) throws PortalException, SystemException;
	protected abstract T findById(long id) throws SystemException, PortalException;
	protected abstract int countEntities(DynamicQuery query) throws SystemException, PortalException;
	protected abstract List<T> queryEntities(DynamicQuery query) throws SystemException, PortalException;
	protected abstract List<T> queryEntities(DynamicQuery query, int start, int end) throws SystemException, PortalException;
	protected abstract DynamicQuery createDymanicQuery();
	protected abstract Class<T> getEntityClass();
	protected abstract Searcher getSearcher();
}