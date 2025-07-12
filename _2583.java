package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2583 {
    static int m, n, k, cnt, width;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = y1; j < y2; j++) {
                for(int k = x1; k < x2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] != 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(list);
        sb.append(cnt).append('\n');
        for(int i : list) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        width = 0;
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            width++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] != 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        cnt++;
        list.add(width);
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
