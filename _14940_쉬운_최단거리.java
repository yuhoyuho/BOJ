package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14940_쉬운_최단거리 {
    static int n, m;
    static int[][] map, result;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        int x = 0, y = 0;
        for(int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    x = i;
                    y = j;
                }
                else if(map[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }

        bfs(x, y);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new java.util.LinkedList<>();
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;
        result[x][y] = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                    result[nx][ny] = cur.cnt + 1;
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, cur.cnt + 1));
                }
            }
        }
    }

    static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

}
