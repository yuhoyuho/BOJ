package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1325 {
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    // ArrayList<ArrayList<Integer>> 로 연결해주면 시간 초과 !!
    // ** List 로 연결해주는게 더 빠르다고 함. **
    static ArrayList<Integer>[] list;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new int[N + 1];
        list = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        for(int i = 1; i <= N; i++) {
            if(max < count[i]) {
                max = count[i];
            }
        }

        for(int i = 1; i <= N; i++) {
            if(max == count[i]) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int x = q.poll();

            for(int i : list[x]) {
                if(!visited[i]) {
                    count[i]++;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}