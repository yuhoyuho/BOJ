package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9251 {
    static Integer[][] dp;
    static char[] str1;
    static char[] str2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new Integer[str1.length + 1][str2.length + 1];

        System.out.println(dp(str1.length - 1, str2.length - 1));
    }

    static int dp(int x, int y) {
        if(x == -1 || y == -1) {
            return 0;
        }

        if(dp[x][y] == null) {
            dp[x][y] = 0;

            if(str1[x] == str2[y]) {
                dp[x][y] = dp(x - 1, y - 1) + 1;
            }
            else {
                dp[x][y] = Math.max(dp(x - 1, y), dp(x, y - 1));
            }
        }

        return dp[x][y];
    }
}