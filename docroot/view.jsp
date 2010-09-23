<%@ include file="init.jsp"%>
<%
	int start = 0;
	if (request.getAttribute("start") != null) {
		start = (Integer) request.getAttribute("start");
	}
	int countPerPage = 2;
	List<PMMessage> messages = (List<PMMessage>) request.getAttribute(PMConstants.MESSAGES_LIST);
	int totalCount = (Integer) request.getAttribute(PMConstants.TOTAL_COUNT);
	String prevIndex = "" + (start - countPerPage);
	String nextIndex = "" + (start + countPerPage);
	String pagingLabel = "";
	if(totalCount > 0) {
		pagingLabel = "Showing messages " + (start + 1) + " to " + (start + messages.size()) + " of " + totalCount;
	}
%>
<portlet:renderURL var="prevPageUrl">
	<portlet:param name="page" value="inbox"/>
	<portlet:param name="startIndex" value="<%= prevIndex %>"/>
</portlet:renderURL>
<portlet:renderURL var="nextPageUrl">
	<portlet:param name="page" value="inbox"/>
	<portlet:param name="startIndex" value="<%= nextIndex %>"/>
</portlet:renderURL>
<div>
	<div class="pageContent">
		<div style="width:100%;">
			<%
				String errorMessage = (String) request.getAttribute(PMConstants.ERROR_MESSAGE);
				if(errorMessage != null) {
			%>
				<div class="portlet-msg-error" style="width:95%;"><%=errorMessage%></div><br/>
			<%
					request.removeAttribute(PMConstants.ERROR_MESSAGE);
				}
			%>
			<%
				String infoMessage = (String) request.getAttribute(PMConstants.INFO_MESSAGE);
				if(infoMessage != null) {
			%>			
				<div class="portlet-msg-info" style="width:95%;"><%=infoMessage%></div><br/>
			<%
					request.removeAttribute(PMConstants.INFO_MESSAGE);
				}
			%>
		</div>			
		<div class="subNavigation">
			<ul>
				<li>Inbox</li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= outboxUrl %>">Outbox</a></li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= trashUrl %>">Trash</a></li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= settingsUrl %>">Settings</a></li>
			</ul>
		</div>
		<p>
			This page displays messages sent to you by other members of this site.
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
					<p>You have no messages.</p>
				<%
					} else {
				%>
				<script type="text/javascript">
					var messageIds = new Array();
					var userIds = new Array();
				</script>
				<form id="delete_form" name="delete_form" action="<%=deleteUrl%>" method="post">
					<input type="hidden" id="type" name="type" value="delete" />
					<input type="hidden" id="ids" name="ids" value="" />
					<table width="100%">
						<tr>
							<td align="center" width="3%" class="pm_header" height="25"><input type="checkbox" onclick="selectAll();" /></td>
							<td width="30%" class="pm_header">From</td>
							<td width="50%" class="pm_header">Subject</td>
							<td width="20%" class="pm_header">Sent</td>
						</tr>
					<%
							boolean grayBg = false;
							for(PMMessage m : messages) {
								String ownerName = m.getOwnerName();
								boolean ownerExists = true;
								try {
									UserLocalServiceUtil.getUser(m.getOwnerId());
								} catch (NoSuchUserException e) {
									ownerExists = false;
								}
								String bgColor = grayBg ? "#DDDDDD" : "#FFFFFF";
								grayBg = !grayBg;
								String msgStyle = PMReadMessageLocalServiceUtil.isMessageUnread(m.getMessageId()) ? "font-weight:bold;" : "";
					%>
						<tr bgcolor="<%=bgColor%>"><td colspan="4">&nbsp</td></tr>
						<tr bgcolor="<%=bgColor%>" style="<%=msgStyle%>">
							<td valign="top" align="center">
								<input type="checkbox" id="message_<%=m.getMessageId()%>" />
								<script type="text/javascript">
									messageIds.push("<%=m.getMessageId()%>");
									userIds.push("<%=m.getOwnerId()%>");
								</script>
							</td>
							<td valign="top">
								<table>
									<tr>
										<td valign="top">
											<%
												if(ownerExists) {
											%>
												<liferay-ui:user-display
													userId="<%= m.getOwnerId() %>"
													displayStyle="<%= 1 %>"
												/>
											<%
												} else {
											%>
												<%=ownerName%>
											<%
												}
											%>
										</td>
									</tr>
								</table><br/>
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
							<td colspan="2">
								<input type="submit" value="Delete" onclick="return getSelectedMessages();"/>
								<input type="submit" value="Block Users" onclick="return getSelectedUsers();"/>
							</td>
							<td colspan="2" align="right">
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