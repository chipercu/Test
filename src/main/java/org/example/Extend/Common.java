package org.example.Extend;

public class Common <T extends Common<T>>{

    protected String text;

    public T print(){
        System.out.println(text);
        return (T) this;
    }


}
