package org.example.Listener;

import java.util.ArrayList;
import java.util.List;

public class Commander implements Observed{

    List<Observer> unitList  = new ArrayList<>();


    public Commander(int unitsCount) {
        spawnUnits(unitsCount);
    }

    public void spawnUnits(int count){
        for (int i = 1; i <= count; i++) {
            Unit unit = new Unit("Bot" + i);
            unit.setFormationPosition(i);
            addUnit(unit);
        }
    }


    @Override
    public void addUnit(Observer observer) {
        this.unitList.add(observer);
    }

    @Override
    public void removeUnit(Observer observer) {
        this.unitList.remove(observer);
    }

    @Override
    public void notifyMove(FormationType formationType) {
        unitList.forEach(u -> u.move(formationType));
    }


}
