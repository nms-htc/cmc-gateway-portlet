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

import com.cmc.gateway.domain.NoSuchProductRouteException;
import com.cmc.gateway.domain.model.ProductRoute;
import com.cmc.gateway.domain.model.impl.ProductRouteImpl;
import com.cmc.gateway.domain.model.impl.ProductRouteModelImpl;

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
 * The persistence implementation for the product route service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductRoutePersistence
 * @see ProductRouteUtil
 * @generated
 */
public class ProductRoutePersistenceImpl extends BasePersistenceImpl<ProductRoute>
	implements ProductRoutePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProductRouteUtil} to access the product route persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProductRouteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCT = new FinderPath(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProductRouteModelImpl.FINDER_CACHE_ENABLED, ProductRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProduct",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT =
		new FinderPath(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProductRouteModelImpl.FINDER_CACHE_ENABLED, ProductRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProduct",
			new String[] { Long.class.getName() },
			ProductRouteModelImpl.PRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCT = new FinderPath(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProductRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProduct",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_ROUTE = new FinderPath(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProductRouteModelImpl.FINDER_CACHE_ENABLED, ProductRouteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRoute",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			ProductRouteModelImpl.PRODUCTID_COLUMN_BITMASK |
			ProductRouteModelImpl.CHANNEL_COLUMN_BITMASK |
			ProductRouteModelImpl.SERVICEADDRESS_COLUMN_BITMASK |
			ProductRouteModelImpl.KEYWORD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROUTE = new FinderPath(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProductRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoute",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProductRouteModelImpl.FINDER_CACHE_ENABLED, ProductRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProductRouteModelImpl.FINDER_CACHE_ENABLED, ProductRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProductRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the product route in the entity cache if it is enabled.
	 *
	 * @param productRoute the product route
	 */
	public void cacheResult(ProductRoute productRoute) {
		EntityCacheUtil.putResult(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProductRouteImpl.class, productRoute.getPrimaryKey(), productRoute);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROUTE,
			new Object[] {
				Long.valueOf(productRoute.getProductId()),
				
			productRoute.getChannel(),
				
			productRoute.getServiceAddress(),
				
			productRoute.getKeyword()
			}, productRoute);

		productRoute.resetOriginalValues();
	}

	/**
	 * Caches the product routes in the entity cache if it is enabled.
	 *
	 * @param productRoutes the product routes
	 */
	public void cacheResult(List<ProductRoute> productRoutes) {
		for (ProductRoute productRoute : productRoutes) {
			if (EntityCacheUtil.getResult(
						ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
						ProductRouteImpl.class, productRoute.getPrimaryKey()) == null) {
				cacheResult(productRoute);
			}
			else {
				productRoute.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all product routes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProductRouteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProductRouteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product route.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductRoute productRoute) {
		EntityCacheUtil.removeResult(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProductRouteImpl.class, productRoute.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(productRoute);
	}

	@Override
	public void clearCache(List<ProductRoute> productRoutes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductRoute productRoute : productRoutes) {
			EntityCacheUtil.removeResult(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
				ProductRouteImpl.class, productRoute.getPrimaryKey());

			clearUniqueFindersCache(productRoute);
		}
	}

	protected void clearUniqueFindersCache(ProductRoute productRoute) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ROUTE,
			new Object[] {
				Long.valueOf(productRoute.getProductId()),
				
			productRoute.getChannel(),
				
			productRoute.getServiceAddress(),
				
			productRoute.getKeyword()
			});
	}

	/**
	 * Creates a new product route with the primary key. Does not add the product route to the database.
	 *
	 * @param routeId the primary key for the new product route
	 * @return the new product route
	 */
	public ProductRoute create(long routeId) {
		ProductRoute productRoute = new ProductRouteImpl();

		productRoute.setNew(true);
		productRoute.setPrimaryKey(routeId);

		return productRoute;
	}

	/**
	 * Removes the product route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param routeId the primary key of the product route
	 * @return the product route that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProductRouteException if a product route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute remove(long routeId)
		throws NoSuchProductRouteException, SystemException {
		return remove(Long.valueOf(routeId));
	}

	/**
	 * Removes the product route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product route
	 * @return the product route that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProductRouteException if a product route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductRoute remove(Serializable primaryKey)
		throws NoSuchProductRouteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProductRoute productRoute = (ProductRoute)session.get(ProductRouteImpl.class,
					primaryKey);

			if (productRoute == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductRouteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(productRoute);
		}
		catch (NoSuchProductRouteException nsee) {
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
	protected ProductRoute removeImpl(ProductRoute productRoute)
		throws SystemException {
		productRoute = toUnwrappedModel(productRoute);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, productRoute);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(productRoute);

		return productRoute;
	}

	@Override
	public ProductRoute updateImpl(
		com.cmc.gateway.domain.model.ProductRoute productRoute, boolean merge)
		throws SystemException {
		productRoute = toUnwrappedModel(productRoute);

		boolean isNew = productRoute.isNew();

		ProductRouteModelImpl productRouteModelImpl = (ProductRouteModelImpl)productRoute;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, productRoute, merge);

			productRoute.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProductRouteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((productRouteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(productRouteModelImpl.getOriginalProductId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT,
					args);

				args = new Object[] {
						Long.valueOf(productRouteModelImpl.getProductId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT,
					args);
			}
		}

		EntityCacheUtil.putResult(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProductRouteImpl.class, productRoute.getPrimaryKey(), productRoute);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROUTE,
				new Object[] {
					Long.valueOf(productRoute.getProductId()),
					
				productRoute.getChannel(),
					
				productRoute.getServiceAddress(),
					
				productRoute.getKeyword()
				}, productRoute);
		}
		else {
			if ((productRouteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ROUTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(productRouteModelImpl.getOriginalProductId()),
						
						productRouteModelImpl.getOriginalChannel(),
						
						productRouteModelImpl.getOriginalServiceAddress(),
						
						productRouteModelImpl.getOriginalKeyword()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROUTE, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ROUTE, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROUTE,
					new Object[] {
						Long.valueOf(productRoute.getProductId()),
						
					productRoute.getChannel(),
						
					productRoute.getServiceAddress(),
						
					productRoute.getKeyword()
					}, productRoute);
			}
		}

		return productRoute;
	}

	protected ProductRoute toUnwrappedModel(ProductRoute productRoute) {
		if (productRoute instanceof ProductRouteImpl) {
			return productRoute;
		}

		ProductRouteImpl productRouteImpl = new ProductRouteImpl();

		productRouteImpl.setNew(productRoute.isNew());
		productRouteImpl.setPrimaryKey(productRoute.getPrimaryKey());

		productRouteImpl.setRouteId(productRoute.getRouteId());
		productRouteImpl.setGroupId(productRoute.getGroupId());
		productRouteImpl.setCompanyId(productRoute.getCompanyId());
		productRouteImpl.setUserId(productRoute.getUserId());
		productRouteImpl.setCreateDate(productRoute.getCreateDate());
		productRouteImpl.setModifiedDate(productRoute.getModifiedDate());
		productRouteImpl.setChannel(productRoute.getChannel());
		productRouteImpl.setServiceAddress(productRoute.getServiceAddress());
		productRouteImpl.setKeyword(productRoute.getKeyword());
		productRouteImpl.setOpenTime(productRoute.getOpenTime());
		productRouteImpl.setClosedTime(productRoute.getClosedTime());
		productRouteImpl.setCheckBalance(productRoute.isCheckBalance());
		productRouteImpl.setSmsMinParams(productRoute.getSmsMinParams());
		productRouteImpl.setSmsMaxParams(productRoute.getSmsMaxParams());
		productRouteImpl.setActionType(productRoute.getActionType());
		productRouteImpl.setProductId(productRoute.getProductId());
		productRouteImpl.setCampaignId(productRoute.getCampaignId());
		productRouteImpl.setLanguageId(productRoute.getLanguageId());
		productRouteImpl.setSynchronous(productRoute.isSynchronous());
		productRouteImpl.setCreateOrder(productRoute.isCreateOrder());
		productRouteImpl.setTimeout(productRoute.getTimeout());
		productRouteImpl.setMaxRegisterDaily(productRoute.getMaxRegisterDaily());
		productRouteImpl.setDuplicateScan(productRoute.getDuplicateScan());
		productRouteImpl.setCheckSpam(productRoute.isCheckSpam());
		productRouteImpl.setFraudTimes(productRoute.getFraudTimes());
		productRouteImpl.setFraudPeriod(productRoute.getFraudPeriod());
		productRouteImpl.setFraudUnit(productRoute.getFraudUnit());
		productRouteImpl.setRejectUnit(productRoute.getRejectUnit());
		productRouteImpl.setRejectPeriod(productRoute.getRejectPeriod());
		productRouteImpl.setBaseChargeEnable(productRoute.isBaseChargeEnable());
		productRouteImpl.setChargingAmount(productRoute.getChargingAmount());
		productRouteImpl.setNotifyOwner(productRoute.isNotifyOwner());
		productRouteImpl.setNotifyDeliver(productRoute.isNotifyDeliver());
		productRouteImpl.setSendAdvertising(productRoute.isSendAdvertising());
		productRouteImpl.setCheckPromotion(productRoute.isCheckPromotion());
		productRouteImpl.setTopupEnable(productRoute.isTopupEnable());
		productRouteImpl.setProperties(productRoute.getProperties());
		productRouteImpl.setQueueName(productRoute.getQueueName());
		productRouteImpl.setProcessClass(productRoute.getProcessClass());
		productRouteImpl.setProcessMethod(productRoute.getProcessMethod());
		productRouteImpl.setStatus(productRoute.getStatus());
		productRouteImpl.setStartDate(productRoute.getStartDate());
		productRouteImpl.setExpirationDate(productRoute.getExpirationDate());
		productRouteImpl.setDescription(productRoute.getDescription());

		return productRouteImpl;
	}

	/**
	 * Returns the product route with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the product route
	 * @return the product route
	 * @throws com.liferay.portal.NoSuchModelException if a product route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductRoute findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the product route with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductRouteException} if it could not be found.
	 *
	 * @param routeId the primary key of the product route
	 * @return the product route
	 * @throws com.cmc.gateway.domain.NoSuchProductRouteException if a product route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute findByPrimaryKey(long routeId)
		throws NoSuchProductRouteException, SystemException {
		ProductRoute productRoute = fetchByPrimaryKey(routeId);

		if (productRoute == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + routeId);
			}

			throw new NoSuchProductRouteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				routeId);
		}

		return productRoute;
	}

	/**
	 * Returns the product route with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product route
	 * @return the product route, or <code>null</code> if a product route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductRoute fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the product route with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param routeId the primary key of the product route
	 * @return the product route, or <code>null</code> if a product route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute fetchByPrimaryKey(long routeId)
		throws SystemException {
		ProductRoute productRoute = (ProductRoute)EntityCacheUtil.getResult(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
				ProductRouteImpl.class, routeId);

		if (productRoute == _nullProductRoute) {
			return null;
		}

		if (productRoute == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				productRoute = (ProductRoute)session.get(ProductRouteImpl.class,
						Long.valueOf(routeId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (productRoute != null) {
					cacheResult(productRoute);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProductRouteModelImpl.ENTITY_CACHE_ENABLED,
						ProductRouteImpl.class, routeId, _nullProductRoute);
				}

				closeSession(session);
			}
		}

		return productRoute;
	}

	/**
	 * Returns all the product routes where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the matching product routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductRoute> findByProduct(long productId)
		throws SystemException {
		return findByProduct(productId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the product routes where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of product routes
	 * @param end the upper bound of the range of product routes (not inclusive)
	 * @return the range of matching product routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductRoute> findByProduct(long productId, int start, int end)
		throws SystemException {
		return findByProduct(productId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product routes where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of product routes
	 * @param end the upper bound of the range of product routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductRoute> findByProduct(long productId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<ProductRoute> list = (List<ProductRoute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProductRoute productRoute : list) {
				if ((productId != productRoute.getProductId())) {
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

			query.append(_SQL_SELECT_PRODUCTROUTE_WHERE);

			query.append(_FINDER_COLUMN_PRODUCT_PRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProductRouteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				list = (List<ProductRoute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first product route in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product route
	 * @throws com.cmc.gateway.domain.NoSuchProductRouteException if a matching product route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute findByProduct_First(long productId,
		OrderByComparator orderByComparator)
		throws NoSuchProductRouteException, SystemException {
		ProductRoute productRoute = fetchByProduct_First(productId,
				orderByComparator);

		if (productRoute != null) {
			return productRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductRouteException(msg.toString());
	}

	/**
	 * Returns the first product route in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product route, or <code>null</code> if a matching product route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute fetchByProduct_First(long productId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProductRoute> list = findByProduct(productId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product route in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product route
	 * @throws com.cmc.gateway.domain.NoSuchProductRouteException if a matching product route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute findByProduct_Last(long productId,
		OrderByComparator orderByComparator)
		throws NoSuchProductRouteException, SystemException {
		ProductRoute productRoute = fetchByProduct_Last(productId,
				orderByComparator);

		if (productRoute != null) {
			return productRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductRouteException(msg.toString());
	}

	/**
	 * Returns the last product route in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product route, or <code>null</code> if a matching product route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute fetchByProduct_Last(long productId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProduct(productId);

		List<ProductRoute> list = findByProduct(productId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product routes before and after the current product route in the ordered set where productId = &#63;.
	 *
	 * @param routeId the primary key of the current product route
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product route
	 * @throws com.cmc.gateway.domain.NoSuchProductRouteException if a product route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute[] findByProduct_PrevAndNext(long routeId,
		long productId, OrderByComparator orderByComparator)
		throws NoSuchProductRouteException, SystemException {
		ProductRoute productRoute = findByPrimaryKey(routeId);

		Session session = null;

		try {
			session = openSession();

			ProductRoute[] array = new ProductRouteImpl[3];

			array[0] = getByProduct_PrevAndNext(session, productRoute,
					productId, orderByComparator, true);

			array[1] = productRoute;

			array[2] = getByProduct_PrevAndNext(session, productRoute,
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

	protected ProductRoute getByProduct_PrevAndNext(Session session,
		ProductRoute productRoute, long productId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCTROUTE_WHERE);

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
			query.append(ProductRouteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(productId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(productRoute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProductRoute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the product route where productId = &#63; and channel = &#63; and serviceAddress = &#63; and keyword = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProductRouteException} if it could not be found.
	 *
	 * @param productId the product ID
	 * @param channel the channel
	 * @param serviceAddress the service address
	 * @param keyword the keyword
	 * @return the matching product route
	 * @throws com.cmc.gateway.domain.NoSuchProductRouteException if a matching product route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute findByRoute(long productId, String channel,
		String serviceAddress, String keyword)
		throws NoSuchProductRouteException, SystemException {
		ProductRoute productRoute = fetchByRoute(productId, channel,
				serviceAddress, keyword);

		if (productRoute == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("productId=");
			msg.append(productId);

			msg.append(", channel=");
			msg.append(channel);

			msg.append(", serviceAddress=");
			msg.append(serviceAddress);

			msg.append(", keyword=");
			msg.append(keyword);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProductRouteException(msg.toString());
		}

		return productRoute;
	}

	/**
	 * Returns the product route where productId = &#63; and channel = &#63; and serviceAddress = &#63; and keyword = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productId the product ID
	 * @param channel the channel
	 * @param serviceAddress the service address
	 * @param keyword the keyword
	 * @return the matching product route, or <code>null</code> if a matching product route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute fetchByRoute(long productId, String channel,
		String serviceAddress, String keyword) throws SystemException {
		return fetchByRoute(productId, channel, serviceAddress, keyword, true);
	}

	/**
	 * Returns the product route where productId = &#63; and channel = &#63; and serviceAddress = &#63; and keyword = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productId the product ID
	 * @param channel the channel
	 * @param serviceAddress the service address
	 * @param keyword the keyword
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching product route, or <code>null</code> if a matching product route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute fetchByRoute(long productId, String channel,
		String serviceAddress, String keyword, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				productId, channel, serviceAddress, keyword
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ROUTE,
					finderArgs, this);
		}

		if (result instanceof ProductRoute) {
			ProductRoute productRoute = (ProductRoute)result;

			if ((productId != productRoute.getProductId()) ||
					!Validator.equals(channel, productRoute.getChannel()) ||
					!Validator.equals(serviceAddress,
						productRoute.getServiceAddress()) ||
					!Validator.equals(keyword, productRoute.getKeyword())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_PRODUCTROUTE_WHERE);

			query.append(_FINDER_COLUMN_ROUTE_PRODUCTID_2);

			if (channel == null) {
				query.append(_FINDER_COLUMN_ROUTE_CHANNEL_1);
			}
			else {
				if (channel.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_CHANNEL_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_CHANNEL_2);
				}
			}

			if (serviceAddress == null) {
				query.append(_FINDER_COLUMN_ROUTE_SERVICEADDRESS_1);
			}
			else {
				if (serviceAddress.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_SERVICEADDRESS_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_SERVICEADDRESS_2);
				}
			}

			if (keyword == null) {
				query.append(_FINDER_COLUMN_ROUTE_KEYWORD_1);
			}
			else {
				if (keyword.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_KEYWORD_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_KEYWORD_2);
				}
			}

			query.append(ProductRouteModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				if (channel != null) {
					qPos.add(channel);
				}

				if (serviceAddress != null) {
					qPos.add(serviceAddress);
				}

				if (keyword != null) {
					qPos.add(keyword);
				}

				List<ProductRoute> list = q.list();

				result = list;

				ProductRoute productRoute = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROUTE,
						finderArgs, list);
				}
				else {
					productRoute = list.get(0);

					cacheResult(productRoute);

					if ((productRoute.getProductId() != productId) ||
							(productRoute.getChannel() == null) ||
							!productRoute.getChannel().equals(channel) ||
							(productRoute.getServiceAddress() == null) ||
							!productRoute.getServiceAddress()
											 .equals(serviceAddress) ||
							(productRoute.getKeyword() == null) ||
							!productRoute.getKeyword().equals(keyword)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROUTE,
							finderArgs, productRoute);
					}
				}

				return productRoute;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ROUTE,
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
				return (ProductRoute)result;
			}
		}
	}

	/**
	 * Returns all the product routes.
	 *
	 * @return the product routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductRoute> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of product routes
	 * @param end the upper bound of the range of product routes (not inclusive)
	 * @return the range of product routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductRoute> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of product routes
	 * @param end the upper bound of the range of product routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductRoute> findAll(int start, int end,
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

		List<ProductRoute> list = (List<ProductRoute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRODUCTROUTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTROUTE.concat(ProductRouteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProductRoute>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProductRoute>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the product routes where productId = &#63; from the database.
	 *
	 * @param productId the product ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByProduct(long productId) throws SystemException {
		for (ProductRoute productRoute : findByProduct(productId)) {
			remove(productRoute);
		}
	}

	/**
	 * Removes the product route where productId = &#63; and channel = &#63; and serviceAddress = &#63; and keyword = &#63; from the database.
	 *
	 * @param productId the product ID
	 * @param channel the channel
	 * @param serviceAddress the service address
	 * @param keyword the keyword
	 * @return the product route that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public ProductRoute removeByRoute(long productId, String channel,
		String serviceAddress, String keyword)
		throws NoSuchProductRouteException, SystemException {
		ProductRoute productRoute = findByRoute(productId, channel,
				serviceAddress, keyword);

		return remove(productRoute);
	}

	/**
	 * Removes all the product routes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProductRoute productRoute : findAll()) {
			remove(productRoute);
		}
	}

	/**
	 * Returns the number of product routes where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the number of matching product routes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProduct(long productId) throws SystemException {
		Object[] finderArgs = new Object[] { productId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRODUCT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCTROUTE_WHERE);

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
	 * Returns the number of product routes where productId = &#63; and channel = &#63; and serviceAddress = &#63; and keyword = &#63;.
	 *
	 * @param productId the product ID
	 * @param channel the channel
	 * @param serviceAddress the service address
	 * @param keyword the keyword
	 * @return the number of matching product routes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRoute(long productId, String channel,
		String serviceAddress, String keyword) throws SystemException {
		Object[] finderArgs = new Object[] {
				productId, channel, serviceAddress, keyword
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROUTE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_PRODUCTROUTE_WHERE);

			query.append(_FINDER_COLUMN_ROUTE_PRODUCTID_2);

			if (channel == null) {
				query.append(_FINDER_COLUMN_ROUTE_CHANNEL_1);
			}
			else {
				if (channel.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_CHANNEL_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_CHANNEL_2);
				}
			}

			if (serviceAddress == null) {
				query.append(_FINDER_COLUMN_ROUTE_SERVICEADDRESS_1);
			}
			else {
				if (serviceAddress.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_SERVICEADDRESS_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_SERVICEADDRESS_2);
				}
			}

			if (keyword == null) {
				query.append(_FINDER_COLUMN_ROUTE_KEYWORD_1);
			}
			else {
				if (keyword.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_KEYWORD_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_KEYWORD_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				if (channel != null) {
					qPos.add(channel);
				}

				if (serviceAddress != null) {
					qPos.add(serviceAddress);
				}

				if (keyword != null) {
					qPos.add(keyword);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROUTE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of product routes.
	 *
	 * @return the number of product routes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRODUCTROUTE);

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
	 * Initializes the product route persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.ProductRoute")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProductRoute>> listenersList = new ArrayList<ModelListener<ProductRoute>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProductRoute>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProductRouteImpl.class.getName());
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
	private static final String _SQL_SELECT_PRODUCTROUTE = "SELECT productRoute FROM ProductRoute productRoute";
	private static final String _SQL_SELECT_PRODUCTROUTE_WHERE = "SELECT productRoute FROM ProductRoute productRoute WHERE ";
	private static final String _SQL_COUNT_PRODUCTROUTE = "SELECT COUNT(productRoute) FROM ProductRoute productRoute";
	private static final String _SQL_COUNT_PRODUCTROUTE_WHERE = "SELECT COUNT(productRoute) FROM ProductRoute productRoute WHERE ";
	private static final String _FINDER_COLUMN_PRODUCT_PRODUCTID_2 = "productRoute.productId = ?";
	private static final String _FINDER_COLUMN_ROUTE_PRODUCTID_2 = "productRoute.productId = ? AND ";
	private static final String _FINDER_COLUMN_ROUTE_CHANNEL_1 = "productRoute.channel IS NULL AND ";
	private static final String _FINDER_COLUMN_ROUTE_CHANNEL_2 = "productRoute.channel = ? AND ";
	private static final String _FINDER_COLUMN_ROUTE_CHANNEL_3 = "(productRoute.channel IS NULL OR productRoute.channel = ?) AND ";
	private static final String _FINDER_COLUMN_ROUTE_SERVICEADDRESS_1 = "productRoute.serviceAddress IS NULL AND ";
	private static final String _FINDER_COLUMN_ROUTE_SERVICEADDRESS_2 = "productRoute.serviceAddress = ? AND ";
	private static final String _FINDER_COLUMN_ROUTE_SERVICEADDRESS_3 = "(productRoute.serviceAddress IS NULL OR productRoute.serviceAddress = ?) AND ";
	private static final String _FINDER_COLUMN_ROUTE_KEYWORD_1 = "productRoute.keyword IS NULL";
	private static final String _FINDER_COLUMN_ROUTE_KEYWORD_2 = "productRoute.keyword = ?";
	private static final String _FINDER_COLUMN_ROUTE_KEYWORD_3 = "(productRoute.keyword IS NULL OR productRoute.keyword = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "productRoute.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProductRoute exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProductRoute exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProductRoutePersistenceImpl.class);
	private static ProductRoute _nullProductRoute = new ProductRouteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProductRoute> toCacheModel() {
				return _nullProductRouteCacheModel;
			}
		};

	private static CacheModel<ProductRoute> _nullProductRouteCacheModel = new CacheModel<ProductRoute>() {
			public ProductRoute toEntityModel() {
				return _nullProductRoute;
			}
		};
}