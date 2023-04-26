package org.example.Anotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Initialazer {

    String app() default "C:\\Windows\\explorer.exe";

    int port() default 10001;

}
