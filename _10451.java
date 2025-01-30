package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10451 {
    static int[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int result = 0;

            visited = new boolean[n + 1];
            map = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    dfs(i);
                    result++;
                }
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int s) {
        visited[s] = true;

        int next = map[s];

        if(!visited[next]) {
            dfs(next);
        }
    }
}