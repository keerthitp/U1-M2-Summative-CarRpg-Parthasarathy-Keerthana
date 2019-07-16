public class Farmer extends GameBase { //Inheriting GameBase class

    Farmer(){   // Variables from the base class are getting intialized here
        setStrength(75);
        setHealth(100);
        setStamina(75);
        setSpeed(10);
        setAttackPower(1);
    }

    public void plow(){  // Function specific to Farmer class is defined
        System.out.println("Plowing");
    }

    public void harvest(){ // Function specific to Farmer class is defined
        System.out.println("Harvesting");
    }
}
