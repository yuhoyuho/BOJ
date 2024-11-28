package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] rank = new int[P];

        if(N > 0) {
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(rank);

        if(P == N && rank[0] >= score) {
            System.out.println(-1);
            return;
        }

        int count = 1;

        for(int i = 0; i < rank.length; i++) {
            if(rank[i] > score) {
                count ++;
            }
        }
        System.out.println(count);
    }
}