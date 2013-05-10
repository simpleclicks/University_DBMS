package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.CourseServiceProxy;
import edu.service.StudentServiceProxy;

/**
 * Servlet implementation class AssighStudent
 */
public class AssignStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 StudentServiceProxy proxy = new StudentServiceProxy();
	 CourseServiceProxy courseproxy = new CourseServiceProxy();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String result = "";
		try {
			 proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/StudentService");
			 result = proxy.getAllStudent();
			String[] students = result.split("!");
			System.out.println("Student lenght "+ students.length);
			for (int i = 0; i < students.length; i++) {
				String data[] = students[i].split("/");
				request.setAttribute("sid" + i, data[0]);
				System.out.println("inside do get for student "+ data[0]);
			}
			if (students.length > 0)
				request.setAttribute("numStudent", students.length);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			 courseproxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/CourseService");
			 result = courseproxy.getAllCourses();
			String[] courses = result.split("!");
			for (int i = 0; i < courses.length; i++) {
				String data[] = courses[i].split("/");
				request.setAttribute("cid" + i, data[0]+"-"+data[2]);
				System.out.println("Courses "+ data[0]);
			}
			if (courses.length > 0)
				request.setAttribute("numCourses", courses.length);
								
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!result.equalsIgnoreCase("")){
			
			request.getRequestDispatcher("/View/AssignStudent.jsp").forward(request, response);
		}else{
			result = "No data Found";
			request.setAttribute("result", result);
			
			request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		String result = "";
		String courses="";
		String section[]=null;
		String sectionId="";
		try {
			String studentId = request.getParameter("sid");
			String courseIds = request.getParameter("cid");
			System.out.println("Student id " + studentId);
				section = courseIds.split("-");
				courses += section[0];
				sectionId += section[1];
			 proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/StudentService");
			 System.out.println("assign studtocourse "+courses + ", "+ sectionId +", "+ studentId);
			 result = proxy.enrollStudent(courses, sectionId,studentId);
			System.out.println("Inside assign student " + result);
			if (result.equalsIgnoreCase("true"))
				request.setAttribute("assignResult",
						"Student enrolled successfully");
			else
				request.setAttribute("assignResult",
						"Failed to enroll Student");

			request.getRequestDispatcher("AssignStudent.jsp").forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
