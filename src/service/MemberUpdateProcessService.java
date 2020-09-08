package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberUpdateProcessService {

	public int memberUpdate(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String mphone = request.getParameter("mphone");
		String memail = request.getParameter("memail");
		
		MemberDTO member = new MemberDTO();
		member.setMid(mid);
		member.setMname(mname);
		member.setMphone(mphone);
		member.setMemail(memail);
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int updateResult = mDAO.memberUpdate(member);
		mDAO.dbClose();
		
		return updateResult;
	}



}





