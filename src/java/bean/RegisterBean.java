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
            mailMessage.setContent("You have successfully registered welcome to All in one Converter","text/html");
            mailMessage.setSubject("All in one converter");
            
            
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com",username,password);
            
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            
            
            
        } catch (MessagingException ex) {
            Logger.getLogger(RegisterBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
