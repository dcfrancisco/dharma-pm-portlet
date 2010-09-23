/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.dharma.service.persistence;

import com.dharma.NoSuchPMDeletedMessageException;

import com.dharma.model.PMDeletedMessage;
import com.dharma.model.impl.PMDeletedMessageImpl;
import com.dharma.model.impl.PMDeletedMessageModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
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
 * The persistence implementation for the p m deleted message service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link PMDeletedMessageUtil} to access the p m deleted message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMDeletedMessagePersistence
 * @see PMDeletedMessageUtil
 * @generated
 */
public class PMDeletedMessagePersistenceImpl extends BasePersistenceImpl<PMDeletedMessage>
	implements PMDeletedMessagePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = PMDeletedMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_OWNERID = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOwnerId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OWNERID = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOwnerId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MESSAGEID = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMessageId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MESSAGEID = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByMessageId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the p m deleted message in the entity cache if it is enabled.
	 *
	 * @param pmDeletedMessage the p m deleted message to cache
	 */
	public void cacheResult(PMDeletedMessage pmDeletedMessage) {
		EntityCacheUtil.putResult(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageImpl.class, pmDeletedMessage.getPrimaryKey(),
			pmDeletedMessage);
	}

	/**
	 * Caches the p m deleted messages in the entity cache if it is enabled.
	 *
	 * @param pmDeletedMessages the p m deleted messages to cache
	 */
	public void cacheResult(List<PMDeletedMessage> pmDeletedMessages) {
		for (PMDeletedMessage pmDeletedMessage : pmDeletedMessages) {
			if (EntityCacheUtil.getResult(
						PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
						PMDeletedMessageImpl.class,
						pmDeletedMessage.getPrimaryKey(), this) == null) {
				cacheResult(pmDeletedMessage);
			}
		}
	}

	/**
	 * Clears the cache for all p m deleted messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(PMDeletedMessageImpl.class.getName());
		EntityCacheUtil.clearCache(PMDeletedMessageImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the p m deleted message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(PMDeletedMessage pmDeletedMessage) {
		EntityCacheUtil.removeResult(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageImpl.class, pmDeletedMessage.getPrimaryKey());
	}

	/**
	 * Creates a new p m deleted message with the primary key. Does not add the p m deleted message to the database.
	 *
	 * @param deletedMessageId the primary key for the new p m deleted message
	 * @return the new p m deleted message
	 */
	public PMDeletedMessage create(long deletedMessageId) {
		PMDeletedMessage pmDeletedMessage = new PMDeletedMessageImpl();

		pmDeletedMessage.setNew(true);
		pmDeletedMessage.setPrimaryKey(deletedMessageId);

		return pmDeletedMessage;
	}

	/**
	 * Removes the p m deleted message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p m deleted message to remove
	 * @return the p m deleted message that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the p m deleted message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deletedMessageId the primary key of the p m deleted message to remove
	 * @return the p m deleted message that was removed
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage remove(long deletedMessageId)
		throws NoSuchPMDeletedMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PMDeletedMessage pmDeletedMessage = (PMDeletedMessage)session.get(PMDeletedMessageImpl.class,
					new Long(deletedMessageId));

			if (pmDeletedMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						deletedMessageId);
				}

				throw new NoSuchPMDeletedMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					deletedMessageId);
			}

			return remove(pmDeletedMessage);
		}
		catch (NoSuchPMDeletedMessageException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMDeletedMessage removeImpl(PMDeletedMessage pmDeletedMessage)
		throws SystemException {
		pmDeletedMessage = toUnwrappedModel(pmDeletedMessage);

		Session session = null;

		try {
			session = openSession();

			if (pmDeletedMessage.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(PMDeletedMessageImpl.class,
						pmDeletedMessage.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(pmDeletedMessage);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageImpl.class, pmDeletedMessage.getPrimaryKey());

		return pmDeletedMessage;
	}

	public PMDeletedMessage updateImpl(
		com.dharma.model.PMDeletedMessage pmDeletedMessage, boolean merge)
		throws SystemException {
		pmDeletedMessage = toUnwrappedModel(pmDeletedMessage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, pmDeletedMessage, merge);

			pmDeletedMessage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMDeletedMessageImpl.class, pmDeletedMessage.getPrimaryKey(),
			pmDeletedMessage);

		return pmDeletedMessage;
	}

	protected PMDeletedMessage toUnwrappedModel(
		PMDeletedMessage pmDeletedMessage) {
		if (pmDeletedMessage instanceof PMDeletedMessageImpl) {
			return pmDeletedMessage;
		}

		PMDeletedMessageImpl pmDeletedMessageImpl = new PMDeletedMessageImpl();

		pmDeletedMessageImpl.setNew(pmDeletedMessage.isNew());
		pmDeletedMessageImpl.setPrimaryKey(pmDeletedMessage.getPrimaryKey());

		pmDeletedMessageImpl.setDeletedMessageId(pmDeletedMessage.getDeletedMessageId());
		pmDeletedMessageImpl.setMessageId(pmDeletedMessage.getMessageId());
		pmDeletedMessageImpl.setOwnerId(pmDeletedMessage.getOwnerId());
		pmDeletedMessageImpl.setDeletedDate(pmDeletedMessage.getDeletedDate());

		return pmDeletedMessageImpl;
	}

	/**
	 * Finds the p m deleted message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m deleted message to find
	 * @return the p m deleted message
	 * @throws com.liferay.portal.NoSuchModelException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p m deleted message with the primary key or throws a {@link com.dharma.NoSuchPMDeletedMessageException} if it could not be found.
	 *
	 * @param deletedMessageId the primary key of the p m deleted message to find
	 * @return the p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage findByPrimaryKey(long deletedMessageId)
		throws NoSuchPMDeletedMessageException, SystemException {
		PMDeletedMessage pmDeletedMessage = fetchByPrimaryKey(deletedMessageId);

		if (pmDeletedMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + deletedMessageId);
			}

			throw new NoSuchPMDeletedMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				deletedMessageId);
		}

		return pmDeletedMessage;
	}

	/**
	 * Finds the p m deleted message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m deleted message to find
	 * @return the p m deleted message, or <code>null</code> if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p m deleted message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deletedMessageId the primary key of the p m deleted message to find
	 * @return the p m deleted message, or <code>null</code> if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage fetchByPrimaryKey(long deletedMessageId)
		throws SystemException {
		PMDeletedMessage pmDeletedMessage = (PMDeletedMessage)EntityCacheUtil.getResult(PMDeletedMessageModelImpl.ENTITY_CACHE_ENABLED,
				PMDeletedMessageImpl.class, deletedMessageId, this);

		if (pmDeletedMessage == null) {
			Session session = null;

			try {
				session = openSession();

				pmDeletedMessage = (PMDeletedMessage)session.get(PMDeletedMessageImpl.class,
						new Long(deletedMessageId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (pmDeletedMessage != null) {
					cacheResult(pmDeletedMessage);
				}

				closeSession(session);
			}
		}

		return pmDeletedMessage;
	}

	/**
	 * Finds all the p m deleted messages where ownerId = &#63;.
	 *
	 * @param ownerId the owner id to search with
	 * @return the matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByOwnerId(long ownerId)
		throws SystemException {
		return findByOwnerId(ownerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p m deleted messages where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param start the lower bound of the range of p m deleted messages to return
	 * @param end the upper bound of the range of p m deleted messages to return (not inclusive)
	 * @return the range of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByOwnerId(long ownerId, int start, int end)
		throws SystemException {
		return findByOwnerId(ownerId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p m deleted messages where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param start the lower bound of the range of p m deleted messages to return
	 * @param end the upper bound of the range of p m deleted messages to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByOwnerId(long ownerId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				ownerId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PMDeletedMessage> list = (List<PMDeletedMessage>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OWNERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_PMDELETEDMESSAGE_WHERE);

				query.append(_FINDER_COLUMN_OWNERID_OWNERID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(PMDeletedMessageModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				list = (List<PMDeletedMessage>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<PMDeletedMessage>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OWNERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first p m deleted message in the ordered set where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage findByOwnerId_First(long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		List<PMDeletedMessage> list = findByOwnerId(ownerId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ownerId=");
			msg.append(ownerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMDeletedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p m deleted message in the ordered set where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage findByOwnerId_Last(long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		int count = countByOwnerId(ownerId);

		List<PMDeletedMessage> list = findByOwnerId(ownerId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ownerId=");
			msg.append(ownerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMDeletedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p m deleted messages before and after the current p m deleted message in the ordered set where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param deletedMessageId the primary key of the current p m deleted message
	 * @param ownerId the owner id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage[] findByOwnerId_PrevAndNext(long deletedMessageId,
		long ownerId, OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		PMDeletedMessage pmDeletedMessage = findByPrimaryKey(deletedMessageId);

		Session session = null;

		try {
			session = openSession();

			PMDeletedMessage[] array = new PMDeletedMessageImpl[3];

			array[0] = getByOwnerId_PrevAndNext(session, pmDeletedMessage,
					ownerId, orderByComparator, true);

			array[1] = pmDeletedMessage;

			array[2] = getByOwnerId_PrevAndNext(session, pmDeletedMessage,
					ownerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMDeletedMessage getByOwnerId_PrevAndNext(Session session,
		PMDeletedMessage pmDeletedMessage, long ownerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PMDELETEDMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_OWNERID_OWNERID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
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
			query.append(PMDeletedMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(pmDeletedMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PMDeletedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the p m deleted messages where messageId = &#63;.
	 *
	 * @param messageId the message id to search with
	 * @return the matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByMessageId(long messageId)
		throws SystemException {
		return findByMessageId(messageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the p m deleted messages where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the message id to search with
	 * @param start the lower bound of the range of p m deleted messages to return
	 * @param end the upper bound of the range of p m deleted messages to return (not inclusive)
	 * @return the range of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByMessageId(long messageId, int start,
		int end) throws SystemException {
		return findByMessageId(messageId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p m deleted messages where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the message id to search with
	 * @param start the lower bound of the range of p m deleted messages to return
	 * @param end the upper bound of the range of p m deleted messages to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findByMessageId(long messageId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				messageId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PMDeletedMessage> list = (List<PMDeletedMessage>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MESSAGEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_PMDELETEDMESSAGE_WHERE);

				query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(PMDeletedMessageModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(messageId);

				list = (List<PMDeletedMessage>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<PMDeletedMessage>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MESSAGEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first p m deleted message in the ordered set where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the message id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage findByMessageId_First(long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		List<PMDeletedMessage> list = findByMessageId(messageId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("messageId=");
			msg.append(messageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMDeletedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p m deleted message in the ordered set where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the message id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a matching p m deleted message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage findByMessageId_Last(long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		int count = countByMessageId(messageId);

		List<PMDeletedMessage> list = findByMessageId(messageId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("messageId=");
			msg.append(messageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMDeletedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p m deleted messages before and after the current p m deleted message in the ordered set where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param deletedMessageId the primary key of the current p m deleted message
	 * @param messageId the message id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p m deleted message
	 * @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMDeletedMessage[] findByMessageId_PrevAndNext(
		long deletedMessageId, long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMDeletedMessageException, SystemException {
		PMDeletedMessage pmDeletedMessage = findByPrimaryKey(deletedMessageId);

		Session session = null;

		try {
			session = openSession();

			PMDeletedMessage[] array = new PMDeletedMessageImpl[3];

			array[0] = getByMessageId_PrevAndNext(session, pmDeletedMessage,
					messageId, orderByComparator, true);

			array[1] = pmDeletedMessage;

			array[2] = getByMessageId_PrevAndNext(session, pmDeletedMessage,
					messageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMDeletedMessage getByMessageId_PrevAndNext(Session session,
		PMDeletedMessage pmDeletedMessage, long messageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PMDELETEDMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
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
			query.append(PMDeletedMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(messageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(pmDeletedMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PMDeletedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the p m deleted messages.
	 *
	 * @return the p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p m deleted messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m deleted messages to return
	 * @param end the upper bound of the range of p m deleted messages to return (not inclusive)
	 * @return the range of p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the p m deleted messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m deleted messages to return
	 * @param end the upper bound of the range of p m deleted messages to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMDeletedMessage> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PMDeletedMessage> list = (List<PMDeletedMessage>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_PMDELETEDMESSAGE);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_PMDELETEDMESSAGE.concat(PMDeletedMessageModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PMDeletedMessage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PMDeletedMessage>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<PMDeletedMessage>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the p m deleted messages where ownerId = &#63; from the database.
	 *
	 * @param ownerId the owner id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOwnerId(long ownerId) throws SystemException {
		for (PMDeletedMessage pmDeletedMessage : findByOwnerId(ownerId)) {
			remove(pmDeletedMessage);
		}
	}

	/**
	 * Removes all the p m deleted messages where messageId = &#63; from the database.
	 *
	 * @param messageId the message id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMessageId(long messageId) throws SystemException {
		for (PMDeletedMessage pmDeletedMessage : findByMessageId(messageId)) {
			remove(pmDeletedMessage);
		}
	}

	/**
	 * Removes all the p m deleted messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PMDeletedMessage pmDeletedMessage : findAll()) {
			remove(pmDeletedMessage);
		}
	}

	/**
	 * Counts all the p m deleted messages where ownerId = &#63;.
	 *
	 * @param ownerId the owner id to search with
	 * @return the number of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOwnerId(long ownerId) throws SystemException {
		Object[] finderArgs = new Object[] { ownerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OWNERID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_PMDELETEDMESSAGE_WHERE);

				query.append(_FINDER_COLUMN_OWNERID_OWNERID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OWNERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the p m deleted messages where messageId = &#63;.
	 *
	 * @param messageId the message id to search with
	 * @return the number of matching p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMessageId(long messageId) throws SystemException {
		Object[] finderArgs = new Object[] { messageId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MESSAGEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_PMDELETEDMESSAGE_WHERE);

				query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(messageId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MESSAGEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the p m deleted messages.
	 *
	 * @return the number of p m deleted messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PMDELETEDMESSAGE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the p m deleted message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.dharma.model.PMDeletedMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PMDeletedMessage>> listenersList = new ArrayList<ModelListener<PMDeletedMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PMDeletedMessage>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = PMMessagePersistence.class)
	protected PMMessagePersistence pmMessagePersistence;
	@BeanReference(type = PMDeletedMessagePersistence.class)
	protected PMDeletedMessagePersistence pmDeletedMessagePersistence;
	@BeanReference(type = PMReadMessagePersistence.class)
	protected PMReadMessagePersistence pmReadMessagePersistence;
	@BeanReference(type = PMBlockedUserPersistence.class)
	protected PMBlockedUserPersistence pmBlockedUserPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PMDELETEDMESSAGE = "SELECT pmDeletedMessage FROM PMDeletedMessage pmDeletedMessage";
	private static final String _SQL_SELECT_PMDELETEDMESSAGE_WHERE = "SELECT pmDeletedMessage FROM PMDeletedMessage pmDeletedMessage WHERE ";
	private static final String _SQL_COUNT_PMDELETEDMESSAGE = "SELECT COUNT(pmDeletedMessage) FROM PMDeletedMessage pmDeletedMessage";
	private static final String _SQL_COUNT_PMDELETEDMESSAGE_WHERE = "SELECT COUNT(pmDeletedMessage) FROM PMDeletedMessage pmDeletedMessage WHERE ";
	private static final String _FINDER_COLUMN_OWNERID_OWNERID_2 = "pmDeletedMessage.ownerId = ?";
	private static final String _FINDER_COLUMN_MESSAGEID_MESSAGEID_2 = "pmDeletedMessage.messageId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pmDeletedMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PMDeletedMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PMDeletedMessage exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(PMDeletedMessagePersistenceImpl.class);
}