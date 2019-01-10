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
        <h1 style="text-align: center;">Welcome to All-In-One Converter Premium+ Edition</h1>
        <div class="row"> 
            
            <div class="column"> 
                
                <h2> Length Conversion </h2>
                <form action="ConversionServletPlus" method="post">
                    <select id="lengthType" name="lengthType">
                        
                        <option value="M2F">Meter(s) to Feet</option>
                        <option value="F2M">Feet to Meter(s)</option>
                        <input name="fromLength" type="text">
                        <input name="toLength" type="text" disabled value= <%= request.getAttribute("lengthTo") %>>
                        <button type="input" name="convertLength">Convert</button>
                            
                    </select> 
                        
                </form>
                    
            </div>
                
            <div class="column"> 
                
                <h2> Temperature Conversion </h2>
                <form action="ConversionServletPlus" method="post">
                    <select id="tempType" name="tempType">
                        
                        <option value="C2F">Celsius to Fahrenheit</option>
                        <option value="F2C">Fahrenheit to Celsius</option>
                        <input name="fromTemp" type="text">
                        <input name="toTemp" type="text" disabled value= <%= request.getAttribute("tempTo") %>>
                        <button type="input" name="convertTemp">Convert</button>
                            
                    </select> 
                </form>
                    
                    
            </div>
                
            <div class="column"> 
                
                <h2> Weight Conversion </h2>
                <form action="ConversionServletPus" method="post">
                    <select id="weightType" name="weightType">
                        
                        <option value="K2P">Kilogram(s) to Pound(s)</option>
                        <option value="P2K">Pound(s) to Kilogram(s)</option>
                        <input name="fromWeight" type="text">
                        <input name="toWeight" type="text" disabled value=<%= request.getAttribute("weightTo") %>>
                        <button type="input" name="convertWeight">Convert</button>
                            
                    </select> 
                </form>   
                    
                    
            </div>
                
        </div>
            
    </body>
</html>
