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
 * Servlet implementation class menupage
 */
@WebServlet("/menupage")
public class menupage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menupage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cake="";
		int price=0;
		PrintWriter out =response.getWriter();
		String n = request.getParameter("layers");
		//System.out.print(n);
		int num = Integer.valueOf(n);
		//System.out.print(num);
		switch(num)
		{
		case 1:
			cake = "Red Velvet";
			price = 900;
			break;
		case 2:
			cake = "Pineapple";
			price = 690;
			break;
		case 3:
			cake = "Plum Cake";
			price = 529;
			break;
		case 4:
			cake = "Cherry Current";
			price =219;
			break;
		}

	String total = String.valueOf(price);
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
		String query = "insert into menu(cake_type,price) values(?,?)";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, cake);
		pstmt.setString(2, total);
		pstmt.executeUpdate();

	}
	catch(Exception e)
	{
		System.out.println("Cannot connect to database " + e);
	}

	
	out.println("<html>"+"<head>\r\n" + 
			"  <meta charset=\"utf-8\" />\r\n" + 
			"  <link rel=\"icon\" href=\"/favicon.ico\" />\r\n" + 
			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n" + 
			"  <meta name=\"theme-color\" content=\"#000000\" />\r\n" + 
			"  <title>Bill predefined</title>\r\n" + 
			"  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Inter%3A400%2C600%2C700%2C800\"/>\r\n" + 
			"  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro%3A400%2C600%2C700%2C800\"/>\r\n" + 
			"  <link rel=\"stylesheet\" href=\"bill-predefined.css\"/>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"<div class=\"bill-predefined-hxk\">\r\n" + 
			"  <div class=\"auto-group-awdn-hLU\">\r\n" + 
			"    <img class=\"ellipse-3-mje\" src=\"ellipse-3.png\"/>\r\n" + 
			"    <img class=\"black-minimal-cake-logo-1-4ik\" src=\"black-minimal-cake-logo-1.png\"/>\r\n" + 
			"    \r\n" + 
			"    <p class=\"bill-UXa\">Bill</p>\r\n" + 
			"    <div class=\"rectangle-2-LJt\">\r\n" + 
			"    </div>\r\n" + 
			"    <button onclick=\"window.location.href = 'pay2.html';\"class='place-order-Cbz'>Pay now</button>" + 
			"  </div>\r\n" + 
			"  <img class=\"vector-Gbr\" src=\"vector-Fz8.png\"/>\r\n" + 
			"  <img class=\"vector-o5z\" src=\"vector.png\"/>\r\n" + 
			"  <img class=\"bxs-cart-LLp\" src=\"bxs-cart.png\"/>\r\n" + 
			"  <p class=\"home-sbe\">HOME</p>"
			+"<p class=\"cake--mh2\">CAKE                                 :</p>\r\n" + 
			"  <p class=\"total--4g8\">TOTAL                                :</p>"
			+ "<p class=\"christmas-pastry-xmW\">"+cake+"</p>"
					+ "<p class=\"christmas-pastry-AWC\">"+price+"</p>"+
			"</div>"
							+ "</body>"
							+ "</html>");
	}
}
