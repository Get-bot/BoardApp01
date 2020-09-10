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
import service.BoardCountService;
import service.BoardListService;
import service.MemberUpdateProcessService;

@WebServlet("/memberupdateprocess")
public class MemberUpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateProcessController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberUpdateProcessService mUpdateProcessService = new MemberUpdateProcessService();
		int updateResult = mUpdateProcessService.memberUpdate(request, response);
    	BoardListService bListService = new BoardListService();
    	List<BoardDTO> boardList = new ArrayList<BoardDTO>();
    	boardList = bListService.boardList(request, response);
    	BoardCountService bcountSer = new BoardCountService();
      	int bcount = bcountSer.boardCount(request, response);
		int page = Integer.parseInt(request.getParameter("page"));
		
		if(updateResult > 0) {
    		request.setAttribute("page", page);
    		request.setAttribute("boardList", boardList);
    		request.setAttribute("bcount", bcount);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("MemberMain.jsp");
    		dispatcher.forward(request, response);
//			response.sendRedirect("mypage?page="+page);
		} else {
			response.sendRedirect("MemberUpdateFail.jsp");
		}
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
