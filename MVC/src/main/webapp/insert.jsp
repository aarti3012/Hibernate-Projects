<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Data</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f8f9fa; margin: 0; padding: 0;">
<div style="width: 400px; margin: 50px auto; background: #ffffff; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 8px;">
    <h1 style="text-align: center; color: #333; font-size: 24px; margin-bottom: 20px;">Insert Data</h1>
    <form action="ProductController" method="post">
        <div style="margin-bottom: 15px;">
            <label for="pid" style="display: block; font-size: 14px; color: #555; margin-bottom: 5px;">Enter Id:</label>
            <input type="text" id="pid" name="pid" style="width: 100%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
        </div>
        <div style="margin-bottom: 15px;">
            <label for="pname" style="display: block; font-size: 14px; color: #555; margin-bottom: 5px;">Enter Name:</label>
            <input type="text" id="pname" name="pname" style="width: 100%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
        </div>
        <div style="margin-bottom: 15px;">
            <label for="price" style="display: block; font-size: 14px; color: #555; margin-bottom: 5px;">Enter Price:</label>
            <input type="text" id="price" name="price" style="width: 100%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
        </div>
        <div style="margin-bottom: 15px;">
            <label for="color" style="display: block; font-size: 14px; color: #555; margin-bottom: 5px;">Enter Color:</label>
            <input type="text" id="color" name="color" style="width: 100%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
        </div>
        <button type="submit" name="insert" style="width: 100%; padding: 10px; background-color: #007BFF; color: white; font-size: 16px; border: none; border-radius: 4px; cursor: pointer;">
            Submit
        </button>
    </form>
</div>
</body>
</html>