package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] box;
    static int M, N;
    static Queue<Tomato> q = new LinkedList<>();

    static class Tomato {
        int x, y, day;

        Tomato(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if(box[i][j] == 1) {
                    q.offer(new Tomato(i, j, 0));
                }
            }
        }
        bfs();
    }

    private static void bfs() {
        int day = 0;

        while (!q.isEmpty()) {
            Tomato t = q.poll();
            day = t.day;
            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (box[ny][nx] == 0) {
                        box[ny][nx] = 1;
                        q.add(new Tomato(ny, nx, day + 1));
                    }
                }
            }
        }
        if (check()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }
    private static boolean check() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}