package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import persistence.MemberDAO;
import persistence.MemberDAOImpl;
import persistence.MemberDTO;

public class MemberServiceImpl implements MemberService {

	private static Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	MemberDAO mdao;
	List<MemberDTO> mList;

	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String action) {
		if (action.equals("signup")) {
			String email = request.getParameter("email");
			String nickname = request.getParameter("nickname");
			String pwd = request.getParameter("pwd");
			MemberDTO mdto = new MemberDTO(email, nickname, pwd);

			boolean flag = regist(mdto);
			if (flag) {
				log.info("regist success");
			} else {
				log.info("regist fail");
			}
		} else if (action.equals("signin")) {
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			MemberDTO mdto = new MemberDTO(email, pwd);
			MemberDTO logindto = login(mdto);
			if (logindto != null) {
				log.info("login success");
				HttpSession session = request.getSession();
				session.setAttribute("email", logindto.getEmail());
				session.setAttribute("nickname", logindto.getNickname());
				session.setAttribute("grade", logindto.getGrade());
				session.setMaxInactiveInterval(5*60);
			} else {
				log.info("login fail");
			}
		} else if(action.equals("isExistEmail")) {
			String email =  request.getParameter("email");
			int isExist = checkEmail(email);
			
			if(isExist > 0) {log.info("is exist email");
			try {
				PrintWriter out = response.getWriter();
				out.print(isExist);
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
			else log.info("is able to signup");
		}
		 else if(action.equals("getUserList")) {
				mList = getList();
				request.setAttribute("objList", mList);
		}
		 else if(action.equals("deleteUser")) {
				String email =  request.getParameter("email");
				int flag = deleteUser(email);

		}
			
		
		
		
		
	}


	@Override
	public boolean regist(MemberDTO mdto) {
		boolean flag = mdao.insert(mdto);

		if (flag)
			return true;
		else
			return false;
	}

	@Override
	public MemberDTO login(MemberDTO mdto) {
		MemberDTO logindto = mdao.login(mdto);

		if (logindto != null)
			return logindto;
		else
			return null;

	}

	@Override
	public int checkEmail(String email) {
		return mdao.checkEmail(email);
	}

	@Override
	public List<MemberDTO> getList() {
		return mdao.getList();
	}

	@Override
	public int deleteUser(String email) {
		return mdao.destory(email);
	}

}
