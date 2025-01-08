package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11054 {
    static int[] arr;
    static Integer[] o_dp;
    static Integer[] r_dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());

        arr = new int[A];
        o_dp = new Integer[A];
        r_dp = new Integer[A];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < A; i++) {
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for(int i = 0; i < A; i++) {
            max = Math.max(max, o_dp[i] + r_dp[i]);
        }

        System.out.println(max - 1);
    }
    static int LIS (int N) {
        if(o_dp[N] == null) {
            o_dp[N] = 1;

            for(int i = N - 1; i >= 0; i--) {
                if(arr[N] > arr[i]) {
                    o_dp[N] = Math.max(o_dp[N], LIS(i) + 1);
                }
            }
        }
        return o_dp[N];
    }
    static int LDS(int N) {
        if(r_dp[N] == null) {
            r_dp[N] = 1;

            for(int i = N + 1; i < r_dp.length; i++) {
                if(arr[i] < arr[N]) {
                    r_dp[N] = Math.max(r_dp[N], LDS(i) + 1);
                }
            }
        }
        return r_dp[N];
    }
}