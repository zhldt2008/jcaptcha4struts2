<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JCaptcha4Struts2 - Demonstration Application</title>
</head>
<body>
<div>
<a href="http://code.google.com/p/jcaptcha4struts2"><img src='images/jc4s2_128.gif' style="border:0"/></a> 
<font face="verdana" size="1"><a href="http://code.google.com/p/jcaptcha4struts2">http://code.google.com/p/jcaptcha4struts2</a></font> 
<h2>Welcome to JCaptcha4Struts2 Demonstration Application</h2>
</div>
<br />
<ul>
	<li><a href="<s:url value='/form-no-intercept.jsp' />">Demo without interceptor</a></li>
	<li><a href="<s:url value='/form-intercept.jsp' />">Demo with interceptor</a></li>
	<li><a href="<s:url value='/form-intercept-simple.jsp' />">Demo with interceptor (Simple Theme)</a></li>
</ul>
</body>
</html>