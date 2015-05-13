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

import com.cmc.gateway.domain.NoSuchProvisioningEntryException;
import com.cmc.gateway.domain.model.ProvisioningEntry;
import com.cmc.gateway.domain.model.impl.ProvisioningEntryImpl;
import com.cmc.gateway.domain.model.impl.ProvisioningEntryModelImpl;

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
 * The persistence implementation for the provisioning entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningEntryPersistence
 * @see ProvisioningEntryUtil
 * @generated
 */
public class ProvisioningEntryPersistenceImpl extends BasePersistenceImpl<ProvisioningEntry>
	implements ProvisioningEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProvisioningEntryUtil} to access the provisioning entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProvisioningEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningEntryModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCode", new String[] { String.class.getName() },
			ProvisioningEntryModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningEntryModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningEntryModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { String.class.getName() },
			ProvisioningEntryModelImpl.PROVISIONINGTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningEntryModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningEntryModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the provisioning entry in the entity cache if it is enabled.
	 *
	 * @param provisioningEntry the provisioning entry
	 */
	public void cacheResult(ProvisioningEntry provisioningEntry) {
		EntityCacheUtil.putResult(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningEntryImpl.class, provisioningEntry.getPrimaryKey(),
			provisioningEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { provisioningEntry.getCode() }, provisioningEntry);

		provisioningEntry.resetOriginalValues();
	}

	/**
	 * Caches the provisioning entries in the entity cache if it is enabled.
	 *
	 * @param provisioningEntries the provisioning entries
	 */
	public void cacheResult(List<ProvisioningEntry> provisioningEntries) {
		for (ProvisioningEntry provisioningEntry : provisioningEntries) {
			if (EntityCacheUtil.getResult(
						ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
						ProvisioningEntryImpl.class,
						provisioningEntry.getPrimaryKey()) == null) {
				cacheResult(provisioningEntry);
			}
			else {
				provisioningEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all provisioning entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProvisioningEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProvisioningEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the provisioning entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProvisioningEntry provisioningEntry) {
		EntityCacheUtil.removeResult(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningEntryImpl.class, provisioningEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(provisioningEntry);
	}

	@Override
	public void clearCache(List<ProvisioningEntry> provisioningEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProvisioningEntry provisioningEntry : provisioningEntries) {
			EntityCacheUtil.removeResult(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
				ProvisioningEntryImpl.class, provisioningEntry.getPrimaryKey());

			clearUniqueFindersCache(provisioningEntry);
		}
	}

	protected void clearUniqueFindersCache(ProvisioningEntry provisioningEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { provisioningEntry.getCode() });
	}

	/**
	 * Creates a new provisioning entry with the primary key. Does not add the provisioning entry to the database.
	 *
	 * @param provisioningId the primary key for the new provisioning entry
	 * @return the new provisioning entry
	 */
	public ProvisioningEntry create(long provisioningId) {
		ProvisioningEntry provisioningEntry = new ProvisioningEntryImpl();

		provisioningEntry.setNew(true);
		provisioningEntry.setPrimaryKey(provisioningId);

		return provisioningEntry;
	}

	/**
	 * Removes the provisioning entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param provisioningId the primary key of the provisioning entry
	 * @return the provisioning entry that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a provisioning entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry remove(long provisioningId)
		throws NoSuchProvisioningEntryException, SystemException {
		return remove(Long.valueOf(provisioningId));
	}

	/**
	 * Removes the provisioning entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the provisioning entry
	 * @return the provisioning entry that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a provisioning entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningEntry remove(Serializable primaryKey)
		throws NoSuchProvisioningEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProvisioningEntry provisioningEntry = (ProvisioningEntry)session.get(ProvisioningEntryImpl.class,
					primaryKey);

			if (provisioningEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProvisioningEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(provisioningEntry);
		}
		catch (NoSuchProvisioningEntryException nsee) {
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
	protected ProvisioningEntry removeImpl(ProvisioningEntry provisioningEntry)
		throws SystemException {
		provisioningEntry = toUnwrappedModel(provisioningEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, provisioningEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(provisioningEntry);

		return provisioningEntry;
	}

	@Override
	public ProvisioningEntry updateImpl(
		com.cmc.gateway.domain.model.ProvisioningEntry provisioningEntry,
		boolean merge) throws SystemException {
		provisioningEntry = toUnwrappedModel(provisioningEntry);

		boolean isNew = provisioningEntry.isNew();

		ProvisioningEntryModelImpl provisioningEntryModelImpl = (ProvisioningEntryModelImpl)provisioningEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, provisioningEntry, merge);

			provisioningEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProvisioningEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((provisioningEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						provisioningEntryModelImpl.getOriginalProvisioningType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] {
						provisioningEntryModelImpl.getProvisioningType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningEntryImpl.class, provisioningEntry.getPrimaryKey(),
			provisioningEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
				new Object[] { provisioningEntry.getCode() }, provisioningEntry);
		}
		else {
			if ((provisioningEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						provisioningEntryModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
					new Object[] { provisioningEntry.getCode() },
					provisioningEntry);
			}
		}

		return provisioningEntry;
	}

	protected ProvisioningEntry toUnwrappedModel(
		ProvisioningEntry provisioningEntry) {
		if (provisioningEntry instanceof ProvisioningEntryImpl) {
			return provisioningEntry;
		}

		ProvisioningEntryImpl provisioningEntryImpl = new ProvisioningEntryImpl();

		provisioningEntryImpl.setNew(provisioningEntry.isNew());
		provisioningEntryImpl.setPrimaryKey(provisioningEntry.getPrimaryKey());

		provisioningEntryImpl.setProvisioningId(provisioningEntry.getProvisioningId());
		provisioningEntryImpl.setGroupId(provisioningEntry.getGroupId());
		provisioningEntryImpl.setCompanyId(provisioningEntry.getCompanyId());
		provisioningEntryImpl.setUserId(provisioningEntry.getUserId());
		provisioningEntryImpl.setCreateDate(provisioningEntry.getCreateDate());
		provisioningEntryImpl.setModifiedDate(provisioningEntry.getModifiedDate());
		provisioningEntryImpl.setProvisioningType(provisioningEntry.getProvisioningType());
		provisioningEntryImpl.setCode(provisioningEntry.getCode());
		provisioningEntryImpl.setTitle(provisioningEntry.getTitle());
		provisioningEntryImpl.setConnectionHost(provisioningEntry.getConnectionHost());
		provisioningEntryImpl.setConnectionPort(provisioningEntry.getConnectionPort());
		provisioningEntryImpl.setConnectByUserName(provisioningEntry.getConnectByUserName());
		provisioningEntryImpl.setConnectByPassword(provisioningEntry.getConnectByPassword());
		provisioningEntryImpl.setProcessClass(provisioningEntry.getProcessClass());
		provisioningEntryImpl.setProcessMethod(provisioningEntry.getProcessMethod());
		provisioningEntryImpl.setProperties(provisioningEntry.getProperties());
		provisioningEntryImpl.setStatus(provisioningEntry.getStatus());
		provisioningEntryImpl.setDescription(provisioningEntry.getDescription());

		return provisioningEntryImpl;
	}

	/**
	 * Returns the provisioning entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the provisioning entry
	 * @return the provisioning entry
	 * @throws com.liferay.portal.NoSuchModelException if a provisioning entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the provisioning entry with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningEntryException} if it could not be found.
	 *
	 * @param provisioningId the primary key of the provisioning entry
	 * @return the provisioning entry
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a provisioning entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry findByPrimaryKey(long provisioningId)
		throws NoSuchProvisioningEntryException, SystemException {
		ProvisioningEntry provisioningEntry = fetchByPrimaryKey(provisioningId);

		if (provisioningEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + provisioningId);
			}

			throw new NoSuchProvisioningEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				provisioningId);
		}

		return provisioningEntry;
	}

	/**
	 * Returns the provisioning entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the provisioning entry
	 * @return the provisioning entry, or <code>null</code> if a provisioning entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the provisioning entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param provisioningId the primary key of the provisioning entry
	 * @return the provisioning entry, or <code>null</code> if a provisioning entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry fetchByPrimaryKey(long provisioningId)
		throws SystemException {
		ProvisioningEntry provisioningEntry = (ProvisioningEntry)EntityCacheUtil.getResult(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
				ProvisioningEntryImpl.class, provisioningId);

		if (provisioningEntry == _nullProvisioningEntry) {
			return null;
		}

		if (provisioningEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				provisioningEntry = (ProvisioningEntry)session.get(ProvisioningEntryImpl.class,
						Long.valueOf(provisioningId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (provisioningEntry != null) {
					cacheResult(provisioningEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProvisioningEntryModelImpl.ENTITY_CACHE_ENABLED,
						ProvisioningEntryImpl.class, provisioningId,
						_nullProvisioningEntry);
				}

				closeSession(session);
			}
		}

		return provisioningEntry;
	}

	/**
	 * Returns the provisioning entry where code = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningEntryException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching provisioning entry
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a matching provisioning entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry findByCode(String code)
		throws NoSuchProvisioningEntryException, SystemException {
		ProvisioningEntry provisioningEntry = fetchByCode(code);

		if (provisioningEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProvisioningEntryException(msg.toString());
		}

		return provisioningEntry;
	}

	/**
	 * Returns the provisioning entry where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching provisioning entry, or <code>null</code> if a matching provisioning entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the provisioning entry where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching provisioning entry, or <code>null</code> if a matching provisioning entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof ProvisioningEntry) {
			ProvisioningEntry provisioningEntry = (ProvisioningEntry)result;

			if (!Validator.equals(code, provisioningEntry.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PROVISIONINGENTRY_WHERE);

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

			query.append(ProvisioningEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (code != null) {
					qPos.add(code);
				}

				List<ProvisioningEntry> list = q.list();

				result = list;

				ProvisioningEntry provisioningEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					provisioningEntry = list.get(0);

					cacheResult(provisioningEntry);

					if ((provisioningEntry.getCode() == null) ||
							!provisioningEntry.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, provisioningEntry);
					}
				}

				return provisioningEntry;
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
				return (ProvisioningEntry)result;
			}
		}
	}

	/**
	 * Returns all the provisioning entries where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @return the matching provisioning entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningEntry> findByType(String provisioningType)
		throws SystemException {
		return findByType(provisioningType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provisioning entries where provisioningType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningType the provisioning type
	 * @param start the lower bound of the range of provisioning entries
	 * @param end the upper bound of the range of provisioning entries (not inclusive)
	 * @return the range of matching provisioning entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningEntry> findByType(String provisioningType,
		int start, int end) throws SystemException {
		return findByType(provisioningType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the provisioning entries where provisioningType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningType the provisioning type
	 * @param start the lower bound of the range of provisioning entries
	 * @param end the upper bound of the range of provisioning entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provisioning entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningEntry> findByType(String provisioningType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { provisioningType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] {
					provisioningType,
					
					start, end, orderByComparator
				};
		}

		List<ProvisioningEntry> list = (List<ProvisioningEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProvisioningEntry provisioningEntry : list) {
				if (!Validator.equals(provisioningType,
							provisioningEntry.getProvisioningType())) {
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

			query.append(_SQL_SELECT_PROVISIONINGENTRY_WHERE);

			if (provisioningType == null) {
				query.append(_FINDER_COLUMN_TYPE_PROVISIONINGTYPE_1);
			}
			else {
				if (provisioningType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TYPE_PROVISIONINGTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TYPE_PROVISIONINGTYPE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProvisioningEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProvisioningEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first provisioning entry in the ordered set where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning entry
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a matching provisioning entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry findByType_First(String provisioningType,
		OrderByComparator orderByComparator)
		throws NoSuchProvisioningEntryException, SystemException {
		ProvisioningEntry provisioningEntry = fetchByType_First(provisioningType,
				orderByComparator);

		if (provisioningEntry != null) {
			return provisioningEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningType=");
		msg.append(provisioningType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningEntryException(msg.toString());
	}

	/**
	 * Returns the first provisioning entry in the ordered set where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning entry, or <code>null</code> if a matching provisioning entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry fetchByType_First(String provisioningType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProvisioningEntry> list = findByType(provisioningType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last provisioning entry in the ordered set where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning entry
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a matching provisioning entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry findByType_Last(String provisioningType,
		OrderByComparator orderByComparator)
		throws NoSuchProvisioningEntryException, SystemException {
		ProvisioningEntry provisioningEntry = fetchByType_Last(provisioningType,
				orderByComparator);

		if (provisioningEntry != null) {
			return provisioningEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningType=");
		msg.append(provisioningType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningEntryException(msg.toString());
	}

	/**
	 * Returns the last provisioning entry in the ordered set where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning entry, or <code>null</code> if a matching provisioning entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry fetchByType_Last(String provisioningType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(provisioningType);

		List<ProvisioningEntry> list = findByType(provisioningType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the provisioning entries before and after the current provisioning entry in the ordered set where provisioningType = &#63;.
	 *
	 * @param provisioningId the primary key of the current provisioning entry
	 * @param provisioningType the provisioning type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provisioning entry
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningEntryException if a provisioning entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry[] findByType_PrevAndNext(long provisioningId,
		String provisioningType, OrderByComparator orderByComparator)
		throws NoSuchProvisioningEntryException, SystemException {
		ProvisioningEntry provisioningEntry = findByPrimaryKey(provisioningId);

		Session session = null;

		try {
			session = openSession();

			ProvisioningEntry[] array = new ProvisioningEntryImpl[3];

			array[0] = getByType_PrevAndNext(session, provisioningEntry,
					provisioningType, orderByComparator, true);

			array[1] = provisioningEntry;

			array[2] = getByType_PrevAndNext(session, provisioningEntry,
					provisioningType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProvisioningEntry getByType_PrevAndNext(Session session,
		ProvisioningEntry provisioningEntry, String provisioningType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROVISIONINGENTRY_WHERE);

		if (provisioningType == null) {
			query.append(_FINDER_COLUMN_TYPE_PROVISIONINGTYPE_1);
		}
		else {
			if (provisioningType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_PROVISIONINGTYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TYPE_PROVISIONINGTYPE_2);
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
			query.append(ProvisioningEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (provisioningType != null) {
			qPos.add(provisioningType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(provisioningEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProvisioningEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the provisioning entries.
	 *
	 * @return the provisioning entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provisioning entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of provisioning entries
	 * @param end the upper bound of the range of provisioning entries (not inclusive)
	 * @return the range of provisioning entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the provisioning entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of provisioning entries
	 * @param end the upper bound of the range of provisioning entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of provisioning entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningEntry> findAll(int start, int end,
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

		List<ProvisioningEntry> list = (List<ProvisioningEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROVISIONINGENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROVISIONINGENTRY.concat(ProvisioningEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProvisioningEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProvisioningEntry>)QueryUtil.list(q,
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
	 * Removes the provisioning entry where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the provisioning entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningEntry removeByCode(String code)
		throws NoSuchProvisioningEntryException, SystemException {
		ProvisioningEntry provisioningEntry = findByCode(code);

		return remove(provisioningEntry);
	}

	/**
	 * Removes all the provisioning entries where provisioningType = &#63; from the database.
	 *
	 * @param provisioningType the provisioning type
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByType(String provisioningType) throws SystemException {
		for (ProvisioningEntry provisioningEntry : findByType(provisioningType)) {
			remove(provisioningEntry);
		}
	}

	/**
	 * Removes all the provisioning entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProvisioningEntry provisioningEntry : findAll()) {
			remove(provisioningEntry);
		}
	}

	/**
	 * Returns the number of provisioning entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching provisioning entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCode(String code) throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROVISIONINGENTRY_WHERE);

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
	 * Returns the number of provisioning entries where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @return the number of matching provisioning entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByType(String provisioningType) throws SystemException {
		Object[] finderArgs = new Object[] { provisioningType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROVISIONINGENTRY_WHERE);

			if (provisioningType == null) {
				query.append(_FINDER_COLUMN_TYPE_PROVISIONINGTYPE_1);
			}
			else {
				if (provisioningType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TYPE_PROVISIONINGTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TYPE_PROVISIONINGTYPE_2);
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
	 * Returns the number of provisioning entries.
	 *
	 * @return the number of provisioning entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROVISIONINGENTRY);

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
	 * Initializes the provisioning entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.ProvisioningEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProvisioningEntry>> listenersList = new ArrayList<ModelListener<ProvisioningEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProvisioningEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProvisioningEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_PROVISIONINGENTRY = "SELECT provisioningEntry FROM ProvisioningEntry provisioningEntry";
	private static final String _SQL_SELECT_PROVISIONINGENTRY_WHERE = "SELECT provisioningEntry FROM ProvisioningEntry provisioningEntry WHERE ";
	private static final String _SQL_COUNT_PROVISIONINGENTRY = "SELECT COUNT(provisioningEntry) FROM ProvisioningEntry provisioningEntry";
	private static final String _SQL_COUNT_PROVISIONINGENTRY_WHERE = "SELECT COUNT(provisioningEntry) FROM ProvisioningEntry provisioningEntry WHERE ";
	private static final String _FINDER_COLUMN_CODE_CODE_1 = "provisioningEntry.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "provisioningEntry.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(provisioningEntry.code IS NULL OR provisioningEntry.code = ?)";
	private static final String _FINDER_COLUMN_TYPE_PROVISIONINGTYPE_1 = "provisioningEntry.provisioningType IS NULL";
	private static final String _FINDER_COLUMN_TYPE_PROVISIONINGTYPE_2 = "provisioningEntry.provisioningType = ?";
	private static final String _FINDER_COLUMN_TYPE_PROVISIONINGTYPE_3 = "(provisioningEntry.provisioningType IS NULL OR provisioningEntry.provisioningType = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "provisioningEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProvisioningEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProvisioningEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProvisioningEntryPersistenceImpl.class);
	private static ProvisioningEntry _nullProvisioningEntry = new ProvisioningEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProvisioningEntry> toCacheModel() {
				return _nullProvisioningEntryCacheModel;
			}
		};

	private static CacheModel<ProvisioningEntry> _nullProvisioningEntryCacheModel =
		new CacheModel<ProvisioningEntry>() {
			public ProvisioningEntry toEntityModel() {
				return _nullProvisioningEntry;
			}
		};
}