package org.example.ObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SubjectImpl implements Subject {

    private final List<Observer> observerList;

    private AtomicInteger data;
    ScheduledExecutorService service;
    ScheduledFuture<?> scheduledFuture;

    public SubjectImpl() {
        this.observerList = new ArrayList<>();
    }

    public void refreshData(){
        this.data = new AtomicInteger(ThreadLocalRandom.current().nextInt(100, 200));
        System.out.println("DATA:" + data);
        notifyObservers();
    }



    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    public void init(){
        scheduledFuture = Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(this::refreshData, 500, 1000, TimeUnit.MILLISECONDS);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: this.observerList){
            observer.update(data, this);
        }
    }

    @Override
    public List<Observer> getSubscribers(){
        return observerList;
    }
}
