package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16234 {
    static int N, L, R;
    static int time;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean flag = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
            time++;
        }
        System.out.println(time);
    }
    static boolean bfs (int x, int y){
        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> list = new ArrayList<>();
        q.offer(new Node(x, y));
        list.add(new Node(x, y));

        visited[x][y] = true;

        int sum = map[x][y];
        boolean moved = false;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                int diff = Math.abs(map[node.x][node.y] - map[nx][ny]);

                if (diff >= L && diff <= R) {
                    sum += map[nx][ny];
                    visited[nx][ny] = true;

                    q.offer(new Node(nx, ny));
                    list.add(new Node(nx, ny));
                    moved = true;
                }
            }
        }
        // 평균값으로 바꿔주기
        if (list.size() > 1) {
            int avg = sum / list.size();

            for (Node node : list) {
                map[node.x][node.y] = avg;
            }
        }
        return moved;
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}