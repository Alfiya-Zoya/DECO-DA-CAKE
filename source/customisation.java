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
 * Servlet implementation class customisation
 */
@WebServlet("/customisation")
public class customisation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customisation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flavor="";
		int price=0;
		PrintWriter out =response.getWriter();
		String layer = request.getParameter("layer");
		String weight = request.getParameter("weight");
		String shape = request.getParameter("shape");
		String flavour = request.getParameter("flavour");
		String des = request.getParameter("des");
		//int num = Integer.valueOf(n);
		//System.out.print(num);
		//int layers = Integer.valueOf(layer);
		int weights = Integer.valueOf(weight);
		int flavours = Integer.valueOf(flavour);
		switch(flavours)
		{
		case 1:
			flavor = "chocolate";
			price = weights*1000;
			break;
		case 2:
			flavor = "Strawberry";
			price = weights*800;
			break;
		case 3:
			flavor = "Butterscotch";
			price = weights*900;
			break;
		}
		String w = String.valueOf(weights);
		String f = String.valueOf(flavor);
		String total = String.valueOf(price);
		System.out.print(layer);
		System.out.print(w);
		System.out.print(shape);
		System.out.print(f);
		System.out.print(total);
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
			String query = "insert into customize(layer,shape,weight,flavor,description,price) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, layer);
			pstmt.setString(2, shape);
			pstmt.setString(3, w);
			pstmt.setString(4, f);
			pstmt.setString(5, des);
			pstmt.setString(6, total);

			pstmt.executeUpdate();

		}
		catch(Exception e)
		{
			System.out.println("Cannot connect to database " + e);
		}

		
		out.println("<html>" + 
				"<head>\r\n" + 
				"  <meta charset=\"utf-8\" />\r\n" + 
				"  <link rel=\"icon\" href=\"/favicon.ico\" />\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n" + 
				"  <meta name=\"theme-color\" content=\"#000000\" />\r\n" + 
				"  <title>Bill customization</title>\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Inter%3A400%2C600%2C700%2C800\"/>\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro%3A400%2C600%2C700%2C800\"/>\r\n" + 
				"  <link rel=\"stylesheet\" href=\"bill-customization.css\"/>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div class=\"bill-customization-Jvc\">\r\n" + 
				"  <div class=\"auto-group-ybkw-SvL\">\r\n" + 
				"    <img class=\"ellipse-3-oXv\" src=\"ellipse-3.png\"/>\r\n" + 
				"    <img class=\"black-minimal-cake-logo-1-72p\" src=\"black-minimal-cake-logo-1.png\"/>\r\n" + 
				"    \r\n" + 
				"    <p class=\"bill-LRN\">Bill</p>\r\n" + 
				"    <div class=\"rectangle-2-noA\">\r\n" + 
				"    </div>\r\n" + 
				"    <button onclick=\"window.location.href = 'pay2.html';\"class='place-order-pjr'>Pay now</button>" + 
				"  </div>\r\n" + 
				"  <img class=\"vector-qex\" src=\"vector-uzY.png\"/>\r\n" + 
				"  <img class=\"vector-9fe\" src=\"vector.png\"/>\r\n" + 
				"  <img class=\"bxs-cart-656\" src=\"bxs-cart.png\"/>\r\n" + 
				"  <p class=\"home-zgG\">HOME</p>\r\n" + 
				"  <p class=\"layers--tWk\">LAYERS                                 :</p>\r\n" + 
				"  <p class=\"weightin-kg--nc8\">WEIGHT(in Kg)                     :</p>\r\n" + 
				"  <p class=\"shape--672\">SHAPE                                  :</p>\r\n" + 
				"  <p class=\"flavour--kSU\">FLAVOUR                              :</p>\r\n" + 
				"  <p class=\"total--Dax\">TOTAL                                   :</p>\r\n" 
				
				+ "<p class=\"christmas-pastry-wG4\" >"+layer+"</p>"
						+ "<p class=\"christmas-pastry-pKr\">"+w+"</p>"
								+ "<p class=\"christmas-pastry-6oA\">" +shape+"</p>"
										+ "<p class=\"christmas-pastry-pDN\"> "+f+"</p>"
												+ "<p class=\"christmas-pastry-7TN\">"+total+"</p>"
								+"</div>"				
								+ "</body>"
								);
	}

	
	}
