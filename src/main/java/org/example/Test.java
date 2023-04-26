package org.example;

import org.example.Anotation.Initialazer;

public class Test {

    @Initialazer(port = 123132)
    public void firstMethod(int port){
        System.out.println("куку - " + port);
    }


    public void secondMethod(){
        System.out.println("некуку");
    }



}
