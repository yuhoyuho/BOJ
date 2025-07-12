package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17281 {
    static int n, result;
    static boolean[] runner;
    static boolean[] select;
    static int[][] player;
    static int[] lineUp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        player = new int[n][9];
        select = new boolean[9];
        lineUp = new int[9];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
        select[3] = true;
        lineUp[3] = 0;
        setPlayer(1);

        System.out.println(result);
    }

    static void init() {
        runner = new boolean[3];
    }

    static void setPlayer(int n) {
        if(n == 9) {
            play();
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(select[i]) {
                continue;
            }
            select[i] = true;
            lineUp[i] = n;
            setPlayer(n + 1);
            select[i] = false;
        }
    }

    static void play() {
        int score = 0;
        int idx = 0;

        for(int i = 0; i < n; i++) {
            int cnt = 0;
            init();

            outer : while(true) {
                for(int j = idx; j < 9; j++) {
                    int batter = player[i][lineUp[j]];

                    switch (batter) {
                        case 0 :
                            cnt++;
                            break;
                        case 1 :
                            if(runner[2]) {
                                score++;
                                runner[2] = false;
                            }

                            for(int k = 1; k >= 0; k--) {
                                if(runner[k]) {
                                    runner[k + 1] = true;
                                    runner[k] = false;
                                }
                            }

                            runner[0] = true;
                            break;
                        case 2 :
                            for(int k = 2; k >= 1; k--) {
                                if(runner[k]) {
                                    score++;
                                    runner[k] = false;
                                }
                            }

                            if(runner[0]) {
                                runner[2] = true;
                                runner[0] = false;
                            }

                            runner[1] = true;
                            break;
                        case 3 :
                            for(int k = 2; k >= 0; k--) {
                                if(runner[k]) {
                                    score++;
                                    runner[k] = false;
                                }
                            }
                            runner[2] = true;
                            break;
                        case 4 :
                            for(int k = 2; k >= 0; k--) {
                                if(runner[k]) {
                                    score++;
                                    runner[k] = false;
                                }
                            }
                            score++;
                    }

                    if(cnt == 3) {
                        idx = j + 1;
                        if(idx == 9) {
                            idx = 0;
                        }
                        break outer;
                    }
                }
            }
        }
        result = Math.max(result, score);
    }
}
