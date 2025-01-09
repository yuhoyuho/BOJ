package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206 {
    static int[][] map;
    static boolean[][][] visited;
    static int N, M;
    static int[] dx = {-1 ,0 ,1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            char[] chArr = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(chArr[j]);
            }
        }

        System.out.println(bfs());

    }
    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1, false));

        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Point pos = q.poll();

            if(pos.x == N - 1 && pos.y == M - 1) {
                return pos.cnt;
            }

            for(int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if(nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                    continue;
                }

                // 1. 벽을 깬 적이 있을 때
                if(pos.destroyed) {
                    // 1 - 1 다음 이동 지점이 벽이 아니라면
                    if(map[nx][ny] == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.offer(new Point(nx, ny, pos.cnt + 1, true));
                    }
                }
                else { // 2. 벽을 깬 적이 없을 때
                    if(map[nx][ny] == 1 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        // 2 - 2 다음 이동 지점에 방문한 적이 없을 때(벽을 안 깬 채로) + 다음 지점이 벽이라면
                        q.offer(new Point(nx, ny, pos.cnt + 1, true));
                    }
                    else if(map[nx][ny] == 0 && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        q.offer(new Point(nx, ny, pos.cnt + 1, false));
                    }
                }
            }
        }
        return -1;
    }
    static class Point {
        int x, y, cnt;
        boolean destroyed;

        Point(int x, int y, int cnt, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }
}