package org.example;

import java.util.List;
import java.util.concurrent.Callable;

public class WaitElement implements Callable<String> {

    private List<String> stringList;

    public WaitElement(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public String call() throws Exception {


        return null;
    }




}
