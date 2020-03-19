package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		log(action);
		if (action.equals("signup")) {
			service.execute(request, response, action);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp?pg=welcome");
			dispatcher.forward(request, response);
		} else if (action.equals("signin")) {
			service.execute(request, response, action);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("isExistEmail")) {
			service.execute(request, response, action);
		} else if (action.equals("getUserList")) {
			service.execute(request, response, action);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp?pg=admin");
			dispatcher.forward(request, response);
		}else if (action.equals("deleteUser")) {
			service.execute(request, response, action);
			RequestDispatcher dispatcher = request.getRequestDispatcher("member?action=getUserList");
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
