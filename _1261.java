package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1261 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }
        System.out.println(bfs(1, 1));
    }

    static int bfs(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 1, 0));
        boolean[][] visited = new boolean[N + 1][M + 1];
        visited[x][y] = true;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(node.x == N && node.y == M) {
                return node.cnt;
            }

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx > N || ny > M || nx < 1 || ny < 1) {
                    continue;
                }

                if(!visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    pq.add(new Node(nx, ny, node.cnt));
                }
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    pq.add(new Node(nx, ny, node.cnt + 1));
                }
            }
        }
        return 0;
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }
}