package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String f = st.nextToken();
        String s = st.nextToken();

        StringBuilder sb1 = new StringBuilder(f).reverse();
        StringBuilder sb2 = new StringBuilder(s).reverse();

        String result = Integer.parseInt(sb1.toString()) > Integer.parseInt(sb2.toString()) ? sb1.toString() : sb2.toString();
        System.out.println(result);
    }
}
