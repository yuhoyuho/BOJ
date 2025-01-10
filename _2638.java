package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2638 {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Node> cheese;
    static int cheeseCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cheese = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) {
                    cheese.add(new Node(i, j));
                    cheeseCnt++;
                }
            }
        }

        int result = 0;
        while(true) {

            if(cheeseCnt == 0) {
                break;
            }

            bfs();
            melt();

            result++;
        }

        System.out.println(result);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));

        visited = new boolean[N][M];
        visited[0][0] = true;
        map[0][0] = 2;

        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if(visited[nx][ny] || map[nx][ny] == 1) {
                    continue;
                }

                map[nx][ny] = 2;
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
    }
    static void melt() {
        for(int i = 0; i < cheese.size(); i++) {
            int x = cheese.get(i).x;
            int y = cheese.get(i).y;
            int cnt = 0;

            for(int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if(map[nx][ny] == 2) {
                    cnt++;
                }
            }
            if(cnt >= 2) {
                map[x][y] = 0;
                cheeseCnt--;
                cheese.remove(i);
                i--;
            }
        }
    }
    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}