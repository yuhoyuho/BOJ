package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _19238 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Taxi>[] start;
    static ArrayList<Taxi>[] end;

    static int[][] map;

    static int N, M, fuel;
    static boolean go = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        start = new ArrayList[M + 2];
        end = new ArrayList[M + 2];

        for(int i = 2; i <= M + 1; i++) {
            start[i] = new ArrayList<>();
            end[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int tx = Integer.parseInt(st.nextToken());
        int ty = Integer.parseInt(st.nextToken());

        for(int i = 2; i < M + 2; i++) {
            st = new StringTokenizer(br.readLine());

            int sx = Integer.parseInt(st.nextToken()); // start - x
            int sy = Integer.parseInt(st.nextToken()); // start - y
            int ex = Integer.parseInt(st.nextToken()); // end - x
            int ey = Integer.parseInt(st.nextToken()); // end - y

            map[sx][sy] = i;

            start[i].add(new Taxi(sx, sy)); // 출발지점 배열에 sx, sy를 추가
            end[i].add(new Taxi(ex, ey)); // 도착지점 배열에 ex, ey를 추가
        }

        while(M-- > 0) {
            int passengerNum = findP(tx, ty); // 가장 가까운 승객을 찾음

            if(!go || passengerNum == -1) { // 연료가 부족하거나 승객을 찾을 수 없는 경우
                System.out.println(-1);
                return;
            }

            int sx = start[passengerNum].get(0).x;
            int sy = start[passengerNum].get(0).y;
            int ex = end[passengerNum].get(0).x;
            int ey = end[passengerNum].get(0).y;

            move(sx, sy, ex, ey); // 이동
            if(!go) {
                System.out.println(-1);
                return;
            }

            // 택시의 현재 위치를 승객의 도착지로 초기화
            tx = end[passengerNum].get(0).x;
            ty = end[passengerNum].get(0).y;
        }
        System.out.println(fuel);
    }
    static int findP(int x, int y) {
        PriorityQueue<Taxi> pq = new PriorityQueue<>();
        pq.offer(new Taxi(x, y, 0));

        boolean[][] visited = new boolean[N + 1][N + 1];
        visited[x][y] = true;

        while(!pq.isEmpty()) {
            Taxi t = pq.poll();

            if(map[t.x][t.y] > 1) { // 승객을 만났다면
                fuel -= t.move;

                if(fuel < 0) {
                    go = false;
                    return -1;
                }

                int passengerNum = map[t.x][t.y];
                map[t.x][t.y] = 0;

                return passengerNum; // 승객 번호를 반환 (그 승객의 목적지를 찾기 위해)
            }

            for(int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if(!isInRange(nx, ny)) { // 유효한 범위인지 확인
                    continue;
                }
                if(!visited[nx][ny] && map[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    pq.offer(new Taxi(nx, ny, t.move + 1)); // 택시의 위치를 다시 큐에 넣음
                }
            }
        }
        return -1;
    }

    static void move(int x, int y, int destX, int destY) {
        PriorityQueue<Taxi> pq = new PriorityQueue<>();
        pq.offer(new Taxi(x, y, 0));

        boolean[][] visited = new boolean[N + 1][N + 1];
        visited[x][y] = true;

        while(!pq.isEmpty()) {
            Taxi t = pq.poll();

            if(t.x == destX && t.y == destY) {
                fuel -= t.move;

                if(fuel < 0) {
                    go = false;
                }

                fuel += (t.move * 2);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if(!isInRange(nx, ny)) {
                    continue;
                }
                if(!visited[nx][ny] && map[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    pq.offer(new Taxi(nx, ny, t.move + 1));
                }
            }
        }
        go = false; // 큐가 빌 때 까지 목적지에 가지 못하면 갈 수 없음을 의미
    }

    static boolean isInRange(int x, int y) {
        if(x < 1 || y < 1 || x > N || y > N) {
            return false;
        }
        return true;
    }

    static class Taxi implements Comparable<Taxi> {
        int x, y, move;

        public Taxi(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }

        public Taxi(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Taxi o) {
            if(move == o.move) {
                if(x == o.x) {
                    return y - o.y;
                }
                return x - o.x;
            }
            return move - o.move;
        }
    }
}