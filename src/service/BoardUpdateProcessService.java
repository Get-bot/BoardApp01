package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardUpdateProcessService {

	public int boardUpdate(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));
		String bwriter = request.getParameter("bwriter");
		String btitle = request.getParameter("btitle");
		String bcontents = request.getParameter("bcontents");
		BoardDTO board = new BoardDTO();
		board.setBnumber(bnumber);
		board.setBwriter(bwriter);
		board.setBtitle(btitle);
		board.setBcontents(bcontents);

		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int updateResult = bDAO.boardUpdate(board);
		bDAO.dbClose();
		return updateResult;
	}

}







