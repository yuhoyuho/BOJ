package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3197 {
    static int r, c, time;
    static boolean flag;
    static int swanX, swanY;

    static char[][] map;
    static boolean[][] visited;
    static boolean[][] check; // 녹는 부분인지 아닌지 검사

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        flag = false;

        map = new char[r][c];

        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 'L') {
                    swanX = i;
                    swanY = j;
                }
            }
        }

        while(!flag) {
            meet();
            melting();
        }

        System.out.println(time);
    }

    static void bfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if(map[nx][ny] == '.') {
                    check[x][y] = true;
                }
            }
        }
    }

    static void melting() {
        check = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 'X') {
                    bfs(i, j);
                }
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(check[i][j]) {
                    map[i][j] = '.';
                }
            }
        }
    }

    static void meet() {
        visited = new boolean[r][c];
        Queue<Node> q = new LinkedList<>();
        visited[swanX][swanY] = true;
        q.offer(new Node(swanX, swanY));

        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny]) {
                    if(map[nx][ny] == 'L') {
                        flag = true;
                        return;
                    }
                    else if(map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
        time++;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
