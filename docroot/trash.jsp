<%@ include file="init.jsp"%>
<%
	int start = 0;
	if (request.getAttribute("start") != null) {
		start = (Integer) request.getAttribute("start");
	}
	int countPerPage = 2;
	List<PMDeletedMessage> messages = (List<PMDeletedMessage>) request.getAttribute(PMConstants.MESSAGES_LIST);
	int totalCount = (Integer) request.getAttribute(PMConstants.TOTAL_COUNT);
	String prevIndex = "" + (start - countPerPage);
	String nextIndex = "" + (start + countPerPage);
	String pagingLabel = "";
	if(totalCount > 0) {
		pagingLabel = "Showing messages " + (start + 1) + " to " + (start + messages.size()) + " of " + totalCount;
	}
%>
<portlet:renderURL var="prevPageUrl">
	<portlet:param name="page" value="trash"/>
	<portlet:param name="startIndex" value="<%= prevIndex %>"/>
</portlet:renderURL>
<portlet:renderURL var="nextPageUrl">
	<portlet:param name="page" value="trash"/>
	<portlet:param name="startIndex" value="<%= nextIndex %>"/>
</portlet:renderURL>
<div>
	<div class="pageContent">
		<div class="subNavigation">
			<ul>
				<li><a class='pm_link'  href="<%= inboxUrl %>">Inbox</a></li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= outboxUrl %>">Outbox</a></li>
				<li>&nbsp;|&nbsp;Trash</li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= settingsUrl %>">Settings</a></li>
			</ul>
		</div>
		<p>
			This page shows the messages from other users that you have deleted.
		</p>
		<input type="button" value="Compose Message" onclick="openCompose();" />
		<br/><br/>
		<div id="messages_count"><%=pagingLabel%></div>
		<div id="mailbox">
			<div>
				<br/>
				<%
					if(totalCount == 0) {
				%>
					<p>You have no deleted messages.</p>
				<%
					} else {
				%>
				<script type="text/javascript">
					var messageIds = new Array();
					var userIds = new Array();
				</script>
				<form id="view_form" name="view_form" action="<%=deleteUrl%>" method="post">
					<input type="hidden" id="type" name="type" value="undelete" />
					<input type="hidden" id="ids" name="ids" value="" />
					<table width="100%">
						<tr>
							<td align="center" width="3%" class="pm_header" height="25"><input type="checkbox" onclick="selectAll();" /></td>
							<td width="20%" class="pm_header">From</td>
							<td width="60%" class="pm_header">Subject</td>
							<td width="20%" class="pm_header">Sent</td>
						</tr>
						<%
							boolean grayBg = false;
							for(PMDeletedMessage dm : messages) {
								PMMessage m = PMMessageLocalServiceUtil.getPMMessage(dm.getMessageId());
								String ownerName = "<i>unknown</i>";
								try {
									ownerName = UserLocalServiceUtil.getUser(m.getOwnerId()).getFullName();
								} catch (NoSuchUserException e) {
								}
								String bgColor = grayBg ? "#DDDDDD" : "#FFFFFF";
								grayBg = !grayBg;
						%>
						<tr bgcolor="<%=bgColor%>"><td colspan="4">&nbsp</td></tr>
						<tr bgcolor="<%=bgColor%>">
							<td valign="top" align="center">
								<input type="checkbox" id="message_<%=dm.getDeletedMessageId()%>" />
								<script type="text/javascript">
									messageIds.push("<%=dm.getDeletedMessageId()%>");
									userIds.push("<%=m.getOwnerId()%>");
								</script>
							</td>
							<td valign="top">
								<table>
									<tr>
										<td valign="top">
											<liferay-ui:user-display
												userId="<%= m.getOwnerId() %>"
												displayStyle="<%= 1 %>"
											/>
										</td>
									</tr>
								</table>	
							</td>
							<td valign="top">
								<portlet:renderURL var="viewMessageUrl">
									<portlet:param name="<%= PMConstants.ACTION %>" value="<%= PMConstants.VIEW_MESSAGE_ACTION %>"/>
									<portlet:param name="messageId" value="<%= String.valueOf(m.getMessageId()) %>"/>
								</portlet:renderURL>
								<a class='pm_link'  href="<%=viewMessageUrl%>" style="text-decoration:none;"><%=m.getSubject()%></a>
							</td>
							<td valign="top"><%=df.format(m.getPostedDate())%></td>
						</tr>	
					<%
							}
						}
					%>
						<tr><td colspan="4">&nbsp</td></tr>
					<%
						if(totalCount > 0) {
					%>	
						<tr>
							<td colspan="3">
								<input type="submit" value="Erase" onclick="return eraseSelectedMessages();"/>
								<input type="submit" value="Undelete" onclick="return getSelectedMessages();"/>
								<input type="submit" value="Block Users" onclick="return getSelectedUsers();"/>
							</td>
							<td align="right">
								<%@ include file="paging.jsp"%>
							</td>
						</tr>
					<%
						}
					%>
					</table>
				</form>	
			</div>
		</div>
	</div>
</div>