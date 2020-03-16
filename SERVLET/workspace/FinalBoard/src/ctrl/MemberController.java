package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(MemberController.class);
	MemberService service;

	public MemberController() {
		service = new MemberServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * String uri = request.getRequestURI(); String ctxPath =
		 * request.getContextPath(); String path = uri.substring(ctxPath.length() + 7);
		 */

		String action = request.getParameter("action");

		if (action.equals("signup")) {
			service.execute(request, response, "signup");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp?pg=welcome");
			dispatcher.forward(request, response);
		} else if (action.equals("signin")) {
			service.execute(request, response, "signin");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp?pg=welcome");
			dispatcher.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

}
