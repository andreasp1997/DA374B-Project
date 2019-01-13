<%-- 
    Document   : loginReg
    Created on : Jan 6, 2019, 12:21:31 AM
    Author     : andreas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Converter account</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
    </head>
        
    <body>
        <div class = "login-box">
            <form action="RegisterServlet" method="POST" action="RegisterServlet">
                <h2>All-in-one Converter</h2>
                <h2>Register:</h2><br>
                <select id="accType" name="accType">
                    <option value="Standard">Standard (Free)</option>
                    <option value="Premium">Premium ($9.99)</option>
                    <option value="Plus">Premium+ ($19.99)</option>
                </select> 
                <br>            <br>
                
                <label> Firstname </label>  <input name="firstname" type="text"> <br><br>
                <label> Lastname </label> <input name="lastname" type="text"> <br><br>
                <label> SSN </label>  <input name="ssn" type="text"> <br><br>
                <label> E-mail </label>  <input name="email" type="text"> <br><br>
                <label> Username </label>  <input name="username" type="text"> <br><br>
                <label> Password </label>  <input name="password" type="password"> <br><br>
                
                <input type="hidden" name="back" value="Login.jsp" />
                
                <input style="margin-bottom: 2%;" type="submit" value="Register" />
                </br>
                
            </form>
        </div>
            
    </body>
</html>
