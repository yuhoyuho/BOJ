package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4179 {
    static int r, c, time;

    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    static Queue<Node> jhq = new LinkedList<>();
    static Queue<Node> fireQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 'J') {
                    jhq.offer(new Node(i, j));
                    visited[i][j] = true;
                }
                else if(map[i][j] == 'F') {
                    fireQ.offer(new Node(i, j));
                }
            }
        }
        bfs();
        System.out.println(sb);
    }

    static void bfs() {
        while(!jhq.isEmpty()) {
            time++;

            int size = fireQ.size();
            for(int i = 0; i < size; i++) {
                Node fire = fireQ.poll();

                for(int j = 0; j < 4; j++) {
                    int nx = fire.x + dx[j];
                    int ny = fire.y + dy[j];

                    if(nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] == '.') {
                        map[nx][ny] = 'F';
                        fireQ.offer(new Node(nx, ny));
                    }
                }
            }

            size = jhq.size();
            for(int k = 0; k < size; k++) {
                Node node = jhq.poll();

                for(int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        sb.append(time);
                        return;
                    }

                    if(!visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        jhq.offer(new Node(nx, ny));
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
