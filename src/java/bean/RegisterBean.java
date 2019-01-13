/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.Session;

/**
 *
 * @author stefa
 */
@Stateless
public class RegisterBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void sendEmail(String fromEmail, String username, String password){
        Properties props = System.getProperties();
        props.put("mail.smtp.", "smtp.gmail.com");
                props.put("mail.auth.", "true");

                        props.put("mail.port.", "465");

                                props.put("mail.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

                                        props.put("mail.socketFactory.port", "465");

                                                props.put("mail.socketFactory.fallback", "false");
                                                
        Session mailSession = Session.getDefaultInstance(props,null);
        mailSession.setDebug(true);

    }
}
