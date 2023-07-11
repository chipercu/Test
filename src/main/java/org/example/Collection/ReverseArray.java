package org.example.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseArray {

    public static final int[] key = new int [] {3, 2, 0};

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.stream(key).boxed().collect(Collectors.toList()));
        list.stream().filter(k -> k != 0).forEach(System.out::println);
        Collections.reverse(list);
        list.stream().filter(k -> k != 0).forEach(System.out::println);



    }


}
