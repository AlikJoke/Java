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
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
</head>
<body>
	<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
<sec:authorize access="hasRole('ROLE_ADMIN')">

		<form:form action="BackToAdd" method="POST" commandName="permanentVisitor">
			<table width="550px" height="60px" bgcolor="#c0c0c0">
				<tr>
					<td><input style="margin-left:265px;" type="submit" value="Закрыть" name="action" class="button10" style="width:150px;height:30px;"></td>
				</tr>
			</table>
		</form:form>
		<form:form action="AddPermanent" method="POST" commandName="permanentVisitor">
			<table width="550px" bgcolor="#c0c0c0">
				<tr>
					<td style="padding-left:60px;align:center"><p>Дата регистрации</p></td>
					<td style="padding-left:60px;align:center"><input type="text" id="datepicker" name="date" value="${today}" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Лицевой счет</p></td>
					<td style="padding-left:60px;align:center">
						<input type="text" name="select" list="select" style="width:200px;height:22px"/>
							<datalist id="select">
							    <c:forEach items="${accList}" var="account">
									<option>${account.account}</option>
								</c:forEach>
							</datalist>
							<script>
    $(document).ready(function () {
        var nativedatalist = !!('list' in document.createElement('input')) && 
            !!(document.createElement('datalist') && window.HTMLDataListElement);

        if (!nativedatalist) {
            $('input[list]').each(function () {
                var availableTags = $('#' + $(this).attr("list")).find('option').map(function () {
                    return this.value;
                }).get();
                $(this).autocomplete({ source: availableTags });
            });
        }
    });
    </script>
					</td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>ФИО</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="name" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Номер телефона(основной)</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="phoneNumber" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Номер телефона(доп)</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="phoneNumber2" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Номер телефона(доп)</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="phoneNumber3" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Адрес проживания</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="address" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Добавить пропуск</p></td>
					<td style="padding-left:60px;align:center"><input type="submit" class="button10" name="action" value="+" style="width:60px;height:30px" /></td>
				</tr>
					
			</table>
	</form:form>
	</sec:authorize>
</body>
</html>