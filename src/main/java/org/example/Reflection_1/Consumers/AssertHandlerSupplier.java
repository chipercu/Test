package org.example.Reflection_1.Consumers;

import org.testng.Assert;

import java.util.Optional;

public class AssertHandlerSupplier {

    public static AssertHandler ifPresent(HandlerType type, Optional<String> element){
        return new AssertHandler(type, x -> x.ifPresent(e -> Assert.fail(String.format("Элемент %s присутствует", element.get()))), element);
    }
//    public static AssertHandler ifNotPresent(HandlerType type, Optional<String> element){
//        return new AssertHandler(type, x -> x.ifPresentOrElse(e -> {}, () -> Assert.fail("Элемент не присуствует")), element);
//    }
//    public static AssertHandler ifNotPresent(){
//        return new AssertHandler(HandlerType.AFTER, x -> x.)
//    }


}
