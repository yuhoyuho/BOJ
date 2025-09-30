package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                sum[i] = Math.max(sum[i], sum[i - j] + card[j]);
            }
        }
        System.out.println(sum[n]);
    }
}
