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
    </head>
    <body>
        <h1>Welcome to All-In-One Converter Standard Edition</h1>
        <div class="row"> 
        
            <div class="column"> 
            
                <h2> Length Conversion </h2>
                
                <select id="accType" name="accType">
   
                    <option value="M2F">Meter(s) to Feet</option>
                    <option value="F2M">Feet to Meter(s)</option>
                    <input name="fromLength" type="text">
                    <input name="toLength" type="text" disabled>
                    <button type="button" name="convertLength">Convert</button>
                    
                </select> 
                
            </div>
            
            <div class="column"> 
            
                <h2> Temperature Conversion </h2>
                
                <select id="accType" name="accType">
   
                    <option value="C2F">Celsius to Fahrenheit</option>
                    <option value="F2C">Fahrenheit to Celsius</option>
                    <input name="fromTemp" type="text">
                    <input name="toTemp" type="text" disabled>
                    <button type="button" name="convertLength">Convert</button>
                    
                </select> 
                
            </div>
            
            <div class="column"> 
                
                <h2> Weight Conversion </h2>
                
                <select id="accType" name="accType">
   
                    <option value="K2P">Kilogram(s) to Pound(s)</option>
                    <option value="F2C">Pound(s) to Kilogram(s)</option>
                    <input name="fromWeight" type="text">
                    <input name="toWeight" type="text" disabled>
                    <button type="button" name="convertLength">Convert</button>
                    
                </select> 
            
            </div>
        
        </div>
    </body>
</html>
