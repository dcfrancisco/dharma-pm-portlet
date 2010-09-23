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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the p m deleted message service. This utility wraps {@link PMDeletedMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMDeletedMessagePersistence
 * @see PMDeletedMessagePersistenceImpl
 * @generated
 */
public class PMDeletedMessageUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(PMDeletedMessage pmDeletedMessage) {
		getPersistence().clearCache(pmDeletedMessage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PMDeletedMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PMDeletedMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PMDeletedMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static PMDeletedMessage remove(PMDeletedMessage pmDeletedMessage)
		throws SystemException {
		return getPersistence().remove(pmDeletedMessage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PMDeletedMessage update(PMDeletedMessage pmDeletedMessage,
		boolean merge) throws SystemException {
		return getPersistence().update(pmDeletedMessage, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PMDeletedMessage update(PMDeletedMessage pmDeletedMessage,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(pmDeletedMessage, merge, serviceContext);
	}

	/**
	* Caches the p m deleted message in the entity cache if it is enabled.
	*
	* @param pmDeletedMessage the p m deleted message to cache
	*/
	public static void cacheResult(
		com.dharma.model.PMDeletedMessage pmDeletedMessage) {
		getPersistence().cacheResult(pmDeletedMessage);
	}

	/**
	* Caches the p m deleted messages in the entity cache if it is enabled.
	*
	* @param pmDeletedMessages the p m deleted messages to cache
	*/
	public static void cacheResult(
		java.util.List<com.dharma.model.PMDeletedMessage> pmDeletedMessages) {
		getPersistence().cacheResult(pmDeletedMessages);
	}

	/**
	* Creates a new p m deleted message with the primary key. Does not add the p m deleted message to the database.
	*
	* @param deletedMessageId the primary key for the new p m deleted message
	* @return the new p m deleted message
	*/
	public static com.dharma.model.PMDeletedMessage create(
		long deletedMessageId) {
		return getPersistence().create(deletedMessageId);
	}

	/**
	* Removes the p m deleted message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param deletedMessageId the primary key of the p m deleted message to remove
	* @return the p m deleted message that was removed
	* @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMDeletedMessage remove(
		long deletedMessageId)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(deletedMessageId);
	}

	public static com.dharma.model.PMDeletedMessage updateImpl(
		com.dharma.model.PMDeletedMessage pmDeletedMessage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(pmDeletedMessage, merge);
	}

	/**
	* Finds the p m deleted message with the primary key or throws a {@link com.dharma.NoSuchPMDeletedMessageException} if it could not be found.
	*
	* @param deletedMessageId the primary key of the p m deleted message to find
	* @return the p m deleted message
	* @throws com.dharma.NoSuchPMDeletedMessageException if a p m deleted message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMDeletedMessage findByPrimaryKey(
		long deletedMessageId)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(deletedMessageId);
	}

	/**
	* Finds the p m deleted message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param deletedMessageId the primary key of the p m deleted message to find
	* @return the p m deleted message, or <code>null</code> if a p m deleted message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMDeletedMessage fetchByPrimaryKey(
		long deletedMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(deletedMessageId);
	}

	/**
	* Finds all the p m deleted messages where ownerId = &#63;.
	*
	* @param ownerId the owner id to search with
	* @return the matching p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMDeletedMessage> findByOwnerId(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwnerId(ownerId);
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
	public static java.util.List<com.dharma.model.PMDeletedMessage> findByOwnerId(
		long ownerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwnerId(ownerId, start, end);
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
	public static java.util.List<com.dharma.model.PMDeletedMessage> findByOwnerId(
		long ownerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOwnerId(ownerId, start, end, orderByComparator);
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
	public static com.dharma.model.PMDeletedMessage findByOwnerId_First(
		long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwnerId_First(ownerId, orderByComparator);
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
	public static com.dharma.model.PMDeletedMessage findByOwnerId_Last(
		long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOwnerId_Last(ownerId, orderByComparator);
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
	public static com.dharma.model.PMDeletedMessage[] findByOwnerId_PrevAndNext(
		long deletedMessageId, long ownerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOwnerId_PrevAndNext(deletedMessageId, ownerId,
			orderByComparator);
	}

	/**
	* Finds all the p m deleted messages where messageId = &#63;.
	*
	* @param messageId the message id to search with
	* @return the matching p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMDeletedMessage> findByMessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMessageId(messageId);
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
	public static java.util.List<com.dharma.model.PMDeletedMessage> findByMessageId(
		long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMessageId(messageId, start, end);
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
	public static java.util.List<com.dharma.model.PMDeletedMessage> findByMessageId(
		long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId(messageId, start, end, orderByComparator);
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
	public static com.dharma.model.PMDeletedMessage findByMessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId_First(messageId, orderByComparator);
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
	public static com.dharma.model.PMDeletedMessage findByMessageId_Last(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId_Last(messageId, orderByComparator);
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
	public static com.dharma.model.PMDeletedMessage[] findByMessageId_PrevAndNext(
		long deletedMessageId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMDeletedMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId_PrevAndNext(deletedMessageId, messageId,
			orderByComparator);
	}

	/**
	* Finds all the p m deleted messages.
	*
	* @return the p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMDeletedMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.dharma.model.PMDeletedMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.dharma.model.PMDeletedMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p m deleted messages where ownerId = &#63; from the database.
	*
	* @param ownerId the owner id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOwnerId(long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOwnerId(ownerId);
	}

	/**
	* Removes all the p m deleted messages where messageId = &#63; from the database.
	*
	* @param messageId the message id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMessageId(messageId);
	}

	/**
	* Removes all the p m deleted messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the p m deleted messages where ownerId = &#63;.
	*
	* @param ownerId the owner id to search with
	* @return the number of matching p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOwnerId(long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOwnerId(ownerId);
	}

	/**
	* Counts all the p m deleted messages where messageId = &#63;.
	*
	* @param messageId the message id to search with
	* @return the number of matching p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMessageId(messageId);
	}

	/**
	* Counts all the p m deleted messages.
	*
	* @return the number of p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PMDeletedMessagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PMDeletedMessagePersistence)PortletBeanLocatorUtil.locate(com.dharma.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					PMDeletedMessagePersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(PMDeletedMessagePersistence persistence) {
		_persistence = persistence;
	}

	private static PMDeletedMessagePersistence _persistence;
}