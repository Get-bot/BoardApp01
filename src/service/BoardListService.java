package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListService {

	public List<BoardDTO> boardList(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		List<BoardDTO> boardList = bDAO.boardList(mid);
		bDAO.dbClose();
		
		return boardList;
	}

}
