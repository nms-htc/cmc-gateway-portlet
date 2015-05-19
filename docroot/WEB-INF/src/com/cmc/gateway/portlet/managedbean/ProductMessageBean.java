package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cmc.gateway.domain.model.ProductMessage;
import com.cmc.gateway.domain.service.ProductMessageLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class ProductMessageBean extends AbstractCRUDBean<ProductMessage> implements Serializable{

	private static final long serialVersionUID = 4762919767736865934L;
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ProductMessageBean.class);

	@Override
	protected ProductMessage initEntity() {
		return ProductMessageLocalServiceUtil.createProductMessage(0);
	}

	@Override
	protected ProductMessage addEntity(ProductMessage entity)
			throws PortalException, SystemException {
		return ProductMessageLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected ProductMessage updateEntity(ProductMessage entity)
			throws PortalException, SystemException {
		return ProductMessageLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(ProductMessage entity) throws PortalException,
			SystemException {
		ProductMessageLocalServiceUtil.deleteProductMessage(entity);
	}

	@Override
	protected ProductMessage findById(long id) throws SystemException,
			PortalException {
		return ProductMessageLocalServiceUtil.getProductMessage(id);
	}

	@Override
	protected int countEntities(DynamicQuery query) throws SystemException,
			PortalException {
		return Long.valueOf(ProductMessageLocalServiceUtil.dynamicQueryCount(query)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProductMessage> queryEntities(DynamicQuery query)
			throws SystemException, PortalException {
		return ProductMessageLocalServiceUtil.dynamicQuery(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProductMessage> queryEntities(DynamicQuery query, int start,
			int end) throws SystemException, PortalException {
		return ProductMessageLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return ProductMessageLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<ProductMessage> getEntityClass() {
		return ProductMessage.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}

}
