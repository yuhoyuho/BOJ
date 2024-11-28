package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int max = 1000;
        int min = 0;
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < L; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num == n) {
                count++;
                break;
            }

            if(num < n && min < num) {
                min = num;
            }
            if(num > n && max > num) {
                max = num;
            }
        }

        int result = 0;

        if(count == 1) {
            System.out.println(0);
        } else {
            for(int i = min + 1; i <= n; i++) {
                for(int j = n; j < max; j++) {
                    result++;
                }
            }
            System.out.println(result - 1);
        }
    }
}