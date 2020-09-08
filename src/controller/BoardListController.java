package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardListService;

@WebServlet("/boardlist")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardListService bListService = new BoardListService();
    	List<BoardDTO> boardList = new ArrayList<BoardDTO>();
    	boardList = bListService.boardList();
    	// boardList를 가지고 BoardList.jsp로 이동 
    	if(boardList != null) {
    		request.setAttribute("boardList", boardList);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardList.jsp");
    		dispatcher.forward(request, response);
    	} else {
    		response.sendRedirect("BoardListFail.jsp");
    	}
    	
    	
    	
    	
    	
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
