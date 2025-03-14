package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074 {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        cnt = 0;

        find((int)Math.pow(2, N), r, c);
        System.out.println(cnt);
    }

    static void find(int N, int r, int c) {
        if(N == 1) return;

        if(r < N / 2 && c < N / 2) { // 제2사분면
            find(N / 2, r, c);
        }
        else if(r < N / 2 && c >= N / 2) { // 제1사분면
            cnt += N * N / 4;
            find(N / 2, r, c - N / 2);
        }
        else if(r >= N / 2 && c < N / 2) { // 제3사분면
            cnt += N * N / 2;
            find(N / 2, r - N / 2, c);
        }
        else { // 제4사분면
            cnt += (N * N / 4) * 3;
            find(N / 2, r - N / 2, c - N / 2);
        }
    }
}