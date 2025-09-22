package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15953 {

    static int[] first = {500, 300, 200, 50, 30, 10}; // 1, 3, 6, 10, 15, 21
    static int[] second = {512, 256, 128, 64, 32};

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result = 0;

            System.out.println(calc(a, b) * 10000);
        }
    }

    static int calc(int a, int b) {
        if(a == 1) {
            result += first[0];
        }
        else if(a > 1 && a <= 3) {
            result += first[1];
        }
        else if(a > 3 && a <= 6) {
            result += first[2];
        }
        else if(a > 6 && a <= 10) {
            result += first[3];
        }
        else if(a > 10 && a <= 15) {
            result += first[4];
        }
        else if(a > 15 && a <= 21) {
            result += first[5];
        }

        if(b == 1) {
            result += second[0];
        }
        else if(b > 1 && b <= 3) {
            result += second[1];
        }
        else if(b > 3 && b <= 7) {
            result += second[2];
        }
        else if(b > 7 && b <= 15) {
            result += second[3];
        }
        else if(b > 15 && b <= 31) {
            result +=  second[4];
        }

        return result;
    }
}
