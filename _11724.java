package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11724 {
    static boolean[] visited = new boolean[1001];
    static int[][] graph = new int[1001][1001];
    static int N;
    static int M;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int x, y;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }

        int result = 0;
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int start) {
        if(visited[start]) {
            return;
        }
        else {
            visited[start] = true;
            for(int i = 1; i <= N; i++) {
                if(graph[start][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}