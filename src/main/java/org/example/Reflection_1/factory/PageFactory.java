package org.example.Reflection_1.factory;

import org.example.Reflection_1.Anotation.Init;
import org.example.Reflection_1.Config.Config;
import org.example.Reflection_1.Config.JavaConfig;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PageFactory {

    private static final Config config = new JavaConfig();
    private static final Map<Class, Object> map = new HashMap<>();

//    public PageFactory() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
////        initPage();
////        initPageFields();
//    }
    static {
        try {
            initPage();
            initPageFields();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


    public static  <T> T getPage(Class<T> clazz){
        return (T) map.get(clazz);
    }

    private static void initPage() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections(config.getPackageToScan());
        final Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(org.example.Reflection_1.Anotation.PageFactory.class);
        for (Class clazz: typesAnnotatedWith){
            Object o1 = clazz.getDeclaredConstructor().newInstance();
            map.put(clazz, o1);
        }
    }
    private static void initPageFields() throws IllegalAccessException {
        for (Map.Entry<Class, Object> page: map.entrySet()){
            final Field[] declaredFields = page.getValue().getClass().getDeclaredFields();
            for (Field field: declaredFields){
                final Init annotation = field.getAnnotation(Init.class);
                if (annotation != null){
                    field.setAccessible(true);
                    field.set(map.get(page.getKey()) , map.get(field.getType()));
                }
            }
        }
    }


}
