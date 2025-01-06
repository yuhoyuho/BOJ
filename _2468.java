package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2468 {
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int [N][N];

        int top = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] > top) {
                    top = map[i][j];
                }
            }
        }

        int max = 0;
        for(int h = 0; h <= top; h++) {
            visited = new boolean[N][N];
            int count = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && map[i][j] > h) {
                        count += dfs(i, j, h);
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    private static int dfs(int x, int y, int h) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] > h) {
                dfs(nx, ny, h);
            }
        }
        return 1;
    }
}