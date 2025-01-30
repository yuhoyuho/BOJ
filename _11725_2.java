package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11725_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            list.get(p).add(s);
            list.get(s).add(p);
        }

        boolean[] visited = new boolean[n + 1];
        int[] result = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : list.get(cur)) {
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;

                    result[next] = cur;
                }
            }
        }
        for(int i = 2; i <= n; i++) {
            sb.append(result[i] + "\n");
        }

        System.out.println(sb);
    }
}