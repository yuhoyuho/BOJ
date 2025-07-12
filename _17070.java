package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17070 {
    static int n, cnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
        dfs(0, 1, 1);

        System.out.println(cnt);
    }
    static void dfs(int x, int y, int direction) {
        if(x == n - 1 && y == n - 1) {
            cnt++;
            return;
        }

        switch(direction) {
            // 1 = 가로, 2 = 세로, 3 = 대각선
            case 1:
                // 가로 -> 가로
                if(y + 1 < n && map[x][y + 1] != 1) {
                    dfs(x, y + 1, 1);
                }
                // 가로 -> 대각선
                if(x + 1 < n && y + 1 < n && map[x + 1][y + 1] != 1 && map[x + 1][y] != 1 && map[x][y + 1] != 1) {
                    dfs(x + 1, y + 1, 3);
                }
                break;
            case 2 :
                // 세로 -> 세로
                if(x + 1 < n && map[x + 1][y] != 1) {
                    dfs(x + 1, y, 2);
                }
                // 세로 -> 대각선
                if(x + 1 < n && y + 1 < n && map[x + 1][y + 1] != 1 && map[x + 1][y] != 1 && map[x][y + 1] != 1) {
                    dfs(x + 1, y + 1, 3);
                }
                break;
            case 3 :
                // 대각선 -> 가로
                if(x < n && y + 1 < n && map[x][y + 1] != 1) {
                    dfs(x, y + 1, 1);
                }
                // 대각선 -> 세로
                if(x + 1 < n && y < n && map[x + 1][y] != 1) {
                    dfs(x + 1, y, 2);
                }
                // 대각선 -> 대각선
                if(x + 1 < n && y + 1 < n && map[x + 1][y + 1] != 1 && map[x + 1][y] != 1 && map[x][y + 1] != 1) {
                    dfs(x + 1, y + 1, 3);
                }
                break;

        }
        return;
    }
}
