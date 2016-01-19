<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:url value='/js/jquery-1.11.1.min.js'/>"></script>
<title><s:text name="label.employees" /></title>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading center">
			<h3><s:text name="application.title" /></h3>
		</div>
		<div class="panel-body">
			<h1>
				<s:text name="label.employees" />
			</h1>
			<s:url id="url" action="inputEmployee" />
			<a href="<s:property value="#url"/>"><s:text name="label.new"></s:text></a> <br /> <br />
			<table class="table table-striped table-bordered">
				<tr>
					<th><s:text name="label.firstName" /></th>
					<th><s:text name="label.lastName" /></th>
					<th><s:text name="label.age" /></th>
					<th><s:text name="label.department" /></th>
					<th>&nbsp;</th>
				</tr>
				<s:iterator value="employees" status="status">
					<tr>
						<td><s:property value="firstName" /></td>
						<td><s:property value="lastName" /></td>
						<td><s:property value="age" /></td>
						<td><s:property value="department.name" /></td>
						<td><s:url action="inputEmployee" id="url">
								<s:param name="employee.employeeId" value="employeeId" />
							</s:url> <a href="<s:property value="#url"/>">Edit</a> &nbsp;&nbsp;&nbsp; <s:url action="deleteEmployee" id="url">
								<s:param name="employee.employeeId" value="employeeId" />
							</s:url> <a href="<s:property value="#url"/>">Delete</a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</body>
</html>