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

import com.cmc.gateway.domain.NoSuchCommandActionException;
import com.cmc.gateway.domain.model.CommandAction;
import com.cmc.gateway.domain.model.impl.CommandActionImpl;
import com.cmc.gateway.domain.model.impl.CommandActionModelImpl;

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
 * The persistence implementation for the command action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see CommandActionPersistence
 * @see CommandActionUtil
 * @generated
 */
public class CommandActionPersistenceImpl extends BasePersistenceImpl<CommandAction>
	implements CommandActionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CommandActionUtil} to access the command action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CommandActionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMMAND = new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED,
			CommandActionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCommand",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMMAND =
		new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED,
			CommandActionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCommand", new String[] { Long.class.getName() },
			CommandActionModelImpl.COMMANDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMMAND = new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCommand",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCT = new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED,
			CommandActionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProduct",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT =
		new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED,
			CommandActionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProduct", new String[] { Long.class.getName() },
			CommandActionModelImpl.PRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCT = new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProduct",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NEXTCOMMAND =
		new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED,
			CommandActionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNextCommand",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEXTCOMMAND =
		new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED,
			CommandActionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNextCommand", new String[] { Long.class.getName() },
			CommandActionModelImpl.NEXTCOMMANDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NEXTCOMMAND = new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNextCommand",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NEXTACTION =
		new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED,
			CommandActionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNextAction",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEXTACTION =
		new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED,
			CommandActionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNextAction",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			CommandActionModelImpl.COMMANDID_COLUMN_BITMASK |
			CommandActionModelImpl.PRODUCTID_COLUMN_BITMASK |
			CommandActionModelImpl.ACTIONTYPE_COLUMN_BITMASK |
			CommandActionModelImpl.SUBSCRIBERTYPE_COLUMN_BITMASK |
			CommandActionModelImpl.ACTIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NEXTACTION = new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNextAction",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED,
			CommandActionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED,
			CommandActionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the command action in the entity cache if it is enabled.
	 *
	 * @param commandAction the command action
	 */
	public void cacheResult(CommandAction commandAction) {
		EntityCacheUtil.putResult(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionImpl.class, commandAction.getPrimaryKey(),
			commandAction);

		commandAction.resetOriginalValues();
	}

	/**
	 * Caches the command actions in the entity cache if it is enabled.
	 *
	 * @param commandActions the command actions
	 */
	public void cacheResult(List<CommandAction> commandActions) {
		for (CommandAction commandAction : commandActions) {
			if (EntityCacheUtil.getResult(
						CommandActionModelImpl.ENTITY_CACHE_ENABLED,
						CommandActionImpl.class, commandAction.getPrimaryKey()) == null) {
				cacheResult(commandAction);
			}
			else {
				commandAction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all command actions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CommandActionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CommandActionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the command action.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CommandAction commandAction) {
		EntityCacheUtil.removeResult(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionImpl.class, commandAction.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CommandAction> commandActions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommandAction commandAction : commandActions) {
			EntityCacheUtil.removeResult(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
				CommandActionImpl.class, commandAction.getPrimaryKey());
		}
	}

	/**
	 * Creates a new command action with the primary key. Does not add the command action to the database.
	 *
	 * @param actionId the primary key for the new command action
	 * @return the new command action
	 */
	public CommandAction create(long actionId) {
		CommandAction commandAction = new CommandActionImpl();

		commandAction.setNew(true);
		commandAction.setPrimaryKey(actionId);

		return commandAction;
	}

	/**
	 * Removes the command action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionId the primary key of the command action
	 * @return the command action that was removed
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction remove(long actionId)
		throws NoSuchCommandActionException, SystemException {
		return remove(Long.valueOf(actionId));
	}

	/**
	 * Removes the command action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the command action
	 * @return the command action that was removed
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommandAction remove(Serializable primaryKey)
		throws NoSuchCommandActionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CommandAction commandAction = (CommandAction)session.get(CommandActionImpl.class,
					primaryKey);

			if (commandAction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommandActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(commandAction);
		}
		catch (NoSuchCommandActionException nsee) {
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
	protected CommandAction removeImpl(CommandAction commandAction)
		throws SystemException {
		commandAction = toUnwrappedModel(commandAction);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, commandAction);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(commandAction);

		return commandAction;
	}

	@Override
	public CommandAction updateImpl(
		com.cmc.gateway.domain.model.CommandAction commandAction, boolean merge)
		throws SystemException {
		commandAction = toUnwrappedModel(commandAction);

		boolean isNew = commandAction.isNew();

		CommandActionModelImpl commandActionModelImpl = (CommandActionModelImpl)commandAction;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, commandAction, merge);

			commandAction.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CommandActionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((commandActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMMAND.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(commandActionModelImpl.getOriginalCommandId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMMAND, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMMAND,
					args);

				args = new Object[] {
						Long.valueOf(commandActionModelImpl.getCommandId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMMAND, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMMAND,
					args);
			}

			if ((commandActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(commandActionModelImpl.getOriginalProductId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT,
					args);

				args = new Object[] {
						Long.valueOf(commandActionModelImpl.getProductId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT,
					args);
			}

			if ((commandActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEXTCOMMAND.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(commandActionModelImpl.getOriginalNextCommandId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NEXTCOMMAND,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEXTCOMMAND,
					args);

				args = new Object[] {
						Long.valueOf(commandActionModelImpl.getNextCommandId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NEXTCOMMAND,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEXTCOMMAND,
					args);
			}

			if ((commandActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEXTACTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(commandActionModelImpl.getOriginalCommandId()),
						Long.valueOf(commandActionModelImpl.getOriginalProductId()),
						
						commandActionModelImpl.getOriginalActionType(),
						Integer.valueOf(commandActionModelImpl.getOriginalSubscriberType()),
						
						commandActionModelImpl.getOriginalActionName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NEXTACTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEXTACTION,
					args);

				args = new Object[] {
						Long.valueOf(commandActionModelImpl.getCommandId()),
						Long.valueOf(commandActionModelImpl.getProductId()),
						
						commandActionModelImpl.getActionType(),
						Integer.valueOf(commandActionModelImpl.getSubscriberType()),
						
						commandActionModelImpl.getActionName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NEXTACTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEXTACTION,
					args);
			}
		}

		EntityCacheUtil.putResult(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
			CommandActionImpl.class, commandAction.getPrimaryKey(),
			commandAction);

		return commandAction;
	}

	protected CommandAction toUnwrappedModel(CommandAction commandAction) {
		if (commandAction instanceof CommandActionImpl) {
			return commandAction;
		}

		CommandActionImpl commandActionImpl = new CommandActionImpl();

		commandActionImpl.setNew(commandAction.isNew());
		commandActionImpl.setPrimaryKey(commandAction.getPrimaryKey());

		commandActionImpl.setActionId(commandAction.getActionId());
		commandActionImpl.setGroupId(commandAction.getGroupId());
		commandActionImpl.setCompanyId(commandAction.getCompanyId());
		commandActionImpl.setUserId(commandAction.getUserId());
		commandActionImpl.setCreateDate(commandAction.getCreateDate());
		commandActionImpl.setModifiedDate(commandAction.getModifiedDate());
		commandActionImpl.setCommandId(commandAction.getCommandId());
		commandActionImpl.setProductId(commandAction.getProductId());
		commandActionImpl.setActionType(commandAction.getActionType());
		commandActionImpl.setSubscriberType(commandAction.getSubscriberType());
		commandActionImpl.setActionName(commandAction.getActionName());
		commandActionImpl.setNextActionType(commandAction.getNextActionType());
		commandActionImpl.setNextCommandId(commandAction.getNextCommandId());
		commandActionImpl.setProcessClass(commandAction.getProcessClass());
		commandActionImpl.setProcessMethod(commandAction.getProcessMethod());
		commandActionImpl.setProperties(commandAction.getProperties());
		commandActionImpl.setDescription(commandAction.getDescription());

		return commandActionImpl;
	}

	/**
	 * Returns the command action with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the command action
	 * @return the command action
	 * @throws com.liferay.portal.NoSuchModelException if a command action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommandAction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the command action with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchCommandActionException} if it could not be found.
	 *
	 * @param actionId the primary key of the command action
	 * @return the command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction findByPrimaryKey(long actionId)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = fetchByPrimaryKey(actionId);

		if (commandAction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + actionId);
			}

			throw new NoSuchCommandActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				actionId);
		}

		return commandAction;
	}

	/**
	 * Returns the command action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the command action
	 * @return the command action, or <code>null</code> if a command action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommandAction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the command action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actionId the primary key of the command action
	 * @return the command action, or <code>null</code> if a command action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction fetchByPrimaryKey(long actionId)
		throws SystemException {
		CommandAction commandAction = (CommandAction)EntityCacheUtil.getResult(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
				CommandActionImpl.class, actionId);

		if (commandAction == _nullCommandAction) {
			return null;
		}

		if (commandAction == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				commandAction = (CommandAction)session.get(CommandActionImpl.class,
						Long.valueOf(actionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (commandAction != null) {
					cacheResult(commandAction);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CommandActionModelImpl.ENTITY_CACHE_ENABLED,
						CommandActionImpl.class, actionId, _nullCommandAction);
				}

				closeSession(session);
			}
		}

		return commandAction;
	}

	/**
	 * Returns all the command actions where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @return the matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByCommand(long commandId)
		throws SystemException {
		return findByCommand(commandId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the command actions where commandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param commandId the command ID
	 * @param start the lower bound of the range of command actions
	 * @param end the upper bound of the range of command actions (not inclusive)
	 * @return the range of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByCommand(long commandId, int start, int end)
		throws SystemException {
		return findByCommand(commandId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the command actions where commandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param commandId the command ID
	 * @param start the lower bound of the range of command actions
	 * @param end the upper bound of the range of command actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByCommand(long commandId, int start,
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

		List<CommandAction> list = (List<CommandAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CommandAction commandAction : list) {
				if ((commandId != commandAction.getCommandId())) {
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

			query.append(_SQL_SELECT_COMMANDACTION_WHERE);

			query.append(_FINDER_COLUMN_COMMAND_COMMANDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CommandActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commandId);

				list = (List<CommandAction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first command action in the ordered set where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction findByCommand_First(long commandId,
		OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = fetchByCommand_First(commandId,
				orderByComparator);

		if (commandAction != null) {
			return commandAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commandId=");
		msg.append(commandId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommandActionException(msg.toString());
	}

	/**
	 * Returns the first command action in the ordered set where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching command action, or <code>null</code> if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction fetchByCommand_First(long commandId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CommandAction> list = findByCommand(commandId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last command action in the ordered set where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction findByCommand_Last(long commandId,
		OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = fetchByCommand_Last(commandId,
				orderByComparator);

		if (commandAction != null) {
			return commandAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commandId=");
		msg.append(commandId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommandActionException(msg.toString());
	}

	/**
	 * Returns the last command action in the ordered set where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching command action, or <code>null</code> if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction fetchByCommand_Last(long commandId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCommand(commandId);

		List<CommandAction> list = findByCommand(commandId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the command actions before and after the current command action in the ordered set where commandId = &#63;.
	 *
	 * @param actionId the primary key of the current command action
	 * @param commandId the command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction[] findByCommand_PrevAndNext(long actionId,
		long commandId, OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = findByPrimaryKey(actionId);

		Session session = null;

		try {
			session = openSession();

			CommandAction[] array = new CommandActionImpl[3];

			array[0] = getByCommand_PrevAndNext(session, commandAction,
					commandId, orderByComparator, true);

			array[1] = commandAction;

			array[2] = getByCommand_PrevAndNext(session, commandAction,
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

	protected CommandAction getByCommand_PrevAndNext(Session session,
		CommandAction commandAction, long commandId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMANDACTION_WHERE);

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
			query.append(CommandActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(commandId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(commandAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CommandAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the command actions where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByProduct(long productId)
		throws SystemException {
		return findByProduct(productId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the command actions where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of command actions
	 * @param end the upper bound of the range of command actions (not inclusive)
	 * @return the range of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByProduct(long productId, int start, int end)
		throws SystemException {
		return findByProduct(productId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the command actions where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of command actions
	 * @param end the upper bound of the range of command actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByProduct(long productId, int start,
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

		List<CommandAction> list = (List<CommandAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CommandAction commandAction : list) {
				if ((productId != commandAction.getProductId())) {
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

			query.append(_SQL_SELECT_COMMANDACTION_WHERE);

			query.append(_FINDER_COLUMN_PRODUCT_PRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CommandActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				list = (List<CommandAction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first command action in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction findByProduct_First(long productId,
		OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = fetchByProduct_First(productId,
				orderByComparator);

		if (commandAction != null) {
			return commandAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommandActionException(msg.toString());
	}

	/**
	 * Returns the first command action in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching command action, or <code>null</code> if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction fetchByProduct_First(long productId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CommandAction> list = findByProduct(productId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last command action in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction findByProduct_Last(long productId,
		OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = fetchByProduct_Last(productId,
				orderByComparator);

		if (commandAction != null) {
			return commandAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommandActionException(msg.toString());
	}

	/**
	 * Returns the last command action in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching command action, or <code>null</code> if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction fetchByProduct_Last(long productId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProduct(productId);

		List<CommandAction> list = findByProduct(productId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the command actions before and after the current command action in the ordered set where productId = &#63;.
	 *
	 * @param actionId the primary key of the current command action
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction[] findByProduct_PrevAndNext(long actionId,
		long productId, OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = findByPrimaryKey(actionId);

		Session session = null;

		try {
			session = openSession();

			CommandAction[] array = new CommandActionImpl[3];

			array[0] = getByProduct_PrevAndNext(session, commandAction,
					productId, orderByComparator, true);

			array[1] = commandAction;

			array[2] = getByProduct_PrevAndNext(session, commandAction,
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

	protected CommandAction getByProduct_PrevAndNext(Session session,
		CommandAction commandAction, long productId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMANDACTION_WHERE);

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
			query.append(CommandActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(productId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(commandAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CommandAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the command actions where nextCommandId = &#63;.
	 *
	 * @param nextCommandId the next command ID
	 * @return the matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByNextCommand(long nextCommandId)
		throws SystemException {
		return findByNextCommand(nextCommandId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the command actions where nextCommandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nextCommandId the next command ID
	 * @param start the lower bound of the range of command actions
	 * @param end the upper bound of the range of command actions (not inclusive)
	 * @return the range of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByNextCommand(long nextCommandId, int start,
		int end) throws SystemException {
		return findByNextCommand(nextCommandId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the command actions where nextCommandId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param nextCommandId the next command ID
	 * @param start the lower bound of the range of command actions
	 * @param end the upper bound of the range of command actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByNextCommand(long nextCommandId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEXTCOMMAND;
			finderArgs = new Object[] { nextCommandId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NEXTCOMMAND;
			finderArgs = new Object[] {
					nextCommandId,
					
					start, end, orderByComparator
				};
		}

		List<CommandAction> list = (List<CommandAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CommandAction commandAction : list) {
				if ((nextCommandId != commandAction.getNextCommandId())) {
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

			query.append(_SQL_SELECT_COMMANDACTION_WHERE);

			query.append(_FINDER_COLUMN_NEXTCOMMAND_NEXTCOMMANDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CommandActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nextCommandId);

				list = (List<CommandAction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first command action in the ordered set where nextCommandId = &#63;.
	 *
	 * @param nextCommandId the next command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction findByNextCommand_First(long nextCommandId,
		OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = fetchByNextCommand_First(nextCommandId,
				orderByComparator);

		if (commandAction != null) {
			return commandAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nextCommandId=");
		msg.append(nextCommandId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommandActionException(msg.toString());
	}

	/**
	 * Returns the first command action in the ordered set where nextCommandId = &#63;.
	 *
	 * @param nextCommandId the next command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching command action, or <code>null</code> if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction fetchByNextCommand_First(long nextCommandId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CommandAction> list = findByNextCommand(nextCommandId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last command action in the ordered set where nextCommandId = &#63;.
	 *
	 * @param nextCommandId the next command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction findByNextCommand_Last(long nextCommandId,
		OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = fetchByNextCommand_Last(nextCommandId,
				orderByComparator);

		if (commandAction != null) {
			return commandAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nextCommandId=");
		msg.append(nextCommandId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommandActionException(msg.toString());
	}

	/**
	 * Returns the last command action in the ordered set where nextCommandId = &#63;.
	 *
	 * @param nextCommandId the next command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching command action, or <code>null</code> if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction fetchByNextCommand_Last(long nextCommandId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNextCommand(nextCommandId);

		List<CommandAction> list = findByNextCommand(nextCommandId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the command actions before and after the current command action in the ordered set where nextCommandId = &#63;.
	 *
	 * @param actionId the primary key of the current command action
	 * @param nextCommandId the next command ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction[] findByNextCommand_PrevAndNext(long actionId,
		long nextCommandId, OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = findByPrimaryKey(actionId);

		Session session = null;

		try {
			session = openSession();

			CommandAction[] array = new CommandActionImpl[3];

			array[0] = getByNextCommand_PrevAndNext(session, commandAction,
					nextCommandId, orderByComparator, true);

			array[1] = commandAction;

			array[2] = getByNextCommand_PrevAndNext(session, commandAction,
					nextCommandId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommandAction getByNextCommand_PrevAndNext(Session session,
		CommandAction commandAction, long nextCommandId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMANDACTION_WHERE);

		query.append(_FINDER_COLUMN_NEXTCOMMAND_NEXTCOMMANDID_2);

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
			query.append(CommandActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nextCommandId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(commandAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CommandAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the command actions where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	 *
	 * @param commandId the command ID
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param subscriberType the subscriber type
	 * @param actionName the action name
	 * @return the matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByNextAction(long commandId, long productId,
		String actionType, int subscriberType, String actionName)
		throws SystemException {
		return findByNextAction(commandId, productId, actionType,
			subscriberType, actionName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the command actions where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param commandId the command ID
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param subscriberType the subscriber type
	 * @param actionName the action name
	 * @param start the lower bound of the range of command actions
	 * @param end the upper bound of the range of command actions (not inclusive)
	 * @return the range of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByNextAction(long commandId, long productId,
		String actionType, int subscriberType, String actionName, int start,
		int end) throws SystemException {
		return findByNextAction(commandId, productId, actionType,
			subscriberType, actionName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the command actions where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param commandId the command ID
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param subscriberType the subscriber type
	 * @param actionName the action name
	 * @param start the lower bound of the range of command actions
	 * @param end the upper bound of the range of command actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findByNextAction(long commandId, long productId,
		String actionType, int subscriberType, String actionName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEXTACTION;
			finderArgs = new Object[] {
					commandId, productId, actionType, subscriberType, actionName
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NEXTACTION;
			finderArgs = new Object[] {
					commandId, productId, actionType, subscriberType, actionName,
					
					start, end, orderByComparator
				};
		}

		List<CommandAction> list = (List<CommandAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CommandAction commandAction : list) {
				if ((commandId != commandAction.getCommandId()) ||
						(productId != commandAction.getProductId()) ||
						!Validator.equals(actionType,
							commandAction.getActionType()) ||
						(subscriberType != commandAction.getSubscriberType()) ||
						!Validator.equals(actionName,
							commandAction.getActionName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_COMMANDACTION_WHERE);

			query.append(_FINDER_COLUMN_NEXTACTION_COMMANDID_2);

			query.append(_FINDER_COLUMN_NEXTACTION_PRODUCTID_2);

			if (actionType == null) {
				query.append(_FINDER_COLUMN_NEXTACTION_ACTIONTYPE_1);
			}
			else {
				if (actionType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NEXTACTION_ACTIONTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_NEXTACTION_ACTIONTYPE_2);
				}
			}

			query.append(_FINDER_COLUMN_NEXTACTION_SUBSCRIBERTYPE_2);

			if (actionName == null) {
				query.append(_FINDER_COLUMN_NEXTACTION_ACTIONNAME_1);
			}
			else {
				if (actionName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NEXTACTION_ACTIONNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NEXTACTION_ACTIONNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CommandActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commandId);

				qPos.add(productId);

				if (actionType != null) {
					qPos.add(actionType);
				}

				qPos.add(subscriberType);

				if (actionName != null) {
					qPos.add(actionName);
				}

				list = (List<CommandAction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first command action in the ordered set where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	 *
	 * @param commandId the command ID
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param subscriberType the subscriber type
	 * @param actionName the action name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction findByNextAction_First(long commandId, long productId,
		String actionType, int subscriberType, String actionName,
		OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = fetchByNextAction_First(commandId,
				productId, actionType, subscriberType, actionName,
				orderByComparator);

		if (commandAction != null) {
			return commandAction;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commandId=");
		msg.append(commandId);

		msg.append(", productId=");
		msg.append(productId);

		msg.append(", actionType=");
		msg.append(actionType);

		msg.append(", subscriberType=");
		msg.append(subscriberType);

		msg.append(", actionName=");
		msg.append(actionName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommandActionException(msg.toString());
	}

	/**
	 * Returns the first command action in the ordered set where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	 *
	 * @param commandId the command ID
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param subscriberType the subscriber type
	 * @param actionName the action name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching command action, or <code>null</code> if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction fetchByNextAction_First(long commandId,
		long productId, String actionType, int subscriberType,
		String actionName, OrderByComparator orderByComparator)
		throws SystemException {
		List<CommandAction> list = findByNextAction(commandId, productId,
				actionType, subscriberType, actionName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last command action in the ordered set where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	 *
	 * @param commandId the command ID
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param subscriberType the subscriber type
	 * @param actionName the action name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction findByNextAction_Last(long commandId, long productId,
		String actionType, int subscriberType, String actionName,
		OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = fetchByNextAction_Last(commandId,
				productId, actionType, subscriberType, actionName,
				orderByComparator);

		if (commandAction != null) {
			return commandAction;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commandId=");
		msg.append(commandId);

		msg.append(", productId=");
		msg.append(productId);

		msg.append(", actionType=");
		msg.append(actionType);

		msg.append(", subscriberType=");
		msg.append(subscriberType);

		msg.append(", actionName=");
		msg.append(actionName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommandActionException(msg.toString());
	}

	/**
	 * Returns the last command action in the ordered set where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	 *
	 * @param commandId the command ID
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param subscriberType the subscriber type
	 * @param actionName the action name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching command action, or <code>null</code> if a matching command action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction fetchByNextAction_Last(long commandId, long productId,
		String actionType, int subscriberType, String actionName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNextAction(commandId, productId, actionType,
				subscriberType, actionName);

		List<CommandAction> list = findByNextAction(commandId, productId,
				actionType, subscriberType, actionName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the command actions before and after the current command action in the ordered set where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	 *
	 * @param actionId the primary key of the current command action
	 * @param commandId the command ID
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param subscriberType the subscriber type
	 * @param actionName the action name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next command action
	 * @throws com.cmc.gateway.domain.NoSuchCommandActionException if a command action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CommandAction[] findByNextAction_PrevAndNext(long actionId,
		long commandId, long productId, String actionType, int subscriberType,
		String actionName, OrderByComparator orderByComparator)
		throws NoSuchCommandActionException, SystemException {
		CommandAction commandAction = findByPrimaryKey(actionId);

		Session session = null;

		try {
			session = openSession();

			CommandAction[] array = new CommandActionImpl[3];

			array[0] = getByNextAction_PrevAndNext(session, commandAction,
					commandId, productId, actionType, subscriberType,
					actionName, orderByComparator, true);

			array[1] = commandAction;

			array[2] = getByNextAction_PrevAndNext(session, commandAction,
					commandId, productId, actionType, subscriberType,
					actionName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommandAction getByNextAction_PrevAndNext(Session session,
		CommandAction commandAction, long commandId, long productId,
		String actionType, int subscriberType, String actionName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMANDACTION_WHERE);

		query.append(_FINDER_COLUMN_NEXTACTION_COMMANDID_2);

		query.append(_FINDER_COLUMN_NEXTACTION_PRODUCTID_2);

		if (actionType == null) {
			query.append(_FINDER_COLUMN_NEXTACTION_ACTIONTYPE_1);
		}
		else {
			if (actionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NEXTACTION_ACTIONTYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_NEXTACTION_ACTIONTYPE_2);
			}
		}

		query.append(_FINDER_COLUMN_NEXTACTION_SUBSCRIBERTYPE_2);

		if (actionName == null) {
			query.append(_FINDER_COLUMN_NEXTACTION_ACTIONNAME_1);
		}
		else {
			if (actionName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NEXTACTION_ACTIONNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NEXTACTION_ACTIONNAME_2);
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
			query.append(CommandActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(commandId);

		qPos.add(productId);

		if (actionType != null) {
			qPos.add(actionType);
		}

		qPos.add(subscriberType);

		if (actionName != null) {
			qPos.add(actionName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(commandAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CommandAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the command actions.
	 *
	 * @return the command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the command actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of command actions
	 * @param end the upper bound of the range of command actions (not inclusive)
	 * @return the range of command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the command actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of command actions
	 * @param end the upper bound of the range of command actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of command actions
	 * @throws SystemException if a system exception occurred
	 */
	public List<CommandAction> findAll(int start, int end,
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

		List<CommandAction> list = (List<CommandAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMMANDACTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMANDACTION.concat(CommandActionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CommandAction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CommandAction>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the command actions where commandId = &#63; from the database.
	 *
	 * @param commandId the command ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCommand(long commandId) throws SystemException {
		for (CommandAction commandAction : findByCommand(commandId)) {
			remove(commandAction);
		}
	}

	/**
	 * Removes all the command actions where productId = &#63; from the database.
	 *
	 * @param productId the product ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByProduct(long productId) throws SystemException {
		for (CommandAction commandAction : findByProduct(productId)) {
			remove(commandAction);
		}
	}

	/**
	 * Removes all the command actions where nextCommandId = &#63; from the database.
	 *
	 * @param nextCommandId the next command ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNextCommand(long nextCommandId)
		throws SystemException {
		for (CommandAction commandAction : findByNextCommand(nextCommandId)) {
			remove(commandAction);
		}
	}

	/**
	 * Removes all the command actions where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63; from the database.
	 *
	 * @param commandId the command ID
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param subscriberType the subscriber type
	 * @param actionName the action name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNextAction(long commandId, long productId,
		String actionType, int subscriberType, String actionName)
		throws SystemException {
		for (CommandAction commandAction : findByNextAction(commandId,
				productId, actionType, subscriberType, actionName)) {
			remove(commandAction);
		}
	}

	/**
	 * Removes all the command actions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CommandAction commandAction : findAll()) {
			remove(commandAction);
		}
	}

	/**
	 * Returns the number of command actions where commandId = &#63;.
	 *
	 * @param commandId the command ID
	 * @return the number of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCommand(long commandId) throws SystemException {
		Object[] finderArgs = new Object[] { commandId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMMAND,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMANDACTION_WHERE);

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
	 * Returns the number of command actions where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the number of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProduct(long productId) throws SystemException {
		Object[] finderArgs = new Object[] { productId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRODUCT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMANDACTION_WHERE);

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
	 * Returns the number of command actions where nextCommandId = &#63;.
	 *
	 * @param nextCommandId the next command ID
	 * @return the number of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNextCommand(long nextCommandId) throws SystemException {
		Object[] finderArgs = new Object[] { nextCommandId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NEXTCOMMAND,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMANDACTION_WHERE);

			query.append(_FINDER_COLUMN_NEXTCOMMAND_NEXTCOMMANDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nextCommandId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NEXTCOMMAND,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of command actions where commandId = &#63; and productId = &#63; and actionType = &#63; and subscriberType = &#63; and actionName = &#63;.
	 *
	 * @param commandId the command ID
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param subscriberType the subscriber type
	 * @param actionName the action name
	 * @return the number of matching command actions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNextAction(long commandId, long productId,
		String actionType, int subscriberType, String actionName)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				commandId, productId, actionType, subscriberType, actionName
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NEXTACTION,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_COMMANDACTION_WHERE);

			query.append(_FINDER_COLUMN_NEXTACTION_COMMANDID_2);

			query.append(_FINDER_COLUMN_NEXTACTION_PRODUCTID_2);

			if (actionType == null) {
				query.append(_FINDER_COLUMN_NEXTACTION_ACTIONTYPE_1);
			}
			else {
				if (actionType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NEXTACTION_ACTIONTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_NEXTACTION_ACTIONTYPE_2);
				}
			}

			query.append(_FINDER_COLUMN_NEXTACTION_SUBSCRIBERTYPE_2);

			if (actionName == null) {
				query.append(_FINDER_COLUMN_NEXTACTION_ACTIONNAME_1);
			}
			else {
				if (actionName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NEXTACTION_ACTIONNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NEXTACTION_ACTIONNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commandId);

				qPos.add(productId);

				if (actionType != null) {
					qPos.add(actionType);
				}

				qPos.add(subscriberType);

				if (actionName != null) {
					qPos.add(actionName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NEXTACTION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of command actions.
	 *
	 * @return the number of command actions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMMANDACTION);

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
	 * Initializes the command action persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.CommandAction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CommandAction>> listenersList = new ArrayList<ModelListener<CommandAction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CommandAction>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CommandActionImpl.class.getName());
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
	private static final String _SQL_SELECT_COMMANDACTION = "SELECT commandAction FROM CommandAction commandAction";
	private static final String _SQL_SELECT_COMMANDACTION_WHERE = "SELECT commandAction FROM CommandAction commandAction WHERE ";
	private static final String _SQL_COUNT_COMMANDACTION = "SELECT COUNT(commandAction) FROM CommandAction commandAction";
	private static final String _SQL_COUNT_COMMANDACTION_WHERE = "SELECT COUNT(commandAction) FROM CommandAction commandAction WHERE ";
	private static final String _FINDER_COLUMN_COMMAND_COMMANDID_2 = "commandAction.commandId = ?";
	private static final String _FINDER_COLUMN_PRODUCT_PRODUCTID_2 = "commandAction.productId = ?";
	private static final String _FINDER_COLUMN_NEXTCOMMAND_NEXTCOMMANDID_2 = "commandAction.nextCommandId = ?";
	private static final String _FINDER_COLUMN_NEXTACTION_COMMANDID_2 = "commandAction.commandId = ? AND ";
	private static final String _FINDER_COLUMN_NEXTACTION_PRODUCTID_2 = "commandAction.productId = ? AND ";
	private static final String _FINDER_COLUMN_NEXTACTION_ACTIONTYPE_1 = "commandAction.actionType IS NULL AND ";
	private static final String _FINDER_COLUMN_NEXTACTION_ACTIONTYPE_2 = "commandAction.actionType = ? AND ";
	private static final String _FINDER_COLUMN_NEXTACTION_ACTIONTYPE_3 = "(commandAction.actionType IS NULL OR commandAction.actionType = ?) AND ";
	private static final String _FINDER_COLUMN_NEXTACTION_SUBSCRIBERTYPE_2 = "commandAction.subscriberType = ? AND ";
	private static final String _FINDER_COLUMN_NEXTACTION_ACTIONNAME_1 = "commandAction.actionName IS NULL";
	private static final String _FINDER_COLUMN_NEXTACTION_ACTIONNAME_2 = "commandAction.actionName = ?";
	private static final String _FINDER_COLUMN_NEXTACTION_ACTIONNAME_3 = "(commandAction.actionName IS NULL OR commandAction.actionName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "commandAction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CommandAction exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CommandAction exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CommandActionPersistenceImpl.class);
	private static CommandAction _nullCommandAction = new CommandActionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CommandAction> toCacheModel() {
				return _nullCommandActionCacheModel;
			}
		};

	private static CacheModel<CommandAction> _nullCommandActionCacheModel = new CacheModel<CommandAction>() {
			public CommandAction toEntityModel() {
				return _nullCommandAction;
			}
		};
}