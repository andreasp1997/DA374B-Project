/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

/**
 *
 * @author andreas
 */
public class Singleton {
    
    private static Singleton instance = null;
    
    // user acc printed in conversion menu
    private String userAcc;
    // used for setting correct account id when registering
    private String idAccount;
    // firstname for Java mail message
    private String firstname;
    // lastname for Java Mail message
    private String lastname;
    // used for checking username
    private String username;
    // used for checking password
    private String password;
    // used for getting account type
    private String accountType;
    // used for checking user
    private String checkUser;
    
    public Singleton() {

    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    public void setUserAcc (String s) { this.userAcc = s; }

    public String getUserAcc() { return userAcc; }
    
    public String getIdAccount() {return idAccount;}

    public void setIdAccount(String idAccount) {this.idAccount = idAccount;}

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}
    
    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getAccountType() {return accountType;}

    public void setAccountType(String accountType) {this.accountType = accountType;}

    public String getCheckUser() { return checkUser; }

    public void setCheckUser(String checkUser) { this.checkUser = checkUser; }
    
    
    
}
