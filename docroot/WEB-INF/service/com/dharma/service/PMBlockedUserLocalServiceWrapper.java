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
 * This class is a wrapper for {@link PMBlockedUserLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PMBlockedUserLocalService
 * @generated
 */
public class PMBlockedUserLocalServiceWrapper
	implements PMBlockedUserLocalService {
	public PMBlockedUserLocalServiceWrapper(
		PMBlockedUserLocalService pmBlockedUserLocalService) {
		_pmBlockedUserLocalService = pmBlockedUserLocalService;
	}

	/**
	* Adds the p m blocked user to the database. Also notifies the appropriate model listeners.
	*
	* @param pmBlockedUser the p m blocked user to add
	* @return the p m blocked user that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMBlockedUser addPMBlockedUser(
		com.dharma.model.PMBlockedUser pmBlockedUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUserLocalService.addPMBlockedUser(pmBlockedUser);
	}

	/**
	* Creates a new p m blocked user with the primary key. Does not add the p m blocked user to the database.
	*
	* @param blockedUserId the primary key for the new p m blocked user
	* @return the new p m blocked user
	*/
	public com.dharma.model.PMBlockedUser createPMBlockedUser(
		long blockedUserId) {
		return _pmBlockedUserLocalService.createPMBlockedUser(blockedUserId);
	}

	/**
	* Deletes the p m blocked user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param blockedUserId the primary key of the p m blocked user to delete
	* @throws PortalException if a p m blocked user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deletePMBlockedUser(long blockedUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pmBlockedUserLocalService.deletePMBlockedUser(blockedUserId);
	}

	/**
	* Deletes the p m blocked user from the database. Also notifies the appropriate model listeners.
	*
	* @param pmBlockedUser the p m blocked user to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deletePMBlockedUser(
		com.dharma.model.PMBlockedUser pmBlockedUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		_pmBlockedUserLocalService.deletePMBlockedUser(pmBlockedUser);
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
		return _pmBlockedUserLocalService.dynamicQuery(dynamicQuery);
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
		return _pmBlockedUserLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _pmBlockedUserLocalService.dynamicQuery(dynamicQuery, start,
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
		return _pmBlockedUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the p m blocked user with the primary key.
	*
	* @param blockedUserId the primary key of the p m blocked user to get
	* @return the p m blocked user
	* @throws PortalException if a p m blocked user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMBlockedUser getPMBlockedUser(long blockedUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUserLocalService.getPMBlockedUser(blockedUserId);
	}

	/**
	* Gets a range of all the p m blocked users.
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
	public java.util.List<com.dharma.model.PMBlockedUser> getPMBlockedUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUserLocalService.getPMBlockedUsers(start, end);
	}

	/**
	* Gets the number of p m blocked users.
	*
	* @return the number of p m blocked users
	* @throws SystemException if a system exception occurred
	*/
	public int getPMBlockedUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUserLocalService.getPMBlockedUsersCount();
	}

	/**
	* Updates the p m blocked user in the database. Also notifies the appropriate model listeners.
	*
	* @param pmBlockedUser the p m blocked user to update
	* @return the p m blocked user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMBlockedUser updatePMBlockedUser(
		com.dharma.model.PMBlockedUser pmBlockedUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUserLocalService.updatePMBlockedUser(pmBlockedUser);
	}

	/**
	* Updates the p m blocked user in the database. Also notifies the appropriate model listeners.
	*
	* @param pmBlockedUser the p m blocked user to update
	* @param merge whether to merge the p m blocked user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the p m blocked user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.dharma.model.PMBlockedUser updatePMBlockedUser(
		com.dharma.model.PMBlockedUser pmBlockedUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUserLocalService.updatePMBlockedUser(pmBlockedUser,
			merge);
	}

	public boolean isUserBlocked(long ownerId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUserLocalService.isUserBlocked(ownerId, userId);
	}

	public java.util.List<com.dharma.model.PMBlockedUser> getBlockedUsers(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUserLocalService.getBlockedUsers(ownerId);
	}

	public PMBlockedUserLocalService getWrappedPMBlockedUserLocalService() {
		return _pmBlockedUserLocalService;
	}

	private PMBlockedUserLocalService _pmBlockedUserLocalService;
}