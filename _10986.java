package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long result = 0;
        long[] sum = new long[n + 1];
        long[] cnt = new long[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % m;

            if(sum[i] == 0) {
                result++;
            }

            cnt[(int)sum[i]]++;
        }

        for(int i = 0; i < m; i++) {
            if(cnt[i] > 1) {
                result += (cnt[i] * (cnt[i] - 1) / 2);
            }
        }

        System.out.println(result);
    }
}
