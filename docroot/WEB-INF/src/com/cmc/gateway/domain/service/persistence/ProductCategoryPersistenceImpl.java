/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.cmc.gateway.domain.service.persistence;

import com.cmc.gateway.domain.NoSuchProductCategoryException;
import com.cmc.gateway.domain.model.ProductCategory;
import com.cmc.gateway.domain.model.impl.ProductCategoryImpl;
import com.cmc.gateway.domain.model.impl.ProductCategoryModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the product category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductCategoryPersistence
 * @see ProductCategoryUtil
 * @generated
 */
public class ProductCategoryPersistenceImpl extends BasePersistenceImpl<ProductCategory>
	implements ProductCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProductCategoryUtil} to access the product category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProductCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryModelImpl.FINDER_CACHE_ENABLED,
			ProductCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryModelImpl.FINDER_CACHE_ENABLED,
			ProductCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the product category in the entity cache if it is enabled.
	 *
	 * @param productCategory the product category
	 */
	public void cacheResult(ProductCategory productCategory) {
		EntityCacheUtil.putResult(ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryImpl.class, productCategory.getPrimaryKey(),
			productCategory);

		productCategory.resetOriginalValues();
	}

	/**
	 * Caches the product categories in the entity cache if it is enabled.
	 *
	 * @param productCategories the product categories
	 */
	public void cacheResult(List<ProductCategory> productCategories) {
		for (ProductCategory productCategory : productCategories) {
			if (EntityCacheUtil.getResult(
						ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ProductCategoryImpl.class,
						productCategory.getPrimaryKey()) == null) {
				cacheResult(productCategory);
			}
			else {
				productCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all product categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProductCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProductCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductCategory productCategory) {
		EntityCacheUtil.removeResult(ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryImpl.class, productCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProductCategory> productCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductCategory productCategory : productCategories) {
			EntityCacheUtil.removeResult(ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ProductCategoryImpl.class, productCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new product category with the primary key. Does not add the product category to the database.
	 *
	 * @param categoryId the primary key for the new product category
	 * @return the new product category
	 */
	public ProductCategory create(long categoryId) {
		ProductCategory productCategory = new ProductCategoryImpl();

		productCategory.setNew(true);
		productCategory.setPrimaryKey(categoryId);

		return productCategory;
	}

	/**
	 * Removes the product category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the product category
	 * @return the product category that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProductCategoryException if a product category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductCategory remove(long categoryId)
		throws NoSuchProductCategoryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the product category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product category
	 * @return the product category that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProductCategoryException if a product category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCategory remove(Serializable primaryKey)
		throws NoSuchProductCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProductCategory productCategory = (ProductCategory)session.get(ProductCategoryImpl.class,
					primaryKey);

			if (productCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(productCategory);
		}
		catch (NoSuchProductCategoryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ProductCategory removeImpl(ProductCategory productCategory)
		throws SystemException {
		productCategory = toUnwrappedModel(productCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, productCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(productCategory);

		return productCategory;
	}

	@Override
	public ProductCategory updateImpl(
		com.cmc.gateway.domain.model.ProductCategory productCategory,
		boolean merge) throws SystemException {
		productCategory = toUnwrappedModel(productCategory);

		boolean isNew = productCategory.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, productCategory, merge);

			productCategory.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryImpl.class, productCategory.getPrimaryKey(),
			productCategory);

		return productCategory;
	}

	protected ProductCategory toUnwrappedModel(ProductCategory productCategory) {
		if (productCategory instanceof ProductCategoryImpl) {
			return productCategory;
		}

		ProductCategoryImpl productCategoryImpl = new ProductCategoryImpl();

		productCategoryImpl.setNew(productCategory.isNew());
		productCategoryImpl.setPrimaryKey(productCategory.getPrimaryKey());

		productCategoryImpl.setCategoryId(productCategory.getCategoryId());
		productCategoryImpl.setGroupId(productCategory.getGroupId());
		productCategoryImpl.setCompanyId(productCategory.getCompanyId());
		productCategoryImpl.setUserId(productCategory.getUserId());
		productCategoryImpl.setCreateDate(productCategory.getCreateDate());
		productCategoryImpl.setModifiedDate(productCategory.getModifiedDate());
		productCategoryImpl.setTitle(productCategory.getTitle());
		productCategoryImpl.setDescription(productCategory.getDescription());

		return productCategoryImpl;
	}

	/**
	 * Returns the product category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the product category
	 * @return the product category
	 * @throws com.liferay.portal.NoSuchModelException if a product category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the product category with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the product category
	 * @return the product category
	 * @throws com.cmc.gateway.domain.NoSuchProductCategoryException if a product category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductCategory findByPrimaryKey(long categoryId)
		throws NoSuchProductCategoryException, SystemException {
		ProductCategory productCategory = fetchByPrimaryKey(categoryId);

		if (productCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchProductCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return productCategory;
	}

	/**
	 * Returns the product category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product category
	 * @return the product category, or <code>null</code> if a product category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the product category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the product category
	 * @return the product category, or <code>null</code> if a product category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductCategory fetchByPrimaryKey(long categoryId)
		throws SystemException {
		ProductCategory productCategory = (ProductCategory)EntityCacheUtil.getResult(ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ProductCategoryImpl.class, categoryId);

		if (productCategory == _nullProductCategory) {
			return null;
		}

		if (productCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				productCategory = (ProductCategory)session.get(ProductCategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (productCategory != null) {
					cacheResult(productCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ProductCategoryImpl.class, categoryId,
						_nullProductCategory);
				}

				closeSession(session);
			}
		}

		return productCategory;
	}

	/**
	 * Returns all the product categories.
	 *
	 * @return the product categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @return the range of product categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductCategory> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ProductCategory> list = (List<ProductCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRODUCTCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTCATEGORY.concat(ProductCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProductCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProductCategory>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the product categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProductCategory productCategory : findAll()) {
			remove(productCategory);
		}
	}

	/**
	 * Returns the number of product categories.
	 *
	 * @return the number of product categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRODUCTCATEGORY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the product category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.ProductCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProductCategory>> listenersList = new ArrayList<ModelListener<ProductCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProductCategory>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ProductCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AppDomainPersistence.class)
	protected AppDomainPersistence appDomainPersistence;
	@BeanReference(type = CommandActionPersistence.class)
	protected CommandActionPersistence commandActionPersistence;
	@BeanReference(type = CommandEntryPersistence.class)
	protected CommandEntryPersistence commandEntryPersistence;
	@BeanReference(type = ProductActionPersistence.class)
	protected ProductActionPersistence productActionPersistence;
	@BeanReference(type = ProductCategoryPersistence.class)
	protected ProductCategoryPersistence productCategoryPersistence;
	@BeanReference(type = ProductEntryPersistence.class)
	protected ProductEntryPersistence productEntryPersistence;
	@BeanReference(type = ProductMessagePersistence.class)
	protected ProductMessagePersistence productMessagePersistence;
	@BeanReference(type = ProductRoutePersistence.class)
	protected ProductRoutePersistence productRoutePersistence;
	@BeanReference(type = ProvisioningActionPersistence.class)
	protected ProvisioningActionPersistence provisioningActionPersistence;
	@BeanReference(type = ProvisioningEntryPersistence.class)
	protected ProvisioningEntryPersistence provisioningEntryPersistence;
	@BeanReference(type = ProvisioningMessagePersistence.class)
	protected ProvisioningMessagePersistence provisioningMessagePersistence;
	@BeanReference(type = ProvisioningRoutePersistence.class)
	protected ProvisioningRoutePersistence provisioningRoutePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PRODUCTCATEGORY = "SELECT productCategory FROM ProductCategory productCategory";
	private static final String _SQL_COUNT_PRODUCTCATEGORY = "SELECT COUNT(productCategory) FROM ProductCategory productCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "productCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProductCategory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProductCategoryPersistenceImpl.class);
	private static ProductCategory _nullProductCategory = new ProductCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProductCategory> toCacheModel() {
				return _nullProductCategoryCacheModel;
			}
		};

	private static CacheModel<ProductCategory> _nullProductCategoryCacheModel = new CacheModel<ProductCategory>() {
			public ProductCategory toEntityModel() {
				return _nullProductCategory;
			}
		};
}