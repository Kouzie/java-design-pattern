package observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class NumberGenerator {
    private List<Observer> observers;

    public NumberGenerator() {
        observers = new ArrayList();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserves() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
    public abstract int getNumber();
    public abstract void execute();
}
