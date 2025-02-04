<%@ page import="java.sql.*, com.dao.DBConnect" %>
<%
    int pid = Integer.parseInt(request.getParameter("pid"));
    String pname = "";
    double price = 0.0;
    String color = "";

    try {
        Connection con = DBConnect.getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM products WHERE pid = ?");
        pst.setInt(1, pid);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            pname = rs.getString("pname");
            price = rs.getDouble("price");
            color = rs.getString("color");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Product</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0;">
    <div style="width: 400px; margin: 50px auto; background: #ffffff; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 8px;">
        <h2 style="text-align: center; color: #333; font-size: 24px; margin-bottom: 20px;">Update Product</h2>
        <form action="ProductController" method="post">
            <input type="hidden" name="pid" value="<%= pid %>">
            
            <div style="margin-bottom: 15px;">
                <label for="pname" style="display: block; font-size: 14px; color: #555; margin-bottom: 5px;">Product Name:</label>
                <input type="text" id="pname" name="pname" value="<%= pname %>" style="width: 100%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label for="price" style="display: block; font-size: 14px; color: #555; margin-bottom: 5px;">Price:</label>
                <input type="text" id="price" name="price" value="<%= price %>" style="width: 100%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label for="color" style="display: block; font-size: 14px; color: #555; margin-bottom: 5px;">Color:</label>
                <input type="text" id="color" name="color" value="<%= color %>" style="width: 100%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
            </div>
            
            <button type="submit" name="update" style="width: 100%; padding: 10px; background-color: #007BFF; color: white; font-size: 16px; border: none; border-radius: 4px; cursor: pointer;">
                Update
            </button>
        </form>
    </div>
</body>
</html>