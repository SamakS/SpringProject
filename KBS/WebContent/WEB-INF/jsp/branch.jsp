<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KBS</title>
</head>
<body>
	<div align="center">
		<h1>Branch List</h1>
	
		<table border="1">
			<tr>
				<th>No</th>
				<th>Branch Code</th>
				<th>Region</th>
				<th>Branch Name</th>
				<th>Work Day Open Period</th>
				<th>SAT Open Period</th>
				<th>SUN Open Period</th>
				<th>Open Special Holiday Flag</th>
				<th>Check CLR Time</th>
				<th>Has ADM Flag</th>
				<th>Has AUP Flag</th>
				<th>Phone No.</th>
				<th>Fax No.</th>
				<th>Address</th>
				<th>Landmark</th>
				<th>Remark</th>
				<th>Update Time</th>			
			<tr>
			<c:forEach var="branch" items="${branchList}" varStatus="status">
				
			<tr>
				<td>${status.index + 1}</td>
				<td>${branch.branchCode}</td>
				<td>${branch.region}</td>
				<td>${branch.branchName}</td>
				<td>${branch.workDayOpenPeriod}</td>
				<td>${branch.satOpenPeriod}</td>
				<td>${branch.sunOpenPeriod}</td>
				<td>${branch.openSpecialHolidayFlag}</td>
				<td>${branch.checkClrTime}</td>
				<td>${branch.hasAdmFlag}</td>
				<td>${branch.hasAupFlag}</td>
				<td>${branch.phoneNo}</td>
				<td>${branch.faxNo}</td>
				<td>${branch.address}</td>					
				<td>${branch.landmark}</td>
				<td>${branch.remark}</td>
				<td>${branch.updateTime}</td>
			</tr>
				
			</c:forEach>		
		</table>
	</div>
</body>
</html>