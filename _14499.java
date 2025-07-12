package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14499 {
    static int n, m, x, y, k;
    static int[] dice;
    static int[][] map;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dice = new int[7];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            move(cmd);
        }
    }

    static void move(int d) {
        int nx = x + dx[d - 1];
        int ny = y + dy[d - 1];

        if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
            roll(d, nx, ny);
            x = nx;
            y = ny;
        }
    }

    static void roll(int cmd, int x, int y) {
        int tmp = dice[1];
        switch(cmd) {
            case 1 :
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
                break;

            case 2:
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;

            case 3:
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;

            case 4:
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }

        if(map[x][y] == 0) {
            map[x][y] = dice[6];
        }
        else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(dice[1]);
    }
}
