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
}
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
</head>
<body bgcolor="#c0c0c0">
	<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
		<form:form action="VisitorGetAdmin" method="POST" commandName="permanentVisitor">
		<h1 align="center">Ввод временных пропусков на автомобили</h1>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><b style="margin:40px">Введите информацию о заказчике</b></div>
		
		<i style="font-size:11pt;margin-left:20px;">(Фамилия, либо лицевой счет, либо номер телефона)</i>
		<div title="Введите номер лицевого счета, фио или номер телефона заказывающего">
			<input type="text" name="search" style="width:360px;height:20px">
			<input type="submit" name="action" class="button10" value="Найти" style="width:150px;height:30px">
			<input type="submit" name="action" class="button10" value="Закрыть" style="width:150px;height:30px;margin-left:100px">
			<input type="submit" value="Заказанные пропуска" name="action" style="margin-left:138px;width:280px;height:37px;" class="button10"/>
		</div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
	
		<b style="margin-left:800px;">Заказанные пропуска</b>
		<table bgcolor="#c0c0d9"  border="2" width="1300px" cellpadding="8px" style="border-collapse: collapse">
				<th style="align:center;width:70px;">Лицевой счет</th>
				<th style="align:center;width:150px;">ФИО</th>
				<th style="align:center;width:"140px;">Телефоны</th>
				<th style="align:center;width:200px;">Адрес</th>
				<th style="align:center;">Номер авто</th>
				<th style="align:center;">Марка авто</th>
				<th style="align:center;">Цель приезда</th>
				<th style="align:center;">Заказать пропуск</th>
				<c:forEach items="${tempVisitorList}" var="tempVisitor">
					<tr>
						<td align="center">${tempVisitor.account}</td>
						<td align="center">${tempVisitor.name}</td>
						<td align="center">${tempVisitor.phoneNumber}<br/>${tempVisitor.phoneNumber2}<br/>${tempVisitor.phoneNumber3}</td>
						<td align="center">${tempVisitor.address}</td>
						<td bgcolor="white" align="center">${tempVisitor.carNumber}</td>
						<td bgcolor="white" align="center">${tempVisitor.brand}</td>
						<td bgcolor="white" align="center">${tempVisitor.aim}</td>
						<td bgcolor="white" align="center"><button type="submit" name="action" value="${tempVisitor.visitorId}.+T" style="background:white;border:0;"><img src="https://pp.vk.me/c625321/v625321943/4b86a/TUms-7SPm_c.jpg" /></button> </td>
					</tr>
				</c:forEach>
				<c:forEach items="${permanentVisitorList}" var="permanentVisitor">
					<tr>
						<td align="center">${permanentVisitor.account}</td>
						<td align="center">${permanentVisitor.name}</td>
						<td align="center">${permanentVisitor.phoneNumber}<br/>${permanentVisitor.phoneNumber2}<br/>${permanentVisitor.phoneNumber3}</td>
						<td align="center">${permanentVisitor.address}</td>
						<td bgcolor="white" align="center">-</td>
						<td bgcolor="white"align="center">-</td>
						<td bgcolor="white" align="center">-</td>
						<td bgcolor="white" align="center"><button type="submit" name="action" value="${permanentVisitor.visitorId}.+V" style="background:white;border:0;"><img src="https://pp.vk.me/c625321/v625321943/4b86a/TUms-7SPm_c.jpg" /></button> </td>
					</tr>
				</c:forEach>
				
			</table>
	</form:form>
	</body>
</html>