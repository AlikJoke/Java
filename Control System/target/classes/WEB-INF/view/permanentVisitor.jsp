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
</head>
<body bgcolor="#c0c0c0">
	<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
	<sec:authorize access="hasRole('ROLE_SUPER')">
		<form:form action="AccountAdd" method="POST" commandName="permanentVisitor">
			<table>
				<tr>
				<td align="center">ID </td>
				<td><input type="text" style="margin-left:30px;" name="id"></td>
				</tr>
				<tr>
					<td align="center" >Лицевой счет </td>
					<td><input type="text" style="margin-left:30px;" name="account"></td>
				</tr>
				</table>
				<td style="width:130px;height:40px;"><input type="submit" name="action" value="Добавить л/с" style="width:130px;height:40px;" /></td>
				<td style="width:130px;height:40px;"><input type="submit" name="action" value="Редактировать" style="width:130px;height:40px;" /></td>
				<td style="width:130px;height:40px;"><input type="submit" name="action" value="Удалить" style="width:130px;height:40px;" /></td>
				
			
			<h1>Лицевые счета</h1>
	<table bgcolor="#c0c0d9"  border="2" width="320px" cellpadding="8px" style="border-collapse: collapse">
				<th style="align:center;width:70px;">ID</th>
				<th style="align:center;width:150px;">Лицевой счет</th>
		<c:forEach items="${accountList}" var="account">
			<tr>
				<td bgcolor="white" align="center">${account.accountId}</td>
				<td bgcolor="white" align="center">${account.account}</td>
			</tr>
		</c:forEach>
	</table>
			
		</form:form>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	
	<form:form action="VisitorAction" method="POST" commandName="permanentVisitor">
		<h1 align="center">Информация о собственниках и их автомобилях </h1>
		
		<div><b style="margin:40px">Введите информацию о заказчике</b></div>
		
		<i style="font-size:11pt;margin-left:60px;">(Фамилия, либо лицевой счет)</i>
		<table style="width:1200px;">
			<tr>
				<td><input type="text" name="search" style="width:360px;height:20px"></td>
				<td><input type="submit" name="action" class="button10" value="Найти" style="width:130px;height:30px"></td>
				<td><button type="submit" name="action" value="Добавить нового жильца" class="button10" style="margin-left:100px;width:210px;height:45px">Добавить нового<br/> жильца</button></td>
				<td><input type="submit" value="Автомобили на территории" name="action" style="margin-left:138px;margin-top:8px;width:280px;height:37px;" class="button10"/></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><input type="submit" value="Добавить пропуск" name="action" style="margin-left:138px;width:280px;height:37px;" class="button10"/></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><input type="submit" value="Заказанные пропуска" name="action" style="margin-left:138px;width:280px;height:37px;" class="button10"/></td>
			</tr>
		</table>
		<br />
		<table bgcolor="#c0c0d9"  border="2" width="1300px" cellpadding="8px" style="border-collapse: collapse">
				<th style="align:center;width:90px;">Показать автомобили</th>
				<th style="align:center;width:150px;">Лицевой счет</th>
				<th style="align:center;width:240px;">ФИО</th>
				<th style="align:center;width:180px;">Телефоны</th>
				<th style="align:center;width:300px;">Адрес</th>
				<th style="align:center;width:120px">Изменить</th>
				<th style="align:center;width:120px">Удалить<br /> жильца</th>
				<c:forEach items="${permanentVisitorList}" var="permanentVisitor">
					<tr>
						<td bgcolor="white" align="center"><button type="submit" name="action" value="${permanentVisitor.visitorId}.show" style="background:white;border:0;"><img src="http://pp.vk.me/c625321/v625321943/4bad5/R6uTa2B_2rw.jpg"/></button></td>
						<td bgcolor="white" align="center">${permanentVisitor.account}</td>
						<td bgcolor="white" align="center">${permanentVisitor.name}</td>
						<td bgcolor="white" align="center">${permanentVisitor.phoneNumber}<br/>${permanentVisitor.phoneNumber2}<br/>${permanentVisitor.phoneNumber3}</td>
						<td bgcolor="white" align="center">${permanentVisitor.address}</td>
						<td bgcolor="white" align="center"><button type="submit" name="action" value="${permanentVisitor.visitorId}.edit" style="background:white;border:0;"><img src="http://iconizer.net/files/On-stage/orig/Edit.png" style="windth:100px;height:40px;" /></button></td>
						<td bgcolor="white" align="center"><button type="submit" name="action" value="${permanentVisitor.visitorId}.-" style="background:white;border:0;"><img src="https://pp.vk.me/c625321/v625321943/4baab/1Bf1CCpVvhg.jpg"/></button></td>
					</tr>
				</c:forEach>
			</table>
	</form:form>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_DISPATCHER')">
		<form:form action="VisitorGet" method="POST" commandName="permanentVisitor">
		<h1 align="center">Ввод временных пропусков на автомобили</h1>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><b style="margin:40px">Введите информацию о заказчике</b></div>
		
		<i style="font-size:11pt;margin-left:20px;">(Фамилия, либо лицевой счет, либо номер телефона)</i>
		<div title="Введите номер лицевого счета, фио или номер телефона заказывающего">
			<input type="text" name="search" style="width:360px;height:20px">
			<input type="submit" name="action" class="button10" value="Найти" style="width:150px;height:30px">
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
	</sec:authorize>
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
		</form:form>
	</sec:authorize>
</body>
</html>