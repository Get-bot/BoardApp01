package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class MemberDeleteService {

	public int memberDelete(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		
		int deleteResult = mDAO.memberDelete(mid);
		mDAO.dbClose();
		
		return deleteResult;
	}

}







