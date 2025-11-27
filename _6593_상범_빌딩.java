package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6593_상범_빌딩 {
    static int n, m, h, time;
    static char[][][] map;
    static boolean[][][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] dh = {1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(h == 0 || n == 0 || m == 0) {
                return;
            }

            map = new char[h][n][m];
            visited = new boolean[h][n][m];

            int sx = 0, sy = 0, sh = 0, ex = 0, ey = 0, eh = 0;
            for(int k = 0; k < h; k++) {
                for(int i = 0; i < n; i++) {
                    String s = br.readLine();
                    for(int j = 0; j < m; j++) {
                        map[k][i][j] = s.charAt(j);

                        if(map[k][i][j] == 'S') {
                            sx = i;
                            sy = j;
                            sh = k;
                        }

                        if(map[k][i][j] == 'E') {
                            ex = i;
                            ey = j;
                            eh = k;
                        }
                    }
                }
                br.readLine();
            }

            boolean flag = bfs(sx, sy, sh, ex, ey, eh);

            if(flag) {
                System.out.println("Escaped in " + time + " minute(s).");
            }
            else {
                System.out.println("Trapped!");
            }
        }
    }

    static boolean bfs(int sx, int sy, int sh, int ex, int ey, int eh) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy, sh, 0));
        visited[sh][sx][sy] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == ex && cur.y == ey && cur.h == eh) {
                time = cur.time;
                return true;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nh = cur.h;

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nh][nx][ny] && map[nh][nx][ny] != '#') {
                    q.offer(new Node(nx, ny, nh, cur.time + 1));
                    visited[nh][nx][ny] = true;
                }
            }

            for(int i = 0; i < 2; i++) {
                int nx = cur.x;
                int ny = cur.y;
                int nh = cur.h + dh[i];

                if(nh >= 0 && nh < h && !visited[nh][nx][ny] && map[nh][nx][ny] != '#') {
                    q.offer(new Node(nx, ny, nh, cur.time + 1));
                    visited[nh][nx][ny] = true;
                }
            }
        }

        return false;
    }

    static class Node {
        int x, y, h, time;

        public Node(int x, int y, int h, int time) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.time = time;
        }
    }
}
