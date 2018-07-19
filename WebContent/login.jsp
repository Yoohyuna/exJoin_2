<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% if(session.getAttribute("ValidMem")!=null){ %>
<jsp:forward page="main.jsp"></jsp:forward>
<% } %> <!--만약 이미 로그인을 한 상태(유효한멤버ValidMem)이면 로그인 다시 안하고 forward 액션태그로 main.jsp로 넘김  -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${message }


	<form action="login" method="post">
		아이디 : <input type="text" name="id"
			value="<% if(session.getAttribute("id")!= null) out.println(session.getAttribute("id")); %>"><br />
		비밀번호 : <input type="password" name="pw"><br />
		<input type="submit" value="로그인">&nbsp;&nbsp; <input type="button" value="회원가입" 
		onclick="javascript:window.location='join.jsp'"> <!-- js언어.  이벤트발생시 저 링크로 가라 -->
	</form>


</body>
</html>