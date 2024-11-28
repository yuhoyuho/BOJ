package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1051 {
    private static int N;
    private static int M;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int square = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                square = Math.max(square, square(i, j));
            }
        }

        if(square == 0) {
            square = 1;
        }
        System.out.println(square);
    }

    private static int square(int x, int y) {
        int max = 0;

        for(int i = 1; i < N; i++) {
            if(x + i < N && y + i < M) {
                if(map[x][y] == map[x + i][y] && map[x][y] == map[x][y + i] && map[x][y] == map[x + i][y + i]) {
                    max = Math.max(max, (i + 1) * (i + 1));
                }
            }
        }
        return max;
    }
}