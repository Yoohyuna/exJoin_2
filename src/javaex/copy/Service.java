//���� command�� �������̽� �ϳ� �������ְ� ����ϴ°����� ������ �ϳ��� �����ؼ� ���
package javaex.copy;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	public ArrayList<MemberDTO> execute(HttpServletRequest request, HttpServletResponse response);
	//�����ϴ� �޼ҵ常 ����(override �ʿ�)
}
