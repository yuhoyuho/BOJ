package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562 {
    static boolean[][] visited;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static int n, time;

    static Queue<Node> q;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n][n];
            time = 0;
            q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int nightX = Integer.parseInt(st.nextToken());
            int nightY = Integer.parseInt(st.nextToken());
            q.offer(new Node(nightX, nightY));

            st = new StringTokenizer(br.readLine());
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());

            if(nightX == goalX && nightY == goalY) {
                sb.append(0).append('\n');
            }
            else {
                bfs(goalX, goalY);
            }
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        while(!q.isEmpty()) {
            time++;

            int size = q.size();
            for(int k = 0; k < size; k++) {
                Node cur = q.poll();

                for(int i = 0; i < 8; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx == x && ny == y) {
                        sb.append(time).append('\n');
                        return;
                    }

                    if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
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
