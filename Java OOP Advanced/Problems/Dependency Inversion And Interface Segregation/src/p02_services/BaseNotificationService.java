package p02_services;

public abstract class BaseNotificationService implements NotificationService {
    private boolean isActive;

    protected BaseNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public void sendNotification() {
        System.out.println(this.getClass().getSimpleName() + " sends you a notification");
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }
}
