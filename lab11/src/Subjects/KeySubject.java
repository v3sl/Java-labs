package Subjects;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.w3c.dom.ls.LSSerializerFilter;

import Observers.Observer;

public class KeySubject implements Subject {
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(KeyEvent event) {
        for (Observer o : observers) {
            o.update(event);
        }
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    private ArrayList<Observer> observers = new ArrayList<>();
}