package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.service.LoginServiceProxy;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginServiceProxy proxy = new LoginServiceProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username ="";
		String password = "";
		username = request.getParameter("uname");
		password = request.getParameter("pwd");
		String result = "";
		HttpSession session = request.getSession();
		session.setAttribute("user", "");
		
		proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/LoginService");
		
		result = proxy.login(username, password);
		System.out.println("username "+username + ", "+ result);
		
		if( result.contains("success")){
			if (username.equalsIgnoreCase("admin")) {
				session.setAttribute("user", "admin");
				request.getRequestDispatcher("/View/Admin.jsp").forward(request, response);
			}else if (username.startsWith("I")) {
				
				session.setAttribute("user", "instructor");
				request.getRequestDispatcher("/View/Instructor.jsp").forward(request, response);
			} else {
				session.setAttribute("user", "student");
				request.getRequestDispatcher("/View/Student.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("result",result);
			request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
		}
		
	}

}
