
interface PaymentProcessor {
    void processPayment(Double amount, String currency);
    boolean isSuccessful();
    String getTransactionId();
}

// Normal payment methout class
class InhousePayment implements  PaymentProcessor {
    private String transactionId;
    private boolean isSuccessful;

    @Override
    public void processPayment(Double amount, String currency){
        System.out.println("Payment Done");
        this.transactionId = "TXN: " + System.currentTimeMillis();
        this.isSuccessful = true;
    }

    @Override
    public boolean isSuccessful(){
        return this.isSuccessful;
    }

    @Override
    public String getTransactionId(){
        return this.transactionId;
    }

}

// Legacy Class 
class LegacyPayment {
    private String transactionId;
    private boolean  isSuccessful;

    public void executePayment(Double amount, String currency){
        System.out.println("Payment Done");
        this.transactionId = "TXN: " + System.currentTimeMillis();
        this.isSuccessful = true;
    }

    public boolean checkPaymentStatus(){
        return isSuccessful;
    }

    public String getTransactionId(){
        return transactionId;
    }
}

// LegacyAdaptor 
class LegacyAdaptor implements PaymentProcessor {
    private final LegacyPayment processor;

    public LegacyAdaptor(LegacyPayment processor) {
        this.processor = processor;
    }

    @Override
    public void processPayment(Double amount, String currency){
        System.out.println("Payment Done by LegacyGateway");
        processor.executePayment(amount, currency);
    }
    
    @Override
    public boolean isSuccessful(){
        return processor.checkPaymentStatus();
    }

    @Override
    public String getTransactionId(){
        return processor.getTransactionId();
    }

}

// checkout class
class CheckoutPayment {
    private final PaymentProcessor processor;

    public CheckoutPayment(PaymentProcessor processor){
        this.processor = processor;
    }

    public void checkoutpayment(Double amount, String currency) throws Exception{
        try {
            processor.processPayment(amount, currency);
            if(processor.isSuccessful()){
                System.err.println("Payment Done: " + processor.getTransactionId());
            }
        } catch (Exception e) {
            throw new Exception("Payment Failed");
        }
    }
}


public class AdaptorDesignPattern {
    public static void main(String[] args){

        // New Method 

        PaymentProcessor processor1 = new InhousePayment();
        CheckoutPayment checkout1 = new CheckoutPayment(processor1);
        try{
            checkout1.checkoutpayment(10.0, "Inr");
        }catch(Exception e){
            System.out.println("Payment Failed");
        }

        // Payment using Legacy Payment Method
        LegacyPayment legacyPayment = new LegacyPayment();
        LegacyAdaptor processor2 = new LegacyAdaptor(legacyPayment);
        CheckoutPayment checkout2 = new CheckoutPayment(processor2);
        try{
            checkout2.checkoutpayment(10.0, "Inr");
        }catch(Exception e){
            System.out.println("Payment Failed");
        }
    }
}
