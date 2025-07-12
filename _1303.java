package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1303 {
    static int n, m;

    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int w = 0;
        int b = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'W' && !visited[i][j]) {
                    w += calW(i, j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'B' && !visited[i][j]) {
                    b += calB(i, j);
                }
            }
        }

        System.out.println(w + " " + b);
    }

    static int calW(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        int power = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 'W' && !visited[nx][ny]) {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    power++;
                }
            }
        }

        return power * power;
    }

    static int calB(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;
        int power = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 'B' && !visited[nx][ny]) {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    power++;
                }
            }
        }

        return power * power;
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
