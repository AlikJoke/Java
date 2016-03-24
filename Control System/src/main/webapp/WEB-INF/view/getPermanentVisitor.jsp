<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<form:form action="BackToAdd" method="POST" commandName="permanentVisitor">
				<table>
					<tr>
						<td><h3>Вернуться на предыдущую страницу </h3></td>
						<td><input type="submit" name="action" value="Вернуться" style="width:80px;height:30px" /></td>
					</tr>
				</table>
	</form:form>
	<form:form action="SearchAction" method="POST" commandName="getPermanentVisitor">
		
		<table>
			<tr>
				<td>Л/с или ФИО</td>
				<td><input name="search"/></td>
			</tr>
			<tr>
				<td colspan="1">
					<input type="submit" name="action" value="Найти" style="width:60px;height:30px" />
				</td>
			</tr>
		</table>
	</form:form>
	<form:form action="VisitorTemp" method="POST" commandName="setTempVisitor">
		<h1>Жители</h1>
	<table border="2">
		<th>ID</th>
		<th>Дата</th>
		<th>Лицевой счет</th>
		<th>ФИО</th>
		<th>Номера телефонов</th>
		<th>Гос. номер</th>
		<th>Марка и цвет</th>
		<th>Адрес</th>
		<c:forEach items="${permanentVisitorList}" var="permanentVisitor">
			<tr>
				<td>${permanentVisitor.visitorId}</td>
				<td>${permanentVisitor.date}</td>
				<td>${permanentVisitor.account}</td>
				<td>${permanentVisitor.name}</td>
				<td>${permanentVisitor.phoneNumber}<br/>${permanentVisitor.phoneNumber2}<br/>${permanentVisitor.phoneNumber3}</td>
				<td>${permanentVisitor.carNumber}</td>
				<td>${permanentVisitor.color}</td>
				<td>${permanentVisitor.address}</td>
				<td> 
		<input type="submit" name="action" value="${permanentVisitor.visitorId}. Оформить временный пропуск" style="width:300px;height:30px" />
	</td>
			</tr>
		</c:forEach>
	</table>
	</form:form>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_DISPATCHER')">
	<form:form action="BackToAdd" method="POST" commandName="permanentVisitor">
				<table>
					<tr>
						<td><h3>Вернуться на предыдущую страницу </h3></td>
						<td><input type="submit" name="action" value="Вернуться" style="width:80px;height:30px" /></td>
					</tr>
				</table>
	</form:form>
	<form:form action="SearchAction" method="POST" commandName="getPermanentVisitor">
		<table>
			<tr>
				<td>Л/с или ФИО</td>
				<td><input name="search"/></td>
			</tr>
			<tr>
				<td colspan="1">
					<input type="submit" name="action" value="Найти" style="width:60px;height:30px" />
				</td>
			</tr>
		</table>
	</form:form>
	<form:form action="VisitorTemp" method="POST" commandName="setTempVisitor">
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
				<td> 
		<input type="submit" name="action" value="${permanentVisitor.visitorId}. Оформить временный пропуск" style="width:300px;height:30px" />
	</td>
			</tr>
		</c:forEach>
	</table>
	</form:form>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_GUARD')">
		<form:form action="GetData" method="POST" commandName="getPermanentVisitor">
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
						<td><input type="submit" name="action" value="${tempVisitor.visitorId}.${tempVisitor.status}" style="width:125px"/> </td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
	</sec:authorize>
</body>
</html>