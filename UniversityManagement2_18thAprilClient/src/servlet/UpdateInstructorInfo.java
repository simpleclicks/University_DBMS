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
 * Servlet implementation class UpdateInstructorInfo
 */
@WebServlet("/UpdateInstructorInfo")
public class UpdateInstructorInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	InstructorServiceProxy proxy = new InstructorServiceProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInstructorInfo() {
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
		String dayValues = "";
		String timeValues = "";
		try {
			
			 String firstname = request.getParameter("fname");
			 String lastname = request.getParameter("lname");
			 String address = request.getParameter("addr");
			 String city = request.getParameter("city");
			 String state = request.getParameter("state");
			 String zipCode = request.getParameter("zcode");
			 String instructorEmpId = request.getParameter("eid");
			 String dept = request.getParameter("dept");
			 String[] days = request.getParameterValues("days");

				for (int i = 0; i < days.length; i++) {
					dayValues += days[i]+","; 
				}
				System.out.println("Days" + dayValues);
				String[] strttime = request.getParameterValues("starttime");
				String[] endtime = request.getParameterValues("endtime");
				for (int i = 0; i < strttime.length; i++) {
					timeValues += strttime[i]+"-"+endtime[i]+","; 
				}
			 
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/InstructorService");
		    
			result = proxy.updateInstructor(instructorEmpId, firstname, lastname, address, city, state, zipCode, dept, dayValues, timeValues);
		
			request.setAttribute("result",result);
			request.getRequestDispatcher("/View/Result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
