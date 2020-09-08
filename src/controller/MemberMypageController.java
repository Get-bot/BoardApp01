package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardCountService;

@WebServlet("/mypage")
public class MemberMypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberMypageController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardCountService bcountSer = new BoardCountService();
    	int bcount = bcountSer.boardCount(request, response);
    	
    		request.setAttribute("bcount", bcount);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("MemberMain.jsp");
    		dispatcher.forward(request, response);
    	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
