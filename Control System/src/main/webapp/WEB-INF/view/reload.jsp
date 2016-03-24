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
.b-container{
    width:200px;
    height:150px;
    background-color: #ccc;
    margin:0px auto;
    padding:10px;
    font-size:30px;
    color: #fff;
}
.b-popup{
    width:100%;
    position:absolute;
    min-height:100%;
    background-color: rgba(0,0,0,0.5);
    overflow:hidden;
    position:fixed;
    top:0px;
}
.b-popup .b-popup-content{
	position:fixed;
    top:30%;
 	left:33%;
    width:400px;
    height: 110px;
    padding:10px;
    background-color: #c5c5c5;
    border-radius:5px;
    box-shadow: 0px 0px 10px #000;
}
</style>
</head>

<body bgcolor="#c0c0c0">
	<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	
	<form:form action="VisitorAction" method="POST" commandName="permanentVisitor">
		<h1 align="center">Информация о собственниках и их автомобилях </h1>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><b style="margin:40px">Введите информацию о заказчике</b></div>
		
		<i style="font-size:11pt;margin-left:60px;">(Фамилия, либо лицевой счет)</i>
		<br/>
		<input type="text" name="search" style="width:360px;height:20px">
		<input type="submit" name="action" class="button10" value="Найти" style="width:130px;height:30px">
		<button type="submit" name="action" value="Добавить нового жильца" class="button10" style="margin-left:100px;width:210px;height:45px">Добавить нового<br/> жильца</button>
		<br />
		<br />
		<table bgcolor="#c0c0d9"  border="2" width="1300px" cellpadding="8px" style="border-collapse: collapse">
				<th style="align:center;width:90px;">Показать автомобили</th>
				<th style="align:center;width:150px;">Лицевой счет</th>
				<th style="align:center;width:240px;">ФИО</th>
				<th style="align:center;width:180px;">Телефоны</th>
				<th style="align:center;width:300px;">Адрес</th>
				<th style="align:center;width:120px">Удалить<br /> жильца</th>
				<c:forEach items="${permanentVisitorList}" var="permanentVisitor">
					<tr>
						<td bgcolor="white" align="center"><input type="image" src="https://pp.vk.me/c625321/v625321943/4bad5/R6uTa2B_2rw.jpg" name="action" value="${permanentVisitor.visitorId}.show" /></td>
						<td bgcolor="white" align="center">${permanentVisitor.account}</td>
						<td bgcolor="white" align="center">${permanentVisitor.name}</td>
						<td bgcolor="white" align="center">${permanentVisitor.phoneNumber}<br/>${permanentVisitor.phoneNumber2}<br/>${permanentVisitor.phoneNumber3}</td>
						<td bgcolor="white" align="center">${permanentVisitor.address}</td>
					</tr>
				</c:forEach>
			</table>
			
	</form:form>
	</sec:authorize>
	</body>
</html>