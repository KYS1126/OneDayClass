package Contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.*;
import DTO.OneDayClass;
import DTO.OneDayStudent;
import DTO.Reservation;

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
		System.out.println(context + command);
		String site = null;
		
		switch (command) {
		case "" :
			site = getIndex(request);
			break;
		case "/index" : //메인화면
			site = getIndex(request);
			break;
		case "/main" : //공방 세부사항 가기
			site = getMain(request);
			break;
		case "/add" : //신청화면 갈때
			site = getAdd(request);
			break;
		case "/signup" : //회원가입 하기
			site = signUp(request, response);
			break;
		case "/addup" : //신청하기 누르면 submit실행
			site = addup(request,response);
			break;
		case "/personnel" :    //인원현황 보기
			site = getPresonnel(request);
			break;
		case "/delete" :
			site = deletePresonnel(request,response);
			break;
		case "/classupdate" :
			site = update(request);
			break;
		case "/update" :
			site = dbupdate(request,response);
			break;
		}
		
		if(site.startsWith("null")) {
			
		} else if (site.startsWith("redirect:/")) {
			String rview = site.substring("redirect:/".length());
			response.sendRedirect(rview);
		} else { // forward
			getServletContext().getRequestDispatcher("/" + site).forward(request, response);			
		}
		
	}
	
	public String getIndex (HttpServletRequest request) {
		List<OneDayClass> list;
		
		try {
			list=dao.getOneClass();
			request.setAttribute("list", list);			
		} catch (Exception e) {
			e.printStackTrace();
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
	
	
	public String getPresonnel (HttpServletRequest request) {
		int classNumber = Integer.parseInt(request.getParameter("classNumber"));
		
		OneDayClass d;
		ArrayList<OneDayStudent> s;
		
		try {
			//해당 스튜던트 객체
			d = dao.getView(classNumber);  //해당 클래스 리턴
			s = dao.getPersonnelList(classNumber); //해당 스튜던트 리턴
			request.setAttribute("oneClassStudent", s);
			request.setAttribute("oneClass", d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "personnel.jsp";
	
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

	
	public String signUp (HttpServletRequest request, HttpServletResponse response) {
		OneDayStudent s = new OneDayStudent();
		
		try {
 			BeanUtils.populate(s, request.getParameterMap());
			
			if (dao.juminCheck(s).equals("0")) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");					
				out.println("alert('중복된 주민 등록 번호입니다.'); location.href= '" + request.getContextPath()+ "/studentadd.jsp" + "' ;");
				out.println("</script>");
				out.flush(); // 한꺼번에 내보내기
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");					
				out.println("alert('회원가입이 성공적으로 완료되었습니다.'); location.href= '" + request.getContextPath()+ "/studentadd.jsp" + "' ;");
				out.println("</script>");
				out.flush(); // 한꺼번에 내보내기
				dao.signUp(s);
				return "index.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "null";
	}
	
	public String addup (HttpServletRequest request,HttpServletResponse response) {
		Reservation r = new Reservation();
		String inputJumin = request.getParameter("jumin");
		response.setContentType("text/html; charset=UTF-8");
		String context = request.getContextPath();
		
		try {
			PrintWriter out=response.getWriter();
 			BeanUtils.populate(r, request.getParameterMap());
 			int result = dao.getStudentNumber(inputJumin); //주민등록 번호로 찾아주기 //해당 번호가 리턴됨.
			dao.addDbUp(r,result);  //db에 올려주기
			out.println("<script>");
			out.println("alert('클래스 신청이 완료되었습니다.'); location.href='"+context+"'+'/index'; ");
			out.println("</script>");
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index.jsp";
	}
	
	public String deletePresonnel(HttpServletRequest request,HttpServletResponse response) {
		Reservation b = new Reservation();
		response.setContentType("text/html; charset=UTF-8");
		String context = request.getContextPath();
		
		try {
			PrintWriter out=response.getWriter();
			BeanUtils.populate(b, request.getParameterMap());
			dao.deletDb(b);
			out.println("<script>");
			out.println("alert('수강 신청 삭제가 완료되었습니다.'); location.href='"+context+"'+'/index'; ");
			out.println("</script>");
			out.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return "null";
		
	}
	
	public String update(HttpServletRequest request) {
		int classNumber = Integer.parseInt(request.getParameter("classNumber"));
	
		OneDayClass d;
		
		try {
			d = dao.getView(classNumber);
			request.setAttribute("oneClass", d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "classupdate.jsp";
	}

	public String dbupdate(HttpServletRequest request,HttpServletResponse response) {
		OneDayClass s = new OneDayClass();
		response.setContentType("text/html; charset=UTF-8");
		String context = request.getContextPath();
		
		try {
			PrintWriter out=response.getWriter();
			BeanUtils.populate(s, request.getParameterMap());
			dao.updateClass(s);
			out.println("<script>");
			out.println("alert('클래스 정보가 성공적으로 수정 되었습니다.'); location.href='"+context+"'+'/index'; ");
			out.println("</script>");
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "null";
	}
	
}





