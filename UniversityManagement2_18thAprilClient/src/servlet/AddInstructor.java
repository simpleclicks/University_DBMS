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
			String dayvalues="";
			String timeValues="";
			String endtimevalues="";
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String address = request.getParameter("addr");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zipCode = request.getParameter("zcode");
			String department = request.getParameter("dept");
			String instructorEmpId = "I"+request.getParameter("eid");
			System.out.println("Instructor Id "+ instructorEmpId);
			String password = lastname+zipCode;
			System.out.println(password);
			String[] days = request.getParameterValues("days");
			for (int i = 0; i < days.length; i++) {
				dayvalues += days[i]+","; 
			}
			System.out.println(dayvalues);
			String[] strttime = request.getParameterValues("starttime");
			String[] endtime = request.getParameterValues("endtime");
			for (int i = 0; i < strttime.length; i++) {
				timeValues += strttime[i]+"-"+endtime[i]+","; 
			}
			System.out.println("Time values "+timeValues);
			
			

			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/InstructorService");

			result = proxy.addInstructor(instructorEmpId, firstname, lastname, address, city, state, zipCode,  department, dayvalues,timeValues,password);

			request.setAttribute("result",result);
			if (result.equalsIgnoreCase("true")){
				
				request.getRequestDispatcher("/View/Result.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}



}


