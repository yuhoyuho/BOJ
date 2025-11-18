package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _1 {

    static int N;
    static int[][] map;
    static int sharkX, sharkY, size = 2, eat = 0, time = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    
    static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Target {
        int x, y, dist;

        Target(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                } else {
                    map[i][j] = value;
                }
            }
        }

        while (true) {
            Target target = find();

            if (target == null) {
                break;
            }

            time += target.dist;
            sharkX = target.x;
            sharkY = target.y;
            map[sharkX][sharkY] = 0;
            eat++;

            if (eat == size) {
                size++;
                eat = 0;
            }
        }

        System.out.println(time);
    }

    /**
     * BFS를 돌면서 가장 우선순위가 높은 먹이를 하나만 찾는다.
     */
    static Target find() {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(sharkX, sharkY));

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1); 
        }
        dist[sharkX][sharkY] = 0;

        Target target = null;
        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Position cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            int d = dist[x][y];

            if (d >= min) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nd = d + 1;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N ||
                    dist[nx][ny] != -1 || map[nx][ny] > size) {
                    continue;
                }

                if (map[nx][ny] > 0 && map[nx][ny] < size) {
                    if (nd <= min) {
                        min = nd;
                        if (target == null) {
                            target = new Target(nx, ny, nd);
                        } else {
                            if (nx < target.x) {
                                target = new Target(nx, ny, nd);
                            } else if (nx == target.x && ny < target.y) {
                                target = new Target(nx, ny, nd);
                            }
                        }
                    }
                }

                dist[nx][ny] = nd;
                q.add(new Position(nx, ny)); // Position 객체 사용
            }
        }

        return target;
    }
}