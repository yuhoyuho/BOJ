package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569 {
    static int M, N, H;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] map;

    static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1][M + 1];

        for(int i = 1; i <= H; i++) {
            for(int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());

                    if(map[i][j][k] == 1) {
                        q.add(new Tomato(i, j, k));
                    }
                }
            }
        }
        bfs();

        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= H; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= M; k++) {
                    if(map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, map[i][j][k]);
                }
            }
        }

        System.out.println(result == 1 ? 0 : result -1);
    }
    static void bfs() {
        while(!q.isEmpty()) {
            Tomato tomato = q.poll();

            int x = tomato.x;
            int y = tomato.y;
            int z = tomato.z;

            for(int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(checkTomato(nz, ny, nx)) {
                    q.add(new Tomato(nz, ny, nx));
                    map[nz][ny][nx] = map[z][y][x] + 1;
                }
            }
        }
    }
    static boolean checkTomato(int z, int y, int x) {
        if(x > M || y > N || z > H || x < 1 || y < 1 || z < 1) {
            return false;
        }

        if(map[z][y][x] == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    static class Tomato {
        int x, y, z;

        Tomato(int z, int y, int x) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}