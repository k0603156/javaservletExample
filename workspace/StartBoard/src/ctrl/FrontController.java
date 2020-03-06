package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrontController extends HttpServlet{
	private static Logger log = LoggerFactory.getLogger(FrontController.class);
	public FrontController () {}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		log.info("uri:" +uri);
		
		String contextPath = req.getContextPath();
		log.info("context:" +contextPath);
		
		String path = uri.substring(contextPath.length());
		log.info(path);
		
		String targetPage= "";
		
		if(path.equals("/test.do")) {
			String name = req.getParameter("my_name");
			log.info("name:" +name);
			targetPage = "/testReturn.jsp";
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(targetPage);
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}
}
