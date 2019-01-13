/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import bean.ConversionBean;
import bean.LengthConvBean;
import bean.TempConvBean;
import bean.WeightConvBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jun
 */
@WebServlet(name = "ConversionServletStandard", urlPatterns = {"/ConversionServletStandard"})
public class ConversionServletStandard extends HttpServlet {
    @EJB
    private ConversionBean conversionBean;
    private final LengthConvBean lengthConvBean = new LengthConvBean();
    private final WeightConvBean weightConvBean = new WeightConvBean();
    private final TempConvBean tempConvBean = new TempConvBean();
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
            out.println("<title>Servlet ConversionServletStandard</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConversionServletStandard at " + request.getContextPath() + "</h1>");
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
        
        Singleton singleton = new Singleton();
        String user = singleton.getInstance().getUserAcc();
        request.getSession().setAttribute("username", user);
        System.out.println(user);
        
        if(request.getParameter("convertTemp") != null) {
            
            double value = 0;
            try {
                value = Double.parseDouble(tempValue);
            }catch(NumberFormatException ex) {
                request.setAttribute("tempTo", "BADINPUT");
                getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                System.out.println(ex);
            }
            
            double returnValue;
            switch (conversionTypeTemp) {
                case "F2C" :
                    //returnValue = conversionBean.F2C(value);
                    returnValue = tempConvBean.F2C(value);
                    request.setAttribute("tempTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request, response);
                    break;
                case "C2F":
                    //returnValue = conversionBean.C2F(value);
                    returnValue = tempConvBean.C2F(value);
                    request.setAttribute("tempTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
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
                getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                
            }
            double returnValue;
            switch(conversionTypeWeight) {
                case "K2P" :
                    //returnValue = conversionBean.K2P(value);
                    returnValue = weightConvBean.K2P(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "K2MG" :
                    returnValue = weightConvBean.K2MG(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "K2O" : 
                    returnValue = weightConvBean.K2O(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "P2K" :
                    //returnValue = conversionBean.P2K(value);
                    returnValue = weightConvBean.P2K(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "P2O" : 
                    returnValue = weightConvBean.P2O(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "P2MG" :
                    returnValue = weightConvBean.P2MG(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "MG2K" :
                    returnValue = weightConvBean.MG2K(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case  "MG2P": 
                    returnValue = weightConvBean.MG2P(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "MG2O" : 
                    returnValue = weightConvBean.MG2O(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "O2K" : 
                    returnValue = weightConvBean.O2K(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "O2P": 
                    returnValue = weightConvBean.O2P(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "O2MG":
                    returnValue = weightConvBean.O2MG(value);
                    request.setAttribute("weightTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                    
            }
        }
        
        if(request.getParameter("convertLength") != null) {
            double value = 0;
            try {
                value = Double.parseDouble(lengthValue);
            }catch(NumberFormatException ex) {
                request.setAttribute("lengthTo", "BADINPUT");
                getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                System.out.println(ex);
            }
            
            double returnValue;
            switch(conversionTypeLength) {
                case "M2F" :
                    //returnValue = conversionBean.M2F(value);
                    returnValue = lengthConvBean.M2F(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "M2IN" :
                    returnValue = lengthConvBean.M2IN(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "M2CM" : 
                    returnValue = lengthConvBean.M2CM(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "F2M" :
                    //returnValue = conversionBean.F2M(value);
                    returnValue = lengthConvBean.F2M(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "F2IN":
                    returnValue = lengthConvBean.F2IN(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "F2CM" : 
                    returnValue = lengthConvBean.F2CM(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "CM2M" :
                    returnValue = lengthConvBean.CM2M(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "CM2F": 
                    returnValue = lengthConvBean.CM2F(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "CM2IN" :
                    returnValue = lengthConvBean.CM2IN(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "IN2M" : 
                    returnValue = lengthConvBean.IN2M(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "IN2F" :
                    returnValue = lengthConvBean.IN2F(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
                    break;
                case "IN2CM": 
                    returnValue = lengthConvBean.IN2CM(value);
                    request.setAttribute("lengthTo", returnValue);
                    getServletContext().getRequestDispatcher("/WEB-INF/StandardConv.jsp").forward(request,response);
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
