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
 * Servlet implementation class AssignInstructor
 */
@WebServlet("/AssignInstructor")
public class AssignInstructor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	InstructorServiceProxy proxy = new InstructorServiceProxy();
	CourseServiceProxy courseproxy = new CourseServiceProxy();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignInstructor() {
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

		try {

			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/InstructorService");
			result = proxy.getAllInstructor();
			String[] instructors = result.split("!");
			for (int i = 0; i < instructors.length; i++) {
				String data[] = instructors[i].split("/");
				request.setAttribute("eid"+i, data[0]);

			}
			if (instructors.length > 0)
				request.setAttribute("numInstr", instructors.length);


		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		try {
			courseproxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/CourseService");
			result = courseproxy.getAllCourses();
			
			String[] courses = result.split("!");
			for (int i = 0; i < courses.length; i++) {
				String data[] = courses[i].split("/");
				request.setAttribute("cid"+i, data[0]+"-"+data[2]);

			}
			if (courses.length > 0)
				request.setAttribute("numCourses", courses.length);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		if (!result.equalsIgnoreCase("")){
			
			request.getRequestDispatcher("/View/AssignInstructor.jsp").forward(request, response);
		}else{
			result = "No data Found";
			request.setAttribute("result", result);
			
			request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
		}
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
			String instructorEmpId = request.getParameter("eid");
			String courseId = request.getParameter("cid");
			String section =  request.getParameter("section");
			
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/InstructorService");
			System.out.println("courses  "+courseId+"Section "+section+"Instructor Emp id " + instructorEmpId);
			result = proxy.assignInstructor(courseId,section, instructorEmpId);
			System.out.println("Inside assign instructor "+result); 

			if (result.equalsIgnoreCase("true"))
				request.setAttribute("assignResult", "Instructor assigned successfully");
			else
				request.setAttribute("assignResult", "Failed to assign Instructor. Instructor is already Assigned to a course");

			request.getRequestDispatcher("/View/AssignInstructor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
