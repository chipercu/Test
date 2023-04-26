package org.example;

import org.example.Anotation.Delay;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FinderByAnnotation {


    private int findDelay = 200;
    private int driverDelay = 200;



//    public void find() throws ExecutionException, InterruptedException {
//
//        Class<Main> methods =  Main.class;
//        List<Class> classes = List.of(Main.class);
//        for (Class c: classes){
//            System.out.println(c.getName());
//        }
//        for (Method method: methods.getDeclaredMethods()){
//            Delay annotation = method.getAnnotation(Delay.class);
//            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
//
//            if (Arrays.stream(declaredAnnotations).toList().contains(annotation)){
//                findDelay = annotation.findDelay();
//                driverDelay = annotation.startDriver();
//            }
//        }
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//
//        Future<String> future = service.schedule(() -> "result" + findDelay + " driverDelay = " + driverDelay, findDelay, TimeUnit.MILLISECONDS);
//        System.out.println(future.get());
//        service.shutdown();
//    }


}
