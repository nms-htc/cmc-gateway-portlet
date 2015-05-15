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

import com.cmc.gateway.domain.NoSuchProductMessageException;
import com.cmc.gateway.domain.model.ProductMessage;
import com.cmc.gateway.domain.model.impl.ProductMessageImpl;
import com.cmc.gateway.domain.model.impl.ProductMessageModelImpl;

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
 * The persistence implementation for the product message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Richard Nguyen
 * @see ProductMessagePersistence
 * @see ProductMessageUtil
 * @generated
 */
public class ProductMessagePersistenceImpl extends BasePersistenceImpl<ProductMessage>
	implements ProductMessagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProductMessageUtil} to access the product message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProductMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCT = new FinderPath(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProductMessageModelImpl.FINDER_CACHE_ENABLED,
			ProductMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProduct",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT =
		new FinderPath(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProductMessageModelImpl.FINDER_CACHE_ENABLED,
			ProductMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProduct",
			new String[] { Long.class.getName() },
			ProductMessageModelImpl.PRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCT = new FinderPath(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProductMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProduct",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MESSAGE = new FinderPath(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProductMessageModelImpl.FINDER_CACHE_ENABLED,
			ProductMessageImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMessage",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			ProductMessageModelImpl.PRODUCTID_COLUMN_BITMASK |
			ProductMessageModelImpl.ACTIONTYPE_COLUMN_BITMASK |
			ProductMessageModelImpl.CHANNEL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MESSAGE = new FinderPath(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProductMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMessage",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProductMessageModelImpl.FINDER_CACHE_ENABLED,
			ProductMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProductMessageModelImpl.FINDER_CACHE_ENABLED,
			ProductMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProductMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the product message in the entity cache if it is enabled.
	 *
	 * @param productMessage the product message
	 */
	public void cacheResult(ProductMessage productMessage) {
		EntityCacheUtil.putResult(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProductMessageImpl.class, productMessage.getPrimaryKey(),
			productMessage);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGE,
			new Object[] {
				Long.valueOf(productMessage.getProductId()),
				
			productMessage.getActionType(),
				
			productMessage.getChannel()
			}, productMessage);

		productMessage.resetOriginalValues();
	}

	/**
	 * Caches the product messages in the entity cache if it is enabled.
	 *
	 * @param productMessages the product messages
	 */
	public void cacheResult(List<ProductMessage> productMessages) {
		for (ProductMessage productMessage : productMessages) {
			if (EntityCacheUtil.getResult(
						ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
						ProductMessageImpl.class, productMessage.getPrimaryKey()) == null) {
				cacheResult(productMessage);
			}
			else {
				productMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all product messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProductMessageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProductMessageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductMessage productMessage) {
		EntityCacheUtil.removeResult(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProductMessageImpl.class, productMessage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(productMessage);
	}

	@Override
	public void clearCache(List<ProductMessage> productMessages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductMessage productMessage : productMessages) {
			EntityCacheUtil.removeResult(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
				ProductMessageImpl.class, productMessage.getPrimaryKey());

			clearUniqueFindersCache(productMessage);
		}
	}

	protected void clearUniqueFindersCache(ProductMessage productMessage) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MESSAGE,
			new Object[] {
				Long.valueOf(productMessage.getProductId()),
				
			productMessage.getActionType(),
				
			productMessage.getChannel()
			});
	}

	/**
	 * Creates a new product message with the primary key. Does not add the product message to the database.
	 *
	 * @param messageId the primary key for the new product message
	 * @return the new product message
	 */
	public ProductMessage create(long messageId) {
		ProductMessage productMessage = new ProductMessageImpl();

		productMessage.setNew(true);
		productMessage.setPrimaryKey(messageId);

		return productMessage;
	}

	/**
	 * Removes the product message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the product message
	 * @return the product message that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProductMessageException if a product message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage remove(long messageId)
		throws NoSuchProductMessageException, SystemException {
		return remove(Long.valueOf(messageId));
	}

	/**
	 * Removes the product message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product message
	 * @return the product message that was removed
	 * @throws com.cmc.gateway.domain.NoSuchProductMessageException if a product message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductMessage remove(Serializable primaryKey)
		throws NoSuchProductMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProductMessage productMessage = (ProductMessage)session.get(ProductMessageImpl.class,
					primaryKey);

			if (productMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(productMessage);
		}
		catch (NoSuchProductMessageException nsee) {
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
	protected ProductMessage removeImpl(ProductMessage productMessage)
		throws SystemException {
		productMessage = toUnwrappedModel(productMessage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, productMessage);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(productMessage);

		return productMessage;
	}

	@Override
	public ProductMessage updateImpl(
		com.cmc.gateway.domain.model.ProductMessage productMessage,
		boolean merge) throws SystemException {
		productMessage = toUnwrappedModel(productMessage);

		boolean isNew = productMessage.isNew();

		ProductMessageModelImpl productMessageModelImpl = (ProductMessageModelImpl)productMessage;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, productMessage, merge);

			productMessage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProductMessageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((productMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(productMessageModelImpl.getOriginalProductId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT,
					args);

				args = new Object[] {
						Long.valueOf(productMessageModelImpl.getProductId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCT,
					args);
			}
		}

		EntityCacheUtil.putResult(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
			ProductMessageImpl.class, productMessage.getPrimaryKey(),
			productMessage);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGE,
				new Object[] {
					Long.valueOf(productMessage.getProductId()),
					
				productMessage.getActionType(),
					
				productMessage.getChannel()
				}, productMessage);
		}
		else {
			if ((productMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MESSAGE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(productMessageModelImpl.getOriginalProductId()),
						
						productMessageModelImpl.getOriginalActionType(),
						
						productMessageModelImpl.getOriginalChannel()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGE, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MESSAGE, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGE,
					new Object[] {
						Long.valueOf(productMessage.getProductId()),
						
					productMessage.getActionType(),
						
					productMessage.getChannel()
					}, productMessage);
			}
		}

		return productMessage;
	}

	protected ProductMessage toUnwrappedModel(ProductMessage productMessage) {
		if (productMessage instanceof ProductMessageImpl) {
			return productMessage;
		}

		ProductMessageImpl productMessageImpl = new ProductMessageImpl();

		productMessageImpl.setNew(productMessage.isNew());
		productMessageImpl.setPrimaryKey(productMessage.getPrimaryKey());

		productMessageImpl.setMessageId(productMessage.getMessageId());
		productMessageImpl.setGroupId(productMessage.getGroupId());
		productMessageImpl.setCompanyId(productMessage.getCompanyId());
		productMessageImpl.setUserId(productMessage.getUserId());
		productMessageImpl.setCreateDate(productMessage.getCreateDate());
		productMessageImpl.setModifiedDate(productMessage.getModifiedDate());
		productMessageImpl.setProductId(productMessage.getProductId());
		productMessageImpl.setActionType(productMessage.getActionType());
		productMessageImpl.setChannel(productMessage.getChannel());
		productMessageImpl.setCause(productMessage.getCause());
		productMessageImpl.setLanguageId(productMessage.getLanguageId());
		productMessageImpl.setCauseValue(productMessage.getCauseValue());
		productMessageImpl.setContent(productMessage.getContent());
		productMessageImpl.setDescription(productMessage.getDescription());

		return productMessageImpl;
	}

	/**
	 * Returns the product message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the product message
	 * @return the product message
	 * @throws com.liferay.portal.NoSuchModelException if a product message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the product message with the primary key or throws a {@link com.cmc.gateway.domain.NoSuchProductMessageException} if it could not be found.
	 *
	 * @param messageId the primary key of the product message
	 * @return the product message
	 * @throws com.cmc.gateway.domain.NoSuchProductMessageException if a product message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage findByPrimaryKey(long messageId)
		throws NoSuchProductMessageException, SystemException {
		ProductMessage productMessage = fetchByPrimaryKey(messageId);

		if (productMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + messageId);
			}

			throw new NoSuchProductMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				messageId);
		}

		return productMessage;
	}

	/**
	 * Returns the product message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product message
	 * @return the product message, or <code>null</code> if a product message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the product message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the product message
	 * @return the product message, or <code>null</code> if a product message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage fetchByPrimaryKey(long messageId)
		throws SystemException {
		ProductMessage productMessage = (ProductMessage)EntityCacheUtil.getResult(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
				ProductMessageImpl.class, messageId);

		if (productMessage == _nullProductMessage) {
			return null;
		}

		if (productMessage == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				productMessage = (ProductMessage)session.get(ProductMessageImpl.class,
						Long.valueOf(messageId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (productMessage != null) {
					cacheResult(productMessage);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProductMessageModelImpl.ENTITY_CACHE_ENABLED,
						ProductMessageImpl.class, messageId, _nullProductMessage);
				}

				closeSession(session);
			}
		}

		return productMessage;
	}

	/**
	 * Returns all the product messages where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the matching product messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductMessage> findByProduct(long productId)
		throws SystemException {
		return findByProduct(productId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the product messages where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of product messages
	 * @param end the upper bound of the range of product messages (not inclusive)
	 * @return the range of matching product messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductMessage> findByProduct(long productId, int start, int end)
		throws SystemException {
		return findByProduct(productId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product messages where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of product messages
	 * @param end the upper bound of the range of product messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductMessage> findByProduct(long productId, int start,
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

		List<ProductMessage> list = (List<ProductMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProductMessage productMessage : list) {
				if ((productId != productMessage.getProductId())) {
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

			query.append(_SQL_SELECT_PRODUCTMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_PRODUCT_PRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ProductMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				list = (List<ProductMessage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first product message in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product message
	 * @throws com.cmc.gateway.domain.NoSuchProductMessageException if a matching product message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage findByProduct_First(long productId,
		OrderByComparator orderByComparator)
		throws NoSuchProductMessageException, SystemException {
		ProductMessage productMessage = fetchByProduct_First(productId,
				orderByComparator);

		if (productMessage != null) {
			return productMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductMessageException(msg.toString());
	}

	/**
	 * Returns the first product message in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product message, or <code>null</code> if a matching product message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage fetchByProduct_First(long productId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProductMessage> list = findByProduct(productId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product message in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product message
	 * @throws com.cmc.gateway.domain.NoSuchProductMessageException if a matching product message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage findByProduct_Last(long productId,
		OrderByComparator orderByComparator)
		throws NoSuchProductMessageException, SystemException {
		ProductMessage productMessage = fetchByProduct_Last(productId,
				orderByComparator);

		if (productMessage != null) {
			return productMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductMessageException(msg.toString());
	}

	/**
	 * Returns the last product message in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product message, or <code>null</code> if a matching product message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage fetchByProduct_Last(long productId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProduct(productId);

		List<ProductMessage> list = findByProduct(productId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product messages before and after the current product message in the ordered set where productId = &#63;.
	 *
	 * @param messageId the primary key of the current product message
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product message
	 * @throws com.cmc.gateway.domain.NoSuchProductMessageException if a product message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage[] findByProduct_PrevAndNext(long messageId,
		long productId, OrderByComparator orderByComparator)
		throws NoSuchProductMessageException, SystemException {
		ProductMessage productMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			ProductMessage[] array = new ProductMessageImpl[3];

			array[0] = getByProduct_PrevAndNext(session, productMessage,
					productId, orderByComparator, true);

			array[1] = productMessage;

			array[2] = getByProduct_PrevAndNext(session, productMessage,
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

	protected ProductMessage getByProduct_PrevAndNext(Session session,
		ProductMessage productMessage, long productId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCTMESSAGE_WHERE);

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
			query.append(ProductMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(productId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(productMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProductMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the product message where productId = &#63; and actionType = &#63; and channel = &#63; or throws a {@link com.cmc.gateway.domain.NoSuchProductMessageException} if it could not be found.
	 *
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param channel the channel
	 * @return the matching product message
	 * @throws com.cmc.gateway.domain.NoSuchProductMessageException if a matching product message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage findByMessage(long productId, String actionType,
		String channel) throws NoSuchProductMessageException, SystemException {
		ProductMessage productMessage = fetchByMessage(productId, actionType,
				channel);

		if (productMessage == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("productId=");
			msg.append(productId);

			msg.append(", actionType=");
			msg.append(actionType);

			msg.append(", channel=");
			msg.append(channel);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProductMessageException(msg.toString());
		}

		return productMessage;
	}

	/**
	 * Returns the product message where productId = &#63; and actionType = &#63; and channel = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param channel the channel
	 * @return the matching product message, or <code>null</code> if a matching product message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage fetchByMessage(long productId, String actionType,
		String channel) throws SystemException {
		return fetchByMessage(productId, actionType, channel, true);
	}

	/**
	 * Returns the product message where productId = &#63; and actionType = &#63; and channel = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param channel the channel
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching product message, or <code>null</code> if a matching product message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage fetchByMessage(long productId, String actionType,
		String channel, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { productId, actionType, channel };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MESSAGE,
					finderArgs, this);
		}

		if (result instanceof ProductMessage) {
			ProductMessage productMessage = (ProductMessage)result;

			if ((productId != productMessage.getProductId()) ||
					!Validator.equals(actionType, productMessage.getActionType()) ||
					!Validator.equals(channel, productMessage.getChannel())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_PRODUCTMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_MESSAGE_PRODUCTID_2);

			if (actionType == null) {
				query.append(_FINDER_COLUMN_MESSAGE_ACTIONTYPE_1);
			}
			else {
				if (actionType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MESSAGE_ACTIONTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_MESSAGE_ACTIONTYPE_2);
				}
			}

			if (channel == null) {
				query.append(_FINDER_COLUMN_MESSAGE_CHANNEL_1);
			}
			else {
				if (channel.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MESSAGE_CHANNEL_3);
				}
				else {
					query.append(_FINDER_COLUMN_MESSAGE_CHANNEL_2);
				}
			}

			query.append(ProductMessageModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				if (actionType != null) {
					qPos.add(actionType);
				}

				if (channel != null) {
					qPos.add(channel);
				}

				List<ProductMessage> list = q.list();

				result = list;

				ProductMessage productMessage = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGE,
						finderArgs, list);
				}
				else {
					productMessage = list.get(0);

					cacheResult(productMessage);

					if ((productMessage.getProductId() != productId) ||
							(productMessage.getActionType() == null) ||
							!productMessage.getActionType().equals(actionType) ||
							(productMessage.getChannel() == null) ||
							!productMessage.getChannel().equals(channel)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGE,
							finderArgs, productMessage);
					}
				}

				return productMessage;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MESSAGE,
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
				return (ProductMessage)result;
			}
		}
	}

	/**
	 * Returns all the product messages.
	 *
	 * @return the product messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of product messages
	 * @param end the upper bound of the range of product messages (not inclusive)
	 * @return the range of product messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of product messages
	 * @param end the upper bound of the range of product messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductMessage> findAll(int start, int end,
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

		List<ProductMessage> list = (List<ProductMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRODUCTMESSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTMESSAGE.concat(ProductMessageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProductMessage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProductMessage>)QueryUtil.list(q,
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
	 * Removes all the product messages where productId = &#63; from the database.
	 *
	 * @param productId the product ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByProduct(long productId) throws SystemException {
		for (ProductMessage productMessage : findByProduct(productId)) {
			remove(productMessage);
		}
	}

	/**
	 * Removes the product message where productId = &#63; and actionType = &#63; and channel = &#63; from the database.
	 *
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param channel the channel
	 * @return the product message that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public ProductMessage removeByMessage(long productId, String actionType,
		String channel) throws NoSuchProductMessageException, SystemException {
		ProductMessage productMessage = findByMessage(productId, actionType,
				channel);

		return remove(productMessage);
	}

	/**
	 * Removes all the product messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProductMessage productMessage : findAll()) {
			remove(productMessage);
		}
	}

	/**
	 * Returns the number of product messages where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the number of matching product messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProduct(long productId) throws SystemException {
		Object[] finderArgs = new Object[] { productId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRODUCT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCTMESSAGE_WHERE);

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
	 * Returns the number of product messages where productId = &#63; and actionType = &#63; and channel = &#63;.
	 *
	 * @param productId the product ID
	 * @param actionType the action type
	 * @param channel the channel
	 * @return the number of matching product messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMessage(long productId, String actionType, String channel)
		throws SystemException {
		Object[] finderArgs = new Object[] { productId, actionType, channel };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MESSAGE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PRODUCTMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_MESSAGE_PRODUCTID_2);

			if (actionType == null) {
				query.append(_FINDER_COLUMN_MESSAGE_ACTIONTYPE_1);
			}
			else {
				if (actionType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MESSAGE_ACTIONTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_MESSAGE_ACTIONTYPE_2);
				}
			}

			if (channel == null) {
				query.append(_FINDER_COLUMN_MESSAGE_CHANNEL_1);
			}
			else {
				if (channel.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MESSAGE_CHANNEL_3);
				}
				else {
					query.append(_FINDER_COLUMN_MESSAGE_CHANNEL_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				if (actionType != null) {
					qPos.add(actionType);
				}

				if (channel != null) {
					qPos.add(channel);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MESSAGE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of product messages.
	 *
	 * @return the number of product messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRODUCTMESSAGE);

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
	 * Initializes the product message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cmc.gateway.domain.model.ProductMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProductMessage>> listenersList = new ArrayList<ModelListener<ProductMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProductMessage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProductMessageImpl.class.getName());
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
	private static final String _SQL_SELECT_PRODUCTMESSAGE = "SELECT productMessage FROM ProductMessage productMessage";
	private static final String _SQL_SELECT_PRODUCTMESSAGE_WHERE = "SELECT productMessage FROM ProductMessage productMessage WHERE ";
	private static final String _SQL_COUNT_PRODUCTMESSAGE = "SELECT COUNT(productMessage) FROM ProductMessage productMessage";
	private static final String _SQL_COUNT_PRODUCTMESSAGE_WHERE = "SELECT COUNT(productMessage) FROM ProductMessage productMessage WHERE ";
	private static final String _FINDER_COLUMN_PRODUCT_PRODUCTID_2 = "productMessage.productId = ?";
	private static final String _FINDER_COLUMN_MESSAGE_PRODUCTID_2 = "productMessage.productId = ? AND ";
	private static final String _FINDER_COLUMN_MESSAGE_ACTIONTYPE_1 = "productMessage.actionType IS NULL AND ";
	private static final String _FINDER_COLUMN_MESSAGE_ACTIONTYPE_2 = "productMessage.actionType = ? AND ";
	private static final String _FINDER_COLUMN_MESSAGE_ACTIONTYPE_3 = "(productMessage.actionType IS NULL OR productMessage.actionType = ?) AND ";
	private static final String _FINDER_COLUMN_MESSAGE_CHANNEL_1 = "productMessage.channel IS NULL";
	private static final String _FINDER_COLUMN_MESSAGE_CHANNEL_2 = "productMessage.channel = ?";
	private static final String _FINDER_COLUMN_MESSAGE_CHANNEL_3 = "(productMessage.channel IS NULL OR productMessage.channel = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "productMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProductMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProductMessage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProductMessagePersistenceImpl.class);
	private static ProductMessage _nullProductMessage = new ProductMessageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProductMessage> toCacheModel() {
				return _nullProductMessageCacheModel;
			}
		};

	private static CacheModel<ProductMessage> _nullProductMessageCacheModel = new CacheModel<ProductMessage>() {
			public ProductMessage toEntityModel() {
				return _nullProductMessage;
			}
		};
}