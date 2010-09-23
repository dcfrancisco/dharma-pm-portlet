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
public class PMMessageClp extends BaseModelImpl<PMMessage> implements PMMessage {
	public PMMessageClp() {
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long pk) {
		setMessageId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_messageId);
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getBody() {
		return _body;
	}

	public void setBody(String body) {
		_body = body;
	}

	public long getParentMessageId() {
		return _parentMessageId;
	}

	public void setParentMessageId(long parentMessageId) {
		_parentMessageId = parentMessageId;
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public String getOwnerName() {
		return _ownerName;
	}

	public void setOwnerName(String ownerName) {
		_ownerName = ownerName;
	}

	public Date getPostedDate() {
		return _postedDate;
	}

	public void setPostedDate(Date postedDate) {
		_postedDate = postedDate;
	}

	public String getRecepients() {
		return _recepients;
	}

	public void setRecepients(String recepients) {
		_recepients = recepients;
	}

	public PMMessage toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (PMMessage)Proxy.newProxyInstance(PMMessage.class.getClassLoader(),
				new Class[] { PMMessage.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		PMMessageClp clone = new PMMessageClp();

		clone.setMessageId(getMessageId());
		clone.setSubject(getSubject());
		clone.setBody(getBody());
		clone.setParentMessageId(getParentMessageId());
		clone.setOwnerId(getOwnerId());
		clone.setOwnerName(getOwnerName());
		clone.setPostedDate(getPostedDate());
		clone.setRecepients(getRecepients());

		return clone;
	}

	public int compareTo(PMMessage pmMessage) {
		int value = 0;

		value = DateUtil.compareTo(getPostedDate(), pmMessage.getPostedDate());

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

		PMMessageClp pmMessage = null;

		try {
			pmMessage = (PMMessageClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = pmMessage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{messageId=");
		sb.append(getMessageId());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", body=");
		sb.append(getBody());
		sb.append(", parentMessageId=");
		sb.append(getParentMessageId());
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", ownerName=");
		sb.append(getOwnerName());
		sb.append(", postedDate=");
		sb.append(getPostedDate());
		sb.append(", recepients=");
		sb.append(getRecepients());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.dharma.model.PMMessage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentMessageId</column-name><column-value><![CDATA[");
		sb.append(getParentMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerName</column-name><column-value><![CDATA[");
		sb.append(getOwnerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postedDate</column-name><column-value><![CDATA[");
		sb.append(getPostedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recepients</column-name><column-value><![CDATA[");
		sb.append(getRecepients());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _messageId;
	private String _subject;
	private String _body;
	private long _parentMessageId;
	private long _ownerId;
	private String _ownerName;
	private Date _postedDate;
	private String _recepients;
}