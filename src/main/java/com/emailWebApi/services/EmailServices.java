package com.emailWebApi.services;

import com.emailWebApi.Model.EmailRequest;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Service
public class EmailServices {


public  void sendEmail(EmailRequest emailRequest){



    String from="tec3brothers@gmail.com";

   //get the system properties
    Properties properties=System.getProperties();
    System.out.println("properties===> "+properties);

    //setting information to properties object
  //setting a host

    properties.put("mail.smtp.host","smtp.gmail.com");
    properties.put("mail.smtp.port","465");
    properties.put("mail.smtp.ssl.enable","true");
    properties.put("mail.smtp.auth","true");


    //To get session Object
    Session session=Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("tec3brothers@gmail.com","**********");
        }
    });

    session.setDebug(true);

    //Composing a message
    MimeMessage actualMessage=new MimeMessage(session);


    try {
        //from email address to email(sender)
        actualMessage.setFrom(from);
        //adding recipient to email(reciever)
        actualMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(emailRequest.getRecipient())));

        //adding subject to email
        actualMessage.setSubject(emailRequest.getSubject());


        //getting file path
        String path="D:\\java projects\\emailwebapi\\profilePhoto.jpg";

        //setting file path
        File file=new File(path);

        MimeMultipart multipart=new MimeMultipart();


        MimeBodyPart textPart=new MimeBodyPart();

        MimeBodyPart filepart=new MimeBodyPart();

        textPart.setText(emailRequest.getMessage());

        filepart.attachFile(file);


        multipart.addBodyPart(textPart);
        multipart.addBodyPart(filepart);





//setting message content
       actualMessage.setContent(multipart);




        //sending an email
        Transport.send(actualMessage);


    } catch (MessagingException | IOException e) {
        e.printStackTrace();
    }






}


}
