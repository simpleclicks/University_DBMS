package servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.CourseService;
import edu.service.CourseServiceProxy;
import edu.service.StudentServiceProxy;

/**
 * Servlet implementation class ListStudents
 */
public class ListStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentServiceProxy proxy = new StudentServiceProxy();
	CourseServiceProxy proxy1 = new CourseServiceProxy();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String result="";
		String student=null;
		String value=null;
		student = request.getParameter("student"); 
		value = request.getParameter("value");
		try{

			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/StudentService");
			if(student == null && value == null){

				result = proxy.getAllStudent();
			}
			else
			{
				result = proxy.searchStudent(student,value);
			}
			if (!result.startsWith("false") && !result.startsWith("False") && !result.equals("")) {
				String[] students = result.split("!");
				for (int i = 0; i < students.length; i++) {
					String data[] = students[i].split("/");
					request.setAttribute("sid"+i, data[0]);
					request.setAttribute("fname"+i, data[1]);
					request.setAttribute("lname"+i, data[2]);
					request.setAttribute("address"+i, data[3]);
					request.setAttribute("city"+i, data[4]);
					request.setAttribute("state"+i, data[5]);
					request.setAttribute("zipcode"+i, data[6]);
				}
				if (students.length > 0)
					request.setAttribute("numStudent", students.length);

				request.getRequestDispatcher("ListStudent.jsp").forward(request, response);
			} else if(!result.equals("")){
				result = result.substring(6);
				request.setAttribute("result", result);
				request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String result="";
		String courseId=null;
		String section=null;
		courseId = request.getParameter("cid"); 
		section = request.getParameter("section");
		try{
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/CourseService");
			result = proxy1.getEnrolledStudentForCourse(courseId, section);
			if (!result.startsWith("false") && !result.startsWith("False") && !result.equals("")) {
				String[] students = result.split("!");
				for (int i = 0; i < students.length; i++) {
					String data[] = students[i].split("/");
					request.setAttribute("sid"+i, data[0]);
					request.setAttribute("fname"+i, data[1]);
					request.setAttribute("lname"+i, data[2]);
					request.setAttribute("address"+i, data[3]);
					request.setAttribute("city"+i, data[4]);
					request.setAttribute("state"+i, data[5]);
					request.setAttribute("zipcode"+i, data[6]);
				}
				if (students.length > 0)
					request.setAttribute("numStudent", students.length);

				request.getRequestDispatcher("ListStudent.jsp").forward(request, response);
			} else if(!result.equals("")){
				result = result.substring(6);
				request.setAttribute("result", result);
				request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
			}

	}catch(Exception ex){
		ex.printStackTrace();
	}
	}
}
