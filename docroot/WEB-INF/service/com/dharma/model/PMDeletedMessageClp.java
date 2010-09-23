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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class PMDeletedMessageClp extends BaseModelImpl<PMDeletedMessage>
	implements PMDeletedMessage {
	public PMDeletedMessageClp() {
	}

	public long getPrimaryKey() {
		return _deletedMessageId;
	}

	public void setPrimaryKey(long pk) {
		setDeletedMessageId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_deletedMessageId);
	}

	public long getDeletedMessageId() {
		return _deletedMessageId;
	}

	public void setDeletedMessageId(long deletedMessageId) {
		_deletedMessageId = deletedMessageId;
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public Date getDeletedDate() {
		return _deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		_deletedDate = deletedDate;
	}

	public PMDeletedMessage toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (PMDeletedMessage)Proxy.newProxyInstance(PMDeletedMessage.class.getClassLoader(),
				new Class[] { PMDeletedMessage.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		PMDeletedMessageClp clone = new PMDeletedMessageClp();

		clone.setDeletedMessageId(getDeletedMessageId());
		clone.setMessageId(getMessageId());
		clone.setOwnerId(getOwnerId());
		clone.setDeletedDate(getDeletedDate());

		return clone;
	}

	public int compareTo(PMDeletedMessage pmDeletedMessage) {
		int value = 0;

		value = DateUtil.compareTo(getDeletedDate(),
				pmDeletedMessage.getDeletedDate());

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

		PMDeletedMessageClp pmDeletedMessage = null;

		try {
			pmDeletedMessage = (PMDeletedMessageClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = pmDeletedMessage.getPrimaryKey();

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

		sb.append("{deletedMessageId=");
		sb.append(getDeletedMessageId());
		sb.append(", messageId=");
		sb.append(getMessageId());
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", deletedDate=");
		sb.append(getDeletedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.dharma.model.PMDeletedMessage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>deletedMessageId</column-name><column-value><![CDATA[");
		sb.append(getDeletedMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deletedDate</column-name><column-value><![CDATA[");
		sb.append(getDeletedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _deletedMessageId;
	private long _messageId;
	private long _ownerId;
	private Date _deletedDate;
}