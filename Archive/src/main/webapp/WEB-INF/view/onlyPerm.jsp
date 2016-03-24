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
<title>Search</title><style>
.button10 {
  display: inline-block;
  color: black;
  font-size: 100%;
  font-weight: 700;
  text-decoration: none;
  user-select: none;
  padding: .25em .5em;
  outline: none;
  border: 1px solid black;
  border-radius: 7px;
  background: "#c0c0c0";
  box-shadow: inset 0 -2px 1px rgba(0,0,0,0), inset 0 1px 2px rgba(0,0,0,0), inset 0 0 0 60px rgba(255,255,0,0);
  transition: box-shadow .2s, border-color .2s;
} 
.button10:hover {
  box-shadow: inset 0 -1px 1px rgba(0,0,0,0), inset 0 1px 2px rgba(0,0,0,0), inset 0 0 0 60px rgba(255,255,0,.5);
}
.button10:active {
  padding: calc(.25em + 1px) .5em calc(.25em - 1px);
  border-color: rgba(177,159,0,1);
  box-shadow: inset 0 -1px 1px rgba(0,0,0,.1), inset 0 1px 2px rgba(0,0,0,.3), inset 0 0 0 60px rgba(255,255,0,.45);
}</style>
</head>
<body bgcolor="#c0c0c0">
	<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
	<sec:authorize access="hasRole('ROLE_GUARD')">
		<form:form action="ShowData" method="POST" commandName="permanentVisitor">
			<table>
			<tr><b>Введите номер автомобиля </b></tr>
			<tr>
				<td><input type="text" name="numb" style="width:250px;height:25px"/></td>
				<td width="250px"><input type="submit" class="button10" name="action" value="Найти" style="width:230px;height:40px" /></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td width="280px" height="50px"><input type="submit" class="button10" name="action" value="Автомобили на территории" style="width:250px;height:50px" /></td>
			</tr>
		</table>
		<h1 align="center">Постоянные пропуска</h1>
		<table border="2" width="1150px" cellpadding="8px" style="border-collapse: collapse">
		<th height="18px">Номер автомобиля</th>
		<th>Марка и цвет</th>
		<th>ФИО</th>
		<th>Телефоны</th>
		<th>Адрес</th>
		<c:forEach items="${permanentVisitorList}" var="permanentVisitor">
			<tr>
				<td align="center" bgcolor="white">${permanentVisitor.carNumber}</td>
				<td align="center" bgcolor="white">${permanentVisitor.brand} <br />${permanentVisitor.color}</td>
				<td align="center" bgcolor="white">${permanentVisitor.name}</td>
				<td align="center" bgcolor="white">${permanentVisitor.phoneNumber}<br/>${permanentVisitor.phoneNumber2}<br/>${permanentVisitor.phoneNumber3}</td>
				<td align="center" bgcolor="white">${permanentVisitor.address}</td>
			</tr>
		</c:forEach>
		</table>
		<h1 align="center">Временные пропуска</h1>
	<table border="2" width="1300px" cellpadding="8px" style="border-collapse: collapse">
		<th>Номер автомобиля</th>
		<th>Марка</th>
		<th>Фактический номер</th>
		<th>Въезд/выезд</th>
		<th>Цель приезда</th>
		<th>Информация о заказчике</th>
		
	</table>
	<input type="text" name="realNumber" style="opacity:0;transform:scale(0,0);">
		</form:form>
	</sec:authorize>
</body>
</html>