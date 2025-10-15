package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _9376_탈옥 {
    static int n, m;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new char[n + 2][m + 2];

            Node[] point = new Node[2];
            for(int i = 0; i < n + 2; i++) {
                for(int j = 0; j < m + 2; j++) {
                    map[i][j] = '.';
                }
            }

            int idx = 0;
            for(int i = 1; i <= n; i++) {
                String s = br.readLine();
                for(int j = 1; j <= m; j++) {
                    map[i][j] = s.charAt(j - 1);

                    if(map[i][j] == '$') {
                        point[idx++] = new Node(i, j);
                    }
                }
            }

            // 0-1 bfs
            int[][] dist0 = bfs(0, 0);
            int[][] dist1 = bfs(point[0].x, point[0].y);
            int[][] dist2 = bfs(point[1].x, point[1].y);

            int result = Integer.MAX_VALUE;
            for(int i = 0; i <= n + 1; i++) {
                for(int j = 0; j <= m + 1; j++) {
                    if(map[i][j] == '*') {
                        continue;
                    }

                    if(dist0[i][j] == -1 || dist1[i][j] == -1 || dist2[i][j] == -1) {
                        continue;
                    }

                    int cnt = dist0[i][j] + dist1[i][j] + dist2[i][j];
                    if(map[i][j] == '#') {
                        cnt -= 2;
                    }

                    result = Math.min(result, cnt);
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static int[][] bfs(int x, int y) {
        int[][] dist = new int[n + 2][m + 2];

        for(int i = 0; i < n + 2; i++) {
            for(int j = 0; j < m + 2; j++) {
                dist[i][j] = -1;
            }
        }

        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y));
        dist[x][y] = 0;

        while(!dq.isEmpty()) {
            Node cur = dq.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2) {
                    continue;
                }

                if(map[nx][ny] == '*' || dist[nx][ny] != -1) {
                    continue;
                }

                if(map[nx][ny] == '#') {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    dq.addLast(new Node(nx, ny));
                }
                else {
                    dist[nx][ny] = dist[cur.x][cur.y];
                    dq.addFirst(new Node(nx, ny));
                }
            }
        }

        return dist;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
