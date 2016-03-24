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
<title>Permanent visitors</title>
<style>
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
<sec:authorize access="hasRole('ROLE_DISPATCHER')">
		<form:form action="VisitorGet" method="POST" commandName="permanentVisitor">
		<h1 align="center">Ввод временных пропусков на автомобили</h1>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><b style="margin:40px">Введите информацию о заказчике</b></div>
		
		<i style="font-size:2">(Фамилия, либо лицевой счет, либо номер телефона)</i>
		<div title="Введите номер лицевого счета, фио или номер телефона заказывающего">
			<input type="text" name="search" style="width:360px;height:20px">
			<input type="submit" name="action" class="button10" value="Найти" style="width:150px;height:30px">
		</div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
	
		<b style="margin-left:800px;">Заказанные временные пропуска</b>
		<table bgcolor="#c0c0d9"  border="2" width="1300px" cellpadding="8px" style="border-collapse: collapse">
				<th>Лицевой счет</th>
				<th>ФИО</th>
				<th>Телефоны</th>
				<th>Адрес</th>
				<th>Номер авто</th>
				<th>Марка авто</th>
				<th>Цель приезда</th>
				<th>Заказать пропуск</th>
				<c:forEach items="${permanentVisitorList}" var="permanentVisitor">
					<tr>
						<td>${permanentVisitor.account}</td>
						<td>${permanentVisitor.name}</td>
						<td>${permanentVisitor.phoneNumber}<br/>${permanentVisitor.phoneNumber2}<br/>${permanentVisitor.phoneNumber3}</td>
						<td>${permanentVisitor.address}</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td bgcolor="white" align="center"><input type="image" src="https://pp.vk.me/c625321/v625321943/4b86a/TUms-7SPm_c.jpg" name="action" value="${permanentVisitor.visitorId}.+" /> </td>
					</tr>
				</c:forEach>
			</table>
	</form:form>
	</sec:authorize>
</body>
</html>