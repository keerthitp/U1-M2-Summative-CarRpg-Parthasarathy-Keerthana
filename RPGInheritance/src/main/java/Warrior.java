public class Warrior extends GameBase{ //Inheriting GameBase class

    private int shieldStrength=100;

    Warrior(){// Variables from the base class are getting intialized here
        setStrength(75);
        setHealth(100);
        setStamina(100);
        setSpeed(50);
        setAttackPower(10);
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public void decreaseShieldStrength(){ // Function specific to Warrior class is defined

    }
}
