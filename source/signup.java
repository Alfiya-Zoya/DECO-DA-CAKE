package decopackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.print("Hello World!");
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
			String n = request.getParameter("name");
			String e = request.getParameter("email");
			String p = request.getParameter("pass");
			String query = "insert into login(name,email,pass) values(?,?,?)";
			//pstmt = conn.prepareStatement("insert into ooclogin(name,email,pass) values(?,?,?)");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n);
			pstmt.setString(2, e);
			pstmt.setString(3, p);
			pstmt.executeUpdate();
			response.sendRedirect("log-in.html");
			//stmt = null;
			//rs = null;
		}
		catch(Exception e)
		{
			System.out.println("Cannot connect to database "+ e.getMessage());
		}

	}

	
}
