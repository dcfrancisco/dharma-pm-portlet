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

import com.dharma.NoSuchPMReadMessageException;

import com.dharma.model.PMReadMessage;
import com.dharma.model.impl.PMReadMessageImpl;
import com.dharma.model.impl.PMReadMessageModelImpl;

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
 * The persistence implementation for the p m read message service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link PMReadMessageUtil} to access the p m read message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMReadMessagePersistence
 * @see PMReadMessageUtil
 * @generated
 */
public class PMReadMessagePersistenceImpl extends BasePersistenceImpl<PMReadMessage>
	implements PMReadMessagePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = PMReadMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_MESSAGEID = new FinderPath(PMReadMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMReadMessageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByMessageId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MESSAGEID = new FinderPath(PMReadMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMReadMessageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByMessageId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PMReadMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMReadMessageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PMReadMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMReadMessageModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the p m read message in the entity cache if it is enabled.
	 *
	 * @param pmReadMessage the p m read message to cache
	 */
	public void cacheResult(PMReadMessage pmReadMessage) {
		EntityCacheUtil.putResult(PMReadMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMReadMessageImpl.class, pmReadMessage.getPrimaryKey(),
			pmReadMessage);
	}

	/**
	 * Caches the p m read messages in the entity cache if it is enabled.
	 *
	 * @param pmReadMessages the p m read messages to cache
	 */
	public void cacheResult(List<PMReadMessage> pmReadMessages) {
		for (PMReadMessage pmReadMessage : pmReadMessages) {
			if (EntityCacheUtil.getResult(
						PMReadMessageModelImpl.ENTITY_CACHE_ENABLED,
						PMReadMessageImpl.class, pmReadMessage.getPrimaryKey(),
						this) == null) {
				cacheResult(pmReadMessage);
			}
		}
	}

	/**
	 * Clears the cache for all p m read messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(PMReadMessageImpl.class.getName());
		EntityCacheUtil.clearCache(PMReadMessageImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the p m read message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(PMReadMessage pmReadMessage) {
		EntityCacheUtil.removeResult(PMReadMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMReadMessageImpl.class, pmReadMessage.getPrimaryKey());
	}

	/**
	 * Creates a new p m read message with the primary key. Does not add the p m read message to the database.
	 *
	 * @param readMessageId the primary key for the new p m read message
	 * @return the new p m read message
	 */
	public PMReadMessage create(long readMessageId) {
		PMReadMessage pmReadMessage = new PMReadMessageImpl();

		pmReadMessage.setNew(true);
		pmReadMessage.setPrimaryKey(readMessageId);

		return pmReadMessage;
	}

	/**
	 * Removes the p m read message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p m read message to remove
	 * @return the p m read message that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a p m read message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the p m read message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param readMessageId the primary key of the p m read message to remove
	 * @return the p m read message that was removed
	 * @throws com.dharma.NoSuchPMReadMessageException if a p m read message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage remove(long readMessageId)
		throws NoSuchPMReadMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PMReadMessage pmReadMessage = (PMReadMessage)session.get(PMReadMessageImpl.class,
					new Long(readMessageId));

			if (pmReadMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + readMessageId);
				}

				throw new NoSuchPMReadMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					readMessageId);
			}

			return remove(pmReadMessage);
		}
		catch (NoSuchPMReadMessageException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMReadMessage removeImpl(PMReadMessage pmReadMessage)
		throws SystemException {
		pmReadMessage = toUnwrappedModel(pmReadMessage);

		Session session = null;

		try {
			session = openSession();

			if (pmReadMessage.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(PMReadMessageImpl.class,
						pmReadMessage.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(pmReadMessage);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(PMReadMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMReadMessageImpl.class, pmReadMessage.getPrimaryKey());

		return pmReadMessage;
	}

	public PMReadMessage updateImpl(
		com.dharma.model.PMReadMessage pmReadMessage, boolean merge)
		throws SystemException {
		pmReadMessage = toUnwrappedModel(pmReadMessage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, pmReadMessage, merge);

			pmReadMessage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(PMReadMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMReadMessageImpl.class, pmReadMessage.getPrimaryKey(),
			pmReadMessage);

		return pmReadMessage;
	}

	protected PMReadMessage toUnwrappedModel(PMReadMessage pmReadMessage) {
		if (pmReadMessage instanceof PMReadMessageImpl) {
			return pmReadMessage;
		}

		PMReadMessageImpl pmReadMessageImpl = new PMReadMessageImpl();

		pmReadMessageImpl.setNew(pmReadMessage.isNew());
		pmReadMessageImpl.setPrimaryKey(pmReadMessage.getPrimaryKey());

		pmReadMessageImpl.setReadMessageId(pmReadMessage.getReadMessageId());
		pmReadMessageImpl.setMessageId(pmReadMessage.getMessageId());
		pmReadMessageImpl.setReadDate(pmReadMessage.getReadDate());

		return pmReadMessageImpl;
	}

	/**
	 * Finds the p m read message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m read message to find
	 * @return the p m read message
	 * @throws com.liferay.portal.NoSuchModelException if a p m read message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p m read message with the primary key or throws a {@link com.dharma.NoSuchPMReadMessageException} if it could not be found.
	 *
	 * @param readMessageId the primary key of the p m read message to find
	 * @return the p m read message
	 * @throws com.dharma.NoSuchPMReadMessageException if a p m read message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage findByPrimaryKey(long readMessageId)
		throws NoSuchPMReadMessageException, SystemException {
		PMReadMessage pmReadMessage = fetchByPrimaryKey(readMessageId);

		if (pmReadMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + readMessageId);
			}

			throw new NoSuchPMReadMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				readMessageId);
		}

		return pmReadMessage;
	}

	/**
	 * Finds the p m read message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m read message to find
	 * @return the p m read message, or <code>null</code> if a p m read message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p m read message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param readMessageId the primary key of the p m read message to find
	 * @return the p m read message, or <code>null</code> if a p m read message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage fetchByPrimaryKey(long readMessageId)
		throws SystemException {
		PMReadMessage pmReadMessage = (PMReadMessage)EntityCacheUtil.getResult(PMReadMessageModelImpl.ENTITY_CACHE_ENABLED,
				PMReadMessageImpl.class, readMessageId, this);

		if (pmReadMessage == null) {
			Session session = null;

			try {
				session = openSession();

				pmReadMessage = (PMReadMessage)session.get(PMReadMessageImpl.class,
						new Long(readMessageId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (pmReadMessage != null) {
					cacheResult(pmReadMessage);
				}

				closeSession(session);
			}
		}

		return pmReadMessage;
	}

	/**
	 * Finds all the p m read messages where messageId = &#63;.
	 *
	 * @param messageId the message id to search with
	 * @return the matching p m read messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMReadMessage> findByMessageId(long messageId)
		throws SystemException {
		return findByMessageId(messageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the p m read messages where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the message id to search with
	 * @param start the lower bound of the range of p m read messages to return
	 * @param end the upper bound of the range of p m read messages to return (not inclusive)
	 * @return the range of matching p m read messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMReadMessage> findByMessageId(long messageId, int start,
		int end) throws SystemException {
		return findByMessageId(messageId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p m read messages where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the message id to search with
	 * @param start the lower bound of the range of p m read messages to return
	 * @param end the upper bound of the range of p m read messages to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p m read messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMReadMessage> findByMessageId(long messageId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				messageId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PMReadMessage> list = (List<PMReadMessage>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MESSAGEID,
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

				query.append(_SQL_SELECT_PMREADMESSAGE_WHERE);

				query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(PMReadMessageModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(messageId);

				list = (List<PMReadMessage>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<PMReadMessage>();
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
	 * Finds the first p m read message in the ordered set where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the message id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p m read message
	 * @throws com.dharma.NoSuchPMReadMessageException if a matching p m read message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage findByMessageId_First(long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMReadMessageException, SystemException {
		List<PMReadMessage> list = findByMessageId(messageId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("messageId=");
			msg.append(messageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMReadMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p m read message in the ordered set where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the message id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p m read message
	 * @throws com.dharma.NoSuchPMReadMessageException if a matching p m read message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage findByMessageId_Last(long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMReadMessageException, SystemException {
		int count = countByMessageId(messageId);

		List<PMReadMessage> list = findByMessageId(messageId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("messageId=");
			msg.append(messageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMReadMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p m read messages before and after the current p m read message in the ordered set where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param readMessageId the primary key of the current p m read message
	 * @param messageId the message id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p m read message
	 * @throws com.dharma.NoSuchPMReadMessageException if a p m read message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage[] findByMessageId_PrevAndNext(long readMessageId,
		long messageId, OrderByComparator orderByComparator)
		throws NoSuchPMReadMessageException, SystemException {
		PMReadMessage pmReadMessage = findByPrimaryKey(readMessageId);

		Session session = null;

		try {
			session = openSession();

			PMReadMessage[] array = new PMReadMessageImpl[3];

			array[0] = getByMessageId_PrevAndNext(session, pmReadMessage,
					messageId, orderByComparator, true);

			array[1] = pmReadMessage;

			array[2] = getByMessageId_PrevAndNext(session, pmReadMessage,
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

	protected PMReadMessage getByMessageId_PrevAndNext(Session session,
		PMReadMessage pmReadMessage, long messageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PMREADMESSAGE_WHERE);

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
			query.append(PMReadMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(messageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(pmReadMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PMReadMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the p m read messages.
	 *
	 * @return the p m read messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMReadMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p m read messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m read messages to return
	 * @param end the upper bound of the range of p m read messages to return (not inclusive)
	 * @return the range of p m read messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMReadMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the p m read messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m read messages to return
	 * @param end the upper bound of the range of p m read messages to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of p m read messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMReadMessage> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PMReadMessage> list = (List<PMReadMessage>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_PMREADMESSAGE);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_PMREADMESSAGE.concat(PMReadMessageModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PMReadMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PMReadMessage>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<PMReadMessage>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the p m read messages where messageId = &#63; from the database.
	 *
	 * @param messageId the message id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMessageId(long messageId) throws SystemException {
		for (PMReadMessage pmReadMessage : findByMessageId(messageId)) {
			remove(pmReadMessage);
		}
	}

	/**
	 * Removes all the p m read messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PMReadMessage pmReadMessage : findAll()) {
			remove(pmReadMessage);
		}
	}

	/**
	 * Counts all the p m read messages where messageId = &#63;.
	 *
	 * @param messageId the message id to search with
	 * @return the number of matching p m read messages
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

				query.append(_SQL_COUNT_PMREADMESSAGE_WHERE);

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
	 * Counts all the p m read messages.
	 *
	 * @return the number of p m read messages
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

				Query q = session.createQuery(_SQL_COUNT_PMREADMESSAGE);

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
	 * Initializes the p m read message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.dharma.model.PMReadMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PMReadMessage>> listenersList = new ArrayList<ModelListener<PMReadMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PMReadMessage>)InstanceFactory.newInstance(
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
	private static final String _SQL_SELECT_PMREADMESSAGE = "SELECT pmReadMessage FROM PMReadMessage pmReadMessage";
	private static final String _SQL_SELECT_PMREADMESSAGE_WHERE = "SELECT pmReadMessage FROM PMReadMessage pmReadMessage WHERE ";
	private static final String _SQL_COUNT_PMREADMESSAGE = "SELECT COUNT(pmReadMessage) FROM PMReadMessage pmReadMessage";
	private static final String _SQL_COUNT_PMREADMESSAGE_WHERE = "SELECT COUNT(pmReadMessage) FROM PMReadMessage pmReadMessage WHERE ";
	private static final String _FINDER_COLUMN_MESSAGEID_MESSAGEID_2 = "pmReadMessage.messageId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pmReadMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PMReadMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PMReadMessage exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(PMReadMessagePersistenceImpl.class);
}