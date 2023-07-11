package org.example.Reflection_1.Consumers;

import org.openqa.selenium.WebElement;

import java.util.Optional;
import java.util.function.Consumer;

public class MainPage {



    public static Consumer<Optional<WebElement>> ifAlertPresent(){
       return new Consumer<Optional<WebElement>>(){
            @Override
            public void accept(Optional<WebElement> webElement) {

            }
        };


//            return x -> {
//                if (x.isPresent()){
//                    System.out.println("Assert Alert");
//                }
//            };
    }



}
