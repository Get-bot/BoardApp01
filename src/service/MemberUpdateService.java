package service;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberUpdateService {

	public MemberDTO memberUpdate(String mid) {
		MemberDAO mDAO = new MemberDAO();
		
		mDAO.dbConnection();
		MemberDTO memberUpdate = mDAO.memberView(mid);
		mDAO.dbClose();
		
		return memberUpdate;
	}

}
