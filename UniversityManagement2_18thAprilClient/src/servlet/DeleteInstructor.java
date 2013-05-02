package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.InstructorServiceProxy;

/**
 * Servlet implementation class DeleteInstructor
 */
@WebServlet("/DeleteInstructor")
public class DeleteInstructor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	InstructorServiceProxy proxy = new InstructorServiceProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInstructor() {
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
		
PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		String result="";
		
		try {
			String instructorEmpId = request.getParameter("eid");
proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/InstructorService");
		    
			result = proxy.deleteInstructor(instructorEmpId);
		
			request.setAttribute("result",result);
			request.getRequestDispatcher("/View/Result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
	}

}
