package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14442 {
    static int n, m, k; // 0 : 이동 가능, 1 : 벽
    static int result;

    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][k + 1];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        result = Integer.MAX_VALUE;
        bfs();
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.offer(new Node(0, 0, 0, 1));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == n - 1 && cur.y == m - 1) {
                result = cur.dist;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(map[nx][ny] == 1) {
                        if(cur.cnt < k && !visited[nx][ny][cur.cnt + 1]){
                            visited[nx][ny][cur.cnt + 1] = true;
                            q.offer(new Node(nx, ny, cur.cnt + 1, cur.dist + 1));
                        }
                    }
                    else {
                        if(!visited[nx][ny][cur.cnt]) {
                            visited[nx][ny][cur.cnt] = true;
                            q.offer(new Node(nx, ny, cur.cnt, cur.dist + 1));
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int x, y, cnt, dist;

        public Node(int x, int y, int cnt, int dist) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dist = dist;
        }
    }
}
