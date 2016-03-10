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
<title>Insert title here</title>
</head>
<body>
	<sec:authorize access="hasRole('ROLE_GUARD')">
		<form:form action="GetData" method="POST" commandName="getTempInVisitor">
			<h1>Введите номер автомобиля</h1>
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
						<td>${tempVisitor.phoneNumber}<br/>${tempVisitor.phoneNumber2}<br/>${permanentVisitor.phoneNumber3}</td>
						<td>${permanentVisitor.carNumber}</td>
					</tr>
				</c:forEach>
			</table>
			<c:forEach items="${permanentVisitorList}" var="permanentVisitor">
			<tr>
				<td align="center" bgcolor="white">${permanentVisitor.carNumber}</td>
				<td align="center" bgcolor="white">${permanentVisitor.color}</td>
				<td align="center" bgcolor="white">${permanentVisitor.name}</td>
				<td align="center" bgcolor="white">${permanentVisitor.phoneNumber}<br/>${tempVisitor.phoneNumber2}<br/>${tempVisitor.phoneNumber3}</td>
				<td align="center" bgcolor="white">${permanentVisitor.address}</td>
			</tr>
		</c:forEach>
		<c:forEach items="${tempVisitorList}" var="tempVisitor">
			<tr>
				<td align="center" bgcolor="white">${tempVisitor.carNumber}</td>
				<td align="center" bgcolor="white">${tempVisitor.brand}</td>
				<td align="center" bgcolor="white"><input style="width:250px;height:25px;background-color: transparent;" type="text" name="realNumber" value="${tempVisitor.realNumber}"></td>
				<td align="center" bgcolor="white"><input class="button10" type="submit" name="action" value="${tempVisitor.visitorId}.${tempVisitor.status}" style="width:125px"/></td>
				<td align="center" bgcolor="white">${tempVisitor.aim}</td>
				<td align="center" bgcolor="white">${tempVisitor.phoneNumber}, ${tempVisitor.nameInf}, ${tempVisitor.address}</td>
				
			</tr>
		</c:forEach>
			<h1>Temp visitors</h1>
			<table border="2">
				<th>ID</th>
				<th>Дата</th>
				<th>Лицевой счет</th>
				<th>ФИО</th>
				<th>Номер телефона</th>
				<th>Гос. номер</th>
				<th>Цель</th>
				<th>Местоположение</th>
				<c:forEach items="${tempVisitorList}" var="tempVisitor">
					<tr>
						<td>${tempVisitor.visitorId}</td>
						<td>${tempVisitor.date}</td>
						<td>${tempVisitor.account}</td>
						<td>${tempVisitor.name}</td>
						<td>${tempVisitor.phoneNumber}</td>
						<td>${tempVisitor.carNumber}</td>
						<td>${tempVisitor.aim}</td>
						<td><input type="submit" name="action" value="${tempVisitor.visitorId}.OUT" style="width:60px"/> </td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
	</sec:authorize>
</body>
</html>