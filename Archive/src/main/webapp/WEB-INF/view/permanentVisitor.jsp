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
	<sec:authorize access="hasRole('ROLE_manager')">
		<form:form action="GetCitizen" method="POST" commandName="permanentVisitor">
		<h1 align="center">Поиск жильцов</h1>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><b style="margin:40px">Введите информацию о жильце</b></div>
		
		<i style="font-size:11pt;margin-left:20px;">(Фамилия, либо лицевой счет, либо номер телефона)</i>
		<div title="Введите номер лицевого счета, фио или номер телефона">
			<input type="text" name="search" style="width:360px;height:20px">
			<input type="submit" name="action" class="button10" value="Найти" style="width:150px;height:30px">
			<input type="submit" value="Добавить нового жильца" name="action" style="margin-left:138px;width:280px;height:37px;" class="button10"/>
		</div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
	
		<b style="margin-left:800px;">Жильцы</b>
		<table bgcolor="#c0c0d9"  border="2" width="1200px" cellpadding="8px" style="border-collapse: collapse">
				<th style="align:center;width:70px;">Лицевой счет</th>
				<th style="align:center;width:150px;">ФИО</th>
				<th style="align:center;width:"140px;">Телефоны</th>
				<th style="align:center;width:"140px;">Email</th>
				<th style="align:center;width:200px;">Адрес в ЖК</th>
				<th style="align:center;width:200px;">Адрес фактический</th>
				<th style="align:center;">Показать полную<br>информацию</th>
				<th style="align:center;">Удалить</th>
				<c:forEach items="${citizenList}" var="citizen">
					<tr>
						<td align="center">
							<c:forEach items="${citizen.accounts}" var="account">
								[${account.account}]<br/>
							</c:forEach>
						</td>
						<td align="center">${citizen.name}</td>
						<td align="center">
							<c:forEach items="${citizen.phoneNumbers}" var="phoneNumber">
								${phoneNumber.phoneNumber}<br/>
							</c:forEach>
						</td>
						<td align="center">
							<c:forEach items="${citizen.emails}" var="email">
								${email.email}<br/>
							</c:forEach>
						</td>
						<td align="center">${citizen.addressTSJ}</td>
						<td align="center">${citizen.addressReal}</td>
						<td bgcolor="white" align="center"><button type="submit" name="action" value="${citizen.id}.show" style="background:white;border:0;"><img style="width:50px;height:30px;" src="http://www.outsidethebox.ms/blog/wp-content/uploads/x-files.png" /></button> </td>
						<td bgcolor="white" align="center"><button type="submit" name="action" value="${citizen.id}.-" style="background:white;border:0;"><img style="width:30px;height:30px;" src="https://pp.vk.me/c625321/v625321943/4baab/1Bf1CCpVvhg.jpg"/></button></td>
					</tr>
				</c:forEach>
			</table>
	</form:form>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_buhgalter')">
		<form:form action="GetCitizen" method="POST" commandName="permanentVisitor">
		<h1 align="center">Поиск жильцов</h1>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><b style="margin:40px">Введите информацию о жильце</b></div>
		
		<i style="font-size:11pt;margin-left:20px;">(Фамилия, либо лицевой счет, либо номер телефона)</i>
		<div title="Введите номер лицевого счета, фио или номер телефона">
			<input type="text" name="search" style="width:360px;height:20px">
			<input type="submit" name="action" class="button10" value="Найти" style="width:150px;height:30px">
			<input type="submit" value="Добавить нового жильца" name="action" style="margin-left:138px;width:280px;height:37px;" class="button10"/>
		</div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
	
		<b style="margin-left:800px;">Жильцы</b>
		<table bgcolor="#c0c0d9"  border="2" width="1200px" cellpadding="8px" style="border-collapse: collapse">
				<th style="align:center;width:70px;">Лицевой счет</th>
				<th style="align:center;width:150px;">ФИО</th>
				<th style="align:center;width:"140px;">Телефоны</th>
				<th style="align:center;width:"140px;">Email</th>
				<th style="align:center;width:200px;">Адрес в ЖК</th>
				<th style="align:center;width:200px;">Адрес фактический</th>
				<th style="align:center;">Показать полную<br>информацию</th>
				<th style="align:center;">Удалить</th>
				<c:forEach items="${citizenList}" var="citizen">
					<tr>
						<td align="center">
							<c:forEach items="${citizen.accounts}" var="account">
								[${account.account}]<br/>
							</c:forEach>
						</td>
						<td align="center">${citizen.name}</td>
						<td align="center">
							<c:forEach items="${citizen.phoneNumbers}" var="phoneNumber">
								${phoneNumber.phoneNumber}<br/>
							</c:forEach>
						</td>
						<td align="center">
							<c:forEach items="${citizen.emails}" var="email">
								${email.email}<br/>
							</c:forEach>
						</td>
						<td align="center">${citizen.addressTSJ}</td>
						<td align="center">${citizen.addressReal}</td>
						<td bgcolor="white" align="center"><button type="submit" name="action" value="${citizen.id}.show" style="background:white;border:0;"><img style="width:50px;height:30px;" src="http://www.outsidethebox.ms/blog/wp-content/uploads/x-files.png" /></button> </td>
						<td bgcolor="white" align="center"><button type="submit" name="action" value="${citizen.id}.-" style="background:white;border:0;"><img style="width:30px;height:30px;" src="https://pp.vk.me/c625321/v625321943/4baab/1Bf1CCpVvhg.jpg"/></button></td>
					</tr>
				</c:forEach>
			</table>
	</form:form>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_legal')">
		<form:form action="GetCitizen" method="POST" commandName="permanentVisitor">
		<h1 align="center">Поиск жильцов</h1>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><b style="margin:40px">Введите информацию о жильце</b></div>
		
		<i style="font-size:11pt;margin-left:20px;">(Фамилия, либо лицевой счет, либо номер телефона)</i>
		<div title="Введите номер лицевого счета, фио или номер телефона">
			<input type="text" name="search" style="width:360px;height:20px">
			<input type="submit" name="action" class="button10" value="Найти" style="width:150px;height:30px">
			<input type="submit" value="Добавить нового жильца" name="action" style="margin-left:138px;width:280px;height:37px;" class="button10"/>
		</div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
		<div><input type="text" style="opacity:0; transform:scale(0,0)"></div>
	
		<b style="margin-left:800px;">Жильцы</b>
		<table bgcolor="#c0c0d9"  border="2" width="1200px" cellpadding="8px" style="border-collapse: collapse">
				<th style="align:center;width:70px;">Лицевой счет</th>
				<th style="align:center;width:150px;">ФИО</th>
				<th style="align:center;width:"140px;">Телефоны</th>
				<th style="align:center;width:"140px;">Email</th>
				<th style="align:center;width:200px;">Адрес в ЖК</th>
				<th style="align:center;width:200px;">Адрес фактический</th>
				<th style="align:center;">Показать полную<br>информацию</th>
				<th style="align:center;">Удалить</th>
				<c:forEach items="${citizenList}" var="citizen">
					<tr>
						<td align="center">
							<c:forEach items="${citizen.accounts}" var="account">
								[${account.account}]<br/>
							</c:forEach>
						</td>
						<td align="center">${citizen.name}</td>
						<td align="center">
							<c:forEach items="${citizen.phoneNumbers}" var="phoneNumber">
								${phoneNumber.phoneNumber}<br/>
							</c:forEach>
						</td>
						<td align="center">
							<c:forEach items="${citizen.emails}" var="email">
								${email.email}<br/>
							</c:forEach>
						</td>
						<td align="center">${citizen.addressTSJ}</td>
						<td align="center">${citizen.addressReal}</td>
						<td bgcolor="white" align="center"><button type="submit" name="action" value="${citizen.id}.show" style="background:white;border:0;"><img style="width:50px;height:30px;" src="http://www.outsidethebox.ms/blog/wp-content/uploads/x-files.png" /></button> </td>
						<td bgcolor="white" align="center"><button type="submit" name="action" value="${citizen.id}.-" style="background:white;border:0;"><img style="width:30px;height:30px;" src="https://pp.vk.me/c625321/v625321943/4baab/1Bf1CCpVvhg.jpg"/></button></td>
					</tr>
				</c:forEach>
			</table>
	</form:form>
	</sec:authorize>
</body>
</html>