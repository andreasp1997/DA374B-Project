/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Singleton.Singleton;
import Database.DBhandler;
import bean.DBbean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andreas
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @EJB
    private DBbean dbBean = new DBbean();
    
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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Singleton singleton = new Singleton();
        
        String checkPassword = null;
        String checkUser = null;
        String checkAccountType = null;
        
        //Check password for username
        dbBean.checkPassForUser(username);
        checkPassword = singleton.getInstance().getPassword();
        
        //Check if user exists 
        dbBean.checkForUsername(username);
        checkUser = singleton.getInstance().getCheckUser();
        
        //Check account type for logging in
        dbBean.checkAccountType(username);
        checkAccountType = singleton.getInstance().getAccountType();
        
        // Checks if username/password is incorrect, and if they are, user will be prompted to retry login
        if (checkUser == "" || checkUser == null ||  !checkPassword.equals(password)){
            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("LoginRetry.jsp");
            RequetsDispatcherObj.forward(request, response);
        
        // Saves username to be shown in converter menu, and sends user to converter menu based on account type
        } else {
            
            request.getSession().setAttribute("username", checkUser);
            singleton.getInstance().setUserAcc(checkUser);
            
            if (checkAccountType.equalsIgnoreCase("standard")){            
               
                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("WEB-INF/StandardConv.jsp");
                RequetsDispatcherObj.forward(request, response);
                
            } else if (checkAccountType.equalsIgnoreCase("premium")){
               
                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("WEB-INF/PremiumConv.jsp");          
                RequetsDispatcherObj.forward(request, response);
           
            } else if (checkAccountType.equalsIgnoreCase("plus")){
                
                RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("WEB-INF/PremiumPlusConv.jsp");          
                RequetsDispatcherObj.forward(request, response);
                
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
