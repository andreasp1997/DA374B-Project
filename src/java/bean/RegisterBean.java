/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import Singleton.Singleton;

/**
 *
 * @author stefa
 */
@Stateless
public class RegisterBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void sendEmail(String fromEmail, String username, String password, String toEmail){
        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            
            //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
            //props.put("mail.smtp.socketFactory.port", "587");
            
            props.put("mail.smtp.socketFactory.fallback", "true");
            
            props.put("mail.smtp.starttls.enable", "true");
            
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.ssl.enable", "true");
            
            Session mailSession = Session.getDefaultInstance(props,null);
            mailSession.setDebug(true);
            
            Message mailMessage = new MimeMessage(mailSession);
            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            
            
            //Message info
            Singleton singleton = new Singleton();
            mailMessage.setContent("Hi " + singleton.getInstance().getFirstname() + " " +
                    singleton.getInstance().getLastname() + "\n" +
                    ".You have successfully registered. Welcome to All in one Converter." + "\n" + 
                            "You have created a " 
                    + singleton.getInstance().getAccountType() + " account type. "
                            + "Standard = Free, Premium = $9.99, Plus = $19.99","text/html");
            mailMessage.setSubject("All-In-One Converter");
            
            
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com",username,password);
            
            // send mail
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            
            
            
        } catch (MessagingException ex) {
            Logger.getLogger(RegisterBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
