<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Struts2 File Upload & Save Example without Database</h2>
	<s:actionerror />
	<s:form action="userImage" method="post" namespace="/" enctype="multipart/form-data">
		<s:file name="userImage" label="Image" />
		<s:submit value="Upload" align="center" />
	</s:form>
</body>
</html>