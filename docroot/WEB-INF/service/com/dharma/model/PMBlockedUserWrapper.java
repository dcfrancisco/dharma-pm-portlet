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

/**
 * <p>
 * This class is a wrapper for {@link PMBlockedUser}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PMBlockedUser
 * @generated
 */
public class PMBlockedUserWrapper implements PMBlockedUser {
	public PMBlockedUserWrapper(PMBlockedUser pmBlockedUser) {
		_pmBlockedUser = pmBlockedUser;
	}

	public long getPrimaryKey() {
		return _pmBlockedUser.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_pmBlockedUser.setPrimaryKey(pk);
	}

	public long getBlockedUserId() {
		return _pmBlockedUser.getBlockedUserId();
	}

	public void setBlockedUserId(long blockedUserId) {
		_pmBlockedUser.setBlockedUserId(blockedUserId);
	}

	public java.lang.String getBlockedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUser.getBlockedUserUuid();
	}

	public void setBlockedUserUuid(java.lang.String blockedUserUuid) {
		_pmBlockedUser.setBlockedUserUuid(blockedUserUuid);
	}

	public long getOwnerId() {
		return _pmBlockedUser.getOwnerId();
	}

	public void setOwnerId(long ownerId) {
		_pmBlockedUser.setOwnerId(ownerId);
	}

	public long getUserId() {
		return _pmBlockedUser.getUserId();
	}

	public void setUserId(long userId) {
		_pmBlockedUser.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pmBlockedUser.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_pmBlockedUser.setUserUuid(userUuid);
	}

	public java.util.Date getBlockedDate() {
		return _pmBlockedUser.getBlockedDate();
	}

	public void setBlockedDate(java.util.Date blockedDate) {
		_pmBlockedUser.setBlockedDate(blockedDate);
	}

	public com.dharma.model.PMBlockedUser toEscapedModel() {
		return _pmBlockedUser.toEscapedModel();
	}

	public boolean isNew() {
		return _pmBlockedUser.isNew();
	}

	public void setNew(boolean n) {
		_pmBlockedUser.setNew(n);
	}

	public boolean isCachedModel() {
		return _pmBlockedUser.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pmBlockedUser.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pmBlockedUser.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_pmBlockedUser.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pmBlockedUser.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pmBlockedUser.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pmBlockedUser.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _pmBlockedUser.clone();
	}

	public int compareTo(com.dharma.model.PMBlockedUser pmBlockedUser) {
		return _pmBlockedUser.compareTo(pmBlockedUser);
	}

	public int hashCode() {
		return _pmBlockedUser.hashCode();
	}

	public java.lang.String toString() {
		return _pmBlockedUser.toString();
	}

	public java.lang.String toXmlString() {
		return _pmBlockedUser.toXmlString();
	}

	public PMBlockedUser getWrappedPMBlockedUser() {
		return _pmBlockedUser;
	}

	private PMBlockedUser _pmBlockedUser;
}