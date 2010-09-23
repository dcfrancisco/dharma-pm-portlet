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

package com.dharma.service;

/**
 * <p>
 * This class is a wrapper for {@link PMReadMessageLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PMReadMessageLocalService
 * @generated
 */
public class PMReadMessageLocalServiceWrapper
	implements PMReadMessageLocalService {
	public PMReadMessageLocalServiceWrapper(
		PMReadMessageLocalService pmReadMessageLocalService) {
		_pmReadMessageLocalService = pmReadMessageLocalService;
	}

	/**
	* Adds the p m read message to the database. Also notifies the appropriate model listeners.
	*
	* @param pmReadMessage the p m read message to add
	* @return the p m read message that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMReadMessage addPMReadMessage(
		com.dharma.model.PMReadMessage pmReadMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmReadMessageLocalService.addPMReadMessage(pmReadMessage);
	}

	/**
	* Creates a new p m read message with the primary key. Does not add the p m read message to the database.
	*
	* @param readMessageId the primary key for the new p m read message
	* @return the new p m read message
	*/
	public com.dharma.model.PMReadMessage createPMReadMessage(
		long readMessageId) {
		return _pmReadMessageLocalService.createPMReadMessage(readMessageId);
	}

	/**
	* Deletes the p m read message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param readMessageId the primary key of the p m read message to delete
	* @throws PortalException if a p m read message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deletePMReadMessage(long readMessageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pmReadMessageLocalService.deletePMReadMessage(readMessageId);
	}

	/**
	* Deletes the p m read message from the database. Also notifies the appropriate model listeners.
	*
	* @param pmReadMessage the p m read message to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deletePMReadMessage(
		com.dharma.model.PMReadMessage pmReadMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		_pmReadMessageLocalService.deletePMReadMessage(pmReadMessage);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmReadMessageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _pmReadMessageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmReadMessageLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmReadMessageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the p m read message with the primary key.
	*
	* @param readMessageId the primary key of the p m read message to get
	* @return the p m read message
	* @throws PortalException if a p m read message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMReadMessage getPMReadMessage(long readMessageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pmReadMessageLocalService.getPMReadMessage(readMessageId);
	}

	/**
	* Gets a range of all the p m read messages.
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
	public java.util.List<com.dharma.model.PMReadMessage> getPMReadMessages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmReadMessageLocalService.getPMReadMessages(start, end);
	}

	/**
	* Gets the number of p m read messages.
	*
	* @return the number of p m read messages
	* @throws SystemException if a system exception occurred
	*/
	public int getPMReadMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmReadMessageLocalService.getPMReadMessagesCount();
	}

	/**
	* Updates the p m read message in the database. Also notifies the appropriate model listeners.
	*
	* @param pmReadMessage the p m read message to update
	* @return the p m read message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMReadMessage updatePMReadMessage(
		com.dharma.model.PMReadMessage pmReadMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmReadMessageLocalService.updatePMReadMessage(pmReadMessage);
	}

	/**
	* Updates the p m read message in the database. Also notifies the appropriate model listeners.
	*
	* @param pmReadMessage the p m read message to update
	* @param merge whether to merge the p m read message with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the p m read message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMReadMessage updatePMReadMessage(
		com.dharma.model.PMReadMessage pmReadMessage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmReadMessageLocalService.updatePMReadMessage(pmReadMessage,
			merge);
	}

	public boolean isMessageUnread(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmReadMessageLocalService.isMessageUnread(messageId);
	}

	public PMReadMessageLocalService getWrappedPMReadMessageLocalService() {
		return _pmReadMessageLocalService;
	}

	private PMReadMessageLocalService _pmReadMessageLocalService;
}