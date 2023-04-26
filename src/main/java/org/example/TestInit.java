package org.example;

import org.example.Anotation.Initialazer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestInit {

    public static void main(String[] args) {

        Class<Test> methods =  Test.class;

        for (Method method: methods.getDeclaredMethods()){
            Initialazer annotation = method.getAnnotation(Initialazer.class);

            Initialazer initialazer = (Initialazer) annotation;
            if (initialazer != null){

                try {
                    method.invoke(methods.getDeclaredConstructor().newInstance(), initialazer.port());
                } catch (Throwable tr) {
                    System.out.println(tr.getCause());
                }
            }


        }



    }


}
