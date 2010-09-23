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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the p m read message service. This utility wraps {@link PMReadMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see PMReadMessagePersistence
 * @see PMReadMessagePersistenceImpl
 * @generated
 */
public class PMReadMessageUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(PMReadMessage pmReadMessage) {
		getPersistence().clearCache(pmReadMessage);
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
	public static List<PMReadMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PMReadMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PMReadMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static PMReadMessage remove(PMReadMessage pmReadMessage)
		throws SystemException {
		return getPersistence().remove(pmReadMessage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PMReadMessage update(PMReadMessage pmReadMessage,
		boolean merge) throws SystemException {
		return getPersistence().update(pmReadMessage, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PMReadMessage update(PMReadMessage pmReadMessage,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(pmReadMessage, merge, serviceContext);
	}

	/**
	* Caches the p m read message in the entity cache if it is enabled.
	*
	* @param pmReadMessage the p m read message to cache
	*/
	public static void cacheResult(com.dharma.model.PMReadMessage pmReadMessage) {
		getPersistence().cacheResult(pmReadMessage);
	}

	/**
	* Caches the p m read messages in the entity cache if it is enabled.
	*
	* @param pmReadMessages the p m read messages to cache
	*/
	public static void cacheResult(
		java.util.List<com.dharma.model.PMReadMessage> pmReadMessages) {
		getPersistence().cacheResult(pmReadMessages);
	}

	/**
	* Creates a new p m read message with the primary key. Does not add the p m read message to the database.
	*
	* @param readMessageId the primary key for the new p m read message
	* @return the new p m read message
	*/
	public static com.dharma.model.PMReadMessage create(long readMessageId) {
		return getPersistence().create(readMessageId);
	}

	/**
	* Removes the p m read message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param readMessageId the primary key of the p m read message to remove
	* @return the p m read message that was removed
	* @throws com.dharma.NoSuchPMReadMessageException if a p m read message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMReadMessage remove(long readMessageId)
		throws com.dharma.NoSuchPMReadMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(readMessageId);
	}

	public static com.dharma.model.PMReadMessage updateImpl(
		com.dharma.model.PMReadMessage pmReadMessage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(pmReadMessage, merge);
	}

	/**
	* Finds the p m read message with the primary key or throws a {@link com.dharma.NoSuchPMReadMessageException} if it could not be found.
	*
	* @param readMessageId the primary key of the p m read message to find
	* @return the p m read message
	* @throws com.dharma.NoSuchPMReadMessageException if a p m read message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMReadMessage findByPrimaryKey(
		long readMessageId)
		throws com.dharma.NoSuchPMReadMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(readMessageId);
	}

	/**
	* Finds the p m read message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param readMessageId the primary key of the p m read message to find
	* @return the p m read message, or <code>null</code> if a p m read message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMReadMessage fetchByPrimaryKey(
		long readMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(readMessageId);
	}

	/**
	* Finds all the p m read messages where messageId = &#63;.
	*
	* @param messageId the message id to search with
	* @return the matching p m read messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMReadMessage> findByMessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMessageId(messageId);
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
	public static java.util.List<com.dharma.model.PMReadMessage> findByMessageId(
		long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMessageId(messageId, start, end);
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
	public static java.util.List<com.dharma.model.PMReadMessage> findByMessageId(
		long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId(messageId, start, end, orderByComparator);
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
	public static com.dharma.model.PMReadMessage findByMessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMReadMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId_First(messageId, orderByComparator);
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
	public static com.dharma.model.PMReadMessage findByMessageId_Last(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMReadMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId_Last(messageId, orderByComparator);
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
	public static com.dharma.model.PMReadMessage[] findByMessageId_PrevAndNext(
		long readMessageId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.dharma.NoSuchPMReadMessageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId_PrevAndNext(readMessageId, messageId,
			orderByComparator);
	}

	/**
	* Finds all the p m read messages.
	*
	* @return the p m read messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.dharma.model.PMReadMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.dharma.model.PMReadMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.dharma.model.PMReadMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p m read messages where messageId = &#63; from the database.
	*
	* @param messageId the message id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMessageId(messageId);
	}

	/**
	* Removes all the p m read messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the p m read messages where messageId = &#63;.
	*
	* @param messageId the message id to search with
	* @return the number of matching p m read messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMessageId(messageId);
	}

	/**
	* Counts all the p m read messages.
	*
	* @return the number of p m read messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PMReadMessagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PMReadMessagePersistence)PortletBeanLocatorUtil.locate(com.dharma.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					PMReadMessagePersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(PMReadMessagePersistence persistence) {
		_persistence = persistence;
	}

	private static PMReadMessagePersistence _persistence;
}