package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.InstructorServiceProxy;

/**
 * Servlet implementation class UnassignInstructor
 */
public class UnassignInstructor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	InstructorServiceProxy proxy = new InstructorServiceProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnassignInstructor() {
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
			String instructorEmpId = request.getParameter("eid");
			String courseId = request.getParameter("cid");
			String section = request.getParameter("section");
			
			System.out.println("values to call unassign function "+instructorEmpId+courseId+section );
			
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/InstructorService");
			result = proxy.unAssignInstructor(instructorEmpId,  courseId, section);
			System.out.println("Inside assign instructor "+result);
			
			

			if (result.equalsIgnoreCase("true")){
				 result="";
				String newInstructorId = request.getParameter("insId");
				result = proxy.assignInstructor( courseId, section,newInstructorId);
				System.out.println("After replacement "+ result);
				if (result.equalsIgnoreCase("true"))
				request.setAttribute("assignResult", "Instructor replaced successfully");
				else
					request.setAttribute("assignResult", "Failed to unassign Instructor");

				request.getRequestDispatcher("/View/UnassignInstructor.jsp").forward(request, response);
			}
			else
				result = result.substring(6);
			request.setAttribute("result", result);
			request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
				
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
