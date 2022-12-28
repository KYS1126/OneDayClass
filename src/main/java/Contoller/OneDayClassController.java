package Contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import DTO.OneDayClass;
import DTO.OneDayStudent;

@WebServlet("/")
public class OneDayClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OneDayClassDAO dao;
	private ServletContext ctx;
       
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new OneDayClassDAO();
		ctx = getServletContext();
	}

	public OneDayClassController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		dopro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		dopro(request, response);
	}
	
	protected void dopro (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath();
		String command = request.getServletPath();
		System.out.println(context + "/" + command);
		String site = null;
		
		switch (command) {
		case "/index" : 
			site = getIndex(request);
			break;
		case "/main" :
			site = getMain(request);
			break;
		case "/add" :
			site = getAdd(request);
			break;
		case "/ch" :
			site = getch(request);
			break;
		}
		getServletContext().getRequestDispatcher("/" + site).forward(request, response);
	}
	
	public String getIndex (HttpServletRequest request) {
		List<OneDayClass> list;
		
		try {
			list=dao.getOneClass();
			request.setAttribute("list", list);			
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("게시판 목록 생성 과정에서 문제 발생!!");
			request.setAttribute("error", "게시판 목록이 정상적으로 처리되지 않았습니다!!");
		}
		return "index.jsp";
		
	}
	
	public String getMain(HttpServletRequest request) {
		int classNumber = Integer.parseInt(request.getParameter("classNumber"));
		OneDayClass d;
		
		try {
			d = dao.getView(classNumber);
			request.setAttribute("oneClass", d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main.jsp";
	}
	
	public String getAdd (HttpServletRequest request) {
		int classNumber = Integer.parseInt(request.getParameter("classNumber"));
		
		OneDayClass d;
		
		try {
			d = dao.getView(classNumber);
			request.setAttribute("oneClass", d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "add.jsp";
	}

	
	//하나씩 비교 해주는 애
	public String getch (HttpServletRequest request) {
		ArrayList<OneDayStudent> studentList = new ArrayList<OneDayStudent>();
		
		//add input에서 가져온 값.
		String inputJumin = request.getParameter("jumin");
		String inputStudentName = request.getParameter("studentName");
		
		try {
			studentList = dao.getStudent(request);
			//학생 객체리스트 보내주기.
			request.setAttribute("studentList", studentList);
			
			for (OneDayStudent s : studentList) {
				if (s.getJumin().equals(inputJumin) && s.getStudentName().equals(inputStudentName)) {
					return 1;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	
	}
	
	
	
	
}





