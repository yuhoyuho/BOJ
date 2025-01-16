package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12100 {
    static int N;
    static int[][] map;
    static int result; // 결과값 저장
    static final int up = 0, down = 1, left = 2, right = 3; // 상, 하, 좌, 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        result = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        play(0);
        System.out.println(result);
    }
    static void play(int cnt) {
        if(cnt == 5) { // 5번 실행 후, 최대값을 result에 저장
            max();
            return;
        }

        int[][] copy = new int[N][N];
        for(int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }

        for(int i = 0; i < 4; i++) {
            move(i);
            play(cnt + 1);

            for(int j = 0; j < N; j++) { // 백트래킹으로 map을 원래대로 복구
                map[j] = copy[j].clone();
            }
        }

    }
    static void move(int dir) { // 블록 움직임 제어
        switch (dir) {
            case up : // 위
                for(int i = 0; i < N; i++) {
                    int idx = 0;
                    int block = 0;

                    for(int j = 0; j < N; j++) {
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[idx - 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[idx][i] = block;
                                idx++;
                            }
                        }
                    }
                }
                break;

            case down : // 아래
                for(int i = 0; i < N; i++) {
                    int idx = N - 1;
                    int block = 0;

                    for(int j = N - 1; j >= 0; j--) {
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[idx + 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[idx][i] = block;
                                idx--;
                            }
                        }
                    }
                }
                break;

            case left : // 왼쪽
                for(int i = 0; i < N; i++) {
                    int idx = 0;
                    int block = 0;

                    for(int j = 0; j < N; j++) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][idx - 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][idx] = block;
                                idx++;
                            }
                        }
                    }
                }
                break;

            case right : // 오른쪽
                for(int i = 0; i < N; i++) {
                    int idx = N - 1;
                    int block = 0;

                    for(int j = N - 1; j >= 0; j--) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][idx + 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][idx] = block;
                                idx--;
                            }
                        }
                    }
                }
                break;
        }
    }
    static void max() { // 최대값을 result에 저장
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                result = Math.max(result, map[i][j]);
            }
        }
    }
}