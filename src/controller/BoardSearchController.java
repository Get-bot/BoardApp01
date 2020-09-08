package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;

import java.util.*;

import service.BoardSearchService;

@WebServlet("/boardserch")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardSearchService bSearchService = new BoardSearchService();
    	List<BoardDTO> searchList = new ArrayList<BoardDTO>();
    	searchList = bSearchService.boardSearch(request, response);
    	if(searchList != null) {
    		request.setAttribute("boardList", searchList);
    		RequestDispatcher dispatcher = 
    				request.getRequestDispatcher("BoardListPaging.jsp");
    		dispatcher.forward(request, response);
    	} else {
    		response.sendRedirect("BoardSearchFail.jsp");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
