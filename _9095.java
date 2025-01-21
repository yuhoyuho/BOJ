package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        dp = new int[12];
        dp();

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n] + "\n");
        }
        System.out.println(sb);
    }

    static void dp() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 12; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
    }
}