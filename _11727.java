package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n + 1];
        int mod = 10007;

        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % mod;
        }

        System.out.println(dp[n]);
    }
}