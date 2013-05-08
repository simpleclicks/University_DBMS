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
 * Servlet implementation class DeleteCourse
 */
@WebServlet("/DeleteCourse")
public class DeleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CourseServiceProxy proxy = new CourseServiceProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCourse() {
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
			String courseId = request.getParameter("courseid");
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/CourseService");
		    
			result = proxy.deleteCourse(courseId);
		
			
			request.setAttribute("result",result);
			System.out.println("Result is "+result );
			if (result.equalsIgnoreCase("true")){
				
				request.getRequestDispatcher("/View/Result.jsp").forward(request, response);
			}
			else{
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
