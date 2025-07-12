package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16926 {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(r-- > 0) {
            rotate();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void rotate() {
        int reps = Math.min(n, m) / 2;

        for(int i = 0; i < reps; i++) {
            int start = map[i][i];

            // left
            for(int j = i + 1; j < m - i; j++) {
                map[i][j - 1] = map[i][j];
            }

            // up
            for(int j = i + 1; j < n - i; j++) {
                map[j - 1][m - i - 1] = map[j][m - i - 1];
            }

            // right
            for(int j = m - i - 1; j > i; j--) {
                map[n - i - 1][j] = map[n - i - 1][j - 1];
            }

            // down
            for(int j = n - i - 1; j > i + 1;j--) {
                map[j][i] = map[j - 1][i];
            }

            map[i + 1][i] = start;
        }
    }
}
