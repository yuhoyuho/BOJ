package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260_1 {
    static int n, m, v;
    static boolean[] visited;

    static Queue<Integer> q = new LinkedList<>();
    static int[][] arr;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


    }

    static void dfs(int start) {
        visited = new boolean[n + 1];
        visited[start] = true;

        q.offer(start);

        while(!q.isEmpty()) {
            sb.append(q.poll());

            for()
        }
    }

    static void bfs() {

    }
}
