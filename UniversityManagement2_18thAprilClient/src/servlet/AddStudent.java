package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.StudentServiceProxy;

/**
 * Servlet implementation class AddStudent
 */
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	 StudentServiceProxy proxy = new StudentServiceProxy();
	public AddStudent() {
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
		try {
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String address = request.getParameter("addr");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zipCode = request.getParameter("zcode");
			String department = request.getParameter("dept");
			String studentId = "S"+request.getParameter("sid");
			int zip = Integer.parseInt(zipCode);
			String password = lastname+zipCode;

			System.out.println(firstname);
			System.out.println(lastname);
			System.out.println(address);
			System.out.println(city);
			System.out.println(state);

			 proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/StudentService");
			result = proxy.addStudent(studentId, firstname, lastname, address,
					city, state, zipCode,password);
			request.setAttribute("result",result);
			if (result.equalsIgnoreCase("true")){
				
				request.getRequestDispatcher("/View/Result.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("/View/Error.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
