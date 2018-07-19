package javaex.copy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.runtime.Name;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("join.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = new MemberDTO();

		/*
		 * String id = request.getParameter(dto.getId()); String pw =
		 * request.getParameter(dto.getPw()); Timestamp rDate= new
		 * Timestamp(System.currentTimeMillis()); //String userPw_check =
		 * request.getParameter("password"); String name =
		 * request.getParameter(dto.getName()); String eMail =
		 * request.getParameter(dto.get eMail()); String address=
		 * request.getParameter(dto.getAddress());
		 */

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Timestamp rDate = new Timestamp(System.currentTimeMillis());
		// String userPw_check = request.getParameter("password");
		String name = request.getParameter("name");
		String eMail = request.getParameter("eMail");
		String address = request.getParameter("address");
		
		dto.setId(id);
		dto.setPw(pw);
		dto.setAddress(address);
		dto.seteMail(eMail);
		dto.setName(name);
		dto.setrDate(rDate);

		// HttpSession session;
		// PrintWriter out = response.getWriter();

		int ri = dao.insertMember(dto);
		if (ri == MemberDAO.MEMBER_JOIN_SUCCESS) {
			// session.setAttribute("id", dto.getId());
			request.setAttribute("message", "회원가입을 축하 합니다");
			// out.println( "<script>alert('회원가입을 축하 합니다'); </script>" );
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {
			request.setAttribute("message", "회원가입에 실패했습니다");
			// out.println( "<script>alert('회원가입에 실패했습니다'); </script>" );
			request.getRequestDispatcher("join.jsp").forward(request, response);

		}

	}

}
