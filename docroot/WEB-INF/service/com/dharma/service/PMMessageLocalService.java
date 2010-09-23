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

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the p m message local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link PMMessageLocalServiceUtil} to access the p m message local service. Add custom service methods to {@link com.dharma.service.impl.PMMessageLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMMessageLocalServiceUtil
 * @see com.dharma.service.base.PMMessageLocalServiceBaseImpl
 * @see com.dharma.service.impl.PMMessageLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PMMessageLocalService {
	/**
	* Adds the p m message to the database. Also notifies the appropriate model listeners.
	*
	* @param pmMessage the p m message to add
	* @return the p m message that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMMessage addPMMessage(
		com.dharma.model.PMMessage pmMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new p m message with the primary key. Does not add the p m message to the database.
	*
	* @param messageId the primary key for the new p m message
	* @return the new p m message
	*/
	public com.dharma.model.PMMessage createPMMessage(long messageId);

	/**
	* Deletes the p m message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the p m message to delete
	* @throws PortalException if a p m message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deletePMMessage(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the p m message from the database. Also notifies the appropriate model listeners.
	*
	* @param pmMessage the p m message to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deletePMMessage(com.dharma.model.PMMessage pmMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the p m message with the primary key.
	*
	* @param messageId the primary key of the p m message to get
	* @return the p m message
	* @throws PortalException if a p m message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.dharma.model.PMMessage getPMMessage(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the p m messages.
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.dharma.model.PMMessage> getPMMessages(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of p m messages.
	*
	* @return the number of p m messages
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPMMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the p m message in the database. Also notifies the appropriate model listeners.
	*
	* @param pmMessage the p m message to update
	* @return the p m message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMMessage updatePMMessage(
		com.dharma.model.PMMessage pmMessage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the p m message in the database. Also notifies the appropriate model listeners.
	*
	* @param pmMessage the p m message to update
	* @param merge whether to merge the p m message with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the p m message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMMessage updatePMMessage(
		com.dharma.model.PMMessage pmMessage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUnreadCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.dharma.model.PMMessage> getInboxMessages(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.dharma.model.PMMessage> getOutboxMessages(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException;
}