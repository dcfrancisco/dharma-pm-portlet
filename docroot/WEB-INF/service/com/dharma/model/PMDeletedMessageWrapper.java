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
 * This class is a wrapper for {@link PMDeletedMessage}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PMDeletedMessage
 * @generated
 */
public class PMDeletedMessageWrapper implements PMDeletedMessage {
	public PMDeletedMessageWrapper(PMDeletedMessage pmDeletedMessage) {
		_pmDeletedMessage = pmDeletedMessage;
	}

	public long getPrimaryKey() {
		return _pmDeletedMessage.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_pmDeletedMessage.setPrimaryKey(pk);
	}

	public long getDeletedMessageId() {
		return _pmDeletedMessage.getDeletedMessageId();
	}

	public void setDeletedMessageId(long deletedMessageId) {
		_pmDeletedMessage.setDeletedMessageId(deletedMessageId);
	}

	public long getMessageId() {
		return _pmDeletedMessage.getMessageId();
	}

	public void setMessageId(long messageId) {
		_pmDeletedMessage.setMessageId(messageId);
	}

	public long getOwnerId() {
		return _pmDeletedMessage.getOwnerId();
	}

	public void setOwnerId(long ownerId) {
		_pmDeletedMessage.setOwnerId(ownerId);
	}

	public java.util.Date getDeletedDate() {
		return _pmDeletedMessage.getDeletedDate();
	}

	public void setDeletedDate(java.util.Date deletedDate) {
		_pmDeletedMessage.setDeletedDate(deletedDate);
	}

	public com.dharma.model.PMDeletedMessage toEscapedModel() {
		return _pmDeletedMessage.toEscapedModel();
	}

	public boolean isNew() {
		return _pmDeletedMessage.isNew();
	}

	public void setNew(boolean n) {
		_pmDeletedMessage.setNew(n);
	}

	public boolean isCachedModel() {
		return _pmDeletedMessage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pmDeletedMessage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pmDeletedMessage.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_pmDeletedMessage.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pmDeletedMessage.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pmDeletedMessage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pmDeletedMessage.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _pmDeletedMessage.clone();
	}

	public int compareTo(com.dharma.model.PMDeletedMessage pmDeletedMessage) {
		return _pmDeletedMessage.compareTo(pmDeletedMessage);
	}

	public int hashCode() {
		return _pmDeletedMessage.hashCode();
	}

	public java.lang.String toString() {
		return _pmDeletedMessage.toString();
	}

	public java.lang.String toXmlString() {
		return _pmDeletedMessage.toXmlString();
	}

	public PMDeletedMessage getWrappedPMDeletedMessage() {
		return _pmDeletedMessage;
	}

	private PMDeletedMessage _pmDeletedMessage;
}