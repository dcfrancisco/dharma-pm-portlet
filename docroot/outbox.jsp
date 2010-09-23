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
	<portlet:param name="page" value="outbox"/>
	<portlet:param name="startIndex" value="<%= prevIndex %>"/>
</portlet:renderURL>
<portlet:renderURL var="nextPageUrl">
	<portlet:param name="page" value="outbox"/>
	<portlet:param name="startIndex" value="<%= nextIndex %>"/>
</portlet:renderURL>
<div>
	<div class="pageContent">
		<div class="subNavigation">
			<ul>
				<li><a class='pm_link'  href="<%= inboxUrl %>">Inbox</a></li>
				<li>&nbsp;|&nbsp;Outbox</li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= trashUrl %>">Trash</a></li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= settingsUrl %>">Settings</a></li>
			</ul>
		</div>
		<p>
			This page displays messages sent from you to other members of this site.
		</p>
		<input type="button" value="Compose Message" onclick="openCompose();" />
		<br/><br/>
		<div id="messages_count"><%=pagingLabel%></div>
		<div id="mailbox">
			<br/>
				<%
					if(totalCount == 0) {
				%>
					<p>You have no sent messages.</p>
				<%
					} else {
				%>
				<form id="view_form" action="" method="post">
					<input type="hidden" id="messageId" name="messageId" value = "" />
					<table width="100%">
						<tr>
							<td width="3%" class="pm_header" height="25">&nbsp;</td>
							<td width="20%" class="pm_header">To</td>
							<td width="60%" class="pm_header">Subject</td>
							<td width="20%" class="pm_header">Sent</td>
						</tr>
					<%
							boolean grayBg = false;
							for(PMMessage m : messages) {
								String bgColor = grayBg ? "#DDDDDD" : "#FFFFFF";
								grayBg = !grayBg;
								String recepients = PMUtil.getRecepientsAsString(m);
								if(recepients.indexOf(",") > 0) {
									String firstUser = recepients.substring(0, recepients.indexOf(","));
									recepients = "<a class='pm_link'  href='#' style='text-decoration:none;' title='" + recepients + "'>" + firstUser + "</a> ...";
								}
					%>
						<tr bgcolor="<%=bgColor%>"><td colspan="4">&nbsp</td></tr>
						<tr bgcolor="<%=bgColor%>">
							<td valign="top" align="center">&nbsp;</td>
							<td valign="top"><%= recepients %></td>
							<td valign="top">
								<portlet:renderURL var="viewMessageUrl">
									<portlet:param name="<%= PMConstants.ACTION %>" value="<%= PMConstants.VIEW_MESSAGE_ACTION %>"/>
									<portlet:param name="messageId" value="<%= String.valueOf(m.getMessageId()) %>"/>
								</portlet:renderURL>
								<a class='pm_link'  href="<%=viewMessageUrl%>" style="text-decoration:none;"><%=m.getSubject()%></a>
							</td>
							<td valign="top"><%=df.format(m.getPostedDate())%></td>
						</tr>
						<tr bgcolor="<%=bgColor%>"><td colspan="4">&nbsp</td></tr>
					<%
							}
						}
					%>
						<tr><td colspan="4">&nbsp</td></tr>
						<tr>
							<td colspan="4" align="right">
								<%@ include file="paging.jsp"%>
							</td>
						</tr>
				</table>
			</form>	
		</div>
	</div>
</div>