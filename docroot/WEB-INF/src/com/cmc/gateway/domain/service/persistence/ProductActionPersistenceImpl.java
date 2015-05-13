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

import com.cmc.gateway.domain.NoSuchProductActionException;
import com.cmc.gateway.domain.model.ProductAction;
import com.cmc.gateway.domain.model.impl.ProductActionImpl;
import com.cmc.gateway.domain.model.impl.ProductActionModelImpl;

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
 * The persistence implementation for the product action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductActionPersistence
 * @see ProductActionUtil
 * @generated
 */
public class ProductActionPersistenceImpl extends BasePersistenceImpl<ProductAction>
	implements ProductActionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProductActionUtil} to access the product action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProductActionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCT = new FinderPath(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
			ProductActionModelImpl.FINDER_CACHE_ENABLED,
			ProductActionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProduct",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT =
		new FinderPath(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
			ProductActionModelImpl.FINDER_CACHE_ENABLED,
			ProductActionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProduct", new String[] { Long.class.getName() },
			ProductActionModelImpl.PRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCT = new FinderPath(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
			ProductActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProduct",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
			ProductActionModelImpl.FINDER_CACHE_ENABLED,
			ProductActionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
			ProductActionModelImpl.FINDER_CACHE_ENABLED,
			ProductActionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
			ProductActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the product action in the entity cache if it is enabled.
	 *
	 * @param productAction the product action
	 */
	public void cacheResult(ProductAction productAction) {
		EntityCacheUtil.putResult(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
			ProductActionImpl.class, productAction.getPrimaryKey(),
			productAction);

		productAction.resetOriginalValues();
	}

	/**
	 * Caches the product actions in the entity cache if it is enabled.
	 *
	 * @param productActions the product actions
	 */
	public void cacheResult(List<ProductAction> productActions) {
		for (ProductAction productAction : productActions) {
			if (EntityCacheUtil.getResult(
						ProductActionModelImpl.ENTITY_CACHE_ENABLED,
						ProductActionImpl.class, productAction.getPrimaryKey()) == null) {
				cacheResult(productAction);
			}
			else {
				productAction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all product actions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProductActionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProductActionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product action.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductAction productAction) {
		EntityCacheUtil.removeResult(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
			ProductActionImpl.class, productAction.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProductAction> productActions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductAction productAction : productActions) {
			EntityCacheUtil.removeResult(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
				ProductActionImpl.class, productAction.getPrimaryKey());
		}
	}

	/**
	 * Creates a new product action with the primary key. Does not add the product action to the database.
	 *
	 * @param actionId the primary key for the new product action
	 * @return the new product action
	 */
	public ProductAction create(long actionId) {
		ProductAction productAction = new ProductActionImpl();

		productAction.setNew(true);
		productAction.setPrimaryKey(actionId);

		return productAction;
	}

	/**
	 * Removes the product action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionId the primary key of the product action
	 * @return the product action that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProductActionException if a product action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductAction remove(long actionId)
		throws NoSuchProductActionException, SystemException {
		return remove(Long.valueOf(actionId));
	}

	/**
	 * Removes the product action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product action
	 * @return the product action that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProductActionException if a product action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductAction remove(Serializable primaryKey)
		throws NoSuchProductActionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProductAction productAction = (ProductAction)session.get(ProductActionImpl.class,
					primaryKey);

			if (productAction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(productAction);
		}
		catch (NoSuchProductActionException nsee) {
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
	protected ProductAction removeImpl(ProductAction productAction)
		throws SystemException {
		productAction = toUnwrappedModel(productAction);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, productAction);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(productAction);

		return productAction;
	}

	@Override
	public ProductAction updateImpl(
		com.cmc.gateway.domain.model.ProductAction productAction, boolean merge)
		throws SystemException {
		productAction = toUnwrappedModel(productAction);

		boolean isNew = productAction.isNew();

		ProductActionModelImpl productActionModelImpl = (ProductActionModelImpl)productAction;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, productAction, merge);

			productAction.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProductActionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((productActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(productActionModelImpl.getOriginalProductId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT,
					args);

				args = new Object[] {
						Long.valueOf(productActionModelImpl.getProductId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT,
					args);
			}
		}

		EntityCacheUtil.putResult(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
			ProductActionImpl.class, productAction.getPrimaryKey(),
			productAction);

		return productAction;
	}

	protected ProductAction toUnwrappedModel(ProductAction productAction) {
		if (productAction instanceof ProductActionImpl) {
			return productAction;
		}

		ProductActionImpl productActionImpl = new ProductActionImpl();

		productActionImpl.setNew(productAction.isNew());
		productActionImpl.setPrimaryKey(productAction.getPrimaryKey());

		productActionImpl.setActionId(productAction.getActionId());
		productActionImpl.setGroupId(productAction.getGroupId());
		productActionImpl.setCompanyId(productAction.getCompanyId());
		productActionImpl.setUserId(productAction.getUserId());
		productActionImpl.setCreateDate(productAction.getCreateDate());
		productActionImpl.setModifiedDate(productAction.getModifiedDate());
		productActionImpl.setActionType(productAction.getActionType());
		productActionImpl.setSubscriberType(productAction.getSubscriberType());
		productActionImpl.setProductId(productAction.getProductId());
		productActionImpl.setBalanceType(productAction.getBalanceType());
		productActionImpl.setCommandId(productAction.getCommandId());
		productActionImpl.setDescription(productAction.getDescription());

		return productActionImpl;
	}

	/**
	 * Returns the product action with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the product action
	 * @return the product action
	 * @throws com.liferay.portal.NoSuchModelException if a product action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductAction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the product action with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductActionException} if it could not be found.
	 *
	 * @param actionId the primary key of the product action
	 * @return the product action
	 * @throws com.cmc.gateway.domain.NoSuchProductActionException if a product action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductAction findByPrimaryKey(long actionId)
		throws NoSuchProductActionException, SystemException {
		ProductAction productAction = fetchByPrimaryKey(actionId);

		if (productAction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + actionId);
			}

			throw new NoSuchProductActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				actionId);
		}

		return productAction;
	}

	/**
	 * Returns the product action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product action
	 * @return the product action, or <code>null</code> if a product action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductAction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the product action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actionId the primary key of the product action
	 * @return the product action, or <code>null</code> if a product action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductAction fetchByPrimaryKey(long actionId)
		throws SystemException {
		ProductAction productAction = (ProductAction)EntityCacheUtil.getResult(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
				ProductActionImpl.class, actionId);

		if (productAction == _nullProductAction) {
			return null;
		}

		if (productAction == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				productAction = (ProductAction)session.get(ProductActionImpl.class,
						Long.valueOf(actionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (productAction != null) {
					cacheResult(productAction);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProductActionModelImpl.ENTITY_CACHE_ENABLED,
						ProductActionImpl.class, actionId, _nullProductAction);
				}

				closeSession(session);
			}
		}

		return productAction;
	}

	/**
	 * Returns all the product actions where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the matching product actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductAction> findByProduct(long productId)
		throws SystemException {
		return findByProduct(productId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the product actions where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of product actions
	 * @param end the upper bound of the range of product actions (not inclusive)
	 * @return the range of matching product actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductAction> findByProduct(long productId, int start, int end)
		throws SystemException {
		return findByProduct(productId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product actions where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of product actions
	 * @param end the upper bound of the range of product actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductAction> findByProduct(long productId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT;
			finderArgs = new Object[] { productId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCT;
			finderArgs = new Object[] { productId, start, end, orderByComparator };
		}

		List<ProductAction> list = (List<ProductAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProductAction productAction : list) {
				if ((productId != productAction.getProductId())) {
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

			query.append(_SQL_SELECT_PRODUCTACTION_WHERE);

			query.append(_FINDER_COLUMN_PRODUCT_PRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProductActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				list = (List<ProductAction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first product action in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product action
	 * @throws com.cmc.gateway.domain.NoSuchProductActionException if a matching product action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductAction findByProduct_First(long productId,
		OrderByComparator orderByComparator)
		throws NoSuchProductActionException, SystemException {
		ProductAction productAction = fetchByProduct_First(productId,
				orderByComparator);

		if (productAction != null) {
			return productAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductActionException(msg.toString());
	}

	/**
	 * Returns the first product action in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product action, or <code>null</code> if a matching product action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductAction fetchByProduct_First(long productId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProductAction> list = findByProduct(productId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product action in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product action
	 * @throws com.cmc.gateway.domain.NoSuchProductActionException if a matching product action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductAction findByProduct_Last(long productId,
		OrderByComparator orderByComparator)
		throws NoSuchProductActionException, SystemException {
		ProductAction productAction = fetchByProduct_Last(productId,
				orderByComparator);

		if (productAction != null) {
			return productAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductActionException(msg.toString());
	}

	/**
	 * Returns the last product action in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product action, or <code>null</code> if a matching product action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductAction fetchByProduct_Last(long productId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProduct(productId);

		List<ProductAction> list = findByProduct(productId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product actions before and after the current product action in the ordered set where productId = &#63;.
	 *
	 * @param actionId the primary key of the current product action
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product action
	 * @throws com.cmc.gateway.domain.NoSuchProductActionException if a product action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductAction[] findByProduct_PrevAndNext(long actionId,
		long productId, OrderByComparator orderByComparator)
		throws NoSuchProductActionException, SystemException {
		ProductAction productAction = findByPrimaryKey(actionId);

		Session session = null;

		try {
			session = openSession();

			ProductAction[] array = new ProductActionImpl[3];

			array[0] = getByProduct_PrevAndNext(session, productAction,
					productId, orderByComparator, true);

			array[1] = productAction;

			array[2] = getByProduct_PrevAndNext(session, productAction,
					productId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductAction getByProduct_PrevAndNext(Session session,
		ProductAction productAction, long productId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCTACTION_WHERE);

		query.append(_FINDER_COLUMN_PRODUCT_PRODUCTID_2);

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
			query.append(ProductActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(productId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(productAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProductAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the product actions.
	 *
	 * @return the product actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductAction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of product actions
	 * @param end the upper bound of the range of product actions (not inclusive)
	 * @return the range of product actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductAction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of product actions
	 * @param end the upper bound of the range of product actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductAction> findAll(int start, int end,
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

		List<ProductAction> list = (List<ProductAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRODUCTACTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTACTION.concat(ProductActionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProductAction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProductAction>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the product actions where productId = &#63; from the database.
	 *
	 * @param productId the product ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByProduct(long productId) throws SystemException {
		for (ProductAction productAction : findByProduct(productId)) {
			remove(productAction);
		}
	}

	/**
	 * Removes all the product actions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProductAction productAction : findAll()) {
			remove(productAction);
		}
	}

	/**
	 * Returns the number of product actions where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the number of matching product actions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProduct(long productId) throws SystemException {
		Object[] finderArgs = new Object[] { productId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRODUCT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCTACTION_WHERE);

			query.append(_FINDER_COLUMN_PRODUCT_PRODUCTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of product actions.
	 *
	 * @return the number of product actions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRODUCTACTION);

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
	 * Initializes the product action persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.ProductAction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProductAction>> listenersList = new ArrayList<ModelListener<ProductAction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProductAction>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProductActionImpl.class.getName());
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
	private static final String _SQL_SELECT_PRODUCTACTION = "SELECT productAction FROM ProductAction productAction";
	private static final String _SQL_SELECT_PRODUCTACTION_WHERE = "SELECT productAction FROM ProductAction productAction WHERE ";
	private static final String _SQL_COUNT_PRODUCTACTION = "SELECT COUNT(productAction) FROM ProductAction productAction";
	private static final String _SQL_COUNT_PRODUCTACTION_WHERE = "SELECT COUNT(productAction) FROM ProductAction productAction WHERE ";
	private static final String _FINDER_COLUMN_PRODUCT_PRODUCTID_2 = "productAction.productId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "productAction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProductAction exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProductAction exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProductActionPersistenceImpl.class);
	private static ProductAction _nullProductAction = new ProductActionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProductAction> toCacheModel() {
				return _nullProductActionCacheModel;
			}
		};

	private static CacheModel<ProductAction> _nullProductActionCacheModel = new CacheModel<ProductAction>() {
			public ProductAction toEntityModel() {
				return _nullProductAction;
			}
		};
}