import java.util.ArrayList;

public class Crossbowman extends Archers{

    public Crossbowman(String name, String role, int attack, int protection, int[] damage, int health, int speed, int shots) {
        super(name, role, attack, protection, damage, health, speed, shots);
    }

    public Crossbowman(String name){
        super(name, "Crossbowman",6,3,new int[] {2,3},10,4, 16);
    }

    @Override
    public void step() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
