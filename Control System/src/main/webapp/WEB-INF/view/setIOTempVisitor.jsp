<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Временные пропуска</title>
</head>
<body>
	<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
	<sec:authorize access="hasRole('ROLE_GUARD')">
		<form:form action="ShowData" method="POST" commandName="setIOTempVisitor">
			<table>
			<tr><h2>Поиск временного пропуска </h2></tr>
			<tr>
				<td>Номер: </td>
				<td><input name="number"/></td>
			</tr>
			<tr>
				<td colspan="1">
					<input type="submit" name="action" value="Найти" style="width:60px;height:30px" />
				</td>
			</tr>
		</table>
		<h1>Жители</h1>
		<table border="2">
		<th>ID</th>
		<th>Дата</th>
		<th>Лицевой счет</th>
		<th>ФИО</th>
		<th>Номера телефонов</th>
		<th>Гос. номер</th>
		<c:forEach items="${permanentVisitorList}" var="permanentVisitor">
			<tr>
				<td>${permanentVisitor.visitorId}</td>
				<td>${permanentVisitor.date}</td>
				<td>${permanentVisitor.account}</td>
				<td>${permanentVisitor.name}</td>
				<td>${permanentVisitor.phoneNumber}<br/>${permanentVisitor.phoneNumber2}<br/>${permanentVisitor.phoneNumber3}</td>
				<td>${permanentVisitor.carNumber}</td>
			</tr>
		</c:forEach>
		</table>
		<h1>Временные пропуска</h1>
	<table border="2">
		<th>ID</th>
		<th>Дата</th>
		<th>Лицевой счет</th>
		<th>ФИО</th>
		<th>Номера телефонов</th>
		<th>Гос. номер</th>
		<th>Цель</th>
		<th>Местоположение</th>
		<c:forEach items="${tempVisitorList}" var="tempVisitor">
			<tr>
				<td>${tempVisitor.visitorId}</td>
				<td>${tempVisitor.date}</td>
				<td>${tempVisitor.account}</td>
				<td>${tempVisitor.name}</td>
				<td>${tempVisitor.phoneNumber}<br/>${tempVisitor.phoneNumber2}<br/>${tempVisitor.phoneNumber3}</td>
				<td>${tempVisitor.carNumber}</td>
				<td>${tempVisitor.aim}</td>
				<td>${tempVisitor.isHere}</td>
			</tr>
		</c:forEach>
	</table>
		</form:form>
	</sec:authorize>
</body>
</html>