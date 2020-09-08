package service;

import java.util.List;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListService {

	public List<BoardDTO> boardList() {
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		List<BoardDTO> boardList = bDAO.boardList();
		bDAO.dbClose();
		
		return boardList;
	}

}
