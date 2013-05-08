package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			String studentId = request.getParameter("sid");
			String courses[] = (request.getParameter("cid")).split("-");
			String courseId = courses[0];
			String section = courses[1];
			
			System.out.println("course,sect "+ courseId +", "+section);
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/StudentService");
			result = proxy.unEnrollStudent(studentId,courseId, section);
			System.out.println("Inside unenroll student "+result); 

			if (result.equalsIgnoreCase("true"))
				request.setAttribute("assignResult", "Instructor assigned successfully");
			else
				request.setAttribute("assignResult", "Failed to assign Instructor");

			request.getRequestDispatcher("/View/AssignInstructor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
	}

}
