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

package com.dharma.service.base;

import com.dharma.model.PMReadMessage;

import com.dharma.service.PMBlockedUserLocalService;
import com.dharma.service.PMDeletedMessageLocalService;
import com.dharma.service.PMMessageLocalService;
import com.dharma.service.PMReadMessageLocalService;
import com.dharma.service.persistence.PMBlockedUserPersistence;
import com.dharma.service.persistence.PMDeletedMessagePersistence;
import com.dharma.service.persistence.PMMessagePersistence;
import com.dharma.service.persistence.PMReadMessagePersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the p m read message local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.dharma.service.impl.PMReadMessageLocalServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link com.dharma.service.PMReadMessageLocalServiceUtil} to access the p m read message local service.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dharma.service.impl.PMReadMessageLocalServiceImpl
 * @see com.dharma.service.PMReadMessageLocalServiceUtil
 * @generated
 */
public abstract class PMReadMessageLocalServiceBaseImpl
	implements PMReadMessageLocalService {
	/**
	 * Adds the p m read message to the database. Also notifies the appropriate model listeners.
	 *
	 * @param pmReadMessage the p m read message to add
	 * @return the p m read message that was added
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage addPMReadMessage(PMReadMessage pmReadMessage)
		throws SystemException {
		pmReadMessage.setNew(true);

		return pmReadMessagePersistence.update(pmReadMessage, false);
	}

	/**
	 * Creates a new p m read message with the primary key. Does not add the p m read message to the database.
	 *
	 * @param readMessageId the primary key for the new p m read message
	 * @return the new p m read message
	 */
	public PMReadMessage createPMReadMessage(long readMessageId) {
		return pmReadMessagePersistence.create(readMessageId);
	}

	/**
	 * Deletes the p m read message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param readMessageId the primary key of the p m read message to delete
	 * @throws PortalException if a p m read message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deletePMReadMessage(long readMessageId)
		throws PortalException, SystemException {
		pmReadMessagePersistence.remove(readMessageId);
	}

	/**
	 * Deletes the p m read message from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pmReadMessage the p m read message to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deletePMReadMessage(PMReadMessage pmReadMessage)
		throws SystemException {
		pmReadMessagePersistence.remove(pmReadMessage);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return pmReadMessagePersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return pmReadMessagePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return pmReadMessagePersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return pmReadMessagePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the p m read message with the primary key.
	 *
	 * @param readMessageId the primary key of the p m read message to get
	 * @return the p m read message
	 * @throws PortalException if a p m read message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage getPMReadMessage(long readMessageId)
		throws PortalException, SystemException {
		return pmReadMessagePersistence.findByPrimaryKey(readMessageId);
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
	public List<PMReadMessage> getPMReadMessages(int start, int end)
		throws SystemException {
		return pmReadMessagePersistence.findAll(start, end);
	}

	/**
	 * Gets the number of p m read messages.
	 *
	 * @return the number of p m read messages
	 * @throws SystemException if a system exception occurred
	 */
	public int getPMReadMessagesCount() throws SystemException {
		return pmReadMessagePersistence.countAll();
	}

	/**
	 * Updates the p m read message in the database. Also notifies the appropriate model listeners.
	 *
	 * @param pmReadMessage the p m read message to update
	 * @return the p m read message that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage updatePMReadMessage(PMReadMessage pmReadMessage)
		throws SystemException {
		pmReadMessage.setNew(false);

		return pmReadMessagePersistence.update(pmReadMessage, true);
	}

	/**
	 * Updates the p m read message in the database. Also notifies the appropriate model listeners.
	 *
	 * @param pmReadMessage the p m read message to update
	 * @param merge whether to merge the p m read message with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the p m read message that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public PMReadMessage updatePMReadMessage(PMReadMessage pmReadMessage,
		boolean merge) throws SystemException {
		pmReadMessage.setNew(false);

		return pmReadMessagePersistence.update(pmReadMessage, merge);
	}

	/**
	 * Gets the p m message local service.
	 *
	 * @return the p m message local service
	 */
	public PMMessageLocalService getPMMessageLocalService() {
		return pmMessageLocalService;
	}

	/**
	 * Sets the p m message local service.
	 *
	 * @param pmMessageLocalService the p m message local service
	 */
	public void setPMMessageLocalService(
		PMMessageLocalService pmMessageLocalService) {
		this.pmMessageLocalService = pmMessageLocalService;
	}

	/**
	 * Gets the p m message persistence.
	 *
	 * @return the p m message persistence
	 */
	public PMMessagePersistence getPMMessagePersistence() {
		return pmMessagePersistence;
	}

	/**
	 * Sets the p m message persistence.
	 *
	 * @param pmMessagePersistence the p m message persistence
	 */
	public void setPMMessagePersistence(
		PMMessagePersistence pmMessagePersistence) {
		this.pmMessagePersistence = pmMessagePersistence;
	}

	/**
	 * Gets the p m deleted message local service.
	 *
	 * @return the p m deleted message local service
	 */
	public PMDeletedMessageLocalService getPMDeletedMessageLocalService() {
		return pmDeletedMessageLocalService;
	}

	/**
	 * Sets the p m deleted message local service.
	 *
	 * @param pmDeletedMessageLocalService the p m deleted message local service
	 */
	public void setPMDeletedMessageLocalService(
		PMDeletedMessageLocalService pmDeletedMessageLocalService) {
		this.pmDeletedMessageLocalService = pmDeletedMessageLocalService;
	}

	/**
	 * Gets the p m deleted message persistence.
	 *
	 * @return the p m deleted message persistence
	 */
	public PMDeletedMessagePersistence getPMDeletedMessagePersistence() {
		return pmDeletedMessagePersistence;
	}

	/**
	 * Sets the p m deleted message persistence.
	 *
	 * @param pmDeletedMessagePersistence the p m deleted message persistence
	 */
	public void setPMDeletedMessagePersistence(
		PMDeletedMessagePersistence pmDeletedMessagePersistence) {
		this.pmDeletedMessagePersistence = pmDeletedMessagePersistence;
	}

	/**
	 * Gets the p m read message local service.
	 *
	 * @return the p m read message local service
	 */
	public PMReadMessageLocalService getPMReadMessageLocalService() {
		return pmReadMessageLocalService;
	}

	/**
	 * Sets the p m read message local service.
	 *
	 * @param pmReadMessageLocalService the p m read message local service
	 */
	public void setPMReadMessageLocalService(
		PMReadMessageLocalService pmReadMessageLocalService) {
		this.pmReadMessageLocalService = pmReadMessageLocalService;
	}

	/**
	 * Gets the p m read message persistence.
	 *
	 * @return the p m read message persistence
	 */
	public PMReadMessagePersistence getPMReadMessagePersistence() {
		return pmReadMessagePersistence;
	}

	/**
	 * Sets the p m read message persistence.
	 *
	 * @param pmReadMessagePersistence the p m read message persistence
	 */
	public void setPMReadMessagePersistence(
		PMReadMessagePersistence pmReadMessagePersistence) {
		this.pmReadMessagePersistence = pmReadMessagePersistence;
	}

	/**
	 * Gets the p m blocked user local service.
	 *
	 * @return the p m blocked user local service
	 */
	public PMBlockedUserLocalService getPMBlockedUserLocalService() {
		return pmBlockedUserLocalService;
	}

	/**
	 * Sets the p m blocked user local service.
	 *
	 * @param pmBlockedUserLocalService the p m blocked user local service
	 */
	public void setPMBlockedUserLocalService(
		PMBlockedUserLocalService pmBlockedUserLocalService) {
		this.pmBlockedUserLocalService = pmBlockedUserLocalService;
	}

	/**
	 * Gets the p m blocked user persistence.
	 *
	 * @return the p m blocked user persistence
	 */
	public PMBlockedUserPersistence getPMBlockedUserPersistence() {
		return pmBlockedUserPersistence;
	}

	/**
	 * Sets the p m blocked user persistence.
	 *
	 * @param pmBlockedUserPersistence the p m blocked user persistence
	 */
	public void setPMBlockedUserPersistence(
		PMBlockedUserPersistence pmBlockedUserPersistence) {
		this.pmBlockedUserPersistence = pmBlockedUserPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = pmReadMessagePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = PMMessageLocalService.class)
	protected PMMessageLocalService pmMessageLocalService;
	@BeanReference(type = PMMessagePersistence.class)
	protected PMMessagePersistence pmMessagePersistence;
	@BeanReference(type = PMDeletedMessageLocalService.class)
	protected PMDeletedMessageLocalService pmDeletedMessageLocalService;
	@BeanReference(type = PMDeletedMessagePersistence.class)
	protected PMDeletedMessagePersistence pmDeletedMessagePersistence;
	@BeanReference(type = PMReadMessageLocalService.class)
	protected PMReadMessageLocalService pmReadMessageLocalService;
	@BeanReference(type = PMReadMessagePersistence.class)
	protected PMReadMessagePersistence pmReadMessagePersistence;
	@BeanReference(type = PMBlockedUserLocalService.class)
	protected PMBlockedUserLocalService pmBlockedUserLocalService;
	@BeanReference(type = PMBlockedUserPersistence.class)
	protected PMBlockedUserPersistence pmBlockedUserPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}