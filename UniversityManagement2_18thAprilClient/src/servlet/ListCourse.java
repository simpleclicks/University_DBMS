package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.CourseServiceProxy;
import edu.service.InstructorServiceProxy;

/**
 * Servlet implementation class ListCourse
 */
@WebServlet("/ListCourse")
public class ListCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CourseServiceProxy proxy = new CourseServiceProxy();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListCourse() {
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
		String course=null;
		String value=null;

		try {

			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/CourseService");

			course = request.getParameter("course"); 
			value = request.getParameter("value");
			System.out.println("course "+ course + "val "+ value);
			if(course == null && value == null){

				result = proxy.getAllCourses();
			}
			else
			{
				result = proxy.searchCourse(course,value);
			}

			System.out.println("Inside search "+result); 
			if(!result.startsWith("false") && !result.startsWith("False") && !result.equals("")){
				String[] courses = result.split("!");
				for (int i = 0; i < courses.length; i++) {
					String data[] = courses[i].split("/");
					request.setAttribute("cid"+i, data[0]);
					request.setAttribute("section"+i, data[1]);
					request.setAttribute("cname"+i, data[2]);
					request.setAttribute("location"+i, data[3]);
					String days[] = data[4].split(",");
					request.setAttribute("numdays"+i, days.length);
					for (int j = 0; j < days.length; j++) {
						request.setAttribute("day"+i+","+j, days[j]);
					}
					String time[] = data[5].split(",");
					for (int j = 0; j < time.length; j++) {
						request.setAttribute("time"+i+","+j, time[j]);
					}

				}
				if (courses.length > 0)
					request.setAttribute("numInstr", courses.length);
				
				request.getRequestDispatcher("/View/ListCourse.jsp").forward(request, response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
