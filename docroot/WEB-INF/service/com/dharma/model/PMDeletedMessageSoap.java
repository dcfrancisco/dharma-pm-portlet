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
 * <a href="PMDeletedMessageSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * {@link com.dharma.service.http.PMDeletedMessageServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.dharma.service.http.PMDeletedMessageServiceSoap
 * @generated
 */
public class PMDeletedMessageSoap implements Serializable {
	public static PMDeletedMessageSoap toSoapModel(PMDeletedMessage model) {
		PMDeletedMessageSoap soapModel = new PMDeletedMessageSoap();

		soapModel.setDeletedMessageId(model.getDeletedMessageId());
		soapModel.setMessageId(model.getMessageId());
		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setDeletedDate(model.getDeletedDate());

		return soapModel;
	}

	public static PMDeletedMessageSoap[] toSoapModels(PMDeletedMessage[] models) {
		PMDeletedMessageSoap[] soapModels = new PMDeletedMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PMDeletedMessageSoap[][] toSoapModels(
		PMDeletedMessage[][] models) {
		PMDeletedMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PMDeletedMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PMDeletedMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PMDeletedMessageSoap[] toSoapModels(
		List<PMDeletedMessage> models) {
		List<PMDeletedMessageSoap> soapModels = new ArrayList<PMDeletedMessageSoap>(models.size());

		for (PMDeletedMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PMDeletedMessageSoap[soapModels.size()]);
	}

	public PMDeletedMessageSoap() {
	}

	public long getPrimaryKey() {
		return _deletedMessageId;
	}

	public void setPrimaryKey(long pk) {
		setDeletedMessageId(pk);
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

	private long _deletedMessageId;
	private long _messageId;
	private long _ownerId;
	private Date _deletedDate;
}