

public class GameBase { // Base class

    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

    public void run(){

        System.out.println("Running");

    }
    public void attack(){
        System.out.println("Attacking");
    }
    public void heal(){
        System.out.println("Healing");
    }

    public void decreasHealth(){
        System.out.println("Decreasing Health");
    }
    public void increaseStamina(){
        System.out.println("Increasing Stamina");
    }
    public void decreaseStamina(){
        System.out.println("Decreasing Stamina");
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
