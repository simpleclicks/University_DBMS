package servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.PersonServiceProxy;

/**
 * Servlet implementation class ListPerson
 */
public class ListPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	PersonServiceProxy proxy = new PersonServiceProxy();
    public ListPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String result="";
		
		proxy.setEndpoint("http://localhost:8080/UniversityManagement2/services/PersonService");
		result = proxy.getAllPerson();

		System.out.println("Inside servlet"+result);
		String[] persons = result.split("!");
		for(int i = 0; i < persons.length; i++){
			String data[] = persons[i].split("/");
//			request.setAttribute("pid"+i, data[0]);
			request.setAttribute("fname"+i, data[0]);
			request.setAttribute("lname"+i, data[1]);
			request.setAttribute("address"+i, data[2]);
			request.setAttribute("city"+i, data[3]);
			request.setAttribute("state"+i, data[4]);
			request.setAttribute("zipcode"+i, data[5]);
		}if (persons.length > 0)
			request.setAttribute("numPerson", persons.length);
		
		request.getRequestDispatcher("ListPerson.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
