/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Singleton.Singleton;
import Database.DBhandler;
import bean.DBbean;
import bean.RegisterBean;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        @EJB
        private RegisterBean mailSender = new RegisterBean();
        private DBbean dbBean = new DBbean();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
      
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
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
        
        String firstname = request.getParameter("firstname").toString();
        String lastname = request.getParameter("lastname").toString();
        String username = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();
        String email = request.getParameter("email").toString();
        String ssn = request.getParameter("ssn").toString();
        String accountType = request.getParameter("accType").toString();
       
        Singleton singleton = new Singleton();
        
        String accType = null;
        String checkUser = null;
        String idAccountNr = null;
        int accId = 0;
        
        //Check if username exists
        dbBean.checkForUsername(username);
        checkUser = Singleton.getInstance().getCheckUser();
        
        //Check what account type is selected
        if (accountType.equalsIgnoreCase("Standard")){
            accType = "Standard";
        } else if (accountType.equalsIgnoreCase("Premium")){
            accType = "Premium";
        } else if (accountType.equalsIgnoreCase("Plus")){
            accType = "Plus";
        }
        
        //get account ID
        dbBean.getAccountID();
        idAccountNr = singleton.getInstance().getIdAccount();
        
        if(idAccountNr.equals("0") || idAccountNr == null || idAccountNr.equals("")){
            accId = 0;
        } else {
            accId = 0;
            accId = Integer.parseInt(idAccountNr);
        }
        
        //Create Account if all conditions are met
        if (checkUser == "" || checkUser == null && firstname != null && lastname != null && username != null && 
                password != null && email != null && ssn != null){
            
        String toEmail = request.getParameter("email");
        
        // sender for Java Mail
        String fromEmail = "converterprojectda374b@gmail.com";
        String Emailusername = "converterprojectda374b";
        String Emailpassword = "dummypassword";
        
        // used for java mail
        singleton.getInstance().setFirstname(firstname);
        singleton.getInstance().setLastname(lastname);
        singleton.getInstance().setAccountType(accType);
        
        // Send confirmation email
        mailSender.sendEmail(fromEmail, Emailusername, Emailpassword, toEmail);
        
        // Create user
        dbBean.createUser(accId, firstname, lastname, email, ssn, username, password, accType);
        
        // Go back to login page
        RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("Login.jsp");
        RequetsDispatcherObj.forward(request, response);
          
        // Redirect to register again if username already exists
        // Or fields are empty
        } else {
            accId = 0;
            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("RegisterRetry.jsp");
            RequetsDispatcherObj.forward(request, response);
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
