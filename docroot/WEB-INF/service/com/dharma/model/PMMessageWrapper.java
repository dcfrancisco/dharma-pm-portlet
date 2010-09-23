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
 * This class is a wrapper for {@link PMMessage}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PMMessage
 * @generated
 */
public class PMMessageWrapper implements PMMessage {
	public PMMessageWrapper(PMMessage pmMessage) {
		_pmMessage = pmMessage;
	}

	public long getPrimaryKey() {
		return _pmMessage.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_pmMessage.setPrimaryKey(pk);
	}

	public long getMessageId() {
		return _pmMessage.getMessageId();
	}

	public void setMessageId(long messageId) {
		_pmMessage.setMessageId(messageId);
	}

	public java.lang.String getSubject() {
		return _pmMessage.getSubject();
	}

	public void setSubject(java.lang.String subject) {
		_pmMessage.setSubject(subject);
	}

	public java.lang.String getBody() {
		return _pmMessage.getBody();
	}

	public void setBody(java.lang.String body) {
		_pmMessage.setBody(body);
	}

	public long getParentMessageId() {
		return _pmMessage.getParentMessageId();
	}

	public void setParentMessageId(long parentMessageId) {
		_pmMessage.setParentMessageId(parentMessageId);
	}

	public long getOwnerId() {
		return _pmMessage.getOwnerId();
	}

	public void setOwnerId(long ownerId) {
		_pmMessage.setOwnerId(ownerId);
	}

	public java.lang.String getOwnerName() {
		return _pmMessage.getOwnerName();
	}

	public void setOwnerName(java.lang.String ownerName) {
		_pmMessage.setOwnerName(ownerName);
	}

	public java.util.Date getPostedDate() {
		return _pmMessage.getPostedDate();
	}

	public void setPostedDate(java.util.Date postedDate) {
		_pmMessage.setPostedDate(postedDate);
	}

	public java.lang.String getRecepients() {
		return _pmMessage.getRecepients();
	}

	public void setRecepients(java.lang.String recepients) {
		_pmMessage.setRecepients(recepients);
	}

	public com.dharma.model.PMMessage toEscapedModel() {
		return _pmMessage.toEscapedModel();
	}

	public boolean isNew() {
		return _pmMessage.isNew();
	}

	public void setNew(boolean n) {
		_pmMessage.setNew(n);
	}

	public boolean isCachedModel() {
		return _pmMessage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pmMessage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pmMessage.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_pmMessage.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pmMessage.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pmMessage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pmMessage.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _pmMessage.clone();
	}

	public int compareTo(com.dharma.model.PMMessage pmMessage) {
		return _pmMessage.compareTo(pmMessage);
	}

	public int hashCode() {
		return _pmMessage.hashCode();
	}

	public java.lang.String toString() {
		return _pmMessage.toString();
	}

	public java.lang.String toXmlString() {
		return _pmMessage.toXmlString();
	}

	public PMMessage getWrappedPMMessage() {
		return _pmMessage;
	}

	private PMMessage _pmMessage;
}