package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.CourseServiceProxy;
import edu.service.InstructorServiceProxy;

/**
 * Servlet implementation class AddCourse
 */
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CourseServiceProxy proxy = new CourseServiceProxy();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCourse() {
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

			String courseName = request.getParameter("cname");
			String courseId = request.getParameter("cid");
			String section = request.getParameter("section");
			String location = request.getParameter("location");
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
			System.out.println("Time "+ timeValues);
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/CourseService");

			result = proxy.addCourse(courseId, courseName,section, location,dayValues,timeValues);			
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
