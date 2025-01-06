package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static int N, M, V;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }
        dfs(V);

        sb.append("\n");
        check = new boolean[N + 1];

        bfs(V);

        System.out.println(sb);
    }
    static void dfs(int x) {
        check[x] = true;
        sb.append(x + " ");

        for(int i = 0; i <= N; i++) {
            if(arr[x][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
    static void bfs(int x) {
        q.add(x);
        check[x] = true;

        while(!q.isEmpty()) {
            x = q.poll();
            sb.append(x + " ");

            for(int i = 0; i <= N; i++) {
                if(arr[x][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}