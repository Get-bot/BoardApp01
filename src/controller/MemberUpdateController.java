package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.MemberUpdateService;

@WebServlet("/memberupdate")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession();
    	String mid = (String) session.getAttribute("loginId");
    	MemberUpdateService mUpdateService = new MemberUpdateService();
    	MemberDTO memberUpdate = mUpdateService.memberUpdate(mid);
    	int page = Integer.parseInt(request.getParameter("page"));
    	
		request.setAttribute("page", page);
    	request.setAttribute("memberUpdate", memberUpdate);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("MemberUpdate.jsp");
    	dispatcher.forward(request, response);
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
