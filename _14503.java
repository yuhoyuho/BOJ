package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14503 {
    static int cnt = 1;
    static int n, m, r, c, d;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);
        System.out.println(cnt);
    }

    static void clean(int x, int y, int dir) {
        map[x][y] = -1;

        for(int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(map[nx][ny] == 0) {
                    cnt++;
                    clean(nx, ny, dir);
                    return;
                }
            }
        }

        int d = (dir + 2) % 4;
        int bx = x + dx[d];
        int by = y + dy[d];

        if(bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1) {
            clean(bx, by, dir);
        }
    }
}