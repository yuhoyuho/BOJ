package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] dp = new Integer[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < n + 1; i++) {
            dp[i] = i;

            for(int j = 1; Math.pow(j, 2) <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}