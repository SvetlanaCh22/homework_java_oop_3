import java.util.ArrayList;

public abstract class Healers extends Hero implements InterStepHealers {
    int mana;

    public Healers(String name, String role, int attack, int protection, int[] damage, int health, int speed, int mana) {
        super(name, role, attack, protection, damage, health, speed);
        this.mana = mana;
    }

    @Override
    public void step(ArrayList<Hero> heroList) {
        ArrayList<Double> reduceHealth = new ArrayList<>();
        double minHealth = 100;
        int minHealthHero = 0;
        for (int i = 0; i < heroList.size(); i++) {
            int heroHealth = heroList.get(i).getHealth();
            int heroMaxHealth = heroList.get(i).getMaxHealth();
            if (heroHealth < heroMaxHealth){
                double temp = ((double)heroHealth / (double)heroMaxHealth) * 100;
                if (temp < minHealth) {
                    minHealth = temp;
                    minHealthHero = i;
                }
            }
        }
        // лечим героя с минимумом здоровья
        heroList.get(minHealthHero).setHealth(heroList.get(minHealthHero).getHealth()+1);
        //String minHealthStr = String.format("%.1f", minHealth);
        //System.out.println(heroList.get(minHealthHero).getName() + "(" + minHealthStr + "% of health)");
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: " + mana;
    }

}

