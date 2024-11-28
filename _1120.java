package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1120 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int result = 50;

        for(int i = 0; i <= (B.length() - A.length()); i++) {
            int count = 0;

            for(int j = 0; j < A.length(); j++) {
                if(A.charAt(j) != B.charAt(j + i)) {
                    count++;
                }
            }
            result = Math.min(result, count);
        }
        System.out.println(result);
    }
}