package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        long max = 0;

        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        max++;

        long min = 0;
        long half = 0;

        while(min < max) {
            half = (max + min) / 2;

            long count = 0;

            for(int i = 0; i < arr.length; i++) {
                count += (arr[i] / half);
            }

            if(count < N) {
                max = half;
            }
            else {
                min = half + 1;
            }
        }
        System.out.println(min - 1);
    }
}