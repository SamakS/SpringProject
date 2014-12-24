<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.krungsri.kbs.utils.Constants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=<%=Constants.PAGE_ENCODING%>">
<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">

<%
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setHeader("Cache-Control", "no-store"); // HTTP 1.1
	response.setDateHeader("Expires", 0);
%>

<script type="text/javascript">
	window.history.forward(1);
</script>

<script src="<c:url value="/resources/jQuery/jquery.js" />"></script>
<script src="<c:url value="/resources/jQuery/jquery-ui.min.js" />"></script>
<script src="<c:url value="/resources/jQuery/jquery.ui.datepicker-th.js" />"></script>
<script src="<c:url value="/resources/jQuery/jquery-ui-timepicker-addon.js" />"></script>
<script src="<c:url value="/resources/jQuery/easyloader.js" />"></script>
<script src="<c:url value="/resources/jQuery/jquery.easyui.min.js" />"></script>
<script src="<c:url value="/resources/jQuery/jquery.form.js" />"></script>
<script src="<c:url value="/resources/jQuery/ckeditor/ckeditor.js" />"></script>

<link href="<c:url value="/resources/jQuery/css/jquery-ui.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/jQuery/css/timepicker.css" />" rel="stylesheet">
<link href="<c:url value="/resources/jQuery/themes/default/easyui.css" />" rel="stylesheet">
<link href="<c:url value="/resources/jQuery/themes/icon.css" />" rel="stylesheet">
<link href="<c:url value="/resources/jQuery/themes/color.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/kbs.css" />" rel="stylesheet">