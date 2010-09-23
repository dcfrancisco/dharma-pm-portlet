<%@ include file="init.jsp"%>
<%
	String pmId = (String) request.getAttribute("messageId");
	PMMessage m = PMMessageLocalServiceUtil.getPMMessage(Long.parseLong(pmId));
	String ownerName = "<i>unknown</i>";
	try {
		ownerName = UserLocalServiceUtil.getUser(m.getOwnerId()).getFullName();
	} catch (NoSuchUserException e) {
	}
	if(PMReadMessageLocalServiceUtil.isMessageUnread(m.getMessageId())) {
		PMReadMessage rm = PMReadMessageLocalServiceUtil.createPMReadMessage(0L);
		rm.setMessageId(m.getMessageId());
		rm.setReadDate(new Date());
		PMReadMessageLocalServiceUtil.addPMReadMessage(rm);
	}
	String recepients = PMUtil.getRecepientsAsString(m);
%>
<div>
	<div class="pageContent">
		<div id="error_div" class="portlet-msg-error" style="width:95%; display:none;"></div>
		<div class="subNavigation">
			<ul>
				<li><a class='pm_link'  href="<%= inboxUrl %>">Inbox</a></li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= outboxUrl %>">Outbox</a></li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= trashUrl %>">Trash</a></li>
				<li>&nbsp;|&nbsp;<a class='pm_link'  href="<%= settingsUrl %>">Settings</a></li>
			</ul>
		</div>
		<br/><h5>View Message</h5><br/>
		<form action="<%=replyUrl%>" method="post" onSubmit="return dh_onSubmit();">
			<input type="hidden" id="parentMessageId" name="parentMessageId" value = "<%=pmId%>" />
			<div style="padding: 10px;">
				<table>
					<tr><td colspan="3">&nbsp;</td></tr>
					<tr>
						<td valign="top" align="right" width="46"><b>From:</b></td>
						<td width="5">&nbsp;</td>
						<td valign="top">
							<liferay-ui:user-display
								userId="<%= m.getOwnerId() %>"
								displayStyle="<%= 1 %>"
							/>							
						</td>
					</tr>
					<tr><td colspan="3">&nbsp;</td></tr>
					<tr>
						<td valign="top" align="right"><b>To:</b></td>
						<td width="5">&nbsp;</td>
						<td valign="top"><%= recepients %></td>
					</tr>
					<tr><td colspan="3">&nbsp;</td></tr>
					<tr>
						<td valign="top" align="right"><b>Sent:</b></td>
						<td width="5">&nbsp;</td>
						<td valign="top">
							<%=df.format(m.getPostedDate())%>
						</td>
					</tr>
					<tr><td colspan="3">&nbsp;</td></tr>
					<tr>
						<td valign="top" align="right"><b>Subject:</b></td>
						<td width="5">&nbsp;</td>
						<td valign="top">
							<%= m.getSubject() %>
						</td>
					</tr>
					<tr><td colspan="3">&nbsp;</td></tr>
					<tr>
						<td valign="top" colspan="3">
							<div class="pm_compose" style="overflow:auto;">
								<%= m.getBody().replace("\n", "<br/>") %>
							</div>
						</td>
					</tr>
					<tr><td colspan="3">&nbsp;</td></tr>
					<tr>
						<td colspan="3" align="right">
							<input type="submit" value="Reply" />
							<input type="button" value="Delete" onclick="return dh_delete(<%=pmId%>);"  />
							<input type="button" value="Close" onclick="location.href='<%=inboxUrl%>';"  />
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</div>
<form id="delete_form" action="<%=deleteUrl%>" method="post">
	<input type="hidden" id="type" name="type" value="delete" />
	<input type="hidden" id="ids" name="ids" value = "" />
</form>