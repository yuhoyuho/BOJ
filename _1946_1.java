package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1946_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] rank = new int[n][2];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int m = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                rank[i][0] = m;
                rank[i][1] = t;
            }

            Arrays.sort(rank, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int cnt = 1;
            int test = rank[0][1];
            for(int i = 1; i < n; i++) {
                if(rank[i][1] < test) {
                    cnt++;
                    test = rank[i][1];
                }
            }
            System.out.println(cnt);
        }
    }
}
