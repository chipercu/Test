package org.example;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class XmlParser {

    List<String> classBody = new ArrayList<>();
    List<String> classVar = new ArrayList<>();
    List<String> classVarObjectString = new ArrayList<>();

    public XmlParser() {



    }

    public void createXmlFromClass(Class<?> clazz) throws IOException {


//        String abs = "C:\\Users\\a.kiperku\\IdeaProjects\\Test\\src\\main\\java\\org\\example\\"+ className +".java";
        Path path = Paths.get(clazz.getPackage().getName());

        classBody.add("<?xml version='1.0' encoding='utf-8'?>\n");
        classBody.add(" <"+ clazz.getSimpleName());
        Method[] methods = clazz.getMethods();
        for (Method method: methods){
            classBody.add(method.getName() + " =\"\"");
        }
        classBody.add(">\n");
        Files.write(path, classBody);
    }


    public void createClassFromXml() throws IOException {

        String className = "";


        Reader reader = new FileReader("C:\\Users\\a.kiperku\\IdeaProjects\\Test\\src\\main\\java\\org\\example\\test_read.xml");
        BufferedReader buffReader = new BufferedReader(reader);

        while (buffReader.ready()) {
            String line = buffReader.readLine();
            if (line.contains("<?") && line.contains("?>")){ //начало документа
                continue;
            } else if (line.contains("</")) {
                continue;
            } else if (line.contains("<!--") && line.contains("-->")){  //комментарий
                continue;
            } else if (line.contains("<") && line.contains("/>")) {
                classVarObjectString.add(line);
                System.out.println(line);

            } else if (line.contains("<") && line.contains(">")) {
                List<String> stringList = Arrays.stream(line.split(" ")).collect(Collectors.toList());
                for (String s: stringList) {
                    if (s.startsWith("<")){
                        String[] splitName = firstUpperCase(s.replace("<", "")).split("_");
                        if (className.isEmpty()){
                            for (String str: splitName){
                                className += firstUpperCase(str);
                            }
                        }
                    } else if (s.contains("=\"")) {
                        String[] split = s.split("=");
                        String varName = split[0].trim();
                        String strVar = split[1].trim().replace("\"", "");

                        String varType;
                        try {
                            Integer.parseInt(strVar);
                            varType = "int ";
                        }catch (NumberFormatException numberFormatException){
                            varType = "String ";
                        }
                        String variable = "private "+ varType + varName + ";\n";
                        if (!checkIfExistVar(classVar, variable)){
                            classVar.add(variable);
                        }
                    }
                }
            } else if (line.startsWith("<") && line.endsWith("/>")) { //конец обьекта
            }

        }
        reader.close();
        buffReader.close();


        String classPackage = XmlParser.class.getPackage().getName();
        String abs = "C:\\Users\\a.kiperku\\IdeaProjects\\Test\\src\\main\\java\\org\\example\\"+ className +".java";
        Path path = Paths.get(abs);

        classBody.add("package " + classPackage + ";\n");
        classBody.add("public class " + className + " {\n");
        classBody.addAll(classVar);
        classBody.add("public " + className + "() { }\n");

        generateGetters(classVar);
        generateSetters(classVar);

        classBody.add(" }\n");

        Files.write(path, classBody);

    }

    public boolean checkIfExistVar(List<String> list, String var){
        if (list.isEmpty()){
            return false;
        }
        for (String str: list){
            if (str.equalsIgnoreCase(var)){
                return true;
            }
        }
        return false;
    }

    public String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return ""; //или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public void generateGetters(List<String> list){
        for (String var: list){
            String[] s = var.split(" ");
            String replace = s[2].replace(";", "").trim();
            String type = s[1];
            classBody.add("public " + type + " get" + firstUpperCase(replace) + " (){ \n  return this." + replace + "; \n } \n");
        }
    }
    public void generateSetters(List<String> list){
        for (String var: list){
            String[] s = var.split(" ");
            String replace = s[2].replace(";", "").trim();
            String type = s[1];
            classBody.add("public void set" + firstUpperCase(replace) + " ("+ type + " " + replace +"){ \n  this." + replace + " = " + replace + "; \n } \n");
        }
    }



}
