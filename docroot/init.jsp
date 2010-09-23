<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.dharma.pm.util.PMConstants"%>
<%@ page import="com.dharma.pm.util.PMUtil"%>
<%@ page import="com.dharma.model.PMMessage"%>
<%@ page import="com.dharma.model.PMDeletedMessage"%>
<%@ page import="com.dharma.model.PMReadMessage"%>
<%@ page import="com.dharma.model.PMBlockedUser"%>
<%@ page import="com.dharma.service.PMMessageLocalServiceUtil"%>
<%@ page import="com.dharma.service.PMDeletedMessageLocalServiceUtil"%>
<%@ page import="com.dharma.service.PMReadMessageLocalServiceUtil"%>
<%@ page import="com.dharma.service.PMBlockedUserLocalServiceUtil"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.NoSuchUserException"%>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	long userId = themeDisplay.getUserId();
	String portletURL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + request.getContextPath();
	String cssURL = portletURL + "/css";
	String jsURL = portletURL + "/js";
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	List<User> allUsers = PMUtil.getAllUsers();
	List<Group> allCommunities = PMUtil.getAllCommunities(userId);
%>

<portlet:renderURL var="inboxUrl">
	<portlet:param name="<%= PMConstants.ACTION %>" value="<%= PMConstants.INBOX_ACTION %>"/>
</portlet:renderURL>
<portlet:renderURL var="outboxUrl">
	<portlet:param name="<%= PMConstants.ACTION %>" value="<%= PMConstants.OUTBOX_ACTION %>"/>
</portlet:renderURL>
<portlet:renderURL var="trashUrl">
	<portlet:param name="<%= PMConstants.ACTION %>" value="<%= PMConstants.TRASH_ACTION %>"/>
</portlet:renderURL>
<portlet:renderURL var="composeUrl">
	<portlet:param name="<%= PMConstants.ACTION %>" value="<%= PMConstants.COMPOSE_ACTION %>"/>
</portlet:renderURL>
<portlet:renderURL var="addUrl">
	<portlet:param name="<%= PMConstants.ACTION %>" value="<%= PMConstants.ADD_ACTION %>"/>
</portlet:renderURL>
<portlet:renderURL var="replyUrl">
	<portlet:param name="<%= PMConstants.ACTION %>" value="<%= PMConstants.REPLY_ACTION %>"/>
</portlet:renderURL>
<portlet:renderURL var="deleteUrl">
	<portlet:param name="<%= PMConstants.ACTION %>" value="<%= PMConstants.DELETE_ACTION %>"/>
</portlet:renderURL>
<portlet:renderURL var="settingsUrl">
	<portlet:param name="<%= PMConstants.ACTION %>" value="<%= PMConstants.SETTINGS_ACTION %>"/>
</portlet:renderURL>

<script src="<%=jsURL%>/AutoComplete.js" type="text/javascript"></script>
<script src="<%=jsURL%>/util.js" type="text/javascript"></script>

<script type="text/javascript">

	var allSelected = 0;
	var replyToAllStr = "";
	var composeURL = "<%=composeUrl%>";
	var allUsers = "<%=PMConstants.ALL_USERS%>";

	function loadAllUsers(exclude) {
		var from = document.getElementById("select_from");
		from.options.length = 0;

		if(!alreadySelected("All Users")) {
			var newElem = document.createElement("option");
			newElem.text = "All Users";
			newElem.value =  allUsers;
			from.options.add(newElem);
		}
		
		<%
			for(Group community : allCommunities) {
		%>
			var nextCommunity = '<%=community.getName().replaceAll("'", "\\\\'")%>';
			var newElem = document.createElement("option");
			newElem.text = "All Members of " + nextCommunity;
			newElem.value =  "<%=PMConstants.ALL_MEMBERS + community.getGroupId()%>";
			from.options.add(newElem);
		<%
			}
		%>

		<%
			for(User u : allUsers) {
				if(!u.isDefaultUser()) {
					String userName	 = u.getFullName();
		%>
			var nextUsername = '<%=userName.replaceAll("'", "\\\\'")%>';
			if((nextUsername != exclude) && !alreadySelected(nextUsername)) {
				addUserToList(nextUsername, '<%=u.getUserId()%>');
			}
		<%
				}
			}
		%>
		
		sortListbox("select_from");
	}

</script>

<link rel="stylesheet"  media="screen" type="text/css" href="<%=cssURL%>/AutoComplete.css"/>
<link rel="stylesheet"  media="screen" type="text/css" href="<%=cssURL%>/style.css"/>

<form id="reply_form" action="<%=replyUrl%>" method="post">
	<input type="hidden" id="replyId" name="replyId" value = "" />
</form>