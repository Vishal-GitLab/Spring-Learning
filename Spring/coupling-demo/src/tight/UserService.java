package tight;

public class UserService {   // hamko notification bhejna hai user service se
    NotificationService notificationService = new NotificationService();
           public void notifyUser(String message) {
               notificationService.send("Notification hello");
           }
}
