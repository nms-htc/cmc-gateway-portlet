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

import com.cmc.gateway.domain.NoSuchProvisioningMessageException;
import com.cmc.gateway.domain.model.ProvisioningMessage;
import com.cmc.gateway.domain.model.impl.ProvisioningMessageImpl;
import com.cmc.gateway.domain.model.impl.ProvisioningMessageModelImpl;

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
 * The persistence implementation for the provisioning message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProvisioningMessagePersistence
 * @see ProvisioningMessageUtil
 * @generated
 */
public class ProvisioningMessagePersistenceImpl extends BasePersistenceImpl<ProvisioningMessage>
	implements ProvisioningMessagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProvisioningMessageUtil} to access the provisioning message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProvisioningMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROVISIONING =
		new FinderPath(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningMessageModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProvisioning",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING =
		new FinderPath(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningMessageModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProvisioning",
			new String[] { Long.class.getName() },
			ProvisioningMessageModelImpl.PROVISIONINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROVISIONING = new FinderPath(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProvisioning",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_RESPONSECODE = new FinderPath(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningMessageModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningMessageImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByResponseCode",
			new String[] { Long.class.getName(), String.class.getName() },
			ProvisioningMessageModelImpl.PROVISIONINGID_COLUMN_BITMASK |
			ProvisioningMessageModelImpl.RESPONSECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESPONSECODE = new FinderPath(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByResponseCode",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningMessageModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningMessageModelImpl.FINDER_CACHE_ENABLED,
			ProvisioningMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the provisioning message in the entity cache if it is enabled.
	 *
	 * @param provisioningMessage the provisioning message
	 */
	public void cacheResult(ProvisioningMessage provisioningMessage) {
		EntityCacheUtil.putResult(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningMessageImpl.class, provisioningMessage.getPrimaryKey(),
			provisioningMessage);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESPONSECODE,
			new Object[] {
				Long.valueOf(provisioningMessage.getProvisioningId()),
				
			provisioningMessage.getResponseCode()
			}, provisioningMessage);

		provisioningMessage.resetOriginalValues();
	}

	/**
	 * Caches the provisioning messages in the entity cache if it is enabled.
	 *
	 * @param provisioningMessages the provisioning messages
	 */
	public void cacheResult(List<ProvisioningMessage> provisioningMessages) {
		for (ProvisioningMessage provisioningMessage : provisioningMessages) {
			if (EntityCacheUtil.getResult(
						ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
						ProvisioningMessageImpl.class,
						provisioningMessage.getPrimaryKey()) == null) {
				cacheResult(provisioningMessage);
			}
			else {
				provisioningMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all provisioning messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProvisioningMessageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProvisioningMessageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the provisioning message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProvisioningMessage provisioningMessage) {
		EntityCacheUtil.removeResult(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningMessageImpl.class, provisioningMessage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(provisioningMessage);
	}

	@Override
	public void clearCache(List<ProvisioningMessage> provisioningMessages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProvisioningMessage provisioningMessage : provisioningMessages) {
			EntityCacheUtil.removeResult(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
				ProvisioningMessageImpl.class,
				provisioningMessage.getPrimaryKey());

			clearUniqueFindersCache(provisioningMessage);
		}
	}

	protected void clearUniqueFindersCache(
		ProvisioningMessage provisioningMessage) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESPONSECODE,
			new Object[] {
				Long.valueOf(provisioningMessage.getProvisioningId()),
				
			provisioningMessage.getResponseCode()
			});
	}

	/**
	 * Creates a new provisioning message with the primary key. Does not add the provisioning message to the database.
	 *
	 * @param messageId the primary key for the new provisioning message
	 * @return the new provisioning message
	 */
	public ProvisioningMessage create(long messageId) {
		ProvisioningMessage provisioningMessage = new ProvisioningMessageImpl();

		provisioningMessage.setNew(true);
		provisioningMessage.setPrimaryKey(messageId);

		return provisioningMessage;
	}

	/**
	 * Removes the provisioning message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the provisioning message
	 * @return the provisioning message that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a provisioning message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage remove(long messageId)
		throws NoSuchProvisioningMessageException, SystemException {
		return remove(Long.valueOf(messageId));
	}

	/**
	 * Removes the provisioning message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the provisioning message
	 * @return the provisioning message that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a provisioning message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningMessage remove(Serializable primaryKey)
		throws NoSuchProvisioningMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProvisioningMessage provisioningMessage = (ProvisioningMessage)session.get(ProvisioningMessageImpl.class,
					primaryKey);

			if (provisioningMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProvisioningMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(provisioningMessage);
		}
		catch (NoSuchProvisioningMessageException nsee) {
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
	protected ProvisioningMessage removeImpl(
		ProvisioningMessage provisioningMessage) throws SystemException {
		provisioningMessage = toUnwrappedModel(provisioningMessage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, provisioningMessage);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(provisioningMessage);

		return provisioningMessage;
	}

	@Override
	public ProvisioningMessage updateImpl(
		com.cmc.gateway.domain.model.ProvisioningMessage provisioningMessage,
		boolean merge) throws SystemException {
		provisioningMessage = toUnwrappedModel(provisioningMessage);

		boolean isNew = provisioningMessage.isNew();

		ProvisioningMessageModelImpl provisioningMessageModelImpl = (ProvisioningMessageModelImpl)provisioningMessage;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, provisioningMessage, merge);

			provisioningMessage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProvisioningMessageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((provisioningMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(provisioningMessageModelImpl.getOriginalProvisioningId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROVISIONING,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING,
					args);

				args = new Object[] {
						Long.valueOf(provisioningMessageModelImpl.getProvisioningId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROVISIONING,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVISIONING,
					args);
			}
		}

		EntityCacheUtil.putResult(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProvisioningMessageImpl.class, provisioningMessage.getPrimaryKey(),
			provisioningMessage);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESPONSECODE,
				new Object[] {
					Long.valueOf(provisioningMessage.getProvisioningId()),
					
				provisioningMessage.getResponseCode()
				}, provisioningMessage);
		}
		else {
			if ((provisioningMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RESPONSECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(provisioningMessageModelImpl.getOriginalProvisioningId()),
						
						provisioningMessageModelImpl.getOriginalResponseCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESPONSECODE,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESPONSECODE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESPONSECODE,
					new Object[] {
						Long.valueOf(provisioningMessage.getProvisioningId()),
						
					provisioningMessage.getResponseCode()
					}, provisioningMessage);
			}
		}

		return provisioningMessage;
	}

	protected ProvisioningMessage toUnwrappedModel(
		ProvisioningMessage provisioningMessage) {
		if (provisioningMessage instanceof ProvisioningMessageImpl) {
			return provisioningMessage;
		}

		ProvisioningMessageImpl provisioningMessageImpl = new ProvisioningMessageImpl();

		provisioningMessageImpl.setNew(provisioningMessage.isNew());
		provisioningMessageImpl.setPrimaryKey(provisioningMessage.getPrimaryKey());

		provisioningMessageImpl.setMessageId(provisioningMessage.getMessageId());
		provisioningMessageImpl.setGroupId(provisioningMessage.getGroupId());
		provisioningMessageImpl.setCompanyId(provisioningMessage.getCompanyId());
		provisioningMessageImpl.setUserId(provisioningMessage.getUserId());
		provisioningMessageImpl.setCreateDate(provisioningMessage.getCreateDate());
		provisioningMessageImpl.setModifiedDate(provisioningMessage.getModifiedDate());
		provisioningMessageImpl.setProvisioningId(provisioningMessage.getProvisioningId());
		provisioningMessageImpl.setResponseCode(provisioningMessage.getResponseCode());
		provisioningMessageImpl.setCause(provisioningMessage.getCause());
		provisioningMessageImpl.setCauseValue(provisioningMessage.getCauseValue());
		provisioningMessageImpl.setDescription(provisioningMessage.getDescription());

		return provisioningMessageImpl;
	}

	/**
	 * Returns the provisioning message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the provisioning message
	 * @return the provisioning message
	 * @throws com.liferay.portal.NoSuchModelException if a provisioning message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the provisioning message with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningMessageException} if it could not be found.
	 *
	 * @param messageId the primary key of the provisioning message
	 * @return the provisioning message
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a provisioning message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage findByPrimaryKey(long messageId)
		throws NoSuchProvisioningMessageException, SystemException {
		ProvisioningMessage provisioningMessage = fetchByPrimaryKey(messageId);

		if (provisioningMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + messageId);
			}

			throw new NoSuchProvisioningMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				messageId);
		}

		return provisioningMessage;
	}

	/**
	 * Returns the provisioning message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the provisioning message
	 * @return the provisioning message, or <code>null</code> if a provisioning message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProvisioningMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the provisioning message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the provisioning message
	 * @return the provisioning message, or <code>null</code> if a provisioning message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage fetchByPrimaryKey(long messageId)
		throws SystemException {
		ProvisioningMessage provisioningMessage = (ProvisioningMessage)EntityCacheUtil.getResult(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
				ProvisioningMessageImpl.class, messageId);

		if (provisioningMessage == _nullProvisioningMessage) {
			return null;
		}

		if (provisioningMessage == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				provisioningMessage = (ProvisioningMessage)session.get(ProvisioningMessageImpl.class,
						Long.valueOf(messageId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (provisioningMessage != null) {
					cacheResult(provisioningMessage);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProvisioningMessageModelImpl.ENTITY_CACHE_ENABLED,
						ProvisioningMessageImpl.class, messageId,
						_nullProvisioningMessage);
				}

				closeSession(session);
			}
		}

		return provisioningMessage;
	}

	/**
	 * Returns all the provisioning messages where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @return the matching provisioning messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningMessage> findByProvisioning(long provisioningId)
		throws SystemException {
		return findByProvisioning(provisioningId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provisioning messages where provisioningId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningId the provisioning ID
	 * @param start the lower bound of the range of provisioning messages
	 * @param end the upper bound of the range of provisioning messages (not inclusive)
	 * @return the range of matching provisioning messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningMessage> findByProvisioning(long provisioningId,
		int start, int end) throws SystemException {
		return findByProvisioning(provisioningId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the provisioning messages where provisioningId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param provisioningId the provisioning ID
	 * @param start the lower bound of the range of provisioning messages
	 * @param end the upper bound of the range of provisioning messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching provisioning messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningMessage> findByProvisioning(long provisioningId,
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

		List<ProvisioningMessage> list = (List<ProvisioningMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProvisioningMessage provisioningMessage : list) {
				if ((provisioningId != provisioningMessage.getProvisioningId())) {
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

			query.append(_SQL_SELECT_PROVISIONINGMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_PROVISIONING_PROVISIONINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProvisioningMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(provisioningId);

				list = (List<ProvisioningMessage>)QueryUtil.list(q,
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
	 * Returns the first provisioning message in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning message
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a matching provisioning message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage findByProvisioning_First(long provisioningId,
		OrderByComparator orderByComparator)
		throws NoSuchProvisioningMessageException, SystemException {
		ProvisioningMessage provisioningMessage = fetchByProvisioning_First(provisioningId,
				orderByComparator);

		if (provisioningMessage != null) {
			return provisioningMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningId=");
		msg.append(provisioningId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningMessageException(msg.toString());
	}

	/**
	 * Returns the first provisioning message in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage fetchByProvisioning_First(long provisioningId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProvisioningMessage> list = findByProvisioning(provisioningId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last provisioning message in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning message
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a matching provisioning message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage findByProvisioning_Last(long provisioningId,
		OrderByComparator orderByComparator)
		throws NoSuchProvisioningMessageException, SystemException {
		ProvisioningMessage provisioningMessage = fetchByProvisioning_Last(provisioningId,
				orderByComparator);

		if (provisioningMessage != null) {
			return provisioningMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("provisioningId=");
		msg.append(provisioningId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProvisioningMessageException(msg.toString());
	}

	/**
	 * Returns the last provisioning message in the ordered set where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage fetchByProvisioning_Last(long provisioningId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProvisioning(provisioningId);

		List<ProvisioningMessage> list = findByProvisioning(provisioningId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the provisioning messages before and after the current provisioning message in the ordered set where provisioningId = &#63;.
	 *
	 * @param messageId the primary key of the current provisioning message
	 * @param provisioningId the provisioning ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next provisioning message
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a provisioning message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage[] findByProvisioning_PrevAndNext(
		long messageId, long provisioningId, OrderByComparator orderByComparator)
		throws NoSuchProvisioningMessageException, SystemException {
		ProvisioningMessage provisioningMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			ProvisioningMessage[] array = new ProvisioningMessageImpl[3];

			array[0] = getByProvisioning_PrevAndNext(session,
					provisioningMessage, provisioningId, orderByComparator, true);

			array[1] = provisioningMessage;

			array[2] = getByProvisioning_PrevAndNext(session,
					provisioningMessage, provisioningId, orderByComparator,
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

	protected ProvisioningMessage getByProvisioning_PrevAndNext(
		Session session, ProvisioningMessage provisioningMessage,
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

		query.append(_SQL_SELECT_PROVISIONINGMESSAGE_WHERE);

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
			query.append(ProvisioningMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(provisioningId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(provisioningMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProvisioningMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the provisioning message where provisioningId = &#63; and responseCode = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProvisioningMessageException} if it could not be found.
	 *
	 * @param provisioningId the provisioning ID
	 * @param responseCode the response code
	 * @return the matching provisioning message
	 * @throws com.cmc.gateway.domain.NoSuchProvisioningMessageException if a matching provisioning message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage findByResponseCode(long provisioningId,
		String responseCode)
		throws NoSuchProvisioningMessageException, SystemException {
		ProvisioningMessage provisioningMessage = fetchByResponseCode(provisioningId,
				responseCode);

		if (provisioningMessage == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("provisioningId=");
			msg.append(provisioningId);

			msg.append(", responseCode=");
			msg.append(responseCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProvisioningMessageException(msg.toString());
		}

		return provisioningMessage;
	}

	/**
	 * Returns the provisioning message where provisioningId = &#63; and responseCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param provisioningId the provisioning ID
	 * @param responseCode the response code
	 * @return the matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage fetchByResponseCode(long provisioningId,
		String responseCode) throws SystemException {
		return fetchByResponseCode(provisioningId, responseCode, true);
	}

	/**
	 * Returns the provisioning message where provisioningId = &#63; and responseCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param provisioningId the provisioning ID
	 * @param responseCode the response code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching provisioning message, or <code>null</code> if a matching provisioning message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage fetchByResponseCode(long provisioningId,
		String responseCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { provisioningId, responseCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RESPONSECODE,
					finderArgs, this);
		}

		if (result instanceof ProvisioningMessage) {
			ProvisioningMessage provisioningMessage = (ProvisioningMessage)result;

			if ((provisioningId != provisioningMessage.getProvisioningId()) ||
					!Validator.equals(responseCode,
						provisioningMessage.getResponseCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROVISIONINGMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_RESPONSECODE_PROVISIONINGID_2);

			if (responseCode == null) {
				query.append(_FINDER_COLUMN_RESPONSECODE_RESPONSECODE_1);
			}
			else {
				if (responseCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_RESPONSECODE_RESPONSECODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_RESPONSECODE_RESPONSECODE_2);
				}
			}

			query.append(ProvisioningMessageModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(provisioningId);

				if (responseCode != null) {
					qPos.add(responseCode);
				}

				List<ProvisioningMessage> list = q.list();

				result = list;

				ProvisioningMessage provisioningMessage = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESPONSECODE,
						finderArgs, list);
				}
				else {
					provisioningMessage = list.get(0);

					cacheResult(provisioningMessage);

					if ((provisioningMessage.getProvisioningId() != provisioningId) ||
							(provisioningMessage.getResponseCode() == null) ||
							!provisioningMessage.getResponseCode()
													.equals(responseCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESPONSECODE,
							finderArgs, provisioningMessage);
					}
				}

				return provisioningMessage;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESPONSECODE,
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
				return (ProvisioningMessage)result;
			}
		}
	}

	/**
	 * Returns all the provisioning messages.
	 *
	 * @return the provisioning messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the provisioning messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of provisioning messages
	 * @param end the upper bound of the range of provisioning messages (not inclusive)
	 * @return the range of provisioning messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the provisioning messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of provisioning messages
	 * @param end the upper bound of the range of provisioning messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of provisioning messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProvisioningMessage> findAll(int start, int end,
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

		List<ProvisioningMessage> list = (List<ProvisioningMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROVISIONINGMESSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROVISIONINGMESSAGE.concat(ProvisioningMessageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProvisioningMessage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProvisioningMessage>)QueryUtil.list(q,
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
	 * Removes all the provisioning messages where provisioningId = &#63; from the database.
	 *
	 * @param provisioningId the provisioning ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByProvisioning(long provisioningId)
		throws SystemException {
		for (ProvisioningMessage provisioningMessage : findByProvisioning(
				provisioningId)) {
			remove(provisioningMessage);
		}
	}

	/**
	 * Removes the provisioning message where provisioningId = &#63; and responseCode = &#63; from the database.
	 *
	 * @param provisioningId the provisioning ID
	 * @param responseCode the response code
	 * @return the provisioning message that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public ProvisioningMessage removeByResponseCode(long provisioningId,
		String responseCode)
		throws NoSuchProvisioningMessageException, SystemException {
		ProvisioningMessage provisioningMessage = findByResponseCode(provisioningId,
				responseCode);

		return remove(provisioningMessage);
	}

	/**
	 * Removes all the provisioning messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProvisioningMessage provisioningMessage : findAll()) {
			remove(provisioningMessage);
		}
	}

	/**
	 * Returns the number of provisioning messages where provisioningId = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @return the number of matching provisioning messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProvisioning(long provisioningId)
		throws SystemException {
		Object[] finderArgs = new Object[] { provisioningId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROVISIONING,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROVISIONINGMESSAGE_WHERE);

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
	 * Returns the number of provisioning messages where provisioningId = &#63; and responseCode = &#63;.
	 *
	 * @param provisioningId the provisioning ID
	 * @param responseCode the response code
	 * @return the number of matching provisioning messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByResponseCode(long provisioningId, String responseCode)
		throws SystemException {
		Object[] finderArgs = new Object[] { provisioningId, responseCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RESPONSECODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROVISIONINGMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_RESPONSECODE_PROVISIONINGID_2);

			if (responseCode == null) {
				query.append(_FINDER_COLUMN_RESPONSECODE_RESPONSECODE_1);
			}
			else {
				if (responseCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_RESPONSECODE_RESPONSECODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_RESPONSECODE_RESPONSECODE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(provisioningId);

				if (responseCode != null) {
					qPos.add(responseCode);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RESPONSECODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of provisioning messages.
	 *
	 * @return the number of provisioning messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROVISIONINGMESSAGE);

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
	 * Initializes the provisioning message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.ProvisioningMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProvisioningMessage>> listenersList = new ArrayList<ModelListener<ProvisioningMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProvisioningMessage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProvisioningMessageImpl.class.getName());
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
	private static final String _SQL_SELECT_PROVISIONINGMESSAGE = "SELECT provisioningMessage FROM ProvisioningMessage provisioningMessage";
	private static final String _SQL_SELECT_PROVISIONINGMESSAGE_WHERE = "SELECT provisioningMessage FROM ProvisioningMessage provisioningMessage WHERE ";
	private static final String _SQL_COUNT_PROVISIONINGMESSAGE = "SELECT COUNT(provisioningMessage) FROM ProvisioningMessage provisioningMessage";
	private static final String _SQL_COUNT_PROVISIONINGMESSAGE_WHERE = "SELECT COUNT(provisioningMessage) FROM ProvisioningMessage provisioningMessage WHERE ";
	private static final String _FINDER_COLUMN_PROVISIONING_PROVISIONINGID_2 = "provisioningMessage.provisioningId = ?";
	private static final String _FINDER_COLUMN_RESPONSECODE_PROVISIONINGID_2 = "provisioningMessage.provisioningId = ? AND ";
	private static final String _FINDER_COLUMN_RESPONSECODE_RESPONSECODE_1 = "provisioningMessage.responseCode IS NULL";
	private static final String _FINDER_COLUMN_RESPONSECODE_RESPONSECODE_2 = "provisioningMessage.responseCode = ?";
	private static final String _FINDER_COLUMN_RESPONSECODE_RESPONSECODE_3 = "(provisioningMessage.responseCode IS NULL OR provisioningMessage.responseCode = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "provisioningMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProvisioningMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProvisioningMessage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProvisioningMessagePersistenceImpl.class);
	private static ProvisioningMessage _nullProvisioningMessage = new ProvisioningMessageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProvisioningMessage> toCacheModel() {
				return _nullProvisioningMessageCacheModel;
			}
		};

	private static CacheModel<ProvisioningMessage> _nullProvisioningMessageCacheModel =
		new CacheModel<ProvisioningMessage>() {
			public ProvisioningMessage toEntityModel() {
				return _nullProvisioningMessage;
			}
		};
}