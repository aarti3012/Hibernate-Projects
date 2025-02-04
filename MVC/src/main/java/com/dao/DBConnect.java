package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
   public static Connection con;

public static Connection getConnection() throws Exception
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tek","root","aarti");
	return con;
}
   
}
