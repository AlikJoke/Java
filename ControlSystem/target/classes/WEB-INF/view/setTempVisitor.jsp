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
<title>Оформить временный пропуск</title>
</head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>s
<body>
<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
<sec:authorize access="hasRole('ROLE_DISPATCHER')">
	<form:form action="BackToPermanent" method="POST" commandName="getPermanentVisitor">
				<table>
					<tr>
						<td><h3>Вернуться на предыдущую страницу </h3></td>
						<td><input type="submit" name="action" value="Вернуться" style="width:80px;height:30px" /></td>
					</tr>
				</table>
	</form:form>
<form:form action="AddTemp" method="POST" commandName="setTempVisitor">
		
		<h2>Форма для создания временного пропуска</h2>
		<table>
			<tr>
				<td>Дата</td>
				<td><input type="date" name="date" value="${today}" /></td>
			</tr>
			<tr>
				<td>Гос. номер</td>
				<td><input name="carNumber" /></td>
			</tr>
			<tr>
				<td>Цель</td>
				<td><input name="aim" /></td>
			</tr>
			<tr>
				<td colspan="1">
					<input type="submit" name="action" value="Добавить" style="width:75px;height:30px" />
				</td>
			</tr>
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
		<c:forEach items="${tempVisitorList}" var="tempVisitor">
			<tr>
				<td>${tempVisitor.visitorId}</td>
				<td>${tempVisitor.date}</td>
				<td>${tempVisitor.account}</td>
				<td>${tempVisitor.name}</td>
				<td>${tempVisitor.phoneNumber}</td>
				<td>${tempVisitor.carNumber}</td>
				<td>${tempVisitor.aim}</td>
			</tr>
		</c:forEach>
	</table>
</form:form>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<form:form action="BackToPermanent" method="POST" commandName="getPermanentVisitor">
				<table>
					<tr>
						<td><h3>Вернуться на предыдущую страницу </h3></td>
						<td><input type="submit" name="action" value="Вернуться" style="width:80px;height:30px" /></td>
					</tr>
				</table>
	</form:form>
<form:form action="AddTemp" method="POST" commandName="setTempVisitor">
		<h2>Форма для создания временного пропуска</h2>
		<table>
			<tr>
				<td>Дата</td>
				<td><input type="text" id="datepicker" name="date" value="${today}" /></td>
			</tr>
			<tr>
				<td>Гос. номер</td>
				<td><input name="carNumber" /></td>
			</tr>
			<tr>
				<td>Марка</td>
				<td><input name="brand" /></td>
			<tr>
				<td>Цель</td>
				<td><input name="aim" /></td>
			</tr>
			<tr>
				<td colspan="1">
					<input type="submit" name="action" value="Добавить" style="width:75px;height:30px" />
				</td>
			</tr>
		</table>
		<h1>Временные пропуска</h1>
	<table border="2">
		<th>ID</th>
		<th>Дата</th>
		<th>Лицевой счет</th>
		<th>ФИО</th>
		<th>Номер телефона</th>
		<th>Адрес</th>
		<th>Гос. номер</th>
		<th>Марка</th>
		<th>Фактический номер</th>
		<th>Цель</th>
		<c:forEach items="${tempVisitorList}" var="tempVisitor">
			<tr>
				<td>${tempVisitor.visitorId}</td>
				<td>${tempVisitor.date}</td>
				<td>${tempVisitor.account}</td>
				<td>${tempVisitor.name}</td>
				<td>${tempVisitor.phoneNumber}</td>
				<td>${tempVisitor.address}</td>
				<td>${tempVisitor.carNumber}</td>
				<td>${tempVisitor.brand}</td>
				<td>${tempVisitor.realNumber}</td>
				<td>${tempVisitor.aim}</td>
			</tr>
		</c:forEach>
	</table>
</form:form>
</sec:authorize>
</body>
</html>