package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class _1539_이진검색트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long cnt = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            int key = Integer.parseInt(br.readLine());

            Integer lower = map.lowerKey(key);
            Integer higher = map.higherKey(key);

            int left = lower == null ? 0 : map.get(lower);
            int right = higher == null ? 0 : map.get(higher);

            int depth = Math.max(left, right) + 1;
            map.put(key, depth);
            cnt += depth;
        }
        System.out.println(cnt);
    }
}
