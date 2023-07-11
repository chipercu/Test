package org.example.Reflection_1.Pages.pagesSecondModule;

import org.example.Reflection_1.Anotation.Init;
import org.example.Reflection_1.Anotation.PageFactory;
import org.example.Reflection_1.Pages.BasePage;

@PageFactory
public class SomePageSecondModule extends BasePage<SomePageSecondModule> {

    @Init
    private MainPageSecondModule mainPageSecondModule;

    public SomePageSecondModule() {
        this.pageName = "SomePageSecondModule";
    }

    public MainPageSecondModule getMainPageSecondModule(){
        System.out.println("movig to " + mainPageSecondModule.getPageName());
        return mainPageSecondModule;
    }

}
