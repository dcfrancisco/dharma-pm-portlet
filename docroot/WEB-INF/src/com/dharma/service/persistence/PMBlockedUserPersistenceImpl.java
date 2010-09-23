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

import com.dharma.NoSuchPMBlockedUserException;

import com.dharma.model.PMBlockedUser;
import com.dharma.model.impl.PMBlockedUserImpl;
import com.dharma.model.impl.PMBlockedUserModelImpl;

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
 * The persistence implementation for the p m blocked user service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link PMBlockedUserUtil} to access the p m blocked user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMBlockedUserPersistence
 * @see PMBlockedUserUtil
 * @generated
 */
public class PMBlockedUserPersistenceImpl extends BasePersistenceImpl<PMBlockedUser>
	implements PMBlockedUserPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = PMBlockedUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_OWNERANDUSER = new FinderPath(PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
			PMBlockedUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOwnerAndUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OWNERANDUSER = new FinderPath(PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
			PMBlockedUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOwnerAndUser",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OWNER = new FinderPath(PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
			PMBlockedUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByOwner",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_OWNER = new FinderPath(PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
			PMBlockedUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByOwner",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
			PMBlockedUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
			PMBlockedUserModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the p m blocked user in the entity cache if it is enabled.
	 *
	 * @param pmBlockedUser the p m blocked user to cache
	 */
	public void cacheResult(PMBlockedUser pmBlockedUser) {
		EntityCacheUtil.putResult(PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
			PMBlockedUserImpl.class, pmBlockedUser.getPrimaryKey(),
			pmBlockedUser);
	}

	/**
	 * Caches the p m blocked users in the entity cache if it is enabled.
	 *
	 * @param pmBlockedUsers the p m blocked users to cache
	 */
	public void cacheResult(List<PMBlockedUser> pmBlockedUsers) {
		for (PMBlockedUser pmBlockedUser : pmBlockedUsers) {
			if (EntityCacheUtil.getResult(
						PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
						PMBlockedUserImpl.class, pmBlockedUser.getPrimaryKey(),
						this) == null) {
				cacheResult(pmBlockedUser);
			}
		}
	}

	/**
	 * Clears the cache for all p m blocked users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(PMBlockedUserImpl.class.getName());
		EntityCacheUtil.clearCache(PMBlockedUserImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the p m blocked user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(PMBlockedUser pmBlockedUser) {
		EntityCacheUtil.removeResult(PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
			PMBlockedUserImpl.class, pmBlockedUser.getPrimaryKey());
	}

	/**
	 * Creates a new p m blocked user with the primary key. Does not add the p m blocked user to the database.
	 *
	 * @param blockedUserId the primary key for the new p m blocked user
	 * @return the new p m blocked user
	 */
	public PMBlockedUser create(long blockedUserId) {
		PMBlockedUser pmBlockedUser = new PMBlockedUserImpl();

		pmBlockedUser.setNew(true);
		pmBlockedUser.setPrimaryKey(blockedUserId);

		return pmBlockedUser;
	}

	/**
	 * Removes the p m blocked user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p m blocked user to remove
	 * @return the p m blocked user that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a p m blocked user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the p m blocked user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blockedUserId the primary key of the p m blocked user to remove
	 * @return the p m blocked user that was removed
	 * @throws com.dharma.NoSuchPMBlockedUserException if a p m blocked user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser remove(long blockedUserId)
		throws NoSuchPMBlockedUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PMBlockedUser pmBlockedUser = (PMBlockedUser)session.get(PMBlockedUserImpl.class,
					new Long(blockedUserId));

			if (pmBlockedUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + blockedUserId);
				}

				throw new NoSuchPMBlockedUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					blockedUserId);
			}

			return remove(pmBlockedUser);
		}
		catch (NoSuchPMBlockedUserException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMBlockedUser removeImpl(PMBlockedUser pmBlockedUser)
		throws SystemException {
		pmBlockedUser = toUnwrappedModel(pmBlockedUser);

		Session session = null;

		try {
			session = openSession();

			if (pmBlockedUser.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(PMBlockedUserImpl.class,
						pmBlockedUser.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(pmBlockedUser);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
			PMBlockedUserImpl.class, pmBlockedUser.getPrimaryKey());

		return pmBlockedUser;
	}

	public PMBlockedUser updateImpl(
		com.dharma.model.PMBlockedUser pmBlockedUser, boolean merge)
		throws SystemException {
		pmBlockedUser = toUnwrappedModel(pmBlockedUser);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, pmBlockedUser, merge);

			pmBlockedUser.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
			PMBlockedUserImpl.class, pmBlockedUser.getPrimaryKey(),
			pmBlockedUser);

		return pmBlockedUser;
	}

	protected PMBlockedUser toUnwrappedModel(PMBlockedUser pmBlockedUser) {
		if (pmBlockedUser instanceof PMBlockedUserImpl) {
			return pmBlockedUser;
		}

		PMBlockedUserImpl pmBlockedUserImpl = new PMBlockedUserImpl();

		pmBlockedUserImpl.setNew(pmBlockedUser.isNew());
		pmBlockedUserImpl.setPrimaryKey(pmBlockedUser.getPrimaryKey());

		pmBlockedUserImpl.setBlockedUserId(pmBlockedUser.getBlockedUserId());
		pmBlockedUserImpl.setOwnerId(pmBlockedUser.getOwnerId());
		pmBlockedUserImpl.setUserId(pmBlockedUser.getUserId());
		pmBlockedUserImpl.setBlockedDate(pmBlockedUser.getBlockedDate());

		return pmBlockedUserImpl;
	}

	/**
	 * Finds the p m blocked user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m blocked user to find
	 * @return the p m blocked user
	 * @throws com.liferay.portal.NoSuchModelException if a p m blocked user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p m blocked user with the primary key or throws a {@link com.dharma.NoSuchPMBlockedUserException} if it could not be found.
	 *
	 * @param blockedUserId the primary key of the p m blocked user to find
	 * @return the p m blocked user
	 * @throws com.dharma.NoSuchPMBlockedUserException if a p m blocked user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser findByPrimaryKey(long blockedUserId)
		throws NoSuchPMBlockedUserException, SystemException {
		PMBlockedUser pmBlockedUser = fetchByPrimaryKey(blockedUserId);

		if (pmBlockedUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + blockedUserId);
			}

			throw new NoSuchPMBlockedUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				blockedUserId);
		}

		return pmBlockedUser;
	}

	/**
	 * Finds the p m blocked user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p m blocked user to find
	 * @return the p m blocked user, or <code>null</code> if a p m blocked user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the p m blocked user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blockedUserId the primary key of the p m blocked user to find
	 * @return the p m blocked user, or <code>null</code> if a p m blocked user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser fetchByPrimaryKey(long blockedUserId)
		throws SystemException {
		PMBlockedUser pmBlockedUser = (PMBlockedUser)EntityCacheUtil.getResult(PMBlockedUserModelImpl.ENTITY_CACHE_ENABLED,
				PMBlockedUserImpl.class, blockedUserId, this);

		if (pmBlockedUser == null) {
			Session session = null;

			try {
				session = openSession();

				pmBlockedUser = (PMBlockedUser)session.get(PMBlockedUserImpl.class,
						new Long(blockedUserId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (pmBlockedUser != null) {
					cacheResult(pmBlockedUser);
				}

				closeSession(session);
			}
		}

		return pmBlockedUser;
	}

	/**
	 * Finds all the p m blocked users where ownerId = &#63; and userId = &#63;.
	 *
	 * @param ownerId the owner id to search with
	 * @param userId the user id to search with
	 * @return the matching p m blocked users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMBlockedUser> findByOwnerAndUser(long ownerId, long userId)
		throws SystemException {
		return findByOwnerAndUser(ownerId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p m blocked users where ownerId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of p m blocked users to return
	 * @param end the upper bound of the range of p m blocked users to return (not inclusive)
	 * @return the range of matching p m blocked users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMBlockedUser> findByOwnerAndUser(long ownerId, long userId,
		int start, int end) throws SystemException {
		return findByOwnerAndUser(ownerId, userId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p m blocked users where ownerId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of p m blocked users to return
	 * @param end the upper bound of the range of p m blocked users to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p m blocked users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMBlockedUser> findByOwnerAndUser(long ownerId, long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				ownerId, userId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PMBlockedUser> list = (List<PMBlockedUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OWNERANDUSER,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(4 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(4);
				}

				query.append(_SQL_SELECT_PMBLOCKEDUSER_WHERE);

				query.append(_FINDER_COLUMN_OWNERANDUSER_OWNERID_2);

				query.append(_FINDER_COLUMN_OWNERANDUSER_USERID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(PMBlockedUserModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(userId);

				list = (List<PMBlockedUser>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<PMBlockedUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OWNERANDUSER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first p m blocked user in the ordered set where ownerId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p m blocked user
	 * @throws com.dharma.NoSuchPMBlockedUserException if a matching p m blocked user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser findByOwnerAndUser_First(long ownerId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchPMBlockedUserException, SystemException {
		List<PMBlockedUser> list = findByOwnerAndUser(ownerId, userId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ownerId=");
			msg.append(ownerId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMBlockedUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p m blocked user in the ordered set where ownerId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p m blocked user
	 * @throws com.dharma.NoSuchPMBlockedUserException if a matching p m blocked user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser findByOwnerAndUser_Last(long ownerId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchPMBlockedUserException, SystemException {
		int count = countByOwnerAndUser(ownerId, userId);

		List<PMBlockedUser> list = findByOwnerAndUser(ownerId, userId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ownerId=");
			msg.append(ownerId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMBlockedUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p m blocked users before and after the current p m blocked user in the ordered set where ownerId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param blockedUserId the primary key of the current p m blocked user
	 * @param ownerId the owner id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p m blocked user
	 * @throws com.dharma.NoSuchPMBlockedUserException if a p m blocked user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser[] findByOwnerAndUser_PrevAndNext(long blockedUserId,
		long ownerId, long userId, OrderByComparator orderByComparator)
		throws NoSuchPMBlockedUserException, SystemException {
		PMBlockedUser pmBlockedUser = findByPrimaryKey(blockedUserId);

		Session session = null;

		try {
			session = openSession();

			PMBlockedUser[] array = new PMBlockedUserImpl[3];

			array[0] = getByOwnerAndUser_PrevAndNext(session, pmBlockedUser,
					ownerId, userId, orderByComparator, true);

			array[1] = pmBlockedUser;

			array[2] = getByOwnerAndUser_PrevAndNext(session, pmBlockedUser,
					ownerId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PMBlockedUser getByOwnerAndUser_PrevAndNext(Session session,
		PMBlockedUser pmBlockedUser, long ownerId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PMBLOCKEDUSER_WHERE);

		query.append(_FINDER_COLUMN_OWNERANDUSER_OWNERID_2);

		query.append(_FINDER_COLUMN_OWNERANDUSER_USERID_2);

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
			query.append(PMBlockedUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(pmBlockedUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PMBlockedUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the p m blocked users where ownerId = &#63;.
	 *
	 * @param ownerId the owner id to search with
	 * @return the matching p m blocked users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMBlockedUser> findByOwner(long ownerId)
		throws SystemException {
		return findByOwner(ownerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p m blocked users where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param start the lower bound of the range of p m blocked users to return
	 * @param end the upper bound of the range of p m blocked users to return (not inclusive)
	 * @return the range of matching p m blocked users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMBlockedUser> findByOwner(long ownerId, int start, int end)
		throws SystemException {
		return findByOwner(ownerId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the p m blocked users where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param start the lower bound of the range of p m blocked users to return
	 * @param end the upper bound of the range of p m blocked users to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching p m blocked users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMBlockedUser> findByOwner(long ownerId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				ownerId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PMBlockedUser> list = (List<PMBlockedUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OWNER,
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

				query.append(_SQL_SELECT_PMBLOCKEDUSER_WHERE);

				query.append(_FINDER_COLUMN_OWNER_OWNERID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(PMBlockedUserModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				list = (List<PMBlockedUser>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<PMBlockedUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OWNER,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first p m blocked user in the ordered set where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching p m blocked user
	 * @throws com.dharma.NoSuchPMBlockedUserException if a matching p m blocked user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser findByOwner_First(long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMBlockedUserException, SystemException {
		List<PMBlockedUser> list = findByOwner(ownerId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ownerId=");
			msg.append(ownerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMBlockedUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last p m blocked user in the ordered set where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching p m blocked user
	 * @throws com.dharma.NoSuchPMBlockedUserException if a matching p m blocked user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser findByOwner_Last(long ownerId,
		OrderByComparator orderByComparator)
		throws NoSuchPMBlockedUserException, SystemException {
		int count = countByOwner(ownerId);

		List<PMBlockedUser> list = findByOwner(ownerId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ownerId=");
			msg.append(ownerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPMBlockedUserException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the p m blocked users before and after the current p m blocked user in the ordered set where ownerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param blockedUserId the primary key of the current p m blocked user
	 * @param ownerId the owner id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next p m blocked user
	 * @throws com.dharma.NoSuchPMBlockedUserException if a p m blocked user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMBlockedUser[] findByOwner_PrevAndNext(long blockedUserId,
		long ownerId, OrderByComparator orderByComparator)
		throws NoSuchPMBlockedUserException, SystemException {
		PMBlockedUser pmBlockedUser = findByPrimaryKey(blockedUserId);

		Session session = null;

		try {
			session = openSession();

			PMBlockedUser[] array = new PMBlockedUserImpl[3];

			array[0] = getByOwner_PrevAndNext(session, pmBlockedUser, ownerId,
					orderByComparator, true);

			array[1] = pmBlockedUser;

			array[2] = getByOwner_PrevAndNext(session, pmBlockedUser, ownerId,
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

	protected PMBlockedUser getByOwner_PrevAndNext(Session session,
		PMBlockedUser pmBlockedUser, long ownerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PMBLOCKEDUSER_WHERE);

		query.append(_FINDER_COLUMN_OWNER_OWNERID_2);

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
			query.append(PMBlockedUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(pmBlockedUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PMBlockedUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the p m blocked users.
	 *
	 * @return the p m blocked users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMBlockedUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the p m blocked users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m blocked users to return
	 * @param end the upper bound of the range of p m blocked users to return (not inclusive)
	 * @return the range of p m blocked users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMBlockedUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the p m blocked users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of p m blocked users to return
	 * @param end the upper bound of the range of p m blocked users to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of p m blocked users
	 * @throws SystemException if a system exception occurred
	 */
	public List<PMBlockedUser> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<PMBlockedUser> list = (List<PMBlockedUser>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_PMBLOCKEDUSER);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_PMBLOCKEDUSER.concat(PMBlockedUserModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PMBlockedUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PMBlockedUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<PMBlockedUser>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the p m blocked users where ownerId = &#63; and userId = &#63; from the database.
	 *
	 * @param ownerId the owner id to search with
	 * @param userId the user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOwnerAndUser(long ownerId, long userId)
		throws SystemException {
		for (PMBlockedUser pmBlockedUser : findByOwnerAndUser(ownerId, userId)) {
			remove(pmBlockedUser);
		}
	}

	/**
	 * Removes all the p m blocked users where ownerId = &#63; from the database.
	 *
	 * @param ownerId the owner id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOwner(long ownerId) throws SystemException {
		for (PMBlockedUser pmBlockedUser : findByOwner(ownerId)) {
			remove(pmBlockedUser);
		}
	}

	/**
	 * Removes all the p m blocked users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PMBlockedUser pmBlockedUser : findAll()) {
			remove(pmBlockedUser);
		}
	}

	/**
	 * Counts all the p m blocked users where ownerId = &#63; and userId = &#63;.
	 *
	 * @param ownerId the owner id to search with
	 * @param userId the user id to search with
	 * @return the number of matching p m blocked users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOwnerAndUser(long ownerId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { ownerId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OWNERANDUSER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(3);

				query.append(_SQL_COUNT_PMBLOCKEDUSER_WHERE);

				query.append(_FINDER_COLUMN_OWNERANDUSER_OWNERID_2);

				query.append(_FINDER_COLUMN_OWNERANDUSER_USERID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OWNERANDUSER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the p m blocked users where ownerId = &#63;.
	 *
	 * @param ownerId the owner id to search with
	 * @return the number of matching p m blocked users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOwner(long ownerId) throws SystemException {
		Object[] finderArgs = new Object[] { ownerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OWNER,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_PMBLOCKEDUSER_WHERE);

				query.append(_FINDER_COLUMN_OWNER_OWNERID_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OWNER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the p m blocked users.
	 *
	 * @return the number of p m blocked users
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

				Query q = session.createQuery(_SQL_COUNT_PMBLOCKEDUSER);

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
	 * Initializes the p m blocked user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.dharma.model.PMBlockedUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PMBlockedUser>> listenersList = new ArrayList<ModelListener<PMBlockedUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PMBlockedUser>)InstanceFactory.newInstance(
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
	private static final String _SQL_SELECT_PMBLOCKEDUSER = "SELECT pmBlockedUser FROM PMBlockedUser pmBlockedUser";
	private static final String _SQL_SELECT_PMBLOCKEDUSER_WHERE = "SELECT pmBlockedUser FROM PMBlockedUser pmBlockedUser WHERE ";
	private static final String _SQL_COUNT_PMBLOCKEDUSER = "SELECT COUNT(pmBlockedUser) FROM PMBlockedUser pmBlockedUser";
	private static final String _SQL_COUNT_PMBLOCKEDUSER_WHERE = "SELECT COUNT(pmBlockedUser) FROM PMBlockedUser pmBlockedUser WHERE ";
	private static final String _FINDER_COLUMN_OWNERANDUSER_OWNERID_2 = "pmBlockedUser.ownerId = ? AND ";
	private static final String _FINDER_COLUMN_OWNERANDUSER_USERID_2 = "pmBlockedUser.userId = ?";
	private static final String _FINDER_COLUMN_OWNER_OWNERID_2 = "pmBlockedUser.ownerId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pmBlockedUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PMBlockedUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PMBlockedUser exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(PMBlockedUserPersistenceImpl.class);
}