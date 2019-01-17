/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import Database.DBhandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import web.RegisterServlet;
import Singleton.Singleton;

/**
 *
 * @author andreas
 */
@Stateless
public class DBbean {

    public void checkForUsername(String username) {
        
        DBhandler dbhandler = new DBhandler();
        Connection connection = dbhandler.getCon();
        Singleton singleton = new Singleton();
        
        try {
            
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT username from mydb.Account where username = + '" + username + "'");
            
            while (rs.next()){
                singleton.getInstance().setCheckUser(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void getAccountID() {
        
        DBhandler dbhandler = new DBhandler();
        Connection connection = dbhandler.getCon();
        Singleton singleton = new Singleton();
        
        try {
            
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT count(idAccount) from mydb.Account");
            
            while (rs.next()){
                
                singleton.getInstance().setIdAccount(rs.getString(1));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createUser(int accID, String firstname, String lastname, String email, String ssn, String username, String password, String accountType) {
    
        DBhandler dbhandler = new DBhandler();
        Connection connection = dbhandler.getCon();
        
        try {
            
            Statement statement = connection.createStatement();
            
            statement.executeUpdate("INSERT INTO mydb.Account (idAccount, "
                    + "firstname, lastname, email, ssn, username, password, accountType) values"
                    + "('"+ accID +"', '"+ firstname +"', '" + lastname + "', '" + email + "', '" + ssn + "',"
                            + " '" + username + "', '" + password +"', '" + accountType +"')");   

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void checkPassForUser(String username) {
        
        DBhandler dbhandler = new DBhandler();
        Connection connection = dbhandler.getCon();
        Singleton singleton = new Singleton();
        
        try {
            
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT password from mydb.Account where username = + '" + username + "'");
            
            while (rs.next()){
                singleton.getInstance().setPassword(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void checkAccountType(String username) {
        
        DBhandler dbhandler = new DBhandler();
        Connection connection = dbhandler.getCon();
        Singleton singleton = new Singleton();
        
        try {
            
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT accountType from mydb.Account where username = + '" + username + "'");
            
            while (rs.next()){
                singleton.getInstance().setAccountType(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
