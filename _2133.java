package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n % 2 != 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for(int i = 4; i < n + 1; i+= 2) {
            dp[i] = dp[i - 2] * 3;

            for(int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[n]);
    }
}