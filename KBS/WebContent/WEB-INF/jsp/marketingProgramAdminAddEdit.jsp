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

window.onload = function() {    
    CKEDITOR.replace( 'description' );
};

$(function(){
	$("#startDate").datepicker({
		changeMonth: true,
		changeYear: true,
		showOn: "button",
		buttonImage: "<c:url value='/resources/images/calendar.gif' />",
		buttonImageOnly: true,
		showWeek: true,
		firstDay: 1
	});
	
	$("#endDate").datepicker({
		changeMonth: true,
		changeYear: true,
		showOn: "button",
		buttonImage: "<c:url value='/resources/images/calendar.gif' />",
		buttonImageOnly: true,
		showWeek: true,
		firstDay: 1
	});
});
</script>
</head>
<body>
	<div id="wrapper">
		<div id="header">		
			<!-- add header -->
		</div>
		<div id="content">	
			<div class="easyui-layout" style="width:100%;height:520px;">
				<div data-options="region:'west',split:true" style="width:250px;text-align: left;" align="left">
					<table id="navigatorTable" 
						   class="easyui-treegrid"
						   style="width:250px;height:500px"
						   data-options="treeField: 'navigator'">
						<thead>
            				<tr>
               	 				<th data-options="field:'navigator'" width="240">Admin</th>
               	 			</tr>
               	 		</thead>
               	 		<tbody>
               	 			<tr>
               	 				<td>
               	 					<a href="<c:url value='/marketingProgramAdmin?state=init' />" target="_parent">Marketing Program</a>               	 					
               	 				</td>               	 			               	 				
               	 			</tr>
               	 			<tr>
               	 				<td>               	 					
               	 					<a href="<c:url value='/customer' />" target="_parent">Customer</a>
               	 				</td>
               	 			</tr>
               	 			<tr>
               	 				<td>               	 					
               	 					<a href="<c:url value='/kbsExcBooth' />" target="_parent">KBS Exc Booth Database</a>
               	 				</td>
               	 			</tr>
               	 			<tr>
               	 				<td>               	 					
               	 					<a href="<c:url value='/kbsExcBooth' />" target="_parent">KBS Exc Booth Elasticsearch</a>
               	 				</td>
               	 			</tr>
               	 		</tbody>
					</table>
				</div>
    			<div data-options="region:'center'" style="padding:5px;">
    				<div class="easyui-layout" title="<c:out value='${title}'/>" style="padding: 10px;width: 95%;height: auto">
    					<form:form commandName="mktAdminForm" method="POST" action="/KBS/marketingProgramAdminAddEdit?state=save" enctype="multipart/form-data">    	    						
    						<div><h2><c:out value='${title}'/></h2></div>
    						<fieldset>
    							<legend><spring:message code='title.generate'/></legend>
    							<table border="0" cellspacing="10" style="width: 100%">
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.path'/></td>
	    								<td><form:input path="path" size="70"/></td>
	    							</tr>
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.name'/></td>
	    								<td><form:input path="name" size="70"/></td>
	    							</tr>
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.overview'/></td>
	    								<td><form:textarea path="overview" cols="50" rows="2" /></td>
	    							</tr>
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.keyword'/></td>
	    								<td><form:textarea path="keyword" cols="50" rows="2" /></td>
	    							</tr>
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.icon'/></td>
	    								<td>	    								
	    									<input type="file" name="iconFile">	    									
	    								</td>
	    							</tr>
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.status'/></td>
	    								<td>
	    									<form:select path="status" >
												<form:option value="0" label="Select" />
												<form:options items="${statusList}" itemValue="statusId" itemLabel="statusName" />												
											</form:select>
	    								</td>
	    							</tr>
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.group'/></td>
	    								<td>
	    									<form:checkboxes path="groupList" items="${groupList}" itemValue="key" itemLabel="value" />	    									
	    								</td>
	    							</tr>	    							
	    						</table> 
    						</fieldset>
	    					<fieldset>
    							<legend><spring:message code='title.description'/></legend>	   						    						    						    						
	    						<table border="0" cellspacing="10" style="width: 100%">
	    							<tr>	    								
	    								<td colspan="2"><form:textarea path="description" /></td>
	    							</tr>
	    							<tr>	    								
	    								<td colspan="2"><spring:message code='mkt.description.remark'/></td>
	    							</tr>
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.startdate'/></td>
	    								<td><form:input path="startDate" size="50"/></td>
	    							</tr>
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.enddate'/></td>
	    								<td><form:input path="endDate" size="50"/></td>
	    							</tr>	    							    						
	    						</table>    						
    						</fieldset>	
    						<fieldset>
    							<legend><spring:message code='title.attachment'/></legend>
    							<table border="0" cellspacing="10" style="width: 100%">
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.attachment1'/></td>
	    								<td><input type="file" name="attachmentFile1"></td>
	    							</tr>
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.attachment2'/></td>
	    								<td><input type="file" name="attachmentFile2"></td>
	    							</tr>
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.attachment3'/></td>
	    								<td><input type="file" name="attachmentFile3"></td>
	    							</tr>
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.attachment4'/></td>
	    								<td><input type="file" name="attachmentFile4"></td>
	    							</tr> 
	    							<tr>
	    								<td width="30%" align="right"><spring:message code='mkt.attachment5'/></td>
	    								<td><input type="file" name="attachmentFile5"></td>
	    							</tr>   							    						
	    						</table>  
    						</fieldset>
    						<fieldset>
    							<legend><spring:message code='title.link'/></legend>
    							<table border="0" cellspacing="10" style="width: 100%">
    								<tr>
    									<td width="30%" align="right"><spring:message code='mkt.link.remark'/></td>
	    								<td><form:textarea path="overview" cols="50" rows="2" /></td>
	    							</tr>
    							</table>
    						</fieldset>
    						<div align="center">
    							<input type="submit" value="Save">
    							<input type="button" value="Cancel">
    						</div>
    					</form:form>		 		
    				</div>
				</div>    				
			</div>		
		</div>
	</div>
	<div>
	</div>
	<div id="footer">
		<div id="footertext">
			<p>
				<spring:message code="footer.text" />
			</p>
		</div>
	</div>
</body>
</html>