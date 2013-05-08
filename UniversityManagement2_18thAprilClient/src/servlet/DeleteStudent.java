package servlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.StudentServiceProxy;

/**
 * Servlet implementation class DeleteStudent
 */
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	StudentServiceProxy proxy = new StudentServiceProxy();
    
    public DeleteStudent() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String result="";
		
		try{
			
			String studentId = request.getParameter("eid");
			System.out.println(studentId);
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/StudentService");
			result = proxy.deleteStudent(studentId);
			request.setAttribute("result",result);
			if (result.equalsIgnoreCase("true")){
				
				request.getRequestDispatcher("/View/Result.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
