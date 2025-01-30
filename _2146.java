package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2146 {
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 2;
        for(int i = 0; i < n; i++) { // 섬 번호 붙이기 (dfs)
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1) {
                    dfs(i, j, num);
                    num++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] > 1) {
                    bfs(i, j, map[i][j], 0);
                }
            }
        }

        System.out.println(min);

    }

    static void dfs(int x, int y, int num) { // 구역 나누기
        visited[x][y] = true;
        map[x][y] = num;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny, num);
                }
            }
        }
    }

    static void bfs(int x, int y, int num, int cnt) { // 최단거리 구하기.
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, num, 0));
        visited = new boolean[n][n];
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(map[cur.x][cur.y] != 0 && map[cur.x][cur.y] != num) {
                min = Math.min(min, cur.cnt - 1);
            }

            if(cur.cnt > min) {
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if(visited[nx][ny] || map[nx][ny] == num) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, num, cur.cnt + 1));
            }
        }
    }

    static class Node {
        int x, y, num, cnt;

        public Node(int x, int y, int num, int cnt) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.cnt = cnt;
        }
    }
}