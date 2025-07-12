package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569_1 {
    static int n, m, h, result;
    static int[][][] map;
    static boolean[][][] visited;

    static int[] dx = {0, -1, 0, 1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[n][m][h];
        visited = new boolean[n][m][h];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                for(int k = 0; k < m; k++) {
                    map[j][k][i] = Integer.parseInt(st.nextToken());

                    if(map[j][k][i] == 1) {
                        visited[j][k][i] = true;
                        q.add(new Tomato(j, k, i));
                    }
                }
            }
        }

        bfs();
        result = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(map[j][k][i] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    else {
                        result = Math.max(result, map[j][k][i]);
                    }
                }
            }
        }

        System.out.println(result - 1);
    }

    static void bfs() {
        while(!q.isEmpty()) {
            Tomato cur = q.poll();

            for(int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nh = cur.h + dh[i];

                if(nx >= 0 && ny >= 0 && nh >= 0 && nx < n && ny < m && nh < h && !visited[nx][ny][nh] && map[nx][ny][nh] == 0) {
                    map[nx][ny][nh] = map[cur.x][cur.y][cur.h] + 1;
                    visited[nx][ny][nh] = true;
                    q.offer(new Tomato(nx, ny, nh));
                }
            }
        }
    }

    static class Tomato {
        int x, y, h;

        public Tomato(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
