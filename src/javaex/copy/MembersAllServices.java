//command 패턴에 존재하는 클래스(여기에 해당작업 위임)
package javaex.copy;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaex.copy.MemberDAO;

public class MembersAllServices implements Service{
	
	public MembersAllServices() {
		
	}
	
	@Override
	public ArrayList<MemberDTO> execute(HttpServletRequest request, HttpServletResponse reponse){
		//넘겨받아 여기서 메소드 받아 dao작업
		MemberDAO dao = MemberDAO.getInstance();
		return dao.membersAll();
	}
}