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

import com.cmc.gateway.domain.NoSuchProductEntryException;
import com.cmc.gateway.domain.model.ProductEntry;
import com.cmc.gateway.domain.model.impl.ProductEntryImpl;
import com.cmc.gateway.domain.model.impl.ProductEntryModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
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
 * The persistence implementation for the product entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductEntryPersistence
 * @see ProductEntryUtil
 * @generated
 */
public class ProductEntryPersistenceImpl extends BasePersistenceImpl<ProductEntry>
	implements ProductEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProductEntryUtil} to access the product entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProductEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, ProductEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, ProductEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName() },
			ProductEntryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, ProductEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, ProductEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { String.class.getName() },
			ProductEntryModelImpl.PRODUCTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, ProductEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			ProductEntryModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, ProductEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, ProductEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			ProductEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, ProductEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, ProductEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the product entry in the entity cache if it is enabled.
	 *
	 * @param productEntry the product entry
	 */
	public void cacheResult(ProductEntry productEntry) {
		EntityCacheUtil.putResult(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryImpl.class, productEntry.getPrimaryKey(), productEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { productEntry.getCode() }, productEntry);

		productEntry.resetOriginalValues();
	}

	/**
	 * Caches the product entries in the entity cache if it is enabled.
	 *
	 * @param productEntries the product entries
	 */
	public void cacheResult(List<ProductEntry> productEntries) {
		for (ProductEntry productEntry : productEntries) {
			if (EntityCacheUtil.getResult(
						ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
						ProductEntryImpl.class, productEntry.getPrimaryKey()) == null) {
				cacheResult(productEntry);
			}
			else {
				productEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all product entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProductEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProductEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductEntry productEntry) {
		EntityCacheUtil.removeResult(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryImpl.class, productEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(productEntry);
	}

	@Override
	public void clearCache(List<ProductEntry> productEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductEntry productEntry : productEntries) {
			EntityCacheUtil.removeResult(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
				ProductEntryImpl.class, productEntry.getPrimaryKey());

			clearUniqueFindersCache(productEntry);
		}
	}

	protected void clearUniqueFindersCache(ProductEntry productEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { productEntry.getCode() });
	}

	/**
	 * Creates a new product entry with the primary key. Does not add the product entry to the database.
	 *
	 * @param productId the primary key for the new product entry
	 * @return the new product entry
	 */
	public ProductEntry create(long productId) {
		ProductEntry productEntry = new ProductEntryImpl();

		productEntry.setNew(true);
		productEntry.setPrimaryKey(productId);

		return productEntry;
	}

	/**
	 * Removes the product entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the product entry
	 * @return the product entry that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry remove(long productId)
		throws NoSuchProductEntryException, SystemException {
		return remove(Long.valueOf(productId));
	}

	/**
	 * Removes the product entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product entry
	 * @return the product entry that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductEntry remove(Serializable primaryKey)
		throws NoSuchProductEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProductEntry productEntry = (ProductEntry)session.get(ProductEntryImpl.class,
					primaryKey);

			if (productEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(productEntry);
		}
		catch (NoSuchProductEntryException nsee) {
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
	protected ProductEntry removeImpl(ProductEntry productEntry)
		throws SystemException {
		productEntry = toUnwrappedModel(productEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, productEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(productEntry);

		return productEntry;
	}

	@Override
	public ProductEntry updateImpl(
		com.cmc.gateway.domain.model.ProductEntry productEntry, boolean merge)
		throws SystemException {
		productEntry = toUnwrappedModel(productEntry);

		boolean isNew = productEntry.isNew();

		ProductEntryModelImpl productEntryModelImpl = (ProductEntryModelImpl)productEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, productEntry, merge);

			productEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProductEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((productEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(productEntryModelImpl.getOriginalCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] {
						Long.valueOf(productEntryModelImpl.getCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}

			if ((productEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						productEntryModelImpl.getOriginalProductType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { productEntryModelImpl.getProductType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}

			if ((productEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(productEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						Integer.valueOf(productEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProductEntryImpl.class, productEntry.getPrimaryKey(), productEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
				new Object[] { productEntry.getCode() }, productEntry);
		}
		else {
			if ((productEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						productEntryModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
					new Object[] { productEntry.getCode() }, productEntry);
			}
		}

		return productEntry;
	}

	protected ProductEntry toUnwrappedModel(ProductEntry productEntry) {
		if (productEntry instanceof ProductEntryImpl) {
			return productEntry;
		}

		ProductEntryImpl productEntryImpl = new ProductEntryImpl();

		productEntryImpl.setNew(productEntry.isNew());
		productEntryImpl.setPrimaryKey(productEntry.getPrimaryKey());

		productEntryImpl.setProductId(productEntry.getProductId());
		productEntryImpl.setGroupId(productEntry.getGroupId());
		productEntryImpl.setCompanyId(productEntry.getCompanyId());
		productEntryImpl.setUserId(productEntry.getUserId());
		productEntryImpl.setCreateDate(productEntry.getCreateDate());
		productEntryImpl.setModifiedDate(productEntry.getModifiedDate());
		productEntryImpl.setCategoryId(productEntry.getCategoryId());
		productEntryImpl.setProductType(productEntry.getProductType());
		productEntryImpl.setCode(productEntry.getCode());
		productEntryImpl.setTitle(productEntry.getTitle());
		productEntryImpl.setSku(productEntry.getSku());
		productEntryImpl.setPrice(productEntry.getPrice());
		productEntryImpl.setSubscriberTypes(productEntry.getSubscriberTypes());
		productEntryImpl.setTermOfUse(productEntry.isTermOfUse());
		productEntryImpl.setTermPeriod(productEntry.getTermPeriod());
		productEntryImpl.setTermUnit(productEntry.getTermUnit());
		productEntryImpl.setSubscription(productEntry.isSubscription());
		productEntryImpl.setSubscriptionUnit(productEntry.getSubscriptionUnit());
		productEntryImpl.setSubscriptionPeriod(productEntry.getSubscriptionPeriod());
		productEntryImpl.setGracePeriod(productEntry.getGracePeriod());
		productEntryImpl.setGraceUnit(productEntry.getGraceUnit());
		productEntryImpl.setStatus(productEntry.getStatus());
		productEntryImpl.setDescription(productEntry.getDescription());
		productEntryImpl.setProperties(productEntry.getProperties());

		return productEntryImpl;
	}

	/**
	 * Returns the product entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the product entry
	 * @return the product entry
	 * @throws com.liferay.portal.NoSuchModelException if a product entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the product entry with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductEntryException} if it could not be found.
	 *
	 * @param productId the primary key of the product entry
	 * @return the product entry
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry findByPrimaryKey(long productId)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = fetchByPrimaryKey(productId);

		if (productEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + productId);
			}

			throw new NoSuchProductEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				productId);
		}

		return productEntry;
	}

	/**
	 * Returns the product entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product entry
	 * @return the product entry, or <code>null</code> if a product entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the product entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the product entry
	 * @return the product entry, or <code>null</code> if a product entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry fetchByPrimaryKey(long productId)
		throws SystemException {
		ProductEntry productEntry = (ProductEntry)EntityCacheUtil.getResult(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
				ProductEntryImpl.class, productId);

		if (productEntry == _nullProductEntry) {
			return null;
		}

		if (productEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				productEntry = (ProductEntry)session.get(ProductEntryImpl.class,
						Long.valueOf(productId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (productEntry != null) {
					cacheResult(productEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProductEntryModelImpl.ENTITY_CACHE_ENABLED,
						ProductEntryImpl.class, productId, _nullProductEntry);
				}

				closeSession(session);
			}
		}

		return productEntry;
	}

	/**
	 * Returns all the product entries where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findByCategory(long categoryId)
		throws SystemException {
		return findByCategory(categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the product entries where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of product entries
	 * @param end the upper bound of the range of product entries (not inclusive)
	 * @return the range of matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findByCategory(long categoryId, int start, int end)
		throws SystemException {
		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product entries where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of product entries
	 * @param end the upper bound of the range of product entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findByCategory(long categoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<ProductEntry> list = (List<ProductEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProductEntry productEntry : list) {
				if ((categoryId != productEntry.getCategoryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRODUCTENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProductEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				list = (List<ProductEntry>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first product entry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product entry
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry findByCategory_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = fetchByCategory_First(categoryId,
				orderByComparator);

		if (productEntry != null) {
			return productEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductEntryException(msg.toString());
	}

	/**
	 * Returns the first product entry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product entry, or <code>null</code> if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry fetchByCategory_First(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProductEntry> list = findByCategory(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product entry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product entry
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry findByCategory_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = fetchByCategory_Last(categoryId,
				orderByComparator);

		if (productEntry != null) {
			return productEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductEntryException(msg.toString());
	}

	/**
	 * Returns the last product entry in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product entry, or <code>null</code> if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry fetchByCategory_Last(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategory(categoryId);

		List<ProductEntry> list = findByCategory(categoryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product entries before and after the current product entry in the ordered set where categoryId = &#63;.
	 *
	 * @param productId the primary key of the current product entry
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product entry
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry[] findByCategory_PrevAndNext(long productId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			ProductEntry[] array = new ProductEntryImpl[3];

			array[0] = getByCategory_PrevAndNext(session, productEntry,
					categoryId, orderByComparator, true);

			array[1] = productEntry;

			array[2] = getByCategory_PrevAndNext(session, productEntry,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductEntry getByCategory_PrevAndNext(Session session,
		ProductEntry productEntry, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCTENTRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ProductEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(productEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProductEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the product entries where productType = &#63;.
	 *
	 * @param productType the product type
	 * @return the matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findByType(String productType)
		throws SystemException {
		return findByType(productType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the product entries where productType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productType the product type
	 * @param start the lower bound of the range of product entries
	 * @param end the upper bound of the range of product entries (not inclusive)
	 * @return the range of matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findByType(String productType, int start, int end)
		throws SystemException {
		return findByType(productType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product entries where productType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productType the product type
	 * @param start the lower bound of the range of product entries
	 * @param end the upper bound of the range of product entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findByType(String productType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { productType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { productType, start, end, orderByComparator };
		}

		List<ProductEntry> list = (List<ProductEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProductEntry productEntry : list) {
				if (!Validator.equals(productType, productEntry.getProductType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRODUCTENTRY_WHERE);

			if (productType == null) {
				query.append(_FINDER_COLUMN_TYPE_PRODUCTTYPE_1);
			}
			else {
				if (productType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TYPE_PRODUCTTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TYPE_PRODUCTTYPE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProductEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (productType != null) {
					qPos.add(productType);
				}

				list = (List<ProductEntry>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first product entry in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product entry
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry findByType_First(String productType,
		OrderByComparator orderByComparator)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = fetchByType_First(productType,
				orderByComparator);

		if (productEntry != null) {
			return productEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productType=");
		msg.append(productType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductEntryException(msg.toString());
	}

	/**
	 * Returns the first product entry in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product entry, or <code>null</code> if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry fetchByType_First(String productType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProductEntry> list = findByType(productType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product entry in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product entry
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry findByType_Last(String productType,
		OrderByComparator orderByComparator)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = fetchByType_Last(productType,
				orderByComparator);

		if (productEntry != null) {
			return productEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productType=");
		msg.append(productType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductEntryException(msg.toString());
	}

	/**
	 * Returns the last product entry in the ordered set where productType = &#63;.
	 *
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product entry, or <code>null</code> if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry fetchByType_Last(String productType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(productType);

		List<ProductEntry> list = findByType(productType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product entries before and after the current product entry in the ordered set where productType = &#63;.
	 *
	 * @param productId the primary key of the current product entry
	 * @param productType the product type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product entry
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry[] findByType_PrevAndNext(long productId,
		String productType, OrderByComparator orderByComparator)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			ProductEntry[] array = new ProductEntryImpl[3];

			array[0] = getByType_PrevAndNext(session, productEntry,
					productType, orderByComparator, true);

			array[1] = productEntry;

			array[2] = getByType_PrevAndNext(session, productEntry,
					productType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductEntry getByType_PrevAndNext(Session session,
		ProductEntry productEntry, String productType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCTENTRY_WHERE);

		if (productType == null) {
			query.append(_FINDER_COLUMN_TYPE_PRODUCTTYPE_1);
		}
		else {
			if (productType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_PRODUCTTYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TYPE_PRODUCTTYPE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ProductEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (productType != null) {
			qPos.add(productType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(productEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProductEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the product entry where code = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProductEntryException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching product entry
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry findByCode(String code)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = fetchByCode(code);

		if (productEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProductEntryException(msg.toString());
		}

		return productEntry;
	}

	/**
	 * Returns the product entry where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching product entry, or <code>null</code> if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the product entry where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching product entry, or <code>null</code> if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ProductEntry) {
			ProductEntry productEntry = (ProductEntry)result;

			if (!Validator.equals(code, productEntry.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PRODUCTENTRY_WHERE);

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else {
				if (code.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CODE_CODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_CODE_CODE_2);
				}
			}

			query.append(ProductEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (code != null) {
					qPos.add(code);
				}

				List<ProductEntry> list = q.list();

				result = list;

				ProductEntry productEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					productEntry = list.get(0);

					cacheResult(productEntry);

					if ((productEntry.getCode() == null) ||
							!productEntry.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, productEntry);
					}
				}

				return productEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ProductEntry)result;
			}
		}
	}

	/**
	 * Returns all the product entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findByStatus(int status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of product entries
	 * @param end the upper bound of the range of product entries (not inclusive)
	 * @return the range of matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of product entries
	 * @param end the upper bound of the range of product entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findByStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<ProductEntry> list = (List<ProductEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProductEntry productEntry : list) {
				if ((status != productEntry.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRODUCTENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProductEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<ProductEntry>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first product entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product entry
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = fetchByStatus_First(status,
				orderByComparator);

		if (productEntry != null) {
			return productEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductEntryException(msg.toString());
	}

	/**
	 * Returns the first product entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product entry, or <code>null</code> if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProductEntry> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product entry
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = fetchByStatus_Last(status, orderByComparator);

		if (productEntry != null) {
			return productEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductEntryException(msg.toString());
	}

	/**
	 * Returns the last product entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product entry, or <code>null</code> if a matching product entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		List<ProductEntry> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product entries before and after the current product entry in the ordered set where status = &#63;.
	 *
	 * @param productId the primary key of the current product entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product entry
	 * @throws com.cmc.gateway.domain.NoSuchProductEntryException if a product entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry[] findByStatus_PrevAndNext(long productId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			ProductEntry[] array = new ProductEntryImpl[3];

			array[0] = getByStatus_PrevAndNext(session, productEntry, status,
					orderByComparator, true);

			array[1] = productEntry;

			array[2] = getByStatus_PrevAndNext(session, productEntry, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductEntry getByStatus_PrevAndNext(Session session,
		ProductEntry productEntry, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCTENTRY_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ProductEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(productEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProductEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the product entries.
	 *
	 * @return the product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of product entries
	 * @param end the upper bound of the range of product entries (not inclusive)
	 * @return the range of product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of product entries
	 * @param end the upper bound of the range of product entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductEntry> findAll(int start, int end,
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

		List<ProductEntry> list = (List<ProductEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRODUCTENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTENTRY.concat(ProductEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProductEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProductEntry>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the product entries where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategory(long categoryId) throws SystemException {
		for (ProductEntry productEntry : findByCategory(categoryId)) {
			remove(productEntry);
		}
	}

	/**
	 * Removes all the product entries where productType = &#63; from the database.
	 *
	 * @param productType the product type
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByType(String productType) throws SystemException {
		for (ProductEntry productEntry : findByType(productType)) {
			remove(productEntry);
		}
	}

	/**
	 * Removes the product entry where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the product entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public ProductEntry removeByCode(String code)
		throws NoSuchProductEntryException, SystemException {
		ProductEntry productEntry = findByCode(code);

		return remove(productEntry);
	}

	/**
	 * Removes all the product entries where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatus(int status) throws SystemException {
		for (ProductEntry productEntry : findByStatus(status)) {
			remove(productEntry);
		}
	}

	/**
	 * Removes all the product entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProductEntry productEntry : findAll()) {
			remove(productEntry);
		}
	}

	/**
	 * Returns the number of product entries where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategory(long categoryId) throws SystemException {
		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCTENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of product entries where productType = &#63;.
	 *
	 * @param productType the product type
	 * @return the number of matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByType(String productType) throws SystemException {
		Object[] finderArgs = new Object[] { productType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCTENTRY_WHERE);

			if (productType == null) {
				query.append(_FINDER_COLUMN_TYPE_PRODUCTTYPE_1);
			}
			else {
				if (productType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TYPE_PRODUCTTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TYPE_PRODUCTTYPE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (productType != null) {
					qPos.add(productType);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of product entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCode(String code) throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCTENTRY_WHERE);

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else {
				if (code.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CODE_CODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_CODE_CODE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (code != null) {
					qPos.add(code);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of product entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching product entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatus(int status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCTENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of product entries.
	 *
	 * @return the number of product entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRODUCTENTRY);

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
	 * Initializes the product entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.ProductEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProductEntry>> listenersList = new ArrayList<ModelListener<ProductEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProductEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProductEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_PRODUCTENTRY = "SELECT productEntry FROM ProductEntry productEntry";
	private static final String _SQL_SELECT_PRODUCTENTRY_WHERE = "SELECT productEntry FROM ProductEntry productEntry WHERE ";
	private static final String _SQL_COUNT_PRODUCTENTRY = "SELECT COUNT(productEntry) FROM ProductEntry productEntry";
	private static final String _SQL_COUNT_PRODUCTENTRY_WHERE = "SELECT COUNT(productEntry) FROM ProductEntry productEntry WHERE ";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 = "productEntry.categoryId = ?";
	private static final String _FINDER_COLUMN_TYPE_PRODUCTTYPE_1 = "productEntry.productType IS NULL";
	private static final String _FINDER_COLUMN_TYPE_PRODUCTTYPE_2 = "productEntry.productType = ?";
	private static final String _FINDER_COLUMN_TYPE_PRODUCTTYPE_3 = "(productEntry.productType IS NULL OR productEntry.productType = ?)";
	private static final String _FINDER_COLUMN_CODE_CODE_1 = "productEntry.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "productEntry.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(productEntry.code IS NULL OR productEntry.code = ?)";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "productEntry.status = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "productEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProductEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProductEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProductEntryPersistenceImpl.class);
	private static ProductEntry _nullProductEntry = new ProductEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProductEntry> toCacheModel() {
				return _nullProductEntryCacheModel;
			}
		};

	private static CacheModel<ProductEntry> _nullProductEntryCacheModel = new CacheModel<ProductEntry>() {
			public ProductEntry toEntityModel() {
				return _nullProductEntry;
			}
		};
}