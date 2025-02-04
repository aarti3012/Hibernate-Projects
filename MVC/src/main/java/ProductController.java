import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBConnect;
import com.dao.Product;
import com.dao.*;


@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("login")!=null)
		{
			String username=request.getParameter("uname");
			String password=request.getParameter("password");
			try {
				Connection con=DBConnect.getConnection();
				PreparedStatement pst=con.prepareStatement("select *from users where username=? and password=?");
				pst.setString(1, username);
				pst.setString(2, password);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					response.sendRedirect("products.jsp");
				}
				else
				{
					response.sendRedirect("index.jsp");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(request.getParameter("insert")!=null)
		{
			int pid=Integer.parseInt(request.getParameter("pid"));
			String pname=request.getParameter("pname");
			Double price=Double.parseDouble(request.getParameter("price"));
			String colour=request.getParameter("color");
			
			Product product=new Product();
			product.setPid(pid);
			product.setPname(pname);
			product.setPrice(price);
			product.setColor(colour);
			
			try {
				Connection con=DBConnect.getConnection();
				PreparedStatement pst=con.prepareStatement("insert into products values(?,?,?,?)");
				pst.setInt(1, product.getPid());
				pst.setString(2, product.getPname());
				pst.setDouble(3, product.getPrice());
				pst.setString(4, product.getColor());
				pst.executeUpdate();
				response.sendRedirect("products.jsp");
			}catch(Exception e) {
				
			}
		}
		if (request.getParameter("update") != null) {
		    int pid = Integer.parseInt(request.getParameter("pid"));
		    String pname = request.getParameter("pname");
		    Double price = Double.parseDouble(request.getParameter("price"));
		    String colour = request.getParameter("color");

		    try {
		        Connection con = DBConnect.getConnection();
		        PreparedStatement pst = con.prepareStatement(
		            "UPDATE products SET pname = ?, price = ?, color = ? WHERE pid = ?");
		        pst.setString(1, pname);
		        pst.setDouble(2, price);
		        pst.setString(3, colour);
		        pst.setInt(4, pid);
		        int rowsUpdated = pst.executeUpdate();

		        if (rowsUpdated > 0) {
		            response.sendRedirect("products.jsp");
		        } else {
		            response.getWriter().println("Update failed. Please check the product ID.");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	}
}
