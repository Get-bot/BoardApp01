package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

public class BoardCountService {

	public int boardCount(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int boardcount = bDAO.boardcount(mid);
		bDAO.dbClose();
		return boardcount;
	}

}








