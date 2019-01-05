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
        <title>Login Or Register</title>
    </head>
    <body>
        <div>
        <form action="LoginOrRegister" method="post">
            <h2>Login</h2><br>
            <b> username: </b>  <input name="username" type="text"> <br><br>
            <b> password: </b> <input name="password" type="text"> <br><br>
            <input type="hidden" name="back" value="Login.jsp" />

            <input type="submit" value="Register" />
        </form>
        </div>
    </body>
</html>
