package Vehicle_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dispupdate
 */
@WebServlet("/Dispupdate")
public class Dispupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dispupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ArrayList<Vehicle> list=new ArrayList<Vehicle>();
		Vehicle p=new Vehicle();
		list=VehicleDAO.SearchVehicleDetails();
		out.print("<html>");
		out.print("");
		out.println("<head>");
		out.println("<style>");
		out.println("body{");
		out.println("background-color:#C8C8C8");
		out.println("}");
		out.println("table,td,th{");        
	    out.println("border: 1px solid black;");
	 	 out.println(" padding: 3px;");
		  out.println("}");
		  out.println("table {");
		  out.println("border-spacing: 15px;");
		  out.println("}");
		  out.println("</style>");
		  out.println("</head>");
		  out.println("<body>");
		  out.print("<center>");
		  out.print("<h1>Update vehicle details</h1>");
		  out.print("</center>");
		out.print("<table width='100%'");
		out.print("<tr><th>Vehicle No</th><th>Branch</th><th>Vehicle Type</th><th>Insurance Expiry Date</th><th>Last Serviced Date</th><th>Service Due Date</th><th>Update</th></tr>");
		for(Vehicle vv:list)
		{
			out.print("<tr><td>"+vv.getVehicleno()+"</td><td>"+vv.getVehicletype()+"</td><td>"+vv.getBranch()+"</td><td>"+vv.getInsurance_expiry()+"</td><td>"+vv.getLast_serviced_date()+"</td><td>"+vv.getService_due_date()+"</td><td><button><a href='Updatevehicle.jsp?vno="+vv.getVehicleno()+"'>Update</a></button></td></tr>");
		}
		out.print("</table>");
		out.print("<br>");
		out.print("<center><a href='Home.jsp'><button>Home page </button></a></center>"); 
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
