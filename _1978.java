package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num != 1 && isPrime(num)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isPrime(int x) {
        for(int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) {
                return false;
            }
        }

        return true;
    }
}