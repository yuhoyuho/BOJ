package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1987 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[] check = new boolean[26];
    static int R, C;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 1);
        System.out.println(result);
    }
    public static void dfs(int x, int y, int count) {
        check[map[x][y]] = true;
        result = Math.max(result, count);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if(!check[map[nx][ny]]) {
                    dfs(nx, ny, count + 1);
                    check[map[nx][ny]] = false;
                }
            }
        }
    }
}