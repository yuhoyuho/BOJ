package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2193 {
    static int n;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];

        System.out.println(dp(n));
    }

    static long dp(int n) {
        if(n == 1) {
            return 1;
        }
        else if(n == 2) {
            return 1;
        }
        else if(n == 3) {
            return 2;
        }
        else if(n == 4) {
            return 3;
        }

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;

        for(int i = 5; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
