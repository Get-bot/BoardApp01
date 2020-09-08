package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberLoginService;

@WebServlet("/memberlogin")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	MemberLoginService mLoginService = new MemberLoginService();
    	String loginId = mLoginService.memberLogin(request, response);
    	HttpSession session = request.getSession();
    	if(loginId != null) {
    		session.setAttribute("loginId", loginId);
    		request.setAttribute("loginIdreq", loginId);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("boardlistpaging");
    		dispatcher.forward(request, response);
    	} else {
    		response.sendRedirect("MemberLoginFail.jsp");
    	}
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
