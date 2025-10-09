package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/// Node left, right로 단순 dfs 탐색을 하는 경우 최악의 경우(한 쪽으로 치우친 편향 트리인 경우) O(n^2)의 시간복잡도를 가짐
/// TreeMap 자료구조를 활용해서 O(n log n)에 끝냄
public class _2957_이진탐색트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long cnt = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            int key = Integer.parseInt(br.readLine());

            Integer lower = map.lowerKey(key);
            Integer higher = map.higherKey(key);

            int left = (lower == null) ? -1 : map.get(lower);
            int right = (higher == null) ? -1 : map.get(higher);

            int depth = Math.max(left, right) + 1;
            map.put(key, depth);
            cnt += depth;
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
