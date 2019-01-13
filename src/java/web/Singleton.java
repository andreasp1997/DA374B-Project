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
    private String userAcc = new String();
    
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
    
}
