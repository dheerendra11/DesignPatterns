
interface Coffee {
    public String getDiscription();
    public int getCost();
}

// Extension of Base class 
class Espresso implements Coffee{
    @Override
    public String getDiscription(){
        return "Espresso";
    }

    @Override 
    public int getCost(){
        // cost of expresso
        return 220;
    }
}

class Latte implements Coffee {
    @Override
    public String getDiscription(){
        return "Latte";
    }

    @Override 
    public int getCost(){
        // cost of Latte
        return 300;
    }
}

// Abstract Decorator 
abstract class Decorator implements Coffee {
    @Override
    public String getDiscription() {
        return "";
    }
}

// Extension of Decorator class
class Milk extends  Decorator {
    Coffee coffee;

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDiscription() {
        return coffee.getDiscription() + " with Milk";
    } 

    @Override
    public int getCost() {
        return coffee.getCost() + 30;
    }
}

class WhippedCream extends  Decorator {
    Coffee coffee;

    public WhippedCream(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDiscription() {
        return coffee.getDiscription() + " with WhippedCream";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 50;
    }
}

public class DecoratorDesignPattern {
    public static void main(String[] args){
        Coffee espresso = new Espresso();
        System.out.println(espresso.getDiscription() + " " + espresso.getCost());

        
        Coffee latte = new Latte();
        Coffee latteWithMilk = new Milk(latte);
        System.out.println(latteWithMilk.getDiscription() + " " + latteWithMilk.getCost());
        
        Coffee lattewithDoubleMilk = new Milk(latteWithMilk);
        System.out.println(lattewithDoubleMilk.getDiscription() + " " + lattewithDoubleMilk.getCost());
        
        Coffee lattewithDoubleMilkandWhippedCream = new WhippedCream(lattewithDoubleMilk);
        System.out.println(lattewithDoubleMilkandWhippedCream.getDiscription() + " " + lattewithDoubleMilkandWhippedCream.getCost());
    }
}
