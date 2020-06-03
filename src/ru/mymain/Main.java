package ru.mymain;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.print("Input the sum: ");
        int sum = new Scanner(System.in).nextInt();

        Random rnd = new Random();

        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            int value = rnd.nextInt(100);
            int mult = rnd.nextInt(2) % 2 == 0 ? 1 : -1;
            arr[i] = mult * value;
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        solution(arr, sum);
    }

    public static void solution(int[] arr, int sum) {
        List<Pair> result = searchPairs(arr, sum);
        for (Pair p : result) {
            System.out.println(p.first + ", " + p.second);
        }
    }

    private static class Pair {
        int first, second;

        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    private static List<Pair> searchPairs(int[] arr, int sum) {
        Map<Integer, Integer> map = new MyHashMap<>(100);
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], sum - arr[i]);
        }
        List<Pair> pairs = new ArrayList<Pair>();
        for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
            Integer requiredKey = kv.getValue();
            if (map.containsKey(requiredKey)) {
                pairs.add(new Pair(kv.getKey(), kv.getValue()));
                map.remove(requiredKey);
            }
        }
        return pairs;
    }
}
