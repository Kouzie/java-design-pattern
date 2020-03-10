package memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;
    private List<String> fruits;
    private Random random;
    private static String[] fruitsName = {"사과", "포도", "바나나", "귤"};

    public Gamer(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
        this.random = new Random();
    }

    public int getMoney() {
        return money;
    }

    public String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "맛있는";
        }
        return prefix + fruitsName[random.nextInt(fruitsName.length)];
    }

    public void betting() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("소지금 증가!");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("소지금 반타작!");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("과일(" + f + ")을 받았습니다.");
        } else {
            System.out.println("변한 것이 없습니다.");
        }
    }

    public Memento createMemento() {
        Memento memento = new Memento(money);
        for (String fruit : fruits) {
            if (fruit.startsWith("맛있는")) {
                memento.addFruit(fruit);
            }
        }
        return memento;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                ", random=" + random +
                '}';
    }
}
