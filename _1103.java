package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1103 {
    static char[][] map;
    static int[][] dp; // 도착한 칸의 최대 cnt를 저장.
    static boolean[][] visited;
    static int N, M;
    static int cnt;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[0][0] = true;
        dfs(0, 0, 1);

        System.out.println(cnt);
    }

    static void dfs(int x, int y, int play) {
        if(cnt == -1) {
            return;
        }

        cnt = Math.max(cnt, play);

        for(int i = 0; i < 4; i++) {
            int move = map[x][y] - '0';

            int nx = x + dx[i] * move;
            int ny = y + dy[i] * move;

            if(isInRange(nx, ny) && map[nx][ny] != 'H' && play + 1 > dp[nx][ny]) {
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dp[nx][ny] = play + 1;
                    dfs(nx, ny, play + 1);
                    visited[nx][ny] = false;
                }
                else {
                    cnt = -1;
                    return;
                }
            }
        }
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}