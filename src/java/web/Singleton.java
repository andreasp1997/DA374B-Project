/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

/**
 *
 * @author andreas
 */
public class Singleton {
    
    private static Singleton instance = null;
    
    //Account name used to show in converter screens
    private String userAcc;
    
    //Account registration
    private String idAccount;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String ssn;
    private String accountType;
    
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

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getSsn() {return ssn;}

    public void setSsn(String ssn) {this.ssn = ssn;}

    public String getAccountType() {return accountType;}

    public void setAccountType(String accountType) {this.accountType = accountType;}
    
}
