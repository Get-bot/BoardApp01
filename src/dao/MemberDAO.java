package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import dto.MemberDTO;

public class MemberDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.getConnection();
	}
	
	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void pstmtClose() {
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void rsClose() {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int memberJoin(MemberDTO member) {
		String sql = "INSERT INTO MEMBER(MID,MPASSWORD,MNAME,MBIRTH,MPHONE,MEMAIL,MPOSTCODE,MADDRDSS,MDETAILADDRESS,MEXTRAADDRESS,MGENDER,PROFILE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		int joinResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpassword());
			pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMbirth());
			pstmt.setString(5, member.getMphone());
			pstmt.setString(6, member.getMemail());
			pstmt.setString(7, member.getPostcode());
			pstmt.setString(8, member.getAddress());
			pstmt.setString(9, member.getDetailAddress());
			pstmt.setString(10, member.getExtraAddress());
			pstmt.setString(11, member.getMgender());
			pstmt.setString(12, member.getImgfile());
			joinResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return joinResult;
	}

	public boolean memberLogin(String mid, String mpassword) {
		String sql = "SELECT * FROM MEMBER WHERE MID=? AND MPASSWORD=?";
		boolean loginResult = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpassword);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginResult = true;
			} else {
				loginResult = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
			pstmtClose();
		}
		return loginResult;
	}

	public List<MemberDTO> memberList() {
		String sql = "SELECT * FROM MEMBER";
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		try {
			pstmt = con.prepareStatement(sql);
			// DB에서 조회한 데이터를 rs에 저장 
			rs = pstmt.executeQuery();
			// 조회 데이터를 모두 담기 위해 while문 사용 
			while(rs.next()) {
				// 각 회원에 대한 정보를 DTO 객체에 담아서 
				// ArrayList의 각 인덱스에 저장 
				member = new MemberDTO();
				// DB에서 조회한 첫번째 회원의 id를 가져옴 
				String mid = rs.getString("MID");
				// 가져온 데이터를 member 객체의 mid 필드값으로 저장 
				member.setMid(mid);
				member.setMpassword(rs.getString("MPASSWORD"));
				member.setMname(rs.getString("MNAME"));
				member.setMphone(rs.getString("MPHONE"));
				member.setMemail(rs.getString("MEMAIL"));
				member.setMgender(rs.getString("MGENDER"));
				// 한명의 정보를 MemberDTO 객체에 다 담고 나면 list에 추가 
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
			pstmtClose();
		}
		return memberList;
	}

	public MemberDTO memberView(String mid) {
		String sql = "SELECT * FROM MEMBER WHERE MID=?";
		MemberDTO memberView = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberView = new MemberDTO();
				memberView.setMid(rs.getString("MID"));
				memberView.setMpassword(rs.getString("MPASSWORD"));
				memberView.setMname(rs.getString("MNAME"));
				memberView.setMphone(rs.getString("MPHONE"));
				memberView.setMemail(rs.getString("MEMAIL"));
				memberView.setMgender(rs.getString("MGENDER"));
				memberView.setImgfile(rs.getString("PROFILE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return memberView;
	}

	public int memberUpdate(MemberDTO member) {
		String sql = "UPDATE MEMBER SET MNAME=?, MPHONE=?, MEMAIL=? WHERE MID=?";
		int updateResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMname());
			pstmt.setString(2, member.getMphone());
			pstmt.setString(3, member.getMemail());
			pstmt.setString(4, member.getMid());
			updateResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return updateResult;
	}

	public int memberDelete(String mid) {
		String sql = "DELETE FROM MEMBER WHERE MID=?";
		int deleteResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			deleteResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		
		return deleteResult;
	}

	
}











