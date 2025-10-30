
import java.util.ArrayList;
import java.util.List;

interface Observer {
    public void update();
}

class Email implements Observer {
    PaymentStatus observable;

    public Email(PaymentStatus observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Mail : Payment " + observable.getStatus());
    }
}

class Text implements Observer {
    PaymentStatus observable;

    public Text(PaymentStatus observable) {
        this.observable = observable;
    }


    @Override
    public void update() {
        System.out.println("Text : Payment " + observable.getStatus());
    }
}

interface ObservableSubject {  
    public boolean addObserver(Observer observer);
    public boolean removeObserver(Observer observer);
    public void notifyObserver();
}

class PaymentStatus implements ObservableSubject {
    List<Observer> observers;
    String status = "Pending";

    public PaymentStatus() {
        observers = new ArrayList<>();
    }

    @Override
    public boolean addObserver(Observer observer) {
        this.observers.add(observer);
        return true;
    }

    @Override
    public boolean removeObserver(Observer observer) {
        this.observers.remove(observer);
        return true;
    }

    @Override
    public void notifyObserver() {
        for(Observer o : observers){
            o.update();
        }
    }
    
    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
        notifyObserver();
    }
}



public class ObserverDesignPattern {
    public static void main(String[] args) {
        PaymentStatus payment = new PaymentStatus();
        Observer observer1 = new Email(payment);
        Observer observer2 = new Text(payment);
        payment.addObserver(observer1);
        
        System.out.println("----------------------------");
        // Update subject state
        payment.setStatus("Started");
        System.out.println("Started Processing Payment");
        payment.setStatus("Pending");
        System.out.println("Payment Done");
        payment.setStatus("Completed");
        
        // Adding new observer
        payment.addObserver(observer2);
        
        System.out.println("----------------------------");
        // Update subject state
        payment.setStatus("Started");
        System.out.println("Started Processing Payment");
        payment.setStatus("Pending");
        System.out.println("Payment Done");
        payment.setStatus("Completed");
        
        // Removing Observer
        payment.removeObserver(observer1);
        
        // Update subject state
        System.out.println("----------------------------");
        payment.setStatus("Started");
        System.out.println("Started Processing Payment");
        payment.setStatus("Pending");
        System.out.println("Payment Done");
        payment.setStatus("Completed");

    }
}
