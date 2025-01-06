package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _4485 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] cost;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int probNum = 1;
        String tmp = "";

        while(!(tmp = br.readLine()).isEmpty()) {
            N = Integer.parseInt(tmp);

            if(N == 0) {
                break;
            }

            map = new int[N][N];
            cost = new int[N][N];
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }

            BFS(0, 0, map[0][0]);
            sb.append("Problem " + probNum + ": " + cost[N - 1][N - 1]).append('\n');
            probNum++;
        }
        System.out.println(sb);
    }

    static void BFS(int x, int y, int weight) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, map[0][0]));
        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= N || ny >= N || nx < 0 || ny < 0) {
                    continue;
                }

                if(!visited[nx][ny] && cost[nx][ny] > map[nx][ny] + node.cost) {
                    cost[nx][ny] = map[nx][ny] + node.cost;
                    visited[nx][ny] = true;

                    pq.add(new Node(nx, ny, cost[nx][ny]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}