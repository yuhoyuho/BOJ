package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11053 {
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());

        arr = new int[A];
        dp = new Integer[A];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < A; i++) {
            LIS(i);
        }

        int max = dp[0];

        for(int i = 1; i < A; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
    private static int LIS(int N) {
        if(dp[N] == null) {
            dp[N] = 1;
            for(int i = N - 1; i >= 0; i--) {
                if(arr[i] < arr[N]) {
                    dp[N] = Math.max(dp[N], LIS(i) + 1);
                }
            }
        }
        return dp[N];
    }
}