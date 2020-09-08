package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import dto.PageDTO;
import service.BoardListPagingService;

import java.util.*;

@WebServlet("/boardlistpaging")
public class BoardListPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListPagingController() {
        super();
    }

    /*
     * 
     */
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardListPagingService bListPagingService = new BoardListPagingService();
    	List<BoardDTO> boardList = bListPagingService.boardList(request, response);
    	PageDTO paging = bListPagingService.paging(request, response);
    	
    	request.setAttribute("boardList", boardList);
    	request.setAttribute("paging", paging);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("BoardListPaging.jsp");
		dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
