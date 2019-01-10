<%-- 
    Document   : StandardConv
    Created on : Jan 8, 2019, 11:27:17 AM
    Author     : andreas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Standard Converter</title>
        <link rel="stylesheet" type="text/css" href="Assets/style.css">
            
    </head>
    <body>
        <h1>Welcome to All-In-One Converter Standard Edition</h1>
        <div class="row"> 
            
            <div class="column"> 
                
                <h2> Length Conversion </h2>
                    
                <form action="ConversionServletStandard" method="post">
                    <select id="lengthType" name="lengthType">
                        
                        <option value="M2F">Meter(s) to Feet</option>
                        <option value="F2M">Feet to Meter(s)</option>
                        <input name="fromLength" type="text">
                        <% 
                            Object length = request.getAttribute("lengthTo");
                            if(length == null) {
                                length = "";
                            }
                        %>
                        <input name="toLength" type="text" disabled value= <%= request.getAttribute("lengthTo") %>>
                        <button type="input" name="convertLength">Convert</button>
                            
                    </select> 
                        
                </form>
                    
            </div>
                
            <div class="column"> 
                
                <h2> Temperature Conversion </h2>
                    
                <form action="ConversionServletStandard" method="post">
                    <select id="tempType" name="tempType">
                        
                        <option value="C2F">Celsius to Fahrenheit</option>
                        <option value="F2C">Fahrenheit to Celsius</option>
                        <input name="fromTemp" type="text">
                        <% 
                            Object temp = request.getAttribute("tempTo");
                            if(temp == null) {
                                temp = "";
                            }
                        %>
                        <input name="toTemp" type="text" disabled value= <%=temp%>>
                        <button type="input" name="convertTemp">Convert</button>
                            
                    </select> 
                </form> 
                    
            </div>
                
            <div class="column"> 
                
                <h2> Weight Conversion </h2>
                    
                <form action="ConversionServletStandard" method="post">
                    <select id="weightType" name="weightType">
                        
                        <option value="K2P">Kilogram(s) to Pound(s)</option>
                        <option value="P2K">Pound(s) to Kilogram(s)</option>
                        <input name="fromWeight" type="text">
                        <% 
                            Object weight = request.getAttribute("weightTo");
                            if(weight == null) {
                                weight = "";
                            }
                        %>
                        <input name="toWeight" type="text" disabled value=<%= weight%>>
                        <button type="input" name="convertWeight">Convert</button>
                            
                    </select> 
                </form> 
                    
            </div>
                
        </div>
                        <button style="margin-bottom: 2%; float:left;" type="button" name="logout" onclick="window.location='loginReg.jsp'">Log out</button>
    </body>
</html>
