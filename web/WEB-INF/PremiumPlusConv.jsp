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
        <title>Premium+ Converter</title>
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
                        <option value="M2IN">Meter(s) to Inch(es)</option>
                        <option value="M2CM">Meter(s) to Centimeter(s)</option> 
                        <option value="F2M">Feet to Meter(s)</option>
                        <option value="F2IN">Feet to Inch(es)</option>
                        <option value="F2CM">Feet to Centimeter(s)</option>
                        <option value="CM2M">Centimeter(s) to Meter(s)</option>
                        <option value="CM2F">Centimeter(s) to Feet</option>
                        <option value="CM2IN">Centimeter(s) to Inch(es)</option>
                        <option value="IN2M">Inch(es) to Meter(s)</option>
                        <option value="IN2F">Inch(es) to Feet</option>
                        <option value="IN2CM">Inch(es) to Centimeter(s)</option>
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
                <form action="ConversionServletPlus" method="post">
                    <select id="weightType" name="weightType">
                        
                        <option value="K2P">Kilogram(s) to Pound(s)</option>
                        <option value="K2MG">Kilogram(s) to Milligram(s)</option>
                        <option value="K2O">Kilogram(s) to Ounce(s)</option>
                        <option value="P2K">Pound(s) to Kilogram(s)</option>
                        <option value="P2O">Pound(s) to Ounce(s)</option>
                        <option value="P2MG">Pound(s) to Milligram(s)</option>
                        <option value="MG2K">Milligram(s) to Kilogram(s)</option>
                        <option value="MG2P">Milligram(s) to Pound(s)</option>
                        <option value="MG2O">Milligram(s) to Ounce(s)</option>
                        <option value="O2K">Ounce(s) to Kilogram(s)</option>
                        <option value="O2P">Ounce(s) Pound(s)</option>
                        <option value="O2MG">Ounce(s) Milligram(s)</option>
                        <input name="fromWeight" type="text">
                        <input name="toWeight" type="text" disabled value=<%= request.getAttribute("weightTo") %>>
                        <button type="input" name="convertWeight">Convert</button>
                            
                    </select> 
                </form>   
                    
                    
            </div>
                        
                        <div class="column"> 
                
                <h2> Volume Conversion </h2>
                <form action="ConversionServletPlus" method="post">
                    <select id="volumeType" name="volumeType">
                        
                        <option value="L2G">Liter(s) to Gallon(s)</option>
                        <option value="L2Q">Liter(s) to Quart(s)</option>
                        <option value="L2CL">Liter(s) to Centiliter(s)</option>
                        <option value="G2L">Gallon(s) to Liter(s)</option>
                        <option value="G2Q">Gallon(s) to Quart(s)</option>
                        <option value="G2CL">Gallon(s) to Centiliter(s)</option>
                        <option value="CL2L">Centiliter(s) to Liter(s)</option>
                        <option value="CL2G">Centiliter(s) to Gallon(s)</option>
                        <option value="CL2Q">Centiliter(s) to Quart(s)</option>
                        <option value="Q2L">Quart(s) to Liter(s)</option>
                        <option value="Q2G">Quart(s) to Gallon(s)</option>
                        <option value="Q2CL">Quart(s) to Centiliter(s)</option>
                        <input name="fromVolume" type="text">
                        <input name="toVolume" type="text" disabled value=<%= request.getAttribute("volumeTo") %>>
                        <button type="input" name="convertVolume">Convert</button>
                            
                    </select> 
                </form>    
                    
                    
            </div>
                
            <div class="column"> 
                
                <h2> Bits&Bytes Conversion </h2>
                <form action="ConversionServletPlus" method="post">
                    <select id="bitType" name="bitType">
                        
                        <option value="BI2BY">Bit(s) to Byte(s)</option>
                        <option value="BY2BI">Byte(s) to Bit(s)</option>
                        <input name="fromBit" type="text">
                        <input name="toBit" type="text" disabled value=<%= request.getAttribute("bitTo") %>>
                        <button type="input" name="convertBit">Convert</button>
                            
                    </select> 
                </form>    
                
                    
            </div>
                        
                               <div class="column"> 
                
                <h2>Currency Conversion </h2>
                <form action="ConversionServletPlus" method="post">
                    <select id="currencyType" name="currencyType">
                        
                        <option value="U2S">USD to SEK</option>
                        <option value="U2E">USD to EUR</option>
                        <option value="U2Y">USD to YEN</option>
                        <option value="S2U">SEK to USD</option>
                        <option value="S2Y">SEK to YEN</option>
                        <option value="S2E">SEK to EUR</option>
                        <option value="E2S">EUR to SEK</option>
                        <option value="E2U">EUR to USD</option>
                        <option value="E2Y">EUR to YEN</option>
                        <option value="Y2S">YEN to SEK</option>
                        <option value="Y2U">YEN to USD</option>
                        <option value="Y2E">YEN to EUR</option>
                        
                        <input name="fromCurrency" type="text">
                        <input name="toCurrency" type="text" disabled value=<%= request.getAttribute("currencyTo") %>>
                        <button type="input" name="convertCurrency">Convert</button>
                            
                    </select> 
                </form>    
                    
                    
            </div>
                
            <div class="column"> 
                
                <h2>Time Conversion </h2>
                <form action="ConversionServletPlus" method="post">
                    <select id="timeType" name="timeType">
                        
                        <option value="H2M">Hours to Minutes</option>
                        <option value="H2S">Hours to Seconds</option>
                        <option value="M2H">Minutes to Hours</option>
                        <option value="M2S">Minutes to Seconds</option>
                        <option value="S2H">Seconds to Hours</option>
                        <option value="S2M">Seconds to Minutes</option>
                        
                        <input name="fromTime" type="text">
                        <input name="toTime" type="text" disabled value=<%= request.getAttribute("timeTo") %>>
                        <button type="input" name="convertTime">Convert</button>
                            
                    </select> 
                </form>    
                
                    
            </div>
                    
                        
                        
                        
                        
                
        </div>
            
                        <button style="margin-bottom: 2%; float:left;" type="button" name="logout" onclick="window.location='Login.jsp'">Log out</button>
    </body>
</html>
