package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889 {
    static int N;
    static boolean[] visited;
    static int[][] map;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        team(0, 0);
        System.out.println(MIN);

    }
    static void team(int idx, int count) {
        if(count == N / 2) {
            cal();
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                team(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
    static void cal() {
        int start = 0;
        int link = 0;

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    start += map[i][j];
                    start += map[j][i];
                }
                else if(!visited[i] && !visited[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        int score = Math.abs(start - link);

        if(score == 0) {
            System.out.println(score);
            System.exit(0);
        }

        MIN = Math.min(MIN, score);
    }
}