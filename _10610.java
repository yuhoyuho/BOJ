package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int[] num = new int[10];
        long total = 0;

        for(int i = 0; i < s.length(); i++) {
            int n = Integer.parseInt(String.valueOf(s.charAt(i)));
            num[n]++;
            total += n;
        }

        if(total % 3 != 0 || !s.contains("0")) {
            System.out.println(-1);
            return;
        }

        for(int i = 9; i >= 0; i--) {
            while(num[i] > 0) {
                sb.append(i);
                num[i]--;
            }
        }

        System.out.println(sb);
    }
}