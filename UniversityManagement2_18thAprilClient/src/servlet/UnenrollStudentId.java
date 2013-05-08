package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.StudentServiceProxy;

/**
 * Servlet implementation class UnenrollStudentId
 */
@WebServlet("/UnenrollStudentId")
public class UnenrollStudentId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentServiceProxy proxy = new StudentServiceProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnenrollStudentId() {
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
		String result = "";
		try {
			ResultSet rs;
			String studentId = request.getParameter("eid");
			System.out.println("unenrol sid "+ studentId);
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/StudentService");
			result = proxy.getEnrolledCoursesForStudent(studentId);
			System.out.println("result "+result);
			if (!result.startsWith("false") && !result.startsWith("False") && !result.equals("")) {

			
			System.out.println("Inside servlet" + result);
			String[] student = result.split("!");
			for (int i = 0; i < student.length; i++) {
				String data[] = student[i].split("/");
				request.setAttribute("sid"+i, data[0]);
				request.setAttribute("cid"+i, data[1]);
				request.setAttribute("cname"+i, data[2]);
				request.setAttribute("location"+i, data[3]);
				request.setAttribute("section"+i, data[4]);
				request.setAttribute("day"+i, data[5]);
				request.setAttribute("time"+i, data[6]);
			}
			if (student.length > 0)
				request.setAttribute("numStudent", student.length);
								
			request.getRequestDispatcher("UnenrollStudent.jsp").forward(request,
					response);
			}
			else{
				result = result.substring(6);
				request.setAttribute("result", result);
				request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
