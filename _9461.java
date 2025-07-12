package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461 {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
    }

    static long dp(int n) {
        if(dp[n] == 0) {
            for (int i = 6; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 5];
            }
        }

        return dp[n];
    }
}
