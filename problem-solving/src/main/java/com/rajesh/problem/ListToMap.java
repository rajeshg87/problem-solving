package com.rajesh.problem;

import java.util.*;

public class ListToMap {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Rajesh", "Lenin", "Vasanth", "Aravind", "Gowsi", "Ragav");
        Map<Integer, String> nameMap = names.stream().sorted(Collections.reverseOrder()).collect(LinkedHashMap::new,
                (m,v) -> m.put(m.size()+1, v),
                (m1,m2) -> {});

        System.out.println(nameMap);
    }
}
