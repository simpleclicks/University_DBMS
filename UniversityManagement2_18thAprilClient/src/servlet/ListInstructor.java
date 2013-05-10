package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.CourseServiceProxy;
import edu.service.InstructorServiceProxy;

/**
 * Servlet implementation class ListInstructor
 */
@WebServlet("/ListInstructor")
public class ListInstructor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InstructorServiceProxy proxy = new InstructorServiceProxy();
	CourseServiceProxy proxy1 = new CourseServiceProxy();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListInstructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String result="";
		//String[] data; 
		String instructor=null;
		String value=null;
		instructor = request.getParameter("instructor"); 
		value = request.getParameter("value");


		try {

			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/InstructorService");
			if(instructor == null && value == null){

				result = proxy.getAllInstructor();
			}
			else
			{
				result = proxy.searchInstructor(instructor,value);
			}
			System.out.println("Inside list instruc "+result); 
			if (!result.startsWith("false") && !result.startsWith("False") && !result.equals("")) {
				String[] instructors = result.split("!");
				for (int i = 0; i < instructors.length; i++) {
					String data[] = instructors[i].split("/");
					request.setAttribute("eid"+i, data[0]);
					request.setAttribute("fname"+i, data[1]);
					request.setAttribute("lname"+i, data[2]);
					request.setAttribute("address"+i, data[3]);
					request.setAttribute("city"+i, data[4]);
					request.setAttribute("state"+i, data[5]);
					request.setAttribute("zipcode"+i, data[6]);
					request.setAttribute("dept"+i, data[7]);
					request.setAttribute("day"+i, data[8]);
					request.setAttribute("time"+i, data[9]);

					String days[] = data[8].split(",");
					request.setAttribute("numdays"+i, days.length);
					for (int j = 0; j < days.length; j++) {
						request.setAttribute("day"+i+","+j, days[j]);
					}
					String time[] = data[9].split(",");
					for (int j = 0; j < time.length; j++) {
						request.setAttribute("time"+i+","+j, time[j]);
					}
				}
				if (instructors.length > 0)
					request.setAttribute("numInstr", instructors.length);


				request.getRequestDispatcher("/View/ListInstructor.jsp").forward(request, response);
			} else if(result.equals("")){
				result = result.substring(6);
				request.setAttribute("result", result);
				request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String result="";
		//String[] data; 
		String courseId=null;
		String section=null;
		courseId = request.getParameter("cid"); 
		section = request.getParameter("section");


		try {

			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/CourseService");
			
				result = proxy1.getAssignedInstructorForCourse(courseId,section);
			 System.out.println("Result from .getAssignedInstructorForCourse " + result);
			if (!result.startsWith("false") && !result.startsWith("False") && !result.equals("")) {
				String[] instructors = result.split("!");
				for (int i = 0; i < instructors.length; i++) {
					String data[] = instructors[i].split("/");
					request.setAttribute("eid"+i, data[0]);
					request.setAttribute("fname"+i, data[1]);
					request.setAttribute("lname"+i, data[2]);
					request.setAttribute("address"+i, data[3]);
					request.setAttribute("city"+i, data[4]);
					request.setAttribute("state"+i, data[5]);
					request.setAttribute("zipcode"+i, data[6]);
					request.setAttribute("dept"+i, data[7]);
					
					
				}
				if (instructors.length > 0)
					request.setAttribute("numInstr", instructors.length);


				request.getRequestDispatcher("/View/ListAssignedInstructor.jsp").forward(request, response);
			} else if(result.equals("")){
				result = result.substring(6);
				request.setAttribute("result", result);
				request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}


	}
}

