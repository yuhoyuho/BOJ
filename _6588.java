package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6588 {
    static int max = 1000000;
    static boolean[] prime = new boolean[max + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isPrime(prime);

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                break;
            }

            int[] result = new int[2];

            for(int i = n; i >= 0; i--) {
                if(prime[i] && prime[n - i]) {
                    result[0] = n - i;
                    result[1] = i;

                    break;
                }
            }
            if(result[0] == 0) {
                sb.append("Goldbach's conjecture is wrong." + "\n");
            }

            sb.append(n + " = " + result[0] + " + " + result[1] + "\n");
        }
        System.out.println(sb);
    }

    static boolean[] isPrime(boolean[] prime) {
        for(int i = 2; i < prime.length; i++) {
            int cnt = 0;

            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    cnt++;
                    break;
                }
            }

            if(cnt == 0) {
                prime[i] = true;
            }
        }

        return prime;
    }
}