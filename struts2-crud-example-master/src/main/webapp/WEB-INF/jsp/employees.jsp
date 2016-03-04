<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<s:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type="text/javascript" src="<s:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title><s:text name="label.employees" /></title>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading center">
			<h3>
				<s:text name="application.title" />
			</h3>
		</div>
		<div class="panel-body">
			<ul class="nav nav-tabs">
				<s:if test="modeTab == 0">
					<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
					<li><a data-toggle="tab" href="#menu1">Menu 1</a></li>
				</s:if>
				<s:elseif test="modeTab == 1">
					<li><a data-toggle="tab" href="#home">Home</a></li>
					<li class="active"><a data-toggle="tab" href="#menu1">Menu 1</a></li>
				</s:elseif>
			</ul>

			<div class="tab-content">
				<div id="home" class="tab-pane fade in active">
					<h3>
						<s:text name="label.employees" />
					</h3>
					<s:url id="url" action="inputEmployee" />
					<a href="<s:property value="#url"/>"><s:text name="label.newEmployee"></s:text></a>
					<br/><br/>
					<table class="table table-striped table-bordered">
						<tr>
							<th><s:text name="label.no"/></th>
							<th><s:text name="label.firstName" /></th>
							<th><s:text name="label.lastName" /></th>
							<th><s:text name="label.age" /></th>
							<th><s:text name="label.department" /></th>
							<th>&nbsp;</th>
						</tr>
						<s:iterator value="employees" status="status">
							<tr>
								<td><s:property value="%{#status.index + 1}"/></td>
								<td><s:property value="firstName" /></td>
								<td><s:property value="lastName" /></td>
								<td><s:property value="age" /></td>
								<td><s:property value="department.name" /></td>
								<td><s:url action="inputEmployee" id="url">
										<s:param name="employee.employeeId" value="employeeId" />
									</s:url> <a href="<s:property value="#url"/>">Edit</a>
									&nbsp;&nbsp;&nbsp; <s:url action="deleteEmployee" id="url">
										<s:param name="employee.employeeId" value="employeeId" />
									</s:url> <a href="<s:property value="#url"/>">Delete</a></td>
							</tr>
						</s:iterator>
					</table>
				</div>
				<div id="menu1" class="tab-pane fade">
					<h3>
						<s:text name="label.departments" />
					</h3>
					<s:url id="url" action="newDepartment" />
					<a href="<s:property value="#url"/>"><s:text name="label.newDepartment"></s:text></a>
					<br/><br/>
					<table class="table table-striped table-bordered">
						<tr>
							<th><s:text name="label.no" /></th>
							<th><s:text name="label.department" /></th>
							<th>&nbsp;</th>
						</tr>
						<s:iterator value="departments" status="status1">
							<tr>
								<td><s:property value="%{#status1.index + 1}"/></td>
								<td><s:property value="name" /></td>
								<td><s:url action="newDepartment" id="url">
										<s:param name="department.departmentId" value="departmentId" />
									</s:url>
									<a href="<s:property value="#url"/>">Edit</a>
									&nbsp;&nbsp;&nbsp; <s:url action="deleteDepartment" id="url">
										<s:param name="department.departmentId" value="departmentId" />
									</s:url> <a href="<s:property value="#url"/>">Delete</a></td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>