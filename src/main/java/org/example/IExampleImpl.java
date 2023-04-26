package org.example;

public class IExampleImpl implements IExample{

    public IExampleImpl() {

    }

    public static void main(String[] args) {

        IExampleImpl iExample = new IExampleImpl();
        System.out.println(iExample.printPI());
    }

    @Override
    public String printPI() {
        return "Const_PI = " + PI;
    }


}
