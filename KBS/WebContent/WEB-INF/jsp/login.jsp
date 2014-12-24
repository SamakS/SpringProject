<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<jsp:include flush="true" page="./header.jsp" />	
<title><spring:message code="application.name"/></title>
<script type="text/javascript">
</script>
</head>
<body>
<div class="easyui-dialog" style="width: 400px; height: 150px; padding: 5px 5px" resizable="false" modal="true" closed="false" maximizable="false" minimizable="false" closable="false" title="<c:out value='${loginTitle}'/>" buttons="#dlg-buttons">
<form:form commandName="form1" method="POST" action="/KBS/authen">
	<table border="0" width="100%">
 		<tr>
 			<td><form:label path="userName">User Name:</form:label></td>
 			<td><form:input path="userName"/></td>
 		</tr>
 		<tr>
 			<td><form:label path="password">Password:</form:label></td>
 			<td><form:input path="password"/></td>
 		</tr>
 		<tr>
 			<td colspan="2" align="center">
 				<input type="submit" value="Submit"/>
				<input type="reset" value="Reset"/>
 			</td>
 		</tr>  		
	</table>	
</form:form>
</div>
</body>
</html>