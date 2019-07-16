public class Constable extends GameBase{//Inheriting GameBase class

    private int jurisdiction;

    Constable(){ // Variables from the base class are getting intialized here
        setStrength(60);
        setHealth(100);
        setStamina(60);
        setSpeed(20);
        setAttackPower(5);
    }

    public int getJurisdiction() {
        return this.jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void arrest(){// Function specific to Constable class is defined
        System.out.println("Arresting");
    }

}
