package org.example.Reflection_1.Pages.pagesFirstModule;

import org.example.Reflection_1.Anotation.Init;
import org.example.Reflection_1.Anotation.PageFactory;
import org.example.Reflection_1.Pages.BasePage;

@PageFactory
public class SomePageFirstModule extends BasePage<SomePageFirstModule> {

    @Init
    private MainPageFirstModule mainPageFirstModule;

    public SomePageFirstModule() {
        this.pageName = "SomePageFirstModule";
    }

    public MainPageFirstModule getMainPageFirstModule(){
        System.out.println("movig to " + mainPageFirstModule.getPageName());
        return mainPageFirstModule;
    }
}
