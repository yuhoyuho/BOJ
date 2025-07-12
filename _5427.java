package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5427 {
    static int n, m, time;

    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Queue<Node> sq;
    static Queue<Node> fq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new char[m][n];
            visited = new boolean[m][n];
            time = 0;

            sq = new LinkedList<>();
            fq = new LinkedList<>();

            for(int i = 0; i < m; i++) {
                map[i] = br.readLine().toCharArray();
            }

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] == '@') {
                        sq.offer(new Node(i, j));
                    }

                    if(map[i][j] == '*') {
                        fq.offer(new Node(i, j));
                    }
                }
            }

            bfs();
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void bfs() {
        while(!sq.isEmpty()) {
            time++;

            int size = fq.size();
            for(int i = 0; i < size; i++) {
                Node cur = fq.poll();

                for(int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if(nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] == '.') {
                        map[nx][ny] = 'F';
                        visited[nx][ny] = true;
                        fq.offer(new Node(nx, ny));
                    }
                }
            }

            size = sq.size();
            for(int i = 0; i < size; i++) {
                Node cur = sq.poll();

                for(int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        sb.append(time);
                        return;
                    }

                    if(!visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        sq.offer(new Node(nx, ny));
                    }
                }
            }
        }
        sb.append("IMPOSSIBLE");
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
