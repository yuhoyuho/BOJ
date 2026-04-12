package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17836_공주님을_구해라 {
    static int[][] map;
    static boolean[][][] visited;
    static int n, m, time;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = bfs(0, 0);
        if(result == -1) {
            System.out.println("Fail");
        }
        else {
            System.out.println(result);
        }
    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0, false));
        visited[x][y][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.cnt > time) {
                break;
            }

            if(cur.x == n - 1 && cur.y == m - 1) {
                return cur.cnt;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < n && ny < m && nx >= 0 && ny >= 0) {
                    if(!cur.gram) {
                        if(map[nx][ny] == 2 && !visited[nx][ny][0]) {
                            q.offer(new Node(nx, ny, cur.cnt + 1, true));
                            visited[nx][ny][1] = true;
                        }
                        else if(map[nx][ny] == 0 && !visited[nx][ny][0]) {
                            q.offer(new Node(nx, ny, cur.cnt + 1, false));
                            visited[nx][ny][0] = true;
                        }
                    }
                    else {
                        if(!visited[nx][ny][1]) {
                            q.offer(new Node(nx, ny, cur.cnt + 1, true));
                        }
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int x, y, cnt;
        boolean gram;

        public Node(int x, int y, int cnt, boolean gram) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.gram = gram;
        }
    }
}
