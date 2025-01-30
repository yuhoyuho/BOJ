package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;

            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    result += gcd(arr[i], arr[j]);
                }
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

    static int gcd(int x, int y) {
        if(y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }
}