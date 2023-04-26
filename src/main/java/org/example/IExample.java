package org.example;

public interface IExample {

    double PI = 3.14;

    default String printPI(){
        return "PI = ";
    }

}
