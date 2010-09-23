<%@ include file="init.jsp"%>
<%
	List<PMBlockedUser> blockedUsers =  PMBlockedUserLocalServiceUtil.getBlockedUsers(themeDisplay.getUserId());
%>
<div>
	<div class="pageContent">
		<div id="error_div" class="portlet-msg-error" style="width:95%; display:none;"></div>
		<div class="subNavigation">
			<ul>
				<li><a class='pm_link'  href="<%= inboxUrl %>">Inbox</a></li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= outboxUrl %>">Outbox</a></li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= trashUrl %>">Trash</a></li>
				<li>&nbsp;|&nbsp;Settings</li>
			</ul>
		</div>
		<br/><h5>Blocked Users</h5><br/>
		<%
			if(blockedUsers.size() == 0) {
		%>
			<p>You have no blocked users</p>
		<%	
			} else {
		%>
			<script type="text/javascript">
				var blockedUserIds = new Array();
			</script>
			<form id="delete_form" name="delete_form" action="<%=deleteUrl%>" method="post">
				<input type="hidden" id="type" name="type" value="unblock" />
				<input type="hidden" id="ids" name="ids" value="" />
				<table width="100%">
					<tr>
						<td align="center" width="5%" class="pm_header" height="25"><input type="checkbox" onclick="selectAllBlockedUsers();" /></td>
						<td class="pm_header">User</td>
					</tr>
					<tr bgcolor="#FFFFFF"><td colspan="2">&nbsp</td></tr>
				<%
					boolean grayBg = false;
					for(PMBlockedUser bu : blockedUsers) {
						String bgColor = grayBg ? "#DDDDDD" : "#FFFFFF";
						grayBg = !grayBg;
						String blockedUserName = "";
						try {
							blockedUserName = UserLocalServiceUtil.getUser(bu.getUserId()).getFullName();
						} catch (NoSuchUserException e) {
							PMBlockedUserLocalServiceUtil.deletePMBlockedUser(bu.getBlockedUserId());
							continue;
						}
				%>
					<tr bgcolor="<%=bgColor%>">
						<td align="center">
							<input type="checkbox" id="blocked_user_<%=bu.getBlockedUserId()%>" />
							<script type="text/javascript">
								blockedUserIds.push("<%=bu.getBlockedUserId()%>");
							</script>
						</td>
						<td>&nbsp;&nbsp;<%=blockedUserName%></td>
					</tr>
					<tr bgcolor="<%=bgColor%>"><td colspan="2">&nbsp</td></tr>
				<%
					}
				%>
					<tr><td colspan="2">&nbsp;</td></tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="Unblock" onclick="return getSelectedBlockedUsers();" />
						</td>
					</tr>
					</table>
				</div>
			</form>
		<%
			}
		%>
	</div>
</div>