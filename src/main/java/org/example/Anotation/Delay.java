package org.example.Anotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Delay {

    int findDelay() default 500;

    int startDriver() default 1000;

}
