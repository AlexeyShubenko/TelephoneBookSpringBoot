<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./static/css/logout.css" rel="stylesheet">
<title>Log out</title>
</head>
<body>
		<div class="divTop">
			<div class="divRight">login: ${userDto.loginName}</div>
		</div>
		
		<h1 id="NoteCentr">Do you want to log out?</h1>
		<div class="buttons">
		<a href="./exit" class="button">Exit</a>
		<a href="./showContacts" class="button">Return to main page</a>
		</div>
</body>
</html>
