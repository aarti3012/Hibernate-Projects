<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0;">
<div style="width: 300px; margin: 50px auto; background: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 8px;">
    <h1 style="text-align: center; color: #333; font-size: 24px; margin-bottom: 20px;">Login Page</h1>
    <form action="insert.jsp" method="post">
        <div style="margin-bottom: 15px;">
            <label for="uname" style="display: block; font-size: 14px; color: #555; margin-bottom: 5px;">Enter Username:</label>
            <input type="text" id="uname" name="uname" style="width: 100%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
        </div>
        <div style="margin-bottom: 15px;">
            <label for="password" style="display: block; font-size: 14px; color: #555; margin-bottom: 5px;">Enter Password:</label>
            <input type="password" id="password" name="password" style="width: 100%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
        </div>
        <button type="submit" name="login" style="width: 100%; padding: 10px; background-color: #007BFF; color: white; font-size: 16px; border: none; border-radius: 4px; cursor: pointer;">
            Login
        </button>
    </form>
</div>
</body>
</html>