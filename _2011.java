package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int mod = 1000000;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for(int i = 1; i < dp.length; i++) {
            int cur = s.charAt(i - 1) - '0';

            if(cur >= 1 && cur <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= mod;
            }

            if(i == 1) {
                continue;
            }
            int prev = s.charAt(i - 2) - '0';

            if(prev == 0) {
                continue;
            }

            int x = cur + prev * 10;

            if(x >= 10 && x <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= mod;
            }
        }
        System.out.println(dp[s.length()]);
    }
}