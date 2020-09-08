package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardViewService {

	public BoardDTO boardView(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));
		
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		//1.조회수 증가, 2. 상세내용 가져오기 
		bDAO.boardHits(bnumber);
		BoardDTO boardView = bDAO.boardView(bnumber);
		bDAO.dbClose();
		return boardView;
	}

}









