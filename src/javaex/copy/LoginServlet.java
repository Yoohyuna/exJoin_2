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
			request.setAttribute("message", "�������� �ʴ� ȸ���Դϴ�");
			System.out.println("dto == null");
			//out.println( "<script>alert('�������� �ʴ� ȸ���Դϴ�'); </script>" );
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		int checkNum = dao.userCheck(id, pw);
		if(checkNum == -1) {
			request.setAttribute("message", "���̵� �������� �ʽ��ϴ�");	
			System.out.println("cheyckNum == -1");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			//out.println( "<script>alert('���̵� �������� �ʽ��ϴ�'); history.go(-1); </script>" );
		}else if(checkNum == 0) {
			System.out.println("cheyckNum == 0");
			request.setAttribute("message", "��й�ȣ�� Ʋ���ϴ�");
			//out.println( "<script>alert('��й�ȣ�� Ʋ���ϴ�'); history.go(-1); </script>" );
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
