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
 * This class is a wrapper for {@link PMReadMessage}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PMReadMessage
 * @generated
 */
public class PMReadMessageWrapper implements PMReadMessage {
	public PMReadMessageWrapper(PMReadMessage pmReadMessage) {
		_pmReadMessage = pmReadMessage;
	}

	public long getPrimaryKey() {
		return _pmReadMessage.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_pmReadMessage.setPrimaryKey(pk);
	}

	public long getReadMessageId() {
		return _pmReadMessage.getReadMessageId();
	}

	public void setReadMessageId(long readMessageId) {
		_pmReadMessage.setReadMessageId(readMessageId);
	}

	public long getMessageId() {
		return _pmReadMessage.getMessageId();
	}

	public void setMessageId(long messageId) {
		_pmReadMessage.setMessageId(messageId);
	}

	public java.util.Date getReadDate() {
		return _pmReadMessage.getReadDate();
	}

	public void setReadDate(java.util.Date readDate) {
		_pmReadMessage.setReadDate(readDate);
	}

	public com.dharma.model.PMReadMessage toEscapedModel() {
		return _pmReadMessage.toEscapedModel();
	}

	public boolean isNew() {
		return _pmReadMessage.isNew();
	}

	public void setNew(boolean n) {
		_pmReadMessage.setNew(n);
	}

	public boolean isCachedModel() {
		return _pmReadMessage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pmReadMessage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pmReadMessage.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_pmReadMessage.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pmReadMessage.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pmReadMessage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pmReadMessage.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _pmReadMessage.clone();
	}

	public int compareTo(com.dharma.model.PMReadMessage pmReadMessage) {
		return _pmReadMessage.compareTo(pmReadMessage);
	}

	public int hashCode() {
		return _pmReadMessage.hashCode();
	}

	public java.lang.String toString() {
		return _pmReadMessage.toString();
	}

	public java.lang.String toXmlString() {
		return _pmReadMessage.toXmlString();
	}

	public PMReadMessage getWrappedPMReadMessage() {
		return _pmReadMessage;
	}

	private PMReadMessage _pmReadMessage;
}