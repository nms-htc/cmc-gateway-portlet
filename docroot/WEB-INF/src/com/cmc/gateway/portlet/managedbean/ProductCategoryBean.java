package com.cmc.gateway.portlet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.cmc.gateway.domain.model.ProductCategory;
import com.cmc.gateway.domain.service.ProductCategoryLocalServiceUtil;
import com.cmc.gateway.portlet.util.JsfUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@ViewScoped
public class ProductCategoryBean extends AbstractCRUDBean<ProductCategory> implements Serializable {

	private static final long serialVersionUID = -2336597554994830653L;
	private static final Logger logger = LoggerFactory.getLogger(ProductCategoryBean.class);
	
	private SelectItem[] items;

	@Override
	protected ProductCategory initEntity() {
		return ProductCategoryLocalServiceUtil.createProductCategory(0);
	}

	@Override
	protected ProductCategory addEntity(ProductCategory entity)
			throws PortalException, SystemException {
		return ProductCategoryLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected ProductCategory updateEntity(ProductCategory entity)
			throws PortalException, SystemException {
		return ProductCategoryLocalServiceUtil.update(entity, JsfUtil.getServiceContext());
	}

	@Override
	protected void removeEntity(ProductCategory entity) throws PortalException,
			SystemException {
		ProductCategoryLocalServiceUtil.delete(entity);
	}

	@Override
	protected ProductCategory findById(long id) throws SystemException,
			PortalException {
		return ProductCategoryLocalServiceUtil.getProductCategory(id);
	}

	@Override
	protected int countEntities(DynamicQuery query) throws SystemException,
			PortalException {
		return Long.valueOf(ProductCategoryLocalServiceUtil.dynamicQueryCount(query)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProductCategory> queryEntities(DynamicQuery query)
			throws SystemException, PortalException {
		return ProductCategoryLocalServiceUtil.dynamicQuery(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<ProductCategory> queryEntities(DynamicQuery query,
			int start, int end) throws SystemException, PortalException {
		return ProductCategoryLocalServiceUtil.dynamicQuery(query, start, end);
	}

	@Override
	protected DynamicQuery createDymanicQuery() {
		return ProductCategoryLocalServiceUtil.dynamicQuery();
	}

	@Override
	protected Class<ProductCategory> getEntityClass() {
		return ProductCategory.class;
	}

	@Override
	protected Searcher getSearcher() {
		return null;
	}
	
	public SelectItem[] getItems() {
		if (items == null) {
			try {
				List<ProductCategory> categories = queryEntities(createDymanicQuery());
				items = new SelectItem[categories.size()];
				
				for (int i = 0; i < categories.size(); i++) {
					ProductCategory category = categories.get(i);
					items[i] = new SelectItem(category.getCategoryId(), category.getTitle());
				}
			} catch (Exception e) {
				logger.warn("Error when build product category select item. Error: {0}", e.getMessage());
			}
		}
		
		return items;
	}

}
