public class Sniper extends Archers {

    public Sniper(String name, String role, int attack, int protection, int[] damage, int health, int speed, int shots) {
        super(name, role, attack, protection, damage, health, speed, shots);
    }

    public Sniper(String name){
        super(name, "Sniper", 12,10, new int[] {8,10},15,9, 32);
    }

    @Override
    public void step() {

    }

    @Override
    public String toString() {
        return super.toString();
    }

}
