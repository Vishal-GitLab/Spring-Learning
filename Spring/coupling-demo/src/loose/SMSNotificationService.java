package loose;

public class SMSNotificationService implements NotificationService{
    @Override
    public void send(String  message) {   // ham send() ko change nhi kara skte h
        System.out.println("SMS: " + message);
    }
}
