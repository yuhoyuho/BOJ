package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }
        bfs();
        System.out.println(map[N][M]);
    }
    private static class Node {
        int x, y;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 1));
        visited[1][1] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nearX = cur.x + dx[i];
                int nearY = cur.y + dy[i];

                if(nearX > 0 && nearY > 0 && nearX <= M && nearY <= N && !visited[nearY][nearX] && map[nearY][nearX] != 0) {
                    q.offer(new Node(nearY, nearX));
                    visited[nearY][nearX] = true;
                    map[nearY][nearX] = map[cur.y][cur.x] + 1;
                }
            }
        }
    }
}