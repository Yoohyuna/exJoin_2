<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Join</title>
<script language="javascript" src="members.js"></script>
<script src="members.js" charset='UTF-8'></script>
</head>
<body>

<form action="joinOK.jsp" method="post" name="reg_form">
���̵� : <input type="text" name="id" size="20"><br/> 
��й�ȣ : <input type="password" name="pw" size="20"><br/> 
��й�ȣ Ȯ�� : <input type="password" name="pw_check" size="20"><br/> 
�̸� : <input type="text" name="name" size="20"><br/> 
���� : <input type="text" name="eMail" size="20"><br/> 
�ּ� : <input type="text" name="address" size="50"><br/> 
<!--  <input type="button" value="ȸ������" onclick="javascript:infoConfirm"> &nbsp;&nbsp;&nbsp; <!-- js�� ����� ���� �޼ҵ�� �̵����� -->
<input id="registerBtn" type="button" value="ȸ������" onclick="infoConfirm()">
<input type ="reset" value="���" onclick="javascipt:window.location='login.jsp'">
<!-- ���ݱ��� �ַ� submit. js����, js�� �ִ� infoConfirm()�޼ҵ� �����ϰ� ���������� �� �Ǹ� join.jsp�� �ѱ�-->
<!-- submit�� js���Ͽ��� -->
</form>

</body>
</html>