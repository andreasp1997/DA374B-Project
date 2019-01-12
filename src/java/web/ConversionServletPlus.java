/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import bean.BitsBytesConvBean;
import bean.ConversionBean;
import bean.CurrencyConvBean;
import bean.LengthConvBean;
import bean.TempConvBean;
import bean.VolumeConvBean;
import bean.WeightConvBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jun
 */
@WebServlet(name = "ConversionServletPlus", urlPatterns = {"/ConversionServletPlus"})
public class ConversionServletPlus extends HttpServlet {
    @EJB
    private ConversionBean conversionBean;
    private final LengthConvBean lengthConvBean = new LengthConvBean();
    private final WeightConvBean weightConvBean = new WeightConvBean();
    private final TempConvBean tempConvBean = new TempConvBean();
    private final VolumeConvBean volumeConvBean = new VolumeConvBean();
    private final BitsBytesConvBean bitsBytesConvBean = new BitsBytesConvBean();
    private final CurrencyConvBean currencyConvBean = new CurrencyConvBean();
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConversionServletPlus</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConversionServletPlus at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tempValue = request.getParameter("fromTemp");
        String conversionTypeTemp = request.getParameter("tempType");
        
        String weightValue = request.getParameter("fromWeight");
        String conversionTypeWeight = request.getParameter("weightType");
        
        String lengthValue = request.getParameter("fromLength");
        String conversionTypeLength = request.getParameter("lengthType");
        
        String volumeValue = request.getParameter("fromVolume");
        String conversionTypeVolume = request.getParameter("volumeType");
        
        String bitValue = request.getParameter("fromBit");
        String conversionTypeBit = request.getParameter("bitType");
        
        String currencyValue = request.getParameter("fromCurrency");
        String conversionTypeCurrency = request.getParameter("currencyType");
        
        if(request.getParameter("convertTemp") != null) {
            
            double value = 0;
            try {
                value = Double.parseDouble(tempValue);
            }catch(NumberFormatException ex) {
                request.setAttribute("tempTo", "BADINPUT");
                getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                System.out.println(ex);
            }
            double returnValue;
            System.out.println(conversionTypeTemp);
            switch (conversionTypeTemp) {
                case "F2C" :
                    //returnValue = conversionBean.F2C(value);
                    returnValue = tempConvBean.F2C(value);
                    request.setAttribute("tempTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request, response);
                    break;
                case "C2F":
                    //returnValue = conversionBean.C2F(value);
                    returnValue = tempConvBean.C2F(value);
                    System.out.println(response.isCommitted()+"3");
                    request.setAttribute("tempTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
            }
        }
        
        if(request.getParameter("convertWeight") != null) {
            double value = 0;
            try {
                value = Double.parseDouble(weightValue);
            }catch(NumberFormatException ex) {
                request.setAttribute("weightTo", "BADINPUT");
                System.out.println(ex);
                getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                
            }
            double returnValue;
            switch(conversionTypeWeight) {
                case "K2P" :
                    //returnValue = conversionBean.K2P(value);
                    returnValue = weightConvBean.K2P(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                case "P2K" :
                    //returnValue = conversionBean.P2K(value);
                    returnValue = weightConvBean.P2K(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
            }
        }
        
        if(request.getParameter("convertLength") != null) {
            double value = 0;
            try {
                value = Double.parseDouble(lengthValue);
            }catch(NumberFormatException ex) {
                request.setAttribute("lengthTo", "BADINPUT");
                getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                System.out.println(ex);
            }
            
            double returnValue;
            switch(conversionTypeLength) {
                case "M2F" :
                    //returnValue = conversionBean.M2F(value);
                    returnValue = lengthConvBean.M2F(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                case "F2M" :
                    //returnValue = conversionBean.F2M(value);
                    returnValue = lengthConvBean.F2M(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
            }
        }
        
        if(request.getParameter("convertVolume") != null) {
            double value = 0;
            try {
                value = Double.parseDouble(volumeValue);
            }catch(NumberFormatException ex) {
                request.setAttribute("volumeTo", "BADINPUT");
                getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                System.out.println(ex);
            }
            
            double returnValue;
            switch(conversionTypeVolume) {
                case "L2G" :
                    //returnValue = conversionBean.L2G(value);
                    returnValue = volumeConvBean.L2G(value);
                    System.out.println(returnValue);
                    request.setAttribute("volumeTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                case "G2L" :
                    //returnValue = conversionBean.G2L(value);
                    //System.out.println(returnValue);
                    returnValue = volumeConvBean.G2L(value);
                    request.setAttribute("volumeTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
            }
        }
        
        if(request.getParameter("convertBit") != null) {
            double value = 0;
            try {
                value = Double.parseDouble(bitValue);
            }catch(NumberFormatException ex) {
                request.setAttribute("bitTo", "BADINPUT");
                getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                System.out.println(ex);
            }
            
            double returnValue;
            switch(conversionTypeBit) {
                case "BI2BY" :
                    //returnValue = conversionBean.BI2BY(value);
                    returnValue = bitsBytesConvBean.BI2BY(value);
                    request.setAttribute("bitTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                case "BY2BI" :
                    //returnValue = conversionBean.BY2BI(value);
                    returnValue = bitsBytesConvBean.BY2BI(value);
                    request.setAttribute("bitTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
            }
        }
        
        if(request.getParameter("convertCurrency") != null) {
            double value = 0;
            try {
                value = Double.parseDouble(currencyValue);
            }catch(NumberFormatException ex) {
                request.setAttribute("currencyTo", "BADINPUT");
                getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                System.out.println(ex);
            }
            
            double returnValue;
            switch(conversionTypeCurrency) {
                case "U2S" :
                    
                    returnValue = currencyConvBean.U2S(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                    
                case "U2E" :
                    
                    returnValue = currencyConvBean.U2E(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                    
                case "U2Y" :
                    
                    returnValue = currencyConvBean.U2Y(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                    
                case "S2U" :
                    
                    returnValue = currencyConvBean.S2U(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                    
                case "S2Y" :
                    
                    returnValue = currencyConvBean.S2Y(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                    
                case "S2E" :
                    
                    returnValue = currencyConvBean.S2E(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                    
                case "E2S" :
                    
                    returnValue = currencyConvBean.E2S(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                    
                case "E2U" :
                    
                    returnValue = currencyConvBean.E2U(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                    
                case "E2Y" :
                    
                    returnValue = currencyConvBean.E2Y(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                    
                case "Y2S" :
                    
                    returnValue = currencyConvBean.Y2S(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                    
                case "Y2U" :
                    
                    returnValue = currencyConvBean.Y2U(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
                    
                case "Y2E" :
                    
                    returnValue = currencyConvBean.Y2E(value);
                    request.setAttribute("currencyTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/PremiumPlusConv.jsp").forward(request,response);
                    break;
            }
        }
    }      

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
