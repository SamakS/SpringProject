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
var url;

function deleteRecord(){
	alert('delete');
}

</script>
</head>
<body>
	<div id="wrapper">
		<div id="header">		
			<!-- add header -->
		</div>
		<div id="content">			
			<form:form commandName="mktAdminForm" method="POST">	
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
    				<div id="toolbar">
    					<a href=<c:url value='/marketingProgramAdmin?state=add' /> target="_parent"  class="easyui-linkbutton" iconCls="icon-add" id="addData" plain="true">New</a>
    					<a href=<c:url value='/marketingProgramAdmin?state=edit' /> target="_parent"  class="easyui-linkbutton" iconCls="icon-edit" id="editData" plain="true">Edit</a>
    					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" id="deleteData" plain="true" onclick="deleteRecord()">Delete</a>    					    				
					</div>
					<table id="marketTable" 
						   class="easyui-datagrid" 
						   style="width:1040px;height:500px;" 						   
						   title="<spring:message code='marketing.name'/>"
						   toolbar="#toolbar" 
						   pagination="true" 						   
						   fitColumns="true" 
						   singleSelect="true">						 
						<thead>
							<tr>
								<th data-options="field:'ck',checkbox:true"></th>
								<th field="name" width="100">Name</th>
								<th field="status" width="100">Status</th>
								<th field="creator" width="100">Creator</th>
								<th field="createdDate" width="100">Created Date</th>
								<th field="updatedDate" width="100">Updated Date</th>
							</tr>
						</thead>						
					</table>
    			</div>
			</div>		
			</form:form>
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