<%@ include file="init.jsp"%>
<%
	String pmId = ParamUtil.getString(request, "parentMessageId", "-1");
	String ownerName = "";
	PMMessage parentMessage = null;
	if(!pmId.equals("-1")) {
		parentMessage = PMMessageLocalServiceUtil.getPMMessage(Long.parseLong(pmId));
		try {
			ownerName = UserLocalServiceUtil.getUser(parentMessage.getOwnerId()).getFullName();
		} catch (NoSuchUserException e) {
			ownerName = "<i>unknown</i>";
		}
	}
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
		<h5>Compose New Message</h5>
		<form action="<%=addUrl%>" method="post" onSubmit="return dh_onSubmit();">
			<input type="hidden" id="parentMessageId" name="parentMessageId" value = "<%=pmId%>" />
			<%
				if(parentMessage != null) {
			%>
				<input type="hidden" id="recepients" name="recepients" value = "<%=parentMessage.getOwnerId()%>;" />
			<%
				} else {
			%>
				<input type="hidden" id="recepients" name="recepients" value = "" />
			<%
				}
			%>
			<div style="padding: 10px;">
				<table>
					<tr>
						<td>
							<table>
								<tr>
									<td colspan="5">
										<b>To: </b>&nbsp;<input type="text" id="find" name="find" style="width:200px;" />
									</td>
								</tr>
								<tr><td colspan="5">&nbsp;</td></tr>
								<tr>
									<td width="250">&nbsp;</td>
									<td colspan="4">
										<b>To:</b>&nbsp;<i>(max 15 entries)</i>
									</td>
								</tr>
								<tr>
									<td colspan="5">
										<table>
											<tr>
												<td>
													<select id="select_from" multiple="true" class="pm_user_select"></select>
												</td>	
												<td width="10"></td>
												<td>
													<input type="button" value=">>" onclick="addUser();" />
													<br/><br/>
													<input type="button" value="<<" onclick="removeUser();" />
												</td>
												<td width="10"></td>
												<td>
													<select id="select_to" name="select_to" multiple="true" class="pm_user_select"></select>
												</td>
											</tr>
										</table>
									</td>			
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<div style="padding:10px;">
				<b>Subject:</b>
				<%
					String subj = "";
					if(parentMessage != null) {
						subj = "RE: " + parentMessage.getSubject();
					}
				%>
				<input type="text" id="subject" name="subject" maxlength="30" value="<%=subj%>" />
			</div>
			<%
				if(parentMessage == null) {
			%>
				<div style="padding:10px;">
					<textarea id="body" name="body" class="pm_compose" 
						onmouseover="return showLeftSymbols();" 
						onfocus="return showLeftSymbols();"
						onclick="return showLeftSymbols();" 
						ondblclick="return showLeftSymbols();" 
						onkeydown="return showLeftSymbols();" 
						onkeypress="return showLeftSymbols();" 
						onmousedown="return showLeftSymbols();" 
						onkeyup="return showLeftSymbols();" 
						onmouseup="return showLeftSymbols();" 
						onmousedown="return showLeftSymbols();" 
						onchange="return showLeftSymbols();"></textarea>
				</div>
				<div id="chars_left" class="pm_left_chars">10000 characters left</div>
				<div style="padding:10px;">
					<input type="submit" value="Send" />
					<input type="button" value="Cancel" onclick="location.href='<%=inboxUrl%>';"  />
				</div>
			<%
				} else {
					String to = PMUtil.getRecepientsAsString(parentMessage);
			%>
				<script type="text/javascript">
					replyToAllStr = "<%=to%>";
				</script>
				<div style="padding:10px;">
					<textarea id="body" name="body" class="pm_compose" 
						onmouseover="return showLeftSymbols();" 
						onfocus="return showLeftSymbols();"
						onclick="return showLeftSymbols();" 
						ondblclick="return showLeftSymbols();" 
						onkeydown="return showLeftSymbols();" 
						onkeypress="return showLeftSymbols();" 
						onmousedown="return showLeftSymbols();" 
						onkeyup="return showLeftSymbols();" 
						onmouseup="return showLeftSymbols();" 
						onmousedown="return showLeftSymbols();" 
						onchange="return showLeftSymbols();">
	
	
	-- Original Message --
	From: <%=ownerName%>
	To: <%=to%>
	Sent: <%=df.format(parentMessage.getPostedDate())%>
	Subject: <%=parentMessage.getSubject()%>
						
	<%=parentMessage.getBody()%>
	</textarea>
				<div id="chars_left" class="pm_left_chars">10000 characters left</div>
				<div style="padding:10px;">
					<input type="submit" value="Reply" />
					<input type="submit" value="Reply to All" onclick="return replyToAll();"/>
					<input type="button" value="Cancel" onclick="location.href='<%=inboxUrl%>';"  />
				</div>	
				<script type="text/javascript">
					showLeftSymbols();
				</script>
				<%	
					}
				%>
			<br/>
		</form>
	</div>
</div>

<script type="text/javascript">

<%
	if(parentMessage != null) {
%>
	var count = 10000 - document.getElementById('body').value.length;
	document.getElementById('chars_left').innerHTML = count + " characters left";
<%
	}
%>
	<%
		if(parentMessage != null) {
	%>
		loadAllUsers('<%=ownerName.replaceAll("'", "\\\\'")%>');
	<%
		} else {
	%>
		loadAllUsers();
	<%
		}
	%>

	//	init autocomplete
	var ac_data = new Array();
	<%
		for(User u : allUsers) {
			if(!u.isDefaultUser()) {
	%>
		ac_data.push('<%=u.getFullName().replaceAll("'", "\\\\'")%>');
	<%
			}
		}
	%>
	ac_data.sort();
	AutoComplete_Create('find', ac_data);

	<%
		if(parentMessage != null) {
			try {
				UserLocalServiceUtil.getUser(parentMessage.getOwnerId());
	%>
				var obj = document.getElementById("select_to");
				var newElem = document.createElement("option");
				newElem.text = '<%=ownerName.replaceAll("'", "\\\\'")%>';
				newElem.value = "<%=parentMessage.getOwnerId()%>";
				obj.options.add(newElem);
	<%
			} catch (Exception e) {
	%>
				showError("Warning : message owner was removed from the system");
	<%
			}
		}
	%>			
</script>