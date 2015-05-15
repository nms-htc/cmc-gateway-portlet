package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmc.gateway.domain.model.ProductRoute;
import com.cmc.gateway.domain.service.ProductRouteLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class ProductRouteBean extends AbstractCRUDBean<ProductRoute> implements Serializable{

	private static final long serialVersionUID = -7584316219549834970L;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ProductRouteBean.class);

	@Override
	protected ProductRoute initEntity() {
		return ProductRouteLocalServiceUtil.createProductRoute(0);
	}

	@Override
	protected ProductRoute addEntity(ProductRoute entity)
			throws PortalException, SystemException {
		return ProductRouteLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected ProductRoute updateEntity(ProductRoute entity)
			throws PortalException, SystemException {
		return ProductRouteLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(ProductRoute entity) throws PortalException,
			SystemException {
		ProductRouteLocalServiceUtil.deleteProductRoute(entity);
	}

	@Override
	protected ProductRoute findById(long id) throws SystemException,
			PortalException {
		return ProductRouteLocalServiceUtil.getProductRoute(id);
	}

	@Override
	protected int count(DynamicQuery query) throws SystemException,
			PortalException {
		return Long.valueOf(ProductRouteLocalServiceUtil.dynamicQueryCount(query)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProductRoute> queryEntities(DynamicQuery query)
			throws SystemException, PortalException {
		return ProductRouteLocalServiceUtil.dynamicQuery(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProductRoute> queryEntities(DynamicQuery query, int start,
			int end) throws SystemException, PortalException {
		return ProductRouteLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return ProductRouteLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<ProductRoute> getEntityClass() {
		return ProductRoute.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}

}
