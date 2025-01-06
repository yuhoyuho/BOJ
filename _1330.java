package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        compareTo(A, B);
    }
    static void compareTo(int x, int y) {
        if(x > y) {
            System.out.println(">");
        }
        else if(x < y) {
            System.out.println("<");
        }
        else {
            System.out.println("==");
        }
    }
}