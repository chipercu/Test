package org.example.Reflection_1.Pages.pagesFirstModule;

import org.example.Reflection_1.Anotation.AssertIfPresent;
import org.example.Reflection_1.Anotation.Init;
import org.example.Reflection_1.Anotation.PageFactory;
import org.example.Reflection_1.Consumers.AssertHandler;
import org.example.Reflection_1.Consumers.HandlerType;
import org.example.Reflection_1.Pages.BasePage;
import org.example.Reflection_1.Pages.pagesSecondModule.MainPageSecondModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Optional;
import java.util.function.Consumer;

@PageFactory
public class MainPageFirstModule extends BasePage<MainPageFirstModule> {

    @Init
    private SomePageFirstModule somePageFirstModule;

    @Init
    private MainPageSecondModule mainPageSecondModule;

    By xpath1 = By.xpath("asdfasdfasdf");
    By xpath2 = By.xpath("asdfasdfasdf");
    By xpath3 = By.xpath("asdfasdfasdf");

    private final Optional<String> alert = Optional.of("ASDASD");

    public MainPageFirstModule() {
        this.pageName = "MainPageFirstModule";
    }

    @AssertIfPresent()
    public SomePageFirstModule getSomePage(AssertHandler... assertHandler){
        beforeHandle(assertHandler);

        System.out.println("movig to " + somePageFirstModule.getPageName());

        afterHandle(assertHandler);
        return somePageFirstModule;
    }





    public MainPageSecondModule getMainPageSecondModule(){
        System.out.println("movig to " + mainPageSecondModule.getPageName());
        return mainPageSecondModule;
    }


}
