package edu.matc.entity;


import edu.matc.util.Utilities;
import org.apache.log4j.Logger;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Created by bvue0 on 12/6/2016.
 */
public class SendEmail {

    private Properties properties;
    private Session getMailSession;
    private MimeMessage generateMailMessage;
    private final Logger logger = Logger.getLogger(SendEmail.class);



    public void run() throws MessagingException {
        setup();
        getMailSession();
        getSessionAndSendMail();
        logger.info("***Mail Sent successfully. Verify email!***");
    }

    public void setup() throws MessagingException {

        logger.info("***Setting up the mail server properties***");

        properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        //need this to convert socket to TLS
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        logger.info("***Mail Server Properties have been setup successfully***");
    }

    public void getMailSession() throws MessagingException {

        logger.info("***get mail session***");

        getMailSession = Session.getDefaultInstance(properties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("bvue4550@gmail.com"));
        //generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@servermonitor.com"));
        generateMailMessage.setSubject("Message From Server Monitor");
        String emailBody = "Your server is down." + "<br><br> Sincerely, <br>CEO Vue";
        generateMailMessage.setContent(emailBody, "text/html");

        logger.info("***Mail Session has been created successfully***");

    }


    public void getSessionAndSendMail() throws MessagingException {

        logger.info("***Get Session and Send mail***");
        Transport transport = getMailSession.getTransport("smtp");

        //This is the sending email
        transport.connect("smtp.gmail.com", "bvue4550@gmail.com", "java2016");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

}
