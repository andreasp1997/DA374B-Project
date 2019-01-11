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
        <title>Premium Converter</title>
        <link rel="stylesheet" type="text/css" href="Assets/style.css">
            
    </head>
    <body>
        <h1 style="text-align: center;">Welcome to All-In-One Converter Premium Edition</h1>
        <div class="row"> 
            
            <div class="column"> 
                
                <h2> Length Conversion </h2>
                    
                <form action="ConversionServletPremium" method="post">
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
                    
                <form action="ConversionServletPremium" method="post">
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
                    
                <form action="ConversionServletPremium" method="post">
                    <select id="weightType" name="weightType">
                        
                        <option value="K2P">Kilogram(s) to Pound(s)</option>
                        <option value="P2K">Pound(s) to Kilogram(s)</option>
                        <input name="fromWeight" type="text">
                        <input name="toWeight" type="text" disabled value=<%= request.getAttribute("weightTo") %>>
                        <button type="input" name="convertWeight">Convert</button>
                            
                    </select> 
                </form> 
                    
            </div>
                
            <div class="column"> 
                
                <h2> Volume Conversion </h2>
                <form action="ConversionServletPremium" method="post">
                    <select id="volumeType" name="volumeType">
                        
                        <option value="L2G">Liter(s) to Gallon(s)</option>
                        <option value="G2L">Gallon(s) to Liter(s)</option>
                        <input name="fromVolume" type="text">
                        <input name="toVolume" type="text" disabled value=<%= request.getAttribute("volumeTo") %>>
                        <button type="input" name="convertVolume">Convert</button>
                            
                    </select> 
                </form>    
                    
                    
            </div>
                
            <div class="column"> 
                
                <h2> Bits&Bytes Conversion </h2>
                <form action="ConversionServletPremium" method="post">
                    <select id="bitType" name="bitType">
                        
                        <option value="BI2BY">Bit(s) to Byte(s)</option>
                        <option value="BY2BI">Byte(s) to Bit(s)</option>
                        <input name="fromBit" type="text">
                        <input name="toBit" type="text" disabled value=<%= request.getAttribute("bitTo") %>>
                        <button type="input" name="convertBit">Convert</button>
                            
                    </select> 
                </form>    
                
                    
            </div>
                
        </div>
                   <button style="margin-bottom: 2%; float:left;" type="button" name="logout" onclick="window.location='Login.jsp'">Log out</button>
    </body>
</html>
