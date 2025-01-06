package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9020 {
    static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        getPrime();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int p = n / 2;
            int q = n / 2;

            while(true) {
                if(!prime[p] && !prime[q]) {
                    sb.append(p).append(' ').append(q).append('\n');
                    break;
                }
                p--;
                q++;
            }

        }
        System.out.println(sb);
    }

    static void getPrime() {
        prime[0] = prime[1] = true;

        for(int i = 2; i < prime.length; i++) {
            if(prime[i]) {
                continue;
            }
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}