package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.Main.CHECK.*;
import static org.example.Main.Checker.*;

public class Main {
    ScheduledExecutorService service;
    private static final int maxWait = 10000;
    private static final int initialDelay = 1000;

    enum CHECK {
        MULTIPLE(integer -> {
            integer *= 2;
            System.out.println(integer);
        }),
        DIVISION(integer -> {
            integer /= 2;
            System.out.println(integer);
        });

        private final Consumer<Integer> consumer;

        public Consumer<Integer> getConsumer() {
            return consumer;
        }

        CHECK(Consumer<Integer> integerConsumer) {
            this.consumer = integerConsumer;
        }
    }


    public static void main(String[] args) throws IOException {

        int exit = 3;

        int count = 0;
        int whileCount = 0;


        for (int i = 0; i < 10; i++) {
            while (true){
                whileCount++;
                while (ThreadLocalRandom.current().nextBoolean()){
                    count++;
                    if (count == exit){
                        break;
                    }
                }
                if (count == exit){
                    System.out.println(whileCount);
                    break;
                }
                count = 0;

            }
        }





    }


    public static void match() {
        String s = "Удаление синхронизации: {name}, {confirm}";
        Pattern pattern = Pattern.compile(" \\{([^{}]+)\\}");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            String str = matcher.group();
            System.out.println(str);
        }

    }

    static class Mouse {
        private int rightButton = 20;
        private int leftButton = 30;

        public Mouse clickCenter(CHECK... checks) {
            for (CHECK c : checks) {
                c.getConsumer().accept(rightButton);
            }

            return this;
        }
    }

    static class Checker {
        private String type;


        public static Consumer<Integer> beforeCheck() {
            return System.out::println;
        }


    }


    public static Stream<List<String>> getList(String ex) {
        return ex != null ? Stream.of(Arrays.stream(ex.split(":")).collect(Collectors.toList())) : Stream.empty();
    }


    class Fake extends JFrame {


    }


//    enum mapEnum{
//        ENUM1, ENUM2
//    }
//    public static Map<Enum, Consumer<ExtProperties>> map = new HashMap<Enum, Consumer<ExtProperties>>() {{
//        put(ENUM1, Main::printPropertyB);
//        put(ENUM2, Main::printProperty);
//    }};
//
//    public static void main(String[] args) {
//        ExtProperties properties = new ExtProperties().addProperty("Отчеты", "ASDASDASD").addBoolean("boolean", true);
//        test(properties, ENUM2);
//    }
//    public static void test(ExtProperties props, mapEnum e) {
//            Optional.of(map.get(e))
//                .orElseThrow(NullPointerException::new)
//                .accept(props);
//    }
//    public static void printPropertyB(ExtProperties properties){
//        System.out.println(properties.isBoolean("boolean"));
//    }
//    public static void printProperty(ExtProperties properties) {
//        System.out.println(properties.getProperty("Отчеты"));
//    }

    // TODO: 25.04.2023  uitest refactoring
//    public enum ReportType {
//        TABLE("Таблица"),
//        SUM_TABLE("Сводная таблица"),
//        COMBINED_CHART("Комбинированная диаграмма"),
//        BAR_GRAPH("Столбиковая диаграмма"),
//        LINE_GRAPH("Линейный график"),
//        DONUT_CHART("Кольцевая диаграмма"),
//        NUM_INDICATOR("Показатель"),
//        FILTER("Фильтр"),
//        PROCESS_CARD("Карта процесса"),
//        PARAMETER("Параметр");
//        private final String value;
//        ReportType(String value) {
//            this.value = value;
//        }
//        public String getValue() {
//            return value;
//        }
//    }
//    private static void addReport(ReportType type, ExtProperties prop, boolean singleComponent) {
//        // поэтому просто берем последний main - это и есть наша раб зона.
//        if (findByTestId(id_droppable_components_container) == null) {
//            editClick();
//        }
//        if (findByTestId(id_droppable_components_container).findByText(prop.getFullName()) != null) {
//            return; // элемент уже есть
//        }
//        dragComponent(type.getValue());
//        while (findByText("олст обновлен до актуальной версии") != null) {
//            longWaitPage(5000);
//            dragComponent(type.getValue());
//        }
//        if(singleComponent && prop.getProperty(ReportsConsts.Размер_отчета) == null) {
//            maximizeReport(type.getValue());
//        } else {
//            editingGraph(prop.getFullName(),
//                    Integer.parseInt(prop.getArray(ReportsConsts.Размер_отчета)[0]),
//                    Integer.parseInt(prop.getArray(ReportsConsts.Размер_отчета)[1]),
//                    Integer.parseInt(prop.getArray(ReportsConsts.Размер_отчета)[2]),
//                    Integer.parseInt(prop.getArray(ReportsConsts.Размер_отчета)[3]));
//        }
//    }


//    public static ExtWebElement findByClassFuture(String value) {
//        ExtWebElement element;
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(); //создаем сервис поток
//        long startFindTime = System.currentTimeMillis(); //фиксируем начало поиска элемента
//        long findTime = 0; //счетчик времени
//        try {
//            element = service.schedule(() -> getRoot().findByClass(value), 100, TimeUnit.MILLISECONDS).get(); //запускаем поток который должен вернуть найденный элемент
//            while (element == null){ //проверяем в цикле 10 сек что элемент не найден
//                if (findTime > 10000){  //условье выхода из цикла по истечении времени поиска
//                    service.shutdown();
//                    throw new NullPointerException("Время пойска элемента истекло");
//                }
//                element = service.schedule(() -> getRoot().findByClass(value), 100, TimeUnit.MILLISECONDS).get(); //перезапуск потока поиска если элемент не был найден
//                findTime += (System.currentTimeMillis() - startFindTime); //обновляем счетчик времени поиска
//                startFindTime = System.currentTimeMillis(); //обновляем время старта нового поиска
//            }
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        service.shutdown(); //вышли из цикла, значит элемент найден и можно вырубить сервис поток
//        return element;
//    }


    public static String kill(int lvl, int counts) {
//        int countD = 0;
//        int countC = 0;
//        int countB = 0;
//        int countA = 0;
//        int countS = 0;
        StringBuilder sb = new StringBuilder();
        Map<NPC.GRADE, Integer> gradeCounts = new HashMap<>();
        for (int i = 0; i < counts; i++) {
            NPC.GRADE grade = new NPC(lvl).onKill();
            if (gradeCounts.containsKey(grade)) {
                gradeCounts.put(grade, gradeCounts.get(grade) + 1);
            } else {
                gradeCounts.put(grade, 1);
//            if (Objects.requireNonNull(grade) == NPC.GRADE.NONE) {
//            } else if (grade == NPC.GRADE.D) {
//                countD++;
//            } else if (grade == NPC.GRADE.C) {
//                countC++;
//            } else if (grade == NPC.GRADE.B) {
//                countB++;
//            } else if (grade == NPC.GRADE.A) {
//                countA++;
//            } else if (grade == NPC.GRADE.S) {
//                countS++;
//            }
            }
//        System.out.println("Monster " + mobLVL + " level. Monster kill: " + mobs);
//        System.out.println("item D grade - " + countD + " шт.");
//        System.out.println("item C grade - " + countC + " шт.");
//        System.out.println("item B grade - " + countB + " шт.");
//        System.out.println("item A grade - " + countA + " шт.");
//        System.out.println("item S grade - " + countS + " шт.");
        }

        sb.append("Monster ").append(lvl).append(" level. Monster kill: ").append(counts).append("\n");
        for (Map.Entry<NPC.GRADE, Integer> entry : gradeCounts.entrySet()) {
            sb.append("item ").append(entry.getKey()).append(" - ").append(entry.getValue()).append(" шт.\n");
        }
        return sb.toString();
    }


//    public void waitReport() throws ExecutionException, InterruptedException {
//        int waitTime = 10000;
//        int initWaitTime = 0;
//        int waitPage = 1000;
//
//        List<ExtWebElement> elems = findElementById();
//
//        CheckCssValue checkCssValue = new CheckCssValue(elems);
//
//        ScheduledFuture<Boolean> schedule = Executors.newSingleThreadScheduledExecutor().schedule(checkCssValue, waitPage, TimeUnit.MILLISECONDS);
//
//        while (schedule.get()){
//            if (initWaitTime > waitTime){
//                executorService.shutdown();
//                throw new NullPointerException(String.format("Время поиска элемента истекло: %d мс. Элемент не найден", waitTime));
//            }
//            initWaitTime += waitPage;
//            schedule = Executors.newSingleThreadScheduledExecutor().schedule(checkCssValue, waitPage, TimeUnit.MILLISECONDS);
//        }
//    }
//    public class CheckCssValue implements Callable<Boolean>{
//        private List<ExtWebElement> elems;
//
//        public CheckCssValue(List<ExtWebElement> elems){
//            this.elems = elems;
//        }
//        @Override
//        public Boolean call() throws Exception {
//            for (ExtWebElement properties : elems){
//                if (Objects.equals(properties.getCssValue("animation-duration"), "400ms")){
//                    return false;
//                }
//            }
//            return true;
//        }
//    }


    public static String getProperUserName() {
        String usr = System.getProperty("user.home");
        return usr.substring(usr.lastIndexOf("\\") + 1);
    }


    public void deleteFile(String path, boolean wait) {
        String userPath = "C:\\Users\\" + getProperUserName();
        Path absolutePath = Paths.get(userPath + path);
        if (wait) {
            try {
                Files.delete(absolutePath);
            } catch (IOException e) {
                int waitTime = 10000;
                int initWaitTime = 0;

                if (Files.exists(absolutePath)) {
                    while (!check(absolutePath, 1000)) {
                        if (initWaitTime > waitTime) {
                            return;
                        }
                        initWaitTime += 1000;
                        System.out.println("Файл занят!");
                    }
                } else {
                    System.out.println("Файл не существует");
                }
            }
        } else {
            try {
                Files.deleteIfExists(absolutePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Boolean check(Path absolutePath, int delay) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Boolean aBoolean = null;
        try {
            aBoolean = service.schedule(() -> {
                try {
                    return Files.deleteIfExists(absolutePath);
                } catch (IOException e) {
                    return false;
                }
            }, delay, TimeUnit.MILLISECONDS).get();
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();
        return aBoolean;
    }


    public void find(Finder finder, int initialDelay) throws ExecutionException, InterruptedException {
        int findTime = 0;
        service = Executors.newSingleThreadScheduledExecutor();

        Future<String> future = service.schedule(finder, initialDelay, TimeUnit.MILLISECONDS);

        while (future.get() == null) {
            if (findTime > maxWait) {
                service.shutdown();
                throw new NullPointerException(String.format("Время поиска элемента истекло: %d мс. Элемент не найден", maxWait));
            }
            findTime += initialDelay;
            future = service.schedule(finder, initialDelay, TimeUnit.MILLISECONDS);
            System.out.println("null");
        }
        service.shutdown();
        System.out.println(future.get());
    }

    public static class Finder implements Callable<String> {
        @Override
        public String call() {
            File file = new File("file.txt");
            if (file.exists()) {
                return file.getName();
            }
            return null;
        }
    }
}