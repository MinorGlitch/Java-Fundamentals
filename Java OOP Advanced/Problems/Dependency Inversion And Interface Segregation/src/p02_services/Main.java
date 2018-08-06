package p02_services;

public class Main {
    public static void main(String[] args) {
        NotificationService service1 = new EmailNotificationService(true);
        NotificationService service2 = new SmsNotificationService(true);

        OnlineStoreOrder onlineStoreOrder = new OnlineStoreOrder(service1, service2);

        onlineStoreOrder.process();
    }
}
