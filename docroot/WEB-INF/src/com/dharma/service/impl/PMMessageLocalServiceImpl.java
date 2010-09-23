/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.dharma.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dharma.model.PMMessage;
import com.dharma.pm.util.PMUtil;
import com.dharma.service.PMBlockedUserLocalServiceUtil;
import com.dharma.service.PMDeletedMessageLocalServiceUtil;
import com.dharma.service.PMReadMessageLocalServiceUtil;
import com.dharma.service.base.PMMessageLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

/**
 * <a href="PMMessageLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class PMMessageLocalServiceImpl extends PMMessageLocalServiceBaseImpl {

	public int getUnreadCount(long userId) throws SystemException {
		int unreadCount = 0;
		for (PMMessage m : getInboxMessages(userId)) {
			if (PMReadMessageLocalServiceUtil.isMessageUnread(m.getMessageId())) {
				unreadCount++;
			}
		}
		return unreadCount;
	}

	public List<PMMessage> getInboxMessages(long userId) throws SystemException {
		List<PMMessage> messages = new ArrayList<PMMessage>();
		for (PMMessage m : getPMMessagePersistence().findAll()) {
			if (PMDeletedMessageLocalServiceUtil.isDeleted(m.getMessageId())) {
				continue;
			}
			if (PMBlockedUserLocalServiceUtil.isUserBlocked(userId, m.getOwnerId())) {
				continue;
			}
			try {
				Set<User> users = PMUtil.getRecepientsList(m.getRecepients());
				for (User u : users) {
					if (u.getUserId() == userId) {
						messages.add(m);
						break;
					}
				}
			} catch (Exception e) {
				throw new SystemException(e.getMessage());
			}
		}
		return messages;
	}

	public List<PMMessage> getOutboxMessages(long ownerId) throws SystemException {
		return getPMMessagePersistence().findByOwnerId(ownerId);
	}
}