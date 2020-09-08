package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardUpdateProcessService;

@WebServlet("/boardupdateprocess")
public class BoardUpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateProcessController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardUpdateProcessService bUpdateProcessService = new BoardUpdateProcessService();
    	int updateResult = bUpdateProcessService.boardUpdate(request, response);
    	int bnumber = Integer.parseInt(request.getParameter("bnumber"));
    	int page = Integer.parseInt(request.getParameter("page"));
    	if(updateResult > 0) {
    		response.sendRedirect("boardview?bnumber="+bnumber+"&page="+page);
    	} else { 
    		response.sendRedirect("BoardUpdateFail.jsp");
    	}
    	
    	
    	
    	
    	
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
