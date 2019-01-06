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
        <title>Welcome to All-in-one Converter online!</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
    </head>

    <body>
        <div class = "login-box">
        <form action="LoginOrRegister" method="post">
                        <h2>All-in-one Converter</h2>
            <h2>Login:</h2><br>*
       <label> Username </label>  <input name="username" type="text"> <br><br>
            <label> Password </label>  <input name="password" type="password"> <br><br>
            <input type="hidden" name="back" value="Login.jsp" />

            <input style="margin-bottom: 2%;" type="submit" value="Login" />
            </br>
            <a style="text-align:center;" href="Register.jsp">Not registered yet? Click here to do so</a>
        </form>
        </div>
        
    </body>
</html>
