package com.company.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test5434 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Optional<String> reduce = list.stream().reduce((a, b) -> a + "\r\n" + b);
        System.out.println(reduce.get());
        System.out.println(12);
    }
}
