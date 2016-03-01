<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Struts 2 file upload example</h1>
	User Image: <s:property value="userImage" />
	<br/>
	
	Content Type: <s:property value="userImageContentType" />
	<br/>
	
	File Name: <s:property value="userImageFileName" />
	<br/>
	
	Uploaded Image:
	<img src="userimages/<s:property value="userImageFileName"/>"/>
</body>
</html>