package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13460 {
    static int N, M, result;
    static char[][] map;
    static boolean[][][][] visited;

    static int holeX, holeY;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);

                if(map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                }

                if(map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }

                if(map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        move(rx, ry, bx, by);
        System.out.println(result);
    }

    static void move(int rx, int ry, int bx, int by) {
        Queue<Bead> q = new LinkedList<>();

        q.offer(new Bead(rx, ry, bx, by, 1));

        visited[rx][ry][bx][by] = true;

        while(!q.isEmpty()) {
            Bead bead = q.poll();

            if(bead.cnt > 10) {
                result = -1;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int newRx = bead.rx;
                int newRy = bead.ry;
                int newBx = bead.bx;
                int newBy = bead.by;

                boolean isRed = false;
                boolean isBlue = false;

                while(map[newRx + dx[i]][newRy + dy[i]] != '#') {
                    newRx += dx[i];
                    newRy += dy[i];

                    if(newRx == holeX && newRy == holeY) {
                        isRed = true;
                        break;
                    }
                }

                while(map[newBx + dx[i]][newBy + dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];

                    if(newBx == holeX && newBy == holeY) {
                        isBlue = true;
                        break;
                    }
                }

                if(isBlue) { // 파란 구슬이 구멍에 빠지면
                    continue;
                }
                if(isRed) { // 빨간 구슬이 구멍에 빠지면
                    result = bead.cnt;
                    return;
                }

                if(newRx == newBx && newRy == newBy) { // 두 구슬의 도착점이 같으면
                    if(i == 0) { // 상
                        if(bead.rx > bead.bx) newRx -= dx[i];
                        else newBx -= dx[i];
                    }
                    if(i == 1) { // 우
                        if(bead.ry > bead.by) newBy -= dy[i];
                        else newRy -= dy[i];
                    }
                    if(i == 2) { // 하
                        if(bead.rx > bead.bx) newBx -= dx[i];
                        else newRx -= dx[i];
                    }
                    if(i == 3) { // 좌
                        if(bead.ry > bead.by) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                }

                if(!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;

                    q.offer(new Bead(newRx, newRy, newBx, newBy, bead.cnt + 1));
                }
            }
        }
        result = -1;
    }

    static class Bead {
        int rx, ry, bx, by, cnt;

        public Bead(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;

            this.bx = bx;
            this.by = by;

            this.cnt = cnt;
        }
    }
}