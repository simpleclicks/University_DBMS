package servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.InstructorServiceProxy;

/**
 * Servlet implementation class UpdateInstructor
 */
@WebServlet("/UpdateInstructor")
public class UpdateInstructorId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	InstructorServiceProxy proxy = new InstructorServiceProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInstructorId() {
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
		//String[] data; 
		
		try {
			ResultSet rs;
			String instructorEmpId = request.getParameter("eid");
			
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/InstructorService");
			result = proxy.getInstructorById(instructorEmpId);
			System.out.println("Inside servlet"+result); 
			String[] data = result.split("/");
			request.setAttribute("fname", data[0]);
			request.setAttribute("lname", data[1]);
			request.setAttribute("address", data[2]);
			request.setAttribute("city", data[3]);
			request.setAttribute("state", data[4]);
			request.setAttribute("zipcode", data[5]);
			request.setAttribute("eid", instructorEmpId);
			
			request.getRequestDispatcher("/View/updateInstructor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		}
}


