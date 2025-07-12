package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] rank = new int[n + 1];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int m = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                rank[m] = t;
            }

            int test = rank[1]; // 서류 1등의 면접 순위
            int cnt = 1;

            for(int i = 2; i <= n; i++) {
                if(rank[i] < test) {
                    test = rank[i];
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
