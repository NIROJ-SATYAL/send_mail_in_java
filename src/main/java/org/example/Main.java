package org.example;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.NewsAddress;
import java.util.Properties;



public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");

        String message="message";
        String subject="subject";
        String to="receiver mail";
        String from="sender mail";


       sendemail(message,subject,to,from);




    }


    public static void sendemail(String message,String subject,String to,String from ){


//        variable for gmail
        String host = "smtp.gmail.com";

//        load the properties


        Properties  properties=System.getProperties();
//        System.out.println("system properties" + properties);

//        setting important information to system

//        put host

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

//        step 1: To get the session object
        Session session= Session.getDefaultInstance(properties, new Authenticator() {
            @Override
//            it check the whether the email address exist or not
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("enter mail here (sender mail)", "enter password here");

            }
        });


                session.setDebug(true);

//        compose the message
        Message m= new MimeMessage(session);

        try {








            m.setFrom(new InternetAddress(from));
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(subject);
            m.setText(message);
//        step 3 send the message using Transport class;
            Transport.send(m);
            System.out.println("send successfully.....");
        } catch (MessagingException me)
        {
            me.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}