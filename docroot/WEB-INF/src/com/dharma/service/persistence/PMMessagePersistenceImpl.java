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

import com.dharma.NoSuchPMMessageException;

import com.dharma.model.PMMessage;
import com.dharma.model.impl.PMMessageImpl;
import com.dharma.model.impl.PMMessageModelImpl;

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
 * The persistence implementation for the p m message service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link PMMessageUtil} to access the p m message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMMessagePersistence
 * @see PMMessageUtil
 * @generated
 */
public class PMMessagePersistenceImpl extends BasePersistenceImpl<PMMessage>
	implements PMMessagePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = PMMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_OWNERID = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByOwnerId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OWNERID = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByOwnerId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_PARENTMESSAGEID = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByParentMessageId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTMESSAGEID = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByParentMessageId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the p m message in the entity cache if it is enabled.
	 *
	 * @param pmMessage the p m message to cache
	 */
	public void cacheResult(PMMessage pmMessage) {
		EntityCacheUtil.putResult(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageImpl.class, pmMessage.getPrimaryKey(), pmMessage);
	}

	/**
	 * Caches the p m messages in the entity cache if it is enabled.
	 *
	 * @param pmMessages the p m messages to cache
	 */
	public void cacheResult(List<PMMessage> pmMessages) {
		for (PMMessage pmMessage : pmMessages) {
			if (EntityCacheUtil.getResult(
						PMMessageModelImpl.ENTITY_CACHE_ENABLED,
						PMMessageImpl.class, pmMessage.getPrimaryKey(), this) == null) {
				cacheResult(pmMessage);
			}
		}
	}

	/**
	 * Clears the cache for all p m messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(PMMessageImpl.class.getName());
		EntityCacheUtil.clearCache(PMMessageImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the p m message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(PMMessage pmMessage) {
		EntityCacheUtil.removeResult(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageImpl.class, pmMessage.getPrimaryKey());
	}

	/**
	 * Creates a new p m message with the primary key. Does not add the p m message to the database.
	 *
	 * @param messageId the primary key for the new p m message
	 * @return the new p m message
	 */
	public PMMessage create(long messageId) {
		PMMessage pmMessage = new PMMessageImpl();

		pmMessage.setNew(true);
		pmMessage.setPrimaryKey(messageId);

		return pmMessage;
	}

	/**
	 * Removes the p m message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p m message to remove
	 * @return the p m message that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the p m message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the p m message to remove
	 * @return the p m message that was removed
	 * @throws com.dharma.NoSuchPMMessageException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage remove(long messageId)
		throws NoSuchPMMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PMMessage pmMessage = (PMMessage)session.get(PMMessageImpl.class,
					new Long(messageId));

			if (pmMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + messageId);
				}

				throw new NoSuchPMMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					messageId);
			}

			return remove(pmMessage);
		}
		catch (NoSuchPMMessageException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMMessage removeImpl(PMMessage pmMessage)
		throws SystemException {
		pmMessage = toUnwrappedModel(pmMessage);

		Session session = null;

		try {
			session = openSession();

			if (pmMessage.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(PMMessageImpl.class,
						pmMessage.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(pmMessage);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageImpl.class, pmMessage.getPrimaryKey());

		return pmMessage;
	}

	public PMMessage updateImpl(com.dharma.model.PMMessage pmMessage,
		boolean merge) throws SystemException {
		pmMessage = toUnwrappedModel(pmMessage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, pmMessage, merge);

			pmMessage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
			PMMessageImpl.class, pmMessage.getPrimaryKey(), pmMessage);

		return pmMessage;
	}

	protected PMMessage toUnwrappedModel(PMMessage pmMessage) {
		if (pmMessage instanceof PMMessageImpl) {
			return pmMessage;
		}

		PMMessageImpl pmMessageImpl = new PMMessageImpl();

		pmMessageImpl.setNew(pmMessage.isNew());
		pmMessageImpl.setPrimaryKey(pmMessage.getPrimaryKey());

		pmMessageImpl.setMessageId(pmMessage.getMessageId());
		pmMessageImpl.setSubject(pmMessage.getSubject());
		pmMessageImpl.setBody(pmMessage.getBody());
		pmMessageImpl.setParentMessageId(pmMessage.getParentMessageId());
		pmMessageImpl.setOwnerId(pmMessage.getOwnerId());
		pmMessageImpl.setOwnerName(pmMessage.getOwnerName());
		pmMessageImpl.setPostedDate(pmMessage.getPostedDate());
		pmMessageImpl.setRecepients(pmMessage.getRecepients());

		return pmMessageImpl;
	}

	/**
	 * Finds the p m message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m message to find
	 * @return the p m message
	 * @throws com.liferay.portal.NoSuchModelException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p m message with the primary key or throws a {@link com.dharma.NoSuchPMMessageException} if it could not be found.
	 *
	 * @param messageId the primary key of the p m message to find
	 * @return the p m message
	 * @throws com.dharma.NoSuchPMMessageException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage findByPrimaryKey(long messageId)
		throws NoSuchPMMessageException, SystemException {
		PMMessage pmMessage = fetchByPrimaryKey(messageId);

		if (pmMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + messageId);
			}

			throw new NoSuchPMMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				messageId);
		}

		return pmMessage;
	}

	/**
	 * Finds the p m message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m message to find
	 * @return the p m message, or <code>null</code> if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p m message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the p m message to find
	 * @return the p m message, or <code>null</code> if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage fetchByPrimaryKey(long messageId)
		throws SystemException {
		PMMessage pmMessage = (PMMessage)EntityCacheUtil.getResult(PMMessageModelImpl.ENTITY_CACHE_ENABLED,
				PMMessageImpl.class, messageId, this);

		if (pmMessage == null) {
			Session session = null;

			try {
				session = openSession();

				pmMessage = (PMMessage)session.get(PMMessageImpl.class,
						new Long(messageId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (pmMessage != null) {
					cacheResult(pmMessage);
				}

				closeSession(session);
			}
		}

		return pmMessage;
	}

	/**
	 * Finds all the p m messages where ownerId = &#63;.
	 *
	 * @param ownerId the owner id to search with
	 * @return the matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByOwnerId(long ownerId)
		throws SystemException {
		return findByOwnerId(ownerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p m messages where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param start the lower bound of the range of p m messages to return
	 * @param end the upper bound of the range of p m messages to return (not inclusive)
	 * @return the range of matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByOwnerId(long ownerId, int start, int end)
		throws SystemException {
		return findByOwnerId(ownerId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p m messages where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param start the lower bound of the range of p m messages to return
	 * @param end the upper bound of the range of p m messages to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByOwnerId(long ownerId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				ownerId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PMMessage> list = (List<PMMessage>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OWNERID,
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

				query.append(_SQL_SELECT_PMMESSAGE_WHERE);

				query.append(_FINDER_COLUMN_OWNERID_OWNERID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(PMMessageModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				list = (List<PMMessage>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<PMMessage>();
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
	 * Finds the first p m message in the ordered set where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p m message
	 * @throws com.dharma.NoSuchPMMessageException if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage findByOwnerId_First(long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		List<PMMessage> list = findByOwnerId(ownerId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ownerId=");
			msg.append(ownerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p m message in the ordered set where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p m message
	 * @throws com.dharma.NoSuchPMMessageException if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage findByOwnerId_Last(long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		int count = countByOwnerId(ownerId);

		List<PMMessage> list = findByOwnerId(ownerId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ownerId=");
			msg.append(ownerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p m messages before and after the current p m message in the ordered set where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the primary key of the current p m message
	 * @param ownerId the owner id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p m message
	 * @throws com.dharma.NoSuchPMMessageException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage[] findByOwnerId_PrevAndNext(long messageId, long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		PMMessage pmMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			PMMessage[] array = new PMMessageImpl[3];

			array[0] = getByOwnerId_PrevAndNext(session, pmMessage, ownerId,
					orderByComparator, true);

			array[1] = pmMessage;

			array[2] = getByOwnerId_PrevAndNext(session, pmMessage, ownerId,
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

	protected PMMessage getByOwnerId_PrevAndNext(Session session,
		PMMessage pmMessage, long ownerId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PMMESSAGE_WHERE);

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
			query.append(PMMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(pmMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PMMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the p m messages where parentMessageId = &#63;.
	 *
	 * @param parentMessageId the parent message id to search with
	 * @return the matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByParentMessageId(long parentMessageId)
		throws SystemException {
		return findByParentMessageId(parentMessageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p m messages where parentMessageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentMessageId the parent message id to search with
	 * @param start the lower bound of the range of p m messages to return
	 * @param end the upper bound of the range of p m messages to return (not inclusive)
	 * @return the range of matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByParentMessageId(long parentMessageId,
		int start, int end) throws SystemException {
		return findByParentMessageId(parentMessageId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p m messages where parentMessageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentMessageId the parent message id to search with
	 * @param start the lower bound of the range of p m messages to return
	 * @param end the upper bound of the range of p m messages to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findByParentMessageId(long parentMessageId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				parentMessageId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PMMessage> list = (List<PMMessage>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PARENTMESSAGEID,
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

				query.append(_SQL_SELECT_PMMESSAGE_WHERE);

				query.append(_FINDER_COLUMN_PARENTMESSAGEID_PARENTMESSAGEID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(PMMessageModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentMessageId);

				list = (List<PMMessage>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<PMMessage>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PARENTMESSAGEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first p m message in the ordered set where parentMessageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentMessageId the parent message id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p m message
	 * @throws com.dharma.NoSuchPMMessageException if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage findByParentMessageId_First(long parentMessageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		List<PMMessage> list = findByParentMessageId(parentMessageId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentMessageId=");
			msg.append(parentMessageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p m message in the ordered set where parentMessageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentMessageId the parent message id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p m message
	 * @throws com.dharma.NoSuchPMMessageException if a matching p m message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage findByParentMessageId_Last(long parentMessageId,
		OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		int count = countByParentMessageId(parentMessageId);

		List<PMMessage> list = findByParentMessageId(parentMessageId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentMessageId=");
			msg.append(parentMessageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p m messages before and after the current p m message in the ordered set where parentMessageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the primary key of the current p m message
	 * @param parentMessageId the parent message id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p m message
	 * @throws com.dharma.NoSuchPMMessageException if a p m message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMMessage[] findByParentMessageId_PrevAndNext(long messageId,
		long parentMessageId, OrderByComparator orderByComparator)
		throws NoSuchPMMessageException, SystemException {
		PMMessage pmMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			PMMessage[] array = new PMMessageImpl[3];

			array[0] = getByParentMessageId_PrevAndNext(session, pmMessage,
					parentMessageId, orderByComparator, true);

			array[1] = pmMessage;

			array[2] = getByParentMessageId_PrevAndNext(session, pmMessage,
					parentMessageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMMessage getByParentMessageId_PrevAndNext(Session session,
		PMMessage pmMessage, long parentMessageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PMMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_PARENTMESSAGEID_PARENTMESSAGEID_2);

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
			query.append(PMMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentMessageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(pmMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PMMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the p m messages.
	 *
	 * @return the p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p m messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m messages to return
	 * @param end the upper bound of the range of p m messages to return (not inclusive)
	 * @return the range of p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the p m messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m messages to return
	 * @param end the upper bound of the range of p m messages to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMMessage> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PMMessage> list = (List<PMMessage>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_PMMESSAGE);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_PMMESSAGE.concat(PMMessageModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PMMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PMMessage>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<PMMessage>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the p m messages where ownerId = &#63; from the database.
	 *
	 * @param ownerId the owner id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOwnerId(long ownerId) throws SystemException {
		for (PMMessage pmMessage : findByOwnerId(ownerId)) {
			remove(pmMessage);
		}
	}

	/**
	 * Removes all the p m messages where parentMessageId = &#63; from the database.
	 *
	 * @param parentMessageId the parent message id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentMessageId(long parentMessageId)
		throws SystemException {
		for (PMMessage pmMessage : findByParentMessageId(parentMessageId)) {
			remove(pmMessage);
		}
	}

	/**
	 * Removes all the p m messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PMMessage pmMessage : findAll()) {
			remove(pmMessage);
		}
	}

	/**
	 * Counts all the p m messages where ownerId = &#63;.
	 *
	 * @param ownerId the owner id to search with
	 * @return the number of matching p m messages
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

				query.append(_SQL_COUNT_PMMESSAGE_WHERE);

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
	 * Counts all the p m messages where parentMessageId = &#63;.
	 *
	 * @param parentMessageId the parent message id to search with
	 * @return the number of matching p m messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentMessageId(long parentMessageId)
		throws SystemException {
		Object[] finderArgs = new Object[] { parentMessageId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTMESSAGEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_PMMESSAGE_WHERE);

				query.append(_FINDER_COLUMN_PARENTMESSAGEID_PARENTMESSAGEID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentMessageId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTMESSAGEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the p m messages.
	 *
	 * @return the number of p m messages
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

				Query q = session.createQuery(_SQL_COUNT_PMMESSAGE);

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
	 * Initializes the p m message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.dharma.model.PMMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PMMessage>> listenersList = new ArrayList<ModelListener<PMMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PMMessage>)InstanceFactory.newInstance(
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
	private static final String _SQL_SELECT_PMMESSAGE = "SELECT pmMessage FROM PMMessage pmMessage";
	private static final String _SQL_SELECT_PMMESSAGE_WHERE = "SELECT pmMessage FROM PMMessage pmMessage WHERE ";
	private static final String _SQL_COUNT_PMMESSAGE = "SELECT COUNT(pmMessage) FROM PMMessage pmMessage";
	private static final String _SQL_COUNT_PMMESSAGE_WHERE = "SELECT COUNT(pmMessage) FROM PMMessage pmMessage WHERE ";
	private static final String _FINDER_COLUMN_OWNERID_OWNERID_2 = "pmMessage.ownerId = ?";
	private static final String _FINDER_COLUMN_PARENTMESSAGEID_PARENTMESSAGEID_2 =
		"pmMessage.parentMessageId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pmMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PMMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PMMessage exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(PMMessagePersistenceImpl.class);
}