package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.service.StudentServiceProxy;

/**
 * Servlet implementation class ViewProfile
 */
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentServiceProxy proxy = new StudentServiceProxy();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewProfile() {
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
		HttpSession session = request.getSession();
		
		System.out.println("In View Profile");
		
		String studentId = session.getAttribute("userId").toString();
		System.out.println(studentId);
		
		String result = "";
		String result_enrolledStudets="";
		try {
			proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/StudentService");
			 result = proxy.getStudentById(studentId);
			 result_enrolledStudets=proxy.getEnrolledCoursesForStudent(studentId);
			 System.out.println("Result"+result);
			 System.out.println("Result for Enrolled students"+result_enrolledStudets);

//			 String[] students = result.split("/");
			 
//			 System.out.println("Result  1"+result1);
		
//			 ArrayList<String> courseNames=new ArrayList<>();
//			 String[] course = result1.split("!");
//			 System.out.println("Length of course"+course.length);
//			 for (int i=0;i<course.length;i++){
//				 String[] temp=course[i].split("/");
//				 System.out.println("Length of temp::"+temp.length);
//				 courseNames.add(temp[2]);
//			 }
//			 for(int j=0;j<courseNames.size();j++){
//				 System.out.println(courseNames.get(j));
//			 }
//			 
			 if (!result.startsWith("false") && !result.startsWith("False") && !result.equals("")) {
					String[] data = result.split("/");
					request.setAttribute("fname", data[0]);
					request.setAttribute("lname", data[1]);
					request.setAttribute("address", data[2]);
					request.setAttribute("city", data[3]);
					request.setAttribute("state", data[4]);
					request.setAttribute("zipcode", data[5]);
					request.setAttribute("eid", studentId);
					
//					for(int j=0;j<courseNames.size();j++){
//						request.setAttribute("course"+j, courseNames.get(j));
//					}
					if (!result_enrolledStudets.startsWith("false") && !result_enrolledStudets.startsWith("False") && !result_enrolledStudets.equals("")) {
						String[] student = result_enrolledStudets.split("!");
						System.out.println("After first split "+ student);
						for (int i = 0; i < student.length; i++) {
							String data_1[] = student[i].split("/");
							
							for(int j=0;j<data_1.length;j++){
								System.out.println(data_1[j]);
							}
							request.setAttribute("cid"+i, data_1[1]);
							request.setAttribute("course"+i, data_1[2]);
//							request.setAttribute("location"+i, data[3]);
//							request.setAttribute("section"+i, data[4]);
//							request.setAttribute("day"+i, data[5]);
//							request.setAttribute("time"+i, data[6]);
						}
						request.setAttribute("TotalCourses", student.length);
					}
					
					request.getRequestDispatcher("ViewProfile.jsp").forward(request,
							response);


			 }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
