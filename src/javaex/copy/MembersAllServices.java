//command ���Ͽ� �����ϴ� Ŭ����(���⿡ �ش��۾� ����)
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
		//�Ѱܹ޾� ���⼭ �޼ҵ� �޾� dao�۾�
		MemberDAO dao = MemberDAO.getInstance();
		return dao.membersAll();
	}
}