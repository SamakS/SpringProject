<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KBS</title>
</head>
<body>
<div align="center">
		<h1>LM Campaign List</h1>
	
		<table border="1">
			<tr>
				<th>No</th>
				<th>Campaign Code</th>
				<th>Description</th>
				<th>Start</th>
				<th>End</th>				
				<th>Update Time</th>			
			<tr>
			<c:forEach var="campaign" items="${lmCampaignList}" varStatus="status">
				
			<tr>
				<td>${status.index + 1}</td>
				<td>${campaign.campcode}</td>
				<td>${campaign.offerDescription}</td>
				<td>${campaign.offerStartDt}</td>
				<td>${campaign.offerEndDt}</td>				
				<td>${campaign.updateDate}</td>
			</tr>
				
			</c:forEach>		
		</table>
	</div>
</body>
</html>