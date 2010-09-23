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

import com.dharma.model.PMDeletedMessage;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the p m deleted message service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link PMDeletedMessageUtil} to access the p m deleted message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMDeletedMessagePersistenceImpl
 * @see PMDeletedMessageUtil
 * @generated
 */
public interface PMDeletedMessagePersistence extends BasePersistence<PMDeletedMessage> {
	/**
	* Caches the p m deleted message in the entity cache if it is enabled.
	*
	* @param pmDeletedMessage the p m deleted message to cache
	*/
	public void cacheResult(com.dharma.model.PMDeletedMessage pmDeletedMessage);

	/**
	* Caches the p m deleted messages in the entity cache if it is enabled.
	*
	* @param pmDeletedMessages the p m deleted messages to cache
	*/
	public void cacheResult(
		java.util.List<com.dharma.model.PMDeletedMessage> pmDeletedMessages);

	/**
	* Creates a new p m deleted message with the primary key. Does not add the p m deleted message to the database.
	*
	* @param deletedMessageId the primary key for the new p m deleted message
	* @return the new p m deleted message
	*/
	public com.dharma.model.PMDeletedMessage create(long deletedMessageId);

	/**
	* Removes the p m deleted message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param deletedMessageId the primary key of the p m deleted message to remove
	* @return the p m deleted message that was removed
	* @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMDeletedMessage remove(long deletedMessageId)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.dharma.model.PMDeletedMessage updateImpl(
		com.dharma.model.PMDeletedMessage pmDeletedMessage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the p m deleted message with the primary key or throws a {@link com.dharma.NoSuchPMDeletedMessageException} if it could not be found.
	*
	* @param deletedMessageId the primary key of the p m deleted message to find
	* @return the p m deleted message
	* @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMDeletedMessage findByPrimaryKey(
		long deletedMessageId)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the p m deleted message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param deletedMessageId the primary key of the p m deleted message to find
	* @return the p m deleted message, or <code>null</code> if a p m deleted message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMDeletedMessage fetchByPrimaryKey(
		long deletedMessageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p m deleted messages where ownerId = &#63;.
	*
	* @param ownerId the owner id to search with
	* @return the matching p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.dharma.model.PMDeletedMessage> findByOwnerId(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMDeletedMessage> findByOwnerId(
		long ownerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMDeletedMessage> findByOwnerId(
		long ownerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMDeletedMessage findByOwnerId_First(long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMDeletedMessage findByOwnerId_Last(long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMDeletedMessage[] findByOwnerId_PrevAndNext(
		long deletedMessageId, long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p m deleted messages where messageId = &#63;.
	*
	* @param messageId the message id to search with
	* @return the matching p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.dharma.model.PMDeletedMessage> findByMessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMDeletedMessage> findByMessageId(
		long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMDeletedMessage> findByMessageId(
		long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMDeletedMessage findByMessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMDeletedMessage findByMessageId_Last(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMDeletedMessage[] findByMessageId_PrevAndNext(
		long deletedMessageId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p m deleted messages.
	*
	* @return the p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.dharma.model.PMDeletedMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMDeletedMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMDeletedMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p m deleted messages where ownerId = &#63; from the database.
	*
	* @param ownerId the owner id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOwnerId(long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p m deleted messages where messageId = &#63; from the database.
	*
	* @param messageId the message id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p m deleted messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p m deleted messages where ownerId = &#63;.
	*
	* @param ownerId the owner id to search with
	* @return the number of matching p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByOwnerId(long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p m deleted messages where messageId = &#63;.
	*
	* @param messageId the message id to search with
	* @return the number of matching p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p m deleted messages.
	*
	* @return the number of p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}