<%
	if (session.getAttribute("ROLE") == null || session.getAttribute("ROLE").equals("user")) {
	response.sendRedirect(request.getContextPath() + "/Login");
}
%>

