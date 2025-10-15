package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16930_달리기 {
    static int n, m, k;
    static char[][] map;
    static int[][] dist;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dist = new int[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(dist[i], -1);
        }

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;

        bfs(x1, y1, x2, y2);
        System.out.println(dist[x2][y2]);
    }

    static void bfs(int x1, int y1, int x2, int y2) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x1, y1));
        dist[x1][y1] = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == x2 && cur.y == y2) {
                return;
            }

            for(int i = 0; i < 4; i++) {
                for(int move = 1; move <= k; move++) {
                    int nx = cur.x + dx[i] * move;
                    int ny = cur.y + dy[i] * move;

                    if(nx >= n || ny >= m || nx < 0 || ny < 0) {
                        break;
                    }

                    if(map[nx][ny] == '#') {
                        break;
                    }

                    if(dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[cur.x][cur.y] + 1;
                        q.offer(new Node(nx, ny));
                    }
                    else {
                        if(dist[nx][ny] < dist[cur.x][cur.y] + 1) {
                            break;
                        }

                        if(dist[nx][ny] == dist[cur.x][cur.y] + 1) {
                            continue;
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
