package memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    int money;
    List<String> fruits;

    public Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList();
    }

    public int getMoney() {
        return money;
    }

    public List getFruits() {
        return fruits;
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }
}
