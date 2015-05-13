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

import com.cmc.gateway.domain.NoSuchProvisioningRouteException;
import com.cmc.gateway.domain.model.ProvisioningRoute;
import com.cmc.gateway.domain.model.impl.ProvisioningRouteImpl;
import com.cmc.gateway.domain.model.impl.ProvisioningRouteModelImpl;

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
 * The persistence implementation for the provisioning route service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningRoutePersistence
 * @see ProvisioningRouteUtil
 * @generated
 */
public class ProvisioningRoutePersistenceImpl extends BasePersistenceImpl<ProvisioningRoute>
	implements ProvisioningRoutePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProvisioningRouteUtil} to access the provisioning route persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProvisioningRouteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROUTE = new FinderPath(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoute",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROUTE = new FinderPath(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoute",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			ProvisioningRouteModelImpl.PROVISIONINGTYPE_COLUMN_BITMASK |
			ProvisioningRouteModelImpl.ROUTETYPE_COLUMN_BITMASK |
			ProvisioningRouteModelImpl.ROUTEKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROUTE = new FinderPath(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoute",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROVISIONING =
		new FinderPath(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProvisioning",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING =
		new FinderPath(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProvisioning",
			new String[] { Long.class.getName() },
			ProvisioningRouteModelImpl.PROVISIONINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROVISIONING = new FinderPath(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProvisioning",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningRouteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the provisioning route in the entity cache if it is enabled.
	 *
	 * @param provisioningRoute the provisioning route
	 */
	public void cacheResult(ProvisioningRoute provisioningRoute) {
		EntityCacheUtil.putResult(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteImpl.class, provisioningRoute.getPrimaryKey(),
			provisioningRoute);

		provisioningRoute.resetOriginalValues();
	}

	/**
	 * Caches the provisioning routes in the entity cache if it is enabled.
	 *
	 * @param provisioningRoutes the provisioning routes
	 */
	public void cacheResult(List<ProvisioningRoute> provisioningRoutes) {
		for (ProvisioningRoute provisioningRoute : provisioningRoutes) {
			if (EntityCacheUtil.getResult(
						ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
						ProvisioningRouteImpl.class,
						provisioningRoute.getPrimaryKey()) == null) {
				cacheResult(provisioningRoute);
			}
			else {
				provisioningRoute.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all provisioning routes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProvisioningRouteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProvisioningRouteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the provisioning route.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProvisioningRoute provisioningRoute) {
		EntityCacheUtil.removeResult(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteImpl.class, provisioningRoute.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProvisioningRoute> provisioningRoutes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProvisioningRoute provisioningRoute : provisioningRoutes) {
			EntityCacheUtil.removeResult(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
				ProvisioningRouteImpl.class, provisioningRoute.getPrimaryKey());
		}
	}

	/**
	 * Creates a new provisioning route with the primary key. Does not add the provisioning route to the database.
	 *
	 * @param routeId the primary key for the new provisioning route
	 * @return the new provisioning route
	 */
	public ProvisioningRoute create(long routeId) {
		ProvisioningRoute provisioningRoute = new ProvisioningRouteImpl();

		provisioningRoute.setNew(true);
		provisioningRoute.setPrimaryKey(routeId);

		return provisioningRoute;
	}

	/**
	 * Removes the provisioning route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param routeId the primary key of the provisioning route
	 * @return the provisioning route that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a provisioning route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute remove(long routeId)
		throws NoSuchProvisioningRouteException, SystemException {
		return remove(Long.valueOf(routeId));
	}

	/**
	 * Removes the provisioning route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the provisioning route
	 * @return the provisioning route that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a provisioning route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningRoute remove(Serializable primaryKey)
		throws NoSuchProvisioningRouteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProvisioningRoute provisioningRoute = (ProvisioningRoute)session.get(ProvisioningRouteImpl.class,
					primaryKey);

			if (provisioningRoute == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProvisioningRouteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(provisioningRoute);
		}
		catch (NoSuchProvisioningRouteException nsee) {
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
	protected ProvisioningRoute removeImpl(ProvisioningRoute provisioningRoute)
		throws SystemException {
		provisioningRoute = toUnwrappedModel(provisioningRoute);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, provisioningRoute);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(provisioningRoute);

		return provisioningRoute;
	}

	@Override
	public ProvisioningRoute updateImpl(
		com.cmc.gateway.domain.model.ProvisioningRoute provisioningRoute,
		boolean merge) throws SystemException {
		provisioningRoute = toUnwrappedModel(provisioningRoute);

		boolean isNew = provisioningRoute.isNew();

		ProvisioningRouteModelImpl provisioningRouteModelImpl = (ProvisioningRouteModelImpl)provisioningRoute;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, provisioningRoute, merge);

			provisioningRoute.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProvisioningRouteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((provisioningRouteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROUTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						provisioningRouteModelImpl.getOriginalProvisioningType(),
						
						provisioningRouteModelImpl.getOriginalRouteType(),
						
						provisioningRouteModelImpl.getOriginalRouteKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROUTE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROUTE,
					args);

				args = new Object[] {
						provisioningRouteModelImpl.getProvisioningType(),
						
						provisioningRouteModelImpl.getRouteType(),
						
						provisioningRouteModelImpl.getRouteKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROUTE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROUTE,
					args);
			}

			if ((provisioningRouteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(provisioningRouteModelImpl.getOriginalProvisioningId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROVISIONING,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING,
					args);

				args = new Object[] {
						Long.valueOf(provisioningRouteModelImpl.getProvisioningId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROVISIONING,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING,
					args);
			}
		}

		EntityCacheUtil.putResult(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningRouteImpl.class, provisioningRoute.getPrimaryKey(),
			provisioningRoute);

		return provisioningRoute;
	}

	protected ProvisioningRoute toUnwrappedModel(
		ProvisioningRoute provisioningRoute) {
		if (provisioningRoute instanceof ProvisioningRouteImpl) {
			return provisioningRoute;
		}

		ProvisioningRouteImpl provisioningRouteImpl = new ProvisioningRouteImpl();

		provisioningRouteImpl.setNew(provisioningRoute.isNew());
		provisioningRouteImpl.setPrimaryKey(provisioningRoute.getPrimaryKey());

		provisioningRouteImpl.setRouteId(provisioningRoute.getRouteId());
		provisioningRouteImpl.setGroupId(provisioningRoute.getGroupId());
		provisioningRouteImpl.setCompanyId(provisioningRoute.getCompanyId());
		provisioningRouteImpl.setUserId(provisioningRoute.getUserId());
		provisioningRouteImpl.setCreateDate(provisioningRoute.getCreateDate());
		provisioningRouteImpl.setModifiedDate(provisioningRoute.getModifiedDate());
		provisioningRouteImpl.setProvisioningId(provisioningRoute.getProvisioningId());
		provisioningRouteImpl.setProvisioningType(provisioningRoute.getProvisioningType());
		provisioningRouteImpl.setRouteType(provisioningRoute.getRouteType());
		provisioningRouteImpl.setRouteKey(provisioningRoute.getRouteKey());
		provisioningRouteImpl.setDescription(provisioningRoute.getDescription());

		return provisioningRouteImpl;
	}

	/**
	 * Returns the provisioning route with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the provisioning route
	 * @return the provisioning route
	 * @throws com.liferay.portal.NoSuchModelException if a provisioning route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningRoute findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the provisioning route with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningRouteException} if it could not be found.
	 *
	 * @param routeId the primary key of the provisioning route
	 * @return the provisioning route
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a provisioning route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute findByPrimaryKey(long routeId)
		throws NoSuchProvisioningRouteException, SystemException {
		ProvisioningRoute provisioningRoute = fetchByPrimaryKey(routeId);

		if (provisioningRoute == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + routeId);
			}

			throw new NoSuchProvisioningRouteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				routeId);
		}

		return provisioningRoute;
	}

	/**
	 * Returns the provisioning route with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the provisioning route
	 * @return the provisioning route, or <code>null</code> if a provisioning route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningRoute fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the provisioning route with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param routeId the primary key of the provisioning route
	 * @return the provisioning route, or <code>null</code> if a provisioning route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute fetchByPrimaryKey(long routeId)
		throws SystemException {
		ProvisioningRoute provisioningRoute = (ProvisioningRoute)EntityCacheUtil.getResult(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
				ProvisioningRouteImpl.class, routeId);

		if (provisioningRoute == _nullProvisioningRoute) {
			return null;
		}

		if (provisioningRoute == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				provisioningRoute = (ProvisioningRoute)session.get(ProvisioningRouteImpl.class,
						Long.valueOf(routeId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (provisioningRoute != null) {
					cacheResult(provisioningRoute);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProvisioningRouteModelImpl.ENTITY_CACHE_ENABLED,
						ProvisioningRouteImpl.class, routeId,
						_nullProvisioningRoute);
				}

				closeSession(session);
			}
		}

		return provisioningRoute;
	}

	/**
	 * Returns all the provisioning routes where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param routeType the route type
	 * @param routeKey the route key
	 * @return the matching provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningRoute> findByRoute(String provisioningType,
		String routeType, String routeKey) throws SystemException {
		return findByRoute(provisioningType, routeType, routeKey,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provisioning routes where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningType the provisioning type
	 * @param routeType the route type
	 * @param routeKey the route key
	 * @param start the lower bound of the range of provisioning routes
	 * @param end the upper bound of the range of provisioning routes (not inclusive)
	 * @return the range of matching provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningRoute> findByRoute(String provisioningType,
		String routeType, String routeKey, int start, int end)
		throws SystemException {
		return findByRoute(provisioningType, routeType, routeKey, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the provisioning routes where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningType the provisioning type
	 * @param routeType the route type
	 * @param routeKey the route key
	 * @param start the lower bound of the range of provisioning routes
	 * @param end the upper bound of the range of provisioning routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningRoute> findByRoute(String provisioningType,
		String routeType, String routeKey, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROUTE;
			finderArgs = new Object[] { provisioningType, routeType, routeKey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROUTE;
			finderArgs = new Object[] {
					provisioningType, routeType, routeKey,
					
					start, end, orderByComparator
				};
		}

		List<ProvisioningRoute> list = (List<ProvisioningRoute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProvisioningRoute provisioningRoute : list) {
				if (!Validator.equals(provisioningType,
							provisioningRoute.getProvisioningType()) ||
						!Validator.equals(routeType,
							provisioningRoute.getRouteType()) ||
						!Validator.equals(routeKey,
							provisioningRoute.getRouteKey())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_PROVISIONINGROUTE_WHERE);

			if (provisioningType == null) {
				query.append(_FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_1);
			}
			else {
				if (provisioningType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_2);
				}
			}

			if (routeType == null) {
				query.append(_FINDER_COLUMN_ROUTE_ROUTETYPE_1);
			}
			else {
				if (routeType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_ROUTETYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_ROUTETYPE_2);
				}
			}

			if (routeKey == null) {
				query.append(_FINDER_COLUMN_ROUTE_ROUTEKEY_1);
			}
			else {
				if (routeKey.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_ROUTEKEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_ROUTEKEY_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProvisioningRouteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (provisioningType != null) {
					qPos.add(provisioningType);
				}

				if (routeType != null) {
					qPos.add(routeType);
				}

				if (routeKey != null) {
					qPos.add(routeKey);
				}

				list = (List<ProvisioningRoute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first provisioning route in the ordered set where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param routeType the route type
	 * @param routeKey the route key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning route
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a matching provisioning route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute findByRoute_First(String provisioningType,
		String routeType, String routeKey, OrderByComparator orderByComparator)
		throws NoSuchProvisioningRouteException, SystemException {
		ProvisioningRoute provisioningRoute = fetchByRoute_First(provisioningType,
				routeType, routeKey, orderByComparator);

		if (provisioningRoute != null) {
			return provisioningRoute;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningType=");
		msg.append(provisioningType);

		msg.append(", routeType=");
		msg.append(routeType);

		msg.append(", routeKey=");
		msg.append(routeKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningRouteException(msg.toString());
	}

	/**
	 * Returns the first provisioning route in the ordered set where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param routeType the route type
	 * @param routeKey the route key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning route, or <code>null</code> if a matching provisioning route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute fetchByRoute_First(String provisioningType,
		String routeType, String routeKey, OrderByComparator orderByComparator)
		throws SystemException {
		List<ProvisioningRoute> list = findByRoute(provisioningType, routeType,
				routeKey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last provisioning route in the ordered set where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param routeType the route type
	 * @param routeKey the route key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning route
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a matching provisioning route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute findByRoute_Last(String provisioningType,
		String routeType, String routeKey, OrderByComparator orderByComparator)
		throws NoSuchProvisioningRouteException, SystemException {
		ProvisioningRoute provisioningRoute = fetchByRoute_Last(provisioningType,
				routeType, routeKey, orderByComparator);

		if (provisioningRoute != null) {
			return provisioningRoute;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningType=");
		msg.append(provisioningType);

		msg.append(", routeType=");
		msg.append(routeType);

		msg.append(", routeKey=");
		msg.append(routeKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningRouteException(msg.toString());
	}

	/**
	 * Returns the last provisioning route in the ordered set where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param routeType the route type
	 * @param routeKey the route key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning route, or <code>null</code> if a matching provisioning route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute fetchByRoute_Last(String provisioningType,
		String routeType, String routeKey, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRoute(provisioningType, routeType, routeKey);

		List<ProvisioningRoute> list = findByRoute(provisioningType, routeType,
				routeKey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the provisioning routes before and after the current provisioning route in the ordered set where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	 *
	 * @param routeId the primary key of the current provisioning route
	 * @param provisioningType the provisioning type
	 * @param routeType the route type
	 * @param routeKey the route key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provisioning route
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a provisioning route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute[] findByRoute_PrevAndNext(long routeId,
		String provisioningType, String routeType, String routeKey,
		OrderByComparator orderByComparator)
		throws NoSuchProvisioningRouteException, SystemException {
		ProvisioningRoute provisioningRoute = findByPrimaryKey(routeId);

		Session session = null;

		try {
			session = openSession();

			ProvisioningRoute[] array = new ProvisioningRouteImpl[3];

			array[0] = getByRoute_PrevAndNext(session, provisioningRoute,
					provisioningType, routeType, routeKey, orderByComparator,
					true);

			array[1] = provisioningRoute;

			array[2] = getByRoute_PrevAndNext(session, provisioningRoute,
					provisioningType, routeType, routeKey, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProvisioningRoute getByRoute_PrevAndNext(Session session,
		ProvisioningRoute provisioningRoute, String provisioningType,
		String routeType, String routeKey, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROVISIONINGROUTE_WHERE);

		if (provisioningType == null) {
			query.append(_FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_1);
		}
		else {
			if (provisioningType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_2);
			}
		}

		if (routeType == null) {
			query.append(_FINDER_COLUMN_ROUTE_ROUTETYPE_1);
		}
		else {
			if (routeType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ROUTE_ROUTETYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_ROUTE_ROUTETYPE_2);
			}
		}

		if (routeKey == null) {
			query.append(_FINDER_COLUMN_ROUTE_ROUTEKEY_1);
		}
		else {
			if (routeKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ROUTE_ROUTEKEY_3);
			}
			else {
				query.append(_FINDER_COLUMN_ROUTE_ROUTEKEY_2);
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
			query.append(ProvisioningRouteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (provisioningType != null) {
			qPos.add(provisioningType);
		}

		if (routeType != null) {
			qPos.add(routeType);
		}

		if (routeKey != null) {
			qPos.add(routeKey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(provisioningRoute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProvisioningRoute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the provisioning routes where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @return the matching provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningRoute> findByProvisioning(long provisioningId)
		throws SystemException {
		return findByProvisioning(provisioningId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provisioning routes where provisioningId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningId the provisioning ID
	 * @param start the lower bound of the range of provisioning routes
	 * @param end the upper bound of the range of provisioning routes (not inclusive)
	 * @return the range of matching provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningRoute> findByProvisioning(long provisioningId,
		int start, int end) throws SystemException {
		return findByProvisioning(provisioningId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the provisioning routes where provisioningId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningId the provisioning ID
	 * @param start the lower bound of the range of provisioning routes
	 * @param end the upper bound of the range of provisioning routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningRoute> findByProvisioning(long provisioningId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING;
			finderArgs = new Object[] { provisioningId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROVISIONING;
			finderArgs = new Object[] {
					provisioningId,
					
					start, end, orderByComparator
				};
		}

		List<ProvisioningRoute> list = (List<ProvisioningRoute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProvisioningRoute provisioningRoute : list) {
				if ((provisioningId != provisioningRoute.getProvisioningId())) {
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

			query.append(_SQL_SELECT_PROVISIONINGROUTE_WHERE);

			query.append(_FINDER_COLUMN_PROVISIONING_PROVISIONINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProvisioningRouteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(provisioningId);

				list = (List<ProvisioningRoute>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first provisioning route in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning route
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a matching provisioning route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute findByProvisioning_First(long provisioningId,
		OrderByComparator orderByComparator)
		throws NoSuchProvisioningRouteException, SystemException {
		ProvisioningRoute provisioningRoute = fetchByProvisioning_First(provisioningId,
				orderByComparator);

		if (provisioningRoute != null) {
			return provisioningRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningId=");
		msg.append(provisioningId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningRouteException(msg.toString());
	}

	/**
	 * Returns the first provisioning route in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning route, or <code>null</code> if a matching provisioning route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute fetchByProvisioning_First(long provisioningId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProvisioningRoute> list = findByProvisioning(provisioningId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last provisioning route in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning route
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a matching provisioning route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute findByProvisioning_Last(long provisioningId,
		OrderByComparator orderByComparator)
		throws NoSuchProvisioningRouteException, SystemException {
		ProvisioningRoute provisioningRoute = fetchByProvisioning_Last(provisioningId,
				orderByComparator);

		if (provisioningRoute != null) {
			return provisioningRoute;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningId=");
		msg.append(provisioningId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningRouteException(msg.toString());
	}

	/**
	 * Returns the last provisioning route in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning route, or <code>null</code> if a matching provisioning route could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute fetchByProvisioning_Last(long provisioningId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProvisioning(provisioningId);

		List<ProvisioningRoute> list = findByProvisioning(provisioningId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the provisioning routes before and after the current provisioning route in the ordered set where provisioningId = &#63;.
	 *
	 * @param routeId the primary key of the current provisioning route
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provisioning route
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningRouteException if a provisioning route with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningRoute[] findByProvisioning_PrevAndNext(long routeId,
		long provisioningId, OrderByComparator orderByComparator)
		throws NoSuchProvisioningRouteException, SystemException {
		ProvisioningRoute provisioningRoute = findByPrimaryKey(routeId);

		Session session = null;

		try {
			session = openSession();

			ProvisioningRoute[] array = new ProvisioningRouteImpl[3];

			array[0] = getByProvisioning_PrevAndNext(session,
					provisioningRoute, provisioningId, orderByComparator, true);

			array[1] = provisioningRoute;

			array[2] = getByProvisioning_PrevAndNext(session,
					provisioningRoute, provisioningId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProvisioningRoute getByProvisioning_PrevAndNext(Session session,
		ProvisioningRoute provisioningRoute, long provisioningId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROVISIONINGROUTE_WHERE);

		query.append(_FINDER_COLUMN_PROVISIONING_PROVISIONINGID_2);

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
			query.append(ProvisioningRouteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(provisioningId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(provisioningRoute);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProvisioningRoute> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the provisioning routes.
	 *
	 * @return the provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningRoute> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provisioning routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of provisioning routes
	 * @param end the upper bound of the range of provisioning routes (not inclusive)
	 * @return the range of provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningRoute> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the provisioning routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of provisioning routes
	 * @param end the upper bound of the range of provisioning routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningRoute> findAll(int start, int end,
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

		List<ProvisioningRoute> list = (List<ProvisioningRoute>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROVISIONINGROUTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROVISIONINGROUTE.concat(ProvisioningRouteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProvisioningRoute>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProvisioningRoute>)QueryUtil.list(q,
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
	 * Removes all the provisioning routes where provisioningType = &#63; and routeType = &#63; and routeKey = &#63; from the database.
	 *
	 * @param provisioningType the provisioning type
	 * @param routeType the route type
	 * @param routeKey the route key
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByRoute(String provisioningType, String routeType,
		String routeKey) throws SystemException {
		for (ProvisioningRoute provisioningRoute : findByRoute(
				provisioningType, routeType, routeKey)) {
			remove(provisioningRoute);
		}
	}

	/**
	 * Removes all the provisioning routes where provisioningId = &#63; from the database.
	 *
	 * @param provisioningId the provisioning ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByProvisioning(long provisioningId)
		throws SystemException {
		for (ProvisioningRoute provisioningRoute : findByProvisioning(
				provisioningId)) {
			remove(provisioningRoute);
		}
	}

	/**
	 * Removes all the provisioning routes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProvisioningRoute provisioningRoute : findAll()) {
			remove(provisioningRoute);
		}
	}

	/**
	 * Returns the number of provisioning routes where provisioningType = &#63; and routeType = &#63; and routeKey = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param routeType the route type
	 * @param routeKey the route key
	 * @return the number of matching provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRoute(String provisioningType, String routeType,
		String routeKey) throws SystemException {
		Object[] finderArgs = new Object[] { provisioningType, routeType, routeKey };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROUTE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PROVISIONINGROUTE_WHERE);

			if (provisioningType == null) {
				query.append(_FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_1);
			}
			else {
				if (provisioningType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_2);
				}
			}

			if (routeType == null) {
				query.append(_FINDER_COLUMN_ROUTE_ROUTETYPE_1);
			}
			else {
				if (routeType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_ROUTETYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_ROUTETYPE_2);
				}
			}

			if (routeKey == null) {
				query.append(_FINDER_COLUMN_ROUTE_ROUTEKEY_1);
			}
			else {
				if (routeKey.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROUTE_ROUTEKEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROUTE_ROUTEKEY_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (provisioningType != null) {
					qPos.add(provisioningType);
				}

				if (routeType != null) {
					qPos.add(routeType);
				}

				if (routeKey != null) {
					qPos.add(routeKey);
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
	 * Returns the number of provisioning routes where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @return the number of matching provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProvisioning(long provisioningId)
		throws SystemException {
		Object[] finderArgs = new Object[] { provisioningId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROVISIONING,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROVISIONINGROUTE_WHERE);

			query.append(_FINDER_COLUMN_PROVISIONING_PROVISIONINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(provisioningId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROVISIONING,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of provisioning routes.
	 *
	 * @return the number of provisioning routes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROVISIONINGROUTE);

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
	 * Initializes the provisioning route persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.ProvisioningRoute")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProvisioningRoute>> listenersList = new ArrayList<ModelListener<ProvisioningRoute>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProvisioningRoute>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProvisioningRouteImpl.class.getName());
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
	private static final String _SQL_SELECT_PROVISIONINGROUTE = "SELECT provisioningRoute FROM ProvisioningRoute provisioningRoute";
	private static final String _SQL_SELECT_PROVISIONINGROUTE_WHERE = "SELECT provisioningRoute FROM ProvisioningRoute provisioningRoute WHERE ";
	private static final String _SQL_COUNT_PROVISIONINGROUTE = "SELECT COUNT(provisioningRoute) FROM ProvisioningRoute provisioningRoute";
	private static final String _SQL_COUNT_PROVISIONINGROUTE_WHERE = "SELECT COUNT(provisioningRoute) FROM ProvisioningRoute provisioningRoute WHERE ";
	private static final String _FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_1 = "provisioningRoute.provisioningType IS NULL AND ";
	private static final String _FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_2 = "provisioningRoute.provisioningType = ? AND ";
	private static final String _FINDER_COLUMN_ROUTE_PROVISIONINGTYPE_3 = "(provisioningRoute.provisioningType IS NULL OR provisioningRoute.provisioningType = ?) AND ";
	private static final String _FINDER_COLUMN_ROUTE_ROUTETYPE_1 = "provisioningRoute.routeType IS NULL AND ";
	private static final String _FINDER_COLUMN_ROUTE_ROUTETYPE_2 = "provisioningRoute.routeType = ? AND ";
	private static final String _FINDER_COLUMN_ROUTE_ROUTETYPE_3 = "(provisioningRoute.routeType IS NULL OR provisioningRoute.routeType = ?) AND ";
	private static final String _FINDER_COLUMN_ROUTE_ROUTEKEY_1 = "provisioningRoute.routeKey IS NULL";
	private static final String _FINDER_COLUMN_ROUTE_ROUTEKEY_2 = "provisioningRoute.routeKey = ?";
	private static final String _FINDER_COLUMN_ROUTE_ROUTEKEY_3 = "(provisioningRoute.routeKey IS NULL OR provisioningRoute.routeKey = ?)";
	private static final String _FINDER_COLUMN_PROVISIONING_PROVISIONINGID_2 = "provisioningRoute.provisioningId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "provisioningRoute.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProvisioningRoute exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProvisioningRoute exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProvisioningRoutePersistenceImpl.class);
	private static ProvisioningRoute _nullProvisioningRoute = new ProvisioningRouteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProvisioningRoute> toCacheModel() {
				return _nullProvisioningRouteCacheModel;
			}
		};

	private static CacheModel<ProvisioningRoute> _nullProvisioningRouteCacheModel =
		new CacheModel<ProvisioningRoute>() {
			public ProvisioningRoute toEntityModel() {
				return _nullProvisioningRoute;
			}
		};
}