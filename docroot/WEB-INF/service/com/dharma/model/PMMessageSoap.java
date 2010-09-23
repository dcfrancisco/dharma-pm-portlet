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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="PMMessageSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * {@link com.dharma.service.http.PMMessageServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.dharma.service.http.PMMessageServiceSoap
 * @generated
 */
public class PMMessageSoap implements Serializable {
	public static PMMessageSoap toSoapModel(PMMessage model) {
		PMMessageSoap soapModel = new PMMessageSoap();

		soapModel.setMessageId(model.getMessageId());
		soapModel.setSubject(model.getSubject());
		soapModel.setBody(model.getBody());
		soapModel.setParentMessageId(model.getParentMessageId());
		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setOwnerName(model.getOwnerName());
		soapModel.setPostedDate(model.getPostedDate());
		soapModel.setRecepients(model.getRecepients());

		return soapModel;
	}

	public static PMMessageSoap[] toSoapModels(PMMessage[] models) {
		PMMessageSoap[] soapModels = new PMMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PMMessageSoap[][] toSoapModels(PMMessage[][] models) {
		PMMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PMMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PMMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PMMessageSoap[] toSoapModels(List<PMMessage> models) {
		List<PMMessageSoap> soapModels = new ArrayList<PMMessageSoap>(models.size());

		for (PMMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PMMessageSoap[soapModels.size()]);
	}

	public PMMessageSoap() {
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long pk) {
		setMessageId(pk);
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

	private long _messageId;
	private String _subject;
	private String _body;
	private long _parentMessageId;
	private long _ownerId;
	private String _ownerName;
	private Date _postedDate;
	private String _recepients;
}