package com.example.loose;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary         // agar multiple implements milte to ye wala default hai primary h
public class SMSNotificationService implements NotificationService{
    @Override
    public void send(String  message) {   // ham send() ko change nhi kara skte h
        System.out.println("SMS: " + message);
    }
}
