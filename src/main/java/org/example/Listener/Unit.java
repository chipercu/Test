package org.example.Listener;

public class Unit implements Observer{

    private final String name;
    private int formationPosition;


    public Unit(String name) {
        this.name = name;
    }


    public int getFormationPosition() {
        return formationPosition;
    }

    public void setFormationPosition(int formationPosition) {
        this.formationPosition = formationPosition;
    }

    @Override
    public void move(FormationType formationType) {
        System.out.println(name + " moved - " + formationType);
    }
}
