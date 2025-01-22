package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579 {
    static Integer[] dp;
    static int[] stair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1];
        stair = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = stair[1];

        if(n > 1) {
            dp[2] = stair[1] + stair[2];
        }

        System.out.println(recur(n));

    }

    static int recur(int n) {
        if(dp[n] == null) {
            dp[n] = Math.max(recur(n - 2), recur(n - 3) + stair[n - 1]) + stair[n];
        }
        return dp[n];
    }
}