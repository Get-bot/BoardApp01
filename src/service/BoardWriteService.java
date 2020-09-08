package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardWriteService {

	public int boardWrite(HttpServletRequest request, HttpServletResponse response) {
		String bwriter = request.getParameter("bwriter");
		String btitle = request.getParameter("btitle");
		String bcontents = request.getParameter("bcontents");
		String bpass = request.getParameter("bpass");
		
		BoardDTO board = new BoardDTO();
		board.setBwriter(bwriter);
		board.setBtitle(btitle);
		board.setBcontents(bcontents);
		board.setBpass(bpass);
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int writeResult = bDAO.boardWrite(board);
		bDAO.dbClose();
		
		return writeResult;
	}

}
