import loose.EmailNotificationService;
import loose.NotificationService;
import loose.SMSNotificationService;
import tight.UserService;

public class AppMain {
    public static void main(String[] args) {
        // Tight
        UserService userService =  new UserService();
        userService.notifyUser("Order Placed!");

        // Loose
        NotificationService emailService  = new EmailNotificationService();
        NotificationService smsService = new SMSNotificationService();
        loose.UserService userServiceLoose  =  new loose.UserService(smsService);
        userServiceLoose.notifyUser("Order Processed!");

        /*
        Constructor Injection - dependency is provided via constructor
        Setter Inejction - dependency is provided via setter method    -- setter ko call krke ham injection provide kare
        Field Inejction - dependency  is assigned directly to a field--  field ki help se ham dependency ineject kare
         */

        loose.UserService userServiceLooseSetter  =  new loose.UserService(smsService);
        userServiceLooseSetter.setNotificationService(emailService);  //  this is setter injection
         userServiceLooseSetter.notificationService =  smsService;

    }
}














