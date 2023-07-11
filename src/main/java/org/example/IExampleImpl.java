package org.example;

import org.example.Extend.Extender;
import org.example.Extend.Extender23;
import org.example.Reflection_1.Consumers.AssertHandlerSupplier;
import org.example.Reflection_1.Consumers.HandlerType;
import org.example.Reflection_1.Consumers.MainPage;
import org.example.Reflection_1.Pages.BasePage;
import org.example.Reflection_1.Pages.pagesFirstModule.MainPageFirstModule;
import org.example.Reflection_1.Pages.pagesSecondModule.MainPageSecondModule;
import org.example.Reflection_1.factory.PageFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

import static org.example.Reflection_1.Consumers.AssertHandlerSupplier.*;
import static org.example.Reflection_1.Consumers.HandlerType.*;
import static org.example.Reflection_1.Consumers.MainPage.*;

public class IExampleImpl implements IExample{

    public IExampleImpl() {

    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        PageFactory pageFactory = new PageFactory();
        PageFactory.getPage(MainPageFirstModule.class)
                .getSomePage(ifPresent(BEFORE, Optional.empty()),
                        ifPresent(BEFORE, Optional.empty()),
                        ifPresent(AFTER, Optional.of("sadasdfasf")))
                .getMainPageFirstModule();

    }

    @Override
    public String printPI() {
        return "Const_PI = " + PI;
    }


}
