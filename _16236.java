package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _16236 {
    static int[][] map;
    static int N;
    static int eat = 0; // 상어가 커질 때 까지 먹어야 하는 수
    static int size = 2; // 상어 크기
    static int time, sharkX, sharkY;


    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while(true) {
            boolean flag = bfs(sharkX, sharkY);

            if(!flag) {
                break;
            }
        }
        System.out.println(time);
    }
    static boolean bfs(int x, int y) {
        PriorityQueue<Shark> pq = new PriorityQueue<>();
        pq.offer(new Shark(x, y, 0));

        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;

        while(!pq.isEmpty()) {
            Shark shark = pq.poll();

            if(map[shark.x][shark.y] != 0 && map[shark.x][shark.y] < size) {
                map[shark.x][shark.y] = 0;
                eat++;
                time += shark.dist;

                sharkX = shark.x;
                sharkY = shark.y;

                if(eat == size) {
                    size++;
                    eat = 0;
                }

                return true;
            }

            for(int i = 0; i < 4; i++) {
                int nx = shark.x + dx[i];
                int ny = shark.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if(visited[nx][ny] || map[nx][ny] > size) {
                    continue;
                }

                visited[nx][ny] = true;
                pq.offer(new Shark(nx, ny, shark.dist + 1));
            }
        }
        return false;
    }

    static class Shark implements Comparable<Shark> {
        int x, y, dist;

        Shark(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public int compareTo(Shark o1) {
            if (dist == o1.dist && x == o1.x) {
                return y - o1.y;
            }
            else if(dist == o1.dist) {
                return x - o1.x;
            }
            return dist - o1.dist;
        }
    }
}