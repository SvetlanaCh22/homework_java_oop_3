/*
Урок 3. Некоторые стандартные интерфейсы Java и примеры их использования

Проделать код ревью своих работ! Оптимизировать интерфейс так, чтобы в клиент коде было видно только публичные поля. Добавить поведение (метод step) для лучников.
1.Если стрел больше нуля заглушка выстрел и уменьшение количества стрел
2.Проверить есть ли крестьяне и свободны ли хоть один из них. Если да, то вернуть одну стрелу и сбросить флаг свободен у крестьянина.
3.Крестьяне должны уметь поднимать свой статус "свободен"
4.Сделать так, чтобы по нажатию Enter программа повторяла вывод на экран состояние персонажей и вызов метода step.

Автор: Чубченко Светлана
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class mainPro {

    private static ArrayList<Hero> getHeroes(boolean heroesType, int quantity) {
        final Random rand = new Random();
        ArrayList<Hero> heroes = new ArrayList<>();

        String[] namesList = {"Grigorii", "Lev", "Andrei", "Roman", "Arsenii", "Stepan", "Vladislav", "Nikita", "Gleb",
                "Mark", "David", "Iaroslav", "Evgenii", "Matvei", "Fyodor", "Nicolai", "Aleksei", "Andrei", "Artemii",
                "Victor", "Nikita", "Daniil", "Denis", "Egor", "Igor", "Lev", "Leonid", "Pavel", "Petr", "Roman",
                "Ruslan", "Sergey", "Semyon", "Timofei", "Stepan", "Vladimir", "Timofei", "Iaroslav", "Pavel", "Egor",
                "Sergey", "Vladislav", "Fedor", "Konstantin", "Maksim", "Artyom", "Nikita", "Iurii", "Platon", "Denis",
                "Iaroslav", "Miron", "Vasilii", "Lev", "Stepan", "Evgenii", "Savelii", "David", "Grigorii", "Timur",
                "Kirill", "Victor", "Fyodor", "Bogdan", "Konstantin", "Adam", "Leonid", "Roman", "Pavel", "Artemii",
                "Petr", "Aleksei", "Miron", "Vladimir"};
        int namesSize = namesList.length;

        for(int i=0; i<quantity; i++) {
            int type = rand.nextInt(4);
            if (heroesType) {
                switch (type) {
                    case 0 -> heroes.add(new Peasant(namesList[rand.nextInt(namesSize)]));
                    case 1 -> heroes.add(new Rogue(namesList[rand.nextInt(namesSize)]));
                    case 2 -> heroes.add(new Sniper(namesList[rand.nextInt(namesSize)]));
                    case 3 -> heroes.add(new Warlock(namesList[rand.nextInt(namesSize)]));
                }
            } else {
                switch (type) {
                    case 0 -> heroes.add(new Peasant(namesList[rand.nextInt(namesSize)]));
                    case 1 -> heroes.add(new Spearman(namesList[rand.nextInt(namesSize)]));
                    case 2 -> heroes.add(new Crossbowman(namesList[rand.nextInt(namesSize)]));
                    case 3 -> heroes.add(new Monk(namesList[rand.nextInt(namesSize)]));
                }
            }
        } return heroes;
    }

    static void callHealers(ArrayList<Hero> heroList) {
        for (Hero hero : heroList) {
            String role = hero.getRole();
            if (role.equals("Warlock") || role.equals("Monk")) {
                //System.out.println(hero.getName() + " heals: ");
                hero.step(heroList); // лечим
            }
        }
    }

    static void callArcher(ArrayList<Hero> heroList) {
        for (Hero hero : heroList) {
            String role = hero.getRole();
            if (role.equals("Crossbowman") || role.equals("Sniper")) {
                hero.step(heroList); // стреляем
            }
        }
    }

    static void callResetPeasants(ArrayList<Hero> heroList) {
        for (Hero hero : heroList) {
            String role = hero.getRole();
            if (role.equals("Peasant")) {
                Peasant peasant = (Peasant)hero;
                peasant.setDelivery(1); // сбросим доступность
            }
        }
    }

    public static void main(String[] args) {

        // заполним 50 рандомных героев
        ArrayList<Hero> heroes1 = getHeroes(true, 10);
        ArrayList<Hero> heroes2 = getHeroes(false, 10);

        // цикл из 10 шагов
        int i = 0;
        while (i<10) {
            // выводим созданные два набора из героев
            System.out.println("Heroes 1:");
            heroes1.forEach(n -> System.out.println(n.toString()));
            System.out.println();
            System.out.println("Heroes 2:");
            heroes2.forEach(n -> System.out.println(n.toString()));
            System.out.println();

            // делаем шаг, где из каждого списка Monk'и и Warlock'и лечат героев с самым низким уровнем здоровья
            callHealers(heroes1);
            callHealers(heroes2);

            // делаем шаг каждого лучника
            callArcher(heroes1);
            callArcher(heroes2);

            // сброс статуса доступности у крестьян
            callResetPeasants(heroes1);
            callResetPeasants(heroes2);

            // ждем ввода пользователя для следующего шага
            Scanner in = new Scanner(System.in);
            in.nextLine();

            i++;
        }

    }

}

