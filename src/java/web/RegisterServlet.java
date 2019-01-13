/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

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
        private RegisterBean mailSender;

    
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
        
        String accType = null;
        String checkUser = null;
        String idAccountNr = null;
        int accId = 0;
        
        DBhandler dbhandler = new DBhandler();
        Connection connection = dbhandler.getCon();
        
        //Check if username exists
        try {
            
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT username from mydb.Account where username = + '" + username + "'");
            
            while (rs.next()){
                checkUser = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(accountType);
        
        //Check what account type is selected
        if (accountType.equalsIgnoreCase("Standard")){
            accType = "Standard";
        } else if (accountType.equalsIgnoreCase("Premium")){
            accType = "Premium";
        } else if (accountType.equalsIgnoreCase("Plus")){
            accType = "Plus";
        }
        
        //get account ID
        try {
            
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT count(idAccount) from mydb.Account");
            
            while (rs.next()){
                idAccountNr = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        
        String fromEmail = "converterprojectda374b@gmail.com";
        String Emailusername = "converterprojectda374b";
        String Emailpassword = "dummypassword";
        
        mailSender.sendEmail(fromEmail, Emailusername, Emailpassword, toEmail);
            
            try {
            
            Statement statement = connection.createStatement();
            
            statement.executeUpdate("INSERT INTO mydb.Account (idAccount, "
                    + "firstname, lastname, email, ssn, username, password, accountType) values"
                    + "('"+ accId +"', '"+ firstname +"', '" + lastname + "', '" + email + "', '" + ssn + "',"
                            + " '" + username + "', '" + password +"', '" + accType +"')");
            
            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("Login.jsp");
            RequetsDispatcherObj.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          
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
