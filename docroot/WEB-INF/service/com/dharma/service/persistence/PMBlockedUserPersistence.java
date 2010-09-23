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

import com.dharma.model.PMBlockedUser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the p m blocked user service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link PMBlockedUserUtil} to access the p m blocked user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMBlockedUserPersistenceImpl
 * @see PMBlockedUserUtil
 * @generated
 */
public interface PMBlockedUserPersistence extends BasePersistence<PMBlockedUser> {
	/**
	* Caches the p m blocked user in the entity cache if it is enabled.
	*
	* @param pmBlockedUser the p m blocked user to cache
	*/
	public void cacheResult(com.dharma.model.PMBlockedUser pmBlockedUser);

	/**
	* Caches the p m blocked users in the entity cache if it is enabled.
	*
	* @param pmBlockedUsers the p m blocked users to cache
	*/
	public void cacheResult(
		java.util.List<com.dharma.model.PMBlockedUser> pmBlockedUsers);

	/**
	* Creates a new p m blocked user with the primary key. Does not add the p m blocked user to the database.
	*
	* @param blockedUserId the primary key for the new p m blocked user
	* @return the new p m blocked user
	*/
	public com.dharma.model.PMBlockedUser create(long blockedUserId);

	/**
	* Removes the p m blocked user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param blockedUserId the primary key of the p m blocked user to remove
	* @return the p m blocked user that was removed
	* @throws com.dharma.NoSuchPMBlockedUserException if a p m blocked user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMBlockedUser remove(long blockedUserId)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.dharma.model.PMBlockedUser updateImpl(
		com.dharma.model.PMBlockedUser pmBlockedUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the p m blocked user with the primary key or throws a {@link com.dharma.NoSuchPMBlockedUserException} if it could not be found.
	*
	* @param blockedUserId the primary key of the p m blocked user to find
	* @return the p m blocked user
	* @throws com.dharma.NoSuchPMBlockedUserException if a p m blocked user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMBlockedUser findByPrimaryKey(long blockedUserId)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the p m blocked user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param blockedUserId the primary key of the p m blocked user to find
	* @return the p m blocked user, or <code>null</code> if a p m blocked user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMBlockedUser fetchByPrimaryKey(long blockedUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p m blocked users where ownerId = &#63; and userId = &#63;.
	*
	* @param ownerId the owner id to search with
	* @param userId the user id to search with
	* @return the matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.dharma.model.PMBlockedUser> findByOwnerAndUser(
		long ownerId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMBlockedUser> findByOwnerAndUser(
		long ownerId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMBlockedUser> findByOwnerAndUser(
		long ownerId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMBlockedUser findByOwnerAndUser_First(
		long ownerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMBlockedUser findByOwnerAndUser_Last(
		long ownerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMBlockedUser[] findByOwnerAndUser_PrevAndNext(
		long blockedUserId, long ownerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p m blocked users where ownerId = &#63;.
	*
	* @param ownerId the owner id to search with
	* @return the matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.dharma.model.PMBlockedUser> findByOwner(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMBlockedUser> findByOwner(
		long ownerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMBlockedUser> findByOwner(
		long ownerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMBlockedUser findByOwner_First(long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMBlockedUser findByOwner_Last(long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMBlockedUser[] findByOwner_PrevAndNext(
		long blockedUserId, long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMBlockedUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p m blocked users.
	*
	* @return the p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.dharma.model.PMBlockedUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMBlockedUser> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMBlockedUser> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p m blocked users where ownerId = &#63; and userId = &#63; from the database.
	*
	* @param ownerId the owner id to search with
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOwnerAndUser(long ownerId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p m blocked users where ownerId = &#63; from the database.
	*
	* @param ownerId the owner id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOwner(long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p m blocked users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p m blocked users where ownerId = &#63; and userId = &#63;.
	*
	* @param ownerId the owner id to search with
	* @param userId the user id to search with
	* @return the number of matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public int countByOwnerAndUser(long ownerId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p m blocked users where ownerId = &#63;.
	*
	* @param ownerId the owner id to search with
	* @return the number of matching p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public int countByOwner(long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p m blocked users.
	*
	* @return the number of p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}