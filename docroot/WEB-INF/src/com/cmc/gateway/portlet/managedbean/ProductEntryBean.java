package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.cmc.gateway.domain.model.ProductEntry;
import com.cmc.gateway.domain.service.ProductEntryLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class ProductEntryBean extends AbstractCRUDBean<ProductEntry> implements
		Serializable {

	private static final long serialVersionUID = 3386261638355281972L;
	private static final Logger logger = LoggerFactory
			.getLogger(ProductEntryBean.class);
	
	private SelectItem[] items;

	@Override
	protected ProductEntry initEntity() {
		return ProductEntryLocalServiceUtil.createProductEntry(0);
	}

	@Override
	protected ProductEntry addEntity(ProductEntry entity)
			throws PortalException, SystemException {
		return ProductEntryLocalServiceUtil.update(entity,
				JsfUtil.getServiceContext());
	}

	@Override
	protected ProductEntry updateEntity(ProductEntry entity)
			throws PortalException, SystemException {
		return ProductEntryLocalServiceUtil.update(entity,
				JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(ProductEntry entity) throws PortalException,
			SystemException {
		ProductEntryLocalServiceUtil.deleteProductEntry(entity);
	}

	@Override
	protected ProductEntry findById(long id) throws SystemException,
			PortalException {
		return ProductEntryLocalServiceUtil.getProductEntry(id);
	}

	@Override
	protected int countEntities(DynamicQuery query) throws SystemException,
			PortalException {
		return Long.valueOf(
				ProductEntryLocalServiceUtil.dynamicQueryCount(query))
				.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProductEntry> queryEntities(DynamicQuery query)
			throws SystemException, PortalException {
		return ProductEntryLocalServiceUtil.dynamicQuery(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProductEntry> queryEntities(DynamicQuery query, int start,
			int end) throws SystemException, PortalException {
		return ProductEntryLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return ProductEntryLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<ProductEntry> getEntityClass() {
		return ProductEntry.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}
	
	public SelectItem[] getItems() {
		if (items == null) {
			try {
				List<ProductEntry> products = queryEntities(createDymanicQuery());
				items = new SelectItem[products.size()];
				for (int i = 0; i < products.size(); i++) {
					ProductEntry product = products.get(i);
					items[i] = new SelectItem(product.getProductId(), product.getTitle());
				}
			} catch (Exception e) {
				logger.warn("Cannot create select items of product. Error: {0}", e.getMessage());
			}
		}
		return items;
	}
	
	public String getProductTitle(long productId) {
		String title = null;
		try {
			ProductEntry product = findById(productId);
			title = product.getTitle();
		} catch (Exception e) {
			logger.error("Cannot fetch product entry with productId = {0}, Error message: {1}", productId, e.getMessage());
		}
		return title;
	}

}
