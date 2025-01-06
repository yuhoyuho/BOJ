package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[10];

        if(M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int bnt = Integer.parseInt(st.nextToken());
                check[bnt] = true;
            }
        }

        int ans = Math.abs(N - 100);

        for(int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);
            boolean isCheck = false;

            for(int j = 0; j < num.length(); j++) {
                if(check[num.charAt(j) - '0']) {
                    isCheck = true;
                    break;
                }
            }
            if(!isCheck) {
                int min = Math.abs(N - i) + num.length();
                ans = Math.min(ans, min);
            }
        }
        System.out.println(ans);
    }
}