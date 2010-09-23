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
public class PMReadMessageClp extends BaseModelImpl<PMReadMessage>
	implements PMReadMessage {
	public PMReadMessageClp() {
	}

	public long getPrimaryKey() {
		return _readMessageId;
	}

	public void setPrimaryKey(long pk) {
		setReadMessageId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_readMessageId);
	}

	public long getReadMessageId() {
		return _readMessageId;
	}

	public void setReadMessageId(long readMessageId) {
		_readMessageId = readMessageId;
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public Date getReadDate() {
		return _readDate;
	}

	public void setReadDate(Date readDate) {
		_readDate = readDate;
	}

	public PMReadMessage toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (PMReadMessage)Proxy.newProxyInstance(PMReadMessage.class.getClassLoader(),
				new Class[] { PMReadMessage.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		PMReadMessageClp clone = new PMReadMessageClp();

		clone.setReadMessageId(getReadMessageId());
		clone.setMessageId(getMessageId());
		clone.setReadDate(getReadDate());

		return clone;
	}

	public int compareTo(PMReadMessage pmReadMessage) {
		int value = 0;

		value = DateUtil.compareTo(getReadDate(), pmReadMessage.getReadDate());

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

		PMReadMessageClp pmReadMessage = null;

		try {
			pmReadMessage = (PMReadMessageClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = pmReadMessage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{readMessageId=");
		sb.append(getReadMessageId());
		sb.append(", messageId=");
		sb.append(getMessageId());
		sb.append(", readDate=");
		sb.append(getReadDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.dharma.model.PMReadMessage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>readMessageId</column-name><column-value><![CDATA[");
		sb.append(getReadMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>readDate</column-name><column-value><![CDATA[");
		sb.append(getReadDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _readMessageId;
	private long _messageId;
	private Date _readDate;
}