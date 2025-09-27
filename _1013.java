package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String vega = "(100+1+|01)+";

        while(T-- > 0) {
            String s = br.readLine();

            if(s.matches(vega)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
