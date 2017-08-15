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
<title>Contact update</title>
</head>

<body>
	<form:form method="POST" modelAttribute="contactDto">
		<h1 id="NoteCentr">Update contact</h1>

		<div class="divErr">
				${error}
		</div>

		  <table>

			<tr>
				<td id="head"><form:label path="firstName">First name*:</form:label></td>
				<td><form:input path="firstName" value="${contact.firstname}"/></td>
				<td><form:errors class="textErr" path="firstName" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="lastName">Last name*:</form:label></td>
				<td><form:input path="lastName" value="${contact.lastname}"/></td>
				<td><form:errors class="textErr" path="lastName" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="middleName">Middle name*:</form:label></td>
				<td><form:input path="middleName" value="${contact.middlename}"/></td>
				<td><form:errors class="textErr" path="middleName" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="mobPhoneNumber">Mobile phone number*:</form:label></td>
				<td><form:input path="mobPhoneNumber" placeholder="+380(00)1234567" value="${contact.mobPhoneNumber}" /></td>
				<td><form:errors class="textErr" path="mobPhoneNumber" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="homePhoneNumber">Home phone number:</form:label></td>
				<td><form:input path="homePhoneNumber" placeholder="12-34-56" value="${contact.homePhoneNumber}"/></td>
				<td><form:errors class="textErr" path="homePhoneNumber" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="address">Address:</form:label></td>
				<td><form:textarea path="address" placeholder="Ukraine, c. Kiev, str. Borschagivska, 148"
					rows="2" cols="21" value="${contact.address}"/></td>
				<td><form:errors class="textErr" path="address" /><td>
			</tr>

			<tr>
				<td id="head"><form:label path="email">Email:</form:label></td>
				<td><form:input path="email" placeholder="test@mail.ua" value="${contact.email}"/></td>
				<td><form:errors class="textErr" path="email" /><td>
			</tr>

		  </table>

		<div class="divErr">
			${error1}
		</div>
		<div class="divErr">
				${error2}
		</div>

		<input type="submit" class="button" value="Update">
		<a href="./showContacts" class="button">Return to previous page</a>

	</form:form>


</body>
</html>
