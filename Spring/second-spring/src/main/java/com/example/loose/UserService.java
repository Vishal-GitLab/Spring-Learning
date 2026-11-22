package com.example.loose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("UserServiceSMS")
public class  UserService {   // hamko notification bhejna hai user service se
        public     NotificationService notificationService;   // ham ak instance bnayenge   .. object reference bna rhe h


    public UserService() {

   }
//    @Autowired
//    public UserService(@Qualifier("emailNotificationService") NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }


    @Autowired
    public UserService(  NotificationService notificationService) {
            this.notificationService = notificationService;
        }

    public void notifyUser(String message) {
               notificationService.send("Notification hello");
           }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


}








