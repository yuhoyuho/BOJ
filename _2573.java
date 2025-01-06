package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class IceBerg {
    int x, y;

    IceBerg(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class _2573 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int result = 0;

        while((count = countIceBerg()) < 2) {
            if(count == 0) {
                result = 0;
                break;
            }
            bfs();
            result++;
        }
        System.out.println(result);
    }

    static int countIceBerg() {
        boolean[][] visited = new boolean[N][M];
        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
            if(map[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx, ny, visited);
            }
        }
    }

    static void bfs() {
        Queue<IceBerg> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0) {
                    q.offer(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            IceBerg ice = q.poll();
            int seaCount = 0;

            for(int i = 0; i < 4; i++) {
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if(!visited[nx][ny] && map[nx][ny] == 0) {
                    seaCount++;
                }
            }

            if(map[ice.x][ice.y] - seaCount < 0) {
                map[ice.x][ice.y] = 0;
            }
            else {
                map[ice.x][ice.y] -= seaCount;
            }
        }
    }
}