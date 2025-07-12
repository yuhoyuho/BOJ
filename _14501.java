package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] period = new int[n];
        int[] cost = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            period[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        for(int i = 0; i < n; i++) {
            if(i + period[i] <= n) {
                dp[i + period[i]] = Math.max(dp[i + period[i]], dp[i] + cost[i]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
        System.out.println(dp[n]);
    }
}
