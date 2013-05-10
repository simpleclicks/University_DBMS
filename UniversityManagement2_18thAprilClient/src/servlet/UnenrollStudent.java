package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.axis.session.Session;

import edu.service.StudentServiceProxy;

/**
 * Servlet implementation class UnenrollStudent
 */
@WebServlet("/UnenrollStudent")
public class UnenrollStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	StudentServiceProxy proxy = new StudentServiceProxy();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnenrollStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String result = "";
		HttpSession session = request.getSession();
		
				try {
			ResultSet rs;
			System.out.println("Session attribute " +session.getAttribute("userId").toString() );
			String studentId = session.getAttribute("userId").toString();
			System.out.println("unenrol sid "+ studentId);
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/StudentService");
			result = proxy.getEnrolledCoursesForStudent(studentId);
			System.out.println("result "+result);
			if (!result.startsWith("false") && !result.startsWith("False") && !result.equals("")) {

			
			System.out.println("Inside servlet" + result);
			String[] student = result.split("!");
			System.out.println("After first split "+ student);
			for (int i = 0; i < student.length; i++) {
				String data[] = student[i].split("/");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		String result="";
		HttpSession session = request.getSession();
		

		try {
			String studentId = session.getAttribute("userId").toString();
			System.out.println("Inside Unenroll do post");
			System.out.println("selected radio "+request.getParameter("cid2") );
			String courses[] = (request.getParameter("cid2")).split("-");
			String courseId = courses[0];
			String section = courses[1];
			
			System.out.println("course,sect "+ courseId +", "+section);
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/StudentService");
			result = proxy.unEnrollStudent(studentId,courseId, section);
			System.out.println("Inside unenroll student "+result); 

			if (result.equalsIgnoreCase("true"))
				request.setAttribute("assignResult", "Unenrolled successfully");
			else
				request.setAttribute("assignResult", "Failed to unEnroll");

			request.getRequestDispatcher("/View/AssignInstructor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
	}

}
