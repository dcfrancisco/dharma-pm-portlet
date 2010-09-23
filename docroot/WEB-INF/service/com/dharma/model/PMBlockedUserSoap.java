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
 * <a href="PMBlockedUserSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * {@link com.dharma.service.http.PMBlockedUserServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.dharma.service.http.PMBlockedUserServiceSoap
 * @generated
 */
public class PMBlockedUserSoap implements Serializable {
	public static PMBlockedUserSoap toSoapModel(PMBlockedUser model) {
		PMBlockedUserSoap soapModel = new PMBlockedUserSoap();

		soapModel.setBlockedUserId(model.getBlockedUserId());
		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setUserId(model.getUserId());
		soapModel.setBlockedDate(model.getBlockedDate());

		return soapModel;
	}

	public static PMBlockedUserSoap[] toSoapModels(PMBlockedUser[] models) {
		PMBlockedUserSoap[] soapModels = new PMBlockedUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PMBlockedUserSoap[][] toSoapModels(PMBlockedUser[][] models) {
		PMBlockedUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PMBlockedUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PMBlockedUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PMBlockedUserSoap[] toSoapModels(List<PMBlockedUser> models) {
		List<PMBlockedUserSoap> soapModels = new ArrayList<PMBlockedUserSoap>(models.size());

		for (PMBlockedUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PMBlockedUserSoap[soapModels.size()]);
	}

	public PMBlockedUserSoap() {
	}

	public long getPrimaryKey() {
		return _blockedUserId;
	}

	public void setPrimaryKey(long pk) {
		setBlockedUserId(pk);
	}

	public long getBlockedUserId() {
		return _blockedUserId;
	}

	public void setBlockedUserId(long blockedUserId) {
		_blockedUserId = blockedUserId;
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

	public Date getBlockedDate() {
		return _blockedDate;
	}

	public void setBlockedDate(Date blockedDate) {
		_blockedDate = blockedDate;
	}

	private long _blockedUserId;
	private long _ownerId;
	private long _userId;
	private Date _blockedDate;
}