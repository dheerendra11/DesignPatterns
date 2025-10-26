// // Factory class
interface Notification {
    public void send(String message);
}

class EmailNotification implements Notification {
    // @override
    public void send(String message){
        System.out.println("Email Notification." + message);
    }
}

class SMSNotification implements Notification {
    // @override
    public void send(String message){
        System.out.println("SMS Notification." + message);
    }
}

abstract class NotificationCreator {
    public abstract Notification createNotification();

    public void send(String message){
        Notification notification = createNotification();
        notification.send(message);
    }
}

class EmailNotificationCreator extends NotificationCreator {
    // @override
    public Notification createNotification(){
        return new EmailNotification();
    }
}

class SMSNotificationCreator extends NotificationCreator {
    // @override
    public Notification createNotification(){
        return new SMSNotification();
    }
}


class Main{
    public static void main(String[] args){
        NotificationCreator notification;

        notification = new EmailNotificationCreator();
        notification.send(" Email");

        notification = new SMSNotificationCreator();
        notification.send(" SMS");
    }
}