package com.journaldev.sparkdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertStringToListOfMap {

    public static void main(String[] args) {
        String input = "[{a:1,b:2,c:text},{a:3,b:4,c:text}]";

        List<Map<String, String>> list = new ArrayList<>();
        String[] maps = input.split("[{}]");
        for (String map : maps) {
            if (map.isEmpty() || map.equals(",") || map.equals("[") || map.equals("]")) {
                continue;
            }
            Map<String, String> tempMap = new HashMap<>();
            String[] keyValuePairs = map.split(",");
            for (String pair : keyValuePairs) {
                String[] keyValuePair = pair.split(":");
                System.out.println(keyValuePair[1]);
                tempMap.put(keyValuePair[0], keyValuePair[1]);
            }
            list.add(tempMap);
        }

        System.out.println(list);
    }

}
