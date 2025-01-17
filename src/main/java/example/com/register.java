package example.com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/regform")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{ 
	
	   PrintWriter out =response.getWriter();
		
		String myname =request.getParameter("name1");
		String myemail =request.getParameter("email1");
		String mypass =request.getParameter("pass1");
		String mygender =request.getParameter("gender1");
		String mycity =request.getParameter("city1");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo","*******","*******");
			
			PreparedStatement ps =con.prepareStatement("insert into register values(?,?,?,?,?)");
			ps.setString(1,myname);
			ps.setString(2,myemail);
			ps.setString(3,mypass);
			ps.setString(4,mygender);
			ps.setString(5,mycity);
			
			int count = ps.executeUpdate();
			if (count>0) {
				
				response.setContentType("text/html");
				out.print("<h3 style='color:green'> User Register Successfully !!! </h3>");
				
				RequestDispatcher rd = request.getRequestDispatcher("/index1.jsp");			
				rd.include(request,response);
			}
			else {
				response.setContentType("text/html");
				out.print("<h3 style='color:red'> User is Not Register Successfully Due to Some Error !!! </h3>");
				
				RequestDispatcher rd = request.getRequestDispatcher("/index1.jsp");			
				rd.include(request,response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.setContentType("text/html");
			out.print("<h3 style='color:red'> Exception occured !!! : "+e.getMessage()+"</h3>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/index1.jsp");			
			rd.include(request,response);
		}
	
	}

 }


