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
.parallelogramm {
    -webkit-transform: skewX(-30deg);
    -moz-transform: skewX(-30deg);
    -o-transform: skewX(-30deg);
    -ms-transform: skewX(-30deg);
    transform: skewX(-30deg);
    zoom: 1;
    filter:progid:DXImageTransform.Microsoft.Matrix(M11=1.0, M21=0.0, M12=-1.0, M22=1.0, SizingMethod='auto expand');
    left: 50px; top: 50px;
    cursor: pointer;
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
  <link rel="stylesheet" hreqf="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
  <script>
  $(function() {
    $( "#datepickerTo" ).datepicker();
  });
  </script>
  
  <script>
	function testJump(x){
	    var ml = ~~x.getAttribute('maxlength');
	    var m2 = x.value;
		x.value = m2.toUpperCase();
	    if(ml && x.value.length >= ml){
	        do{
	            x = x.nextSibling;
	        }
	        while(x && !(/text/.test(x.type)));
	        if(x && /text/.test(x.type)){
	            x.focus();
	        }
	    }
	}
  </script>

  <script>
  //var alphaOnly = /[sА-Я\söÖäÄüÜ]/g;
  var rusOnly = /[авеукнхпорсмтАВЕУКНХПРОСМТ]/g;
  var alphaextraOnly = /[A-Za-z\-&/'"\öÖäÄüÜ]/g;
  var alphadigitsOnly = /[sA-Za-z\söÖäÄüÜ\s1234567890]/g;
  var digitsOnly = /[1234567890]/g;
  var integerOnly = /[0-9\.]/g;
  var mailOnly = /[a-z\.@]/g;

  function restrictCharacters(myfield, e, restrictionType) {
    if (!e) var e = window.event
    if (e.keyCode) code = e.keyCode;
    else if (e.which) code = e.which;
    var character = String.fromCharCode(code);

    // if they pressed esc... remove focus from field...
    if (code==27) { this.blur(); return false; }
    
    // ignore if they are press other keys
    // strange because code: 39 is the down key AND ' key...
    // and DEL also equals .
    if (!e.ctrlKey && code!=9 && code!=8 && code!=36 && code!=37 && code!=38 && (code!=39 || (code==39 && character=="'")) && code!=40) {
        if (character.match(restrictionType)) {
            return true;
        } else {
            return false;
        }
        
    }   
}

window.onload = function()
{
	document.getElementById("number").onkeypress = function (e)
    {
         return restrictCharacters(this,e,rusOnly);
    };   
    
    document.getElementById("number2").onkeypress = function (e)
    {
         return restrictCharacters(this,e,digitsOnly);
    };    
    
    document.getElementById("number3").onkeypress = function (e)
    {
         return restrictCharacters(this,e,rusOnly);
    }; 
    
    document.getElementById("number4").onkeypress = function (e)
    {
         return restrictCharacters(this,e,digitsOnly);
    }; 
    
}
  </script>
  
</head>
<body>
	<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
	<sec:authorize access="hasRole('ROLE_ADMIN')">

		<form:form action="BackToAdd" method="POST" commandName="permanentVisitor">
			<table width="500px" height="60px" bgcolor="#c0c0c0">
				<tr>
					<td><h2>л/с ${accVisitor} - ${nameVisitor} </h2> </td>
					<td><input type="submit" value="Закрыть" name="action" class="button10" style="width:150px;height:30px;"></td>
				</tr>
			</table>
		</form:form>
		<form:form action="AddTempTime" method="POST" commandName="permanentVisitor">
			<div  style="bgcolor:#c0c0c0;background:#c0c0c0;width:500px;">
						<button class="parallelogramm" name="action" value="Разовый пропуск" style="width:200px;height:40px;background:#60a0d9;margin-left:70px;">Разовый<br/>пропуск</button>
						<button class="parallelogramm" name="action" value="Временный пропуск" style="border: 2px solid red;width:200px;height:40px;background:#60a0d9"">Временный<br/>пропуск</button>
			</div>
			<table width="500px" bgcolor="#c0c0c0">
				<tr>
					<td style="padding-left:60px;align:center"><p>Дата регистрации<br>пропуска</p></td>
					<td style="padding-left:60px;align:center"><input type="text" id="datepicker" name="date" value="${today}" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Дата окончания<br>действия пропуска</p></td>
					<td style="padding-left:60px;align:center"><input type="text" id="datepickerTo" name="dateTo" value="${today}" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Номер авто</p></td>
					<td style="padding-left:60px;align:center">
						<input type="text" id="number" name="number" maxlength="1" style="width:15px;height:22px" onkeyup="testJump(this);" onkeypress="return app.restrictChars(this, event, rusOnly)" />
						<input maxlength="3" type="text" id="number2" name="number2" style="width:45px;height:22px;margin-left:5px;" onkeyup="testJump(this);" onkeypress="return app.restrictChars(this, event, digitsOnly)" />
						<input maxlength="2" type="text" id="number3" name="number3" style="width:30px;height:22px;margin-left:5px;" onkeyup="testJump(this);" onkeypress="return app.restrictChars(this, event, rusOnly)" />
						<input maxlength="3" type="text" id="number4" name="number4" style="width:45px;height:22px;margin-left:5px;" onkeypress="return app.restrictChars(this, event, digitsOnly)" />
					</td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Марка авто</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="brand" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Цель приезда</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="aim" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Добавить пропуск</p></td>
					<td style="padding-left:60px;align:center"><input type="submit" class="button10" name="action" value="+" style="width:60px;height:30px" /></td>
				</tr>
					
			</table>
	</form:form>
	</sec:authorize>
<sec:authorize access="hasRole('ROLE_DISPATCHER')">

		<form:form action="BackToAdd" method="POST" commandName="permanentVisitor">
			<table width="500px" height="60px" bgcolor="#c0c0c0">
				<tr>
					<td><h2>л/с ${accVisitor} - ${nameVisitor} </h2> </td>
					<td><input type="submit" value="Закрыть" name="action" class="button10" style="width:150px;height:30px;"></td>
				</tr>
			</table>
		</form:form>
		<form:form action="AddTempTime" method="POST" commandName="permanentVisitor">
					<div  style="bgcolor:#c0c0c0;background:#c0c0c0;width:500px;">
						<button class="parallelogramm" name="action" value="Разовый пропуск" style="width:200px;height:40px;background:#60a0d9;margin-left:70px;">Разовый<br/>пропуск</button>
						<button class="parallelogramm" name="action" value="Временный пропуск" style="border: 2px solid red;width:200px;height:40px;background:#60a0d9"">Временный<br/>пропуск</button>
					</div>
			<table width="500px" bgcolor="#c0c0c0">
				<tr>
					<td style="padding-left:60px;align:center"><p>Дата регистрации<br>пропуска</p></td>
					<td style="padding-left:60px;align:center"><input type="text" id="datepicker" name="date" value="${today}" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Дата окончания<br>действия пропуска</p></td>
					<td style="padding-left:60px;align:center"><input type="text" id="datepickerTo" name="dateTo" value="${today}" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Номер авто</p></td>
					<td style="padding-left:60px;align:center">
						<input type="text" id="number" name="number" maxlength="1" style="width:15px;height:22px" onkeyup="testJump(this);" onkeypress="return app.restrictChars(this, event, rusOnly)" />
						<input maxlength="3" type="text" id="number2" name="number2" style="width:45px;height:22px;margin-left:5px;" onkeyup="testJump(this);" onkeypress="return app.restrictChars(this, event, digitsOnly)" />
						<input maxlength="2" type="text" id="number3" name="number3" style="width:30px;height:22px;margin-left:5px;" onkeyup="testJump(this);" onkeypress="return app.restrictChars(this, event, rusOnly)" />
						<input maxlength="3" type="text" id="number4" name="number4" style="width:45px;height:22px;margin-left:5px;" onkeypress="return app.restrictChars(this, event, digitsOnly)" />
					</td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Марка авто</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="brand" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Цель приезда</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="aim" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Добавить пропуск</p></td>
					<td style="padding-left:60px;align:center"><input type="submit" class="button10" name="action" value="+" style="width:60px;height:30px" /></td>
				</tr>
					
			</table>
	</form:form>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_GUARD')">

		<form:form action="BackToAdd" method="POST" commandName="permanentVisitor">
			<table width="500px" height="60px" bgcolor="#c0c0c0">
				<tr>
					<td><h2>л/с ${accVisitor} - ${nameVisitor} </h2> </td>
					<td><input type="submit" value="Закрыть" name="action" class="button10" style="width:150px;height:30px;"></td>
				</tr>
			</table>
		</form:form>
		<form:form action="AddTemp" method="POST" commandName="permanentVisitor">
			<table width="500px" bgcolor="#c0c0c0">
				<tr>
					<td style="padding-left:60px;align:center"><p>Дата</p></td>
					<td style="padding-left:60px;align:center"><input type="text" id="datepicker" name="text" id="datepicker" value="${today}" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Номер авто</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="carNumber" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Марка авто</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="brand" style="width:200px;height:22px" /></td>
				</tr>
				<tr>
					<td style="padding-left:60px;align:center"><p>Цель приезда</p></td>
					<td style="padding-left:60px;align:center"><input type="text" name="aim" style="width:200px;height:22px" /></td>
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