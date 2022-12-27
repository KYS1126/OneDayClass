package Contoller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OneDayClassController")
public class OneDayClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public OneDayClassController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void dopro (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath();
		String command = request.getServletPath();
		System.out.println(context + ":" + command);
		String site = null;
		
		
	}

}
