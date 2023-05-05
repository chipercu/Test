package org.example.Listener;

public interface Observed {

    void addUnit(Observer observer);
    void removeUnit(Observer observer);

    void notifyMove(FormationType formationType);

}
