package p02_services;

public class OnlineStoreOrder {

    private NotificationService[] notificationServices;

    public OnlineStoreOrder(NotificationService... services) {
        this.notificationServices = services;
    }

    public void process() {
        for (NotificationService notificationService : notificationServices) {
            notificationService.sendNotification();
        }
    }
}
