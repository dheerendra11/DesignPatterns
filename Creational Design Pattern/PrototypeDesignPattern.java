// Prototype Design Pattern
interface Prototype {
    public Prototype clone();
}

class Enemy implements Prototype{
    private String type;
    private int health;
    private int speed;
    private String weapon;
    private String armor;

    public Enemy(String type, int health, int speed, String weapon, String armor){
        this.type = type;
        this.health = health;
        this.speed = speed;
        this.weapon = weapon;
        this.armor = armor;
    }

    @Override
    public Enemy clone(){
        return new Enemy(type, health, speed, weapon, armor);
    }

    public void setType(String type){
        this.type = type;
    }

    public void changeWeapon(String weapon){
        this.weapon = weapon;
    }

    public void printStats() {
        System.out.println(type + " [Health: " + health +
                           ", Speed: " + speed +
                           ", Armored: " + armor +
                           ", Weapon: " + weapon + "]");
    }
}

class Main{
    public static void main(String[] args){
        Enemy e1 = new Enemy("Level1", 100, 100, "Knife", "Steel");
        Enemy e2 = e1.clone();
        Enemy e3 = e1.clone();

        e2.setType("Level2");
        e2.changeWeapon("Gun");
        e1.printStats();
        e2.printStats();
        e3.printStats();
    }
}
