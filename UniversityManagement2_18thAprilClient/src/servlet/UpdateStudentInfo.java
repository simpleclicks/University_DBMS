package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.StudentServiceProxy;

/**
 * Servlet implementation class UpdateStudentInfo
 */
public class UpdateStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	StudentServiceProxy proxy = new StudentServiceProxy();

	public UpdateStudentInfo() {
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
			String studentId = request.getParameter("eid");
			System.out.println("Sending info for update "+studentId+ firstname+ lastname+ address+ city+ state +zipCode);
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/StudentService");
			result = proxy.updateStudent(studentId, firstname, lastname, address, city, state, zipCode);
			request.setAttribute("result",result);
			request.getRequestDispatcher("Result.jsp").forward(request, response);



		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
