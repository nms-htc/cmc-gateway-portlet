package com.cmc.gateway.portlet.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.cmc.gateway.portlet.managedbean.Searcher;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;

public abstract class AbstractLazyDataModel<T extends BaseModel<T>> extends LazyDataModel<T> {

	// serialVersionUID
	private static final long serialVersionUID = -7706268392392499629L;
	private static final Logger _LOGGER = LoggerFactory.getLogger(AbstractLazyDataModel.class);

	protected Searcher searcher;

	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}

	@Override
	public T getRowData(String rowKey) {
		try {
			return findById(Long.parseLong(rowKey));
		} catch (Exception e) {
			_LOGGER.error(e);
			return null;
		}
	}

	@Override
	public Object getRowKey(T object) {
		return object.getPrimaryKeyObj().toString();
	}

	@Override
	public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

		DynamicQuery listQuery;
		DynamicQuery countQuery;

		List<T> result = new ArrayList<T>();
		int count = 0;

		// process search
		if (searcher != null && searcher.getSearchQuery() != null) {
			listQuery = searcher.getSearchQuery();
			countQuery = searcher.getSearchQuery();
		} else {
			listQuery = getDynamicQuery();
			countQuery = getDynamicQuery();
		}

		// process filter
		if (filters != null) {
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				if (entry.getValue() instanceof String) {
					listQuery.add(RestrictionsFactoryUtil.ilike(entry.getKey(),"%" + entry.getValue() + "%"));
					countQuery.add(RestrictionsFactoryUtil.ilike(entry.getKey(),"%" +  entry.getValue() + "%"));
				} else {
					listQuery.add(RestrictionsFactoryUtil.eq(entry.getKey(), entry.getValue()));
					countQuery.add(RestrictionsFactoryUtil.eq(entry.getKey(), entry.getValue()));
				}
				
			}
		}

		// process order
		if (sortField != null && !sortField.trim().isEmpty() && sortOrder != null) {
			Order order = null;
			switch (sortOrder) {
			case ASCENDING:
				order = OrderFactoryUtil.asc(sortField);
				break;
			case DESCENDING:
				order = OrderFactoryUtil.desc(sortField);
				break;
			default:
				break;
			}
			
			if (order != null) listQuery.addOrder(order);
		}
		
		// process search
		try {
			result = query(listQuery, first, first + pageSize);
			count = count(countQuery);
		} catch (Exception e) {
			_LOGGER.error(e);
		}

		setRowCount(count);
		return result;
	}

	protected abstract Class<T> getModelClass();
	protected abstract DynamicQuery getDynamicQuery();
	protected abstract List<T> query(DynamicQuery query,int start,int end) throws SystemException, PortalException;
	protected abstract int count(DynamicQuery query) throws SystemException, PortalException;
	protected abstract T findById(long id) throws SystemException, PortalException;
	
}	