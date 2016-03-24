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
  box-shadow: inset 0 -2px 1px rgba(0,0,0,0), inset 0 1px 2px rgba(0,0,0,0), inset 0 0 0 10px rgba(255,255,0,0);
  transition: box-shadow .2s, border-color .2s;
} 
.button10:hover {
  box-shadow: inset 0 -1px 1px rgba(0,0,0,0), inset 0 1px 2px rgba(0,0,0,0), inset 0 0 0 10px rgba(255,255,0,.5);
}
.button10:active {
  padding: calc(.25em + 1px) .5em calc(.25em - 1px);
  border-color: rgba(177,159,0,1);
  box-shadow: inset 0 -1px 1px rgba(0,0,0,.1), inset 0 1px 2px rgba(0,0,0,.3), inset 0 0 0 10px rgba(255,255,0,.45);
}</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
  </head>
<script>
$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    
    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div><input list="select" maxlength="8" onkeypress="return app.restrictChars(this, event, ololo)" id="account" type="text" name="select" style="width:100px;height:22px;" ><i style="margin-left:5px;font-size:15px;">Собственник</i><input type="checkbox" name="isChecked" value="owner' + x + '" style="width:20px;height:20px;" /><datalist id="select"><c:forEach items="${accList}" var="account"><option>${account}</option></c:forEach></datalist></div>');
            
        }
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
});
</script>
<script>
$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap1"); //Fields wrapper
    var add_button      = $(".add_field_button1"); //Add button ID
    
    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div><input maxlength="11" type="text" name="myphone[]"/></div>'); //add input box
        }
    });
    
    $(wrapper).on("click",".remove_field1", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
});
</script>

<script>
$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap2"); //Fields wrapper
    var add_button      = $(".add_field_button2"); //Add button ID
    
    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div><input type="text" name="myemail[]"/></div>'); //add input box
        }
    });
    
    $(wrapper).on("click",".remove_field2", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
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
  //var alphaOnly = /[sА-Я\söÖäÄüÜ]/g;
  var rusOnly = /[а-я\А-Я\ ]/g;
  var alphaextraOnly = /[A-Za-z\-&/'"\öÖäÄüÜ]/g;
  var ololo = /[1234567890\а-я\А-Я]/g;
  var alphadigitsOnly = /[sA-Za-z\söÖäÄüÜ\s1234567890]/g;
  var digitsOnly = /[1234567890]/g;
  var integerOnly = /[0-9\.]/g;
  var mailOnly = /[a-z\.@\A-Z\0-9]/g;

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
	document.getElementById("account").onkeypress = function (e)
    {
         return restrictCharacters(this,e, ololo);
    };   
    
    document.getElementById("name").onkeypress = function (e)
    {
         return restrictCharacters(this,e, rusOnly);
    }; 
    
    document.getElementById("phone").onkeypress = function (e)
    {
         return restrictCharacters(this,e, digitsOnly);
    };
    
    document.getElementById("mail").onkeypress = function (e)
    {
         return restrictCharacters(this,e, mailOnly);
    };
    
    document.getElementById("home").onkeypress = function (e)
    {
         return restrictCharacters(this,e, digitsOnly);
    };
    
    document.getElementById("room").onkeypress = function (e)
    {
         return restrictCharacters(this,e, digitsOnly);
    };
}
  </script>
<body>
	<p align="right"><a href="logout"><img src="https://pp.vk.me/c627729/v627729943/3db06/whOvUSSh8qM.jpg" width="50px" height="50px;"/></a></p>
		
		<form:form action="AddPermanent" method="POST" commandName="addPermanent">
			
			<table width="550px" bgcolor="#c0c0c0">
				<tr>
					<td style="border:1px solid #c0c0c0;padding-left:10px;"><input type="submit" value="Закрыть" name="action" class="button10" style="width:150px;height:30px;"></td>
				</tr>
				<tr>
					<td style="padding-left:10px;"><p>ФИО</p></td>
					<td><input type="text" id="name" onkeypress="return app.restrictChars(this, event, rusOnly)" name="name" style="width:280px;height:22px" /></td>
					<td style="padding-left:10px;">Лицевой счет</td>
					<td>
						<div class="input_fields_wrap">
   	 					<div><input list="select" id="account" maxlength="8" onkeypress="return app.restrictChars(this, event, ololo)" type="text" name="select" style="width:100px;height:22px;" ><i style="margin-left:5px;font-size:15px;">Собственник</i><input type="checkbox" name="isChecked" value="owner1" style="width:20px;height:20px;" />
   	 						<datalist id="select">
							    <c:forEach items="${accList}" var="account">
									<option>${account}</option>
								</c:forEach>
							</datalist>
						</div>
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
						</div>
							
					</td>
					<td style="border:1px solid #c0c0c0;">
						<button class="add_field_button" style="width:85px;height:30px;'">Добавить...</button>
					</td>
				</tr>
				<tr>
					<td style="padding-left:10px;">Является членом ТСЖ</td>
					<td style="padding-left:10px;"><input type="checkbox" name="isChecked" value="member" style="width:20px;height:20px;" /></td>
					<td style="padding-left:10px;"><p>Номер телефона</p></td>
					<td>
						<div class="input_fields_wrap1">
   	 					<div><input maxlength="11" type="text" id="phone" onkeypress="return app.restrictChars(this, event, digitsOnly)" name="myphone[]"><i style="font-size:12px;">Основной</i></div>
						</div>
					</td>
					<td style="border:1px solid #c0c0c0;">
						<button class="add_field_button1" style="width:85px;height:30px;'">Добавить...</button>
					</td>
				</tr>
				<tr>
					<td style="padding-left:10px;">Ответственный</td>
					<td style="padding-left:10px;"><input type="checkbox" name="isChecked" value="responsible" style="width:20px;height:20px;" /></td>
					<td style="padding-left:10px;"><p>Email</p></td>
					<td>
						<div class="input_fields_wrap2">
						<div><input id="mail" onkeypress="return app.restrictChars(this, event, mailOnly)" type="text" name="myemail[]"><i style="font-size:12px;">Основной</i></div>
						</div>
						
					</td>
					<td style="border:1px solid #c0c0c0;">
						<button class="add_field_button2" style="width:85px;height:30px;'">Добавить...</button>
					</td>
				</tr>
				<tr>
					<td style="padding-left:10px;"><p>Адрес проживания в ЖК</p></td>
					<td>ул. Весенняя, дом <input id="home" type="text" name="addressTSJNumbHome" maxlength="1" onkeyup="testJump(this);" onkeypress="return app.restrictChars(this, event, digitsOnly)" style="width:20px;height:18px" />, корп. 
					<input id="korp" type="text" name="addressTSJNumbKorp" maxlength="1" onkeyup="testJump(this);" onkeypress="return app.restrictChars(this, event, digitsOnly)" style="width:20px;height:18px" />, кв.
					<input id="room" type="text" name="addressTSJNumbRoom" maxlength="2" onkeyup="testJump(this);" onkeypress="return app.restrictChars(this, event, digitsOnly)" style="width:20px;height:18px" /></td>
					<td style="padding-left:10px;"><p>Фактический адрес проживания</p></td>
					<td><input type="text" name="addressReal" style="width:220px;height:22px" /></td>
				</tr>
				<tr style="border:1px solid #c0c0c0;">
					<td style="border:1px solid #c0c0c0;padding-left:10px;"><input type="checkbox" name="isChecked" value="checked" style="transform:scale(0,0);opacity:0px;" checked /></td>
					<td style="border:1px solid #c0c0c0;padding-left:10px;"><p>Добавить жильца</p></td>
					<td style="border:1px solid #c0c0c0;padding-left:6px;"><input type="submit" class="button10" name="action" value="+" style="width:100px;height:30px" /></td>
				</tr>
					
			</table>
	</form:form>
</body>
</html>