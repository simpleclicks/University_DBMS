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
 * Servlet implementation class AddInstructor
 */
@WebServlet("/AddInstructor")
public class AddInstructor extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	InstructorServiceProxy proxy = new InstructorServiceProxy();

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInstructor() {
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
			
			 String firstname = request.getParameter("fname");
			 String lastname = request.getParameter("lname");
			 String address = request.getParameter("addr");
			 String city = request.getParameter("city");
			 String state = request.getParameter("state");
			 String zipCode = request.getParameter("zcode");
			 String course = request.getParameter("course");
			 String department = request.getParameter("dept");
			 String instructorEmpId = request.getParameter("eid");
			 //String officehrs = request.getParameter("offhrs");
			 // TODO : these 2 fields need to come from the UI. Multiple values should be selected 
			 //and then comma separated before sending to the server.
			 String days = "Monday,Tuesday";
			 String timings = "3:00 PM - 4:00 PM,5:00 PM - 6:15 PM";
			 int zip = Integer.parseInt(zipCode);
					 
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/InstructorService");
		    
			result = proxy.addInstructor(instructorEmpId, firstname, lastname, address, city, state, zip, department, days, timings);
		
			request.setAttribute("result",result);
			request.getRequestDispatcher("/View/Result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}



	}


