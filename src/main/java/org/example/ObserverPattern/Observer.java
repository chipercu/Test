package org.example.ObserverPattern;

import java.util.concurrent.atomic.AtomicInteger;

public interface Observer{

    void update(AtomicInteger data, Subject subject);

    void subscribe(Subject subject);

    void dismiss(Subject subject);

}
