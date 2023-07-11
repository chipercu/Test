package org.example.Reflection_1.Pages.pagesSecondModule;

import org.example.Reflection_1.Anotation.Init;
import org.example.Reflection_1.Anotation.PageFactory;
import org.example.Reflection_1.Pages.BasePage;
import org.example.Reflection_1.Pages.pagesFirstModule.MainPageFirstModule;

@PageFactory
public class MainPageSecondModule extends BasePage<MainPageSecondModule> {

    @Init
    private SomePageSecondModule somePageSecondModule;

    @Init
    private MainPageFirstModule mainPageFirstModule;


    public MainPageSecondModule() {
        this.pageName = "MainPageSecondModule";
    }


    public SomePageSecondModule getSomePage(){
        System.out.println("movig to " + somePageSecondModule.getPageName());
        return somePageSecondModule;
    }

    public MainPageFirstModule getMainPageFirstModule(){
        System.out.println("movig to " + mainPageFirstModule.getPageName());
        return mainPageFirstModule;
    }

}
