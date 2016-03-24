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
TD, TH {
	border: 1px solid black;
}
TABLE {
	border-collapse:collapse;
}
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
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<body>
	<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
		
		<form:form action="Back" method="POST" commandName="addPermanent">
			
			<table width="750px" bgcolor="#c0c0c0">
				<tr>
					<td style="border:0px solid #c0c0c0;padding-left:10px;"><input type="submit" value="Закрыть" name="action" class="button10" style="width:150px;height:30px;"></td>
				</tr>
				<tr>
					<td style="padding-left:10px;height:50px;"><b style="margin-left:100px;">ФИО</b></td>
					<td><i style="font-size:25px;margin-left:70px;">${citizen.name}</i></td>
				</tr>
				<tr>
					<td style="padding-left:10px;"><b style="margin-left:70px;">Лицевой счет</b></td>
						<td align="center">
							<c:forEach items="${accountOwner}" var="account">
								<i style="font-size:22px;margin-left:20px;">${account} <br/></i>
							</c:forEach>
					</td>
				</tr>
				<tr>
					<td style="padding-left:10px;height:50px;"><b style="margin-left:50px;">Является членом ТСЖ</b></td>
					<td><i style="font-size:25px;margin-left:200px;">${member}</i></td>
					
				</tr>
				<tr>
					<td style="padding-left:10px;height:50px;"><b style="margin-left:60px;">Ответственный</b></td>
					<td><i style="font-size:25px;margin-left:200px;">${responsible}</i></td>
				</tr>
				<tr>
					<td style="padding-left:10px;height:50px;"><b style="margin-left:60px;">Номер телефона</b></td>
					<td align="center">
							<c:forEach items="${citizen.phoneNumbers}" var="phoneNumber">
								<i style="font-size:22px;margin-left:20px;">${phoneNumber.phoneNumber}<br/></i>
							</c:forEach>
					</td>
				</tr>
				<tr>
					<td style="padding-left:10px;height:50px;"><b style="margin-left:100px;">Email</b></td>
					<td align="center">
							<c:forEach items="${citizen.emails}" var="email">
								<i style="font-size:22px;margin-left:20px;">${email.email}<br/></i>
							</c:forEach>
						</td>
				</tr>
				<tr>
					<td style="padding-left:10px;height:50px;"><b style="margin-left:45px;">Адрес проживания в ЖК</b></td>
					<td><i style="font-size:22px;margin-left:70px;">${citizen.addressTSJ}</i></td>
				</tr>	
				<tr>
					<td style="padding-left:10px;height:50px;"><b style="margin-left:30px;">Фактический адрес проживания</b></td>
					<td><i style="font-size:22px;margin-left:70px;">${citizen.addressReal}</i></td>
				</tr>	
					
			</table>
			<table width="750px" bgcolor="#c0c0c0">
				<tr style="border:1px solid #c0c0c0;">
					<td style="border:1px solid #c0c0c0;padding-left:6px;"><input type="submit" class="button10" name="action" value="Редактировать" style="width:150px;height:30px;margin-left:300px;" /></td>
				</tr>
			</table>
	</form:form>
</body>
</html>