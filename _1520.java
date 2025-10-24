package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1520 {
  static int n, m;
  static int[][] map, dp;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    input();
    System.out.println(dfs(0, 0));
  }

  static int dfs(int x, int y) {
    if(x == n - 1 && y == m - 1) {
      return 1;
    }

    if(dp[x][y] != -1) {
      return dp[x][y];
    }

    dp[x][y] = 0;

    for(int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] < map[x][y]) {
        dp[x][y] += dfs(nx, ny);
      }
    }

    return dp[x][y];
  }

  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    dp = new int[n][m];
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      Arrays.fill(dp[i], -1);
      for(int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }
}
