package decopackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	String name;
	String email;
	String pass;
	String check;
	String check2;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public login() {
        // TODO Auto-generated constructor stub
    }
    public void check_table(Statement stmt, Connection conn, ResultSet rs, PreparedStatement pstmt)
	{
		try
		{
			String query = "select pass from login WHERE email = ?";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, email);
			System.out.println("Success");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				check = rs.getString("pass");				
			}
			System.out.println(check);
		}
		catch(Exception e)
		{
			System.out.println("error : " + e);
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		// TODO Auto-generated method stub
			response.setContentType("text/html");
			
			//response.sendRedirect("index.html");
		Connection conn;
		String userName;
		String url;
		String password;
		Statement stmt;
		ResultSet rs;
		PreparedStatement pstmt;
		conn = null;
		stmt = null;
		rs = null;
		pstmt = null;
		try
		{
			conn = null;
			userName = "root";
			password = "root";
			url = "jdbc:mysql://localhost:3306/ooc";
			Class.forName ("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,userName,password);
			System.out.println("Database connection established");
			stmt = conn.createStatement();
			stmt = null;
			rs = null;
			pstmt = null;
		}
		catch(Exception e)
		{
			System.out.println("Cannot connect to database " + e);
		}
		email = request.getParameter("email");
		pass = request.getParameter("pass");
		//PrintWriter out = response.getWriter();
		check_table(stmt, conn, rs, pstmt);
		if(pass.equals(check))
		{			
			response.sendRedirect("after-log-in.html");
		}
		else
		{
			response.sendRedirect("log-in.html");
		}
	}

}
