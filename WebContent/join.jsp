<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join</title>
<script language="javascript" src="members.js"></script>
<script src="members.js" charset='UTF-8'></script>
</head>
<body>
${message }
<form action="join" method="post" name="reg_form">
아이디 : <input type="text" name="id" size="20"><br/> 
비밀번호 : <input type="password" name="pw" size="20"><br/> 
비밀번호 확인 : <input type="password" name="pw_check" size="20"><br/> 
이름 : <input type="text" name="name" size="20"><br/> 
메일 : <input type="text" name="eMail" size="20"><br/> 
주소 : <input type="text" name="address" size="50"><br/> 
<!--  <input type="button" value="회원가입" onclick="javascript:infoConfirm"> &nbsp;&nbsp;&nbsp; <!-- js에 만들어 놓은 메소드로 이동가능 -->
<input id="registerBtn" type="button" value="회원가입" onclick="infoConfirm()">
<input type ="reset" value="취소" onclick="javascipt:window.location='login.jsp'">
<!-- 지금까지 주로 submit. js사용시, js에 있는 infoConfirm()메소드 실행하고 정상적으로 다 되면 join.jsp로 넘김-->
<!-- submit을 js파일에서 -->
</form>

</body>
</html>