package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1783 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int result = 0;

        if(n == 1) {
            result = 1;
        }
        else if(n == 2) {
            result = Math.min(4, (m + 1) / 2);
        }
        else {
            if(m >= 7) {
                result = m - 2;
            }
            else {
                result = Math.min(4, m);
            }
        }

        System.out.println(result);
    }
}