package org.example.ObserverPattern;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ObserverImpl implements Observer {

    private String name;
    private final int dismissCondition;

    public ObserverImpl(String name, int dismissCondition) {
        this.name = name;
        this.dismissCondition = dismissCondition;
    }

    @Override
    public void update(AtomicInteger data, Subject subject) {
        if (data.get() > dismissCondition){
            dismiss(subject);
            System.out.println(this.name + " is dismiss");
        }else {
            System.out.println(this.name + ": " +  data);
        }
    }

    @Override
    public void subscribe(Subject subject) {
        subject.addObserver(this);
        System.out.println(subject.getSubscribers().size());
    }

    @Override
    public void dismiss(Subject subject) {

    }

//    @Override
//    public void dismiss(Subject subject) {
//
//        subject.getSubscribers().stream().filter(s -> s.equals(this)).findFirst().ifPresent(subject::removeObserver);
////        subject.removeObserver(this);
//    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObserverImpl observer = (ObserverImpl) o;
        return dismissCondition == observer.dismissCondition && Objects.equals(name, observer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dismissCondition);
    }
}
