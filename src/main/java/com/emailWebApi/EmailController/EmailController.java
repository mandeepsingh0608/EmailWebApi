package com.emailWebApi.EmailController;

import com.emailWebApi.Model.EmailRequest;
import com.emailWebApi.services.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping
public class EmailController {

    @Autowired
    private EmailServices emailServices;


@PostMapping("/sendemail")
public ResponseEntity<?> EmailContectRecevier(@RequestBody EmailRequest emailRequest){


    try {
        emailServices.sendEmail(emailRequest);
    }catch (Exception e){
        e.printStackTrace();
        String errormessage="problem occur while sending email";
        return ResponseEntity.status(HttpStatus.valueOf(errormessage)).build();
    }



    return ResponseEntity.status(HttpStatus.OK).body("email has been sent");
}



}
