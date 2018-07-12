//보통 command는 인터페이스 하나 선언해주고 사용하는곳에서 사용법을 하나로 통일해서 사용
package javaex.copy;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	public ArrayList<MemberDTO> execute(HttpServletRequest request, HttpServletResponse response);
	//실행하는 메소드만 있음(override 필요)
}
