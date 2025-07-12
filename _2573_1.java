package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2573_1 {
    static int n, m, cnt, time;
    static int[][] map;
    static int[][] copyMap;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1 ,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copyMap = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        melting();
        System.out.println(time);
    }

    static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(map[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx, ny, visited);
            }
        }
    }

    static void count() {
        boolean[][] visited = new boolean[n][m];
        cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
    }

    static void save(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(map[nx][ny] == 0) {
                copyMap[x][y]++;
            }
        }
    }

    static boolean check() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static void melting() { // 빙산 녹이기
        while(check()) {
            time++;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] != 0) {
                        save(i, j);
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] != 0) {
                        map[i][j] -= copyMap[i][j];

                        if(map[i][j] <= 0) {
                            map[i][j] = 0;
                        }
                    }
                }
            }

            count();
            if(cnt > 1) {
                return;
            }

            copyMap = new int[n][m];
        }

        time = 0;
    }
}
