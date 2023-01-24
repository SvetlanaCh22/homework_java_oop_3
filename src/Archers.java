import java.util.ArrayList;

public abstract class Archers extends Hero implements InterStepArchers {

    int shots;

    public Archers(String name, String role, int attack, int protection, int[] damage, int health, int speed, int shots) {
        super(name, role, attack, protection, damage, health, speed);
        this.shots = shots;
    }

    @Override
    public void step(ArrayList<Hero> heroList) {
        if (shots>0) shots = shots-1; // выстрел
        // проверяем крестьян
        for (Hero hero : heroList) {
            String role = hero.getRole();
            if (role.equals("Peasant")) {
                // если это крестьянин - попробуем взять стрелу
                Peasant peasant = (Peasant)hero;
                if (peasant.getDelivery() == 1) {
                    peasant.setDelivery(0); // установим у крестьянина флаг свободности 0.
                    shots++; // увеличим число стрел
                    // других крестьян не трогаем - выходим
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Shots: " + shots;
    }
}
