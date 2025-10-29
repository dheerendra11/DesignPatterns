interface PaymentMethod {
    public boolean pay() throws Exception;
}

class UPI implements PaymentMethod {
    @Override
    public boolean pay() throws Exception {
        try {
            System.out.println("Payment Done using UPI");
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    } 
}

class Card implements PaymentMethod {
    @Override
    public boolean pay() throws Exception {
        try {
            System.out.println("Payment Done using Card");
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    } 
}

class Cash implements PaymentMethod {
    @Override
    public boolean pay() throws Exception {
        try {
            System.out.println("Payment Done using Cash");
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    } 
}

class PaymentGateWay {
    PaymentMethod paymentMethod = new Cash(); // default method

    public PaymentGateWay(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(){
        try{
            paymentMethod.pay();
        }catch (Exception e){
            System.out.println("Payment Failed");
        }
    }

}

public class StrategyDesignPattern {
    public static void main(String[] args) {
        PaymentGateWay payment1 = new PaymentGateWay(new Card());
        payment1.processPayment();

        PaymentGateWay payment2 = new PaymentGateWay(new Cash());
        payment2.processPayment();

        PaymentGateWay payment3 = new PaymentGateWay(new UPI());
        payment3.processPayment();

        payment3.setPaymentMethod(new Cash());
        payment3.processPayment();
    }    
}
