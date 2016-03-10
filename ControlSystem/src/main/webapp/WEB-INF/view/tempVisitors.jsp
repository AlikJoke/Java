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

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 
</head>
<body onload="init()" bgcolor="#c0c0c0">
	<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<form:form action="BackToAdd" method="POST" commandName="tempVisitors" >
		<table>
		<tr>
		<td><h1 align="center">Заказанные пропуска</h1><td>
		<td><input align="left" style="width:125px;height:45px" type="submit" name="action" class="button10" value="Закрыть" /></td>
		<tr>
		</table>
		</form:form>
		<form:form action="DeleteTemp" method="POST" commandName="tempVisitors" >
	<table border="2" width="1300px" cellpadding="8px" style="border-collapse: collapse">
		<th>Номер автомобиля</th>
		<th>Марка</th>
		<th>Цель приезда</th>
		<th>Дата регистрации<br/> пропуска</th>
		<th>Дата окончания<br/>срока пропуска</th>
		<th>Информация о заказчике</th>
		<th>Удалить пропуск</th>
		<c:forEach items="${tempVisitorList}" var="tempVisitor">
			<tr>
				<td align="center" bgcolor="white">${tempVisitor.carNumber}</td>
				<td align="center" bgcolor="white">${tempVisitor.brand}</td>
				<td align="center" bgcolor="white">${tempVisitor.aim}</td>
				<td align="center" bgcolor="white">${tempVisitor.date}</td>
				<td align="center" bgcolor="white">${tempVisitor.dateTo}</td>
				<td align="center" bgcolor="white">${tempVisitor.nameInf}, ${tempVisitor.address}<br/>${tempVisitor.phoneNumber}<br/>${tempVisitor.phoneNumber2}<br/>${tempVisitor.phoneNumber3}</td>
				<td bgcolor="white" align="center"><button type="submit" name="action" value="${tempVisitor.visitorId}.del" style="background:white;border:0;"><img src="https://pp.vk.me/c625321/v625321943/4baab/1Bf1CCpVvhg.jpg"/></button></td>
			</tr>
		</c:forEach>
	</table>
	<input type="text" name="numb" style="opacity:0; transform:scale(0,0)">
		</form:form>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_DISPATCHER')">
		<form:form action="BackToAdd" method="POST" commandName="permanentVisitor" modelAttribute="temp" >
		<table>
		<tr>
		<td><h1 align="center">Заказанные пропуска</h1><td>
		<td><input align="left" style="width:125px;height:45px" type="submit" name="action" class="button10" value="Закрыть" /></td>
		<tr>
		</table>
		</form:form>
		<form:form action="DeleteTemp" method="POST" commandName="tempVisitors" >
	<table border="2" width="1300px" cellpadding="8px" style="border-collapse: collapse">
		<th>Номер автомобиля</th>
		<th>Марка</th>
		<th>Цель приезда</th>
		<th>Дата регистрации<br/> пропуска</th>
		<th>Дата окончания<br/>срока пропуска</th>
		<th>Информация о заказчике</th>
		<th>Удалить пропуск</th>
		<c:forEach items="${tempVisitorList}" var="tempVisitor">
			<tr>
				<td align="center" bgcolor="white">${tempVisitor.carNumber}</td>
				<td align="center" bgcolor="white">${tempVisitor.brand}</td>
				<td align="center" bgcolor="white">${tempVisitor.aim}</td>
				<td align="center" bgcolor="white">${tempVisitor.date}</td>
				<td align="center" bgcolor="white">${tempVisitor.dateTo}</td>
				<td align="center" bgcolor="white">${tempVisitor.nameInf}, ${tempVisitor.address}<br/>${tempVisitor.phoneNumber}<br/>${tempVisitor.phoneNumber2}<br/>${tempVisitor.phoneNumber3}</td>
				<td bgcolor="white" align="center"><button type="submit" name="action" value="${tempVisitor.visitorId}.del" style="background:white;border:0;"><img src="https://pp.vk.me/c625321/v625321943/4baab/1Bf1CCpVvhg.jpg"/></button></td>
			</tr>
		</c:forEach>
	</table>
	<input type="text" name="numb" style="opacity:0; transform:scale(0,0)">
	<input type="text" name="realNumber" style="opacity:0; transform:scale(0,0)">
		</form:form>
	</sec:authorize>
</body>
</html>