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

package com.dharma.model;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PMBlockedUser service. Represents a row in the &quot;blocked_user&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.dharma.model.impl.PMBlockedUserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.dharma.model.impl.PMBlockedUserImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a p m blocked user model instance should use the {@link PMBlockedUser} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PMBlockedUser
 * @see com.dharma.model.impl.PMBlockedUserImpl
 * @see com.dharma.model.impl.PMBlockedUserModelImpl
 * @generated
 */
public interface PMBlockedUserModel extends BaseModel<PMBlockedUser> {
	/**
	 * Gets the primary key of this p m blocked user.
	 *
	 * @return the primary key of this p m blocked user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this p m blocked user
	 *
	 * @param pk the primary key of this p m blocked user
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the blocked user id of this p m blocked user.
	 *
	 * @return the blocked user id of this p m blocked user
	 */
	public long getBlockedUserId();

	/**
	 * Sets the blocked user id of this p m blocked user.
	 *
	 * @param blockedUserId the blocked user id of this p m blocked user
	 */
	public void setBlockedUserId(long blockedUserId);

	/**
	 * Gets the blocked user uuid of this p m blocked user.
	 *
	 * @return the blocked user uuid of this p m blocked user
	 * @throws SystemException if a system exception occurred
	 */
	public String getBlockedUserUuid() throws SystemException;

	/**
	 * Sets the blocked user uuid of this p m blocked user.
	 *
	 * @param blockedUserUuid the blocked user uuid of this p m blocked user
	 */
	public void setBlockedUserUuid(String blockedUserUuid);

	/**
	 * Gets the owner id of this p m blocked user.
	 *
	 * @return the owner id of this p m blocked user
	 */
	public long getOwnerId();

	/**
	 * Sets the owner id of this p m blocked user.
	 *
	 * @param ownerId the owner id of this p m blocked user
	 */
	public void setOwnerId(long ownerId);

	/**
	 * Gets the user id of this p m blocked user.
	 *
	 * @return the user id of this p m blocked user
	 */
	public long getUserId();

	/**
	 * Sets the user id of this p m blocked user.
	 *
	 * @param userId the user id of this p m blocked user
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this p m blocked user.
	 *
	 * @return the user uuid of this p m blocked user
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this p m blocked user.
	 *
	 * @param userUuid the user uuid of this p m blocked user
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the blocked date of this p m blocked user.
	 *
	 * @return the blocked date of this p m blocked user
	 */
	public Date getBlockedDate();

	/**
	 * Sets the blocked date of this p m blocked user.
	 *
	 * @param blockedDate the blocked date of this p m blocked user
	 */
	public void setBlockedDate(Date blockedDate);

	/**
	 * Gets a copy of this p m blocked user as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public PMBlockedUser toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(PMBlockedUser pmBlockedUser);

	public int hashCode();

	public String toString();

	public String toXmlString();
}