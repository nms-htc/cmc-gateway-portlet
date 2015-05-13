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

import com.cmc.gateway.domain.NoSuchProvisioningActionException;
import com.cmc.gateway.domain.model.ProvisioningAction;
import com.cmc.gateway.domain.model.impl.ProvisioningActionImpl;
import com.cmc.gateway.domain.model.impl.ProvisioningActionModelImpl;

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
 * The persistence implementation for the provisioning action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningActionPersistence
 * @see ProvisioningActionUtil
 * @generated
 */
public class ProvisioningActionPersistenceImpl extends BasePersistenceImpl<ProvisioningAction>
	implements ProvisioningActionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProvisioningActionUtil} to access the provisioning action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProvisioningActionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROVISIONING =
		new FinderPath(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProvisioning",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING =
		new FinderPath(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProvisioning",
			new String[] { Long.class.getName() },
			ProvisioningActionModelImpl.PROVISIONINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROVISIONING = new FinderPath(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProvisioning",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMMAND = new FinderPath(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCommand",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMMAND =
		new FinderPath(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCommand",
			new String[] { Long.class.getName() },
			ProvisioningActionModelImpl.COMMANDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMMAND = new FinderPath(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCommand",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_P_C = new FinderPath(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningActionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByP_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProvisioningActionModelImpl.PROVISIONINGID_COLUMN_BITMASK |
			ProvisioningActionModelImpl.COMMANDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_P_C = new FinderPath(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_C",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the provisioning action in the entity cache if it is enabled.
	 *
	 * @param provisioningAction the provisioning action
	 */
	public void cacheResult(ProvisioningAction provisioningAction) {
		EntityCacheUtil.putResult(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionImpl.class, provisioningAction.getPrimaryKey(),
			provisioningAction);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_P_C,
			new Object[] {
				Long.valueOf(provisioningAction.getProvisioningId()),
				Long.valueOf(provisioningAction.getCommandId())
			}, provisioningAction);

		provisioningAction.resetOriginalValues();
	}

	/**
	 * Caches the provisioning actions in the entity cache if it is enabled.
	 *
	 * @param provisioningActions the provisioning actions
	 */
	public void cacheResult(List<ProvisioningAction> provisioningActions) {
		for (ProvisioningAction provisioningAction : provisioningActions) {
			if (EntityCacheUtil.getResult(
						ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
						ProvisioningActionImpl.class,
						provisioningAction.getPrimaryKey()) == null) {
				cacheResult(provisioningAction);
			}
			else {
				provisioningAction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all provisioning actions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProvisioningActionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProvisioningActionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the provisioning action.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProvisioningAction provisioningAction) {
		EntityCacheUtil.removeResult(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionImpl.class, provisioningAction.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(provisioningAction);
	}

	@Override
	public void clearCache(List<ProvisioningAction> provisioningActions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProvisioningAction provisioningAction : provisioningActions) {
			EntityCacheUtil.removeResult(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
				ProvisioningActionImpl.class, provisioningAction.getPrimaryKey());

			clearUniqueFindersCache(provisioningAction);
		}
	}

	protected void clearUniqueFindersCache(
		ProvisioningAction provisioningAction) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_P_C,
			new Object[] {
				Long.valueOf(provisioningAction.getProvisioningId()),
				Long.valueOf(provisioningAction.getCommandId())
			});
	}

	/**
	 * Creates a new provisioning action with the primary key. Does not add the provisioning action to the database.
	 *
	 * @param actionId the primary key for the new provisioning action
	 * @return the new provisioning action
	 */
	public ProvisioningAction create(long actionId) {
		ProvisioningAction provisioningAction = new ProvisioningActionImpl();

		provisioningAction.setNew(true);
		provisioningAction.setPrimaryKey(actionId);

		return provisioningAction;
	}

	/**
	 * Removes the provisioning action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionId the primary key of the provisioning action
	 * @return the provisioning action that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a provisioning action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction remove(long actionId)
		throws NoSuchProvisioningActionException, SystemException {
		return remove(Long.valueOf(actionId));
	}

	/**
	 * Removes the provisioning action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the provisioning action
	 * @return the provisioning action that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a provisioning action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningAction remove(Serializable primaryKey)
		throws NoSuchProvisioningActionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProvisioningAction provisioningAction = (ProvisioningAction)session.get(ProvisioningActionImpl.class,
					primaryKey);

			if (provisioningAction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProvisioningActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(provisioningAction);
		}
		catch (NoSuchProvisioningActionException nsee) {
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
	protected ProvisioningAction removeImpl(
		ProvisioningAction provisioningAction) throws SystemException {
		provisioningAction = toUnwrappedModel(provisioningAction);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, provisioningAction);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(provisioningAction);

		return provisioningAction;
	}

	@Override
	public ProvisioningAction updateImpl(
		com.cmc.gateway.domain.model.ProvisioningAction provisioningAction,
		boolean merge) throws SystemException {
		provisioningAction = toUnwrappedModel(provisioningAction);

		boolean isNew = provisioningAction.isNew();

		ProvisioningActionModelImpl provisioningActionModelImpl = (ProvisioningActionModelImpl)provisioningAction;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, provisioningAction, merge);

			provisioningAction.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProvisioningActionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((provisioningActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(provisioningActionModelImpl.getOriginalProvisioningId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROVISIONING,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING,
					args);

				args = new Object[] {
						Long.valueOf(provisioningActionModelImpl.getProvisioningId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROVISIONING,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING,
					args);
			}

			if ((provisioningActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMMAND.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(provisioningActionModelImpl.getOriginalCommandId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMMAND, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMMAND,
					args);

				args = new Object[] {
						Long.valueOf(provisioningActionModelImpl.getCommandId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMMAND, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMMAND,
					args);
			}
		}

		EntityCacheUtil.putResult(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningActionImpl.class, provisioningAction.getPrimaryKey(),
			provisioningAction);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_P_C,
				new Object[] {
					Long.valueOf(provisioningAction.getProvisioningId()),
					Long.valueOf(provisioningAction.getCommandId())
				}, provisioningAction);
		}
		else {
			if ((provisioningActionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_P_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(provisioningActionModelImpl.getOriginalProvisioningId()),
						Long.valueOf(provisioningActionModelImpl.getOriginalCommandId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_C, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_P_C, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_P_C,
					new Object[] {
						Long.valueOf(provisioningAction.getProvisioningId()),
						Long.valueOf(provisioningAction.getCommandId())
					}, provisioningAction);
			}
		}

		return provisioningAction;
	}

	protected ProvisioningAction toUnwrappedModel(
		ProvisioningAction provisioningAction) {
		if (provisioningAction instanceof ProvisioningActionImpl) {
			return provisioningAction;
		}

		ProvisioningActionImpl provisioningActionImpl = new ProvisioningActionImpl();

		provisioningActionImpl.setNew(provisioningAction.isNew());
		provisioningActionImpl.setPrimaryKey(provisioningAction.getPrimaryKey());

		provisioningActionImpl.setActionId(provisioningAction.getActionId());
		provisioningActionImpl.setGroupId(provisioningAction.getGroupId());
		provisioningActionImpl.setCompanyId(provisioningAction.getCompanyId());
		provisioningActionImpl.setUserId(provisioningAction.getUserId());
		provisioningActionImpl.setCreateDate(provisioningAction.getCreateDate());
		provisioningActionImpl.setModifiedDate(provisioningAction.getModifiedDate());
		provisioningActionImpl.setProvisioningId(provisioningAction.getProvisioningId());
		provisioningActionImpl.setCommandId(provisioningAction.getCommandId());
		provisioningActionImpl.setPriority(provisioningAction.getPriority());
		provisioningActionImpl.setTimeout(provisioningAction.getTimeout());
		provisioningActionImpl.setRetryEnable(provisioningAction.isRetryEnable());
		provisioningActionImpl.setMaxRetry(provisioningAction.getMaxRetry());
		provisioningActionImpl.setLogEnable(provisioningAction.isLogEnable());
		provisioningActionImpl.setProcessClass(provisioningAction.getProcessClass());
		provisioningActionImpl.setProcessMethod(provisioningAction.getProcessMethod());
		provisioningActionImpl.setProperties(provisioningAction.getProperties());
		provisioningActionImpl.setStatus(provisioningAction.getStatus());
		provisioningActionImpl.setDescription(provisioningAction.getDescription());

		return provisioningActionImpl;
	}

	/**
	 * Returns the provisioning action with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the provisioning action
	 * @return the provisioning action
	 * @throws com.liferay.portal.NoSuchModelException if a provisioning action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningAction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the provisioning action with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningActionException} if it could not be found.
	 *
	 * @param actionId the primary key of the provisioning action
	 * @return the provisioning action
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a provisioning action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction findByPrimaryKey(long actionId)
		throws NoSuchProvisioningActionException, SystemException {
		ProvisioningAction provisioningAction = fetchByPrimaryKey(actionId);

		if (provisioningAction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + actionId);
			}

			throw new NoSuchProvisioningActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				actionId);
		}

		return provisioningAction;
	}

	/**
	 * Returns the provisioning action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the provisioning action
	 * @return the provisioning action, or <code>null</code> if a provisioning action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningAction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the provisioning action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actionId the primary key of the provisioning action
	 * @return the provisioning action, or <code>null</code> if a provisioning action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction fetchByPrimaryKey(long actionId)
		throws SystemException {
		ProvisioningAction provisioningAction = (ProvisioningAction)EntityCacheUtil.getResult(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
				ProvisioningActionImpl.class, actionId);

		if (provisioningAction == _nullProvisioningAction) {
			return null;
		}

		if (provisioningAction == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				provisioningAction = (ProvisioningAction)session.get(ProvisioningActionImpl.class,
						Long.valueOf(actionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (provisioningAction != null) {
					cacheResult(provisioningAction);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProvisioningActionModelImpl.ENTITY_CACHE_ENABLED,
						ProvisioningActionImpl.class, actionId,
						_nullProvisioningAction);
				}

				closeSession(session);
			}
		}

		return provisioningAction;
	}

	/**
	 * Returns all the provisioning actions where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @return the matching provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningAction> findByProvisioning(long provisioningId)
		throws SystemException {
		return findByProvisioning(provisioningId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provisioning actions where provisioningId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningId the provisioning ID
	 * @param start the lower bound of the range of provisioning actions
	 * @param end the upper bound of the range of provisioning actions (not inclusive)
	 * @return the range of matching provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningAction> findByProvisioning(long provisioningId,
		int start, int end) throws SystemException {
		return findByProvisioning(provisioningId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the provisioning actions where provisioningId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningId the provisioning ID
	 * @param start the lower bound of the range of provisioning actions
	 * @param end the upper bound of the range of provisioning actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningAction> findByProvisioning(long provisioningId,
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

		List<ProvisioningAction> list = (List<ProvisioningAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProvisioningAction provisioningAction : list) {
				if ((provisioningId != provisioningAction.getProvisioningId())) {
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

			query.append(_SQL_SELECT_PROVISIONINGACTION_WHERE);

			query.append(_FINDER_COLUMN_PROVISIONING_PROVISIONINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProvisioningActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(provisioningId);

				list = (List<ProvisioningAction>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first provisioning action in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning action
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction findByProvisioning_First(long provisioningId,
		OrderByComparator orderByComparator)
		throws NoSuchProvisioningActionException, SystemException {
		ProvisioningAction provisioningAction = fetchByProvisioning_First(provisioningId,
				orderByComparator);

		if (provisioningAction != null) {
			return provisioningAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningId=");
		msg.append(provisioningId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningActionException(msg.toString());
	}

	/**
	 * Returns the first provisioning action in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction fetchByProvisioning_First(long provisioningId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProvisioningAction> list = findByProvisioning(provisioningId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last provisioning action in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning action
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction findByProvisioning_Last(long provisioningId,
		OrderByComparator orderByComparator)
		throws NoSuchProvisioningActionException, SystemException {
		ProvisioningAction provisioningAction = fetchByProvisioning_Last(provisioningId,
				orderByComparator);

		if (provisioningAction != null) {
			return provisioningAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningId=");
		msg.append(provisioningId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningActionException(msg.toString());
	}

	/**
	 * Returns the last provisioning action in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction fetchByProvisioning_Last(long provisioningId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProvisioning(provisioningId);

		List<ProvisioningAction> list = findByProvisioning(provisioningId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the provisioning actions before and after the current provisioning action in the ordered set where provisioningId = &#63;.
	 *
	 * @param actionId the primary key of the current provisioning action
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provisioning action
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a provisioning action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction[] findByProvisioning_PrevAndNext(long actionId,
		long provisioningId, OrderByComparator orderByComparator)
		throws NoSuchProvisioningActionException, SystemException {
		ProvisioningAction provisioningAction = findByPrimaryKey(actionId);

		Session session = null;

		try {
			session = openSession();

			ProvisioningAction[] array = new ProvisioningActionImpl[3];

			array[0] = getByProvisioning_PrevAndNext(session,
					provisioningAction, provisioningId, orderByComparator, true);

			array[1] = provisioningAction;

			array[2] = getByProvisioning_PrevAndNext(session,
					provisioningAction, provisioningId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProvisioningAction getByProvisioning_PrevAndNext(
		Session session, ProvisioningAction provisioningAction,
		long provisioningId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROVISIONINGACTION_WHERE);

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
			query.append(ProvisioningActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(provisioningId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(provisioningAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProvisioningAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the provisioning actions where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @return the matching provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningAction> findByCommand(long commandId)
		throws SystemException {
		return findByCommand(commandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the provisioning actions where commandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param commandId the command ID
	 * @param start the lower bound of the range of provisioning actions
	 * @param end the upper bound of the range of provisioning actions (not inclusive)
	 * @return the range of matching provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningAction> findByCommand(long commandId, int start,
		int end) throws SystemException {
		return findByCommand(commandId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the provisioning actions where commandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param commandId the command ID
	 * @param start the lower bound of the range of provisioning actions
	 * @param end the upper bound of the range of provisioning actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningAction> findByCommand(long commandId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMMAND;
			finderArgs = new Object[] { commandId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMMAND;
			finderArgs = new Object[] { commandId, start, end, orderByComparator };
		}

		List<ProvisioningAction> list = (List<ProvisioningAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProvisioningAction provisioningAction : list) {
				if ((commandId != provisioningAction.getCommandId())) {
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

			query.append(_SQL_SELECT_PROVISIONINGACTION_WHERE);

			query.append(_FINDER_COLUMN_COMMAND_COMMANDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProvisioningActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commandId);

				list = (List<ProvisioningAction>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first provisioning action in the ordered set where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning action
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction findByCommand_First(long commandId,
		OrderByComparator orderByComparator)
		throws NoSuchProvisioningActionException, SystemException {
		ProvisioningAction provisioningAction = fetchByCommand_First(commandId,
				orderByComparator);

		if (provisioningAction != null) {
			return provisioningAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commandId=");
		msg.append(commandId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningActionException(msg.toString());
	}

	/**
	 * Returns the first provisioning action in the ordered set where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction fetchByCommand_First(long commandId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProvisioningAction> list = findByCommand(commandId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last provisioning action in the ordered set where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning action
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction findByCommand_Last(long commandId,
		OrderByComparator orderByComparator)
		throws NoSuchProvisioningActionException, SystemException {
		ProvisioningAction provisioningAction = fetchByCommand_Last(commandId,
				orderByComparator);

		if (provisioningAction != null) {
			return provisioningAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commandId=");
		msg.append(commandId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningActionException(msg.toString());
	}

	/**
	 * Returns the last provisioning action in the ordered set where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction fetchByCommand_Last(long commandId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCommand(commandId);

		List<ProvisioningAction> list = findByCommand(commandId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the provisioning actions before and after the current provisioning action in the ordered set where commandId = &#63;.
	 *
	 * @param actionId the primary key of the current provisioning action
	 * @param commandId the command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provisioning action
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a provisioning action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction[] findByCommand_PrevAndNext(long actionId,
		long commandId, OrderByComparator orderByComparator)
		throws NoSuchProvisioningActionException, SystemException {
		ProvisioningAction provisioningAction = findByPrimaryKey(actionId);

		Session session = null;

		try {
			session = openSession();

			ProvisioningAction[] array = new ProvisioningActionImpl[3];

			array[0] = getByCommand_PrevAndNext(session, provisioningAction,
					commandId, orderByComparator, true);

			array[1] = provisioningAction;

			array[2] = getByCommand_PrevAndNext(session, provisioningAction,
					commandId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProvisioningAction getByCommand_PrevAndNext(Session session,
		ProvisioningAction provisioningAction, long commandId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROVISIONINGACTION_WHERE);

		query.append(_FINDER_COLUMN_COMMAND_COMMANDID_2);

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
			query.append(ProvisioningActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(commandId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(provisioningAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProvisioningAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the provisioning action where provisioningId = &#63; and commandId = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningActionException} if it could not be found.
	 *
	 * @param provisioningId the provisioning ID
	 * @param commandId the command ID
	 * @return the matching provisioning action
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningActionException if a matching provisioning action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction findByP_C(long provisioningId, long commandId)
		throws NoSuchProvisioningActionException, SystemException {
		ProvisioningAction provisioningAction = fetchByP_C(provisioningId,
				commandId);

		if (provisioningAction == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("provisioningId=");
			msg.append(provisioningId);

			msg.append(", commandId=");
			msg.append(commandId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProvisioningActionException(msg.toString());
		}

		return provisioningAction;
	}

	/**
	 * Returns the provisioning action where provisioningId = &#63; and commandId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param provisioningId the provisioning ID
	 * @param commandId the command ID
	 * @return the matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction fetchByP_C(long provisioningId, long commandId)
		throws SystemException {
		return fetchByP_C(provisioningId, commandId, true);
	}

	/**
	 * Returns the provisioning action where provisioningId = &#63; and commandId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param provisioningId the provisioning ID
	 * @param commandId the command ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching provisioning action, or <code>null</code> if a matching provisioning action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction fetchByP_C(long provisioningId, long commandId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { provisioningId, commandId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_P_C,
					finderArgs, this);
		}

		if (result instanceof ProvisioningAction) {
			ProvisioningAction provisioningAction = (ProvisioningAction)result;

			if ((provisioningId != provisioningAction.getProvisioningId()) ||
					(commandId != provisioningAction.getCommandId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROVISIONINGACTION_WHERE);

			query.append(_FINDER_COLUMN_P_C_PROVISIONINGID_2);

			query.append(_FINDER_COLUMN_P_C_COMMANDID_2);

			query.append(ProvisioningActionModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(provisioningId);

				qPos.add(commandId);

				List<ProvisioningAction> list = q.list();

				result = list;

				ProvisioningAction provisioningAction = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_P_C,
						finderArgs, list);
				}
				else {
					provisioningAction = list.get(0);

					cacheResult(provisioningAction);

					if ((provisioningAction.getProvisioningId() != provisioningId) ||
							(provisioningAction.getCommandId() != commandId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_P_C,
							finderArgs, provisioningAction);
					}
				}

				return provisioningAction;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_P_C,
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
				return (ProvisioningAction)result;
			}
		}
	}

	/**
	 * Returns all the provisioning actions.
	 *
	 * @return the provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningAction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provisioning actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of provisioning actions
	 * @param end the upper bound of the range of provisioning actions (not inclusive)
	 * @return the range of provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningAction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the provisioning actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of provisioning actions
	 * @param end the upper bound of the range of provisioning actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningAction> findAll(int start, int end,
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

		List<ProvisioningAction> list = (List<ProvisioningAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROVISIONINGACTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROVISIONINGACTION.concat(ProvisioningActionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProvisioningAction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProvisioningAction>)QueryUtil.list(q,
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
	 * Removes all the provisioning actions where provisioningId = &#63; from the database.
	 *
	 * @param provisioningId the provisioning ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByProvisioning(long provisioningId)
		throws SystemException {
		for (ProvisioningAction provisioningAction : findByProvisioning(
				provisioningId)) {
			remove(provisioningAction);
		}
	}

	/**
	 * Removes all the provisioning actions where commandId = &#63; from the database.
	 *
	 * @param commandId the command ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCommand(long commandId) throws SystemException {
		for (ProvisioningAction provisioningAction : findByCommand(commandId)) {
			remove(provisioningAction);
		}
	}

	/**
	 * Removes the provisioning action where provisioningId = &#63; and commandId = &#63; from the database.
	 *
	 * @param provisioningId the provisioning ID
	 * @param commandId the command ID
	 * @return the provisioning action that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningAction removeByP_C(long provisioningId, long commandId)
		throws NoSuchProvisioningActionException, SystemException {
		ProvisioningAction provisioningAction = findByP_C(provisioningId,
				commandId);

		return remove(provisioningAction);
	}

	/**
	 * Removes all the provisioning actions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProvisioningAction provisioningAction : findAll()) {
			remove(provisioningAction);
		}
	}

	/**
	 * Returns the number of provisioning actions where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @return the number of matching provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProvisioning(long provisioningId)
		throws SystemException {
		Object[] finderArgs = new Object[] { provisioningId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROVISIONING,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROVISIONINGACTION_WHERE);

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
	 * Returns the number of provisioning actions where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @return the number of matching provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCommand(long commandId) throws SystemException {
		Object[] finderArgs = new Object[] { commandId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMMAND,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROVISIONINGACTION_WHERE);

			query.append(_FINDER_COLUMN_COMMAND_COMMANDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commandId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMMAND,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of provisioning actions where provisioningId = &#63; and commandId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param commandId the command ID
	 * @return the number of matching provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByP_C(long provisioningId, long commandId)
		throws SystemException {
		Object[] finderArgs = new Object[] { provisioningId, commandId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_P_C,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROVISIONINGACTION_WHERE);

			query.append(_FINDER_COLUMN_P_C_PROVISIONINGID_2);

			query.append(_FINDER_COLUMN_P_C_COMMANDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(provisioningId);

				qPos.add(commandId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_P_C, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of provisioning actions.
	 *
	 * @return the number of provisioning actions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROVISIONINGACTION);

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
	 * Initializes the provisioning action persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.ProvisioningAction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProvisioningAction>> listenersList = new ArrayList<ModelListener<ProvisioningAction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProvisioningAction>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProvisioningActionImpl.class.getName());
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
	private static final String _SQL_SELECT_PROVISIONINGACTION = "SELECT provisioningAction FROM ProvisioningAction provisioningAction";
	private static final String _SQL_SELECT_PROVISIONINGACTION_WHERE = "SELECT provisioningAction FROM ProvisioningAction provisioningAction WHERE ";
	private static final String _SQL_COUNT_PROVISIONINGACTION = "SELECT COUNT(provisioningAction) FROM ProvisioningAction provisioningAction";
	private static final String _SQL_COUNT_PROVISIONINGACTION_WHERE = "SELECT COUNT(provisioningAction) FROM ProvisioningAction provisioningAction WHERE ";
	private static final String _FINDER_COLUMN_PROVISIONING_PROVISIONINGID_2 = "provisioningAction.provisioningId = ?";
	private static final String _FINDER_COLUMN_COMMAND_COMMANDID_2 = "provisioningAction.commandId = ?";
	private static final String _FINDER_COLUMN_P_C_PROVISIONINGID_2 = "provisioningAction.provisioningId = ? AND ";
	private static final String _FINDER_COLUMN_P_C_COMMANDID_2 = "provisioningAction.commandId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "provisioningAction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProvisioningAction exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProvisioningAction exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProvisioningActionPersistenceImpl.class);
	private static ProvisioningAction _nullProvisioningAction = new ProvisioningActionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProvisioningAction> toCacheModel() {
				return _nullProvisioningActionCacheModel;
			}
		};

	private static CacheModel<ProvisioningAction> _nullProvisioningActionCacheModel =
		new CacheModel<ProvisioningAction>() {
			public ProvisioningAction toEntityModel() {
				return _nullProvisioningAction;
			}
		};
}