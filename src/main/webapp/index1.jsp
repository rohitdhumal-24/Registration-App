<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="regform" method="post">
Name:<input type="text" name="name1" placeholder="Enter name" /> </br></br>
Email:<input type="text" name="email1" placeholder="Enter Email" /> </br></br>
Password:<input type="password" name="pass1" placeholder="Enter Password" /> </br></br>
Gender:<input type="radio" name="gender1" value="male" /> Male <input type="radio" name="gender1" value="female" /> female </br></br>
City: <select name="city1">
       <option> Select City </option>
       <option> Mumbai</option>
       <option> Pune  </option>
       <option> Banglore </option>
       <option> Delhi </option>
     </select> </br></br>
  <input type="Submit" value="Register" />   
</form>
</body>
</html>