package com.emailWebApi.Model;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EmailRequest {

    private String recipient;
    private String subject;
    private String message;


    public EmailRequest(String recipient, String subject, String message) {
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;

    }



    public EmailRequest() {
    }


    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "EmailRequest{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}





