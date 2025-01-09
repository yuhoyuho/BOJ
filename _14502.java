package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14502 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static int[][] map;
    static int[][] copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }

    static void dfs(int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<virus> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2) {
                    q.offer(new virus(i, j));
                }
            }
        }

        copy = new int[N][M];

        for(int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }

        while(!q.isEmpty()) {
            virus v = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                if(nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                    continue;
                }

                if(copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;

                    q.offer(new virus(nx, ny));
                }
            }
        }

        int safe = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copy[i][j] == 0) {
                    safe++;
                }
            }
        }
        max = Math.max(safe, max);
    }

    static class virus {
        int x, y;

        virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}