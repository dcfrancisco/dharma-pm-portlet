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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the p m deleted message local service. This utility wraps {@link com.dharma.service.impl.PMDeletedMessageLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.dharma.service.impl.PMDeletedMessageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMDeletedMessageLocalService
 * @see com.dharma.service.base.PMDeletedMessageLocalServiceBaseImpl
 * @see com.dharma.service.impl.PMDeletedMessageLocalServiceImpl
 * @generated
 */
public class PMDeletedMessageLocalServiceUtil {
	/**
	* Adds the p m deleted message to the database. Also notifies the appropriate model listeners.
	*
	* @param pmDeletedMessage the p m deleted message to add
	* @return the p m deleted message that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMDeletedMessage addPMDeletedMessage(
		com.dharma.model.PMDeletedMessage pmDeletedMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPMDeletedMessage(pmDeletedMessage);
	}

	/**
	* Creates a new p m deleted message with the primary key. Does not add the p m deleted message to the database.
	*
	* @param deletedMessageId the primary key for the new p m deleted message
	* @return the new p m deleted message
	*/
	public static com.dharma.model.PMDeletedMessage createPMDeletedMessage(
		long deletedMessageId) {
		return getService().createPMDeletedMessage(deletedMessageId);
	}

	/**
	* Deletes the p m deleted message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param deletedMessageId the primary key of the p m deleted message to delete
	* @throws PortalException if a p m deleted message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePMDeletedMessage(long deletedMessageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deletePMDeletedMessage(deletedMessageId);
	}

	/**
	* Deletes the p m deleted message from the database. Also notifies the appropriate model listeners.
	*
	* @param pmDeletedMessage the p m deleted message to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deletePMDeletedMessage(
		com.dharma.model.PMDeletedMessage pmDeletedMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deletePMDeletedMessage(pmDeletedMessage);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the p m deleted message with the primary key.
	*
	* @param deletedMessageId the primary key of the p m deleted message to get
	* @return the p m deleted message
	* @throws PortalException if a p m deleted message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMDeletedMessage getPMDeletedMessage(
		long deletedMessageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPMDeletedMessage(deletedMessageId);
	}

	/**
	* Gets a range of all the p m deleted messages.
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
	public static java.util.List<com.dharma.model.PMDeletedMessage> getPMDeletedMessages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPMDeletedMessages(start, end);
	}

	/**
	* Gets the number of p m deleted messages.
	*
	* @return the number of p m deleted messages
	* @throws SystemException if a system exception occurred
	*/
	public static int getPMDeletedMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPMDeletedMessagesCount();
	}

	/**
	* Updates the p m deleted message in the database. Also notifies the appropriate model listeners.
	*
	* @param pmDeletedMessage the p m deleted message to update
	* @return the p m deleted message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMDeletedMessage updatePMDeletedMessage(
		com.dharma.model.PMDeletedMessage pmDeletedMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePMDeletedMessage(pmDeletedMessage);
	}

	/**
	* Updates the p m deleted message in the database. Also notifies the appropriate model listeners.
	*
	* @param pmDeletedMessage the p m deleted message to update
	* @param merge whether to merge the p m deleted message with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the p m deleted message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.dharma.model.PMDeletedMessage updatePMDeletedMessage(
		com.dharma.model.PMDeletedMessage pmDeletedMessage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePMDeletedMessage(pmDeletedMessage, merge);
	}

	public static boolean isDeleted(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isDeleted(messageId);
	}

	public static java.util.List<com.dharma.model.PMDeletedMessage> findByOwnerId(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByOwnerId(ownerId);
	}

	public static java.util.List<com.dharma.model.PMDeletedMessage> findByMessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMessageId(messageId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PMDeletedMessageLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					PMDeletedMessageLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new PMDeletedMessageLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(PMDeletedMessageLocalService service) {
		_service = service;
	}

	private static PMDeletedMessageLocalService _service;
}