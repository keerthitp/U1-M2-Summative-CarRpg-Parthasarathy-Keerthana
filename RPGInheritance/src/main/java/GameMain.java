public class GameMain {
    public static void main(String[] args) {

        Farmer farmer = new Farmer();
        Constable constable = new Constable();
        Warrior warrior = new Warrior();

        farmer.setAttackPower(2);
        farmer.setSpeed(20);
        farmer.setStamina(75);
        farmer.harvest();
        farmer.plow();
        farmer.heal();

        constable.decreaseStamina();
        constable.setJurisdiction(2);
        constable.arrest();

        warrior.run();
        warrior.setSpeed(55);
        warrior.decreaseShieldStrength();
        warrior.attack();
        warrior.decreasHealth();
    }
}
