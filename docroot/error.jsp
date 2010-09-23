<%@ include file="init.jsp"%>

<div>
	<div class="pageContent">
		<%
			String errorMessage = (String) request.getAttribute(PMConstants.ERROR_MESSAGE);
			if(errorMessage != null) {
		%>
			<div class="portlet-msg-error"><%=errorMessage%></div><br/>
		<%
				request.removeAttribute(PMConstants.ERROR_MESSAGE);
			}
		%>
		<%
			String infoMessage = (String) request.getAttribute(PMConstants.INFO_MESSAGE);
			if(infoMessage != null) {
		%>			
			<div class="portlet-msg-info"><%=infoMessage%></div><br/>
		<%
				request.removeAttribute(PMConstants.INFO_MESSAGE);
			}
		%>
	</div>
</div>