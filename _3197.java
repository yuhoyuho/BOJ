package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3197 {
    static int R, C;
    static char[][] map;
    static boolean[][] swanVisited;
    static int[] swanPos = new int[4]; // swan1(x,y), swan2(x,y)
    static Queue<Point> swanQ = new LinkedList<>();
    static Queue<Point> nextQ = new LinkedList<>();
    static Queue<Point> waterQ = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        swanVisited = new boolean[R][C];
        int idx = 0;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'L') {
                    swanPos[idx++] = i;
                    swanPos[idx++] = j;
                    waterQ.add(new Point(i, j)); // 백조 위치도 물이므로 waterQ에 추가
                } else if (map[i][j] == '.') {
                    waterQ.add(new Point(i, j));
                }
            }
        }

        // 한 마리 백조를 기준으로 탐색 시작
        swanQ.add(new Point(swanPos[0], swanPos[1]));
        swanVisited[swanPos[0]][swanPos[1]] = true;

        int days = 0;
        while (true) {
            if (moveSwan()) { // 백조가 만났는지 확인
                break;
            }
            meltIce(); // 얼음 녹이기
            days++;

            // 다음 날 탐색을 위해 큐 교체
            swanQ = nextQ;
            nextQ = new LinkedList<>();
        }
        System.out.println(days);
    }

    // 백조 이동 BFS: 현재 swanQ를 탐색하며 다른 백조를 찾거나, 다음 탐색 지점(nextQ)을 찾음
    static boolean moveSwan() {
        while (!swanQ.isEmpty()) {
            Point current = swanQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C || swanVisited[nx][ny]) {
                    continue;
                }

                swanVisited[nx][ny] = true;
                if (nx == swanPos[2] && ny == swanPos[3]) { // 다른 백조를 만남
                    return true;
                } else if (map[nx][ny] == 'X') { // 얼음을 만남
                    nextQ.add(new Point(nx, ny)); // 다음 날 탐색할 큐에 추가
                } else { // 물을 만남
                    swanQ.add(new Point(nx, ny)); // 즉시 탐색할 큐에 추가
                }
            }
        }
        return false;
    }

    // 물 확장 BFS: 현재 waterQ를 기준으로 인접한 얼음을 녹임
    static void meltIce() {
        int size = waterQ.size();
        for (int i = 0; i < size; i++) {
            Point current = waterQ.poll();

            for (int j = 0; j < 4; j++) {
                int nx = current.x + dx[j];
                int ny = current.y + dy[j];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }

                if (map[nx][ny] == 'X') {
                    map[nx][ny] = '.';
                    waterQ.add(new Point(nx, ny)); // 새로 녹은 물도 다음 날 확장을 위해 추가
                }
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}