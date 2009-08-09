<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://code.google.com/p/jcaptcha4struts2/taglib/2.0" prefix="jcaptcha" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JCaptcha4Struts2 - Demonstration Application</title>
</head>
<body>
<s:form action="form-intercept">
	<s:textfield name="text" label="Text"/>
	
	<!-- The JCaptcha Control -->
	<jcaptcha:image label="Type the text "/>
	
	<s:submit />
</s:form>
</body>
</html>