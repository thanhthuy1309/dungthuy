<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="employee==null || employee.employeeId == null">
	<s:set name="title" value="%{'Add new employee'}" />
</s:if>
<s:else>
	<s:set name="title" value="%{'Update employee'}" />
</s:else>

<html>
<head>
<link href="<s:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:url value='/js/jquery-1.11.1.min.js'/>"></script>
<style>
</style>
<title><s:property value="#title" /></title>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading center">
			<h3>
				<s:text name="application.title" />
			</h3>
		</div>
		<div class="panel-body">
			<h1>
				<s:property value="#title" />
			</h1>
			<s:actionerror />
			<s:actionmessage />
			<s:form action="saveEmployee" method="post">
				<s:textfield name="employee.firstName" value="%{employee.firstName}" label="%{getText('label.firstName')}" size="40" cssClass="mt10 form-control"/>
				<s:textfield name="employee.lastName" value="%{employee.lastName}" label="%{getText('label.lastName')}" size="40" cssClass="mt10 form-control"/>
				<s:textfield name="employee.age" value="%{employee.age}" label="%{getText('label.age')}" size="20" cssClass="mt10 form-control"/>
				<s:hidden name="employee.employeeId" value="%{employee.employeeId}" />
				<s:select name="employee.department.departmentId" value="%{employee.department.departmentId}" list="departments" label="%{getText('label.department')}" 
							listKey="departmentId" listValue="name" cssClass="mt10 form-control"/>
				<s:submit value="%{getText('button.label.submit')}" cssClass="btn btn-primary mt10"/>
				<s:submit value="%{getText('button.label.cancel')}" action="index" cssClass="btn btn-default mt10"/>
			</s:form>
		</div>
	</div>
</body>
</html>