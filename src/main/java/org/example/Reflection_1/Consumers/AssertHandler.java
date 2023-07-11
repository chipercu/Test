package org.example.Reflection_1.Consumers;

import org.openqa.selenium.WebElement;

import java.util.Optional;
import java.util.function.Consumer;

public class AssertHandler {

    private final HandlerType type;
    private final Optional<String> element;

    private final Consumer<Optional<String>> consumer;

    public AssertHandler(HandlerType type, Consumer<Optional<String>> consumer, Optional<String> element) {
        this.type = type;
        this.consumer = consumer;
        this.element = element;
    }

    public HandlerType getType() {
        return type;
    }

    public void handle(){
        consumer.accept(element);
    }

    public Consumer<Optional<String>> getConsumer() {
        return consumer;
    }
}
