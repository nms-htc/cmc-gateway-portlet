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

import com.cmc.gateway.domain.NoSuchCommandEntryException;
import com.cmc.gateway.domain.model.CommandEntry;
import com.cmc.gateway.domain.model.impl.CommandEntryImpl;
import com.cmc.gateway.domain.model.impl.CommandEntryModelImpl;

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
 * The persistence implementation for the command entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see CommandEntryPersistence
 * @see CommandEntryUtil
 * @generated
 */
public class CommandEntryPersistenceImpl extends BasePersistenceImpl<CommandEntry>
	implements CommandEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CommandEntryUtil} to access the command entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CommandEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
			CommandEntryModelImpl.FINDER_CACHE_ENABLED, CommandEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			CommandEntryModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
			CommandEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
			CommandEntryModelImpl.FINDER_CACHE_ENABLED, CommandEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
			CommandEntryModelImpl.FINDER_CACHE_ENABLED, CommandEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { String.class.getName() },
			CommandEntryModelImpl.PROVISIONINGTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
			CommandEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
			CommandEntryModelImpl.FINDER_CACHE_ENABLED, CommandEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
			CommandEntryModelImpl.FINDER_CACHE_ENABLED, CommandEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
			CommandEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the command entry in the entity cache if it is enabled.
	 *
	 * @param commandEntry the command entry
	 */
	public void cacheResult(CommandEntry commandEntry) {
		EntityCacheUtil.putResult(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
			CommandEntryImpl.class, commandEntry.getPrimaryKey(), commandEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { commandEntry.getCode() }, commandEntry);

		commandEntry.resetOriginalValues();
	}

	/**
	 * Caches the command entries in the entity cache if it is enabled.
	 *
	 * @param commandEntries the command entries
	 */
	public void cacheResult(List<CommandEntry> commandEntries) {
		for (CommandEntry commandEntry : commandEntries) {
			if (EntityCacheUtil.getResult(
						CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
						CommandEntryImpl.class, commandEntry.getPrimaryKey()) == null) {
				cacheResult(commandEntry);
			}
			else {
				commandEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all command entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CommandEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CommandEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the command entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CommandEntry commandEntry) {
		EntityCacheUtil.removeResult(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
			CommandEntryImpl.class, commandEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(commandEntry);
	}

	@Override
	public void clearCache(List<CommandEntry> commandEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommandEntry commandEntry : commandEntries) {
			EntityCacheUtil.removeResult(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
				CommandEntryImpl.class, commandEntry.getPrimaryKey());

			clearUniqueFindersCache(commandEntry);
		}
	}

	protected void clearUniqueFindersCache(CommandEntry commandEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { commandEntry.getCode() });
	}

	/**
	 * Creates a new command entry with the primary key. Does not add the command entry to the database.
	 *
	 * @param commandId the primary key for the new command entry
	 * @return the new command entry
	 */
	public CommandEntry create(long commandId) {
		CommandEntry commandEntry = new CommandEntryImpl();

		commandEntry.setNew(true);
		commandEntry.setPrimaryKey(commandId);

		return commandEntry;
	}

	/**
	 * Removes the command entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commandId the primary key of the command entry
	 * @return the command entry that was removed
	 * @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a command entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry remove(long commandId)
		throws NoSuchCommandEntryException, SystemException {
		return remove(Long.valueOf(commandId));
	}

	/**
	 * Removes the command entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the command entry
	 * @return the command entry that was removed
	 * @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a command entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommandEntry remove(Serializable primaryKey)
		throws NoSuchCommandEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CommandEntry commandEntry = (CommandEntry)session.get(CommandEntryImpl.class,
					primaryKey);

			if (commandEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommandEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(commandEntry);
		}
		catch (NoSuchCommandEntryException nsee) {
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
	protected CommandEntry removeImpl(CommandEntry commandEntry)
		throws SystemException {
		commandEntry = toUnwrappedModel(commandEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, commandEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(commandEntry);

		return commandEntry;
	}

	@Override
	public CommandEntry updateImpl(
		com.cmc.gateway.domain.model.CommandEntry commandEntry, boolean merge)
		throws SystemException {
		commandEntry = toUnwrappedModel(commandEntry);

		boolean isNew = commandEntry.isNew();

		CommandEntryModelImpl commandEntryModelImpl = (CommandEntryModelImpl)commandEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, commandEntry, merge);

			commandEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CommandEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((commandEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						commandEntryModelImpl.getOriginalProvisioningType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { commandEntryModelImpl.getProvisioningType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
			CommandEntryImpl.class, commandEntry.getPrimaryKey(), commandEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
				new Object[] { commandEntry.getCode() }, commandEntry);
		}
		else {
			if ((commandEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						commandEntryModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
					new Object[] { commandEntry.getCode() }, commandEntry);
			}
		}

		return commandEntry;
	}

	protected CommandEntry toUnwrappedModel(CommandEntry commandEntry) {
		if (commandEntry instanceof CommandEntryImpl) {
			return commandEntry;
		}

		CommandEntryImpl commandEntryImpl = new CommandEntryImpl();

		commandEntryImpl.setNew(commandEntry.isNew());
		commandEntryImpl.setPrimaryKey(commandEntry.getPrimaryKey());

		commandEntryImpl.setCommandId(commandEntry.getCommandId());
		commandEntryImpl.setGroupId(commandEntry.getGroupId());
		commandEntryImpl.setCompanyId(commandEntry.getCompanyId());
		commandEntryImpl.setUserId(commandEntry.getUserId());
		commandEntryImpl.setCreateDate(commandEntry.getCreateDate());
		commandEntryImpl.setModifiedDate(commandEntry.getModifiedDate());
		commandEntryImpl.setProvisioningType(commandEntry.getProvisioningType());
		commandEntryImpl.setCode(commandEntry.getCode());
		commandEntryImpl.setTitle(commandEntry.getTitle());
		commandEntryImpl.setPriority(commandEntry.getPriority());
		commandEntryImpl.setTimeout(commandEntry.getTimeout());
		commandEntryImpl.setRetryEnable(commandEntry.isRetryEnable());
		commandEntryImpl.setMaxRetry(commandEntry.getMaxRetry());
		commandEntryImpl.setLogEnable(commandEntry.isLogEnable());
		commandEntryImpl.setProperties(commandEntry.getProperties());
		commandEntryImpl.setStatus(commandEntry.getStatus());
		commandEntryImpl.setDescription(commandEntry.getDescription());

		return commandEntryImpl;
	}

	/**
	 * Returns the command entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the command entry
	 * @return the command entry
	 * @throws com.liferay.portal.NoSuchModelException if a command entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommandEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the command entry with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchCommandEntryException} if it could not be found.
	 *
	 * @param commandId the primary key of the command entry
	 * @return the command entry
	 * @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a command entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry findByPrimaryKey(long commandId)
		throws NoSuchCommandEntryException, SystemException {
		CommandEntry commandEntry = fetchByPrimaryKey(commandId);

		if (commandEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + commandId);
			}

			throw new NoSuchCommandEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				commandId);
		}

		return commandEntry;
	}

	/**
	 * Returns the command entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the command entry
	 * @return the command entry, or <code>null</code> if a command entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommandEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the command entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commandId the primary key of the command entry
	 * @return the command entry, or <code>null</code> if a command entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry fetchByPrimaryKey(long commandId)
		throws SystemException {
		CommandEntry commandEntry = (CommandEntry)EntityCacheUtil.getResult(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
				CommandEntryImpl.class, commandId);

		if (commandEntry == _nullCommandEntry) {
			return null;
		}

		if (commandEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				commandEntry = (CommandEntry)session.get(CommandEntryImpl.class,
						Long.valueOf(commandId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (commandEntry != null) {
					cacheResult(commandEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CommandEntryModelImpl.ENTITY_CACHE_ENABLED,
						CommandEntryImpl.class, commandId, _nullCommandEntry);
				}

				closeSession(session);
			}
		}

		return commandEntry;
	}

	/**
	 * Returns the command entry where code = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchCommandEntryException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching command entry
	 * @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a matching command entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry findByCode(String code)
		throws NoSuchCommandEntryException, SystemException {
		CommandEntry commandEntry = fetchByCode(code);

		if (commandEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCommandEntryException(msg.toString());
		}

		return commandEntry;
	}

	/**
	 * Returns the command entry where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching command entry, or <code>null</code> if a matching command entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the command entry where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching command entry, or <code>null</code> if a matching command entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof CommandEntry) {
			CommandEntry commandEntry = (CommandEntry)result;

			if (!Validator.equals(code, commandEntry.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COMMANDENTRY_WHERE);

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

			query.append(CommandEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (code != null) {
					qPos.add(code);
				}

				List<CommandEntry> list = q.list();

				result = list;

				CommandEntry commandEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					commandEntry = list.get(0);

					cacheResult(commandEntry);

					if ((commandEntry.getCode() == null) ||
							!commandEntry.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, commandEntry);
					}
				}

				return commandEntry;
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
				return (CommandEntry)result;
			}
		}
	}

	/**
	 * Returns all the command entries where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @return the matching command entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandEntry> findByType(String provisioningType)
		throws SystemException {
		return findByType(provisioningType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the command entries where provisioningType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningType the provisioning type
	 * @param start the lower bound of the range of command entries
	 * @param end the upper bound of the range of command entries (not inclusive)
	 * @return the range of matching command entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandEntry> findByType(String provisioningType, int start,
		int end) throws SystemException {
		return findByType(provisioningType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the command entries where provisioningType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningType the provisioning type
	 * @param start the lower bound of the range of command entries
	 * @param end the upper bound of the range of command entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching command entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandEntry> findByType(String provisioningType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<CommandEntry> list = (List<CommandEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CommandEntry commandEntry : list) {
				if (!Validator.equals(provisioningType,
							commandEntry.getProvisioningType())) {
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

			query.append(_SQL_SELECT_COMMANDENTRY_WHERE);

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
				query.append(CommandEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommandEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first command entry in the ordered set where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching command entry
	 * @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a matching command entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry findByType_First(String provisioningType,
		OrderByComparator orderByComparator)
		throws NoSuchCommandEntryException, SystemException {
		CommandEntry commandEntry = fetchByType_First(provisioningType,
				orderByComparator);

		if (commandEntry != null) {
			return commandEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningType=");
		msg.append(provisioningType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommandEntryException(msg.toString());
	}

	/**
	 * Returns the first command entry in the ordered set where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching command entry, or <code>null</code> if a matching command entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry fetchByType_First(String provisioningType,
		OrderByComparator orderByComparator) throws SystemException {
		List<CommandEntry> list = findByType(provisioningType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last command entry in the ordered set where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching command entry
	 * @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a matching command entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry findByType_Last(String provisioningType,
		OrderByComparator orderByComparator)
		throws NoSuchCommandEntryException, SystemException {
		CommandEntry commandEntry = fetchByType_Last(provisioningType,
				orderByComparator);

		if (commandEntry != null) {
			return commandEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningType=");
		msg.append(provisioningType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommandEntryException(msg.toString());
	}

	/**
	 * Returns the last command entry in the ordered set where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching command entry, or <code>null</code> if a matching command entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry fetchByType_Last(String provisioningType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(provisioningType);

		List<CommandEntry> list = findByType(provisioningType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the command entries before and after the current command entry in the ordered set where provisioningType = &#63;.
	 *
	 * @param commandId the primary key of the current command entry
	 * @param provisioningType the provisioning type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next command entry
	 * @throws com.cmc.gateway.domain.NoSuchCommandEntryException if a command entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry[] findByType_PrevAndNext(long commandId,
		String provisioningType, OrderByComparator orderByComparator)
		throws NoSuchCommandEntryException, SystemException {
		CommandEntry commandEntry = findByPrimaryKey(commandId);

		Session session = null;

		try {
			session = openSession();

			CommandEntry[] array = new CommandEntryImpl[3];

			array[0] = getByType_PrevAndNext(session, commandEntry,
					provisioningType, orderByComparator, true);

			array[1] = commandEntry;

			array[2] = getByType_PrevAndNext(session, commandEntry,
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

	protected CommandEntry getByType_PrevAndNext(Session session,
		CommandEntry commandEntry, String provisioningType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMANDENTRY_WHERE);

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
			query.append(CommandEntryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(commandEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CommandEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the command entries.
	 *
	 * @return the command entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the command entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of command entries
	 * @param end the upper bound of the range of command entries (not inclusive)
	 * @return the range of command entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the command entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of command entries
	 * @param end the upper bound of the range of command entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of command entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandEntry> findAll(int start, int end,
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

		List<CommandEntry> list = (List<CommandEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMMANDENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMANDENTRY.concat(CommandEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CommandEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CommandEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes the command entry where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the command entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public CommandEntry removeByCode(String code)
		throws NoSuchCommandEntryException, SystemException {
		CommandEntry commandEntry = findByCode(code);

		return remove(commandEntry);
	}

	/**
	 * Removes all the command entries where provisioningType = &#63; from the database.
	 *
	 * @param provisioningType the provisioning type
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByType(String provisioningType) throws SystemException {
		for (CommandEntry commandEntry : findByType(provisioningType)) {
			remove(commandEntry);
		}
	}

	/**
	 * Removes all the command entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CommandEntry commandEntry : findAll()) {
			remove(commandEntry);
		}
	}

	/**
	 * Returns the number of command entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching command entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCode(String code) throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMANDENTRY_WHERE);

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
	 * Returns the number of command entries where provisioningType = &#63;.
	 *
	 * @param provisioningType the provisioning type
	 * @return the number of matching command entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByType(String provisioningType) throws SystemException {
		Object[] finderArgs = new Object[] { provisioningType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMANDENTRY_WHERE);

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
	 * Returns the number of command entries.
	 *
	 * @return the number of command entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMMANDENTRY);

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
	 * Initializes the command entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.CommandEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CommandEntry>> listenersList = new ArrayList<ModelListener<CommandEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CommandEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CommandEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_COMMANDENTRY = "SELECT commandEntry FROM CommandEntry commandEntry";
	private static final String _SQL_SELECT_COMMANDENTRY_WHERE = "SELECT commandEntry FROM CommandEntry commandEntry WHERE ";
	private static final String _SQL_COUNT_COMMANDENTRY = "SELECT COUNT(commandEntry) FROM CommandEntry commandEntry";
	private static final String _SQL_COUNT_COMMANDENTRY_WHERE = "SELECT COUNT(commandEntry) FROM CommandEntry commandEntry WHERE ";
	private static final String _FINDER_COLUMN_CODE_CODE_1 = "commandEntry.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "commandEntry.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(commandEntry.code IS NULL OR commandEntry.code = ?)";
	private static final String _FINDER_COLUMN_TYPE_PROVISIONINGTYPE_1 = "commandEntry.provisioningType IS NULL";
	private static final String _FINDER_COLUMN_TYPE_PROVISIONINGTYPE_2 = "commandEntry.provisioningType = ?";
	private static final String _FINDER_COLUMN_TYPE_PROVISIONINGTYPE_3 = "(commandEntry.provisioningType IS NULL OR commandEntry.provisioningType = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "commandEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CommandEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CommandEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CommandEntryPersistenceImpl.class);
	private static CommandEntry _nullCommandEntry = new CommandEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CommandEntry> toCacheModel() {
				return _nullCommandEntryCacheModel;
			}
		};

	private static CacheModel<CommandEntry> _nullCommandEntryCacheModel = new CacheModel<CommandEntry>() {
			public CommandEntry toEntityModel() {
				return _nullCommandEntry;
			}
		};
}