<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./static/css/registUpdate.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User registration</title>
</head>

<body>

<div>
	<form:form method="POST" modelAttribute="userDto" action="" >
		<h1 id="NoteCentr">Login Page</h1>
		<div class="textErr">
			${error}
		</div>
	  <table>

	  	<tr>
			<td id="head"><form:label path="loginName">Login:</form:label></td>
			<td><form:input path="loginName"/></td>
			<td><form:errors path="loginName" class="textErr"/><td>
		</tr>
	  	
	  	<tr>
			<td id="head"><form:label path="password">Password:</form:label></td>
			<td><form:input path="password"/></td>
			<td><form:errors path="password" class="textErr"/><td>
		</tr>
	  	
		<tr>
			<td id="head"><form:label path="fio">Full name:</form:label></td>
			<td><form:input path="fio"/></td>
			<td><form:errors path="fio" class="textErr"/></td>
		</tr>
					
 	  </table>
 	  	
			<input type="submit" class="button" value="Save">

			<a href="../views" class="button">Return To Main Page</a>
		<div><spring:message code="title.login" /> </div>
	</form:form>
</div>

</body>
</html>
