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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class PMBlockedUserClp extends BaseModelImpl<PMBlockedUser>
	implements PMBlockedUser {
	public PMBlockedUserClp() {
	}

	public long getPrimaryKey() {
		return _blockedUserId;
	}

	public void setPrimaryKey(long pk) {
		setBlockedUserId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_blockedUserId);
	}

	public long getBlockedUserId() {
		return _blockedUserId;
	}

	public void setBlockedUserId(long blockedUserId) {
		_blockedUserId = blockedUserId;
	}

	public String getBlockedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getBlockedUserId(), "uuid",
			_blockedUserUuid);
	}

	public void setBlockedUserUuid(String blockedUserUuid) {
		_blockedUserUuid = blockedUserUuid;
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getBlockedDate() {
		return _blockedDate;
	}

	public void setBlockedDate(Date blockedDate) {
		_blockedDate = blockedDate;
	}

	public PMBlockedUser toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (PMBlockedUser)Proxy.newProxyInstance(PMBlockedUser.class.getClassLoader(),
				new Class[] { PMBlockedUser.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		PMBlockedUserClp clone = new PMBlockedUserClp();

		clone.setBlockedUserId(getBlockedUserId());
		clone.setOwnerId(getOwnerId());
		clone.setUserId(getUserId());
		clone.setBlockedDate(getBlockedDate());

		return clone;
	}

	public int compareTo(PMBlockedUser pmBlockedUser) {
		int value = 0;

		value = DateUtil.compareTo(getBlockedDate(),
				pmBlockedUser.getBlockedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		PMBlockedUserClp pmBlockedUser = null;

		try {
			pmBlockedUser = (PMBlockedUserClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = pmBlockedUser.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{blockedUserId=");
		sb.append(getBlockedUserId());
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", blockedDate=");
		sb.append(getBlockedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.dharma.model.PMBlockedUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>blockedUserId</column-name><column-value><![CDATA[");
		sb.append(getBlockedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>blockedDate</column-name><column-value><![CDATA[");
		sb.append(getBlockedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _blockedUserId;
	private String _blockedUserUuid;
	private long _ownerId;
	private long _userId;
	private String _userUuid;
	private Date _blockedDate;
}