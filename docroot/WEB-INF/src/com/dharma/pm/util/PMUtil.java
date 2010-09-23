package com.dharma.pm.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dharma.model.PMMessage;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;

public class PMUtil {

	public static Set<User> getRecepientsList(String recepients) {
		Set<User> list = new HashSet<User>();
		if (recepients.contains(PMConstants.ALL_USERS)) {
			list.addAll(getAllUsers());
		} else {
			String[] ids = recepients.split(";");
			for (int i = 0; i < ids.length; i++) {
				String nextId = ids[i];
				if (nextId.contains(PMConstants.ALL_MEMBERS)) {
					String communityIdStr = nextId.substring(PMConstants.ALL_MEMBERS.length());
					long communityId = Long.parseLong(communityIdStr);
					try {
						list.addAll(UserLocalServiceUtil.getGroupUsers(communityId));
					} catch (SystemException e) {
						e.printStackTrace();
					}
				} else {
					long userId = Long.parseLong(ids[i]);
					try {
						list.add(UserLocalServiceUtil.getUser(userId));
					} catch (PortalException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return list;
	}

	public static String getRecepientsAsString(PMMessage message) {
		String str = "";

		String recepients = message.getRecepients();
		if(recepients.contains(PMConstants.ALL_USERS)) {
			return "All Users";
		} else {
			Group community = null;
			User user = null;
			String[] ids = recepients.split(";");
			for (int i = 0; i < ids.length; i++) {
				String nextId = ids[i];
				if (nextId.contains(PMConstants.ALL_MEMBERS)) {
					String communityIdStr = nextId.substring(PMConstants.ALL_MEMBERS.length());
					long communityId = Long.parseLong(communityIdStr);
					try {
						community = GroupLocalServiceUtil.getGroup(communityId);
						if (i > 0) {
							str += ", ";
						}
						str += "All Members of " + community.getName();
					} catch (PortalException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					}					
				} else {
					long userId = Long.parseLong(ids[i]);
					try {
						user = UserLocalServiceUtil.getUser(userId);
						if (i > 0) {
							str += ", ";
						}
						str += user.getFullName();
					} catch (PortalException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					}					
				}
			}
		}
		
		return str;
	}

	public static String getSenderEmail(PMMessage message) {
		long ownerId = message.getOwnerId();
		try {
			return UserLocalServiceUtil.getUserById(ownerId).getEmailAddress();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns all active users
	 * 
	 * @return
	 */
	public static List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			users = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
			List<User> filtered = new ArrayList<User>();
			for (User u : users) {
				// [kas] 20100917] modified for CTFP.  We will assume this to be true for any logged in user
				if (u.isActive()) {  // && u.isAgreedToTermsOfUse()) {
					filtered.add(u);
				}
			}
			users = filtered;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * Returns all existing communities
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Group> getAllCommunities(long userId) {
		List<Group> communities = new ArrayList<Group>();
		try {
			List<Group> groups = GroupLocalServiceUtil.getGroups(0, GroupLocalServiceUtil.getGroupsCount());
			for (Group c : groups) {
				if (c.isCommunity() 
						&& !c.getName().equals("Control Panel") 
						&& !c.getName().equals("Guest")) {
					if (c.getType() != GroupConstants.TYPE_COMMUNITY_OPEN) {
						boolean isMember = false;
						for (Group cm : GroupLocalServiceUtil.getUserGroups(userId)) {
							if (cm.getGroupId() == c.getGroupId()) {
								isMember = true;
								break;
							}
						}
						if (!isMember) {
							continue;
						}
					}
					communities.add(c);
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
            e.printStackTrace();
        }
		return communities;
	}
}