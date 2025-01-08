package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3190 {
    static int N, K, L;
    static int a = 2;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static HashMap<Integer, String> hMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // N * N -> map 의 크기
        K = Integer.parseInt(br.readLine()); // 사과의 개수

        map = new int[N][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;

            map[row][col] = 1;
        }

        L = Integer.parseInt(br.readLine());
        hMap = new HashMap<>();

        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();

            hMap.put(X, C);
        }
        move();
    }
    static void move() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int x = 0;
        int y = 0;
        int time = 0;

        while(true) {
            int nx = x + dx[a];
            int ny = y + dy[a];
            time++;

            // 벽에 부딪히는 경우
            if(nx > N - 1 || ny > N - 1 || nx < 0 || ny < 0) {
                break;
            }

            /* 몸통에 부딪히는 경우 -> 2차원 좌표를 1차원 좌표로 변환
            (N * N 배열에서 ny * N + nx => (2차원 좌표 -> 1차원 좌표로 관리 가능)
             */
            if(q.contains(ny * N + nx)) {
                break;
            }

            if(map[ny][nx] == 1) {
                map[ny][nx] = 0;
                q.add(ny * N + nx);
            }
            else {
                q.add(ny * N + nx);
                q.poll();
            }

            if(hMap.containsKey(time)) {
                String dir = hMap.get(time);

                if(dir.equals("D")) {
                    a -= 1;

                    if(a == -1) {
                        a = 3;
                    }
                }
                else {
                    a += 1;

                    if(a == 4) {
                        a = 0;
                    }
                }
            }
            x = nx;
            y = ny;
        }
        System.out.println(time);
    }
}