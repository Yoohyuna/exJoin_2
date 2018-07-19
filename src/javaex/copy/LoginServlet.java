package javaex.copy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
				
		String id = (String) request.getParameter("id");
		String pw = (String) request.getParameter("pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = dao.getMember(id);
		PrintWriter out = response.getWriter();
		
		if(dto == null) {
			request.setAttribute("message", "존재하지 않는 회원입니다");
			System.out.println("dto == null");
			//out.println( "<script>alert('존재하지 않는 회원입니다'); </script>" );
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		int checkNum = dao.userCheck(id, pw);
		if(checkNum == -1) {
			request.setAttribute("message", "아이디가 존재하지 않습니다");	
			System.out.println("cheyckNum == -1");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			//out.println( "<script>alert('아이디가 존재하지 않습니다'); history.go(-1); </script>" );
		}else if(checkNum == 0) {
			System.out.println("cheyckNum == 0");
			request.setAttribute("message", "비밀번호가 틀립니다");
			//out.println( "<script>alert('비밀번호가 틀립니다'); history.go(-1); </script>" );
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			System.out.println("ok go main");
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		
		}
		
		
	}

}
