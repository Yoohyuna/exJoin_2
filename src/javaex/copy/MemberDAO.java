package javaex.copy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	
	public static final int MEMBER_NONEXISTENT=0;
	public static final int MEMBER_EXISTENT=1;
	public static final int MEMBER_JOIN_FAIL =0;
	public static final int MEMBER_JOIN_SUCCESS =1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD=0;
	public static final int MEMBER_LOGIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;

	private static MemberDAO instance = new MemberDAO(); //자기 클래스에서 자기를 생성하고 그거를 참조(모든곳에서 공유가능)

private MemberDAO() {
	
}//보통 생성자 public. private-static 메소드(singleton)
	
public static MemberDAO getInstance() {
	return instance;
}

public int insertMember(MemberDTO dto) {
	int ri = 0;
	
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	String query = "insert into yoo.members values (?,?,?,?,?,?)";
	
	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.geteMail());
		pstmt.setTimestamp(6, dto.getrDate());
		pstmt.setString(5, dto.getAddress());
		pstmt.executeUpdate();
		ri = MemberDAO.MEMBER_JOIN_SUCCESS;
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	return ri;
}

public int confirmId(String id) {
	int ri = 0;
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet set = null;
	String query = "select id from yoo.members where id = ?";
	
	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, id); //사용자가 입력한 id(joinOK에서 넘어옴)
		set = pstmt.executeQuery();
		if(set.next()){
			ri = MemberDAO.MEMBER_EXISTENT;
		} else {
			ri = MemberDAO.MEMBER_NONEXISTENT;
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			set.close();
			pstmt.close();
			connection.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	return ri;
}

public int userCheck( String id, String pw) {
	int ri = 0;
	String dbPw;
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet set = null;
	String query = "select pw from yoo.members where id = ?";
	
	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, id);
		set = pstmt.executeQuery();
		
		if(set.next()) {
			dbPw = set.getString("pw");
			if(dbPw.equals(pw)) {
				ri = MemberDAO.MEMBER_LOGIN_SUCCESS;				// 로그인 Ok
			} else {
				ri = MemberDAO.MEMBER_LOGIN_PW_NO_GOOD;		// 비번 X
			}
		} else {
			ri = MemberDAO.MEMBER_LOGIN_IS_NOT;		// 회원 X	
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			set.close();
			pstmt.close();
			connection.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return ri;
}

public MemberDTO getMember(String id) {
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet set = null;
	String query = "select * from yoo.members where id = ?";
	MemberDTO dto = null;
	
	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, id);
		set = pstmt.executeQuery();
		
		if(set.next()) {
			dto = new MemberDTO();
			dto.setId(set.getString("id"));
			dto.setPw(set.getString("pw"));
			dto.setName(set.getString("name"));
			dto.seteMail(set.getString("eMail"));
			dto.setrDate(set.getTimestamp("rDate"));
			dto.setAddress(set.getString("address"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			set.close();
			pstmt.close();
			connection.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	return dto;
	
}

public int updateMember(MemberDTO dto) {
	int ri = 0;
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	String query = "update yoo.members set pw=?, eMail=?, address=? where id=?";
	
	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, dto.getPw());
		pstmt.setString(2, dto.geteMail());
		pstmt.setString(3, dto.getAddress());
		pstmt.setString(4, dto.getId());
		ri = pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			pstmt.close();
			connection.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	return ri;
}

public ArrayList<MemberDTO> membersAll() {
	
	ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "select * from yoo.members";
	
	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(query);
		rs = pstmt.executeQuery();
		
		System.out.println("============");
		while (rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.seteMail(rs.getString("eMail"));
			dto.setrDate(rs.getTimestamp("rDate"));
			dto.setAddress(rs.getString("address"));
			dtos.add(dto);
		}
		System.out.println("--------------------------");
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			rs.close();
			pstmt.close();
			connection.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	return dtos;
	
}

private Connection getConnection() {
	
	Context context = null;
	DataSource dataSource = null;
	Connection connection = null;
	try {
		context = new InitialContext();
		dataSource = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
		connection = dataSource.getConnection();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return connection;
}

}


