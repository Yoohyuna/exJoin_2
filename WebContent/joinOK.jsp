
<%@page import="javaex.copy.MemberDAO"%>
<%@page import="javaex.copy.MemberDTO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%request.setCharacterEncoding("EUC-KR"); %>
    <jsp:useBean id="dto" class="javaex.copy.MemberDTO"></jsp:useBean> 
    <jsp:setProperty name="dto" property="*"></jsp:setProperty><!-- 모든 dto(사용하려는 bean의 아이디)를 set하겠다 -->
     <!-- * : 자동적으로 입력. dto의 변수명과 input 태그의 이름이 같아야 적용 -->
<%
		dto.setrDate(new Timestamp(System.currentTimeMillis()));
		MemberDAO dao = MemberDAO.getInstance(); //생성하지 않고 받아옴(singleton패턴)
		if(dao.confirmId(dto.getId()) == MemberDAO.MEMBER_EXISTENT) {
%> <!-- 사용자한테 받는게 아니고 서버에서 알아서. 따로 명시 -->
		<script language="javascript">
			alert("아이디가 이미 존재 합니다.");
			history.back();
		</script>
<%

		} else {
			int ri = dao.insertMember(dto);
			if(ri == MemberDAO.MEMBER_JOIN_SUCCESS) {
				session.setAttribute("id", dto.getId());
%>
			<script language="javascript">
				alert("회원가입을 축하 합니다.");
				document.location.href="login.jsp";
			</script>
<%
			} else {
%>
			<script language="javascript">
				alert("회원가입에 실패했습니다.");
				document.location.href="login.jsp";
			</script>
<%
			}
		}
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>