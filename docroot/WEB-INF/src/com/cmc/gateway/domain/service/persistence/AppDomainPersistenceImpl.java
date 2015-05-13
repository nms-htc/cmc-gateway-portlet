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

import com.cmc.gateway.domain.NoSuchAppDomainException;
import com.cmc.gateway.domain.model.AppDomain;
import com.cmc.gateway.domain.model.impl.AppDomainImpl;
import com.cmc.gateway.domain.model.impl.AppDomainModelImpl;

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
 * The persistence implementation for the app domain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see AppDomainPersistence
 * @see AppDomainUtil
 * @generated
 */
public class AppDomainPersistenceImpl extends BasePersistenceImpl<AppDomain>
	implements AppDomainPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AppDomainUtil} to access the app domain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AppDomainImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
			AppDomainModelImpl.FINDER_CACHE_ENABLED, AppDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
			AppDomainModelImpl.FINDER_CACHE_ENABLED, AppDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { String.class.getName() },
			AppDomainModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
			AppDomainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
			AppDomainModelImpl.FINDER_CACHE_ENABLED, AppDomainImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName(), String.class.getName() },
			AppDomainModelImpl.TYPE_COLUMN_BITMASK |
			AppDomainModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
			AppDomainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
			AppDomainModelImpl.FINDER_CACHE_ENABLED, AppDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
			AppDomainModelImpl.FINDER_CACHE_ENABLED, AppDomainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
			AppDomainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the app domain in the entity cache if it is enabled.
	 *
	 * @param appDomain the app domain
	 */
	public void cacheResult(AppDomain appDomain) {
		EntityCacheUtil.putResult(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
			AppDomainImpl.class, appDomain.getPrimaryKey(), appDomain);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { appDomain.getType(), appDomain.getCode() }, appDomain);

		appDomain.resetOriginalValues();
	}

	/**
	 * Caches the app domains in the entity cache if it is enabled.
	 *
	 * @param appDomains the app domains
	 */
	public void cacheResult(List<AppDomain> appDomains) {
		for (AppDomain appDomain : appDomains) {
			if (EntityCacheUtil.getResult(
						AppDomainModelImpl.ENTITY_CACHE_ENABLED,
						AppDomainImpl.class, appDomain.getPrimaryKey()) == null) {
				cacheResult(appDomain);
			}
			else {
				appDomain.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all app domains.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AppDomainImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AppDomainImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the app domain.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppDomain appDomain) {
		EntityCacheUtil.removeResult(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
			AppDomainImpl.class, appDomain.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(appDomain);
	}

	@Override
	public void clearCache(List<AppDomain> appDomains) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AppDomain appDomain : appDomains) {
			EntityCacheUtil.removeResult(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
				AppDomainImpl.class, appDomain.getPrimaryKey());

			clearUniqueFindersCache(appDomain);
		}
	}

	protected void clearUniqueFindersCache(AppDomain appDomain) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { appDomain.getType(), appDomain.getCode() });
	}

	/**
	 * Creates a new app domain with the primary key. Does not add the app domain to the database.
	 *
	 * @param domainId the primary key for the new app domain
	 * @return the new app domain
	 */
	public AppDomain create(long domainId) {
		AppDomain appDomain = new AppDomainImpl();

		appDomain.setNew(true);
		appDomain.setPrimaryKey(domainId);

		return appDomain;
	}

	/**
	 * Removes the app domain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param domainId the primary key of the app domain
	 * @return the app domain that was removed
	 * @throws com.cmc.gateway.domain.NoSuchAppDomainException if a app domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain remove(long domainId)
		throws NoSuchAppDomainException, SystemException {
		return remove(Long.valueOf(domainId));
	}

	/**
	 * Removes the app domain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the app domain
	 * @return the app domain that was removed
	 * @throws com.cmc.gateway.domain.NoSuchAppDomainException if a app domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AppDomain remove(Serializable primaryKey)
		throws NoSuchAppDomainException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AppDomain appDomain = (AppDomain)session.get(AppDomainImpl.class,
					primaryKey);

			if (appDomain == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppDomainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(appDomain);
		}
		catch (NoSuchAppDomainException nsee) {
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
	protected AppDomain removeImpl(AppDomain appDomain)
		throws SystemException {
		appDomain = toUnwrappedModel(appDomain);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, appDomain);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(appDomain);

		return appDomain;
	}

	@Override
	public AppDomain updateImpl(
		com.cmc.gateway.domain.model.AppDomain appDomain, boolean merge)
		throws SystemException {
		appDomain = toUnwrappedModel(appDomain);

		boolean isNew = appDomain.isNew();

		AppDomainModelImpl appDomainModelImpl = (AppDomainModelImpl)appDomain;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, appDomain, merge);

			appDomain.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AppDomainModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((appDomainModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appDomainModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { appDomainModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
			AppDomainImpl.class, appDomain.getPrimaryKey(), appDomain);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
				new Object[] { appDomain.getType(), appDomain.getCode() },
				appDomain);
		}
		else {
			if ((appDomainModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appDomainModelImpl.getOriginalType(),
						
						appDomainModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
					new Object[] { appDomain.getType(), appDomain.getCode() },
					appDomain);
			}
		}

		return appDomain;
	}

	protected AppDomain toUnwrappedModel(AppDomain appDomain) {
		if (appDomain instanceof AppDomainImpl) {
			return appDomain;
		}

		AppDomainImpl appDomainImpl = new AppDomainImpl();

		appDomainImpl.setNew(appDomain.isNew());
		appDomainImpl.setPrimaryKey(appDomain.getPrimaryKey());

		appDomainImpl.setDomainId(appDomain.getDomainId());
		appDomainImpl.setGroupId(appDomain.getGroupId());
		appDomainImpl.setCompanyId(appDomain.getCompanyId());
		appDomainImpl.setUserId(appDomain.getUserId());
		appDomainImpl.setCreateDate(appDomain.getCreateDate());
		appDomainImpl.setModifiedDate(appDomain.getModifiedDate());
		appDomainImpl.setType(appDomain.getType());
		appDomainImpl.setCode(appDomain.getCode());
		appDomainImpl.setTitle(appDomain.getTitle());
		appDomainImpl.setValue(appDomain.getValue());
		appDomainImpl.setDefaultValue(appDomain.isDefaultValue());
		appDomainImpl.setDescription(appDomain.getDescription());

		return appDomainImpl;
	}

	/**
	 * Returns the app domain with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the app domain
	 * @return the app domain
	 * @throws com.liferay.portal.NoSuchModelException if a app domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AppDomain findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the app domain with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchAppDomainException} if it could not be found.
	 *
	 * @param domainId the primary key of the app domain
	 * @return the app domain
	 * @throws com.cmc.gateway.domain.NoSuchAppDomainException if a app domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain findByPrimaryKey(long domainId)
		throws NoSuchAppDomainException, SystemException {
		AppDomain appDomain = fetchByPrimaryKey(domainId);

		if (appDomain == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + domainId);
			}

			throw new NoSuchAppDomainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				domainId);
		}

		return appDomain;
	}

	/**
	 * Returns the app domain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the app domain
	 * @return the app domain, or <code>null</code> if a app domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AppDomain fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the app domain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param domainId the primary key of the app domain
	 * @return the app domain, or <code>null</code> if a app domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain fetchByPrimaryKey(long domainId) throws SystemException {
		AppDomain appDomain = (AppDomain)EntityCacheUtil.getResult(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
				AppDomainImpl.class, domainId);

		if (appDomain == _nullAppDomain) {
			return null;
		}

		if (appDomain == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				appDomain = (AppDomain)session.get(AppDomainImpl.class,
						Long.valueOf(domainId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (appDomain != null) {
					cacheResult(appDomain);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AppDomainModelImpl.ENTITY_CACHE_ENABLED,
						AppDomainImpl.class, domainId, _nullAppDomain);
				}

				closeSession(session);
			}
		}

		return appDomain;
	}

	/**
	 * Returns all the app domains where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching app domains
	 * @throws SystemException if a system exception occurred
	 */
	public List<AppDomain> findByType(String type) throws SystemException {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app domains where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of app domains
	 * @param end the upper bound of the range of app domains (not inclusive)
	 * @return the range of matching app domains
	 * @throws SystemException if a system exception occurred
	 */
	public List<AppDomain> findByType(String type, int start, int end)
		throws SystemException {
		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the app domains where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of app domains
	 * @param end the upper bound of the range of app domains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching app domains
	 * @throws SystemException if a system exception occurred
	 */
	public List<AppDomain> findByType(String type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<AppDomain> list = (List<AppDomain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AppDomain appDomain : list) {
				if (!Validator.equals(type, appDomain.getType())) {
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

			query.append(_SQL_SELECT_APPDOMAIN_WHERE);

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else {
				if (type.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TYPE_TYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TYPE_TYPE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AppDomainModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (type != null) {
					qPos.add(type);
				}

				list = (List<AppDomain>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first app domain in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app domain
	 * @throws com.cmc.gateway.domain.NoSuchAppDomainException if a matching app domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain findByType_First(String type,
		OrderByComparator orderByComparator)
		throws NoSuchAppDomainException, SystemException {
		AppDomain appDomain = fetchByType_First(type, orderByComparator);

		if (appDomain != null) {
			return appDomain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppDomainException(msg.toString());
	}

	/**
	 * Returns the first app domain in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app domain, or <code>null</code> if a matching app domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain fetchByType_First(String type,
		OrderByComparator orderByComparator) throws SystemException {
		List<AppDomain> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app domain in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app domain
	 * @throws com.cmc.gateway.domain.NoSuchAppDomainException if a matching app domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain findByType_Last(String type,
		OrderByComparator orderByComparator)
		throws NoSuchAppDomainException, SystemException {
		AppDomain appDomain = fetchByType_Last(type, orderByComparator);

		if (appDomain != null) {
			return appDomain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppDomainException(msg.toString());
	}

	/**
	 * Returns the last app domain in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app domain, or <code>null</code> if a matching app domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain fetchByType_Last(String type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(type);

		List<AppDomain> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the app domains before and after the current app domain in the ordered set where type = &#63;.
	 *
	 * @param domainId the primary key of the current app domain
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next app domain
	 * @throws com.cmc.gateway.domain.NoSuchAppDomainException if a app domain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain[] findByType_PrevAndNext(long domainId, String type,
		OrderByComparator orderByComparator)
		throws NoSuchAppDomainException, SystemException {
		AppDomain appDomain = findByPrimaryKey(domainId);

		Session session = null;

		try {
			session = openSession();

			AppDomain[] array = new AppDomainImpl[3];

			array[0] = getByType_PrevAndNext(session, appDomain, type,
					orderByComparator, true);

			array[1] = appDomain;

			array[2] = getByType_PrevAndNext(session, appDomain, type,
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

	protected AppDomain getByType_PrevAndNext(Session session,
		AppDomain appDomain, String type, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPDOMAIN_WHERE);

		if (type == null) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_1);
		}
		else {
			if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
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
			query.append(AppDomainModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (type != null) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(appDomain);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AppDomain> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the app domain where type = &#63; and code = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchAppDomainException} if it could not be found.
	 *
	 * @param type the type
	 * @param code the code
	 * @return the matching app domain
	 * @throws com.cmc.gateway.domain.NoSuchAppDomainException if a matching app domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain findByCode(String type, String code)
		throws NoSuchAppDomainException, SystemException {
		AppDomain appDomain = fetchByCode(type, code);

		if (appDomain == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("type=");
			msg.append(type);

			msg.append(", code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAppDomainException(msg.toString());
		}

		return appDomain;
	}

	/**
	 * Returns the app domain where type = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param type the type
	 * @param code the code
	 * @return the matching app domain, or <code>null</code> if a matching app domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain fetchByCode(String type, String code)
		throws SystemException {
		return fetchByCode(type, code, true);
	}

	/**
	 * Returns the app domain where type = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param type the type
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching app domain, or <code>null</code> if a matching app domain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain fetchByCode(String type, String code,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { type, code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof AppDomain) {
			AppDomain appDomain = (AppDomain)result;

			if (!Validator.equals(type, appDomain.getType()) ||
					!Validator.equals(code, appDomain.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_APPDOMAIN_WHERE);

			if (type == null) {
				query.append(_FINDER_COLUMN_CODE_TYPE_1);
			}
			else {
				if (type.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CODE_TYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_CODE_TYPE_2);
				}
			}

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

			query.append(AppDomainModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (type != null) {
					qPos.add(type);
				}

				if (code != null) {
					qPos.add(code);
				}

				List<AppDomain> list = q.list();

				result = list;

				AppDomain appDomain = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					appDomain = list.get(0);

					cacheResult(appDomain);

					if ((appDomain.getType() == null) ||
							!appDomain.getType().equals(type) ||
							(appDomain.getCode() == null) ||
							!appDomain.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, appDomain);
					}
				}

				return appDomain;
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
				return (AppDomain)result;
			}
		}
	}

	/**
	 * Returns all the app domains.
	 *
	 * @return the app domains
	 * @throws SystemException if a system exception occurred
	 */
	public List<AppDomain> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the app domains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of app domains
	 * @param end the upper bound of the range of app domains (not inclusive)
	 * @return the range of app domains
	 * @throws SystemException if a system exception occurred
	 */
	public List<AppDomain> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the app domains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of app domains
	 * @param end the upper bound of the range of app domains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of app domains
	 * @throws SystemException if a system exception occurred
	 */
	public List<AppDomain> findAll(int start, int end,
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

		List<AppDomain> list = (List<AppDomain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_APPDOMAIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPDOMAIN.concat(AppDomainModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AppDomain>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AppDomain>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the app domains where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByType(String type) throws SystemException {
		for (AppDomain appDomain : findByType(type)) {
			remove(appDomain);
		}
	}

	/**
	 * Removes the app domain where type = &#63; and code = &#63; from the database.
	 *
	 * @param type the type
	 * @param code the code
	 * @return the app domain that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public AppDomain removeByCode(String type, String code)
		throws NoSuchAppDomainException, SystemException {
		AppDomain appDomain = findByCode(type, code);

		return remove(appDomain);
	}

	/**
	 * Removes all the app domains from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AppDomain appDomain : findAll()) {
			remove(appDomain);
		}
	}

	/**
	 * Returns the number of app domains where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching app domains
	 * @throws SystemException if a system exception occurred
	 */
	public int countByType(String type) throws SystemException {
		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPDOMAIN_WHERE);

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else {
				if (type.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TYPE_TYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TYPE_TYPE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (type != null) {
					qPos.add(type);
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
	 * Returns the number of app domains where type = &#63; and code = &#63;.
	 *
	 * @param type the type
	 * @param code the code
	 * @return the number of matching app domains
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCode(String type, String code) throws SystemException {
		Object[] finderArgs = new Object[] { type, code };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_APPDOMAIN_WHERE);

			if (type == null) {
				query.append(_FINDER_COLUMN_CODE_TYPE_1);
			}
			else {
				if (type.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CODE_TYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_CODE_TYPE_2);
				}
			}

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

				if (type != null) {
					qPos.add(type);
				}

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
	 * Returns the number of app domains.
	 *
	 * @return the number of app domains
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPDOMAIN);

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
	 * Initializes the app domain persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.AppDomain")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AppDomain>> listenersList = new ArrayList<ModelListener<AppDomain>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AppDomain>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AppDomainImpl.class.getName());
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
	private static final String _SQL_SELECT_APPDOMAIN = "SELECT appDomain FROM AppDomain appDomain";
	private static final String _SQL_SELECT_APPDOMAIN_WHERE = "SELECT appDomain FROM AppDomain appDomain WHERE ";
	private static final String _SQL_COUNT_APPDOMAIN = "SELECT COUNT(appDomain) FROM AppDomain appDomain";
	private static final String _SQL_COUNT_APPDOMAIN_WHERE = "SELECT COUNT(appDomain) FROM AppDomain appDomain WHERE ";
	private static final String _FINDER_COLUMN_TYPE_TYPE_1 = "appDomain.type IS NULL";
	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "appDomain.type = ?";
	private static final String _FINDER_COLUMN_TYPE_TYPE_3 = "(appDomain.type IS NULL OR appDomain.type = ?)";
	private static final String _FINDER_COLUMN_CODE_TYPE_1 = "appDomain.type IS NULL AND ";
	private static final String _FINDER_COLUMN_CODE_TYPE_2 = "appDomain.type = ? AND ";
	private static final String _FINDER_COLUMN_CODE_TYPE_3 = "(appDomain.type IS NULL OR appDomain.type = ?) AND ";
	private static final String _FINDER_COLUMN_CODE_CODE_1 = "appDomain.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "appDomain.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(appDomain.code IS NULL OR appDomain.code = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "appDomain.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AppDomain exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AppDomain exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AppDomainPersistenceImpl.class);
	private static AppDomain _nullAppDomain = new AppDomainImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AppDomain> toCacheModel() {
				return _nullAppDomainCacheModel;
			}
		};

	private static CacheModel<AppDomain> _nullAppDomainCacheModel = new CacheModel<AppDomain>() {
			public AppDomain toEntityModel() {
				return _nullAppDomain;
			}
		};
}