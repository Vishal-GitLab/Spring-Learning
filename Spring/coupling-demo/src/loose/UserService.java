package loose;


public class UserService {   // hamko notification bhejna hai user service se
        public     NotificationService notificationService;   // ham ak instance bnayenge   .. object reference bna rhe h


    public UserService() {

    }
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String message) {
               notificationService.send("Notification hello");
           }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


}








