package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardSearchService {

public List<BoardDTO> boardSearch(HttpServletRequest request, HttpServletResponse response) {
	String keyword = request.getParameter("keyword");
	String keyfield = request.getParameter("keyfield");
	BoardDAO bDAO = new BoardDAO();
	bDAO.dbConnection();
	List<BoardDTO> searchList = bDAO.boardSearch(keyword,keyfield);
	bDAO.dbClose();
	
	return searchList;

}


}









