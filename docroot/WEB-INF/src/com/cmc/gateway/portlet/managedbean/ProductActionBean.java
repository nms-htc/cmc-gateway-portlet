package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmc.gateway.domain.model.ProductAction;
import com.cmc.gateway.domain.service.ProductActionLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class ProductActionBean extends AbstractCRUDBean<ProductAction> implements Serializable {

	private static final long serialVersionUID = 5292384190924603070L;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ProductActionBean.class);

	@Override
	protected ProductAction initEntity() {
		return ProductActionLocalServiceUtil.createProductAction(0);
	}

	@Override
	protected ProductAction addEntity(ProductAction entity)
			throws PortalException, SystemException {
		return ProductActionLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected ProductAction updateEntity(ProductAction entity)
			throws PortalException, SystemException {
		return ProductActionLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(ProductAction entity) throws PortalException,
			SystemException {
		ProductActionLocalServiceUtil.deleteProductAction(entity);
	}

	@Override
	protected ProductAction findById(long id) throws SystemException,
			PortalException {
		return ProductActionLocalServiceUtil.getProductAction(id);
	}

	@Override
	protected int count(DynamicQuery query) throws SystemException,
			PortalException {
		return Long.valueOf(ProductActionLocalServiceUtil.dynamicQueryCount(query)).intValue();
	}

	@Override
	protected List<ProductAction> queryEntities(DynamicQuery query)
			throws SystemException, PortalException {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProductAction> queryEntities(DynamicQuery query, int start,
			int end) throws SystemException, PortalException {
		return ProductActionLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return ProductActionLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<ProductAction> getEntityClass() {
		return ProductAction.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}

}
