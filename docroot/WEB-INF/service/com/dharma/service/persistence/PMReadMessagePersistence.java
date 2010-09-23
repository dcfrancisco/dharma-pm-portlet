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

import com.dharma.model.PMReadMessage;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the p m read message service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link PMReadMessageUtil} to access the p m read message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMReadMessagePersistenceImpl
 * @see PMReadMessageUtil
 * @generated
 */
public interface PMReadMessagePersistence extends BasePersistence<PMReadMessage> {
	/**
	* Caches the p m read message in the entity cache if it is enabled.
	*
	* @param pmReadMessage the p m read message to cache
	*/
	public void cacheResult(com.dharma.model.PMReadMessage pmReadMessage);

	/**
	* Caches the p m read messages in the entity cache if it is enabled.
	*
	* @param pmReadMessages the p m read messages to cache
	*/
	public void cacheResult(
		java.util.List<com.dharma.model.PMReadMessage> pmReadMessages);

	/**
	* Creates a new p m read message with the primary key. Does not add the p m read message to the database.
	*
	* @param readMessageId the primary key for the new p m read message
	* @return the new p m read message
	*/
	public com.dharma.model.PMReadMessage create(long readMessageId);

	/**
	* Removes the p m read message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param readMessageId the primary key of the p m read message to remove
	* @return the p m read message that was removed
	* @throws com.dharma.NoSuchPMReadMessageException if a p m read message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMReadMessage remove(long readMessageId)
		throws com.dharma.NoSuchPMReadMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.dharma.model.PMReadMessage updateImpl(
		com.dharma.model.PMReadMessage pmReadMessage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the p m read message with the primary key or throws a {@link com.dharma.NoSuchPMReadMessageException} if it could not be found.
	*
	* @param readMessageId the primary key of the p m read message to find
	* @return the p m read message
	* @throws com.dharma.NoSuchPMReadMessageException if a p m read message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMReadMessage findByPrimaryKey(long readMessageId)
		throws com.dharma.NoSuchPMReadMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the p m read message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param readMessageId the primary key of the p m read message to find
	* @return the p m read message, or <code>null</code> if a p m read message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMReadMessage fetchByPrimaryKey(long readMessageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p m read messages where messageId = &#63;.
	*
	* @param messageId the message id to search with
	* @return the matching p m read messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.dharma.model.PMReadMessage> findByMessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMReadMessage> findByMessageId(
		long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMReadMessage> findByMessageId(
		long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMReadMessage findByMessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMReadMessageException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMReadMessage findByMessageId_Last(long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMReadMessageException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.dharma.model.PMReadMessage[] findByMessageId_PrevAndNext(
		long readMessageId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMReadMessageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the p m read messages.
	*
	* @return the p m read messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.dharma.model.PMReadMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMReadMessage> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.dharma.model.PMReadMessage> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p m read messages where messageId = &#63; from the database.
	*
	* @param messageId the message id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p m read messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p m read messages where messageId = &#63;.
	*
	* @param messageId the message id to search with
	* @return the number of matching p m read messages
	* @throws SystemException if a system exception occurred
	*/
	public int countByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the p m read messages.
	*
	* @return the number of p m read messages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}