package org.example.Reflection_1.Pages;

import org.example.Reflection_1.Consumers.AssertHandler;
import org.example.Reflection_1.Consumers.HandlerType;

public class BasePage<T extends BasePage<T>>{

    protected String pageName;


    public T printPageName() {
        System.out.println(pageName);
        return (T) this;
    }
    public void beforeHandle(AssertHandler... assertHandler){
        if (assertHandler != null){
            for (AssertHandler handler : assertHandler){
                if (handler.getType() == HandlerType.BEFORE){
                    handler.handle();
                }
            }
        }
    }
    public void afterHandle(AssertHandler... assertHandler){
        if (assertHandler != null){
            for (AssertHandler handler : assertHandler){
                if (handler.getType() == HandlerType.AFTER){
                    handler.handle();
                }
            }
        }
    }
    public String getPageName() {
        return pageName;
    }
}
