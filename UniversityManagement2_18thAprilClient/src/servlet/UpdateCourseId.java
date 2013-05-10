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
 * Servlet implementation class UpdateCourseId
 */
@WebServlet("/UpdateCourseId")
public class UpdateCourseId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CourseServiceProxy proxy = new CourseServiceProxy();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCourseId() {
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
			String courseId = request.getParameter("cid");
			String courseSec = request.getParameter("csec");
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/CourseService");
			result = proxy.getCourseById(courseId,courseSec);
			System.out.println("Result is "+result);
			if(!result.startsWith("false")){
				String[] data = result.split("/");
				request.setAttribute("cname", data[0]);
				request.setAttribute("location", data[1]);
				request.setAttribute("cid", data[2]);
				request.setAttribute("section", data[3]);
				String days[] = data[4].split(",");
				request.setAttribute("numdays", days.length);
				for (int j = 0; j < days.length; j++) {
					request.setAttribute("days"+j, days[j]);
				}
				String time[] = data[5].split(",");
				for (int j = 0; j < time.length; j++) {
					String splittime[] = time[j].split("-"); 
					if(splittime[0].equals("!"))
						break;
					request.setAttribute("starttime"+j, splittime[0]);
					request.setAttribute("endtime"+j, splittime[1]);
				}

				request.getRequestDispatcher("/View/UpdateCourse.jsp").forward(request, response);
			} else {
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
