package org.anz.interview;

import java.io.*;
import java.util.*;

class Solution {

    public static String showChanges(List<String> input) {
        String line1 = input.get(0);
        String line2 = input.get(1);

        Map<String, HashSet<String>> map = new HashMap<>();
        String[] tokens = line1.split("\\s*,\\s*");

        for (String token : tokens) {
            String[] pair = token.split("\\s*:\\s*");
            String src = pair[1];
            String dst = pair[0];
            if (!map.containsKey(src)) {
                map.put(src, new HashSet<>());
            }
            map.get(src).add(dst);
        }

        List<String> list = new ArrayList<>();
        helper(list, line2, map);
        String result = Arrays.toString(list.toArray());
        int idxLeft = result.indexOf("[");
        int idxRight = result.indexOf("]");
        return result.substring(idxLeft+1, idxRight);
    }

    private static void helper(List<String> list, String src, Map<String, HashSet<String>> map) {
        if (!map.containsKey(src)) return;

        for (String dst : map.get(src)) {
            list.add(dst);
            if (map.containsKey(dst)) helper(list, dst, map);
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String line1 = bufferedReader.readLine().trim();
//        String line2 = bufferedReader.readLine().trim();
//        List<String> input = new ArrayList<>(Arrays.asList(line1, line2));
//
//        bufferedWriter.write(Solution.showChanges(input));
//
//        bufferedReader.close();
//        bufferedWriter.close();
        String line1 = "a.o:a.c, b.o:b.c, c.o:c.c, p1:a.o, p1:b.o, p2:b.o, p2:c.o";
        String line2 = "b.c";
        List<String> input = new ArrayList<>(Arrays.asList(line1, line2));
        System.out.println(Solution.showChanges(input));    // b.o, p1, p2
    }
}